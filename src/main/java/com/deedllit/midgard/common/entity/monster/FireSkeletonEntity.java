package com.deedllit.midgard.common.entity.monster;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.monster.AbstractSkeletonEntity;
import net.minecraft.entity.monster.CreeperEntity;
import net.minecraft.item.Items;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.World;

public class FireSkeletonEntity extends AbstractSkeletonEntity {

	protected FireSkeletonEntity(EntityType<? extends AbstractSkeletonEntity> type, World worldIn) {
		super(type, worldIn);
	}

	@Override
	protected SoundEvent getAmbientSound() {
		return SoundEvents.ENTITY_SKELETON_AMBIENT;
	}

	@Override
	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return SoundEvents.ENTITY_SKELETON_HURT;
	}

	@Override
	protected SoundEvent getDeathSound() {
		return SoundEvents.ENTITY_SKELETON_DEATH;
	}

	@Override
	protected SoundEvent getStepSound() {
		return SoundEvents.ENTITY_SKELETON_STEP;
	}

	protected void dropSpecialItems(DamageSource source, int looting, boolean recentlyHitIn) {
		super.dropSpecialItems(source, looting, recentlyHitIn);
		Entity entity = source.getTrueSource();
		if (entity instanceof CreeperEntity) {
			CreeperEntity creeperentity = (CreeperEntity)entity;
		    if (creeperentity.ableToCauseSkullDrop()) {
		    	creeperentity.incrementDroppedSkulls();
		        this.entityDropItem(Items.SKELETON_SKULL);
		        }
		    }
		}
	
	public boolean isPotionApplicable(EffectInstance potioneffectIn) {
		return potioneffectIn.getPotion() == Effects.WITHER ? false : super.isPotionApplicable(potioneffectIn);
		}
	
}
