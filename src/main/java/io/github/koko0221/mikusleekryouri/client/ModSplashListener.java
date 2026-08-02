package io.github.koko0221.mikusleekryouri.client;


import io.github.koko0221.mikusleekryouri.MikusLeekRyouri;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.SplashManager;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.resources.Identifier;
import net.minecraft.server.packs.resources.PreparableReloadListener;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.AddClientReloadListenersEvent;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;


@EventBusSubscriber(
        modid = MikusLeekRyouri.MODID,
        value = Dist.CLIENT
)
public class ModSplashListener {


    private static final Style DEFAULT_STYLE =
            Style.EMPTY.withColor(-256);


    @SubscribeEvent
    public static void onAddReloadListeners(
            AddClientReloadListenersEvent event
    ){

        event.addListener(
                Identifier.fromNamespaceAndPath(
                        MikusLeekRyouri.MODID,
                        "miku_splash_injector"
                ),
                (PreparableReloadListener) (currentReload, taskExecutor, preparationBarrier, reloadExecutor) ->
                        CompletableFuture
                                .runAsync(() -> {}, taskExecutor)
                                .thenCompose(preparationBarrier::wait)
                                .thenRunAsync(
                                        ModSplashListener::injectSplash,
                                        reloadExecutor
                                )
        );

    }


    private static void injectSplash(){

        try {

            Field guiSplashField =
                    Minecraft.getInstance()
                            .gui
                            .getClass()
                            .getDeclaredField("splashManager");

            guiSplashField.setAccessible(true);

            SplashManager splashManager =
                    (SplashManager) guiSplashField.get(
                            Minecraft.getInstance().gui
                    );

            Field splashesField =
                    SplashManager.class
                            .getDeclaredField("splashes");

            splashesField.setAccessible(true);

            @SuppressWarnings("unchecked")
            List<Component> current =
                    (List<Component>) splashesField.get(splashManager);

            List<Component> merged =
                    new ArrayList<>(current);

            merged.add(
                    Component.literal(
                            "什麼叫初音是個軟體而已.....想決鬥嗎？！！！！"
                    ).setStyle(DEFAULT_STYLE)
            );

            splashesField.set(
                    splashManager,
                    List.copyOf(merged)
            );

        } catch(Exception e){
            e.printStackTrace();
        }

    }

}