package mod.maxson.tags;

import mod.maxson.util.ModIdentifier;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;

public class ModItemTags {
    private static TagKey<Item> register(String name) {
        return TagKey.of(RegistryKeys.ITEM, ModIdentifier.of(name));
    }

    public static void initialize() {}
}
