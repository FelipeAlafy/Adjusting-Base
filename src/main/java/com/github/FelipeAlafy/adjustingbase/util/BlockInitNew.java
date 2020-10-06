package com.github.FelipeAlafy.adjustingbase.util;

import com.github.FelipeAlafy.adjustingbase.AdjustingBase;
import com.github.FelipeAlafy.adjustingbase.blocks.BronzeChestBlock;
import net.minecraft.block.Block;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockInitNew {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, AdjustingBase.MOD_ID);
    public static final RegistryObject<Block> BRONZE_CHEST = BLOCKS.register("bronze_chest", BronzeChestBlock::new);
}
