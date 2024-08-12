package mod.maxson.sound;

import mod.maxson.TheOldGods;
import mod.maxson.util.ModIdentifier;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;

public class ModSoundEvents {
    public static final SoundEvent SPHEDGE_WALK = register("sphedge_walk");

    public static SoundEvent register(String name) {
        var id = ModIdentifier.of(name);
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }

    public static void initialize() {
        TheOldGods.LOGGER.info("Initializing Sound Events...");
    }
}
