package io.github.koko0221.mikusleekryouri.loot;

import com.mojang.serialization.MapCodec;

import io.github.koko0221.mikusleekryouri.registry.ModItems;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;

import net.neoforged.neoforge.common.loot.IGlobalLootModifier;
import net.neoforged.neoforge.common.loot.LootModifier;

import javax.annotation.Nonnull;


public class AddLeekSeedsModifier extends LootModifier {


    public static final MapCodec<AddLeekSeedsModifier> CODEC =
            MapCodec.unit(
                    AddLeekSeedsModifier::new
            );


    public AddLeekSeedsModifier() {
        super(
                new LootItemCondition[0]
        );
    }


    @Override
    protected ObjectArrayList<ItemStack> doApply(
            @Nonnull ObjectArrayList<ItemStack> loot,
            @Nonnull LootContext context
    ) {

        ResourceLocation table =
                context.getQueriedLootTableId();


        // =========================
        // Chest Loot
        // =========================

        if (
                table.equals(
                        ResourceLocation.parse(
                                "minecraft:chests/shipwreck_supply"
                        )
                )
                ||
                table.equals(
                        ResourceLocation.parse(
                                "minecraft:chests/pillager_outpost"
                        )
                )
        ) {

            // 42.06% chance
            if (
                    context.getRandom()
                            .nextFloat()
                            < 0.4206f
            ) {

                loot.add(
                        new ItemStack(
                                ModItems.LEEK_SEEDS.get(),
                                context.getRandom()
                                        .nextInt(1, 6)
                        )
                );

            }

        }


        // =========================
        // Zombie Family
        // =========================

        if (
                table.equals(
                        ResourceLocation.parse(
                                "minecraft:entities/zombie"
                        )
                )
                ||
                table.equals(
                        ResourceLocation.parse(
                                "minecraft:entities/husk"
                        )
                )
                ||
                table.equals(
                        ResourceLocation.parse(
                                "minecraft:entities/zombie_villager"
                        )
                )
        ) {

            // 1% chance
            if (
                    context.getRandom()
                            .nextFloat()
                            < 0.01f
            ) {

                loot.add(
                        new ItemStack(
                                ModItems.LEEK_SEEDS.get()
                        )
                );

            }

        }


        return loot;
    }


    @Override
    public MapCodec<? extends IGlobalLootModifier> codec() {
        return CODEC;
    }

}