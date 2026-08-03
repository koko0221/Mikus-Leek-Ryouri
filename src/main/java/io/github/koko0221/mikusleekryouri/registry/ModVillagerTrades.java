package io.github.koko0221.mikusleekryouri.registry;

import io.github.koko0221.mikusleekryouri.MikusLeekRyouri;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.ItemCost;
import net.minecraft.world.item.trading.MerchantOffer;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.village.VillagerTradesEvent;
import net.neoforged.neoforge.event.village.WandererTradesEvent;

import java.util.List;

/**
 * Registers custom villager trades (farmer) and wandering trader trades
 * for the mod's leek items.
 *
 * NOTE: In 1.21.1, trades are NOT data-driven via JSON.
 * They must be registered here in Java instead.
 */
@EventBusSubscriber(modid = MikusLeekRyouri.MODID)
public class ModVillagerTrades {

    @SubscribeEvent
    public static void onVillagerTrades(VillagerTradesEvent event) {
        // Only add trades to Farmer profession
        if (event.getType() == VillagerProfession.FARMER) {

            // Level 1 trades list (index 0 = novice, index 1 = first trade pool)
            List<VillagerTrades.ItemListing> level1Trades = event.getTrades().get(1);

            // 16 leek -> 1 emerald
            level1Trades.add((trader, random) -> new MerchantOffer(
                    new ItemCost(ModItems.LEEK.get(), 16),
                    new ItemStack(Items.EMERALD),
                    12,
                    1,
                    0.05f
            ));
        }
    }

    @SubscribeEvent
    public static void onWandererTrades(WandererTradesEvent event) {

        // 1 emerald -> 1 leek seed
        event.getGenericTrades().add((trader, random) -> new MerchantOffer(
                new ItemCost(Items.EMERALD),
                new ItemStack(ModItems.LEEK_SEEDS.get()),
                12,
                1,
                0.05f
        ));
    }
}