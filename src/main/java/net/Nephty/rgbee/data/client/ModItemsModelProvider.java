package net.Nephty.rgbee.data.client;

import net.Nephty.rgbee.Rgbee;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;

import javax.annotation.Nonnull;

public class ModItemsModelProvider extends ItemModelProvider {

    public ModItemsModelProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, Rgbee.MOD_ID, existingFileHelper);
    }

    /*
    @Nonnull
    @Override
    public String getName() {
        return super.getName();
    }
    */

    @Override
    protected void registerModels() {
        withExistingParent("pollen_block", modLoc("block/pollen_block"));

        ModelFile itemGenerated = getExistingFile(mcLoc("item/generated"));

        itemBuilder(itemGenerated, "pollen_block_item");
        itemBuilder(itemGenerated, "pollen");
        itemBuilder(itemGenerated, "liquid_pollen");
    }

    private ItemModelBuilder itemBuilder(ModelFile itemGenerated, String name) {
        return getBuilder(name).parent(itemGenerated).texture("layer0", "item/" + name);
    }
}
