package com.cookiejar.bageling.core.other;

import com.cookiejar.bageling.core.Bageling;
import com.cookiejar.bageling.core.registry.BagelingEntityTypes;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;

@EventBusSubscriber(modid = Bageling.MOD_ID, value = Dist.CLIENT)
public class BagelingClientCompat {
	@SubscribeEvent
	public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(BagelingEntityTypes.SPIDERMANS_BAGEL.get(), ThrownItemRenderer::new);
	}
}