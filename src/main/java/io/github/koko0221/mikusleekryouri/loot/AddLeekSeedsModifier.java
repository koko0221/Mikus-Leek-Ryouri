package io.github.koko0221.mikusleekryouri.loot;

import com.mojang.serialization.MapCodec;
import io.github.koko0221.mikusleekryouri.registry.ModItems;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.neoforged.neoforge.common.loot.IGlobalLootModifier;
import net.neoforged.neoforge.common.loot.LootModifier;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;

public class AddLeekSeedsModifier extends LootModifier {


    public static final MapCodec<AddLeekSeedsModifier> CODEC =
            MapCodec.unit(
                    AddLeekSeedsModifier::new
            );


    public AddLeekSeedsModifier() {
        super(
                new LootItemCondition[0],
                0
        );
    }



    @Override
    protected ObjectArrayList<ItemStack> doApply(
            ObjectArrayList<ItemStack> loot,
            LootContext context
    ) {


        Identifier table =
                context.getQueriedLootTableId();


        if(
            table.equals(
                Identifier.parse(
                    "minecraft:chests/shipwreck_supply"
                )
            )
            ||
            table.equals(
                Identifier.parse(
                    "minecraft:chests/pillager_outpost"
                )
            )
        ){

            if(
                context.getRandom().nextFloat()
                < 0.4206f
            ){

                loot.add(
                    new ItemStack(
                        ModItems.LEEK_SEEDS.get(),
                        context.getRandom()
                            .nextInt(1,6)
                    )
                );

            }

        }


        return loot;
    }



    @Override
    public MapCodec<? extends IGlobalLootModifier> codec(){
        return CODEC;
    }

}
