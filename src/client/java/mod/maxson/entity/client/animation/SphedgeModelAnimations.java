package mod.maxson.entity.client.animation;

import net.minecraft.client.render.entity.animation.Animation;
import net.minecraft.client.render.entity.animation.Keyframe;
import net.minecraft.client.render.entity.animation.Transformation;
import org.joml.Vector3f;

public class SphedgeModelAnimations {
	public static final Animation WALK = Animation.Builder.create(0.15f).looping()
			.addBoneAnimation("front_right_leg", new Transformation(Transformation.Targets.ROTATE, 
				new Keyframe(0.0F, new Vector3f(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR), 
				new Keyframe(0.0125F, new Vector3f(-.25F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
				new Keyframe(0.025F, new Vector3f(-.50F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
				new Keyframe(0.0375F, new Vector3f(-.75F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
				new Keyframe(0.05F, new Vector3f(-.50F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
				new Keyframe(0.0625F, new Vector3f(-.25F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
				new Keyframe(0.075F, new Vector3f(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
				new Keyframe(0.0875F, new Vector3f(.25F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
				new Keyframe(0.1F, new Vector3f(.50F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
				new Keyframe(0.1125F, new Vector3f(.75F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
				new Keyframe(0.125F, new Vector3f(.50F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
				new Keyframe(0.1375F, new Vector3f(.25F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
				new Keyframe(0.15F, new Vector3f(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR)
			))
		.addBoneAnimation("front_right_leg", new Transformation(Transformation.Targets.ROTATE,
			new Keyframe(0.0F, new Vector3f(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.0125F, new Vector3f(-.25F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.025F, new Vector3f(-.50F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.0375F, new Vector3f(-.75F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.05F, new Vector3f(-.50F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.0625F, new Vector3f(-.25F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.075F, new Vector3f(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.0875F, new Vector3f(.25F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.1F, new Vector3f(.50F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.1125F, new Vector3f(.75F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.125F, new Vector3f(.50F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.1375F, new Vector3f(.25F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.15F, new Vector3f(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR)
		))
		.addBoneAnimation("front_left_leg", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, new Vector3f(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.0125F, new Vector3f(.25F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.025F, new Vector3f(.50F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.0375F, new Vector3f(.75F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.05F, new Vector3f(.50F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.0625F, new Vector3f(.25F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.075F, new Vector3f(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.0875F, new Vector3f(-.25F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.1F, new Vector3f(-.50F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.1125F, new Vector3f(-.75F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.125F, new Vector3f(-.50F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.1375F, new Vector3f(-.25F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.15F, new Vector3f(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR)
		))
		.addBoneAnimation("back_left_leg", new Transformation(Transformation.Targets.ROTATE,
			new Keyframe(0.0F, new Vector3f(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.0125F, new Vector3f(-.25F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.025F, new Vector3f(-.50F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.0375F, new Vector3f(-.75F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.05F, new Vector3f(-.50F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.0625F, new Vector3f(-.25F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.075F, new Vector3f(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.0875F, new Vector3f(.25F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.1F, new Vector3f(.50F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.1125F, new Vector3f(.75F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.125F, new Vector3f(.50F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.1375F, new Vector3f(.25F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.15F, new Vector3f(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR)
		))
		.addBoneAnimation("back_right_leg", new Transformation(Transformation.Targets.ROTATE,
			new Keyframe(0.0F, new Vector3f(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.0125F, new Vector3f(.25F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.025F, new Vector3f(.50F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.0375F, new Vector3f(.75F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.05F, new Vector3f(.50F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.0625F, new Vector3f(.25F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.075F, new Vector3f(.00F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.0875F, new Vector3f(-.25F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.1F, new Vector3f(-.50F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.1125F, new Vector3f(-.75F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.125F, new Vector3f(-.50F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.1375F, new Vector3f(-.25F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.15F, new Vector3f(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR)
		))
		.build();

	public static final Animation IDLE = Animation.Builder.create(3.3333F).looping()
		.addBoneAnimation("body", new Transformation(Transformation.Targets.SCALE,
			new Keyframe(0.0F, new Vector3f(.10F, .10F, .10F), Transformation.Interpolations.LINEAR),
			new Keyframe(1.6667F, new Vector3f(.105F, .105F, .105F), Transformation.Interpolations.LINEAR),
			new Keyframe(3.3333F, new Vector3f(.10F, .10F, .10F), Transformation.Interpolations.LINEAR)
		))
		.build();
}