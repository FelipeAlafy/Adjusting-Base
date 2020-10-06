package com.github.FelipeAlafy.adjustingbase.util;

import com.github.FelipeAlafy.adjustingbase.AdjustingBase;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class EntityTypes {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = new DeferredRegister<>(ForgeRegistries.ENTITIES,
            AdjustingBase.MOD_ID);

    public static final RegistryObject<EntityType<ChestEntity>> CHEST_ENTITY = ENTITY_TYPES
            .register("chest_entity",
                    () -> EntityType.Builder.<ChestEntity>create(ChestEntity::new, EntityClassification.CREATURE)
                            .size(0.9f, 1.3f)
                            .build(new ResourceLocation(AdjustingBase.MOD_ID, "chest_entity").toString()));
}
