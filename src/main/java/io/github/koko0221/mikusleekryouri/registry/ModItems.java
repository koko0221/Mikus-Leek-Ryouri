package io.github.koko0221.mikusleekryouri.registry;

import io.github.koko0221.mikusleekryouri.MikusLeekRyouri;
import io.github.koko0221.mikusleekryouri.item.ContainerFoodItem;

import net.minecraft.core.component.DataComponents;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.component.Consumable;
import net.minecraft.world.item.consume_effects.ApplyStatusEffectsConsumeEffect;

import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;


public class ModItems {

    public static final DeferredRegister.Items ITEMS =
            DeferredRegister.createItems(MikusLeekRyouri.MODID);



    public static final DeferredItem<Item> LEEK =
            ITEMS.registerItem(
                    "leek",
                    Item::new,
                    () -> new Item.Properties()
                            .food(
                                    new FoodProperties.Builder()
                                            .nutrition(1)
                                            .saturationModifier(0.3F)
                                            .build()
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
            ITEMS.registerItem(
                    "baked_leek",
                    Item::new,
                    () -> new Item.Properties()
                            .food(
                                    new FoodProperties.Builder()
                                            .nutrition(2)
                                            .saturationModifier(0.1F)
                                            .build()
                            )
            );

    

    public static final DeferredItem<Item> LEEK_SALMON =
            ITEMS.registerItem(
                    "leek_salmon",
                    Item::new,
                    () -> new Item.Properties()
                            .food(
                                    new FoodProperties.Builder()
                                            .nutrition(7)
                                            .saturationModifier(0.8F)
                                            .build()
                            )
            );

    

    public static final DeferredItem<Item> LEEK_BREAD =
            ITEMS.registerItem(
                    "leek_bread",
                    Item::new,
                    () -> new Item.Properties()
                            .food(
                                    new FoodProperties.Builder()
                                            .nutrition(6)
                                            .saturationModifier(0.6F)
                                            .build()
                            )
            );

    

    public static final DeferredItem<Item> LEEK_CHICKEN =
            ITEMS.registerItem(
                    "leek_chicken",
                    Item::new,
                    () -> new Item.Properties()
                            .food(
                                    new FoodProperties.Builder()
                                            .nutrition(7)
                                            .saturationModifier(0.6F)
                                            .build()
                            )
            );

    

    public static final DeferredItem<Item> GOLDEN_LEEK =
            ITEMS.registerItem(
                    "golden_leek",
                    Item::new,
                    () -> new Item.Properties()
                            .food(
                                    new FoodProperties.Builder()
                                            .nutrition(4)
                                            .saturationModifier(1.2F)
                                            .build()
                            )
            );

    

    public static final DeferredItem<Item> LEEK_RAMEN =
        ITEMS.registerItem(
                "leek_ramen",
                (properties) ->
                        new ContainerFoodItem(
                                properties,
                                Items.BOWL
                        ),
                () -> new Item.Properties()
                        .food(
                                new FoodProperties.Builder()
                                        .nutrition(12)
                                        .saturationModifier(0.8F)
                                        .build()
                        )
        );

    

    public static final DeferredItem<Item> LEEK_STIR_FRIED_MUTTON =
            ITEMS.registerItem(
                    "leek_stir_fried_mutton",
                    (properties) ->
                            new ContainerFoodItem(
                                    properties,
                                    Items.BOWL
                            ),
                    () -> new Item.Properties()
                            .food(
                                    new FoodProperties.Builder()
                                            .nutrition(7)
                                            .saturationModifier(0.8F)
                                            .build()
                            )
            );

    

    public static final DeferredItem<Item> LEEK_PORK_CHOP =
            ITEMS.registerItem(
                    "leek_pork_chop",
                    Item::new,
                    () -> new Item.Properties()
                            .food(
                                    new FoodProperties.Builder()
                                            .nutrition(9)
                                            .saturationModifier(0.8F)
                                            .build()
                            )
            );

    

    public static final DeferredItem<Item> LEEK_STEAK =
            ITEMS.registerItem(
                    "leek_steak",
                    Item::new,
                    () -> new Item.Properties()
                            .food(
                                    new FoodProperties.Builder()
                                            .nutrition(9)
                                            .saturationModifier(0.8F)
                                            .build()
                            )
            );

    

    public static final DeferredItem<Item> YAMINABE =
            ITEMS.registerItem(
                    "yaminabe",
                    (properties) ->
                            new ContainerFoodItem(
                                    properties,
                                    Items.BUCKET,
                                    78
                            ),
                    () -> new Item.Properties()
                            .stacksTo(16)
                            .food(
                                    new FoodProperties.Builder()
                                            .nutrition(12)
                                            .saturationModifier(0.1F)
                                            .build()
                            )
                            .component(
                                    DataComponents.CONSUMABLE,
                                    Consumable.builder()
                                            // 噁心 Lv.1，持續 30 秒 (30 * 20 = 600 tick)，100% 觸發
                                            .onConsume(new ApplyStatusEffectsConsumeEffect(
                                                    new MobEffectInstance(MobEffects.NAUSEA, 600, 0),
                                                    1.0F
                                            ))
                                            .build()
                            )
            );

    public static final DeferredItem<Item> MIKU_LEEK_SWORD =
            ITEMS.registerItem(
                    "miku_leek_sword",
                    props -> new Item(
                            props.sword(
                                    ModItemTiers.MIKU_LEEK_MATERIAL,
                                    3,      // 攻擊加成，配合 +2 公式 = 5 傷害
                                    -2.4f   // 攻速 4 + (-2.4) = 1.6
                            )
                    )
            );
        
    public static void register(
            net.neoforged.bus.api.IEventBus bus
    ) {
        ITEMS.register(bus);
    }
}