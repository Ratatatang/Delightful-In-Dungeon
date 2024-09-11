package com.figgity.delightindungeon;

import com.figgity.delightindungeon.entities.EntityInit;
import com.figgity.delightindungeon.client.renderer.WalkingMushroomRenderer;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(DelightInDungeon.MODID)
public class DelightInDungeon {
    public static final String MODID = "delightindungeon";

    public DelightInDungeon() {
        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        EntityInit.ENTITY_TYPES.register(modEventBus);

        MinecraftForge.EVENT_BUS.register(this);
    }
}
