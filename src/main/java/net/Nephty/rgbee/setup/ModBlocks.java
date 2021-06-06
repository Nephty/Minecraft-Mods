package net.Nephty.rgbee.setup;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final RegistryObject<Block> POLLEN_BLOCK = register("pollen_block",
            () -> new Block(AbstractBlock.Properties.of(Material.WOOL)
                    .sound(SoundType.HONEY_BLOCK)
                    .jumpFactor((float) 0.8)
                    .harvestTool(ToolType.HOE)
                    .strength((float) 0.3, 3)));
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
