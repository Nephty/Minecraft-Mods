package net.Nephty.rgbee.data.blocks;

import net.Nephty.rgbee.setup.ModBlocks;
import net.Nephty.rgbee.setup.ModItems;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Effect;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;


public class CustomFlower extends FlowerBlock {
    private static double breakingThreshold = 0.125;

    public CustomFlower(Effect p_i49984_1_, int p_i49984_2_, Properties p_i49984_3_) {
        super(p_i49984_1_, p_i49984_2_, p_i49984_3_);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(CustomFlower::init);
    }

    @SuppressWarnings("deprecation")
    @Override
    public ActionResultType use(BlockState state, World world, BlockPos pos, PlayerEntity playerEntity, Hand hand, BlockRayTraceResult rayTrace) {
        if (world.isClientSide) {
            return ActionResultType.SUCCESS;
        }
        ItemStack itemInHand = playerEntity.getItemInHand(hand);
        PollenHarvester harvesterInHand = ((PollenHarvester) (itemInHand.getItem()));
        if (playerEntity.isHolding(ModItems.POLLEN_HARVESTER.get())) {
            // if pollen harvester has room
            if (harvesterInHand.pollenStack < PollenHarvester.MAX_POLLEN) {
                // remove 1 durability of the playerEntity's pollen harvester if not in creative
                if (!playerEntity.isCreative()) {
                    itemInHand.hurtAndBreak(1, playerEntity, (p_226874_1_) -> p_226874_1_.broadcastBreakEvent(hand));
                }
                // add a new pollen in pollen harvester
                harvesterInHand.pollenStack++;
                playerEntity.displayClientMessage(new StringTextComponent("This harvester contains " + harvesterInHand.pollenStack + " items."), true);
                // Random chance (1/5) to break the flower upon harvesting pollen
                boolean breaking = determineIfBreaking();
                if (breaking || breakingThreshold == 0.125 + 8 * 0.05) {
                    world.destroyBlock(pos, false);
                    breakingThreshold = 0.125;
                } else {
                    breakingThreshold += 0.05;
                }
            } else {
                // Show the inability to use the item if it's full
                playerEntity.displayClientMessage(new StringTextComponent("You cannot harvest pollen when the harvester is full."), true);
                return ActionResultType.FAIL;
            }
        }
        return ActionResultType.PASS;
    }

    @SubscribeEvent
    public static void init(FMLClientSetupEvent event) {
        RenderTypeLookup.setRenderLayer(ModBlocks.ENCHANTED_FLOWER.get(), RenderType.cutout());
    }

    public static boolean determineIfBreaking() {
        double value = ( ( (Math.pow(breakingThreshold, 2) / 225) + ( breakingThreshold / 40 ) ) *
                ( ( ( Math.pow(Math.cos(breakingThreshold), 4) / 1.5 ) + 0.8 ) ) ) * 20;
        double random = Math.random();
        return random <= value;
    }
}
