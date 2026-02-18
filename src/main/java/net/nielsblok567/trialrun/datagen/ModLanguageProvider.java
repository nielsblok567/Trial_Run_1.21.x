package net.nielsblok567.trialrun.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.RegistryWrapper;
import net.nielsblok567.trialrun.block.ModBlocks;
import net.nielsblok567.trialrun.item.ModItemGroups;
import net.nielsblok567.trialrun.item.ModItems;

import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;

import static org.apache.commons.lang3.StringUtils.substring;

public class ModLanguageProvider extends FabricLanguageProvider {
    public ModLanguageProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generateTranslations(RegistryWrapper.WrapperLookup registryLookup, TranslationBuilder translationBuilder) {
        /**
         * This ArrayList registers objects which have a simple name and translation (e.g. iron_ingot -> Iron Ingot)
         * This is passed to an iterator, which constructs an appropriate string stored in another ArrayList
         * Finally, an iterator works through the list and passes both object and string to the translationBuilder method
         */
        ArrayList<Object> simpleTranslations = new ArrayList<>();
        simpleTranslations.add(ModItems.CHISEL);
        simpleTranslations.add(ModItems.GIFFEL);
        simpleTranslations.add(ModItems.FUEL_PELLET);
        simpleTranslations.add(ModItems.PLATINUM_INGOT);
        simpleTranslations.add(ModItems.RAW_PLATINUM);
        simpleTranslations.add(ModBlocks.COQUE_BLOCK);
        simpleTranslations.add(ModBlocks.MAGIC_BLOCK);
        simpleTranslations.add(ModBlocks.PLATINUM_ORE);
        simpleTranslations.add(ModBlocks.PLATINUM_DEEPSLATE_ORE);
        simpleTranslations.add(ModBlocks.PINK_GARNET_BLOCK);
        simpleTranslations.add(ModItemGroups.ALL_MODDED);
        simpleTranslations.add(ModItemGroups.MOD_BLOCKS);
        simpleTranslations.add(ModBlocks.COQUE_STAIR);
        simpleTranslations.add(ModBlocks.COQUE_SLAB);
        simpleTranslations.add(ModBlocks.COQUE_BUTTON);
        simpleTranslations.add(ModBlocks.COQUE_PRESSURE_PLATE);
        simpleTranslations.add(ModBlocks.COQUE_FENCE);
        simpleTranslations.add(ModBlocks.COQUE_FENCE_GATE);
        simpleTranslations.add(ModBlocks.COQUE_WALL);
        simpleTranslations.add(ModBlocks.COQUE_DOOR);
        simpleTranslations.add(ModBlocks.COQUE_TRAPDOOR);

        ArrayList<String> simpleTranslationStrings = new ArrayList<>();

        for (int i = 0 ; i < simpleTranslations.size(); i++) {
            simpleTranslationStrings.add(nameToString(simpleTranslations.get(i)));
            if (simpleTranslations.get(i) instanceof Block) {
                //System.out.println(simpleTranslations.get(i));
                translationBuilder.add(((Block) simpleTranslations.get(i)).getTranslationKey(), simpleTranslationStrings.get(i));

            } else if (simpleTranslations.get(i) instanceof Item) {
                //System.out.println(simpleTranslations.get(i));
                translationBuilder.add(((Item) simpleTranslations.get(i)).getTranslationKey(), simpleTranslationStrings.get(i));

            } else if (simpleTranslations.get(i) instanceof ItemGroup) {
                //System.out.println(((ItemGroup) simpleTranslations.get(i)).getDisplayName());
                int indexStart = ((ItemGroup) simpleTranslations.get(i)).getDisplayName().toString().indexOf("'");
                int indexEnd = ((ItemGroup) simpleTranslations.get(i)).getDisplayName().toString().lastIndexOf("'");

                String substring = substring(((ItemGroup) simpleTranslations.get(i)).getDisplayName().toString(), indexStart + 1, indexEnd);

                //System.out.println(substring);
                String[] tempArray = substring.split("[._]");
                String output = "";
                for (int y = 2; y < tempArray.length; y++) {
                    tempArray[y] = capitalizeString(tempArray[y]);
                    output = output.concat(tempArray[y]);
                    //System.out.println("Split: " + output);

                    if (!(y == tempArray.length - 1)) {
                        output = output + " ";
                    }
                }
                //System.out.println(output);
                translationBuilder.add(substring, output);
            }
        }

        //translationBuilder methods containing translations unfit for simple translations (currently tooltips)
        translationBuilder.add("tooltip.trialrun.magic_block"       , "§7Magically transforms §fplatinum§7 ingots to tasty §4Giffels§7!");
        translationBuilder.add("tooltip.trialrun.chisel"            , "§7Hold §eShift §7for more information.");
        translationBuilder.add("tooltip.trialrun.chisel.shift_down" , "§7This item chisels some stone blocks into bricks!");
        translationBuilder.add("tooltip.trialrun.giffel"            , "§7A delicious cinnamon-y treat!");
    }

    private static String nameToString(Object input) {
        String temp = new String(input.toString().replace('}',' ').trim());
        //System.out.println("temp: " + temp);
        String[] tempArray = temp.split("[:_]");
        String output = "";
        for (int i = 1; i < tempArray.length; i++) {
            tempArray[i] = capitalizeString(tempArray[i]);
            output = output.concat(tempArray[i]);
            //System.out.println("Split: " + output);

            if (!(i == tempArray.length - 1)) {
                output = output + " ";
            }
        }
        return output;
    }

    private static String capitalizeString(String string) {
        String firstLetter = String.valueOf(string.charAt(0));
        String[] split = string.split(".", 2);
        string = firstLetter.toUpperCase() + split[1];
        return string;
    }
}
