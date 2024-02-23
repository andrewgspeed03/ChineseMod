package net.Andrew.chinamod.datagen.loot;

import java.util.Set;

import net.Andrew.chinamod.block.ModBlocks;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockLootTables extends BlockLootSubProvider{

    protected ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
        
    }

    @Override
    protected void generate() {
       this.dropSelf(ModBlocks.TILE_ROAD.get());
       this.dropSelf(ModBlocks.GU_DRUM.get());
       this.dropSelf(ModBlocks.SILK_BLOCK.get());
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }

}
