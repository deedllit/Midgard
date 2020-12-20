package com.deedllit.midgard.common.client.entity.model;

import com.deedllit.midgard.common.entities.passive.CamelEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class CamelEntityModel extends EntityModel<CamelEntity> {
	private final ModelRenderer BodyGrp;
	private final ModelRenderer HeadGrp;
	private final ModelRenderer NeckGrp;
	private final ModelRenderer EarsGrp;
	private final ModelRenderer NoseGrp;
	private final ModelRenderer BellyGrp;
	private final ModelRenderer LegsGrp;
	private final ModelRenderer LeftLegsGrp;
	private final ModelRenderer FrontLeftLeg;
	private final ModelRenderer BackLeftLeg;
	private final ModelRenderer RightLegsGrp;
	private final ModelRenderer FrontRightLeg;
	private final ModelRenderer BackRightLeg;

	public CamelEntityModel() {

		textureWidth = 128;
		textureHeight = 128;

		BodyGrp = new ModelRenderer(this);
		BodyGrp.setRotationPoint(0.0F, 24.0F, 0.0F);
		

		HeadGrp = new ModelRenderer(this);
		HeadGrp.setRotationPoint(0.0F, 0.0F, 0.0F);
		BodyGrp.addChild(HeadGrp);
		

		NeckGrp = new ModelRenderer(this);
		NeckGrp.setRotationPoint(0.0F, 0.0F, 0.0F);
		HeadGrp.addChild(NeckGrp);
		setRotationAngle(NeckGrp, 0.1309F, 0.0F, 0.0F);
		NeckGrp.setTextureOffset(40, 40).addBox(-4.0F, -35.0F, 0.0F, 6.0F, 18.0F, 5.0F, 0.0F, false);

		EarsGrp = new ModelRenderer(this);
		EarsGrp.setRotationPoint(0.0F, 0.0F, 0.0F);
		HeadGrp.addChild(EarsGrp);
		setRotationAngle(EarsGrp, -0.1309F, 0.0F, 0.0F);
		EarsGrp.setTextureOffset(28, 32).addBox(-4.0F, -42.0F, -3.0F, 2.0F, 6.0F, 2.0F, 0.0F, false);
		EarsGrp.setTextureOffset(0, 32).addBox(0.0F, -42.0F, -3.0F, 2.0F, 6.0F, 2.0F, 0.0F, false);

		NoseGrp = new ModelRenderer(this);
		NoseGrp.setRotationPoint(0.0F, 0.0F, 0.0F);
		HeadGrp.addChild(NoseGrp);
		NoseGrp.setTextureOffset(0, 32).addBox(-5.0F, -39.0F, -9.0F, 8.0F, 6.0F, 12.0F, 0.0F, false);

		BellyGrp = new ModelRenderer(this);
		BellyGrp.setRotationPoint(0.0F, 0.0F, 0.0F);
		BodyGrp.addChild(BellyGrp);
		BellyGrp.setTextureOffset(0, 0).addBox(-7.0F, -25.0F, 0.0F, 12.0F, 10.0F, 22.0F, 0.0F, false);
		BellyGrp.setTextureOffset(0, 50).addBox(-6.0F, -29.0F, 4.0F, 10.0F, 6.0F, 5.0F, 0.0F, false);
		BellyGrp.setTextureOffset(46, 0).addBox(-6.0F, -30.0F, 15.0F, 10.0F, 7.0F, 5.0F, 0.0F, false);

		LegsGrp = new ModelRenderer(this);
		LegsGrp.setRotationPoint(0.0F, 0.0F, 0.0F);
		BodyGrp.addChild(LegsGrp);
		

		LeftLegsGrp = new ModelRenderer(this);
		LeftLegsGrp.setRotationPoint(0.0F, 0.0F, 0.0F);
		LegsGrp.addChild(LeftLegsGrp);
		

		FrontLeftLeg = new ModelRenderer(this);
		FrontLeftLeg.setRotationPoint(0.0F, 0.0F, 0.0F);
		LeftLegsGrp.addChild(FrontLeftLeg);
		FrontLeftLeg.setTextureOffset(68, 12).addBox(5.0F, -24.0F, 1.0F, 6.0F, 6.0F, 6.0F, 0.0F, false);
		FrontLeftLeg.setTextureOffset(76, 63).addBox(5.0F, -3.0F, 1.0F, 6.0F, 3.0F, 6.0F, 0.0F, false);
		FrontLeftLeg.setTextureOffset(42, 65).addBox(6.0F, -20.0F, 2.0F, 4.0F, 18.0F, 4.0F, 0.0F, false);

		BackLeftLeg = new ModelRenderer(this);
		BackLeftLeg.setRotationPoint(0.0F, 0.0F, 0.0F);
		LeftLegsGrp.addChild(BackLeftLeg);
		BackLeftLeg.setTextureOffset(62, 44).addBox(5.0F, -24.0F, 16.0F, 7.0F, 6.0F, 6.0F, 0.0F, false);
		BackLeftLeg.setTextureOffset(76, 0).addBox(5.0F, -3.0F, 16.0F, 6.0F, 3.0F, 6.0F, 0.0F, false);
		BackLeftLeg.setTextureOffset(0, 61).addBox(6.0F, -20.0F, 17.0F, 4.0F, 18.0F, 4.0F, 0.0F, false);

		RightLegsGrp = new ModelRenderer(this);
		RightLegsGrp.setRotationPoint(0.0F, 0.0F, 0.0F);
		LegsGrp.addChild(RightLegsGrp);
		

		FrontRightLeg = new ModelRenderer(this);
		FrontRightLeg.setRotationPoint(0.0F, 0.0F, 0.0F);
		RightLegsGrp.addChild(FrontRightLeg);
		FrontRightLeg.setTextureOffset(57, 32).addBox(-13.0F, -24.0F, 1.0F, 7.0F, 6.0F, 6.0F, 0.0F, false);
		FrontRightLeg.setTextureOffset(76, 76).addBox(-13.0F, -3.0F, 1.0F, 6.0F, 3.0F, 6.0F, 0.0F, false);
		FrontRightLeg.setTextureOffset(26, 59).addBox(-12.0F, -20.0F, 2.0F, 4.0F, 18.0F, 4.0F, 0.0F, false);

		BackRightLeg = new ModelRenderer(this);
		BackRightLeg.setRotationPoint(0.0F, 0.0F, 0.0F);
		RightLegsGrp.addChild(BackRightLeg);
		BackRightLeg.setTextureOffset(56, 57).addBox(-13.0F, -24.0F, 16.0F, 7.0F, 6.0F, 6.0F, 0.0F, false);
		BackRightLeg.setTextureOffset(58, 69).addBox(-13.0F, -3.0F, 16.0F, 6.0F, 3.0F, 6.0F, 0.0F, false);
		BackRightLeg.setTextureOffset(0, 0).addBox(-12.0F, -20.0F, 17.0F, 4.0F, 18.0F, 4.0F, 0.0F, false);
	
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	@Override
	public void setRotationAngles(CamelEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks,
			float netHeadYaw, float headPitch) {		
	}

	@Override
	public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn,
			float red, float green, float blue, float alpha) {
		
		BodyGrp.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);

		
	}

	@Override
	public void setLivingAnimations(CamelEntity entityIn, float limbSwing, float limbSwingAmount, float partialTick) {
		super.setLivingAnimations(entityIn, limbSwing, limbSwingAmount, partialTick);
	}
	

	public ModelRenderer getBackLeftLeg() {
		return BackLeftLeg;
	}
	
	public ModelRenderer getBackRightLeg() {
		return BackRightLeg;
	}
	
	public ModelRenderer getEarsGrp() {
		return EarsGrp;
	}
	
	public ModelRenderer getFrontLeftLeg() {
		return FrontLeftLeg;
	}
	
	public ModelRenderer getFrontRightLeg() {
		return FrontRightLeg;
	}
	
	public ModelRenderer getNeckGrp() {
		return NeckGrp;
	}
	
	public ModelRenderer getNoseGrp() {
		return NoseGrp;
	}
	
	public ModelRenderer getBellyGrp() {
		return BellyGrp;
	}
	
	public ModelRenderer getBodyGrp() {
		return BodyGrp;
	}
	
		public ModelRenderer getHeadGrp() {
		return HeadGrp;
	}
	
	public ModelRenderer getLeftLegsGrp() {
		return LeftLegsGrp;
	}
	
	public ModelRenderer getLegsGrp() {
		return LegsGrp;
	}
	
	public ModelRenderer getRightLegsGrp() {
		return RightLegsGrp;
	}
	
	
}