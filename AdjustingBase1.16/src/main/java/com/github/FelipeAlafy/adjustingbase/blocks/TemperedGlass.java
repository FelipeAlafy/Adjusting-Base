package com.github.FelipeAlafy.adjustingbase.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

import java.util.List;

public class TemperedGlass extends Block {
    public TemperedGlass() {
        super(net.minecraft.block.Block.Properties.create(Material.IRON)
                .hardnessAndResistance(3.0f, 3.0f)
                .sound(SoundType.GLASS)
                .setRequiresTool()
                .harvestLevel(0)
                .harvestTool(ToolType.PICKAXE));
    }
}
