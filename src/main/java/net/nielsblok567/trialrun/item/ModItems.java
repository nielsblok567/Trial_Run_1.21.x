package net.nielsblok567.trialrun.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.nielsblok567.trialrun.TrialRun;

public class ModItems {
    public static final Item GIFFEL = registerItem("giffel", new Item(new Item.Settings()));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(TrialRun.MOD_ID, name), item);
    }

    public static void registerModItems() {
        TrialRun.LOGGER.info("Registering Mod Items for " + TrialRun.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(entries -> {
            entries.add(GIFFEL);
        });
    }

}
