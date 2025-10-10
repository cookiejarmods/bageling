package com.cookiejar.bageling.core.registry;

import com.cookiejar.bageling.common.entity.projectile.ThrownSpidermanBagel;
import com.cookiejar.bageling.core.Bageling;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.neoforge.event.tick.EntityTickEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class BagelingEntityTypes {
	public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(BuiltInRegistries.ENTITY_TYPE, Bageling.MOD_ID);

	public static final DeferredHolder<EntityType<?>, EntityType<ThrownSpidermanBagel>> SPIDERMANS_BAGEL = ENTITIES.register("spidermans_bagel", () -> EntityType.Builder.<ThrownSpidermanBagel>of(ThrownSpidermanBagel::new, MobCategory.MISC).sized(0.25F, 0.25F).build(Bageling.location("spidermans_bagel").toString()));
}