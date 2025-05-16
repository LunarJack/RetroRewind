package net.lunarjack.retrorewind.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.lunarjack.retrorewind.RetroRewind;
import net.lunarjack.retrorewind.block.ModBlocks;
import net.lunarjack.retrorewind.item.ModItems;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.data.server.recipe.SmithingTrimRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider
{
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture)
    {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter exporter)
    {
        List<ItemConvertible> CLOUDY_RUBY_SMELTABLES = List.of(ModBlocks.RUBY_ORE, ModBlocks.DEEPSLATE_RUBY_ORE);

        offerSmelting(exporter, CLOUDY_RUBY_SMELTABLES, RecipeCategory.MISC, ModItems.CLOUDY_RUBY, 1.0f, 200, "cloudy_ruby");
        offerBlasting(exporter, CLOUDY_RUBY_SMELTABLES, RecipeCategory.MISC, ModItems.CLOUDY_RUBY, 1.0f, 100, "cloudy_ruby");

        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModItems.RUBY, RecipeCategory.BUILDING_BLOCKS, ModBlocks.RUBY_BLOCK);

        offerStonecuttingRecipe(exporter, RecipeCategory.MISC, ModItems.RUBY, ModItems.CLOUDY_RUBY);

        offerSmelting(exporter, List.of(ModItems.FISH), RecipeCategory.FOOD, ModItems.COOKED_FISH, 0.35f, 200, "cooked_fish");

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.NETHER_REACTOR_CORE)
                .pattern("IDI")
                .pattern("IDI")
                .pattern("IDI")
                .input('I', Items.IRON_INGOT)
                .input('D', Items.DIAMOND)
                .criterion(hasItem(Items.DIAMOND), conditionsFromItem(Items.DIAMOND))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.COPPER_HORN)
                .pattern("   ")
                .pattern("CHC")
                .pattern(" C ")
                .input('C', Items.COPPER_INGOT)
                .input('H', Items.GOAT_HORN)
                .criterion(hasItem(Items.GOAT_HORN), conditionsFromItem(Items.GOAT_HORN))
                .offerTo(exporter);
        ShapelessRecipeJsonBuilder.create(RecipeCategory.REDSTONE, ModBlocks.ANCIENT_WOOD_BUTTON)
                .input(ModBlocks.ANCIENT_WOOD_PLANKS)
                .criterion(hasItem(ModBlocks.ANCIENT_WOOD_PLANKS), conditionsFromItem(ModBlocks.ANCIENT_WOOD_PLANKS))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ANCIENT_WOOD_STAIRS)
                .pattern("P  ")
                .pattern("PP ")
                .pattern("PPP")
                .input('P', ModBlocks.ANCIENT_WOOD_PLANKS)
                .criterion(hasItem(ModBlocks.ANCIENT_WOOD_PLANKS), conditionsFromItem(ModBlocks.ANCIENT_WOOD_PLANKS))
                .offerTo(exporter);
        offerSlabRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.ANCIENT_WOOD_SLAB, ModBlocks.ANCIENT_WOOD_PLANKS);
        offerPressurePlateRecipe(exporter, ModBlocks.RUBY_PRESSURE_PLATE, ModItems.RUBY_INGOT);
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.RUBY_SWORD)
                .pattern(" R ")
                .pattern(" R ")
                .pattern(" S ")
                .input('R', ModItems.RUBY_INGOT)
                .input('S', Items.STICK)
                .criterion(hasItem(ModItems.RUBY_INGOT), conditionsFromItem(ModItems.RUBY_INGOT))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.RUBY_AXE)
                .pattern("RR ")
                .pattern("RS ")
                .pattern(" S ")
                .input('R', ModItems.RUBY_INGOT)
                .input('S', Items.STICK)
                .criterion(hasItem(ModItems.RUBY_INGOT), conditionsFromItem(ModItems.RUBY_INGOT))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.RUBY_PICKAXE)
                .pattern("RRR")
                .pattern(" S ")
                .pattern(" S ")
                .input('R', ModItems.RUBY_INGOT)
                .input('S', Items.STICK)
                .criterion(hasItem(ModItems.RUBY_INGOT), conditionsFromItem(ModItems.RUBY_INGOT))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.RUBY_SHOVEL)
                .pattern(" R ")
                .pattern(" S ")
                .pattern(" S ")
                .input('R', ModItems.RUBY_INGOT)
                .input('S', Items.STICK)
                .criterion(hasItem(ModItems.RUBY_INGOT), conditionsFromItem(ModItems.RUBY_INGOT))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.RUBY_HOE)
                .pattern("RR ")
                .pattern(" S ")
                .pattern(" S ")
                .input('R', ModItems.RUBY_INGOT)
                .input('S', Items.STICK)
                .criterion(hasItem(ModItems.RUBY_INGOT), conditionsFromItem(ModItems.RUBY_INGOT))
                .offerTo(exporter);
    }
}
