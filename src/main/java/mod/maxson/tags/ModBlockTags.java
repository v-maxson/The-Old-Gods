package mod.maxson.tags;

import mod.maxson.util.ModIdentifier;
import net.minecraft.block.Block;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;

public class ModBlockTags {
    public static final TagKey<Block> SPHEDGE_ORES = register("sphedge_ores");

    private static TagKey<Block> register(String name) {
        return TagKey.of(RegistryKeys.BLOCK, ModIdentifier.of(name));
    }

    public static void initialize() {}
}
