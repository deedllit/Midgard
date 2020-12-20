package com.deedllit.midgard.common.client.entity.model;

import com.deedllit.midgard.common.entities.passive.CamelEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class CamelEntityModel2 extends EntityModel<CamelEntity> {
	private final ModelRenderer Body;
	private final ModelRenderer Legs;
	private final ModelRenderer Back;
	private final ModelRenderer BackRight;
	private final ModelRenderer BackLeft;
	private final ModelRenderer Front;
	private final ModelRenderer FrontRight;
	private final ModelRenderer FrontLeft;
	private final ModelRenderer Head;
	private final ModelRenderer Face;
	private final ModelRenderer Neck;
	private final ModelRenderer Belly;

	public CamelEntityModel2() {
		textureWidth = 64;
		textureHeight = 64;

		Body = new ModelRenderer(this);
		Body.setRotationPoint(0.0F, 24.0F, 0.0F);
		

		Legs = new ModelRenderer(this);
		Legs.setRotationPoint(0.0F, 0.0F, 0.0F);
		Body.addChild(Legs);
		

		Back = new ModelRenderer(this);
		Back.setRotationPoint(0.0F, 0.0F, 0.0F);
		Legs.addChild(Back);
		

		BackRight = new ModelRenderer(this);
		BackRight.setRotationPoint(0.0F, 0.0F, 0.0F);
		Back.addChild(BackRight);
		BackRight.setTextureOffset(30, 0).addBox(-5.0F, -9.0F, 5.0F, 3.0F, 9.0F, 3.0F, 0.0F, false);

		BackLeft = new ModelRenderer(this);
		BackLeft.setRotationPoint(0.0F, 0.0F, 0.0F);
		Back.addChild(BackLeft);
		BackLeft.setTextureOffset(0, 0).addBox(-1.0F, -9.0F, 5.0F, 3.0F, 9.0F, 3.0F, 0.0F, false);

		Front = new ModelRenderer(this);
		Front.setRotationPoint(0.0F, 0.0F, 0.0F);
		Legs.addChild(Front);
		

		FrontRight = new ModelRenderer(this);
		FrontRight.setRotationPoint(0.0F, 0.0F, 0.0F);
		Front.addChild(FrontRight);
		FrontRight.setTextureOffset(34, 34).addBox(-5.0F, -9.0F, -8.0F, 3.0F, 9.0F, 3.0F, 0.0F, false);

		FrontLeft = new ModelRenderer(this);
		FrontLeft.setRotationPoint(0.0F, 0.0F, 0.0F);
		Front.addChild(FrontLeft);
		FrontLeft.setTextureOffset(0, 22).addBox(-1.0F, -9.0F, -8.0F, 3.0F, 9.0F, 3.0F, 0.0F, false);

		Head = new ModelRenderer(this);
		Head.setRotationPoint(0.0F, 0.0F, 0.0F);
		Body.addChild(Head);
		

		Face = new ModelRenderer(this);
		Face.setRotationPoint(0.0F, 0.0F, 0.0F);
		Head.addChild(Face);
		Face.setTextureOffset(22, 22).addBox(-3.0F, -20.0F, -18.0F, 3.0F, 3.0F, 7.0F, 0.0F, false);
		Face.setTextureOffset(0, 12).addBox(-3.0F, -21.0F, -13.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);

		Neck = new ModelRenderer(this);
		Neck.setRotationPoint(0.0F, -10.0F, 0.0F);
		Head.addChild(Neck);
		Neck.setTextureOffset(18, 38).addBox(-3.0F, -7.0F, -14.0F, 3.0F, 5.0F, 3.0F, 0.0F, false);
		Neck.setTextureOffset(0, 22).addBox(-4.0F, -3.0F, -13.0F, 5.0F, 4.0F, 12.0F, 0.0F, false);

		Belly = new ModelRenderer(this);
		Belly.setRotationPoint(0.0F, 0.0F, 0.0F);
		Body.addChild(Belly);
		Belly.setTextureOffset(35, 22).addBox(-4.0F, -16.0F, 3.0F, 5.0F, 2.0F, 4.0F, 0.0F, false);
		Belly.setTextureOffset(0, 38).addBox(-4.0F, -16.0F, -7.0F, 5.0F, 2.0F, 4.0F, 0.0F, false);
		Belly.setTextureOffset(0, 0).addBox(-5.0F, -14.0F, -8.0F, 7.0F, 6.0F, 16.0F, 0.0F, false);
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
		
		Body.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);

		
	}

	@Override
	public void setLivingAnimations(CamelEntity entityIn, float limbSwing, float limbSwingAmount, float partialTick) {
		super.setLivingAnimations(entityIn, limbSwing, limbSwingAmount, partialTick);
	}
	
	public ModelRenderer getBack() {
		return Back;
	}
	
	public ModelRenderer getNeck() {
		return Neck;
	}
	
	public ModelRenderer getLegs() {
		return Legs;
	}
	
	public ModelRenderer getHead() {
		return Head;
	}
	
	public ModelRenderer getFrontRight() {
		return FrontRight;
	}
	
	public ModelRenderer getFrontLeft() {
		return FrontLeft;
	}
	
	public ModelRenderer getFront() {
		return Front;
	}
	
	public ModelRenderer getFace() {
		return Face;
	}
	
	public ModelRenderer getBody() {
		return Body;
	}
	
	public ModelRenderer getBelly() {
		return Belly;
	}
	
	public ModelRenderer getBackLeft() {
		return BackLeft;
	}
	
	public ModelRenderer getBackRight() {
		return BackRight;
	} 
	
	
}