package net.Andrew.chinamod.item.custom;

import java.util.List;

import net.Andrew.chinamod.ChinaMod;
import net.Andrew.chinamod.item.ModItems;
import net.Andrew.chinamod.util.ModTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.TierSortingRegistry;

public class ModToolTiers {
    public static final Tier JADE = TierSortingRegistry.registerTier(
        new ForgeTier(5, 1500, 5f, 4f, 25,
                    ModTags.Blocks.NEEDS_JADE_TOOL, () -> Ingredient.of(ModItems.JADE.get())),
        new ResourceLocation(ChinaMod.MOD_ID, "jade"), List.of(Tiers.NETHERITE), List.of());
}
