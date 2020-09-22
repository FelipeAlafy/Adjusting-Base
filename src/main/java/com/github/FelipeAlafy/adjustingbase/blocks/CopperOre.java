package com.github.FelipeAlafy.adjustingbase.blocks;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.OreBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class CopperOre extends OreBlock {
    public CopperOre() {
        super(AbstractBlock.Properties.create(Material.IRON)
        .hardnessAndResistance(2.0F, 3.0F)
        .harvestTool(ToolType.PICKAXE)
        .harvestLevel(1)
        .setRequiresTool()
        .sound(SoundType.METAL));
    }
}
