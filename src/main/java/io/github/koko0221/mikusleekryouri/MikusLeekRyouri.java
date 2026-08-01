package io.github.koko0221.mikusleekryouri;

import org.slf4j.Logger;
import com.mojang.logging.LogUtils;
import io.github.koko0221.mikusleekryouri.registry.ModBlocks;
import io.github.koko0221.mikusleekryouri.registry.ModCreativeModeTabs;
import io.github.koko0221.mikusleekryouri.registry.ModItems;
import io.github.koko0221.mikusleekryouri.registry.ModLootModifiers;
import io.github.koko0221.mikusleekryouri.registry.ModEffects;
import io.github.koko0221.mikusleekryouri.registry.ModPotions;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.server.ServerStartingEvent;

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(MikusLeekRyouri.MODID)
public class MikusLeekRyouri {

    public static final String MODID = "mikusleekryouri";

    public static final Logger LOGGER = LogUtils.getLogger();


    public MikusLeekRyouri(
            IEventBus modEventBus,
            ModContainer modContainer
    ) {

        // Common setup
        modEventBus.addListener(this::commonSetup);


        // Register blocks and items
        ModBlocks.register(modEventBus);
        ModItems.register(modEventBus);
        ModEffects.register(modEventBus);
        ModPotions.register(modEventBus);
        ModLootModifiers.register(modEventBus);
        
        // Register the custom creative mode tab
        ModCreativeModeTabs.register(modEventBus);

        // Register server events
        NeoForge.EVENT_BUS.register(this);


        // Config
        modContainer.registerConfig(
                ModConfig.Type.COMMON,
                Config.SPEC
        );
    }


    private void commonSetup(FMLCommonSetupEvent event) {

        LOGGER.info("Miku's Leek Ryouri common setup loaded!");

        event.enqueueWork(() -> {
});

    }


    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

        LOGGER.info("Miku's Leek Ryouri server starting!");

    }
}
