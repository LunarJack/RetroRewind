package net.lunarjack.retrorewind.sound;

import net.lunarjack.retrorewind.RetroRewind;

import net.minecraft.block.jukebox.JukeboxSong;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class ModSounds
{
    public static final SoundEvent RUBY_BLOCK_PLACE = registerSoundEvent("ruby_block_place");
    public static final SoundEvent RUBY_BLOCK_HIT = registerSoundEvent("ruby_block_hit");
    public static final SoundEvent RUBY_BLOCK_STEP = registerSoundEvent("ruby_block_step");
    public static final SoundEvent RUBY_BLOCK_BREAK = registerSoundEvent("ruby_block_break");
    public static final SoundEvent RUBY_BLOCK_FALL = registerSoundEvent("ruby_block_fall");

    public static final BlockSoundGroup RUBY_BLOCK_SOUNDS = new BlockSoundGroup(1f, 1f, RUBY_BLOCK_BREAK, RUBY_BLOCK_STEP, RUBY_BLOCK_PLACE, RUBY_BLOCK_HIT, RUBY_BLOCK_FALL);

    private static SoundEvent registerSoundEvent(String name)
    {
        return Registry.register(Registries.SOUND_EVENT, Identifier.of(RetroRewind.MOD_ID, name), SoundEvent.of(Identifier.of(RetroRewind.MOD_ID, name)));
    }

    public static void registerSounds()
    {
        RetroRewind.LOGGER.info("Registering Mod Sounds for " + RetroRewind.MOD_ID);
    }
}
