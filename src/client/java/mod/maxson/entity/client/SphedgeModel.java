package mod.maxson.entity.client;


import mod.maxson.TheOldGods;
import mod.maxson.entity.client.animation.SphedgeModelAnimations;
import mod.maxson.entity.custom.SphedgeEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;

public class SphedgeModel<T extends SphedgeEntity> extends SinglePartEntityModel<T> {
	public final ModelPart sphedge;
	public final ModelPart head;

	public SphedgeModel(ModelPart root) {
		this.sphedge = root.getChild("sphedge");
		this.head = root.getChild("sphedge").getChild("head");
	}

	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData sphedge = modelPartData.addChild("sphedge", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));
		ModelPartData front_right_leg = sphedge.addChild("front_right_leg", ModelPartBuilder.create().uv(4, 64).cuboid(-0.5F, -1.0F, -1.5F, 1.0F, 17.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(-4.0F, -16.0F, -4.0F));
		ModelPartData front_left_leg = sphedge.addChild("front_left_leg", ModelPartBuilder.create().uv(12, 64).cuboid(-0.5F, -1.0F, -1.5F, 1.0F, 17.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(4.0F, -16.0F, -4.0F));
		ModelPartData back_left_leg = sphedge.addChild("back_left_leg", ModelPartBuilder.create().uv(0, 64).cuboid(-0.5F, -1.0F, -1.5F, 1.0F, 17.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(6.0F, -16.0F, 6.0F));
		ModelPartData back_right_leg = sphedge.addChild("back_right_leg", ModelPartBuilder.create().uv(8, 64).cuboid(-0.5F, -1.0F, -1.5F, 1.0F, 17.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(-6.0F, -16.0F, 6.0F));
		ModelPartData body = sphedge.addChild("body", ModelPartBuilder.create().uv(0, 32).cuboid(-8.0F, -8.0F, -8.0F, 16.0F, 16.0F, 16.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -24.0F, 0.0F));
		ModelPartData head = sphedge.addChild("head", ModelPartBuilder.create().uv(0, 0).cuboid(-8.0F, -9.0F, -11.0F, 16.0F, 16.0F, 16.0F, new Dilation(-5.0F)), ModelTransform.pivot(0.0F, -19.0F, -6.0F));
		return TexturedModelData.of(modelData, 96, 96);
	}
	@Override
	public void setAngles(SphedgeEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.getPart().traverse().forEach(ModelPart::resetTransform);
		this.setHeadAngles(netHeadYaw, headPitch);
		this.animateMovement(SphedgeModelAnimations.WALK, limbSwing, limbSwingAmount, 1f, 1f);
		this.updateAnimation(entity.idlingAnimationState, SphedgeModelAnimations.IDLE, ageInTicks, 5);
	}

	private void setHeadAngles(float headYaw, float headPitch) {
		this.head.yaw = MathHelper.clamp(headYaw, -.425f, .425f);
		this.head.pitch = MathHelper.clamp(headPitch, -.20f, .375f);
	}

	@Override
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		sphedge.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
	}
	@Override
	public ModelPart getPart() {
		return sphedge;
	}
}