package mod.maxson.entity.custom;

import mod.maxson.TheOldGods;
import mod.maxson.entity.ModEntities;
import mod.maxson.entity.goal.PoopGoal;
import mod.maxson.item.ModItems;
import mod.maxson.sound.ModSoundEvents;
import net.minecraft.block.BlockState;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.recipe.Ingredient;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class SphedgeEntity extends AnimalEntity {
    public static final int DEFAULT_SIZE = 9;
    public static final int HEALTH_PER_SIZE = 15;
    public static final float SIZE_SCALE_FACTOR = 0.1111111111111111f;
    public static final int MAX_HEALTH = (HEALTH_PER_SIZE * DEFAULT_SIZE) * 3;
    public static final TrackedData<Integer> SIZE = DataTracker.registerData(SphedgeEntity.class, TrackedDataHandlerRegistry.INTEGER);
    public static final Item FOOD_ITEM = ModItems.SPHEDGE_INGOT;

    public final AnimationState idlingAnimationState = new AnimationState();
    private int idleAnimationCooldown = 0;

    public SphedgeEntity(EntityType<? extends AnimalEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    protected void initDataTracker() {
        super.initDataTracker();
        this.dataTracker.startTracking(SIZE, DEFAULT_SIZE);
    }

    public int size() {
        return this.dataTracker.get(SIZE);
    }

    public void size(int newSize) {
        this.dataTracker.set(SIZE, newSize);
    }

    private void updateAnimations() {
        if (this.idleAnimationCooldown <= 0) {
            this.idleAnimationCooldown = this.random.nextInt(40) + 80;
            this.idlingAnimationState.start(this.age);
        } else {
            this.idleAnimationCooldown--;
        }
    }

    @Override
    protected void updateLimbs(float posDelta) {
        float f;
        if (this.getPose() == EntityPose.STANDING) {
            f = Math.min(posDelta * 6.0F, 1.0F);
        } else {
            f = 0.0F;
        }

        this.limbAnimator.updateLimbs(f, 0.2F);
    }

    @Override
    public void tick() {
        super.tick();
        if (this.getWorld().isClient()) {
            this.updateAnimations();
        }
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(0, new SwimGoal(this));
        this.goalSelector.add(1, new EscapeDangerGoal(this, 3.0f));
        this.goalSelector.add(3, new TemptGoal(this, 6.0f, Ingredient.ofItems(FOOD_ITEM), false));
        this.goalSelector.add(3, new WanderAroundFarGoal(this, 1.0f));
        this.goalSelector.add(4, new LookAtEntityGoal(this, PlayerEntity.class, 6.0f));
        this.goalSelector.add(5, new LookAroundGoal(this));
        this.goalSelector.add(6, new PoopGoal(this));
    }

    public static DefaultAttributeContainer.Builder createSphedgeAttributes() {
        return DefaultAttributeContainer.builder()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, MAX_HEALTH)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.1f)
                .add(EntityAttributes.GENERIC_ARMOR, 0.5f)
                .add(EntityAttributes.GENERIC_ARMOR_TOUGHNESS, 0.1f)
                .add(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE, 0.0f)
                .add(EntityAttributes.GENERIC_MAX_ABSORPTION, 1.0f)
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 10f);
    }

    @Override
    public ActionResult interactMob(PlayerEntity player, Hand hand) {
        if (!player.getWorld().isClient())  {
            ItemStack itemStack = player.getStackInHand(hand);
            if (itemStack.isOf(FOOD_ITEM)) {
                this.size(this.size() + 1);
                this.setHealth(SphedgeEntity.HEALTH_PER_SIZE * this.size());
                if (!player.getAbilities().creativeMode) {
                    itemStack.decrement(1);
                }
                return ActionResult.PASS;
            }
        }

        return ActionResult.FAIL;
    }

    @Override
    public EntityData initialize(ServerWorldAccess world, LocalDifficulty difficulty, SpawnReason spawnReason, @Nullable EntityData entityData, @Nullable NbtCompound entityNbt) {
        var data = super.initialize(world, difficulty, spawnReason, entityData, entityNbt);
        this.setHealth(SphedgeEntity.HEALTH_PER_SIZE * this.size());
        return data;
    }

    @Override
    protected void playStepSound(BlockPos pos, BlockState state) {
        this.playSound(ModSoundEvents.SPHEDGE_WALK, 0.5f, 1);
    }

    @Nullable
    @Override
    public PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
        var entityToCreate = ModEntities.SPHEDGE.create(world);
        if (entityToCreate != null) entityToCreate.setHealth(HEALTH_PER_SIZE * this.size());

        return entityToCreate;
    }
}
