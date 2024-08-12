package mod.maxson.datagen.tags;

import mod.maxson.block.ModBlocks;
import mod.maxson.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

public class ItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(ItemTags.PICKAXES)
                .add(ModItems.SPHEDGE_PICKAXE);

        getOrCreateTagBuilder(ItemTags.AXES)
                .add(ModItems.SPHEDGE_AXE);

        getOrCreateTagBuilder(ItemTags.SWORDS)
                .add(ModItems.SPHEDGE_SWORD);

        getOrCreateTagBuilder(ItemTags.SHOVELS)
                .add(ModItems.SPHEDGE_SHOVEL);

        getOrCreateTagBuilder(ItemTags.HOES)
                .add(ModItems.SPHEDGE_HOE);

        getOrCreateTagBuilder(ItemTags.PLANKS)
                .add(ModBlocks.SPHEDGE_PLANKS.asItem());

        getOrCreateTagBuilder(ItemTags.LOGS_THAT_BURN)
                .add(
                    ModBlocks.SPHEDGE_LOG.asItem(),
                    ModBlocks.SPHEDGE_WOOD.asItem(),
                    ModBlocks.STRIPPED_SPHEDGE_LOG.asItem(),
                    ModBlocks.STRIPPED_SPHEDGE_WOOD.asItem()
                );
    }
}
