package net.Nephty.rgbee.setup;

import net.Nephty.rgbee.Rgbee;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ITag;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.ResourceLocation;

public class ModTags {
    public static final class Blocks {
        public static final ITag.INamedTag<Block> STORAGE_BLOCKS_POLLEN_BLOCK = forge("storage_blocks/pollen_block");
        public static final ITag.INamedTag<Block> DECORATION_BLOCKS_ENCHANTED_FLOWER = forge("decoration_blocks/enchanted_flower");

        private static ITag.INamedTag<Block> forge(String path) {
            return BlockTags.createOptional(new ResourceLocation("forge", path));
        }

        private static ITag.INamedTag<Block> mod(String path) {
            return BlockTags.createOptional(new ResourceLocation(Rgbee.MOD_ID, path));
        }
    }

    public static final class Items {
        public static final ITag.INamedTag<Item> STORAGE_BLOCKS_POLLEN_BLOCK = forge("storage_blocks/pollen_block");
        public static final ITag.INamedTag<Item> MATERIALS_LIQUID_POLLEN = forge("materials/liquid_pollen");
        public static final ITag.INamedTag<Item> MATERIALS_LIQUID_POLLEN_BOTTLE = forge("materials/liquid_pollen_bottle");
        public static final ITag.INamedTag<Item> DECORATION_BLOCKS_ENCHANTED_FLOWER = forge("decoration_blocks/enchanted_flower");
        public static final ITag.INamedTag<Item> TOOLS_POLLEN_HARVESTER = forge("tools/pollen_harvester");
        public static final ITag.INamedTag<Item> MISC_POLLEN = forge("miscellaneous/pollen");
        public static final ITag.INamedTag<Item> MISC_GREEN_POLLEN = forge("miscellaneous/green_pollen");
        public static final ITag.INamedTag<Item> MISC_RED_POLLEN = forge("miscellaneous/red_pollen");
        public static final ITag.INamedTag<Item> MISC_BLUE_POLLEN = forge("miscellaneous/blue_pollen");
        public static final ITag.INamedTag<Item> MISC_CYAN_POLLEN = forge("miscellaneous/cyan_pollen");
        public static final ITag.INamedTag<Item> MISC_MAGENTA_POLLEN = forge("miscellaneous/magenta_pollen");
        public static final ITag.INamedTag<Item> MISC_GREEN_WHEAT = forge("miscellaneous/green_wheat");
        public static final ITag.INamedTag<Item> MISC_RED_WHEAT = forge("miscellaneous/red_wheat");
        public static final ITag.INamedTag<Item> MISC_BLUE_WHEAT = forge("miscellaneous/blue_wheat");
        public static final ITag.INamedTag<Item> MISC_CYAN_WHEAT = forge("miscellaneous/cyan_wheat");
        public static final ITag.INamedTag<Item> MISC_MAGENTA_WHEAT = forge("miscellaneous/magenta_wheat");
        public static final ITag.INamedTag<Item> MISC_GREEN_COOKIE = forge("miscellaneous/green_cookie");
        public static final ITag.INamedTag<Item> MISC_RED_COOKIE = forge("miscellaneous/red_cookie");
        public static final ITag.INamedTag<Item> MISC_BLUE_COOKIE = forge("miscellaneous/blue_cookie");
        public static final ITag.INamedTag<Item> MISC_CYAN_COOKIE = forge("miscellaneous/cyan_cookie");
        public static final ITag.INamedTag<Item> MISC_MAGENTA_COOKIE = forge("miscellaneous/magenta_cookie");

        private static ITag.INamedTag<Item> forge(String path) {
            return ItemTags.createOptional(new ResourceLocation("forge", path));
        }

        private static ITag.INamedTag<Item> mod(String path) {
            return ItemTags.createOptional(new ResourceLocation(Rgbee.MOD_ID, path));
        }
    }
}
