package com.cookiejar.bageling.integration;

import com.cookiejar.bageling.core.registry.BagelingItems;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;

public class CreateIntegration {
	public static final DeferredItem<Item> BAGEL_DOUGH = BagelingItems.ITEMS.register("bagel_dough", () -> new Item(new Item.Properties().food(BagelingItems.BagelingFoodProperties.BAGEL_DOUGH)));

	public static void register() {}
}