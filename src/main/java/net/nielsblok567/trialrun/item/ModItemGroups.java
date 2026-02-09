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

public class ModItemGroups {
    public static final ItemGroup JOKES = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(TrialRun.MOD_ID, "jokes"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.GIFFEL))
                    .displayName(Text.translatable("itemgroup.trialrun.jokes"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.GIFFEL);
                        entries.add(ModBlocks.COQUE_BLOCK);
                    }).build());

    public static final ItemGroup PINK_GARNET = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(TrialRun.MOD_ID, "pink_garnet"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModBlocks.PINK_GARNET_BLOCK))
                    .displayName(Text.translatable("itemgroup.trialrun.pink_garnet"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModBlocks.PINK_GARNET_BLOCK);
                    }).build());

    public static void registerItemGroups() {
        TrialRun.LOGGER.info("Registering Item Groups for " + TrialRun.MOD_ID);
    }
}
