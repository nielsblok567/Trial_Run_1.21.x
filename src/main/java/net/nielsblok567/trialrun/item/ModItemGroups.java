package net.nielsblok567.trialrun.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.nielsblok567.trialrun.TrialRun;
import net.nielsblok567.trialrun.block.ModBlocks;
import net.nielsblok567.trialrun.block.custom.MagicBlock;

public class ModItemGroups {
    public static final ItemGroup ALL_MODDED = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(TrialRun.MOD_ID, "modded"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.GIFFEL))
                    .displayName(Text.translatable("itemgroup.trialrun.modded"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.GIFFEL);
                        entries.add(ModItems.CHISEL);
                        entries.add(ModItems.FUEL_PELLET);
                        entries.add(ModItems.PLATINUM_INGOT);
                        entries.add(ModItems.PLATINUM_RAW);
                        //entries.add(ModItems.MJOLNIR);
                        entries.add(ModBlocks.COQUE_BLOCK);
                        entries.add(ModBlocks.PINK_GARNET_BLOCK);
                        entries.add(ModBlocks.PLATINUM_ORE);
                        entries.add(ModBlocks.PLATINUM_DEEPSLATE_ORE);
                        entries.add(ModBlocks.MAGIC_BLOCK);
                    }).build());

    public static final ItemGroup MOD_BLOCKS = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(TrialRun.MOD_ID, "mod_blocks"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModBlocks.PINK_GARNET_BLOCK))
                    .displayName(Text.translatable("itemgroup.trialrun.mod_blocks"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModBlocks.PINK_GARNET_BLOCK);
                        entries.add(ModBlocks.PLATINUM_ORE);
                        entries.add(ModBlocks.PLATINUM_DEEPSLATE_ORE);
                        entries.add(ModBlocks.MAGIC_BLOCK);
                    }).build());

    public static void registerItemGroups() {
        TrialRun.LOGGER.info("Registering Item Groups for " + TrialRun.MOD_ID);
    }
}
