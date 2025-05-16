package net.lunarjack.retrorewind.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.lunarjack.retrorewind.block.ModBlocks;
import net.lunarjack.retrorewind.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LeafEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider
{
    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup)
    {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate()
    {
        addDrop(ModBlocks.RUBY_BLOCK);
        addDrop(ModBlocks.ANCIENT_WOOD_PLANKS);
        addDrop(ModBlocks.NETHER_REACTOR_CORE);
        addDrop(ModBlocks.RUBY_ORE, oreDrops(ModBlocks.RUBY_ORE, ModItems.CLOUDY_RUBY));
        addDrop(ModBlocks.DEEPSLATE_RUBY_ORE, oreDrops(ModBlocks.DEEPSLATE_RUBY_ORE, ModItems.CLOUDY_RUBY));
        addDrop(ModBlocks.ANCIENT_WOOD_STAIRS);
        addDrop(ModBlocks.ANCIENT_WOOD_SLAB, slabDrops(ModBlocks.ANCIENT_WOOD_SLAB));
        addDrop(ModBlocks.ANCIENT_WOOD_BUTTON);
        addDrop(ModBlocks.RUBY_PRESSURE_PLATE);
    }

    public LootTable.Builder multipleOreDrops(Block drop, Item item, float minDrops, float maxDrops)
    {
        RegistryWrapper.Impl<Enchantment> impl = this.registryLookup.getWrapperOrThrow(RegistryKeys.ENCHANTMENT);
        return this.dropsWithSilkTouch(drop, this.applyExplosionDecay(drop, ((LeafEntry.Builder<?>) ItemEntry.builder(item).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(minDrops, maxDrops)))).apply(ApplyBonusLootFunction.oreDrops(impl.getOrThrow(Enchantments.FORTUNE)))));
    }
}
