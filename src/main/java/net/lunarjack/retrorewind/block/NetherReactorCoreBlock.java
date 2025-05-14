package net.lunarjack.retrorewind.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.pattern.BlockPattern;
import net.minecraft.block.pattern.BlockPatternBuilder;
import net.minecraft.block.pattern.CachedBlockPosition;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.predicate.block.BlockStatePredicate;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class NetherReactorCoreBlock extends Block
{
    public static final IntProperty STAGE = IntProperty.of("stage", 0, 2);

    private BlockPattern netherReactorPattern;

    public NetherReactorCoreBlock(Settings settings)
    {
        super(settings);
        setDefaultState(this.getDefaultState().with(STAGE, 0));
    }

    @Override
    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit)
    {
        if(!world.isClient)
            world.setBlockState(pos, state.cycle(STAGE));
        return ActionResult.SUCCESS;
    }

    private BlockPattern getNetherReactorPattern()
    {
        if(this.netherReactorPattern == null)
            this.netherReactorPattern = BlockPatternBuilder.start()
                    .aisle("###", "~*~", "###")
                    .where('*', CachedBlockPosition.matchesBlockState(BlockStatePredicate.forBlock(ModBlocks.NETHER_REACTOR_CORE)))
                    .where('#', CachedBlockPosition.matchesBlockState(BlockStatePredicate.forBlock(Blocks.COBBLESTONE)))
                    .where('~', pos -> pos.getBlockState().isAir())
                    .build();
        return this.netherReactorPattern;
    }

    private void isReactorCompleted(World world, BlockPos pos)
    {
        BlockPattern.Result result = this.getNetherReactorPattern().searchAround(world, pos);
    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(STAGE);
    }
}
