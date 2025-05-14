package net.lunarjack.retrorewind.item;

import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.lunarjack.retrorewind.block.ModBlocks;

public class ModFuelItems
{
    public static void registerFuelItems()
    {
        FuelRegistry.INSTANCE.add(ModBlocks.ANCIENT_WOOD_PLANKS, 300);
    }
}
