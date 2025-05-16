package net.lunarjack.retrorewind.item;

import net.lunarjack.retrorewind.RetroRewind;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;

import java.util.EnumMap;
import java.util.List;
import java.util.function.Supplier;

public class ModArmorMaterials
{
    public static final RegistryEntry<ArmorMaterial> RUBY_ARMOR_MATERIAL = registerArmorMaterial("ruby", () -> new ArmorMaterial(Util.make(new EnumMap<>(ArmorItem.Type.class), map ->
    {
        map.put(ArmorItem.Type.BOOTS, 2);
        map.put(ArmorItem.Type.LEGGINGS, 4);
        map.put(ArmorItem.Type.CHESTPLATE, 6);
        map.put(ArmorItem.Type.HELMET, 4);
        map.put(ArmorItem.Type.BODY, 4);
    }), 10, SoundEvents.ITEM_ARMOR_EQUIP_IRON, () -> Ingredient.ofItems(ModItems.RUBY_INGOT), List.of(new ArmorMaterial.Layer(Identifier.of(RetroRewind.MOD_ID, "ruby"))), 0, 0));

    public static RegistryEntry<ArmorMaterial> registerArmorMaterial(String name, Supplier<ArmorMaterial> material)
    {
        return Registry.registerReference(Registries.ARMOR_MATERIAL, Identifier.of(RetroRewind.MOD_ID, name), material.get());
    }
}
