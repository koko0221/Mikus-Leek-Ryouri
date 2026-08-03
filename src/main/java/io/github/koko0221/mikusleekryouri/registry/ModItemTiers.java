package io.github.koko0221.mikusleekryouri.registry;


import io.github.koko0221.mikusleekryouri.MikusLeekRyouri;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;

import net.neoforged.neoforge.common.SimpleTier;


public class ModItemTiers {


    public static final TagKey<Item> MIKU_LEEK_SWORD_REPAIR_ITEMS =
            TagKey.create(
                    net.minecraft.core.registries.Registries.ITEM,
                    ResourceLocation.fromNamespaceAndPath(
                            MikusLeekRyouri.MODID,
                            "repairs_miku_leek_sword"
                    )
            );


    public static final Tier MIKU_LEEK_MATERIAL =
            new SimpleTier(
                    BlockTags.INCORRECT_FOR_DIAMOND_TOOL,
                    390,
                    15f,
                    1f,
                    37,
                    () -> Ingredient.of(MIKU_LEEK_SWORD_REPAIR_ITEMS)
            );

}