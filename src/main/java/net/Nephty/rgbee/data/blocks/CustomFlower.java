package net.Nephty.rgbee.data.blocks;

import net.Nephty.rgbee.setup.ModItems;
import net.minecraft.block.BlockState;
import net.minecraft.block.FlowerBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.potion.Effect;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.World;

public class CustomFlower extends FlowerBlock {
    public CustomFlower(Effect p_i49984_1_, int p_i49984_2_, Properties p_i49984_3_) {
        super(p_i49984_1_, p_i49984_2_, p_i49984_3_);
    }

    @SuppressWarnings("deprecation")
    @Override
    public ActionResultType use(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockRayTraceResult rayTrace) {
        if (world.isClientSide) {
            return ActionResultType.SUCCESS;
        }
        // TODO : make a special item to gather pollen such as a small plank
        if (player.isHolding(ModItems.POLLEN_HARVESTER.get())) {
            // if the player has a free slot
            if (player.inventory.getFreeSlot() != -1) {
                // remove 1 durability of the player's shears if not in creative
                if (!player.isCreative()) {
                    player.inventory.getSelected().hurtAndBreak(1, player, (p_226874_1_) -> p_226874_1_.broadcastBreakEvent(hand));
                }
                // add a new pollen
                player.inventory.add(new ItemStack(ModItems.POLLEN::get));
            } else {
                // remove 1 durability of the player's shears if not in creative
                if (!player.isCreative()) {
                    player.inventory.getSelected().hurtAndBreak(1, player, (p_226874_1_) -> p_226874_1_.broadcastBreakEvent(hand));
                }
                // drop a pollen in the world
                popResource(world, pos, new ItemStack(ModItems.POLLEN::get));
            }
            return ActionResultType.SUCCESS;
        }
        return ActionResultType.PASS;
    }
}
