package net.Andrew.chinamod.datagen;

import java.util.List;

import net.Andrew.chinamod.ChinaMod;
import net.Andrew.chinamod.block.ModBlocks;
import net.Andrew.chinamod.item.ModItems;
import net.minecraft.client.Minecraft;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.FireworkRocketItem.Shape;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.BlastingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.SmeltingRecipe;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;


public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder{

    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(RecipeOutput pRecipeOutput) {
       
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.TILE_ROAD.get())
            .pattern("###")
            .pattern("###")
            .pattern("###")
            .define('#', ItemTags.create(new ResourceLocation("minecraft:brick")))
            .unlockedBy(getHasName(ModItems.PINE_CONE.get()), has(ModItems.PINE_CONE.get()))
            .save(pRecipeOutput);
         
         ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.TILE_ROAD.get())
            .pattern("###")
            .pattern("###")
            .pattern("###")
            .define('#', ModItems.SILK.get())
            .unlockedBy(getHasName(ModItems.SILK.get()), has(ModItems.SILK.get()))
            .save(pRecipeOutput);

         ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.SILK.get(), 9)
            .requires(ModBlocks.SILK_BLOCK.get())
            .unlockedBy(getHasName(ModBlocks.SILK_BLOCK.get()), has(ModBlocks.SILK_BLOCK.get()))
            .save(pRecipeOutput);
    }

    protected static void oreSmelting(RecipeOutput pRecipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
      oreCooking(pRecipeOutput, RecipeSerializer.SMELTING_RECIPE, SmeltingRecipe::new, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_smelting");
   }

   protected static void oreBlasting(RecipeOutput pRecipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
      oreCooking(pRecipeOutput, RecipeSerializer.BLASTING_RECIPE, BlastingRecipe::new, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_blasting");
   }

   private static <T extends AbstractCookingRecipe> void oreCooking(RecipeOutput pRecipeOutput, RecipeSerializer<T> pSerializer, AbstractCookingRecipe.Factory<T> p_312098_, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pSuffix) {
      for(ItemLike itemlike : pIngredients) {
         SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult, 
            pExperience, pCookingTime, pSerializer, p_312098_)
            .group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
            .save(pRecipeOutput, ChinaMod.MODID + ":" + getItemName(pResult) + pSuffix + "_" + getItemName(itemlike));
      }

   }
}
