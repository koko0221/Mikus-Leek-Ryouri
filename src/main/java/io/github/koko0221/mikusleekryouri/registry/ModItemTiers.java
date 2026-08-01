package io.github.koko0221.mikusleekryouri.registry;

import io.github.koko0221.mikusleekryouri.MikusLeekRyouri;

import net.minecraft.resources.Identifier;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ToolMaterial;


public class ModItemTiers {


    public static final TagKey<Item> MIKU_LEEK_SWORD_REPAIR_ITEMS =
            TagKey.create(
                    net.minecraft.core.registries.Registries.ITEM,
                    Identifier.fromNamespaceAndPath(
                            MikusLeekRyouri.MODID,
                            "repairs_miku_leek_sword"
                    )
            );


    public static final ToolMaterial MIKU_LEEK_MATERIAL =
            new ToolMaterial(
                    BlockTags.INCORRECT_FOR_DIAMOND_TOOL,
                    390,
                    15f,
                    1f,
                    37,
                    MIKU_LEEK_SWORD_REPAIR_ITEMS
            );
}