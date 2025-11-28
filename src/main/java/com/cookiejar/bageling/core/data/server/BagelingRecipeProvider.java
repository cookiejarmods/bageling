package com.cookiejar.bageling.core.data.server;

import com.cookiejar.bageling.core.other.tags.BagelingItemTags;
import com.cookiejar.bageling.core.registry.BagelingBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.conditions.ModLoadedCondition;
import net.neoforged.neoforge.common.conditions.OrCondition;

import java.util.List;
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
				.requires(BagelingItemTags.MILK)
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

		ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, STRAWBERRY_JAM_BAGEL, 3)
				.requires(BAGEL, 3)
				.requires(BagelingItemTags.STRAWBERRY)
				.unlockedBy("has_bagel", has(BAGEL))
				.save(recipeOutput.withConditions(new ModLoadedCondition("neapolitan")));

		ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, BagelingBlocks.BAGEL_STACK.asItem())
				.requires(BAGEL, 9)
				.unlockedBy("has_bagel", has(BAGEL))
				.save(recipeOutput);

		ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, BAGEL, 9)
				.requires(BagelingBlocks.BAGEL_STACK.asItem())
				.unlockedBy("has_bagel", has(BAGEL))
				.save(recipeOutput, "bageling:bagel_from_block");

		ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, BAGEL_DOUGH)
				.requires(BagelingItemTags.DOUGH)
				.unlockedBy("has_dough", has(BagelingItemTags.DOUGH))
				.save(recipeOutput.withConditions(new OrCondition(List.of(new ModLoadedCondition("create"), new ModLoadedCondition("farmersdelight")))));

		ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, BACON_EGG_CHEESE_BAGEL)
				.requires(BAGEL)
				.requires(BagelingItemTags.COOKED_PORK)
				.requires(BagelingItemTags.COOKED_EGG)
				.requires(BagelingItemTags.MILK)
				.unlockedBy("has_bagel", has(BAGEL))
				.save(recipeOutput);

		ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, BACON_EGG_CHEESE_BAGEL)
			.requires(BAGEL)
			.requires(BagelingItemTags.COOKED_PORK)
			.requires(BagelingItemTags.EGGS)
			.requires(BagelingItemTags.MILK)
			.unlockedBy("has_bagel", has(BAGEL))
			.save(recipeOutput, "bageling:bacon_raw_egg_cheese_bagel");

		ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, SALMON_BAGEL)
				.requires(BAGEL)
				.requires(BagelingItemTags.COOKED_SALMON)
				.requires(BagelingItemTags.MILK)
				.requires(BagelingItemTags.TOMATO)
				.unlockedBy("has_bagel", has(BAGEL))
				.save(recipeOutput.withConditions(new ModLoadedCondition("farmersdelight")));

		ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, SPIDERMANS_BAGEL, 8)
				.pattern("BBB")
				.pattern("BSB")
				.pattern("BBB")
				.define('B', BAGEL)
				.define('S', STRING)
				.unlockedBy("has_spidermans_bagel", has(SPIDERMANS_BAGEL))
				.save(recipeOutput);

		SimpleCookingRecipeBuilder.smelting(Ingredient.of(BAGEL_DOUGH), RecipeCategory.FOOD, BAGEL.get(), 0.35F, 200).unlockedBy("has_dough", has(BagelingItemTags.DOUGH)).save(recipeOutput, "bageling:bagel_from_smelting");
		SimpleCookingRecipeBuilder.smoking(Ingredient.of(BAGEL_DOUGH), RecipeCategory.FOOD, BAGEL.get(), 0.35F, 100).unlockedBy("has_dough", has(BagelingItemTags.DOUGH)).save(recipeOutput, "bageling:bagel_from_smoking");
		SimpleCookingRecipeBuilder.campfireCooking(Ingredient.of(BAGEL_DOUGH), RecipeCategory.FOOD, BAGEL.get(), 0.35F, 600).unlockedBy("has_dough", has(BagelingItemTags.DOUGH)).save(recipeOutput, "bageling:bagel_from_campfire");
	}
}