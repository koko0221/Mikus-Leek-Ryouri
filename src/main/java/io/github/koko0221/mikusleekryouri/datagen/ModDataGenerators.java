package io.github.koko0221.mikusleekryouri.datagen;

import io.github.koko0221.mikusleekryouri.MikusLeekRyouri;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

@EventBusSubscriber(modid = MikusLeekRyouri.MODID)
public class ModDataGenerators {

    // 改成 Client：這個版本的 runData task 跑的是 client 資料生成流程，
    // 掉落表這種以前算「server data」的東西現在也要掛在 Client 事件底下才會被觸發
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput output = generator.getPackOutput();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        generator.addProvider(
                true,
                new LootTableProvider(
                        output,
                        Set.of(),
                        List.of(
                                new LootTableProvider.SubProviderEntry(
                                        ModBlockLootTableProvider::new,
                                        LootContextParamSets.BLOCK
                                )
                        ),
                        lookupProvider
                )
        );
    }
}
