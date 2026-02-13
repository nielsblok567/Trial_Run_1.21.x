package net.nielsblok567.trialrun.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.nielsblok567.trialrun.TrialRun;
import net.nielsblok567.trialrun.item.custom.ChiselItem;

import java.util.List;

public class ModItems {
    public static final Item GIFFEL = registerItem("giffel", new Item(new Item.Settings().food(ModFoodComponents.GIFFEL)) {
        @Override
        public void appendTooltip(ItemStack stack, Item.TooltipContext context, List<Text> tooltip, TooltipType options) {
        tooltip.add(Text.translatable("tooltip.trialrun.giffel"));
        super.appendTooltip(stack, context, tooltip, options);
        }
    });
    public static final Item PLATINUM_RAW = registerItem("platinum_raw", new Item(new Item.Settings()));
    public static final Item PLATINUM_INGOT = registerItem("platinum_ingot", new Item(new Item.Settings()));
    public static final Item FUEL_PELLET = registerItem("fuel_pellet", new Item(new Item.Settings()));

    public static final Item CHISEL = registerItem("chisel", new ChiselItem(new Item.Settings().maxDamage(64)));

    /*
    public static final Item MJOLNIR = registerItem("mjolnir", new Item(
            new Item.Settings()
                    .rarity(Rarity.EPIC)
                    .attributeModifiers(MjolnirItem.createAttributeModifiers())
    ));
    */
    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(TrialRun.MOD_ID, name), item);
    }

    public static void registerModItems() {
        TrialRun.LOGGER.info("Registering Mod Items for " + TrialRun.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(entries -> {
            entries.add(GIFFEL);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(PLATINUM_RAW);
            entries.add(PLATINUM_INGOT);
        });
    }

}
