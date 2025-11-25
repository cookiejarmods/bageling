package com.cookiejar.bageling.core.registry;

import java.util.Optional;

import com.cookiejar.bageling.core.Bageling;

import net.minecraft.advancements.Criterion;
import net.minecraft.advancements.CriterionTrigger;
import net.minecraft.advancements.critereon.PlayerTrigger;
import net.minecraft.core.registries.Registries;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class BagelingCriteriaTriggers {
	public static final DeferredRegister<CriterionTrigger<?>> TRIGGERS = DeferredRegister.create(Registries.TRIGGER_TYPE, Bageling.MOD_ID);
	public static final DeferredHolder<CriterionTrigger<?>, PlayerTrigger> HIT_PLAYER_WITH_BAGEL = TRIGGERS.register("hit__player_with_bagel", PlayerTrigger::new);

	public static Criterion<PlayerTrigger.TriggerInstance> hitPlayerWithBagel() {
			return HIT_PLAYER_WITH_BAGEL.get().createCriterion(new PlayerTrigger.TriggerInstance(Optional.empty()));
	}
}