package mod.maxson.datagen.tags;

import mod.maxson.block.ModBlocks;
import mod.maxson.tags.ModBlockTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

public class BlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public BlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(ModBlockTags.SPHEDGE_ORES)
                .add(ModBlocks.SPHEDGE_ORE, ModBlocks.DEEPSLATE_SPHEDGE_ORE);

        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .forceAddTag(ModBlockTags.SPHEDGE_ORES)
                .add(
                        ModBlocks.SPHEDGE_BLOCK,
                        ModBlocks.SPHEDGE_LEGS
                );

        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
                .forceAddTag(ModBlockTags.SPHEDGE_ORES)
                .add(
                        ModBlocks.SPHEDGE_BLOCK,
                        ModBlocks.SPHEDGE_LEGS
                );

        getOrCreateTagBuilder(BlockTags.LOGS_THAT_BURN)
                .add(
                        ModBlocks.SPHEDGE_LOG,
                        ModBlocks.SPHEDGE_WOOD,
                        ModBlocks.STRIPPED_SPHEDGE_LOG,
                        ModBlocks.STRIPPED_SPHEDGE_WOOD
                );

    }
}
