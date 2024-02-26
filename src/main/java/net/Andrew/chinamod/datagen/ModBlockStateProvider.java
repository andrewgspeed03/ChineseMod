package net.Andrew.chinamod.datagen;

import net.Andrew.chinamod.ChinaMod;
import net.Andrew.chinamod.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.ButtonBlock;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.FenceBlock;
import net.minecraft.world.level.block.FenceGateBlock;
import net.minecraft.world.level.block.PressurePlateBlock;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.TrapDoorBlock;
import net.minecraft.world.level.block.WallBlock;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStateProvider extends BlockStateProvider{

    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, ChinaMod.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.TILE_ROAD);
        blockWithItem(ModBlocks.SILK_BLOCK);
        blockWithItem(ModBlocks.WHITE_PINE_PLANK);

        stairsBlock((StairBlock) ModBlocks.WHITE_PINE_STAIRS.get(), blockTexture(ModBlocks.WHITE_PINE_PLANK.get()));
        slabBlock((SlabBlock) ModBlocks.WHITE_PINE_SLAB.get(), blockTexture(ModBlocks.WHITE_PINE_PLANK.get()),blockTexture(ModBlocks.WHITE_PINE_PLANK.get()));
        
        buttonBlock((ButtonBlock) ModBlocks.WHITE_PINE_BUTTON.get(), blockTexture(ModBlocks.WHITE_PINE_PLANK.get()));
        pressurePlateBlock((PressurePlateBlock) ModBlocks.WHITE_PINE_PRESSURE_PLATE.get(), blockTexture(ModBlocks.WHITE_PINE_PLANK.get()));

        fenceBlock((FenceBlock) ModBlocks.WHITE_PINE_FENCE.get(), blockTexture(ModBlocks.WHITE_PINE_PLANK.get()));
        fenceGateBlock((FenceGateBlock) ModBlocks.WHITE_PINE_FENCE_GATE.get(), blockTexture(ModBlocks.WHITE_PINE_PLANK.get()));
        wallBlock((WallBlock) ModBlocks.WHITE_PINE_WALL.get(), blockTexture(ModBlocks.WHITE_PINE_PLANK.get()));

        doorBlockWithRenderType((DoorBlock) ModBlocks.WHITE_PINE_DOOR.get(), modLoc("block/white_pine_trap_door"),modLoc("block/white_pine_plank"),"cutour");
        trapdoorBlockWithRenderType((TrapDoorBlock) ModBlocks.WHITE_PINE_TRAP_DOOR.get(), modLoc("block/white_pine_trap_door"),true, "cutout");
    }
    
    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }

}
