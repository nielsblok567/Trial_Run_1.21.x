package net.nielsblok567.trialrun.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.nielsblok567.trialrun.block.ModBlocks;
import net.nielsblok567.trialrun.item.ModItems;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.COQUE_STAIR);
        addDrop(ModBlocks.COQUE_SLAB, slabDrops(ModBlocks.COQUE_SLAB));
        addDrop(ModBlocks.COQUE_BUTTON);
        addDrop(ModBlocks.COQUE_PRESSURE_PLATE);
        addDrop(ModBlocks.COQUE_FENCE);
        addDrop(ModBlocks.COQUE_FENCE_GATE);
        addDrop(ModBlocks.COQUE_WALL);
        addDrop(ModBlocks.COQUE_DOOR, doorDrops(ModBlocks.COQUE_DOOR));
        addDrop(ModBlocks.COQUE_TRAPDOOR);
        addDrop(ModBlocks.COQUE_BLOCK);
        addDrop(ModBlocks.PINK_GARNET_BLOCK);
        addDrop(ModBlocks.MAGIC_BLOCK);
        addDrop(ModBlocks.PLATINUM_ORE, oreDrops(ModBlocks.PLATINUM_ORE, ModItems.RAW_PLATINUM));
        addDrop(ModBlocks.PLATINUM_DEEPSLATE_ORE, multipleOreDrops(ModBlocks.PLATINUM_DEEPSLATE_ORE, ModItems.RAW_PLATINUM, 2f,5f));
    }


    public LootTable.Builder multipleOreDrops(Block drop, Item item, float minDrops, float maxDrops) {
        RegistryWrapper.Impl<Enchantment> impl = this.registryLookup.getWrapperOrThrow(RegistryKeys.ENCHANTMENT);
        return this.dropsWithSilkTouch(drop, this.applyExplosionDecay(drop, ItemEntry.builder(item)
                                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(minDrops, maxDrops)))
                                .apply(ApplyBonusLootFunction.oreDrops(impl.getOrThrow(Enchantments.FORTUNE)))
                )
        );
    }
}
