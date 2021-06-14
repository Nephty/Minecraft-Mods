package net.Nephty.rgbee.data.features;

import com.mojang.serialization.Codec;
import net.Nephty.rgbee.setup.ModBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.Util;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.blockstateprovider.BlockStateProvider;
import net.minecraft.world.gen.blockstateprovider.BlockStateProviderType;
import net.minecraft.world.gen.blockstateprovider.PlainFlowerBlockStateProvider;

import java.util.Random;

public class EnchantedPlainFlowerBlockStateProvider extends BlockStateProvider {
    public static final Codec<net.minecraft.world.gen.blockstateprovider.PlainFlowerBlockStateProvider> CODEC;
    public static final net.minecraft.world.gen.blockstateprovider.PlainFlowerBlockStateProvider INSTANCE = new net.minecraft.world.gen.blockstateprovider.PlainFlowerBlockStateProvider();
    private static final BlockState[] NOISE_FLOWERS = new BlockState[]{ModBlocks.ENCHANTED_FLOWER.get().defaultBlockState()};
    public static final BlockStateProviderType<PlainFlowerBlockStateProvider> ENCHANTED_PLAIN_FLOWER_PROVIDER = register("enchanted_plain_flower_provider", PlainFlowerBlockStateProvider.CODEC);


    protected BlockStateProviderType<?> type() {
        return ENCHANTED_PLAIN_FLOWER_PROVIDER;
    }

    private static <P extends BlockStateProvider> BlockStateProviderType<P> register(String p_236800_0_, Codec<P> p_236800_1_) {
        return Registry.register(Registry.BLOCKSTATE_PROVIDER_TYPES, p_236800_0_, new BlockStateProviderType<>(p_236800_1_));
    }

    public BlockState getState(Random p_225574_1_, BlockPos p_225574_2_) {
        double d0 = Biome.BIOME_INFO_NOISE.getValue((double)p_225574_2_.getX() / 200.0D, (double)p_225574_2_.getZ() / 200.0D, false);
        if (d0 < -0.8D) {
            return Util.getRandom(NOISE_FLOWERS, p_225574_1_);
        } else {
            return p_225574_1_.nextInt(3) > 0 ? Util.getRandom(NOISE_FLOWERS, p_225574_1_) : Blocks.DANDELION.defaultBlockState();
        }
    }

    static {
        CODEC = Codec.unit(() -> {
            return INSTANCE;
        });
    }
}