package mod.maxson.entity;

import com.terraformersmc.terraform.boat.api.TerraformBoatType;
import com.terraformersmc.terraform.boat.api.TerraformBoatTypeRegistry;
import com.terraformersmc.terraform.boat.api.item.TerraformBoatItemHelper;
import mod.maxson.block.ModBlocks;
import mod.maxson.item.ModItems;
import mod.maxson.util.ModIdentifier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;

public class ModBoats {
    public static final ModBoat SPHEDGE_BOAT = register("sphedge", ModBlocks.SPHEDGE_PLANKS);

    public static class ModBoat {
        public final ModIdentifier boatId;
        public final ModIdentifier chestBoatId;
        public final RegistryKey<TerraformBoatType> key;

        public final Item boatItem;
        public final Item chestBoatItem;

        public ModBoat(String name) {
            this.boatId = ModIdentifier.of(String.format("%s_boat", name));
            this.chestBoatId = ModIdentifier.of(String.format("%s_chest_boat", name));
            this.key = TerraformBoatTypeRegistry.createKey(this.boatId);

            this.boatItem = TerraformBoatItemHelper.registerBoatItem(this.boatId, this.key, false);
            this.chestBoatItem = TerraformBoatItemHelper.registerBoatItem(this.chestBoatId, this.key, true);
        }
    }

    public static ModBoat register(String name, ItemConvertible planks) {
        var boat = new ModBoat(name);

        Registry.register(TerraformBoatTypeRegistry.INSTANCE, boat.key,
                new TerraformBoatType.Builder()
                        .item(boat.boatItem)
                        .chestItem(boat.chestBoatItem)
                        .planks(planks.asItem())
                        .build());

        return boat;
    }

    public static void initialize() {}
}
