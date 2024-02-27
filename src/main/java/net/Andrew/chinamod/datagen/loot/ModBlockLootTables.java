package net.Andrew.chinamod.datagen.loot;

import java.util.Set;

import net.Andrew.chinamod.block.ModBlocks;
import net.Andrew.chinamod.item.ModItems;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
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

        this.dropSelf(ModBlocks.JADE_BLOCK.get());

        this.add(ModBlocks.JADE_ORE.get(),
            block -> createCopperLikeOreDrops(ModBlocks.JADE_ORE.get(), ModItems.JADE.get()));
        this.add(ModBlocks.DEEPSLATE_JADE_ORE.get(),
            block -> createCopperLikeOreDrops(ModBlocks.DEEPSLATE_JADE_ORE.get(), ModItems.JADE.get()));

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

    protected LootTable.Builder createCopperLikeOreDrops(Block pBlock, Item item){
        return createSilkTouchDispatchTable(pBlock,
            this.applyExplosionDecay(pBlock,
                LootItem.lootTableItem(item)
                    .apply(SetItemCountFunction.setCount(UniformGenerator.between(2f, 5f)))
                    .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
