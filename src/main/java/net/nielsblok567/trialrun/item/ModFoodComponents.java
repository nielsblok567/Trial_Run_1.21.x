package net.nielsblok567.trialrun.item;

import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

public class ModFoodComponents {

    public static final FoodComponent GIFFEL = new FoodComponent.Builder()
            .snack()
            .nutrition(2)
            .saturationModifier(0.1f)
            .statusEffect(new StatusEffectInstance(StatusEffects.LUCK, 200), 0.3f)
            .build();
}
