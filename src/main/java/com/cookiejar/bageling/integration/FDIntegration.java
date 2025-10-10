package com.cookiejar.bageling.integration;

import com.cookiejar.bageling.core.registry.BagelingItems;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;

public class FDIntegration {
	public static final DeferredItem<Item> BACON_EGG_CHEESE_BAGEL = BagelingItems.ITEMS.register("bacon_egg_cheese_bagel", () -> new Item(new Item.Properties().food(BagelingItems.BagelingFoodProperties.BACON_EGG_CHEESE_BAGEL)));

	public static void register() {}
}