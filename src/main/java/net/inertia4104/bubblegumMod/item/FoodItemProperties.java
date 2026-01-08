package net.inertia4104.bubblegumMod.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class FoodItemProperties {
    public static final FoodProperties REDGUM = new FoodProperties.Builder().nutrition(1).saturationModifier(2).effect(() -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE,
            1200), 1).build();
}
