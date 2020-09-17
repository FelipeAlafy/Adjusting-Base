package com.github.FelipeAlafy.adjustingbase.items;

import com.github.FelipeAlafy.adjustingbase.AdjustingBase;
import com.github.FelipeAlafy.adjustingbase.util.RegistryHandler;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemSieve extends Item {
    public ItemSieve() {
        super(new Item.Properties()
        .group(AdjustingBase.TAB)
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
