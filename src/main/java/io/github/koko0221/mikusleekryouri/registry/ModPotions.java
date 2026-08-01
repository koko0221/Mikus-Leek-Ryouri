package io.github.koko0221.mikusleekryouri.registry;


import io.github.koko0221.mikusleekryouri.MikusLeekRyouri;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.alchemy.Potion;

import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;



public class ModPotions {


    public static final DeferredRegister<Potion> POTIONS =
            DeferredRegister.create(
                    Registries.POTION,
                    MikusLeekRyouri.MODID
            );


    public static final DeferredHolder<Potion, Potion> MIKU_WATER =
            POTIONS.register(
                    "miku_water",
                    () -> new Potion(
                            "miku_water",
                            new MobEffectInstance(
                                    ModEffects.SINGER,
                                    3780,
                                    0,
                                    false,
                                    true,
                                    true
                            )
                    )
            );


    public static void register(
            net.neoforged.bus.api.IEventBus bus
    ){
        POTIONS.register(bus);
    }
}