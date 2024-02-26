package net.Andrew.chinamod.datagen.loot;

import java.util.Set;

import net.Andrew.chinamod.block.ModBlocks;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockLootTables extends BlockLootSubProvider{
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
        
    }

    @Override
    protected void generate() {
        this.dropSelf(ModBlocks.TILE_ROAD.get());
        this.dropSelf(ModBlocks.GU_DRUM.get());
        this.dropSelf(ModBlocks.SILK_BLOCK.get());
        this.dropSelf(ModBlocks.WHITE_PINE_PLANK.get());

        this.dropSelf(ModBlocks.WHITE_PINE_STAIRS.get());
        this.dropSelf(ModBlocks.WHITE_PINE_FENCE.get());
        this.dropSelf(ModBlocks.WHITE_PINE_FENCE_GATE.get());
        this.dropSelf(ModBlocks.WHITE_PINE_WALL.get());
        this.dropSelf(ModBlocks.WHITE_PINE_BUTTON.get());
        this.dropSelf(ModBlocks.WHITE_PINE_PRESSURE_PLATE.get());
        this.dropSelf(ModBlocks.WHITE_PINE_TRAP_DOOR.get());

        this.add(ModBlocks.WHITE_PINE_SLAB.get(),
            block -> createSlabItemTable(ModBlocks.WHITE_PINE_SLAB.get()));
        this.add(ModBlocks.WHITE_PINE_DOOR.get(),
            block -> createDoorTable(ModBlocks.WHITE_PINE_DOOR.get()));
    }
    
    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
