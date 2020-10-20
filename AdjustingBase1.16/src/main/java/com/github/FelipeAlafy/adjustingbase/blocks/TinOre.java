package com.github.FelipeAlafy.adjustingbase.blocks;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.OreBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class TinOre extends OreBlock {
    public TinOre() {
        super(AbstractBlock.Properties.create(Material.IRON)
        .sound(SoundType.METAL)
        .hardnessAndResistance(3.5F,3.0F)
        .harvestLevel(1)
        .harvestTool(ToolType.PICKAXE)
        .setRequiresTool());
    }
}
