package net.Nephty.rgbee.data.blocks;

import net.Nephty.rgbee.setup.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

public class PollenBlock extends Block {
    public PollenBlock(Properties p_i48440_1_) {
        super(p_i48440_1_);
        // FMLJavaModLoadingContext.get().getModEventBus().addListener(PollenBlock::init);
    }

    @SubscribeEvent
    public static void init(FMLClientSetupEvent event) {
        // TODO : find a better way to make the block look like honey block
        // Blocks.HONEY_BLOCK // reference
        RenderTypeLookup.setRenderLayer(ModBlocks.POLLEN_BLOCK.get(), RenderType.translucent());
    }
}
