package com.github.FelipeAlafy.adjustingbase.util;

import com.github.FelipeAlafy.adjustingbase.AdjustingBase;
import net.minecraft.client.tutorial.Tutorial;
import net.minecraft.inventory.container.ContainerType;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ContainerTypes {
    public static final DeferredRegister<ContainerType<?>> CONTAINER_TYPES = DeferredRegister.create(ForgeRegistries.CONTAINERS, AdjustingBase.MOD_ID);
    public static final RegistryObject<ContainerType<BronzeChestConatainer>> BRONZE_CHEST = CONTAINER_TYPES.register("Bronze Chest", () ->
            IForgeContainerType.create(BronzeChestConatiner::new));
}