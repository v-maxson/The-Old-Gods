package mod.maxson.datagen.recipe;

import com.google.common.collect.ImmutableList;
import mod.maxson.block.ModBlocks;
import mod.maxson.item.ModItems;
import mod.maxson.util.ModIdentifier;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;

public class RecipeProvider extends FabricRecipeProvider {
    // Not to be confused with the block tag :)
    public static final ImmutableList<ItemConvertible> SPHEDGE_ORES = ImmutableList.of(
            ModBlocks.DEEPSLATE_SPHEDGE_ORE,
            ModBlocks.SPHEDGE_ORE,
            ModItems.RAW_SPHEDGE
    );

    public RecipeProvider(FabricDataOutput output) {
        super(output);
    }

    private void offerPickaxeRecipe(RecipeExporter exporter, ItemConvertible ingredient, ItemConvertible stick, ItemConvertible output) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, output)
                .pattern("XXX")
                .pattern(" # ")
                .pattern(" # ")
                .input('X', ingredient)
                .input('#', stick)
                .criterion(hasItem(ModItems.SPHEDGE_INGOT), conditionsFromItem(ModItems.SPHEDGE_INGOT))
                .offerTo(exporter, ModIdentifier.of(getRecipeName(output)));
    }
    private void offerPickaxeRecipe(RecipeExporter exporter, ItemConvertible ingredient, ItemConvertible output) { offerPickaxeRecipe(exporter, ingredient, Items.STICK, output); }

    private void offerAxeRecipe(RecipeExporter exporter, ItemConvertible ingredient, ItemConvertible stick, ItemConvertible output) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, output)
                .pattern("XX")
                .pattern("X#")
                .pattern(" #")
                .input('X', ingredient)
                .input('#', stick)
                .criterion(hasItem(ModItems.SPHEDGE_INGOT), conditionsFromItem(ModItems.SPHEDGE_INGOT))
                .offerTo(exporter, ModIdentifier.of(getRecipeName(output)));
    }
    private void offerAxeRecipe(RecipeExporter exporter, ItemConvertible ingredient, ItemConvertible output) { offerAxeRecipe(exporter, ingredient, Items.STICK, output); }

    private void offerSwordRecipe(RecipeExporter exporter, ItemConvertible ingredient, ItemConvertible stick, ItemConvertible output) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, output)
                .pattern("X")
                .pattern("X")
                .pattern("#")
                .input('X', ingredient)
                .input('#', stick)
                .criterion(hasItem(ModItems.SPHEDGE_INGOT), conditionsFromItem(ModItems.SPHEDGE_INGOT))
                .offerTo(exporter, ModIdentifier.of(getRecipeName(output)));
    }
    private void offerSwordRecipe(RecipeExporter exporter, ItemConvertible ingredient, ItemConvertible output) { offerSwordRecipe(exporter, ingredient, Items.STICK, output); }

    private void offerShovelRecipe(RecipeExporter exporter, ItemConvertible ingredient, ItemConvertible stick, ItemConvertible output) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, output)
                .pattern("X")
                .pattern("#")
                .pattern("#")
                .input('X', ingredient)
                .input('#', stick)
                .criterion(hasItem(ModItems.SPHEDGE_INGOT), conditionsFromItem(ModItems.SPHEDGE_INGOT))
                .offerTo(exporter, ModIdentifier.of(getRecipeName(output)));
    }
    private void offerShovelRecipe(RecipeExporter exporter, ItemConvertible ingredient, ItemConvertible output) { offerShovelRecipe(exporter, ingredient, Items.STICK, output); }

    private void offerHoeRecipe(RecipeExporter exporter, ItemConvertible ingredient, ItemConvertible stick, ItemConvertible output) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, output)
                .pattern("XX")
                .pattern(" #")
                .pattern(" #")
                .input('X', ingredient)
                .input('#', stick)
                .criterion(hasItem(ModItems.SPHEDGE_INGOT), conditionsFromItem(ModItems.SPHEDGE_INGOT))
                .offerTo(exporter, ModIdentifier.of(getRecipeName(output)));
    }
    private void offerHoeRecipe(RecipeExporter exporter, ItemConvertible ingredient, ItemConvertible output) { offerPickaxeRecipe(exporter, ingredient, Items.STICK, output); }

    @Override
    public void generate(RecipeExporter exporter) {
        offerSmelting(exporter, SPHEDGE_ORES, RecipeCategory.MISC, ModItems.SPHEDGE_INGOT, 0.7f, 200, "sphedge_ingot");
        offerBlasting(exporter, SPHEDGE_ORES, RecipeCategory.MISC, ModItems.SPHEDGE_INGOT, 0.7f, 100, "sphedge_ingot");

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.SPHEDGE_STICK)
                .pattern("##")
                .input('#', ModBlocks.SPHEDGE_PLANKS)
                .criterion(hasItem(ModBlocks.SPHEDGE_PLANKS), conditionsFromItem(ModBlocks.SPHEDGE_PLANKS))
                .offerTo(exporter, ModIdentifier.of(getRecipeName(ModItems.SPHEDGE_STICK)));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SPHEDGE_BLOCK)
                .input(Ingredient.ofItems(ModItems.SPHEDGE_INGOT), 9)
                .group("sphedge_block")
                .criterion(hasItem(ModItems.SPHEDGE_INGOT), conditionsFromItem(ModItems.SPHEDGE_INGOT))
                .offerTo(exporter, convertBetween(ModBlocks.SPHEDGE_BLOCK, ModItems.SPHEDGE_INGOT));
        offerShapelessRecipe(exporter, ModItems.SPHEDGE_INGOT, ModBlocks.SPHEDGE_BLOCK, "sphedge_ingot", 9);

        // Sphedge Legs
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SPHEDGE_LEGS)
                .pattern("# #")
                .pattern("   ")
                .pattern("# #")
                .input('#', ModItems.SPHEDGE_STICK)
                .criterion(hasItem(ModItems.SPHEDGE_STICK), conditionsFromItem(ModItems.SPHEDGE_STICK))
                .offerTo(exporter, ModIdentifier.of(getRecipeName(ModBlocks.SPHEDGE_LEGS)));

        offerPickaxeRecipe(exporter, ModItems.SPHEDGE_INGOT, ModItems.SPHEDGE_STICK, ModItems.SPHEDGE_PICKAXE);
        offerAxeRecipe(exporter, ModItems.SPHEDGE_INGOT, ModItems.SPHEDGE_STICK,  ModItems.SPHEDGE_AXE);
        offerSwordRecipe(exporter, ModItems.SPHEDGE_INGOT, ModItems.SPHEDGE_STICK,  ModItems.SPHEDGE_SWORD);
        offerShovelRecipe(exporter, ModItems.SPHEDGE_INGOT, ModItems.SPHEDGE_STICK,  ModItems.SPHEDGE_SHOVEL);
        offerHoeRecipe(exporter, ModItems.SPHEDGE_INGOT, ModItems.SPHEDGE_STICK,  ModItems.SPHEDGE_HOE);
    }
}
