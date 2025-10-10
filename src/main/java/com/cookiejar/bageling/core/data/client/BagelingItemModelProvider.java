package com.cookiejar.bageling.core.data.client;

import com.cookiejar.bageling.core.Bageling;
import com.cookiejar.bageling.core.registry.BagelingItems;
import com.cookiejar.bageling.integration.CreateIntegration;
import com.cookiejar.bageling.integration.FDIntegration;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import static com.cookiejar.bageling.core.registry.BagelingItems.*;

public class BagelingItemModelProvider extends ItemModelProvider {
	public BagelingItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
		super(output, Bageling.MOD_ID, existingFileHelper);
	}

	@Override
	protected void registerModels() {
		this.basicItem(BAGEL.get());
		this.basicItem(CREAM_CHEESE_BAGEL.get());
		this.basicItem(APPLE_JAM_BAGEL.get());
		this.basicItem(SWEET_BERRY_JAM_BAGEL.get());
		this.basicItem(GLOW_BERRY_JAM_BAGEL.get());
		this.basicItem(FDIntegration.BACON_EGG_CHEESE_BAGEL.get());
		this.basicItem(CreateIntegration.BAGEL_DOUGH.get());

		this.basicItem(SPIDERMANS_BAGEL.get());
	}
}