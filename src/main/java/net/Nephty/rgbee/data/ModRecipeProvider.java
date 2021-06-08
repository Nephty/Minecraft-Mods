package net.Nephty.rgbee.data;

import net.Nephty.rgbee.Rgbee;
import net.Nephty.rgbee.setup.ModBlocks;
import net.Nephty.rgbee.setup.ModItems;
import net.minecraft.data.*;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;

import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider {
    public ModRecipeProvider(DataGenerator p_i48262_1_) {
        super(p_i48262_1_);
    }

    @Override
    protected void buildShapelessRecipes(Consumer<IFinishedRecipe> consumer) {
        // Pollen block -> 9 Pollen
        ShapelessRecipeBuilder.shapeless(ModItems.POLLEN.get(), 9)
                .requires(ModBlocks.POLLEN_BLOCK.get())
                .unlockedBy("has_item", has(ModBlocks.POLLEN_BLOCK.get()))
                .save(consumer);

        // 9 Pollen -> 1 Pollen block
        ShapedRecipeBuilder.shaped(ModBlocks.POLLEN_BLOCK.get())
                .define('#', ModItems.POLLEN.get())
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .unlockedBy("has_item", has(ModItems.POLLEN.get()))
                .save(consumer);

        // 1 Pollen + 1 Bottle -> 1 Liquid pollen bottle
        ShapelessRecipeBuilder.shapeless(ModItems.LIQUID_POLLEN_BOTTLE.get(), 1)
                .requires(ModItems.LIQUID_POLLEN.get()).requires(Items.GLASS_BOTTLE)
                .unlockedBy("has_item", has(ModItems.LIQUID_POLLEN.get()))
                .save(consumer);

        // 1 Pollen -> 1 Liquid Pollen
        CookingRecipeBuilder.smelting(Ingredient.of(ModItems.POLLEN.get()), ModItems.LIQUID_POLLEN.get(), 0.7f, 200)
                .unlockedBy("has_item", has(ModItems.POLLEN.get()))
                .save(consumer, modId("pollen_smelting"));

        // 4 Slabs & 2 Iron Ingots -> 1 Pollen Harvester
        ShapedRecipeBuilder.shaped(ModItems.POLLEN_HARVESTER.get())
                .define('#', () -> Items.OAK_SLAB)
                .define('i', () -> Items.IRON_INGOT)
                .pattern("#i#")
                .pattern("#i#")
                .pattern("   ")
                .unlockedBy("has_item", has(Items.OAK_SLAB))
                .unlockedBy("has_item", has(Items.IRON_INGOT))
                .save(consumer);
    }

    private static ResourceLocation modId(String path) {
        return new ResourceLocation(Rgbee.MOD_ID, path);
    }
}
