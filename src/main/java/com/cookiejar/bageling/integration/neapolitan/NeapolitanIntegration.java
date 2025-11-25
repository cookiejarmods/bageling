package com.cookiejar.bageling.integration.neapolitan;

import com.cookiejar.bageling.core.registry.BagelingItems;
import com.teamabnormals.neapolitan.common.item.HealingItem;
import net.minecraft.world.item.Item;

import java.util.function.Supplier;

public class NeapolitanIntegration {
	public static final Supplier<Item> STRAWBERRY_BAGEL = () -> new HealingItem(1.0F, new Item.Properties().food(BagelingItems.BagelingFoodProperties.FRUIT_JAM_BAGEL_NO_FD));
}