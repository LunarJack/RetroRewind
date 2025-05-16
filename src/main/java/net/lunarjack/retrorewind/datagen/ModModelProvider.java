package net.lunarjack.retrorewind.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.lunarjack.retrorewind.block.ModBlocks;
import net.lunarjack.retrorewind.item.ModItems;
import net.minecraft.data.client.*;
import net.minecraft.item.ArmorItem;
import net.minecraft.util.Identifier;

public class ModModelProvider extends FabricModelProvider
{
    public ModModelProvider(FabricDataOutput output)
    {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator)
    {
        BlockStateModelGenerator.BlockTexturePool rubyPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.RUBY_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_RUBY_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RUBY_ORE);
        BlockStateModelGenerator.BlockTexturePool ancientPlankPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.ANCIENT_WOOD_PLANKS);
        ancientPlankPool.stairs(ModBlocks.ANCIENT_WOOD_STAIRS);
        ancientPlankPool.slab(ModBlocks.ANCIENT_WOOD_SLAB);
        ancientPlankPool.button(ModBlocks.ANCIENT_WOOD_BUTTON);
        rubyPool.pressurePlate(ModBlocks.RUBY_PRESSURE_PLATE);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator)
    {
        itemModelGenerator.register(ModItems.RUBY, Models.GENERATED);
        itemModelGenerator.register(ModItems.CLOUDY_RUBY, Models.GENERATED);
        itemModelGenerator.register(ModItems.COOKED_FISH, Models.GENERATED);
        itemModelGenerator.register(ModItems.FISH, Models.GENERATED);
        itemModelGenerator.register(ModItems.QUIVER, Models.GENERATED);
        itemModelGenerator.register(ModItems.RUBY_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.RUBY_UPGRADE_SMITHING_TEMPLATE, Models.GENERATED);
        itemModelGenerator.register(ModItems.RUBY_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.RUBY_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.RUBY_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.RUBY_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.RUBY_HOE, Models.HANDHELD);
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.RUBY_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.RUBY_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.RUBY_LEGGINGS));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.RUBY_BOOTS));
    }
}
