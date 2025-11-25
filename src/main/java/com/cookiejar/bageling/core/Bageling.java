package com.cookiejar.bageling.core;

import com.cookiejar.bageling.core.data.client.BagelingBlockStateProvider;
import com.cookiejar.bageling.core.data.client.BagelingItemModelProvider;
import com.cookiejar.bageling.core.data.server.BagelingAdvancementProvider;
import com.cookiejar.bageling.core.data.server.BagelingRecipeProvider;
import com.cookiejar.bageling.core.data.server.tags.BagelingBlockTagsProvider;
import com.cookiejar.bageling.core.data.server.tags.BagelingItemTagsProvider;
import com.cookiejar.bageling.core.registry.BagelingBlocks;
import com.cookiejar.bageling.core.registry.BagelingCriteriaTriggers;
import com.cookiejar.bageling.core.registry.BagelingEntityTypes;
import com.cookiejar.bageling.core.registry.BagelingItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.concurrent.CompletableFuture;

@Mod(Bageling.MOD_ID)
public class Bageling {
	public static final String MOD_ID = "bageling";

	public Bageling(IEventBus bus, ModContainer container) {
		BagelingItems.ITEMS.register(bus);
		BagelingBlocks.BLOCKS.register(bus);
		BagelingEntityTypes.ENTITIES.register(bus);
		BagelingCriteriaTriggers.TRIGGERS.register(bus);
		bus.addListener(this::dataSetup);
	}

	private void dataSetup(GatherDataEvent event) {
		DataGenerator generator = event.getGenerator();
		PackOutput output = generator.getPackOutput();
		CompletableFuture<HolderLookup.Provider> provider = event.getLookupProvider();
		ExistingFileHelper helper = event.getExistingFileHelper();

		boolean server = event.includeServer();
		boolean client = event.includeClient();
		generator.addProvider(client, new BagelingBlockStateProvider(output, helper));
		generator.addProvider(client, new BagelingItemModelProvider(output, helper));

		BagelingBlockTagsProvider blockTags = new BagelingBlockTagsProvider(output, provider, helper);
		generator.addProvider(server, blockTags);
		generator.addProvider(server, new BagelingRecipeProvider(output, provider));
		generator.addProvider(server, new BagelingItemTagsProvider(output, provider, blockTags.contentsGetter(), helper));
		generator.addProvider(server, new BagelingAdvancementProvider(output, provider, helper));
	}

	public static ResourceLocation location(String path) {
		return ResourceLocation.fromNamespaceAndPath(MOD_ID, path);
	}
}