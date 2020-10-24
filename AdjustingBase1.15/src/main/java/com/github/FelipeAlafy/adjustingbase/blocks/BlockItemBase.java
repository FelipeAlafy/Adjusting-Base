package com.github.FelipeAlafy.adjustingbase.blocks;

import com.github.FelipeAlafy.adjustingbase.AdjustingBase;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;

public class BlockItemBase extends BlockItem {
    public BlockItemBase(Block block) {
        super(block, new Item.Properties().group(AdjustingBase.TAB));
    }
}
