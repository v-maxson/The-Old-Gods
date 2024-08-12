package mod.maxson.datagen;

import mod.maxson.datagen.lang.EnglishLanguageProvider;
import mod.maxson.datagen.loot_table.BlockLootTableProvider;
import mod.maxson.datagen.models.ModelProvider;
import mod.maxson.datagen.recipe.RecipeProvider;
import mod.maxson.datagen.tags.BlockTagProvider;
import mod.maxson.datagen.tags.ItemTagProvider;
import mod.maxson.datagen.world.WorldGenerationProvider;
import mod.maxson.world.ModConfiguredFeatures;
import mod.maxson.world.ModPlacedFeatures;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.registry.RegistryBuilder;
import net.minecraft.registry.RegistryKeys;

public class TheOldGodsDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		var pack = fabricDataGenerator.createPack();

		// Language Provider(s)
		pack.addProvider(EnglishLanguageProvider::new);

		// Loot Table Provider(s)
		pack.addProvider(BlockLootTableProvider::new);

		// Model Provider(s)
		pack.addProvider(ModelProvider::new);

		// Recipe Provider(s)
		pack.addProvider(RecipeProvider::new);

		// Tag Provider(s)
		pack.addProvider(BlockTagProvider::new);
		pack.addProvider(ItemTagProvider::new);

		// World Gen
		pack.addProvider(WorldGenerationProvider::new);
	}

	@Override
	public void buildRegistry(RegistryBuilder registryBuilder) {
		registryBuilder.addRegistry(RegistryKeys.CONFIGURED_FEATURE, ModConfiguredFeatures::bootstrap);
		registryBuilder.addRegistry(RegistryKeys.PLACED_FEATURE, ModPlacedFeatures::boostrap);
	}
}
