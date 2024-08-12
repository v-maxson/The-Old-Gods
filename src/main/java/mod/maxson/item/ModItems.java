package mod.maxson.item;

import com.terraformersmc.terraform.boat.api.item.TerraformBoatItemHelper;
import mod.maxson.TheOldGods;
import mod.maxson.block.ModBlocks;
import mod.maxson.entity.ModBoats;
import mod.maxson.item.materials.ModToolMaterials;
import mod.maxson.util.ModIdentifier;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.HangingSignItem;
import net.minecraft.item.Item;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.SignItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item RAW_SPHEDGE = register("raw_sphedge", new Item(new FabricItemSettings()));
    public static final Item SPHEDGE_INGOT = register("sphedge_ingot", new Item(new FabricItemSettings()));
    public static final Item SPHEDGE_STICK = register("sphedge_stick", new Item(new FabricItemSettings()));

    // Sphedge Tools
    public static final Item SPHEDGE_PICKAXE = register("sphedge_pickaxe", new PickaxeItem(ModToolMaterials.SPHEDGE, 0, 1.0f, new FabricItemSettings()));
    public static final Item SPHEDGE_AXE = register("sphedge_axe", new PickaxeItem(ModToolMaterials.SPHEDGE, 0, 1.0f, new FabricItemSettings()));
    public static final Item SPHEDGE_SWORD = register("sphedge_sword", new PickaxeItem(ModToolMaterials.SPHEDGE, 0, 1.0f, new FabricItemSettings()));
    public static final Item SPHEDGE_SHOVEL = register("sphedge_shovel", new PickaxeItem(ModToolMaterials.SPHEDGE, 0, 1.0f, new FabricItemSettings()));
    public static final Item SPHEDGE_HOE = register("sphedge_hoe", new PickaxeItem(ModToolMaterials.SPHEDGE, 0, 1.0f, new FabricItemSettings()));

    // Sphedge Signs
    public static final Item SPHEDGE_SIGN = register("sphedge_sign",
        new SignItem(new FabricItemSettings().maxCount(16), ModBlocks.SPHEDGE_STANDING_SIGN, ModBlocks.SPHEDGE_WALL_SIGN));
    public static final Item SPHEDGE_HANGING_SIGN = register("sphedge_hanging_sign",
            new HangingSignItem(ModBlocks.SPHEDGE_HANGING_SIGN, ModBlocks.SPHEDGE_HANGING_WALL_SIGN, new FabricItemSettings().maxCount(16))); // ????

    private static Item register(String name, Item item) {
        return Registry.register(Registries.ITEM, ModIdentifier.of(name), item);
    }

    public static void initialize() {
        TheOldGods.LOGGER.info("Initializing Mod Items...");
    }
}
