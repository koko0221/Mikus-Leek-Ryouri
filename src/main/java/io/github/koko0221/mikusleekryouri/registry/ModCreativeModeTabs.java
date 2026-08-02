package io.github.koko0221.mikusleekryouri.registry;

import io.github.koko0221.mikusleekryouri.MikusLeekRyouri;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.registries.RegisterEvent;


public class ModCreativeModeTabs {

    public static CreativeModeTab MIKU_TAB;


    private static final ResourceLocation MIKU_TAB_ID =
            ResourceLocation.fromNamespaceAndPath(
                    MikusLeekRyouri.MODID,
                    "miku"
            );



    public static void register(
            IEventBus eventBus
    ) {

        eventBus.addListener(
                ModCreativeModeTabs::onBuildCreativeModeTabContents
        );

        eventBus.addListener(
                ModCreativeModeTabs::onRegisterCreativeModeTab
        );
    }



    private static void onRegisterCreativeModeTab(
            RegisterEvent event
    ) {

        if (!event.getRegistryKey()
                .equals(BuiltInRegistries.CREATIVE_MODE_TAB.key())) {

            return;
        }


        event.register(
                BuiltInRegistries.CREATIVE_MODE_TAB.key(),
                MIKU_TAB_ID,
                () ->
                        CreativeModeTab.builder()

                                .title(
                                    net.minecraft.network.chat.Component.literal(
                                            "Miku's Leek Ryouri"
                                    )
                                )

                                .icon(
                                    () -> new ItemStack(
                                            ModItems.LEEK.get()
                                    )
                                )

                                .displayItems(
                                    (params, output) -> {

                                        // 基礎物品
                                        output.accept(
                                                ModItems.LEEK.get()
                                        );

                                        output.accept(
                                                ModItems.LEEK_SEEDS.get()
                                        );

                                        // 蔥捆
                                        output.accept(
                                                ModItems.LEEK_BUNDLE.get()
                                        );

                                        //初音蔥
                                        output.accept(
                                                ModItems.MIKU_LEEK_SWORD.get()
                                        );

                                        // 蔥料理
                                        output.accept(
                                                ModItems.BAKED_LEEK.get()
                                        );

                                        output.accept(
                                                ModItems.LEEK_SALMON.get()
                                        );

                                        output.accept(
                                                ModItems.LEEK_BREAD.get()
                                        );

                                        output.accept(
                                                ModItems.LEEK_CHICKEN.get()
                                        );

                                        output.accept(
                                                ModItems.GOLDEN_LEEK.get()
                                        );

                                        output.accept(
                                                ModItems.LEEK_RAMEN.get()
                                        );

                                        output.accept(
                                                ModItems.LEEK_STIR_FRIED_MUTTON.get()
                                        );

                                        output.accept(
                                                ModItems.LEEK_PORK_CHOP.get()
                                        );

                                        output.accept(
                                                ModItems.LEEK_STEAK.get()
                                        );

                                        output.accept(
                                                ModItems.YAMINABE.get()
                                        );
                                    }
                                )

                                .build()
        );
    }





    private static void onBuildCreativeModeTabContents(
            BuildCreativeModeTabContentsEvent event
    ) {


        ResourceKey<CreativeModeTab> tab =
                event.getTabKey();



        // 種子放自然方塊
        if(tab == CreativeModeTabs.NATURAL_BLOCKS) {

            event.accept(
                    ModItems.LEEK_SEEDS.get()
            );

            event.accept(
                    ModItems.LEEK_BUNDLE.get()
            );
        }


        // 劍放戰鬥分類
        if(tab == CreativeModeTabs.COMBAT) {

            event.accept(
                    ModItems.MIKU_LEEK_SWORD.get()
            );
        }


        // 食物分類
        if(tab == CreativeModeTabs.FOOD_AND_DRINKS) {


            event.accept(
                    ModItems.LEEK.get()
            );


            event.accept(
                    ModItems.BAKED_LEEK.get()
            );

            event.accept(
                    ModItems.LEEK_SALMON.get()
            );

            event.accept(
                    ModItems.LEEK_BREAD.get()
            );

            event.accept(
                    ModItems.LEEK_CHICKEN.get()
            );

            event.accept(
                    ModItems.GOLDEN_LEEK.get()
            );

            event.accept(
                    ModItems.LEEK_RAMEN.get()
            );

            event.accept(
                    ModItems.LEEK_STIR_FRIED_MUTTON.get()
            );

            event.accept(
                    ModItems.LEEK_PORK_CHOP.get()
            );

            event.accept(
                    ModItems.LEEK_STEAK.get()
            );

            event.accept(
                    ModItems.YAMINABE.get()
            );
        }
    }
}