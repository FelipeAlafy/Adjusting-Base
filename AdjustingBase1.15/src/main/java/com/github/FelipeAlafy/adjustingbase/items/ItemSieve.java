package com.github.FelipeAlafy.adjustingbase.items;

import com.github.FelipeAlafy.adjustingbase.AdjustingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemSieve extends Item {
    public ItemSieve() {
        super(new Item.Properties()
        .group(AdjustingBase.TAB).maxStackSize(1)
        .setNoRepair());
    }

    @Override
    public boolean hasContainerItem(ItemStack stack){
        return true;
    }

    @Override
    public ItemStack getContainerItem(ItemStack itemStack) {
        final ItemStack copy = itemStack.copy();
        return copy;
    }
}
