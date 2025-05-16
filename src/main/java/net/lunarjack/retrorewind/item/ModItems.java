package net.lunarjack.retrorewind.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.lunarjack.retrorewind.RetroRewind;
import net.lunarjack.retrorewind.block.ModBlocks;
import net.minecraft.item.*;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.tag.InstrumentTags;
import net.minecraft.util.Identifier;

public class ModItems
{
    public static final Item RUBY = registerItem("ruby", new Item(new Item.Settings()));
    public static final Item CLOUDY_RUBY = registerItem("cloudy_ruby", new Item(new Item.Settings()));
    public static final Item RUBY_INGOT = registerItem("ruby_ingot", new Item(new Item.Settings()));

    public static final Item RUBY_SWORD = registerItem("ruby_sword", new SwordItem(ModToolMaterials.RUBY, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.RUBY, 3, -2.4f))));
    public static final Item RUBY_AXE = registerItem("ruby_axe", new AxeItem(ModToolMaterials.RUBY, new Item.Settings().attributeModifiers(AxeItem.createAttributeModifiers(ModToolMaterials.RUBY, 6.0f, -3.2f))));
    public static final Item RUBY_PICKAXE = registerItem("ruby_pickaxe", new PickaxeItem(ModToolMaterials.RUBY, new Item.Settings().attributeModifiers(PickaxeItem.createAttributeModifiers(ModToolMaterials.RUBY, 1.0f, -2.8f))));
    public static final Item RUBY_SHOVEL = registerItem("ruby_shovel", new ShovelItem(ModToolMaterials.RUBY, new Item.Settings().attributeModifiers(ShovelItem.createAttributeModifiers(ModToolMaterials.RUBY, 1.5f , -3.0f))));
    public static final Item RUBY_HOE = registerItem("ruby_hoe", new HoeItem(ModToolMaterials.RUBY, new Item.Settings().attributeModifiers(HoeItem.createAttributeModifiers(ModToolMaterials.RUBY, 0.0f, -2.0f))));

    public static final Item RUBY_HELMET = registerItem("ruby_helmet", new ModArmorItem(ModArmorMaterials.RUBY_ARMOR_MATERIAL, ArmorItem.Type.HELMET, new Item.Settings().maxDamage(ArmorItem.Type.HELMET.getMaxDamage(15))));
    public static final Item RUBY_CHESTPLATE= registerItem("ruby_chestplate", new ArmorItem(ModArmorMaterials.RUBY_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE, new Item.Settings().maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(15))));
    public static final Item RUBY_LEGGINGS = registerItem("ruby_leggings", new ArmorItem(ModArmorMaterials.RUBY_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS, new Item.Settings().maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(15))));
    public static final Item RUBY_BOOTS = registerItem("ruby_boots", new ArmorItem(ModArmorMaterials.RUBY_ARMOR_MATERIAL, ArmorItem.Type.BOOTS, new Item.Settings().maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(15))));

    public static final Item QUIVER = registerItem("quiver", new QuiverItem(new Item.Settings().maxCount(1)));

    public static final Item FISH = registerItem("fish", new Item(new Item.Settings().food(ModFoodComponents.FISH)));
    public static final Item COOKED_FISH = registerItem("cooked_fish", new Item(new Item.Settings().food(ModFoodComponents.COOKED_FISH)));

    public static final Item COPPER_HORN = registerItem("copper_horn", new CopperHornItem(new Item.Settings().maxCount(1), InstrumentTags.GOAT_HORNS));

    public static final Item RUBY_UPGRADE_SMITHING_TEMPLATE = registerItem("ruby_upgrade_smithing_template", new Item(new Item.Settings()));

    private static Item registerItem(String name, Item item)
    {
        return Registry.register(Registries.ITEM, Identifier.of(RetroRewind.MOD_ID, name), item);
    }

    public static void registerModItems()
    {
        RetroRewind.LOGGER.info("Registering Mod Items for " + RetroRewind.MOD_ID);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries ->
        {
           entries.add(RUBY);
           entries.add(CLOUDY_RUBY);
           entries.add(RUBY_INGOT);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(entries ->
        {
            entries.add(QUIVER);
            entries.add(ModItems.RUBY_SWORD);
            entries.add(ModItems.RUBY_AXE);
            entries.add(ModItems.RUBY_HELMET);
            entries.add(ModItems.RUBY_CHESTPLATE);
            entries.add(ModItems.RUBY_LEGGINGS);
            entries.add(ModItems.RUBY_BOOTS);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(entries ->
        {
            entries.add(ModBlocks.RUBY_ORE);
            entries.add(ModBlocks.DEEPSLATE_RUBY_ORE);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries ->
        {
            entries.add(ModBlocks.RUBY_BLOCK);
            entries.add(ModBlocks.ANCIENT_WOOD_PLANKS);
            entries.add(ModBlocks.ANCIENT_WOOD_STAIRS);
            entries.add(ModBlocks.ANCIENT_WOOD_SLAB);
            entries.add(ModBlocks.ANCIENT_WOOD_BUTTON);
            entries.add(ModBlocks.RUBY_PRESSURE_PLATE);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(entries ->
        {
            entries.add(ModBlocks.NETHER_REACTOR_CORE);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(entries ->
        {
            entries.add(ModItems.FISH);
            entries.add(ModItems.COOKED_FISH);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.REDSTONE).register(entries ->
        {
            entries.add(ModBlocks.ANCIENT_WOOD_BUTTON);
            entries.add(ModBlocks.RUBY_PRESSURE_PLATE);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(entries ->
        {
            entries.add(ModItems.RUBY_SHOVEL);
            entries.add(ModItems.RUBY_PICKAXE);
            entries.add(ModItems.RUBY_AXE);
            entries.add(ModItems.RUBY_HOE);
        });
    }
}
