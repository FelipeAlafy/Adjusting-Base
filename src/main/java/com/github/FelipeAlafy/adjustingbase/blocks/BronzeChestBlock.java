package com.github.FelipeAlafy.adjustingbase.blocks;

import com.github.FelipeAlafy.adjustingbase.tileentity.BronzeChestTileEntity;
import com.github.FelipeAlafy.adjustingbase.util.TileEntityTypes;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.tileentity.ChestTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.network.NetworkHooks;

public class BronzeChestBlock extends Block {
    public BronzeChestBlock() {
        super(Block.Properties.create(Material.WOOD)
        .sound(SoundType.WOOD)
        .hardnessAndResistance(1.0F, 1.0F)
        .harvestLevel(0)
        .harvestTool(ToolType.AXE)
        .setRequiresTool());
    }

    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }

    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return TileEntityTypes.BRONZE_CHEST.get().create();
    }

    @Override
    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        if(!worldIn.isRemote){
            TileEntity tile = worldIn.getTileEntity(pos);
            if (tile instanceof ChestTileEntity){
                NetworkHooks.openGui((ServerPlayerEntity) player, (ChestTileEntity) tile, pos);
                return ActionResultType.SUCCESS;
            }
        }
        return ActionResultType.FAIL;
    }

    @Override
    public void onReplaced(BlockState state, World worldIn, BlockPos pos, BlockState newState, boolean isMoving) {
        if(state.getBlock() != newState.getBlock()){
            TileEntity te = worldIn.getTileEntity(pos);
            if(te instanceof BronzeChestTileEntity){
                InventoryHelper.dropItems(worldIn, pos, ((BronzeChestTileEntity) te).getItems());
            }
        }
    }
}
