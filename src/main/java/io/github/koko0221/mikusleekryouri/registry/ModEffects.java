package io.github.koko0221.mikusleekryouri.registry;


import io.github.koko0221.mikusleekryouri.MikusLeekRyouri;
import io.github.koko0221.mikusleekryouri.effect.SingerEffect;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.effect.MobEffect;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;


public class ModEffects {


    public static final DeferredRegister<MobEffect> EFFECTS =
            DeferredRegister.create(
                    Registries.MOB_EFFECT,
                    MikusLeekRyouri.MODID
            );


    public static final DeferredHolder<MobEffect, MobEffect> SINGER =
            EFFECTS.register(
                    "singer",
                    SingerEffect::new
            );


    public static void register(
            net.neoforged.bus.api.IEventBus bus
    ){
        EFFECTS.register(bus);
    }
}