package net.lunarjack.retrorewind.item;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class QuiverItem extends Item
{
    ModArrowTypes[] arrows = new ModArrowTypes[256];

    public QuiverItem(Settings settings)
    {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand)
    {
        ItemStack itemStack = user.getStackInHand(hand);
        if(user.getInventory().contains(new ItemStack(Items.ARROW)))
            return TypedActionResult.consume(itemStack);
        else
            return TypedActionResult.fail(itemStack);
    }
}
