package com.cookiejar.bageling.core.data.server;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

import com.cookiejar.bageling.core.Bageling;
import com.cookiejar.bageling.core.registry.BagelingCriteriaTriggers;
import com.cookiejar.bageling.core.registry.BagelingItems;

import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.advancements.AdvancementType;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.common.data.AdvancementProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class BagelingAdvancementProvider extends AdvancementProvider {

	public BagelingAdvancementProvider(PackOutput output, CompletableFuture<Provider> registries, ExistingFileHelper existingFileHelper) {
		super(output, registries, existingFileHelper, List.of(new BagelingAdvancementGenerator()));
	}

	public static class BagelingAdvancementGenerator implements AdvancementGenerator {

		@Override
		public void generate(Provider registries, Consumer<AdvancementHolder> saver, ExistingFileHelper existingFileHelper) {
			advancementBuilder("hit_player_with_bagel", "husbandry", ResourceLocation.withDefaultNamespace("husbandry/root"), BagelingItems.SPIDERMANS_BAGEL.get(), AdvancementType.CHALLENGE, true, false, true)
				.addCriterion("hit_player_with_bagel", BagelingCriteriaTriggers.hitPlayerWithBagel())
				.save(saver, Bageling.MOD_ID + ":husbandry/hit_player_with_bagel");
		}
	}

	private static Advancement.Builder advancementBuilder(String name, String category, ResourceLocation parent, ItemLike icon, AdvancementType frame, boolean showToast, boolean announceToChat, boolean hidden) {
			return Advancement.Builder.advancement().parent(Advancement.Builder.advancement().build(parent)).display(icon,
					Component.translatable("advancements." + Bageling.MOD_ID + "." + category + "." + name + ".title"),
					Component.translatable("advancements." + Bageling.MOD_ID + "." + category + "." + name + ".description"),
					null, frame, showToast, announceToChat, hidden);
		}
}
