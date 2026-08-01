package io.github.koko0221.mikusleekryouri.registry;


import io.github.koko0221.mikusleekryouri.MikusLeekRyouri;

import net.minecraft.world.item.alchemy.Potions;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.brewing.RegisterBrewingRecipesEvent;


@EventBusSubscriber(modid = MikusLeekRyouri.MODID)
public class ModBrewing {


    @SubscribeEvent
    public static void registerBrewing(
            RegisterBrewingRecipesEvent event
    ){

        // 水瓶 + 蔥 = 平凡藥水
        event.getBuilder().addMix(
                Potions.WATER,
                ModItems.LEEK.get(),
                Potions.MUNDANE
        );


        // 粗製藥水 + 蔥 = 初音水
        event.getBuilder().addMix(
                Potions.AWKWARD,
                ModItems.LEEK.get(),
                ModPotions.MIKU_WATER
        );

    }
}