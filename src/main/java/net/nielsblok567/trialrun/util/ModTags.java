package net.nielsblok567.trialrun.util;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.nielsblok567.trialrun.TrialRun;


public class ModTags {
    public static class Blocks {

        private static TagKey<Block> createTag(String name) {
            return TagKey.of(RegistryKeys.BLOCK, Identifier.of(TrialRun.MOD_ID, name));
        }
    }
    public static class Items {
        public static final TagKey<Item> CAN_BECOME_GIFFEL = createTag("can_become_giffel");

        private static TagKey<Item> createTag(String name) {
            return TagKey.of(RegistryKeys.ITEM, Identifier.of(TrialRun.MOD_ID, name));
        }
    }
}
