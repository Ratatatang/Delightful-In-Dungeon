package com.figgity.delightindungeon.event;

import com.figgity.delightindungeon.DelightInDungeon;
import com.figgity.delightindungeon.client.model.WalkingMushroomModel;
import com.figgity.delightindungeon.client.renderer.WalkingMushroomRenderer;
import com.figgity.delightindungeon.entities.EntityInit;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = DelightInDungeon.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientModEvents {
    @SubscribeEvent
    public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(EntityInit.WALKNG_MUSHROOM.get(), WalkingMushroomRenderer::new);
    }

    @SubscribeEvent
    public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(WalkingMushroomModel.LAYER_LOCATION, WalkingMushroomModel::createBodyLayer);
    }
}
