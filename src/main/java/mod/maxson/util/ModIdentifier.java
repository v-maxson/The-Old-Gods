package mod.maxson.util;

import mod.maxson.TheOldGods;
import net.minecraft.util.Identifier;
import net.minecraft.util.InvalidIdentifierException;

public class ModIdentifier extends Identifier {
    public ModIdentifier(String id) {
        super(TheOldGods.MOD_ID, id);
    }

    public static Identifier of(String id) {
        return new ModIdentifier(id);
    }
}
