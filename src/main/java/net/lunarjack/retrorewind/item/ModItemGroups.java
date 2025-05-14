package net.lunarjack.retrorewind.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.lunarjack.retrorewind.RetroRewind;
import net.lunarjack.retrorewind.block.ModBlocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups
{
    public static final ItemGroup RETROREWIND_GROUP = Registry.register(Registries.ITEM_GROUP, Identifier.of(RetroRewind.MOD_ID, "retrorewind_group"), FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.QUIVER)).displayName(Text.translatable("itemgroup.retrorewind.retrorewind_group")).entries((displayContext, entries) ->
    {
        entries.add(ModItems.QUIVER);
        entries.add(ModItems.RUBY);
        entries.add(ModItems.CLOUDY_RUBY);
        entries.add(ModItems.RUBY_INGOT);
        entries.add(ModItems.FISH);
        entries.add(ModItems.COOKED_FISH);
        entries.add(ModBlocks.RUBY_BLOCK);
        entries.add(ModBlocks.RUBY_ORE);
        entries.add(ModBlocks.DEEPSLATE_RUBY_ORE);
        entries.add(ModBlocks.ANCIENT_WOOD_PLANKS);
        entries.add(ModBlocks.NETHER_REACTOR_CORE);
        entries.add(ModBlocks.ANCIENT_WOOD_BUTTON);
        entries.add(ModBlocks.ANCIENT_WOOD_SLAB);
        entries.add(ModBlocks.ANCIENT_WOOD_STAIRS);
        entries.add(ModBlocks.RUBY_PRESSURE_PLATE);
    }).build());

    public static void registerItemGroups()
    {
        RetroRewind.LOGGER.info("Registering Mod Ittem Groups for " + RetroRewind.MOD_ID);
    }
}
