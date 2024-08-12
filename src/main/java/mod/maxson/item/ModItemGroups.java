package mod.maxson.item;

import mod.maxson.TheOldGods;
import mod.maxson.block.ModBlocks;
import mod.maxson.entity.ModBoats;
import mod.maxson.util.ModIdentifier;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableTextContent;

public class ModItemGroups {
    public static final ItemGroup BLOCKS = register("blocks", ModBlocks.SPHEDGE_ORE, (((displayContext, entries) -> {
        entries.add(ModBlocks.DEEPSLATE_SPHEDGE_ORE);
        entries.add(ModBlocks.SPHEDGE_ORE);
        entries.add(ModBlocks.SPHEDGE_BLOCK);
        entries.add(ModBlocks.SPHEDGE_LEGS);
        entries.add(ModBlocks.SPHEDGE_GRASS_BLOCK);
        entries.add(ModBlocks.SPHEDGE_DIRT);

        entries.add(ModBlocks.SPHEDGE_LOG);
        entries.add(ModBlocks.SPHEDGE_WOOD);
        entries.add(ModBlocks.STRIPPED_SPHEDGE_LOG);
        entries.add(ModBlocks.STRIPPED_SPHEDGE_WOOD);
        entries.add(ModBlocks.SPHEDGE_PLANKS);
        entries.add(ModBlocks.SPHEDGE_LEAVES);

        entries.add(ModItems.SPHEDGE_SIGN);
        entries.add(ModItems.SPHEDGE_HANGING_SIGN);

        entries.add(ModBlocks.SPHEDGE_SAPLING);
    })));

    public static final ItemGroup INGREDIENTS = register("ingredients", ModItems.SPHEDGE_INGOT, ((displayContext, entries) -> {
        entries.add(ModItems.RAW_SPHEDGE);
        entries.add(ModItems.SPHEDGE_INGOT);
        entries.add(ModItems.SPHEDGE_STICK);
    }));

    public static final ItemGroup TOOLS = register("mod_tools", ModItems.SPHEDGE_PICKAXE, (((displayContext, entries) -> {
        entries.add(ModItems.SPHEDGE_PICKAXE);
        entries.add(ModItems.SPHEDGE_AXE);
        entries.add(ModItems.SPHEDGE_SWORD);
        entries.add(ModItems.SPHEDGE_SHOVEL);
        entries.add(ModItems.SPHEDGE_HOE);
        entries.add(ModBoats.SPHEDGE_BOAT.boatItem);
        entries.add(ModBoats.SPHEDGE_BOAT.chestBoatItem);
    })));

    private static ItemGroup register(String name, ItemConvertible icon, ItemGroup.EntryCollector entries) {
        return Registry.register(
                Registries.ITEM_GROUP,
                ModIdentifier.of(name),
                FabricItemGroup.builder()
                        .displayName(Text.translatable(String.format("itemGroup.%s", name)))
                        .icon(() -> new ItemStack(icon))
                        .entries(entries)
                        .build());
    }

    // For Language Provider(s)
    public static String getGroupKey(ItemGroup group) {
        return ((TranslatableTextContent) group.getDisplayName().getContent()).getKey();
    }

    public static void initialize() {
        TheOldGods.LOGGER.info("Initializing Mod Item Group(s)");
    }
}
