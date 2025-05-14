package net.lunarjack.retrorewind.component;

import net.lunarjack.retrorewind.RetroRewind;
import net.minecraft.component.ComponentType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;


import java.util.function.UnaryOperator;

public class ModDataComponentTypes
{
    private static <T>ComponentType<T> register(String name, UnaryOperator<ComponentType.Builder<T>> builderOperator)
    {
        return Registry.register(Registries.DATA_COMPONENT_TYPE, Identifier.of(RetroRewind.MOD_ID, name), builderOperator.apply(ComponentType.builder()).build());
    }

    public static void registerComponentTypes()
    {
        RetroRewind.LOGGER.info("Registering Data Component Types for " + RetroRewind.MOD_ID);
    }
}
