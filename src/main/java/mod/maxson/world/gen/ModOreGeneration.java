package mod.maxson.world.gen;

import mod.maxson.TheOldGods;
import mod.maxson.world.ModPlacedFeatures;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.gen.GenerationStep;

public class ModOreGeneration {
    public static void generate() {
        TheOldGods.LOGGER.info("Generating Ores...");

        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(),
                GenerationStep.Feature.UNDERGROUND_ORES, ModPlacedFeatures.SPHEDGE_ORE_PLACED_KEY);
    }
}
