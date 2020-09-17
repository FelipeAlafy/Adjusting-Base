package com.github.FelipeAlafy.adjustingbase.init;

import  com.github.FelipeAlafy.adjustingbase.AdjustingBase ;
import  com.github.FelipeAlafy.adjustingbase.blocks.RubyBlock ;
import  com.github.FelipeAlafy.adjustingbase.blocks.RubyOre ;
import  net.minecraft.block.Block ;
import  net.minecraftforge.fml.RegistryObject ;
import  net.minecraftforge.registries.DeferredRegister ;
import  net.minecraftforge.registries.ForgeRegistries ;

public class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, AdjustingBase.MOD_ID);

    // Blocks
    public static final RegistryObject<Block> RUBY_BLOCK = BLOCKS.register("ruby_block", RubyBlock::new);
    public static final RegistryObject<Block> RUBY_ORE = BLOCKS.register("ruby_ore", RubyOre::new);

}