package com.figgity.delightindungeon.client.renderer;

import com.figgity.delightindungeon.DelightInDungeon;
import com.figgity.delightindungeon.client.model.WalkingMushroomModel;
import com.figgity.delightindungeon.entities.custom.WalkingMushroomEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class WalkingMushroomRenderer extends MobRenderer<WalkingMushroomEntity, WalkingMushroomModel> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(DelightInDungeon.MODID, "textures/entity/walking_mushroom.png");

    public WalkingMushroomRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new WalkingMushroomModel(pContext.bakeLayer(WalkingMushroomModel.LAYER_LOCATION)), 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(WalkingMushroomEntity walkingMushroomEntity) {
        return TEXTURE;
    }
}
