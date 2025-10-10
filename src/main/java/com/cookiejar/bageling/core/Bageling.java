package com.cookiejar.bageling.core;

import com.cookiejar.bageling.core.data.client.BagelingItemModelProvider;
import com.cookiejar.bageling.core.registry.BagelingEntityTypes;
import com.cookiejar.bageling.core.registry.BagelingItems;
import com.cookiejar.bageling.integration.CreateIntegration;
import com.cookiejar.bageling.integration.FDIntegration;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.ModList;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.concurrent.CompletableFuture;

@Mod(Bageling.MOD_ID)
public class Bageling {
	public static final String MOD_ID = "bageling";

	public Bageling(IEventBus bus, ModContainer container) {
		BagelingItems.ITEMS.register(bus);
		BagelingEntityTypes.ENTITIES.register(bus);
		if (ModList.get().isLoaded("farmersdelight")) {
			FDIntegration.register();
		}
		if (ModList.get().isLoaded("farmersdelight") || ModList.get().isLoaded("create")) {
			CreateIntegration.register();
		}
		bus.addListener(this::dataSetup);
	}

	private void dataSetup(GatherDataEvent event) {
		DataGenerator generator = event.getGenerator();
		PackOutput output = generator.getPackOutput();
		CompletableFuture<HolderLookup.Provider> provider = event.getLookupProvider();
		ExistingFileHelper helper = event.getExistingFileHelper();

		boolean server = event.includeServer();
		boolean client = event.includeClient();
		generator.addProvider(client, new BagelingItemModelProvider(output, helper));
	}

	public static ResourceLocation location(String path) {
		return ResourceLocation.fromNamespaceAndPath(MOD_ID, path);
	}
}