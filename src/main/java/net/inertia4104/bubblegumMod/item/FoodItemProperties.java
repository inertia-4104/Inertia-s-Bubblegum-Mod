package net.inertia4104.bubblegumMod.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class FoodItemProperties {
    public static final FoodProperties REDGUM = new FoodProperties.Builder().nutrition(1).saturationModifier(2).effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST,
            1200, 2), 1).build();
    public static final FoodProperties BLUEGUM = new FoodProperties.Builder().nutrition(1).saturationModifier(2).effect(() -> new MobEffectInstance(MobEffects.DOLPHINS_GRACE,
            1200), 1).build();
    public static final FoodProperties GREENGUM = new FoodProperties.Builder().nutrition(1).saturationModifier(2).effect(() -> new MobEffectInstance(MobEffects.JUMP,
            1200), 1).build();
    public static final FoodProperties PINKGUM = new FoodProperties.Builder().nutrition(1).saturationModifier(2).effect(() -> new MobEffectInstance(MobEffects.REGENERATION,
            1200), 1).build();
    public static final FoodProperties PURPLEGUM = new FoodProperties.Builder().nutrition(1).saturationModifier(2).effect(() -> new MobEffectInstance(MobEffects.NIGHT_VISION,
            1200), 1).build();
    public static final FoodProperties YELLOWGUM = new FoodProperties.Builder().nutrition(1).saturationModifier(2).effect(() -> new MobEffectInstance(MobEffects.ABSORPTION,
            1200, 2), 1).build();
    public static final FoodProperties ORANGEGUM = new FoodProperties.Builder().nutrition(1).saturationModifier(2).effect(() -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE,
            1200, 2), 1).build();
}
