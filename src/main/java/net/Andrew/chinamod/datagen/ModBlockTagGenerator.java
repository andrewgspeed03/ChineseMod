package net.Andrew.chinamod.datagen;

import java.util.concurrent.CompletableFuture;

import org.jetbrains.annotations.Nullable;

import net.Andrew.chinamod.ChinaMod;
import net.Andrew.chinamod.block.ModBlocks;
import net.Andrew.chinamod.util.ModTags;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModBlockTagGenerator extends BlockTagsProvider{

    public ModBlockTagGenerator(PackOutput output, CompletableFuture<Provider> lookupProvider,
            @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, ChinaMod.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(Provider pProvider) {
        this.tag(ModTags.Blocks.METAL_VALUABLES)
            .addTag(Tags.Blocks.ORES);

        this.tag(BlockTags.MINEABLE_WITH_AXE)
            .add(ModBlocks.GU_DRUM.get());

        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
            .add(ModBlocks.TILE_ROAD.get(),
                ModBlocks.JADE_BLOCK.get(),
                ModBlocks.JADE_ORE.get(),
                ModBlocks.DEEPSLATE_JADE_ORE.get());

        this.tag(BlockTags.NEEDS_STONE_TOOL)
            .add(ModBlocks.TILE_ROAD.get());

        this.tag(BlockTags.NEEDS_IRON_TOOL)
            .add(ModBlocks.JADE_BLOCK.get(),
            ModBlocks.JADE_ORE.get(),
            ModBlocks.DEEPSLATE_JADE_ORE.get());

        this.tag(BlockTags.NEEDS_DIAMOND_TOOL);

        this.tag(BlockTags.FENCES)
            .add(ModBlocks.WHITE_PINE_FENCE.get());
        this.tag(BlockTags.FENCES)
            .add(ModBlocks.WHITE_PINE_FENCE_GATE.get());
        this.tag(BlockTags.WALLS)
            .add(ModBlocks.WHITE_PINE_WALL.get());

    }
    
}
