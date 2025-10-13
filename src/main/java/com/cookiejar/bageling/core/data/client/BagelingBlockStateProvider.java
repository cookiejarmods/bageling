package com.cookiejar.bageling.core.data.client;

import com.cookiejar.bageling.core.Bageling;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import static com.cookiejar.bageling.core.registry.BagelingBlocks.*;

public class BagelingBlockStateProvider extends BlockStateProvider {
	public BagelingBlockStateProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
		super(output, Bageling.MOD_ID, existingFileHelper);
	}

	@Override
	protected void registerStatesAndModels() {
		this.simpleBlockWithItem(BAGEL_STACK.get(),
				models().withExistingParent(BAGEL_STACK.getRegisteredName(), "block/cube_bottom_top")
						.texture("top", BAGEL_STACK.getId().withSuffix("_top").withPrefix("block/"))
						.texture("bottom", BAGEL_STACK.getId().withSuffix("_bottom").withPrefix("block/"))
						.texture("side", BAGEL_STACK.getId().withSuffix("_side").withPrefix("block/"))
		);
	}
}