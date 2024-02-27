package net.Andrew.chinamod.util;

import net.Andrew.chinamod.ChinaMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static class Blocks{
        public static final TagKey<Block> METAL_VALUABLES = tag("metal_valuables");
        public static final TagKey<Block> NEEDS_JADE_TOOL = tag("needs_jade_tool");

        private static TagKey<Block> tag(String name){
            return BlockTags.create(new ResourceLocation(ChinaMod.MOD_ID, name));
        }
    }

    public static class Items {
    
        private static TagKey<Item> tag(String name){
            return ItemTags.create(new ResourceLocation(ChinaMod.MOD_ID, name));
        }    
    }
}
