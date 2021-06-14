package net.Nephty.rgbee.setup;

import net.Nephty.rgbee.data.blocks.PollenHarvester;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;

public class ModItems {
    public static final RegistryObject<Item> POLLEN = Registration.ITEMS.register("pollen", () ->
            new Item(new Item.Properties().tab(ItemGroup.TAB_MATERIALS)));
    public static final RegistryObject<Item> GOLDEN_POLLEN = Registration.ITEMS.register("golden_pollen", () ->
            new Item(new Item.Properties().tab(ItemGroup.TAB_MISC)));
    public static final RegistryObject<Item> LIQUID_POLLEN = Registration.ITEMS.register("liquid_pollen", () ->
            new Item(new Item.Properties().tab(ItemGroup.TAB_MATERIALS)));
    public static final RegistryObject<Item> LIQUID_POLLEN_BOTTLE = Registration.ITEMS.register("liquid_pollen_bottle", () ->
            new Item(new Item.Properties().tab(ItemGroup.TAB_MATERIALS)));
    public static final RegistryObject<Item> POLLEN_HARVESTER = Registration.ITEMS.register("pollen_harvester", () ->
            new PollenHarvester(new Item.Properties().tab(ItemGroup.TAB_TOOLS).durability(220)));


    static void register() {}
}
