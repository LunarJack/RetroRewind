package net.lunarjack.retrorewind.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.lunarjack.retrorewind.RetroRewind;
import net.lunarjack.retrorewind.block.ModBlocks;
import net.minecraft.item.Item;

import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.tag.InstrumentTags;
import net.minecraft.util.Identifier;

public class ModItems
{
    public static final Item RUBY = registerItem("ruby", new Item(new Item.Settings()));
    public static final Item CLOUDY_RUBY = registerItem("cloudy_ruby", new Item(new Item.Settings()));
    public static final Item RUBY_INGOT = registerItem("ruby_ingot", new Item(new Item.Settings()));
    public static final Item QUIVER = registerItem("quiver", new Item(new Item.Settings().maxCount(1)));

    public static final Item FISH = registerItem("fish", new Item(new Item.Settings().food(ModFoodComponents.FISH)));
    public static final Item COOKED_FISH = registerItem("cooked_fish", new Item(new Item.Settings().food(ModFoodComponents.COOKED_FISH)));

    public static final Item COPPER_HORN = registerItem("copper_horn", new CopperHornItem(new Item.Settings().maxCount(1), InstrumentTags.GOAT_HORNS));

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
    }
}
