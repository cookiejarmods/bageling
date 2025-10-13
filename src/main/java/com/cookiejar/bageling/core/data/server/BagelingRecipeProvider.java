package com.cookiejar.bageling.core.data.server;

import com.cookiejar.bageling.core.registry.BagelingBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.neoforged.neoforge.common.Tags;

import java.util.concurrent.CompletableFuture;

import static com.cookiejar.bageling.core.registry.BagelingItems.*;
import static net.minecraft.world.item.Items.*;

public class BagelingRecipeProvider extends RecipeProvider {
	public BagelingRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
		super(output, registries);
	}

	@Override
	protected void buildRecipes(RecipeOutput recipeOutput) {
		ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, BAGEL, 3)
				.pattern(" X ")
				.pattern("X X")
				.pattern(" X ")
				.define('X', WHEAT)
				.unlockedBy("has_wheat", has(WHEAT))
				.save(recipeOutput);

		ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, CREAM_CHEESE_BAGEL, 3)
				.requires(BAGEL, 3)
				.requires(Tags.Items.BUCKETS_MILK)
				.unlockedBy("has_bagel", has(BAGEL))
				.save(recipeOutput);

		ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, APPLE_JAM_BAGEL, 3)
				.requires(BAGEL, 3)
				.requires(APPLE)
				.unlockedBy("has_bagel", has(BAGEL))
				.save(recipeOutput);

		ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, GLOW_BERRY_JAM_BAGEL, 3)
				.requires(BAGEL, 3)
				.requires(GLOW_BERRIES)
				.unlockedBy("has_bagel", has(BAGEL))
				.save(recipeOutput);

		ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, SWEET_BERRY_JAM_BAGEL, 3)
				.requires(BAGEL, 3)
				.requires(SWEET_BERRIES)
				.unlockedBy("has_bagel", has(BAGEL))
				.save(recipeOutput);

		ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, BagelingBlocks.BAGEL_STACK.asItem())
				.requires(BAGEL, 9)
				.unlockedBy("has_bagel", has(BAGEL))
				.save(recipeOutput);

		ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, BAGEL, 9)
				.requires(BagelingBlocks.BAGEL_STACK.asItem())
				.unlockedBy("has_bagel", has(BAGEL))
				.save(recipeOutput, "bagel_from_block");
	}
}