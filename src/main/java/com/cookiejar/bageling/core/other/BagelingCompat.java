package com.cookiejar.bageling.core.other;

import com.cookiejar.bageling.core.registry.BagelingItems;

import net.minecraft.world.level.block.DispenserBlock;

public class BagelingCompat {
	public static void register() {
		registerDispenserBehaviours();
	}

	public static void registerDispenserBehaviours() {
		DispenserBlock.registerProjectileBehavior(BagelingItems.SPIDERMANS_BAGEL.get());
	}
}