package net.Nephty.rgbee.data.blocks;

import net.Nephty.rgbee.setup.ModBlocks;
import net.Nephty.rgbee.setup.ModItems;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.FlowerBlock;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.potion.Effect;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;


public class CustomFlower extends FlowerBlock {
    public CustomFlower(Effect p_i49984_1_, int p_i49984_2_, Properties p_i49984_3_) {
        super(p_i49984_1_, p_i49984_2_, p_i49984_3_);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(CustomFlower::init);
    }

    @SuppressWarnings("deprecation")
    @Override
    public ActionResultType use(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockRayTraceResult rayTrace) {
        if (world.isClientSide) {
            return ActionResultType.SUCCESS;
        }
        if (player.isHolding(ModItems.POLLEN_HARVESTER.get())) {
            // if pollen harvester has room
            if (((PollenHarvester) player.inventory.getSelected().getItem()).pollenStack < ((PollenHarvester) player.inventory.getSelected().getItem()).MAX_POLLEN) {
                // if the player has a free slot
                if (player.inventory.getFreeSlot() != -1) {
                    // remove 1 durability of the player's shears if not in creative
                    if (!player.isCreative()) {
                        player.inventory.getSelected().hurtAndBreak(1, player, (p_226874_1_) -> p_226874_1_.broadcastBreakEvent(hand));
                    }
                    // add a new pollen in pollen harvester
                    ((PollenHarvester) player.inventory.getSelected().getItem()).pollenStack++;
                    System.out.println(((PollenHarvester) player.inventory.getSelected().getItem()).pollenStack);
                }
            } else {
                // TODO : display info message that pollen harvester is full
                return ActionResultType.FAIL;
            }
        }
        return ActionResultType.PASS;
    }

    @SubscribeEvent
    public static void init(FMLClientSetupEvent event) {
        RenderTypeLookup.setRenderLayer(ModBlocks.ENCHANTED_FLOWER.get(), RenderType.cutout());
    }
}
