package net.lunarjack.retrorewind.item;

import net.minecraft.item.GoatHornItem;
import net.minecraft.item.Instrument;
import net.minecraft.registry.tag.TagKey;

public class CopperHornItem extends GoatHornItem
{
    private final TagKey<Instrument> instrumentTag;

    public CopperHornItem(Settings settings, TagKey<Instrument> instrumentTag)
    {
        super(settings, instrumentTag);
        this.instrumentTag = instrumentTag;
    }
}
