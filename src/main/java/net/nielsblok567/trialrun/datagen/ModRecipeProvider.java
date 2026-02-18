package net.nielsblok567.trialrun.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.nielsblok567.trialrun.block.ModBlocks;
import net.nielsblok567.trialrun.item.ModItems;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        List<ItemConvertible> PLATINUM_SMELTABLES = List.of(ModItems.RAW_PLATINUM, ModBlocks.PLATINUM_ORE, ModBlocks.PLATINUM_DEEPSLATE_ORE);

        offerSmelting(exporter, PLATINUM_SMELTABLES, RecipeCategory.MISC, ModItems.PLATINUM_INGOT, 0.25f, 200, "platinum_ingot");
        offerBlasting(exporter, PLATINUM_SMELTABLES, RecipeCategory.MISC, ModItems.PLATINUM_INGOT, 0.25f, 100, "platinum_ingot");

        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, Items.EGG, RecipeCategory.FOOD, ModBlocks.COQUE_BLOCK);
        offer2x2CompactingRecipe(exporter, RecipeCategory.MISC, Items.COAL, ModItems.FUEL_PELLET);

        offerShapelessRecipe(exporter, ModItems.FUEL_PELLET, Items.COAL, "_from_coal", 4);

        createStairsRecipe(ModBlocks.COQUE_STAIR, Ingredient.ofItems(ModBlocks.COQUE_BLOCK))
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.COQUE_BLOCK), FabricRecipeProvider.conditionsFromItem(ModBlocks.COQUE_BLOCK))
                .offerTo(exporter);
        offerSlabRecipe(exporter, RecipeCategory.BUILDING_BLOCKS,ModBlocks.COQUE_SLAB, ModBlocks.COQUE_BLOCK);
        offerPressurePlateRecipe(exporter, ModBlocks.COQUE_PRESSURE_PLATE, ModBlocks.COQUE_BLOCK);
        createDoorRecipe(ModBlocks.COQUE_DOOR, Ingredient.ofItems(ModBlocks.COQUE_BLOCK))
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.COQUE_BLOCK), FabricRecipeProvider.conditionsFromItem(ModBlocks.COQUE_BLOCK))
                .offerTo(exporter);
        createTrapdoorRecipe(ModBlocks.COQUE_TRAPDOOR, Ingredient.ofItems(ModBlocks.COQUE_BLOCK))
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.COQUE_BLOCK), FabricRecipeProvider.conditionsFromItem(ModBlocks.COQUE_BLOCK))
                .offerTo(exporter);
        createTransmutationRecipe(ModBlocks.COQUE_BUTTON, Ingredient.ofItems(ModBlocks.COQUE_BLOCK))
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.COQUE_BLOCK), FabricRecipeProvider.conditionsFromItem(ModBlocks.COQUE_BLOCK))
                .offerTo(exporter);
        createFenceRecipe(ModBlocks.COQUE_FENCE, Ingredient.ofItems(ModBlocks.COQUE_BLOCK))
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.COQUE_BLOCK), FabricRecipeProvider.conditionsFromItem(ModBlocks.COQUE_BLOCK))
                .offerTo(exporter);
        createFenceGateRecipe(ModBlocks.COQUE_FENCE_GATE, Ingredient.ofItems(ModBlocks.COQUE_BLOCK))
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.COQUE_BLOCK), FabricRecipeProvider.conditionsFromItem(ModBlocks.COQUE_BLOCK))
                .offerTo(exporter);
        offerWallRecipe(exporter, RecipeCategory.BUILDING_BLOCKS,ModBlocks.COQUE_WALL, ModBlocks.COQUE_BLOCK);
    }
}
