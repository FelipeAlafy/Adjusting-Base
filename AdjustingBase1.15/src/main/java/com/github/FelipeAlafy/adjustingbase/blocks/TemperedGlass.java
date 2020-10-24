package com.github.FelipeAlafy.adjustingbase.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class TemperedGlass extends Block {
    public TemperedGlass() {
        super(Block.Properties.create(Material.IRON)
                .hardnessAndResistance(3.0f, 3.0f)
                .sound(SoundType.GLASS)
                .harvestLevel(0)
                .harvestTool(ToolType.PICKAXE));
    }
}
