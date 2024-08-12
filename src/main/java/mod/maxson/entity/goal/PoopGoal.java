package mod.maxson.entity.goal;

import mod.maxson.entity.custom.SphedgeEntity;
import mod.maxson.item.ModItems;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.item.ItemStack;

public class PoopGoal extends Goal {
    private static final float CHANCE = 0.002f;
    private final SphedgeEntity sphedgeEntity;

    public PoopGoal(SphedgeEntity sphedgeEntity) {
        this.sphedgeEntity = sphedgeEntity;
    }

    @Override
    public boolean canStart() {
        return !(this.sphedgeEntity.getRandom().nextFloat() >= CHANCE);
    }

    @Override
    public void start() {
//        if (this.sphedgeEntity.getRandom().nextFloat() <= CHANCE) return;

        if (this.sphedgeEntity.size() > 0) {
            var mobEntityPos = this.sphedgeEntity.getPos();
            var world = this.sphedgeEntity.getWorld();

            world.spawnEntity(new ItemEntity(world, mobEntityPos.getX() + -0.5, mobEntityPos.getY() + 1.0f, mobEntityPos.getZ(), new ItemStack(ModItems.RAW_SPHEDGE), -(world.random.nextDouble() * 0.2 - 0.1), 0, 0));
            this.sphedgeEntity.size(this.sphedgeEntity.size() - 1);
            this.sphedgeEntity.setHealth(SphedgeEntity.HEALTH_PER_SIZE * this.sphedgeEntity.size());
        } else {
            this.sphedgeEntity.kill();
        }
    }
}
