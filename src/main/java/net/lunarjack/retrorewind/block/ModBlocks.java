package net.lunarjack.retrorewind.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.lunarjack.retrorewind.RetroRewind;
import net.lunarjack.retrorewind.sound.ModSounds;
import net.minecraft.block.*;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class ModBlocks
{
    public static final Block RUBY_BLOCK = registerBlock("ruby_block", new Block(AbstractBlock.Settings.copy(Blocks.EMERALD_BLOCK).mapColor(MapColor.RED).sounds(ModSounds.RUBY_BLOCK_SOUNDS)));
    public static final Block RUBY_ORE = registerBlock("ruby_ore", new ExperienceDroppingBlock(UniformIntProvider.create(3, 7), AbstractBlock.Settings.copy(Blocks.EMERALD_ORE).mapColor(MapColor.STONE_GRAY)));
    public static final Block DEEPSLATE_RUBY_ORE = registerBlock("deepslate_ruby_ore", new ExperienceDroppingBlock(UniformIntProvider.create(3, 7), AbstractBlock.Settings.copy(Blocks.DEEPSLATE_EMERALD_ORE).mapColor(MapColor.DEEPSLATE_GRAY)));
    public static final Block ANCIENT_WOOD_PLANKS = registerBlock("ancient_wood_planks", new Block(AbstractBlock.Settings.copy(Blocks.STONE)));

    public static final Block ANCIENT_WOOD_STAIRS = registerBlock("ancient_wood_stairs", new StairsBlock(ModBlocks.ANCIENT_WOOD_PLANKS.getDefaultState(), AbstractBlock.Settings.copy(Blocks.STONE_STAIRS)));
    public static final Block ANCIENT_WOOD_SLAB = registerBlock("ancient_wood_slab", new SlabBlock(AbstractBlock.Settings.copy(Blocks.STONE_SLAB)));
    public static final Block ANCIENT_WOOD_BUTTON = registerBlock("ancient_wood_button", new ButtonBlock(BlockSetType.IRON, 20, AbstractBlock.Settings.copy(Blocks.STONE).noCollision()));
    public static final Block RUBY_PRESSURE_PLATE = registerBlock("ruby_pressure_plate", new PressurePlateBlock(BlockSetType.IRON, AbstractBlock.Settings.copy(ModBlocks.RUBY_BLOCK)));

    public static final Block NETHER_REACTOR_CORE = registerBlock("nether_reactor_core", new NetherReactorCoreBlock(AbstractBlock.Settings.create().sounds(BlockSoundGroup.METAL).strength(3.0f, 6.0f).requiresTool().instrument(NoteBlockInstrument.CHIME).mapColor(MapColor.DIAMOND_BLUE)));

    private static Block registerBlock(String name, Block block)
    {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(RetroRewind.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block)
    {
        Registry.register(Registries.ITEM, Identifier.of(RetroRewind.MOD_ID, name), new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks()
    {
        RetroRewind.LOGGER.info("Registering Mod Blocks for " + RetroRewind.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries ->
        {
            entries.add(ModBlocks.RUBY_BLOCK );
        });
    }
}
