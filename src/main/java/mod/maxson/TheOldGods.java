package mod.maxson;

import mod.maxson.block.ModBlocks;
import mod.maxson.entity.ModEntities;
import mod.maxson.item.ModItemGroups;
import mod.maxson.item.ModItems;
import mod.maxson.sound.ModSoundEvents;
import mod.maxson.tags.ModTags;
import mod.maxson.world.gen.ModWorldGeneration;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TheOldGods implements ModInitializer {
	public static final String MOD_ID = "the-old-gods";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		// Blocks and Items First
		ModBlocks.initialize();
		ModItems.initialize();

		ModEntities.initialize();
		ModItemGroups.initialize();
		ModSoundEvents.initialize();
		ModTags.initialize();
		ModWorldGeneration.generate();
	}
}