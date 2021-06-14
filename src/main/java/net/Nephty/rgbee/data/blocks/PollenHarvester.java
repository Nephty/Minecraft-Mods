package net.Nephty.rgbee.data.blocks;

import net.Nephty.rgbee.setup.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.inventory.container.Container;
import net.minecraft.item.*;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.ArrayList;

public class PollenHarvester extends ShearsItem {
    // TODO : allow player to retrieve pollen through crafting
    // TODO : make the item stack at 1 max
    public static final int MAX_POLLEN = 128;
    int pollenStack = 0;

    public PollenHarvester(Properties p_i48471_1_) {
        super(p_i48471_1_);
        this.setDamage(new ItemStack(this), 2);
    }

    public PollenHarvester(Properties p_i48471_1_, int pollenStack) {
        super(p_i48471_1_);
        this.pollenStack = pollenStack;
    }

    @Override
    public boolean mineBlock(ItemStack itemStack, World world, BlockState blockState, BlockPos blockPos, LivingEntity livingEntity) {
        itemStack.hurtAndBreak(1, livingEntity, (var) -> {
            var.broadcastBreakEvent(EquipmentSlotType.MAINHAND);
        });
        return true;
    }

    @Override
    public ActionResultType interactLivingEntity(ItemStack stack, net.minecraft.entity.player.PlayerEntity playerIn, LivingEntity entity, net.minecraft.util.Hand hand) {
        return ActionResultType.PASS;
    }

    @Override
    public ActionResult<ItemStack> use(World world, PlayerEntity playerEntity, Hand hand) {
        ItemStack itemInHand = playerEntity.getItemInHand(hand);
        if (world.isClientSide) {
            return ActionResult.success(itemInHand);
        }
        PollenHarvester harvesterInHand = ((PollenHarvester) (itemInHand.getItem()));
        int freeSlots = playerEntity.inventory.getFreeSlot();
        int freeSpace = freeSlots * 64;
        int pollenQuantity = harvesterInHand.pollenStack;

        if (playerEntity.isCrouching()) {

            // If we need to extract the pollen from the harvester
            if (!(pollenQuantity == 0 && playerEntity.inventory.contains(new ItemStack(ModItems.POLLEN::get)))) {
                if (freeSlots != -1) {
                    ItemStack result;
                    if (freeSpace == 64) {
                        if (harvesterInHand.pollenStack <= 64) {
                            result = new ItemStack(ModItems.POLLEN::get, harvesterInHand.pollenStack);
                            playerEntity.inventory.add(result);
                            harvesterInHand.pollenStack = 0;
                        } else {
                            result = new ItemStack(ModItems.POLLEN::get, 64);
                            playerEntity.inventory.add(result);
                            harvesterInHand.pollenStack -= 64;
                        }
                    } else {
                        if (harvesterInHand.pollenStack > 64) {
                            result = new ItemStack(ModItems.POLLEN::get, 64);
                            playerEntity.inventory.add(result);
                            harvesterInHand.pollenStack -= 64;
                        }
                        result = new ItemStack(ModItems.POLLEN::get, harvesterInHand.pollenStack);
                        playerEntity.inventory.add(result);
                        harvesterInHand.pollenStack = 0;
                    }
                    return ActionResult.consume(itemInHand);
                }

            // If we need to take the pollen inside the harvester
            } else {
                ArrayList<ItemStack> toRemove = new ArrayList<>();
                ArrayList<ItemStack> newStacks = new ArrayList<>();
                for (ItemStack itemStack : playerEntity.inventory.items) {
                    if (itemStack.getItem().equals(ModItems.POLLEN.get())) {
                        if (itemStack.getCount() + harvesterInHand.pollenStack <= MAX_POLLEN) {
                            // add it all to the harvester
                            harvesterInHand.pollenStack += itemStack.getCount();
                            toRemove.add(itemStack);
                        } else if (harvesterInHand.pollenStack <= MAX_POLLEN) {
                            // add max - pollenstack
                            int toAdd = MAX_POLLEN - harvesterInHand.pollenStack;
                            if (toAdd + harvesterInHand.pollenStack >= 128) {
                                System.out.println("Too many pollen in the harvester. Please report this error on the GitHub page.");
                            }
                            harvesterInHand.pollenStack += toAdd;
                            ItemStack newStack = new ItemStack(ModItems.POLLEN::get, itemStack.getCount() - toAdd);
                            newStacks.add(newStack);
                            toRemove.add(itemStack);
                        }
                    }
                }
                for (ItemStack itemStack : toRemove) {
                    playerEntity.inventory.removeItem(itemStack);
                }
                for (ItemStack itemStack : newStacks) {
                    playerEntity.inventory.add(itemStack);
                }
            }
        }
        return ActionResult.fail(itemInHand);
    }
}
