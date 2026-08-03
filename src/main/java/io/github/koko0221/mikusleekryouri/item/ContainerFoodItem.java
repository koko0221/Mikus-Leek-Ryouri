package io.github.koko0221.mikusleekryouri.item;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import javax.annotation.Nonnull;


public class ContainerFoodItem extends Item {

    private final Item containerItem;
    private final int eatDuration;


    public ContainerFoodItem(
            Properties properties,
            Item containerItem
    ) {
        this(properties, containerItem, 32);
    }


    public ContainerFoodItem(
            Properties properties,
            Item containerItem,
            int eatDuration
    ) {
        super(properties);
        this.containerItem = containerItem;
        this.eatDuration = eatDuration;
    }


    @Override
    public int getUseDuration(
            @Nonnull ItemStack stack,
            @Nonnull LivingEntity entity
    ) {
        return eatDuration;
    }


    @Override
    public ItemStack finishUsingItem(
            @Nonnull ItemStack stack,
            @Nonnull Level level,
            @Nonnull LivingEntity entity
    ) {

        ItemStack result = super.finishUsingItem(
                stack,
                level,
                entity
        );


        if (!level.isClientSide()
                && entity instanceof Player player
                && !player.getAbilities().instabuild) {

            ItemStack containerStack =
                    new ItemStack(containerItem);


            if (result.isEmpty()) {
                return containerStack;
            }


            if (!player.getInventory().add(containerStack)) {
                player.drop(containerStack, false);
            }
        }


        return result;
    }
}