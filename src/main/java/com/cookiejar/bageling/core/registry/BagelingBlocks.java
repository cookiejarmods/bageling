package com.cookiejar.bageling.core.registry;

import com.cookiejar.bageling.core.Bageling;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class BagelingBlocks {
	public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(Bageling.MOD_ID);

	public static final DeferredBlock<RotatedPillarBlock> BAGEL_STACK = register("bagel_stack", () -> new RotatedPillarBlock(BlockBehaviour.Properties.of().strength(0.5F).destroyTime(0.5F).sound(SoundType.WOOL).mapColor(MapColor.COLOR_BROWN)));

	public static final <T extends Block> DeferredBlock<T> register(String name, Supplier<T> supplier) {
		DeferredBlock<T> block = BLOCKS.register(name, supplier);
		BagelingItems.ITEMS.registerSimpleBlockItem(name, block);
		return block;
	}
}