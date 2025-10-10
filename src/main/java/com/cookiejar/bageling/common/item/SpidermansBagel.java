package com.cookiejar.bageling.common.item;

import com.cookiejar.bageling.common.entity.projectile.ThrownSpidermanBagel;
import com.cookiejar.bageling.core.registry.BagelingItems;
import net.minecraft.core.Direction;
import net.minecraft.core.Position;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ProjectileItem;
import net.minecraft.world.level.Level;

public class SpidermansBagel extends Item implements ProjectileItem {

	public SpidermansBagel(Properties properties) {
		super(properties);
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand usedHand) {
		ItemStack itemStack = player.getItemInHand(usedHand);
		if (!player.getAbilities().instabuild) {
			itemStack.shrink(1);
		}
		level.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.SNOWBALL_THROW, SoundSource.NEUTRAL, 0.5F, 0.4F);

		if (!level.isClientSide) {
			ThrownSpidermanBagel thrownBagel= new ThrownSpidermanBagel(player, level);
			thrownBagel.setItem(new ItemStack(BagelingItems.SPIDERMANS_BAGEL.get()));
			thrownBagel.shootFromRotation(player, player.getXRot(), player.getYRot(), -1.0F, 0.6F, 1.0F);
			level.addFreshEntity(thrownBagel);

		}

		return new InteractionResultHolder<>(InteractionResult.SUCCESS, itemStack);
	}

	@Override
	public Projectile asProjectile(Level level, Position position, ItemStack itemStack, Direction direction) {
		ThrownSpidermanBagel thrownBagel = new ThrownSpidermanBagel(position.x(), position.y(), position.z(), level);
		thrownBagel.setItem(itemStack);
		return thrownBagel;
	}
}