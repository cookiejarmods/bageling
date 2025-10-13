package com.cookiejar.bageling.core.registry;

import com.cookiejar.bageling.common.item.SpidermansBagel;
import com.cookiejar.bageling.core.Bageling;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraft.world.level.ItemLike;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModList;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

@EventBusSubscriber(modid = Bageling.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class BagelingItems {
	public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Bageling.MOD_ID);

	public static final DeferredItem<Item> BAGEL = ITEMS.register("bagel", () -> new Item(new Item.Properties().food(BagelingFoodProperties.BAGEL)));

	public static final DeferredItem<Item> CREAM_CHEESE_BAGEL = ITEMS.register("cream_cheese_bagel", () -> new Item(new Item.Properties().food(BagelingFoodProperties.CREAM_CHEESE_BAGEL)));

	public static final DeferredItem<Item> SPIDERMANS_BAGEL = ITEMS.register("spidermans_bagel", () -> new SpidermansBagel(new Item.Properties().rarity(Rarity.RARE)));

	public static final DeferredItem<Item> APPLE_JAM_BAGEL = ITEMS.register("apple_jam_bagel", () -> new Item(new Item.Properties().food(ModList.get().isLoaded("farmersdelight") ? BagelingFoodProperties.APPLE_JAM_BAGEL : BagelingFoodProperties.APPLE_JAM_BAGEL_NO_FD)));

	public static final DeferredItem<Item> SWEET_BERRY_JAM_BAGEL = ITEMS.register("sweet_berry_jam_bagel", () -> new Item(new Item.Properties().food(ModList.get().isLoaded("farmersdelight") ? BagelingFoodProperties.SWEET_BERRY_JAM_BAGEL : BagelingFoodProperties.SWEET_BERRY_JAM_BAGEL_NO_FD)));;

	public static final DeferredItem<Item> GLOW_BERRY_JAM_BAGEL = ITEMS.register("glow_berry_jam_bagel", () -> new Item(new Item.Properties().food(ModList.get().isLoaded("farmersdelight") ? BagelingFoodProperties.GLOW_BERRY_JAM_BAGEL : BagelingFoodProperties.GLOW_BERRY_JAM_BAGEL_NO_FD)));;

	public static final DeferredItem<Item> SALMON_BAGEL = ITEMS.register("salmon_bagel", () -> new Item(new Item.Properties().food(BagelingFoodProperties.SALMON_BAGEL)));

	public static class BagelingFoodProperties {
		public static final FoodProperties BAGEL = new FoodProperties.Builder().nutrition(5).saturationModifier(0.4f).fast().build();

		public static final FoodProperties BAGEL_DOUGH = new FoodProperties.Builder().nutrition(2).saturationModifier(0.4f).effect(() -> new MobEffectInstance(MobEffects.HUNGER, 600, 0), 0.3f).fast().build();

		public static final FoodProperties CREAM_CHEESE_BAGEL = new FoodProperties.Builder().nutrition(8).saturationModifier(0.4f).fast().build();

		public static final FoodProperties BACON_EGG_CHEESE_BAGEL = new FoodProperties.Builder().nutrition(10).saturationModifier(0.8f).fast().build();

		public static final FoodProperties SALMON_BAGEL = new FoodProperties.Builder().nutrition(10).saturationModifier(0.8f).fast().build();

		public static final FoodProperties APPLE_JAM_BAGEL = new FoodProperties.Builder().nutrition(7).saturationModifier(0.4f).alwaysEdible().effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 300, 0, false, false), 1F).fast().build();

		public static final FoodProperties SWEET_BERRY_JAM_BAGEL = new FoodProperties.Builder().nutrition(7).saturationModifier(0.4f).alwaysEdible().effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 300, 0, false, false), 1F).fast().build();

		public static final FoodProperties GLOW_BERRY_JAM_BAGEL = new FoodProperties.Builder().nutrition(7).saturationModifier(0.4f).alwaysEdible().effect(() -> new MobEffectInstance(MobEffects.GLOWING, 100, 0), 1F).fast().build();

		public static final FoodProperties APPLE_JAM_BAGEL_NO_FD = new FoodProperties.Builder().nutrition(7).saturationModifier(0.4f).fast().build();

		public static final FoodProperties SWEET_BERRY_JAM_BAGEL_NO_FD = new FoodProperties.Builder().nutrition(7).saturationModifier(0.4f).fast().build();

		public static final FoodProperties GLOW_BERRY_JAM_BAGEL_NO_FD = new FoodProperties.Builder().nutrition(7).saturationModifier(0.4f).fast().build();
	}

	@SubscribeEvent
	public static void buildCreativeTabs(BuildCreativeModeTabContentsEvent event) {
		if (event.getTabKey() == CreativeModeTabs.FOOD_AND_DRINKS) {
			addAfter(event, Items.BREAD, BAGEL);
			addAfter(event, BAGEL, CREAM_CHEESE_BAGEL);
			addAfter(event, BAGEL, APPLE_JAM_BAGEL);
			addAfter(event, BAGEL, SWEET_BERRY_JAM_BAGEL);
			addAfter(event, BAGEL, GLOW_BERRY_JAM_BAGEL);
			addAfter(event, BAGEL, SALMON_BAGEL);
			event.accept(BagelingBlocks.BAGEL_STACK.asItem());
		}
	}
	public static void addAfter(BuildCreativeModeTabContentsEvent event, ItemLike existing, ItemLike newItem) {
		event.insertAfter(new ItemStack(existing), new ItemStack(newItem), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
	}
}