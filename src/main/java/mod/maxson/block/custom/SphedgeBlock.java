package mod.maxson.block.custom;

import mod.maxson.block.ModBlocks;
import mod.maxson.entity.ModEntities;
import mod.maxson.entity.custom.SphedgeEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.CarvedPumpkinBlock;
import net.minecraft.block.pattern.BlockPattern;
import net.minecraft.block.pattern.BlockPatternBuilder;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class SphedgeBlock extends Block {
    private static final BlockPattern SPHEDGE_PATTERN = BlockPatternBuilder.start()
            .aisle("   ", "~^~", "~#~")
            .where('#', pos -> pos.getBlockState().isOf(ModBlocks.SPHEDGE_LEGS))
            .where('^', pos -> pos.getBlockState().isOf(ModBlocks.SPHEDGE_BLOCK))
            .where('~', pos -> pos.getBlockState().isAir())
            .build();
    private static final EntityType<SphedgeEntity> SPHEDGE_ENTITY = ModEntities.SPHEDGE;

    public SphedgeBlock(Settings settings) {
        super(settings);
    }

    @Override
    public void onPlaced(World world, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack itemStack) {
        if (world.isClient()) return;


        if (state.isOf(ModBlocks.SPHEDGE_BLOCK) && pos.getY() >= world.getBottomY()) {
            var patternSearch = SPHEDGE_PATTERN.searchAround(world, pos);
            if (patternSearch != null) {
                var entityToSpawn = SPHEDGE_ENTITY.create(world);
                if (entityToSpawn != null) {
                    CarvedPumpkinBlock.breakPatternBlocks(world, patternSearch);

                    var blockPos = patternSearch.translate(0, 2, 0).getBlockPos();
                    entityToSpawn.refreshPositionAndAngles(
                            blockPos.getX() + 0.5,
                            blockPos.getY() + 0.55,
                            blockPos.getZ() + 0.5,
                            patternSearch.getForwards().getAxis() == Direction.Axis.X ? 0.0f : 90.0f,
                            0.0f
                    );
                    entityToSpawn.bodyYaw = patternSearch.getForwards().getAxis() == Direction.Axis.X ? 0.0F : 90.0F;

                    world.spawnEntity(entityToSpawn);
                    CarvedPumpkinBlock.updatePatternBlocks(world, patternSearch);
                }
            }
        }
    }
}
