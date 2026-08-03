package io.github.koko0221.mikusleekryouri.block;

import io.github.koko0221.mikusleekryouri.registry.ModItems;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;

public class LeekCropBlock extends CropBlock {


    public LeekCropBlock(Properties properties) {
        super(properties);
    }


    /**
     * 最大生長階段
     * CropBlock 預設是 7 (8階)
     */
    @Override
    public int getMaxAge() {
        return 7;
    }


    /**
     * 指定種子物品
     */
    @Override
    protected ItemLike getBaseSeedId() {
        return ModItems.LEEK_SEEDS.get();
    }


    /**
     * 種植條件
     */
    @Override
    protected boolean mayPlaceOn(
            BlockState state,
            BlockGetter level,
            BlockPos pos
    ) {
        return super.mayPlaceOn(state, level, pos);
    }


    /**
     * 生長條件
     * 光照 >= 9 才允許成長
     */
    @Override
    protected boolean canSurvive(
            BlockState state,
            LevelReader level,
            BlockPos pos
    ) {

        if (
                level.getRawBrightness(
                        pos,
                        0
                ) < 9
        ) {
            return false;
        }


        return super.canSurvive(
                state,
                level,
                pos
        );
    }

}