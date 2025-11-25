package com.cookiejar.bageling.core.other.tags;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class BagelingItemTags {
	public static final TagKey<Item> DOUGH = itemTag("c", "foods/dough");
	public static final TagKey<Item> COOKED_PORK = itemTag("c", "foods/cooked_pork");
	public static final TagKey<Item> COOKED_EGG = itemTag("c", "foods/cooked_egg");
	public static final TagKey<Item> EGGS = itemTag("c", "eggs");
	public static final TagKey<Item> MILK = itemTag("c", "foods/milk");
	public static final TagKey<Item> COOKED_SALMON = itemTag("c", "foods/cooked_salmon");
	public static final TagKey<Item> TOMATO = itemTag("c", "foods/tomato");
	public static final TagKey<Item> STRAWBERRY = itemTag("c", "foods/strawberry");

	public static final TagKey<Item> BAGEL = itemTag("c", "foods/bagel");
	public static final TagKey<Item> STORAGE_BLOCKS_BAGEL = itemTag("c", "storage_blocks/bagel");
	public static TagKey<Item> itemTag(String modid, String name) {
		return TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(modid, name));
	}
}