package net.nielsblok567.trialrun;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.nielsblok567.trialrun.block.ModBlocks;
import net.nielsblok567.trialrun.item.ModItemGroups;
import net.nielsblok567.trialrun.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TrialRun implements ModInitializer {
	public static final String MOD_ID = "trialrun";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

		FuelRegistry.INSTANCE.add(ModItems.FUEL_PELLET, 400);
	}
}