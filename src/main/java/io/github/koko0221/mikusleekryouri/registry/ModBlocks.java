package io.github.koko0221.mikusleekryouri.registry;

import io.github.koko0221.mikusleekryouri.MikusLeekRyouri;
import io.github.koko0221.mikusleekryouri.block.LeekCropBlock;

import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;

import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.bus.api.IEventBus;


public class ModBlocks {

    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(MikusLeekRyouri.MODID);



    public static final DeferredBlock<LeekCropBlock> LEEK_CROP =
            BLOCKS.register(
                    "leek_crop",
                    () -> new LeekCropBlock(
                            BlockBehaviour.Properties.of()
                                    .noCollission()
                                    .randomTicks()
                                    .instabreak()
                                    .sound(SoundType.CROP)
                    )
            );



    public static final DeferredBlock<RotatedPillarBlock> LEEK_BUNDLE =
            BLOCKS.register(
                    "leek_bundle",
                    () -> new RotatedPillarBlock(
                            BlockBehaviour.Properties.of()
                                    .mapColor(MapColor.PLANT)
                                    .strength(0.5F)
                                    .sound(SoundType.GRASS)
                    )
            );



    public static void register(IEventBus bus) {
        BLOCKS.register(bus);
    }
}