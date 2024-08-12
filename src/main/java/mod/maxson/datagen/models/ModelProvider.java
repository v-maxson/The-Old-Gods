package mod.maxson.datagen.models;

import mod.maxson.block.ModBlocks;
import mod.maxson.entity.ModBoats;
import mod.maxson.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

public class ModelProvider extends FabricModelProvider {
    public ModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_SPHEDGE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SPHEDGE_BLOCK);
        // Custom Model for ModBlocks.SPHEDGE_LEGS
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SPHEDGE_ORE);

        blockStateModelGenerator.registerLog(ModBlocks.SPHEDGE_LOG)
                .log(ModBlocks.SPHEDGE_LOG)
                .wood(ModBlocks.SPHEDGE_WOOD);
        blockStateModelGenerator.registerLog(ModBlocks.STRIPPED_SPHEDGE_LOG)
                .log(ModBlocks.STRIPPED_SPHEDGE_LOG)
                .wood(ModBlocks.STRIPPED_SPHEDGE_WOOD);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SPHEDGE_LEAVES);
        var sphedge_pool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.SPHEDGE_PLANKS);
        sphedge_pool.family(ModBlocks.SPHEDGE_FAMILY);

        blockStateModelGenerator.registerTintableCross(ModBlocks.SPHEDGE_SAPLING, BlockStateModelGenerator.TintType.NOT_TINTED);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.RAW_SPHEDGE, Models.GENERATED);
        itemModelGenerator.register(ModItems.SPHEDGE_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.SPHEDGE_STICK, Models.GENERATED);
        itemModelGenerator.register(ModItems.SPHEDGE_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.SPHEDGE_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.SPHEDGE_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.SPHEDGE_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.SPHEDGE_HOE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.SPHEDGE_HANGING_SIGN, Models.GENERATED);
        itemModelGenerator.register(ModBoats.SPHEDGE_BOAT.boatItem, Models.GENERATED);
        itemModelGenerator.register(ModBoats.SPHEDGE_BOAT.chestBoatItem, Models.GENERATED);
    }
}
