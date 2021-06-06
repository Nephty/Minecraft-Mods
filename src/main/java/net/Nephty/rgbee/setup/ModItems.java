package net.Nephty.rgbee.setup;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;

public class ModItems {
    public static final RegistryObject<Item> POLLEN = Registration.ITEMS.register("pollen", () ->
            new Item(new Item.Properties().tab(ItemGroup.TAB_MATERIALS)));
    public static final RegistryObject<Item> LIQUID_POLLEN = Registration.ITEMS.register("liquid_pollen", () ->
            new Item(new Item.Properties().tab(ItemGroup.TAB_MATERIALS)));


    static void register() {}
}
