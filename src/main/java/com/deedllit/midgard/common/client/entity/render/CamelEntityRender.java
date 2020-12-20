package com.deedllit.midgard.common.client.entity.render;

import com.deedllit.midgard.Midgard;
import com.deedllit.midgard.common.client.entity.model.CamelEntityModel;
import com.deedllit.midgard.common.entities.passive.CamelEntity;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class CamelEntityRender extends MobRenderer<CamelEntity, CamelEntityModel> {

	protected static final ResourceLocation TEXTURE = new ResourceLocation(Midgard.MOD_ID,
			"textures/entity/camel.png");

	public CamelEntityRender(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new CamelEntityModel(), 0.5f);
	}

	@Override
	public ResourceLocation getEntityTexture(CamelEntity entity) {
		return TEXTURE;
	}
	
}
