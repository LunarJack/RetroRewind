package net.lunarjack.retrorewind.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.lunarjack.retrorewind.block.ModBlocks;
import net.lunarjack.retrorewind.item.ModItems;
import net.lunarjack.retrorewind.util.ModTags;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider
{

    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture)
    {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup)
    {
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.RUBY_BLOCK)
                .add(ModBlocks.RUBY_ORE)
                .add(ModBlocks.DEEPSLATE_RUBY_ORE)
                .add(ModBlocks.NETHER_REACTOR_CORE)
                .add(ModBlocks.ANCIENT_WOOD_PLANKS);
        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.RUBY_ORE)
                .add(ModBlocks.RUBY_BLOCK)
                .add(ModBlocks.DEEPSLATE_RUBY_ORE);
        getOrCreateTagBuilder(ModTags.Blocks.NEEDS_RUBY_TOOL)
                .addTag(BlockTags.NEEDS_IRON_TOOL);
    }
}
