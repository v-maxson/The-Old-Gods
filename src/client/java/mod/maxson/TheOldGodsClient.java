package mod.maxson;

import com.terraformersmc.terraform.boat.api.client.TerraformBoatClientHelper;
import com.terraformersmc.terraform.sign.SpriteIdentifierRegistry;
import mod.maxson.block.ModBlocks;
import mod.maxson.entity.ModBoats;
import mod.maxson.entity.ModEntities;
import mod.maxson.entity.client.ModModelLayers;
import mod.maxson.entity.client.SphedgeModel;
import mod.maxson.entity.client.SphedgeRenderer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.TexturedRenderLayers;
import net.minecraft.client.util.SpriteIdentifier;

public class TheOldGodsClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		// Block Render Layers
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.SPHEDGE_LEAVES, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.SPHEDGE_SAPLING, RenderLayer.getCutout());

		// Entity Model Layers
		EntityModelLayerRegistry.registerModelLayer(ModModelLayers.SPHEDGE, SphedgeModel::getTexturedModelData);

		// Entity Renderers
		EntityRendererRegistry.register(ModEntities.SPHEDGE, SphedgeRenderer::new);

		// Terraformers API
		SpriteIdentifierRegistry.INSTANCE.addIdentifier(new SpriteIdentifier(TexturedRenderLayers.SIGNS_ATLAS_TEXTURE, ModBlocks.SPHEDGE_SIGN_TEXTURE));
		SpriteIdentifierRegistry.INSTANCE.addIdentifier(new SpriteIdentifier(TexturedRenderLayers.SIGNS_ATLAS_TEXTURE, ModBlocks.SPHEDGE_HANGING_SIGN_TEXTURE));

		TerraformBoatClientHelper.registerModelLayers(ModBoats.SPHEDGE_BOAT.boatId, false);
	}
}