package io.github.koko0221.mikusleekryouri.registry;

import io.github.koko0221.mikusleekryouri.MikusLeekRyouri;
import io.github.koko0221.mikusleekryouri.block.LeekCropBlock;

import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;

import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;



public class ModBlocks {

    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(MikusLeekRyouri.MODID);


    // 改用 registerBlock(name, factory, propertiesSupplier)
    // 這個版本會自動把 ResourceKey 綁進 Properties 的 id，不用自己手動 setId(...)
    public static final DeferredBlock<LeekCropBlock> LEEK_CROP =
        BLOCKS.registerBlock(
                "leek_crop",
                LeekCropBlock::new,
                () -> BlockBehaviour.Properties.of()
                        .noCollision()
                        .randomTicks()
                        .instabreak()
                        .sound(SoundType.CROP)
                        .pushReaction(PushReaction.DESTROY)
        );


    // 蔥捆：跟原木/乾草捆同類型，可依放置軸向旋轉
    public static final DeferredBlock<RotatedPillarBlock> LEEK_BUNDLE =
        BLOCKS.registerBlock(
                "leek_bundle",
                RotatedPillarBlock::new,
                () -> BlockBehaviour.Properties.of()
                        .mapColor(MapColor.PLANT)
                        .strength(0.5F)
                        .sound(SoundType.GRASS)
        );


    public static void register(
            net.neoforged.bus.api.IEventBus bus
    ){
        BLOCKS.register(bus);
    }
}