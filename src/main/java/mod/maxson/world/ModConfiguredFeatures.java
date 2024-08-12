package mod.maxson.world;

import mod.maxson.block.ModBlocks;
import mod.maxson.util.ModIdentifier;
import mod.maxson.world.tree.ModTreeConfiguredFeatures;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.BlockMatchRuleTest;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.world.gen.feature.*;

import java.util.List;

public class ModConfiguredFeatures {
    // Ores
    public static final RegistryKey<ConfiguredFeature<?, ?>> SPHEDGE_ORE_KEY = registerKey("sphedge_ore");

    // Trees
    public static final RegistryKey<ConfiguredFeature<?, ?>> SPHEDGE_TREE_KEY = registerKey("sphedge");

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {
        // Ores
        RuleTest stoneReplaceables = new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceables = new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);

        // Unused (for now)
        RuleTest netherReplaceables = new TagMatchRuleTest(BlockTags.BASE_STONE_NETHER);
        RuleTest endReplaceables = new BlockMatchRuleTest(Blocks.END_STONE);

        var overworldSphedgeOres = List.of(
                OreFeatureConfig.createTarget(stoneReplaceables, ModBlocks.SPHEDGE_ORE.getDefaultState()),
                OreFeatureConfig.createTarget(deepslateReplaceables, ModBlocks.DEEPSLATE_SPHEDGE_ORE.getDefaultState())
        );

        register(context, SPHEDGE_ORE_KEY, Feature.ORE, new OreFeatureConfig(overworldSphedgeOres, 12));

        // Trees
        register(context, SPHEDGE_TREE_KEY, Feature.TREE, ModTreeConfiguredFeatures.SPHEDGE_TREE_FEATURE);
    }

    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, ModIdentifier.of(name));
    }

    public static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                  RegistryKey<ConfiguredFeature<?, ?>> key,
                                                                                  F feature,
                                                                                  FC featureConfig) {
        context.register(key, new ConfiguredFeature<>(feature, featureConfig));
    }
}
