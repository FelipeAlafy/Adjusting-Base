package com.github.FelipeAlafy.adjustingbase.items;

import com.github.FelipeAlafy.adjustingbase.AdjustingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemBailey extends Item {
    public ItemBailey() {
        super((new Item.Properties().maxStackSize(1).setNoRepair().group(AdjustingBase.TAB)));
    }

    @Override
    public boolean hasContainerItem(ItemStack itemStack){
        return true;
    }

    @Override
    public ItemStack getContainerItem(ItemStack itemStack){
        final ItemStack copy = itemStack.copy();
        return copy;
    }
}
