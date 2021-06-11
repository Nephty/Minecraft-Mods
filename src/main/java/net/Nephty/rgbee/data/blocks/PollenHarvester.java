package net.Nephty.rgbee.data.blocks;

import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.*;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class PollenHarvester extends ShearsItem {
    // TODO : allow player to retrieve pollen through crafting
    final int MAX_POLLEN = 128;
    int pollenStack = 0;
    public PollenHarvester(Properties p_i48471_1_) {
        super(p_i48471_1_);
    }

    public PollenHarvester(Properties p_i48471_1_, int pollenStack) {
        super(p_i48471_1_);
        this.pollenStack = pollenStack;
    }

    @Override
    public boolean mineBlock(ItemStack itemStack, World world, BlockState blockState, BlockPos blockPos, LivingEntity livingEntity) {
        return true;
    }

    @Override
    public ActionResultType interactLivingEntity(ItemStack stack, net.minecraft.entity.player.PlayerEntity playerIn, LivingEntity entity, net.minecraft.util.Hand hand) {
        return ActionResultType.PASS;
    }
}
