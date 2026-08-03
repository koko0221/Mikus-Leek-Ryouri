package io.github.koko0221.mikusleekryouri.block;

import io.github.koko0221.mikusleekryouri.registry.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import javax.annotation.Nonnull;

public class LeekCropBlock extends CropBlock {

    private static final VoxelShape[] SHAPE_BY_AGE = new VoxelShape[]{
            box(0,0,0,16,2,16),
            box(0,0,0,16,4,16),
            box(0,0,0,16,6,16),
            box(0,0,0,16,8,16),
            box(0,0,0,16,10,16),
            box(0,0,0,16,12,16),
            box(0,0,0,16,14,16),
            box(0,0,0,16,16,16)
    };

    public LeekCropBlock(Properties properties) {
        super(properties);
    }



    @Override
    public net.minecraft.world.level.block.state.properties.IntegerProperty getAgeProperty() {
        return AGE;
    }


    @Override
    protected ItemLike getBaseSeedId() {
        return ModItems.LEEK_SEEDS.get();
    }

    @Override
    public VoxelShape getShape(
            @Nonnull BlockState state,
            @Nonnull BlockGetter level,
            @Nonnull BlockPos pos,
            @Nonnull CollisionContext context
    ) {
        return SHAPE_BY_AGE[getAge(state)];
    }

    @Override
    protected int getBonemealAgeIncrease(@Nonnull Level level) {
        // 2~5
        return level.getRandom().nextIntBetweenInclusive(2,5);
    }
}
