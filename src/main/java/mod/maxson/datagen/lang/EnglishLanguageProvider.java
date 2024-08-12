package mod.maxson.datagen.lang;

import mod.maxson.block.ModBlocks;
import mod.maxson.entity.ModBoats;
import mod.maxson.entity.ModEntities;
import mod.maxson.item.ModItemGroups;
import mod.maxson.item.ModItems;
import mod.maxson.sound.ModSoundEvents;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;

public class EnglishLanguageProvider extends FabricLanguageProvider {
    public EnglishLanguageProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generateTranslations(TranslationBuilder translationBuilder) {
        // Blocks
        translationBuilder.add(ModBlocks.DEEPSLATE_SPHEDGE_ORE, "Deepslate Sphedge Ore");
        translationBuilder.add(ModBlocks.SPHEDGE_BLOCK, "Sphedge Block");
        translationBuilder.add(ModBlocks.SPHEDGE_LEGS, "Sphedge Legs");
        translationBuilder.add(ModBlocks.SPHEDGE_ORE, "Sphedge Ore");
        translationBuilder.add(ModBlocks.SPHEDGE_LOG, "Sphedge Log");
        translationBuilder.add(ModBlocks.SPHEDGE_WOOD, "Sphedge Wood");
        translationBuilder.add(ModBlocks.STRIPPED_SPHEDGE_LOG, "Stripped Sphedge Log");
        translationBuilder.add(ModBlocks.STRIPPED_SPHEDGE_WOOD, "Stripped Sphedge Wood");
        translationBuilder.add(ModBlocks.SPHEDGE_PLANKS, "Sphedge Planks");
        translationBuilder.add(ModBlocks.SPHEDGE_LEAVES, "Sphedge Leaves");
//        translationBuilder.add(ModBlocks.SPHEDGE_STANDING_SIGN, "Sphedge Standing Sign");
        translationBuilder.add(ModBlocks.SPHEDGE_WALL_SIGN, "Sphedge Sign");
//        translationBuilder.add(ModBlocks.SPHEDGE_HANGING_SIGN, "Sphedge Hanging Sign");
        translationBuilder.add(ModBlocks.SPHEDGE_HANGING_WALL_SIGN, "Sphedge Hanging Sign");
        translationBuilder.add(ModBlocks.SPHEDGE_SAPLING, "Sphedge Sapling");

        // Ingredients
        translationBuilder.add(ModItems.RAW_SPHEDGE, "Raw Sphedge");
        translationBuilder.add(ModItems.SPHEDGE_INGOT, "Sphedge Ingot");
        translationBuilder.add(ModItems.SPHEDGE_STICK, "Sphedge Stick");

        // Tools
        translationBuilder.add(ModItems.SPHEDGE_PICKAXE, "Sphedge Pickaxe");
        translationBuilder.add(ModItems.SPHEDGE_AXE, "Sphedge Axe");
        translationBuilder.add(ModItems.SPHEDGE_SWORD, "Sphedge Sword");
        translationBuilder.add(ModItems.SPHEDGE_SHOVEL, "Sphedge Shovel");
        translationBuilder.add(ModItems.SPHEDGE_HOE, "Sphedge Hoe");

        // Boats
        translationBuilder.add(ModBoats.SPHEDGE_BOAT.boatItem, "Sphedge Boat");
        translationBuilder.add(ModBoats.SPHEDGE_BOAT.chestBoatItem, "Sphedge Chest Boat");

        // Entities
        translationBuilder.add(ModEntities.SPHEDGE.getTranslationKey(), "Sphedge");

        // Item Groups
        translationBuilder.add(ModItemGroups.getGroupKey(ModItemGroups.BLOCKS), "The Old Gods: Blocks");
        translationBuilder.add(ModItemGroups.getGroupKey(ModItemGroups.INGREDIENTS), "The Old Gods: Ingredients");
        translationBuilder.add(ModItemGroups.getGroupKey(ModItemGroups.TOOLS), "The Old Gods: Tools");

        // Sounds
        translationBuilder.add(ModSoundEvents.SPHEDGE_WALK.getId().toTranslationKey("sounds"), "Sphedge Walking...");
    }
}
