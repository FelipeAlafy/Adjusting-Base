package com.github.FelipeAlafy.adjustingbase.items;

import com.github.FelipeAlafy.adjustingbase.AdjustingBase;
import net.minecraft.item.Food;
import net.minecraft.item.Item;

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
}
