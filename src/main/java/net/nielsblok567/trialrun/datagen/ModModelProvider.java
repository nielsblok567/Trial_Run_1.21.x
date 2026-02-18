package net.nielsblok567.trialrun.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.block.Block;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.minecraft.item.Item;
import net.nielsblok567.trialrun.block.ModBlocks;
import net.nielsblok567.trialrun.item.ModItems;

import java.util.List;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        List<Block> simpleBlocks = List.of(
        ModBlocks.PINK_GARNET_BLOCK,
        ModBlocks.MAGIC_BLOCK,
        ModBlocks.PLATINUM_ORE,
        ModBlocks.PLATINUM_DEEPSLATE_ORE);

        for (Block element : simpleBlocks) {
            blockStateModelGenerator.registerSimpleCubeAll(element);
        }

        BlockStateModelGenerator.BlockTexturePool coquePool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.COQUE_BLOCK);
        coquePool.stairs(ModBlocks.COQUE_STAIR);
        coquePool.slab(ModBlocks.COQUE_SLAB);
        coquePool.button(ModBlocks.COQUE_BUTTON);
        coquePool.pressurePlate(ModBlocks.COQUE_PRESSURE_PLATE);
        coquePool.fence(ModBlocks.COQUE_FENCE);
        coquePool.fenceGate(ModBlocks.COQUE_FENCE_GATE);
        coquePool.wall(ModBlocks.COQUE_WALL);

        blockStateModelGenerator.registerDoor(ModBlocks.COQUE_DOOR);
        blockStateModelGenerator.registerTrapdoor(ModBlocks.COQUE_TRAPDOOR);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        List<Item> simpleItems = List.of(
        ModItems.CHISEL,
        ModItems.FUEL_PELLET,
        ModItems.GIFFEL,
        ModItems.PLATINUM_INGOT,
        ModItems.RAW_PLATINUM);

        for (Item entry : simpleItems) {
            itemModelGenerator.register(entry, Models.GENERATED);
        }
    }
}
