package net.Nephty.rgbee.data;

import net.Nephty.rgbee.Rgbee;
import net.Nephty.rgbee.setup.ModTags;
import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.ItemTagsProvider;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModItemTagsProvider extends ItemTagsProvider {
    public ModItemTagsProvider(DataGenerator dataGenerator, BlockTagsProvider blockTagProvider, ExistingFileHelper existingFileHelper) {
        super(dataGenerator, blockTagProvider, Rgbee.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags() {
        copy(ModTags.Blocks.STORAGE_BLOCKS_POLLEN_BLOCK, ModTags.Items.STORAGE_BLOCKS_POLLEN_BLOCK);
        copy(ModTags.Blocks.DECORATION_BLOCKS_ENCHANTED_FLOWER, ModTags.Items.DECORATION_BLOCKS_ENCHANTED_FLOWER);
        tag(ModTags.Items.MATERIALS_LIQUID_POLLEN).addTag(Tags.Items.SLIMEBALLS);
        tag(ModTags.Items.TOOLS_POLLEN_HARVESTER).addTag(Tags.Items.SHEARS);
        tag(ModTags.Items.MISC_POLLEN).addTag(Tags.Items.DUSTS);
        tag(ModTags.Items.MISC_GREEN_POLLEN).addTag(Tags.Items.DUSTS);
        tag(ModTags.Items.MISC_RED_POLLEN).addTag(Tags.Items.DUSTS);
        tag(ModTags.Items.MISC_BLUE_POLLEN).addTag(Tags.Items.DUSTS);
        tag(ModTags.Items.MISC_CYAN_POLLEN).addTag(Tags.Items.DUSTS);
        tag(ModTags.Items.MISC_MAGENTA_POLLEN).addTag(Tags.Items.DUSTS);
        tag(ModTags.Items.MISC_GREEN_WHEAT).addTag(Tags.Items.CROPS_WHEAT);
        tag(ModTags.Items.MISC_RED_WHEAT).addTag(Tags.Items.CROPS_WHEAT);
        tag(ModTags.Items.MISC_BLUE_WHEAT).addTag(Tags.Items.CROPS_WHEAT);
        tag(ModTags.Items.MISC_CYAN_WHEAT).addTag(Tags.Items.CROPS_WHEAT);
        tag(ModTags.Items.MISC_MAGENTA_WHEAT).addTag(Tags.Items.CROPS_WHEAT);
        // tag(ModTags.Items.MISC_GREEN_COOKIE).addTag(Tags.Items.CROPS_WHEAT);
        // tag(ModTags.Items.MISC_RED_COOKIE).addTag(Tags.Items.CROPS_WHEAT);
        // tag(ModTags.Items.MISC_BLUE_COOKIE).addTag(Tags.Items.CROPS_WHEAT);
        // tag(ModTags.Items.MISC_CYAN_COOKIE).addTag(Tags.Items.CROPS_WHEAT);
        // tag(ModTags.Items.MISC_MAGENTA_COOKIE).addTag(Tags.Items.CROPS_WHEAT);
    }
}
