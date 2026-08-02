package io.github.koko0221.mikusleekryouri.registry;


import io.github.koko0221.mikusleekryouri.MikusLeekRyouri;

import net.minecraft.core.component.DataComponents;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.ItemEnchantments;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.Item;


import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.AnvilUpdateEvent;


@EventBusSubscriber(modid = MikusLeekRyouri.MODID)
public class ModAnvilEvents {


    @SubscribeEvent
    public static void onAnvilUpdate(
            AnvilUpdateEvent event
    ){

        ItemStack left = event.getLeft();

        if(
                !left.is(ModItems.MIKU_LEEK_SWORD.get())
        ){
            return;
        }

        ItemStack right = event.getRight();


        ItemEnchantments leftEnchants =
                left.getOrDefault(
                        DataComponents.ENCHANTMENTS,
                        ItemEnchantments.EMPTY
                );


        ItemEnchantments rightEnchants =
                right.getOrDefault(
                        DataComponents.STORED_ENCHANTMENTS,
                        ItemEnchantments.EMPTY
                );

        if(rightEnchants.isEmpty()){
            rightEnchants =
                    right.getOrDefault(
                            DataComponents.ENCHANTMENTS,
                            ItemEnchantments.EMPTY
                    );
        }

        if(rightEnchants.isEmpty()){
            return;
        }


        ItemEnchantments.Mutable merged =
                new ItemEnchantments.Mutable(leftEnchants);

        Holder<Item> itemHolder = BuiltInRegistries.ITEM.wrapAsHolder(left.getItem());

        int appliedCount = 0;

        for(
                var entry : rightEnchants.entrySet()
        ){
            Holder<Enchantment> enchantment = entry.getKey();
            int rightLevel = entry.getIntValue();


            // 只允許這把劍本身合法能擁有的附魔（用 supported_items 檢查）
            if (!enchantment.value().definition().supportedItems().contains(itemHolder)) {
                continue;
            }

            int leftLevel = leftEnchants.getLevel(enchantment);

            int newLevel;
            if(leftLevel == rightLevel){
                newLevel = leftLevel + 1;
            } else {
                newLevel = Math.max(leftLevel, rightLevel);
            }

            int maxLevel = enchantment.value().getMaxLevel();
            newLevel = Math.min(newLevel, maxLevel);

            merged.set(enchantment, newLevel);
            appliedCount++;
        }


        if(appliedCount == 0){
            return;
        }


        ItemStack output = left.copy();

        output.set(
                DataComponents.ENCHANTMENTS,
                merged.toImmutable()
        );


        event.setOutput(output);

        event.setCost(
                Math.max(1, appliedCount)
        );

        event.setMaterialCost(1);

    }

}