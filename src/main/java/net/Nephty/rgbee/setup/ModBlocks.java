package net.Nephty.rgbee.setup;

import net.Nephty.rgbee.data.blocks.CustomFlower;
import net.Nephty.rgbee.data.blocks.PollenBlock;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.potion.Effects;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final RegistryObject<Block> POLLEN_BLOCK = register("pollen_block",
            () -> new PollenBlock(AbstractBlock.Properties.of(Material.WOOL)
                    .sound(SoundType.HONEY_BLOCK)
                    .jumpFactor(0.8F)
                    .harvestTool(ToolType.HOE)
                    .strength(0.3F, 3)));
    public static final RegistryObject<Block> ENCHANTED_FLOWER = register("enchanted_flower", () ->
            new CustomFlower(Effects.HEAL, 1, AbstractBlock.Properties.of(Material.PLANT)
                    .noCollission()
                    .instabreak()
                    .noOcclusion()
                    .sound(SoundType.GRASS)));

    public static void register() {}

    private static <T extends Block> RegistryObject<T> registerNoItem(String name, Supplier<T> block) {
        return Registration.BLOCKS.register(name, block);
    }

    private static <T extends Block> RegistryObject<T> register(String name, Supplier<T> block) {
        RegistryObject<T> res = registerNoItem(name, block);
        Registration.ITEMS.register(name, () -> new BlockItem(res.get(), new Item.Properties().tab(ItemGroup.TAB_BUILDING_BLOCKS)));
        return res;
    }
}
