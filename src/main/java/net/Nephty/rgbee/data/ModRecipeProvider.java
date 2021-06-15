package net.Nephty.rgbee.data;

import net.Nephty.rgbee.Rgbee;
import net.Nephty.rgbee.setup.ModBlocks;
import net.Nephty.rgbee.setup.ModItems;
import net.minecraft.data.*;
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
        ShapelessRecipeBuilder.shapeless(ModItems.POLLEN::get, 9)
                .requires(ModBlocks.POLLEN_BLOCK.get())
                .unlockedBy("has_item", has(ModBlocks.POLLEN_BLOCK.get()))
                .save(consumer);

        // 9 Pollen -> 1 Pollen block
        ShapedRecipeBuilder.shaped(ModBlocks.POLLEN_BLOCK.get())
                .define('#', ModItems.POLLEN::get)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .unlockedBy("has_item", has(ModItems.POLLEN::get))
                .save(consumer);



        // 1 Pollen + 1 Bottle -> 1 Liquid pollen bottle
        ShapelessRecipeBuilder.shapeless(ModItems.LIQUID_POLLEN_BOTTLE::get, 1)
                .requires(ModItems.LIQUID_POLLEN::get).requires(Items.GLASS_BOTTLE)
                .unlockedBy("has_item", has(ModItems.LIQUID_POLLEN::get))
                .save(consumer);

        // 1 Pollen -> 1 Liquid Pollen
        CookingRecipeBuilder.smelting(Ingredient.of(ModItems.POLLEN::get), ModItems.LIQUID_POLLEN::get, 0.7f, 200)
                .unlockedBy("has_item", has(ModItems.POLLEN::get))
                .save(consumer, modId("pollen_smelting"));



        // 4 Slabs & 2 Iron Ingots -> 1 Pollen Harvester
        ShapedRecipeBuilder.shaped(ModItems.POLLEN_HARVESTER::get)
                .define('#', () -> Items.OAK_SLAB)
                .define('i', () -> Items.IRON_INGOT)
                .pattern("#i#")
                .pattern("#i#")
                .pattern("   ")
                .unlockedBy("has_item", has(Items.IRON_INGOT))
                .save(consumer);



        // 8 pollen + 1 gold ingot -> 8 golden pollen
        ShapedRecipeBuilder.shaped(ModItems.GOLDEN_POLLEN::get, 8)
                .define('#', ModItems.POLLEN::get)
                .define('g', () -> Items.GOLD_INGOT)
                .pattern("###")
                .pattern("#g#")
                .pattern("###")
                .unlockedBy("has_item", has(ModItems.POLLEN::get))
                .save(consumer);

        // 8 pollen + 1 green dye -> 8 green pollen
        ShapedRecipeBuilder.shaped(ModItems.GREEN_POLLEN::get, 8)
                .define('#', ModItems.POLLEN::get)
                .define('o', Items.GREEN_DYE)
                .pattern("###")
                .pattern("#o#")
                .pattern("###")
                .unlockedBy("has_item", has(ModItems.POLLEN::get))
                .save(consumer);

        // 8 pollen + 1 red dye -> 8 red pollen
        ShapedRecipeBuilder.shaped(ModItems.RED_POLLEN::get, 8)
                .define('#', ModItems.POLLEN::get)
                .define('o', Items.RED_DYE)
                .pattern("###")
                .pattern("#o#")
                .pattern("###")
                .unlockedBy("has_item", has(ModItems.POLLEN::get))
                .save(consumer);

        // 8 pollen + 1 blue dye -> 8 blue pollen
        ShapedRecipeBuilder.shaped(ModItems.BLUE_POLLEN::get, 8)
                .define('#', ModItems.POLLEN::get)
                .define('o', Items.BLUE_DYE)
                .pattern("###")
                .pattern("#o#")
                .pattern("###")
                .unlockedBy("has_item", has(ModItems.POLLEN::get))
                .save(consumer);

        // 8 pollen + 1 cyan dye -> 8 cyan pollen
        ShapedRecipeBuilder.shaped(ModItems.CYAN_POLLEN::get, 8)
                .define('#', ModItems.POLLEN::get)
                .define('o', Items.CYAN_DYE)
                .pattern("###")
                .pattern("#o#")
                .pattern("###")
                .unlockedBy("has_item", has(ModItems.POLLEN::get))
                .save(consumer);

        // 8 pollen + 1 magenta dye -> 8 magenta pollen
        ShapedRecipeBuilder.shaped(ModItems.MAGENTA_POLLEN::get, 8)
                .define('#', ModItems.POLLEN::get)
                .define('o', Items.MAGENTA_DYE)
                .pattern("###")
                .pattern("#o#")
                .pattern("###")
                .unlockedBy("has_item", has(ModItems.POLLEN::get))
                .save(consumer);



        // 8 wheat + 1 green pollen -> 8 green wheat
        ShapedRecipeBuilder.shaped(ModItems.GREEN_WHEAT::get, 8)
                .define('#', Items.WHEAT)
                .define('o', ModItems.GREEN_POLLEN::get)
                .pattern("###")
                .pattern("#o#")
                .pattern("###")
                .unlockedBy("has_item", has(ModItems.POLLEN::get))
                .save(consumer);

        // 8 wheat + 1 red pollen -> 8 red wheat
        ShapedRecipeBuilder.shaped(ModItems.RED_WHEAT::get, 8)
                .define('#', Items.WHEAT)
                .define('o', ModItems.RED_POLLEN::get)
                .pattern("###")
                .pattern("#o#")
                .pattern("###")
                .unlockedBy("has_item", has(ModItems.POLLEN::get))
                .save(consumer);

        // 8 wheat + 1 blue pollen -> 8 blue wheat
        ShapedRecipeBuilder.shaped(ModItems.BLUE_WHEAT::get, 8)
                .define('#', Items.WHEAT)
                .define('o', ModItems.BLUE_POLLEN::get)
                .pattern("###")
                .pattern("#o#")
                .pattern("###")
                .unlockedBy("has_item", has(ModItems.POLLEN::get))
                .save(consumer);

        // 8 wheat + 1 cyan pollen -> 8 cyan wheat
        ShapedRecipeBuilder.shaped(ModItems.CYAN_WHEAT::get, 8)
                .define('#', Items.WHEAT)
                .define('o', ModItems.CYAN_POLLEN::get)
                .pattern("###")
                .pattern("#o#")
                .pattern("###")
                .unlockedBy("has_item", has(ModItems.POLLEN::get))
                .save(consumer);

        // 8 wheat + 1 magenta pollen -> 8 magenta wheat
        ShapedRecipeBuilder.shaped(ModItems.MAGENTA_WHEAT::get, 8)
                .define('#', Items.WHEAT)
                .define('o', ModItems.MAGENTA_POLLEN::get)
                .pattern("###")
                .pattern("#o#")
                .pattern("###")
                .unlockedBy("has_item", has(ModItems.POLLEN::get))
                .save(consumer);


        // 2 green wheat + 1 cocoa beans -> 8 green cookies
        ShapedRecipeBuilder.shaped(ModItems.GREEN_COOKIE::get, 8)
                .define('#', ModItems.GREEN_WHEAT::get)
                .define('o', ModItems.GREEN_POLLEN::get)
                .pattern("   ")
                .pattern("   ")
                .pattern("#o#")
                .unlockedBy("has_item", has(ModItems.POLLEN::get))
                .save(consumer);

        // 2 red wheat + 1 red pollen -> 8 red cookies
        ShapedRecipeBuilder.shaped(ModItems.RED_COOKIE::get, 8)
                .define('#', ModItems.RED_WHEAT::get)
                .define('o', ModItems.RED_POLLEN::get)
                .pattern("   ")
                .pattern("   ")
                .pattern("#o#")
                .unlockedBy("has_item", has(ModItems.POLLEN::get))
                .save(consumer);

        // 2 blue wheat + 1 blue pollen -> 8 blue cookies
        ShapedRecipeBuilder.shaped(ModItems.BLUE_COOKIE::get, 8)
                .define('#', ModItems.BLUE_WHEAT::get)
                .define('o', ModItems.BLUE_POLLEN::get)
                .pattern("   ")
                .pattern("   ")
                .pattern("#o#")
                .unlockedBy("has_item", has(ModItems.POLLEN::get))
                .save(consumer);

        // 2 cyan wheat + 1 cyan pollen -> 8 cyan cookies
        ShapedRecipeBuilder.shaped(ModItems.CYAN_COOKIE::get, 8)
                .define('#', ModItems.CYAN_WHEAT::get)
                .define('o', ModItems.CYAN_POLLEN::get)
                .pattern("   ")
                .pattern("   ")
                .pattern("#o#")
                .unlockedBy("has_item", has(ModItems.POLLEN::get))
                .save(consumer);

        // 2 magenta wheat + 1 magenta pollen -> 8 magenta cookies
        ShapedRecipeBuilder.shaped(ModItems.MAGENTA_COOKIE::get, 8)
                .define('#', ModItems.MAGENTA_WHEAT::get)
                .define('o', ModItems.MAGENTA_POLLEN::get)
                .pattern("   ")
                .pattern("   ")
                .pattern("#o#")
                .unlockedBy("has_item", has(ModItems.POLLEN::get))
                .save(consumer);
    }

    private static ResourceLocation modId(String path) {
        return new ResourceLocation(Rgbee.MOD_ID, path);
    }
}
