package mod.maxson.tags;

import mod.maxson.TheOldGods;

public class ModTags {
    public static void initialize() {
        TheOldGods.LOGGER.info("Initializing Mod Tags...");

        ModBlockTags.initialize();
        ModItemTags.initialize();
    }
}
