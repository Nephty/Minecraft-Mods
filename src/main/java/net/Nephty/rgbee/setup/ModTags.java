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
        public static final ITag.INamedTag<Block> STORAGE_BLOCKS_ENCHANTED_FLOWER = forge("storage_blocks/enchanted_flower");

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
        public static final ITag.INamedTag<Item> STORAGE_BLOCKS_ENCHANTED_FLOWER = forge("storage_blocks/enchanted_flower");

        private static ITag.INamedTag<Item> forge(String path) {
            return ItemTags.createOptional(new ResourceLocation("forge", path));
        }

        private static ITag.INamedTag<Item> mod(String path) {
            return ItemTags.createOptional(new ResourceLocation(Rgbee.MOD_ID, path));
        }
    }
}
