package net.Nephty.rgbee.data;

import net.Nephty.rgbee.Rgbee;
import net.Nephty.rgbee.setup.ModBlocks;
import net.Nephty.rgbee.setup.ModTags;
import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModBlockTagsProvider extends BlockTagsProvider {
    public ModBlockTagsProvider(DataGenerator generatorIn, ExistingFileHelper existingFileHelper) {
        super(generatorIn, Rgbee.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags() {
        tag(ModTags.Blocks.STORAGE_BLOCKS_POLLEN_BLOCK).add(ModBlocks.POLLEN_BLOCK.get());
        tag(Tags.Blocks.DIRT).addTags(ModTags.Blocks.STORAGE_BLOCKS_POLLEN_BLOCK);
    }
}
