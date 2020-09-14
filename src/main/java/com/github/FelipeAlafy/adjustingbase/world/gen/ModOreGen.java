package com.github.FelipeAlafy.adjustingbase.world.gen;

import com.github.FelipeAlafy.adjustingbase.AdjustingBase;
import com.github.FelipeAlafy.adjustingbase.util.RegistryHandler;
import net.minecraft.block.BlockState;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.ConfiguredPlacement;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(modid = AdjustingBase.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModOreGen {
    public static void generatedOres(FMLLoadCompleteEvent event){
        for (Biome biome : ForgeRegistries.BIOMES){

            if(biome.getCategory() == Biome.Category.NETHER){

            }else if (biome.getCategory() == Biome.Category.THEEND) {

            } else {
                genOre(biome, 15, 8, 5, 25,
                        OreFeatureConfig.FillerBlockType.NATURAL_STONE, RegistryHandler.RUBY_ORE.get().getDefaultState(),
                        7);
            }
        }
    }

    public  static void genOre(Biome biome, int count, int bottomOffset, int topOffset, int max, OreFeatureConfig.FillerBlockType filler, BlockState defaultBlockstate, int size){
        CountRangeConfig range = new CountRangeConfig(count, bottomOffset, topOffset, max);
        OreFeatureConfig feature = new OreFeatureConfig(filler, defaultBlockstate, size);
        ConfiguredPlacement config = Placement.COUNT_RANGE.configure(range);
        biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(feature).withPlacement(config));
    }
}