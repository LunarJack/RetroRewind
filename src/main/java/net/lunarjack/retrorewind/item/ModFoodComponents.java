package net.lunarjack.retrorewind.item;

import net.minecraft.component.type.FoodComponent;

public class ModFoodComponents
{
    public static final FoodComponent FISH = new FoodComponent.Builder().nutrition(2).saturationModifier(0.1f).build();
    public static final FoodComponent COOKED_FISH = new FoodComponent.Builder().nutrition(5).saturationModifier(0.6f).build();
}
