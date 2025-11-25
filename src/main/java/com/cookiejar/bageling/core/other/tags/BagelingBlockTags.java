package com.cookiejar.bageling.core.other.tags;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public class BagelingBlockTags {
	public static final TagKey<Block> STORAGE_BLOCKS_BAGEL = blockTag("c", "storage_blocks/bagel");

	public static TagKey<Block> blockTag(String modid, String name) {
		return TagKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(modid, name));
	}
}
