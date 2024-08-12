package mod.maxson.world.tree;

import mod.maxson.world.ModConfiguredFeatures;
import net.minecraft.block.SaplingGenerator;

import java.util.Optional;

public class ModSaplingGenerators {
    public static final SaplingGenerator SPHEDGE =
            new SaplingGenerator(
                    "sphedge",
                    0f,
                    Optional.empty(),
                    Optional.empty(),
                    Optional.of(ModConfiguredFeatures.SPHEDGE_TREE_KEY),
                    Optional.empty(),
                    Optional.empty(),
                    Optional.empty());
}
