package mod.maxson.block;

import com.terraformersmc.terraform.sign.block.TerraformHangingSignBlock;
import com.terraformersmc.terraform.sign.block.TerraformSignBlock;
import com.terraformersmc.terraform.sign.block.TerraformWallHangingSignBlock;
import com.terraformersmc.terraform.sign.block.TerraformWallSignBlock;
import mod.maxson.TheOldGods;
import mod.maxson.block.custom.SphedgeBlock;
import mod.maxson.block.custom.SphedgeLegsBlock;
import mod.maxson.util.ModIdentifier;
import mod.maxson.world.tree.ModSaplingGenerators;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.minecraft.block.*;
import net.minecraft.data.family.BlockFamilies;
import net.minecraft.data.family.BlockFamily;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class ModBlocks {
    public static final Block DEEPSLATE_SPHEDGE_ORE = register("deepslate_sphedge_ore",
            new Block(FabricBlockSettings.copy(Blocks.DEEPSLATE_IRON_ORE)));
    public static final Block SPHEDGE_BLOCK = register("sphedge_block",
            new SphedgeBlock(FabricBlockSettings.copy(Blocks.IRON_BLOCK)));
    public static final Block SPHEDGE_LEGS = register("sphedge_legs",
            new SphedgeLegsBlock(FabricBlockSettings.copy(SPHEDGE_BLOCK).nonOpaque()));
    public static final Block SPHEDGE_ORE = register("sphedge_ore",
            new Block(FabricBlockSettings.copy(Blocks.IRON_ORE)));
    public static final Block SPHEDGE_GRASS_BLOCK = register("sphedge_grass_block", new GrassBlock(FabricBlockSettings.copy(Blocks.GRASS_BLOCK)));
    public static final Block SPHEDGE_DIRT = register("sphedge_dirt", new Block(FabricBlockSettings.copy(Blocks.DIRT)));

    public static final Block SPHEDGE_LOG = register("sphedge_log",
            new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_LOG)));
    public static final Block SPHEDGE_WOOD = register("sphedge_wood",
            new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_WOOD)));
    public static final Block STRIPPED_SPHEDGE_LOG = register("stripped_sphedge_log",
            new PillarBlock(FabricBlockSettings.copy(Blocks.STRIPPED_OAK_LOG)));
    public static final Block STRIPPED_SPHEDGE_WOOD = register("stripped_sphedge_wood",
            new PillarBlock(FabricBlockSettings.copy(Blocks.STRIPPED_OAK_WOOD)));
    public static final Block SPHEDGE_PLANKS = register("sphedge_planks",
            new Block(FabricBlockSettings.copy(Blocks.OAK_PLANKS)));
    public static final Block SPHEDGE_LEAVES = register("sphedge_leaves",
            new LeavesBlock(FabricBlockSettings.copy(Blocks.OAK_LEAVES).nonOpaque()));

    public static final ModIdentifier SPHEDGE_SIGN_TEXTURE = ModIdentifier.of("entity/signs/sphedge");
    public static final ModIdentifier SPHEDGE_HANGING_SIGN_TEXTURE = ModIdentifier.of("entity/signs/hanging/sphedge");
    public static final ModIdentifier SPHEDGE_HANGING_GUI_SIGN_TEXTURE = ModIdentifier.of("textures/gui/hanging_signs/sphedge");

    public static final Block SPHEDGE_STANDING_SIGN = registerBlock("sphedge_standing_sign",
            new TerraformSignBlock(SPHEDGE_SIGN_TEXTURE, FabricBlockSettings.copy(Blocks.OAK_SIGN)));
    public static final Block SPHEDGE_WALL_SIGN = registerBlock("sphedge_wall_sign",
            new TerraformWallSignBlock(SPHEDGE_SIGN_TEXTURE, FabricBlockSettings.copy(Blocks.OAK_SIGN)));
    public static final Block SPHEDGE_HANGING_SIGN = registerBlock("sphedge_hanging_sign",
            new TerraformHangingSignBlock(SPHEDGE_HANGING_SIGN_TEXTURE, SPHEDGE_HANGING_GUI_SIGN_TEXTURE, FabricBlockSettings.copy(Blocks.OAK_SIGN)));
    public static final Block SPHEDGE_HANGING_WALL_SIGN = registerBlock("sphedge_hanging_wall_sign",
            new TerraformWallHangingSignBlock(SPHEDGE_HANGING_SIGN_TEXTURE, SPHEDGE_HANGING_GUI_SIGN_TEXTURE, FabricBlockSettings.copy(Blocks.OAK_SIGN)));

    public static final BlockFamily SPHEDGE_FAMILY = BlockFamilies.register(ModBlocks.SPHEDGE_PLANKS)
            .sign(ModBlocks.SPHEDGE_STANDING_SIGN, ModBlocks.SPHEDGE_WALL_SIGN)
            .group("wooden")
            .unlockCriterionName("has_planks")
            .build();

    // Sphedge Sapling
    public static final Block SPHEDGE_SAPLING = register("sphedge_sapling",
            new SaplingBlock(ModSaplingGenerators.SPHEDGE, FabricBlockSettings.copy(Blocks.OAK_SAPLING)));

    private static Block register(String name, Block block) {
        registerItem(name, block);
        return registerBlock(name, block);
    }

    private static Block registerBlock(String name, Block block) {
        return Registry.register(Registries.BLOCK, ModIdentifier.of(name), block);
    }

    private static void registerItem(String name, Block block) {
        Registry.register(Registries.ITEM, ModIdentifier.of(name), new BlockItem(block, new Item.Settings()));
    }

    public static void initialize() {
        TheOldGods.LOGGER.info("Initializing Mod Blocks...");

        // Strippable and Flammable
        StrippableBlockRegistry.register(ModBlocks.SPHEDGE_LOG, ModBlocks.STRIPPED_SPHEDGE_LOG);
        StrippableBlockRegistry.register(ModBlocks.SPHEDGE_WOOD, ModBlocks.STRIPPED_SPHEDGE_WOOD);

        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.SPHEDGE_LOG, 5 ,5);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.SPHEDGE_WOOD, 5 ,5);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.STRIPPED_SPHEDGE_LOG, 5 ,5);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.STRIPPED_SPHEDGE_WOOD, 5 ,5);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.SPHEDGE_PLANKS, 5 ,20);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.SPHEDGE_LEAVES, 30 ,60);
    }
}
