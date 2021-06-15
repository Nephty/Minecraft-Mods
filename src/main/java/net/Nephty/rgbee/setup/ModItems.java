package net.Nephty.rgbee.setup;

import net.Nephty.rgbee.data.blocks.PollenHarvester;
import net.Nephty.rgbee.data.colors.Color;
import net.Nephty.rgbee.data.items.food.EffectCookie;
import net.minecraft.item.Foods;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;

public class ModItems {
    public static final RegistryObject<Item> POLLEN = Registration.ITEMS.register("pollen", () ->
            new Item(new Item.Properties().tab(ItemGroup.TAB_MATERIALS)));
    public static final RegistryObject<Item> GREEN_POLLEN = Registration.ITEMS.register("green_pollen", () ->
            new Item(new Item.Properties().tab(ItemGroup.TAB_MATERIALS)));
    public static final RegistryObject<Item> RED_POLLEN = Registration.ITEMS.register("red_pollen", () ->
            new Item(new Item.Properties().tab(ItemGroup.TAB_MATERIALS)));
    public static final RegistryObject<Item> BLUE_POLLEN = Registration.ITEMS.register("blue_pollen", () ->
            new Item(new Item.Properties().tab(ItemGroup.TAB_MATERIALS)));
    public static final RegistryObject<Item> CYAN_POLLEN = Registration.ITEMS.register("cyan_pollen", () ->
            new Item(new Item.Properties().tab(ItemGroup.TAB_MATERIALS)));
    public static final RegistryObject<Item> MAGENTA_POLLEN = Registration.ITEMS.register("magenta_pollen", () ->
            new Item(new Item.Properties().tab(ItemGroup.TAB_MATERIALS)));
    public static final RegistryObject<Item> GOLDEN_POLLEN = Registration.ITEMS.register("golden_pollen", () ->
            new Item(new Item.Properties().tab(ItemGroup.TAB_MISC)));
    public static final RegistryObject<Item> LIQUID_POLLEN = Registration.ITEMS.register("liquid_pollen", () ->
            new Item(new Item.Properties().tab(ItemGroup.TAB_MATERIALS)));
    public static final RegistryObject<Item> LIQUID_POLLEN_BOTTLE = Registration.ITEMS.register("liquid_pollen_bottle", () ->
            new Item(new Item.Properties().tab(ItemGroup.TAB_MATERIALS)));
    public static final RegistryObject<Item> POLLEN_HARVESTER = Registration.ITEMS.register("pollen_harvester", () ->
            new PollenHarvester(new Item.Properties().tab(ItemGroup.TAB_TOOLS).durability(220)));
    public static final RegistryObject<Item> GREEN_WHEAT = Registration.ITEMS.register("green_wheat", () ->
            new Item(new Item.Properties().tab(ItemGroup.TAB_MATERIALS)));
    public static final RegistryObject<Item> RED_WHEAT = Registration.ITEMS.register("red_wheat", () ->
            new Item(new Item.Properties().tab(ItemGroup.TAB_MATERIALS)));
    public static final RegistryObject<Item> BLUE_WHEAT = Registration.ITEMS.register("blue_wheat", () ->
            new Item(new Item.Properties().tab(ItemGroup.TAB_MATERIALS)));
    public static final RegistryObject<Item> CYAN_WHEAT = Registration.ITEMS.register("cyan_wheat", () ->
            new Item(new Item.Properties().tab(ItemGroup.TAB_MATERIALS)));
    public static final RegistryObject<Item> MAGENTA_WHEAT = Registration.ITEMS.register("magenta_wheat", () ->
            new Item(new Item.Properties().tab(ItemGroup.TAB_MATERIALS)));
    public static final RegistryObject<Item> GREEN_COOKIE = Registration.ITEMS.register("green_cookie", () ->
            new EffectCookie((new Item.Properties()).tab(ItemGroup.TAB_FOOD).food(Foods.COOKIE), Color.GREEN));
    public static final RegistryObject<Item> RED_COOKIE = Registration.ITEMS.register("red_cookie", () ->
            new EffectCookie((new Item.Properties()).tab(ItemGroup.TAB_FOOD).food(Foods.COOKIE), Color.RED));
    public static final RegistryObject<Item> BLUE_COOKIE = Registration.ITEMS.register("blue_cookie", () ->
            new EffectCookie((new Item.Properties()).tab(ItemGroup.TAB_FOOD).food(Foods.COOKIE), Color.BLUE));
    public static final RegistryObject<Item> CYAN_COOKIE = Registration.ITEMS.register("cyan_cookie", () ->
            new EffectCookie((new Item.Properties()).tab(ItemGroup.TAB_FOOD).food(Foods.COOKIE), Color.CYAN));
    public static final RegistryObject<Item> MAGENTA_COOKIE = Registration.ITEMS.register("magenta_cookie", () ->
            new EffectCookie((new Item.Properties()).tab(ItemGroup.TAB_FOOD).food(Foods.COOKIE), Color.MAGENTA));


    static void register() {}
}
