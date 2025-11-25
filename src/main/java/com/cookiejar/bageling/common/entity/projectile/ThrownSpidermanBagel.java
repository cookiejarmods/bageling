package com.cookiejar.bageling.common.entity.projectile;

import com.cookiejar.bageling.core.registry.BagelingEntityTypes;
import com.cookiejar.bageling.core.registry.BagelingItems;
import com.cookiejar.bageling.core.registry.BagelingSounds;
import net.minecraft.core.particles.ItemParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

public class ThrownSpidermanBagel extends ThrowableItemProjectile {

	public ThrownSpidermanBagel(EntityType<? extends ThrowableItemProjectile> entityType, Level level) {
		super(entityType, level);
	}

	public ThrownSpidermanBagel(double x, double y, double z, Level level) {
		super(BagelingEntityTypes.SPIDERMANS_BAGEL.get(), x, y, z, level);
	}

	public ThrownSpidermanBagel(LivingEntity shooter, Level level) {
		super(BagelingEntityTypes.SPIDERMANS_BAGEL.get(), shooter, level);
	}


	@Override
	@OnlyIn(Dist.CLIENT)
	public void handleEntityEvent(byte id) {
		if (id == 3) {
			for (int n = 0; n < 8; ++n) {
				level().addParticle(new ItemParticleOption(ParticleTypes.ITEM, this.getItem()), this.getX(), this.getY(), this.getZ(), 0.0D, 0.0D, 0.0D);
			}
		}
	}

	@Override
	protected void onHitEntity(EntityHitResult result) {
		Entity entity = result.getEntity();
		Level level = result.getEntity().level();
		entity.hurt(this.damageSources().thrown(this, this.getOwner()), (float) 0);
		if (entity instanceof Player) {
			((Player) entity).getFoodData().eat(5, 0.4F);
			//this.playSound(); BONK
		}
		super.onHitEntity(result);
	}

	@Override
	protected void onHit(HitResult result) {
		if (!this.level().isClientSide) {
			this.level().broadcastEntityEvent(this, (byte)3);
			this.discard();
		}
		super.onHit(result);
	}

	@Override
	protected void onHitBlock(BlockHitResult result) {
		super.onHitBlock(result);
		if (this.random.nextInt(10) > 3) {
			this.level().addFreshEntity(new ItemEntity(this.level(), this.getX(), this.getY(), this.getZ(), this.getItem()));
		}
	}

	@Override
	protected Item getDefaultItem() {
		return BagelingItems.SPIDERMANS_BAGEL.get().asItem();
	}

	@Override
	public ItemStack getItem() {
		return new ItemStack(BagelingItems.SPIDERMANS_BAGEL.get());
	}
}