package com.github.FelipeAlafy.adjustingbase.util;

import com.github.FelipeAlafy.adjustingbase.AdjustingBase;
import com.github.FelipeAlafy.adjustingbase.tileentity.BronzeChestTileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;


public class TileEntityTypes {
    public static final DeferredRegister<TileEntityType<?>> TILE_ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, AdjustingBase.MOD_ID);
    public static final RegistryObject<TileEntityType<BronzeChestTileEntity>> BRONZE_CHEST = TILE_ENTITY_TYPES.register("bronze_chest", () ->
            TileEntityType.Builder.create(BronzeChestTileEntity::new, BlockInitNew.BRONZE_CHEST.get()).build(null));
}
