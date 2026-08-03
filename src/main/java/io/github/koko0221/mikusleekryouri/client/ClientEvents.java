package io.github.koko0221.mikusleekryouri.client;


import io.github.koko0221.mikusleekryouri.MikusLeekRyouri;
import io.github.koko0221.mikusleekryouri.registry.ModEffects;

import net.minecraft.client.Minecraft;
import net.minecraft.core.particles.ParticleTypes;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.ClientTickEvent;



import java.util.Random;



@EventBusSubscriber(
        modid = MikusLeekRyouri.MODID,
        value = Dist.CLIENT
)
public class ClientEvents {


    private static int tick = 0;

    private static final Random RANDOM = new Random();



    @SubscribeEvent
    public static void clientTick(
            ClientTickEvent.Post event
    ){

        Minecraft mc = Minecraft.getInstance();

        var player = mc.player;
        var level = mc.level;

        if(
                player == null ||
                level == null ||
                mc.isPaused()
        ){
            return;
        }

        if(
                player.hasEffect(
                        ModEffects.SINGER
                )
        ){

            tick++;

            if(tick >= 4){

                tick = 0;

                double x =
                        player.getX()
                        +(RANDOM.nextDouble()-0.5)*1.2;

                double y =
                        player.getY()
                        +RANDOM.nextDouble()*1.8;

                double z =
                        player.getZ()
                        +(RANDOM.nextDouble()-0.5)*1.2;

                double color =
                        RANDOM.nextDouble()*0.8+0.1;

                level.addParticle(
                        ParticleTypes.NOTE,
                        x,
                        y,
                        z,
                        color,
                        0,
                        0
                );
            }

        }

    }

}