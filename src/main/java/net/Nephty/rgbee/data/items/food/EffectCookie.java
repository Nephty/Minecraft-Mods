package net.Nephty.rgbee.data.items.food;

import net.Nephty.rgbee.data.colors.Color;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class EffectCookie extends Item {
    Color color;
    public EffectCookie(Properties p_i48487_1_, Color color) {
        super(p_i48487_1_);
        this.color = color;
    }

    @Override
    public ItemStack finishUsingItem(ItemStack itemStack, World world, LivingEntity playerEntity) {
        // duration in seconds, automatically converts it to ticks since effect duration is measured in ticks
        int duration;
        int effectID;
        int intensity;
        switch (color) {
            case GREEN:
                // Health boost 2 for 15 sec
                effectID = 21;
                duration = 15;
                intensity = 2;
                break;
            case RED:
                // Fire resistance 1 for 20 sec
                effectID = 12;
                duration = 20;
                intensity = 1;
                break;
            case BLUE:
                // Strength 2 for 10 seconds
                effectID = 5;
                duration = 10;
                intensity = 2;
                break;
            case CYAN:
                // Speed 3 for 10 seconds
                effectID = 1;
                duration = 10;
                intensity = 3;
                break;
            case MAGENTA:
                // Regeneration 3 for 4 sec : regenerates 3.5 hearts
                effectID = 10;
                duration = 4;
                intensity = 3;
                break;
            default:
                throw new IllegalStateException("Unexpected value : " + color);
        }
        playerEntity.addEffect(new EffectInstance(Effect.byId(effectID), 20*duration, intensity-1));
        return this.isEdible() ? playerEntity.eat(world, itemStack) : itemStack;
    }
    /*
    @Override
    public ActionResult<ItemStack> use(World world, PlayerEntity playerEntity, Hand hand) {
        if (this.isEdible()) {
            ItemStack itemstack = playerEntity.getItemInHand(hand);
            if (playerEntity.canEat(this.getFoodProperties().canAlwaysEat())) {
                playerEntity.startUsingItem(hand);
                return ActionResult.consume(itemstack);
            } else {
                return ActionResult.fail(itemstack);
            }
        } else {
            return ActionResult.pass(playerEntity.getItemInHand(hand));
        }
    }
     */
}
