package com.figgity.delightindungeon.client.model;

import com.figgity.delightindungeon.DelightInDungeon;
import com.figgity.delightindungeon.client.animation.WalkingMushroomEntityAnimation;
import com.figgity.delightindungeon.entities.custom.WalkingMushroomEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import org.jetbrains.annotations.NotNull;

public class WalkingMushroomModel extends HierarchicalModel<WalkingMushroomEntity> {
	public static final ModelLayerLocation LAYER_LOCATION =
			new ModelLayerLocation(new ResourceLocation(DelightInDungeon.MODID, "walking_mushroom"), "main");
	private final ModelPart body;

	public WalkingMushroomModel(ModelPart root) { this.body = root.getChild("body"); }

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offset(0.0F, 16.0F, 0.0F));

		PartDefinition stem = body.addOrReplaceChild("stem", CubeListBuilder.create().texOffs(0, 15).addBox(-4.0F, -4.0F, -2.0F, 8.0F, 7.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 1.5708F, 0.0F, 0.0F));

		PartDefinition leg1 = body.addOrReplaceChild("leg1", CubeListBuilder.create()
				.texOffs(6, 15).addBox(-0.5F, 0.0F, -1.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(6, 15).addBox(-0.5F, 2.0F, -1.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 3).addBox(-1.0F, 5.0F, -1.5F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(34, 0).addBox(-1.5F, 4.0F, -2.0F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, 2.0F, 0.0F));

		leg1.addOrReplaceChild("bone", CubeListBuilder.create().texOffs(6, 15).addBox(0.5F, -1.0F, -2.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.0F, 1.0F, 1.0F));

		leg1.addOrReplaceChild("bone2", CubeListBuilder.create().texOffs(6, 15).addBox(0.5F, 1.0F, -2.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.0F, 1.0F, 1.0F));

		PartDefinition cap = body.addOrReplaceChild("cap", CubeListBuilder.create().texOffs(0, 0).addBox(-6.0F, -20.0F, -5.5F, 12.0F, 5.0F, 10.0F, new CubeDeformation(0.0F))
		.texOffs(0, 32).addBox(-6.8284F, -16.0F, -5.0F, 1.0F, 2.0F, 9.0F, new CubeDeformation(0.0F))
		.texOffs(27, 23).addBox(6.0F, -16.0F, -5.0F, 1.0F, 2.0F, 9.0F, new CubeDeformation(0.0F))
		.texOffs(26, 18).addBox(-5.4142F, -16.0F, 4.4142F, 11.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(26, 15).addBox(-5.4142F, -16.0F, -6.4142F, 11.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 8.0F, 0.0F));

		PartDefinition cap_r1 = cap.addOrReplaceChild("cap_r1", CubeListBuilder.create().texOffs(0, 6).addBox(3.0F, -7.0F, 19.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-10.6777F, -9.0F, -6.6066F, 0.0F, 0.7854F, 0.0F));

		PartDefinition cap_r2 = cap.addOrReplaceChild("cap_r2", CubeListBuilder.create().texOffs(0, 18).addBox(3.0F, -7.0F, 4.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-11.7782F, -9.0F, -5.7071F, 0.0F, 0.7854F, 0.0F));

		PartDefinition cap_r3 = cap.addOrReplaceChild("cap_r3", CubeListBuilder.create().texOffs(0, 15).addBox(3.0F, -7.0F, 23.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.0208F, -9.0F, -15.0919F, 0.0F, -0.7854F, 0.0F));

		PartDefinition cap_r4 = cap.addOrReplaceChild("cap_r4", CubeListBuilder.create().texOffs(0, 21).addBox(3.0F, -7.0F, 4.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.2929F, -9.0F, -11.364F, 0.0F, -0.7854F, 0.0F));

		PartDefinition leg2 = body.addOrReplaceChild("leg2", CubeListBuilder.create()
				.texOffs(11, 32).addBox(-1.5F, 4.0F, -1.0F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-1.0F, 5.0F, -0.5F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(6, 20).addBox(-0.5F, 0.0F, 0.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(6, 20).addBox(-0.5F, 2.0F, 0.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, 2.0F, -1.0F));


		leg2.addOrReplaceChild("bone3", CubeListBuilder.create().texOffs(6, 15), PartPose.offset(-1.0F, 1.0F, 2.0F));

		leg2.addOrReplaceChild("bone4", CubeListBuilder.create().texOffs(6, 15), PartPose.offset(-1.0F, 1.0F, 2.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(@NotNull WalkingMushroomEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		body.getAllParts().forEach(ModelPart::resetPose);


		if(!entity.isInWaterOrBubble())	{
			animateWalk(WalkingMushroomEntityAnimation.walk, limbSwing, limbSwingAmount*2, 1.0f, 2.5f);
		}
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart root() {
		return this.body;
	}
}