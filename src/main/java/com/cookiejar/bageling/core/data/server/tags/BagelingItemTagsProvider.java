package com.cookiejar.bageling.core.data.server.tags;

import com.cookiejar.bageling.core.Bageling;
import com.cookiejar.bageling.core.other.tags.BagelingBlockTags;
import com.cookiejar.bageling.core.other.tags.BagelingItemTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;
import static com.cookiejar.bageling.core.registry.BagelingItems.*;

public class BagelingItemTagsProvider extends ItemTagsProvider {

	public BagelingItemTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, CompletableFuture<TagLookup<Block>> blockTags, @Nullable ExistingFileHelper existingFileHelper) {
		super(output, lookupProvider, blockTags, Bageling.MOD_ID, existingFileHelper);
	}

	@Override
	protected void addTags(HolderLookup.Provider provider) {
		this.tag(Tags.Items.FOODS).add(BAGEL.get(), CREAM_CHEESE_BAGEL.get(), SPIDERMANS_BAGEL.get(), APPLE_JAM_BAGEL.get(), SWEET_BERRY_JAM_BAGEL.get(), GLOW_BERRY_JAM_BAGEL.get(), SALMON_BAGEL.get(), BAGEL_DOUGH.get(), BACON_EGG_CHEESE_BAGEL.get());
		this.tag(BagelingItemTags.DOUGH).add(BAGEL_DOUGH.get());
		this.tag(BagelingItemTags.BAGEL).add(BAGEL.get(), CREAM_CHEESE_BAGEL.get(), SPIDERMANS_BAGEL.get(), APPLE_JAM_BAGEL.get(), SWEET_BERRY_JAM_BAGEL.get(), GLOW_BERRY_JAM_BAGEL.get(), SALMON_BAGEL.get(), BAGEL_DOUGH.get(), BACON_EGG_CHEESE_BAGEL.get());

		this.copy(BagelingBlockTags.STORAGE_BLOCKS_BAGEL, BagelingItemTags.STORAGE_BLOCKS_BAGEL);
	}
}