package io.github.koko0221.mikusleekryouri.registry;


import com.mojang.serialization.MapCodec;

import io.github.koko0221.mikusleekryouri.MikusLeekRyouri;
import io.github.koko0221.mikusleekryouri.loot.AddLeekSeedsModifier;

import net.neoforged.neoforge.registries.NeoForgeRegistries;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.loot.IGlobalLootModifier;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;


public class ModLootModifiers {


    public static final DeferredRegister<MapCodec<? extends IGlobalLootModifier>>
            LOOT_MODIFIERS =
            DeferredRegister.create(
                    NeoForgeRegistries.Keys.GLOBAL_LOOT_MODIFIER_SERIALIZERS,
                    MikusLeekRyouri.MODID
            );


    public static final DeferredHolder<
            MapCodec<? extends IGlobalLootModifier>,
            MapCodec<AddLeekSeedsModifier>
            >
            ADD_LEEK_SEEDS =
            LOOT_MODIFIERS.register(
                    "add_leek_seeds",
                    () -> AddLeekSeedsModifier.CODEC
            );


    public static void register(IEventBus bus) {
        LOOT_MODIFIERS.register(bus);
    }

}
