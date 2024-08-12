package mod.maxson.datagen.loot_table;

import mod.maxson.block.ModBlocks;
import mod.maxson.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;

public class BlockLootTableProvider extends FabricBlockLootTableProvider {
    public BlockLootTableProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    public LootTable.Builder sphedgeOreDrops(Block drop) {
        return dropsWithSilkTouch(
                drop,
                applyExplosionDecay(
                        drop,
                        ItemEntry.builder(ModItems.RAW_SPHEDGE)
                                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2.0F, 4.0F)))
                                .apply(ApplyBonusLootFunction.oreDrops(Enchantments.FORTUNE))
                )
        );
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.DEEPSLATE_SPHEDGE_ORE, sphedgeOreDrops(ModBlocks.DEEPSLATE_SPHEDGE_ORE));
        addDrop(ModBlocks.SPHEDGE_BLOCK);
        addDrop(ModBlocks.SPHEDGE_LEGS);
        addDrop(ModBlocks.SPHEDGE_ORE, sphedgeOreDrops(ModBlocks.SPHEDGE_ORE));
        addDrop(ModBlocks.SPHEDGE_LOG);
        addDrop(ModBlocks.SPHEDGE_WOOD);
        addDrop(ModBlocks.STRIPPED_SPHEDGE_LOG);
        addDrop(ModBlocks.STRIPPED_SPHEDGE_WOOD);
        addDrop(ModBlocks.SPHEDGE_PLANKS);
        addDrop(ModBlocks.SPHEDGE_LEAVES, leavesDrops(ModBlocks.SPHEDGE_LEAVES, ModBlocks.SPHEDGE_LEAVES, 0.005F, 0.0055555557F, 0.00625F, 0.008333334F, 0.025F)); // TODO ADD SAPLING
        addDrop(ModBlocks.SPHEDGE_STANDING_SIGN);
        addDrop(ModBlocks.SPHEDGE_WALL_SIGN);
        addDrop(ModBlocks.SPHEDGE_HANGING_SIGN);
        addDrop(ModBlocks.SPHEDGE_HANGING_WALL_SIGN);
        addDrop(ModBlocks.SPHEDGE_GRASS_BLOCK, ModBlocks.SPHEDGE_DIRT);
        addDrop(ModBlocks.SPHEDGE_DIRT);
    }
}
