package net.Andrew.chinamod.item;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoods {
    public static final FoodProperties COOKED_RICE = new FoodProperties.Builder().nutrition(7)
        .saturationMod(0.8f).effect(() -> new MobEffectInstance(MobEffects.ABSORPTION, 200), 0.1f).build();

    
}
