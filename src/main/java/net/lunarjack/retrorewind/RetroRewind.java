package net.lunarjack.retrorewind;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.lunarjack.retrorewind.block.ModBlocks;
import net.lunarjack.retrorewind.component.ModDataComponentTypes;
import net.lunarjack.retrorewind.item.ModFuelItems;
import net.lunarjack.retrorewind.item.ModItemGroups;
import net.lunarjack.retrorewind.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RetroRewind implements ModInitializer
{
	public static final String MOD_ID = "retrorewind";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize()
	{
		ModItemGroups.registerItemGroups();

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

		ModFuelItems.registerFuelItems();

		ModDataComponentTypes.registerComponentTypes();
	}
}