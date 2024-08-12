package mod.maxson.world.tree;

import mod.maxson.block.ModBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.BlobFoliagePlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;

public class ModTreeConfiguredFeatures {
    // Values identical to oak.
    public static final TreeFeatureConfig SPHEDGE_TREE_FEATURE = new TreeFeatureConfig.Builder(
            BlockStateProvider.of(ModBlocks.SPHEDGE_LOG),
            new StraightTrunkPlacer(4, 2, 0),

            BlockStateProvider.of(Blocks.OAK_LEAVES),
            new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 3),

            new TwoLayersFeatureSize(1, 0, 1))
            .build();
}
