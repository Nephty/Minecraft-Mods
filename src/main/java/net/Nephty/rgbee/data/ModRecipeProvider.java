package net.Nephty.rgbee.data;

import net.Nephty.rgbee.Rgbee;
import net.Nephty.rgbee.setup.ModBlocks;
import net.Nephty.rgbee.setup.ModItems;
import net.minecraft.data.*;
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

        ShapedRecipeBuilder.shaped(ModBlocks.POLLEN_BLOCK.get())
                .define('#', ModItems.POLLEN.get())
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .unlockedBy("has_item", has(ModItems.POLLEN.get()))
                .save(consumer);

        CookingRecipeBuilder.smelting(Ingredient.of(ModItems.POLLEN.get()), ModItems.LIQUID_POLLEN.get(), 0.7f, 200)
                .unlockedBy("has_item", has(ModItems.POLLEN.get()))
                .save(consumer, modId("pollen_smelting"));
    }

    private static ResourceLocation modId(String path) {
        return new ResourceLocation(Rgbee.MOD_ID, path);
    }
}
