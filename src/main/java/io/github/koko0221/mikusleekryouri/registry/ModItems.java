package io.github.koko0221.mikusleekryouri.registry;

import io.github.koko0221.mikusleekryouri.MikusLeekRyouri;
import io.github.koko0221.mikusleekryouri.item.ContainerFoodItem;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.SwordItem;

import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;


public class ModItems {

    public static final DeferredRegister.Items ITEMS =
            DeferredRegister.createItems(MikusLeekRyouri.MODID);



    public static final DeferredItem<Item> LEEK =
            ITEMS.register(
                    "leek",
                    () -> new Item(
                            new Item.Properties()
                                    .food(
                                            new FoodProperties.Builder()
                                                    .nutrition(1)
                                                    .saturationModifier(0.3F)
                                                    .build()
                                    )
                    )
            );


    public static final DeferredItem<BlockItem> LEEK_SEEDS =
            ITEMS.registerSimpleBlockItem(
                    "leek_seeds",
                    ModBlocks.LEEK_CROP
            );


    public static final DeferredItem<BlockItem> LEEK_BUNDLE =
            ITEMS.registerSimpleBlockItem(
                    "leek_bundle",
                    ModBlocks.LEEK_BUNDLE
            );



    public static final DeferredItem<Item> BAKED_LEEK =
            ITEMS.register(
                    "baked_leek",
                    () -> new Item(
                            food(2, 0.1F)
                    )
            );



    public static final DeferredItem<Item> LEEK_SALMON =
            ITEMS.register(
                    "leek_salmon",
                    () -> new Item(
                            food(7, 0.8F)
                    )
            );



    public static final DeferredItem<Item> LEEK_BREAD =
            ITEMS.register(
                    "leek_bread",
                    () -> new Item(
                            food(6, 0.6F)
                    )
            );



    public static final DeferredItem<Item> LEEK_CHICKEN =
            ITEMS.register(
                    "leek_chicken",
                    () -> new Item(
                            food(7, 0.6F)
                    )
            );



    public static final DeferredItem<Item> GOLDEN_LEEK =
            ITEMS.register(
                    "golden_leek",
                    () -> new Item(
                            food(4, 1.2F)
                    )
            );



    public static final DeferredItem<Item> LEEK_RAMEN =
            ITEMS.register(
                    "leek_ramen",
                    () -> new ContainerFoodItem(
                            food(12, 0.8F),
                            Items.BOWL
                    )
            );



    public static final DeferredItem<Item> LEEK_STIR_FRIED_MUTTON =
            ITEMS.register(
                    "leek_stir_fried_mutton",
                    () -> new ContainerFoodItem(
                            food(7, 0.8F),
                            Items.BOWL
                    )
            );



    public static final DeferredItem<Item> LEEK_PORK_CHOP =
            ITEMS.register(
                    "leek_pork_chop",
                    () -> new Item(
                            food(9, 0.8F)
                    )
            );



    public static final DeferredItem<Item> LEEK_STEAK =
            ITEMS.register(
                    "leek_steak",
                    () -> new Item(
                            food(9, 0.8F)
                    )
            );



    public static final DeferredItem<Item> YAMINABE =
            ITEMS.register(
                    "yaminabe",
                    () -> new ContainerFoodItem(
                            new Item.Properties()
                                    .stacksTo(16)
                                    .food(
                                            new FoodProperties.Builder()
                                                    .nutrition(12)
                                                    .saturationModifier(0.1F)
                                                    .effect(
                                                            () -> new MobEffectInstance(
                                                                    MobEffects.CONFUSION,
                                                                    600,
                                                                    0
                                                            ),
                                                            1.0F
                                                    )
                                                    .build()
                                    ),
                            Items.BUCKET,
                            78
                    )
            );



    public static final DeferredItem<Item> MIKU_LEEK_SWORD =
            ITEMS.registerItem(
                    "miku_leek_sword",
                    props -> new SwordItem(
                            ModItemTiers.MIKU_LEEK_MATERIAL,
                            props.attributes(
                                    SwordItem.createAttributes(
                                            ModItemTiers.MIKU_LEEK_MATERIAL,
                                            3,
                                            -2.4f
                                    )
                            )
                    )
            );


    private static Item.Properties food(
            int nutrition,
            float saturation
    ) {
        return new Item.Properties()
                .food(
                        new FoodProperties.Builder()
                                .nutrition(nutrition)
                                .saturationModifier(saturation)
                                .build()
                );
    }



    public static void register(
            net.neoforged.bus.api.IEventBus bus
    ) {
        ITEMS.register(bus);
    }
}