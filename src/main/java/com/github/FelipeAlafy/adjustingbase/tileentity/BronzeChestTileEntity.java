package com.github.FelipeAlafy.adjustingbase.tileentity;

import com.github.FelipeAlafy.adjustingbase.blocks.BronzeChestBlock;
import com.github.FelipeAlafy.adjustingbase.util.TileEntityTypes;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.inventory.container.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.LockableLootTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.Direction;
import net.minecraft.util.NonNullList;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.items.wrapper.InvWrapper;

import javax.annotation.Nonnull;

public class BronzeChestTileEntity extends LockableLootTileEntity {

    private NonNullList<ItemStack> chestcontents = NonNullList.withSize(36, ItemStack.EMPTY);
    protected int numPlayersUsing;
    private IItemHandlerModifiable items = createHandler();
    private LazyOptional <IItemHandlerModifiable> itemHander = LazyOptional.of(() -> items);

    public BronzeChestTileEntity(TileEntityType<?> typeIn) {
        super(typeIn);
    }

    public BronzeChestTileEntity() {
        this(TileEntityTypes.BRONZE_CHEST.get());
    }

    @Override
    public int getSizeInventory() {
        return 36;
    }

    public NonNullList<ItemStack> getItemHander() {
        return this.chestcontents;
    }

    @Override
    public void setItems(NonNullList<ItemStack> itemsIn) {
        this.chestcontents = itemsIn;
    }

    @Override
    protected ITextComponent getDefaultName(){
        return new TranslationTextComponent("container.bronze_chest")
    }

    @Override
    protected Container createMenu(int id, PlayerInventory player) {
        return new BronzeChestContainer(id, player, this);
    }

    @Override
    public CompoundNBT write(CompoundNBT compound) {
        super.write(compound);
        if(!this.checkLootAndWrite(compound)){
            ItemStackHelper.saveAllItems(compound, this.chestcontents);
        }
        return compound;
    }

    @Override
    public void read(BlockState stateIn, CompoundNBT compound) {
        super.read(stateIn, compound);
        this.chestcontents = NonNullList.withSize(this.getSizeInventory(), ItemStack.EMPTY);
        if(!this.checkLootAndRead(compound)){
            ItemStackHelper.loadAllItems(compound, this.chestcontents);
        }
    }

    private void playSound(SoundEvent sound){
        double dx = (double) this.pos.getX() + 0.5D;
        double dy = (double) this.pos.getY() + 0.5D;
        double dz = (double) this.pos.getZ() + 0.5D;
        this.world.playSound((PlayerEntity) null, dx, dy, dz, sound, SoundCategory.BLOCKS, 0.5f,
                this.world.rand.nextFloat() * 0.1f + 0.9f);
    }

    @Override
    public boolean receiveClientEvent(int id, int type) {
        if(id == 1){
            this.numPlayersUsing = type;
            return true;
        } else {
            return super.receiveClientEvent(id, type);
        }
    }

    @Override
    public void openInventory(PlayerEntity player) {
        if(!player.isSpectator()){
            if(this.numPlayersUsing < 0){
                this.numPlayersUsing = 0;
            }
            ++this.numPlayersUsing;
            this.onOpenOrClose();
        }
    }

    @Override
    public void closeInventory(PlayerEntity player) {
        if(!player.isSpectator()){
            --this.numPlayersUsing;
            this.onOpenOrClose();
        }
    }

    protected void onOpenOrClose(){
        Block block = this.getBlockState().getBlock();
        if(block instanceof BronzeChestBlock){
            this.world.addBlockEvent(this.pos, block, 1, this.numPlayersUsing);
            this.world.notifyNeighborsOfStateChange(this.pos, block);
        }
    }

    public static int getNumPlayersUsing(IBlockReader reader, BlockPos pos) {
        BlockState blockState = reader.getBlockState(pos);
        if(blockState.hasTileEntity()){
            TileEntity tileEntity = reader.getTileEntity(pos);
            if(tileEntity instanceof BronzeChestTileEntity){
                return ((BronzeChestTileEntity)tileEntity).numPlayersUsing;
            }
        }
        return 0;
    }

    public static void swapContents(BronzeChestTileEntity bc, BronzeChestTileEntity otherBC){
        NonNullList<ItemStack> list = bc.getItems();
        bc.setItems(otherBC.getItems());
        otherBC.setItems(list);
    }

    @Override
    public void updateContainingBlockInfo() {
        super.updateContainingBlockInfo();
        if(this.itemHander != null){
            this.itemHander.invalidate();
            this.itemHander = null;
        }
    }

    @Override
    public <T> LazyOptional<T> getCapability(Capability<T> cap, @Nonnull Direction side) {
        if(cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY){
            return itemHander.cast();
        }
        return super.getCapability(cap, side);
    }

    private IItemHandlerModifiable createHandler(){
        return new InvWrapper(this);
    }

    @Override
    public void remove() {
        super.remove();
        if(itemHander != null){
            itemHander.invalidate();
        }
    }
}
