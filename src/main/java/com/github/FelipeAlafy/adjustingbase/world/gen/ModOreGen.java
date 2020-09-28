package com.github.FelipeAlafy.adjustingbase.world.gen;

import com.github.FelipeAlafy.adjustingbase.AdjustingBase;
import com.github.FelipeAlafy.adjustingbase.config.OregenConfig;
import com.github.FelipeAlafy.adjustingbase.util.RegistryHandler;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.pattern.BlockMatcher;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.ConfiguredPlacement;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(modid = AdjustingBase.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModOreGen {

    public static OreFeatureConfig.FillerBlockType END_STONE = OreFeatureConfig.FillerBlockType.create("END_STONE",
            "end_stone", new BlockMatcher(Blocks.END_STONE));

    @SubscribeEvent
    public static void generateOres(FMLLoadCompleteEvent event) {
        for (Biome biome : ForgeRegistries.BIOMES) {
            if (biome.getCategory() == Biome.Category.NETHER) {
                //Nether

            } else if (biome.getCategory() == Biome.Category.THEEND) {
                //The End

            } else {
                //Overword
                genOre(biome, 4, 8, 5, 30, OreFeatureConfig.FillerBlockType.NATURAL_STONE, RegistryHandler.RUBY_ORE.get().getDefaultState(), 3, OregenConfig.gen_ruby.get());
                genOre(biome, 12, 10, 5, 60, OreFeatureConfig.FillerBlockType.NATURAL_STONE, RegistryHandler.COPPER_ORE.get().getDefaultState(), 7,OregenConfig.gen_copper.get());
                genOre(biome, 12, 10, 5, 55, OreFeatureConfig.FillerBlockType.NATURAL_STONE, RegistryHandler.TIN_ORE.get().getDefaultState(), 7, OregenConfig.gen_tin.get());
                genOre(biome, 8, 7, 5, 50, OreFeatureConfig.FillerBlockType.NATURAL_STONE, RegistryHandler.SILVER_ORE.get().getDefaultState(), 4, OregenConfig.gen_silver.get());
                genOre(biome, 8, 25, 1, 60, OreFeatureConfig.FillerBlockType.NATURAL_STONE, RegistryHandler.ALUMINUM_ORE.get().getDefaultState(), 8, OregenConfig.gen_aluminum.get());
            }
        }
    }

    private static void genOre(Biome biome, int count, int bottomOffset, int topOffset, int max, OreFeatureConfig.FillerBlockType filler, BlockState defaultBlockstate, int size, boolean gen) {
        if(gen){
            CountRangeConfig range = new CountRangeConfig(count, bottomOffset, topOffset, max);
            OreFeatureConfig feature = new OreFeatureConfig(filler, defaultBlockstate, size);
            ConfiguredPlacement config = Placement.COUNT_RANGE.configure(range);
            biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(feature).withPlacement(config));
        }
    }
}