package mod.maxson.entity.client;

import mod.maxson.entity.custom.SphedgeEntity;
import mod.maxson.util.ModIdentifier;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class SphedgeRenderer extends MobEntityRenderer<SphedgeEntity, SphedgeModel<SphedgeEntity>> {
    private static final Identifier TEXTURE = ModIdentifier.of("textures/entity/sphedge.png");

    public SphedgeRenderer(EntityRendererFactory.Context context) {
        super(context, new SphedgeModel<>(context.getPart(ModModelLayers.SPHEDGE)), 0.6f);
    }

    @Override
    public Identifier getTexture(SphedgeEntity entity) {
        return TEXTURE;
    }

    @Override
    public void render(SphedgeEntity mobEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        var scale = mobEntity.size() * SphedgeEntity.SIZE_SCALE_FACTOR;
        matrixStack.scale(scale, scale, scale);

        super.render(mobEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}
