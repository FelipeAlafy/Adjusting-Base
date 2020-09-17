package com.github.FelipeAlafy.adjustingbase.items;

import com.github.FelipeAlafy.adjustingbase.AdjustingBase;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

public class ChupChup extends Item {

    public ChupChup() {
        super(new Item.Properties()
                .group(AdjustingBase.TAB)
                .food(new Food.Builder()
                        .hunger(20)
                        .saturation(1.6f)
                        .build())
        );
    }

    @Override
    public boolean hasContainerItem(ItemStack itemStack){
        return true;
    }

    @Override
    public ItemStack getContainerItem(ItemStack itemStack){
        return itemStack.copy();
    }
}
