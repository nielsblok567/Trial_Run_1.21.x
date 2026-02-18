package net.nielsblok567.trialrun.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.nielsblok567.trialrun.TrialRun;
import net.nielsblok567.trialrun.block.custom.MagicBlock;

public class ModBlocks {

    public static final Block PINK_GARNET_BLOCK = registerBlock("pink_garnet_block",
            new Block(AbstractBlock.Settings.create().strength(4f)
                    .requiresTool().sounds(BlockSoundGroup.AMETHYST_BLOCK)));

    public static final Block COQUE_BLOCK = registerBlock("coque_block",
            new Block(AbstractBlock.Settings.create().strength(0.5f).sounds(BlockSoundGroup.SNOW)));

    public static final Block PLATINUM_ORE = registerBlock("platinum_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(6, 7),
                    AbstractBlock.Settings.create().strength(3f).requiresTool()));

    public static final Block PLATINUM_DEEPSLATE_ORE = registerBlock("platinum_deepslate_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(6, 9),
                    AbstractBlock.Settings.create().strength(4f).requiresTool().sounds(BlockSoundGroup.DEEPSLATE)));

    public static final Block MAGIC_BLOCK = registerBlock("magic_block",
            new MagicBlock(AbstractBlock.Settings.create().strength(1f).requiresTool()));

    public static final Block COQUE_STAIR = registerBlock("coque_stairs",
            new StairsBlock(ModBlocks.COQUE_BLOCK.getDefaultState(),
                    AbstractBlock.Settings.create().strength(0.5f).sounds(BlockSoundGroup.SNOW)));
    public static final Block COQUE_SLAB = registerBlock("coque_slab",
            new SlabBlock(AbstractBlock.Settings.create().strength(0.5f).sounds(BlockSoundGroup.SNOW)));

    public static final Block COQUE_BUTTON = registerBlock("coque_button",
            new ButtonBlock(BlockSetType.IRON, 5, AbstractBlock.Settings.create().strength(0.5f).sounds(BlockSoundGroup.SNOW)));
    public static final Block COQUE_PRESSURE_PLATE = registerBlock("coque_pressure_plate",
            new PressurePlateBlock(BlockSetType.IRON, AbstractBlock.Settings.create().strength(0.5f).sounds(BlockSoundGroup.SNOW)));

    public static final Block COQUE_FENCE = registerBlock("coque_fence",
            new FenceBlock(AbstractBlock.Settings.create().strength(0.5f).sounds(BlockSoundGroup.SNOW)));
    public static final Block COQUE_FENCE_GATE = registerBlock("coque_fence_gate",
            new FenceGateBlock(WoodType.ACACIA, AbstractBlock.Settings.create().strength(0.5f).sounds(BlockSoundGroup.SNOW)));
    public static final Block COQUE_WALL = registerBlock("coque_wall",
            new WallBlock(AbstractBlock.Settings.create().strength(0.5f).sounds(BlockSoundGroup.SNOW)));

    public static final Block COQUE_DOOR = registerBlock("coque_door",
            new DoorBlock(BlockSetType.BAMBOO, AbstractBlock.Settings.create().strength(0.5f).sounds(BlockSoundGroup.SNOW).nonOpaque()));
    public static final Block COQUE_TRAPDOOR = registerBlock("coque_trapdoor",
            new TrapdoorBlock(BlockSetType.BAMBOO, AbstractBlock.Settings.create().strength(0.5f).sounds(BlockSoundGroup.SNOW).nonOpaque()));

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(TrialRun.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(TrialRun.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks() {
        TrialRun.LOGGER.info("Registering Mod Blocks for " + TrialRun.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            entries.add(ModBlocks.COQUE_BLOCK);
            entries.add(ModBlocks.PINK_GARNET_BLOCK);
        });
    }
}
