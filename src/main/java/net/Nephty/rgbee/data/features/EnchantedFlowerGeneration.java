package net.Nephty.rgbee.data.features;

import net.Nephty.rgbee.Rgbee;
import net.Nephty.rgbee.setup.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.blockplacer.SimpleBlockPlacer;
import net.minecraft.world.gen.blockstateprovider.WeightedBlockStateProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class EnchantedFlowerGeneration {
    public static final BlockClusterFeatureConfig ENCHANTED_DEFAULT_FLOWER_CONFIG = (new BlockClusterFeatureConfig.Builder((new WeightedBlockStateProvider()).add(ModBlocks.ENCHANTED_FLOWER.get().defaultBlockState(), 2), SimpleBlockPlacer.INSTANCE)).tries(64).build();

    public static final ConfiguredFeature<?, ?> ENCHANTED_FLOWER_DEFAULT = register("enchanted_flower_default", Feature.FLOWER.configured(ENCHANTED_DEFAULT_FLOWER_CONFIG).decorated(Features.Placements.ADD_32).decorated(Features.Placements.HEIGHTMAP_SQUARE).count(2));

    private static <FC extends IFeatureConfig> ConfiguredFeature<FC, ?> register(String p_243968_0_, ConfiguredFeature<FC, ?> p_243968_1_) {
        return Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, p_243968_0_, p_243968_1_);
    }

    public static void addFlowers(final BiomeLoadingEvent event) {
        addFlower(event);
    }

    private static void addFlower(final BiomeLoadingEvent event) {
        event.getGeneration().addFeature(GenerationStage.Decoration.TOP_LAYER_MODIFICATION, ENCHANTED_FLOWER_DEFAULT);
    }
}
