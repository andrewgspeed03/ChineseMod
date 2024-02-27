package net.Andrew.chinamod.block;

import java.util.function.Supplier;

import net.Andrew.chinamod.ChinaMod;
import net.Andrew.chinamod.block.custom.GuBlock;
import net.Andrew.chinamod.item.ModItems;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = 
        DeferredRegister.create(ForgeRegistries.BLOCKS, ChinaMod.MODID);

    //.m_308003_ is the copy method
    public static final RegistryObject<Block> JADE_BLOCK = registerBlock("jade_block", () -> new Block(BlockBehaviour.Properties.m_308003_(Blocks.LAPIS_BLOCK)));
    public static final RegistryObject<Block> JADE_ORE = registerBlock("jade_ore", () -> new Block(BlockBehaviour.Properties.m_308003_(Blocks.LAPIS_ORE)));
    public static final RegistryObject<Block> DEEPSLATE_JADE_ORE = registerBlock("deepslate_jade_ore", () -> new Block(BlockBehaviour.Properties.m_308003_(Blocks.DEEPSLATE_LAPIS_ORE)));

    public static final RegistryObject<Block> SILK_BLOCK = registerBlock("silk_block", () -> new Block(BlockBehaviour.Properties.m_308003_(Blocks.WHITE_WOOL)));

    public static final RegistryObject<Block> TILE_ROAD = registerBlock("tile_road", () -> new Block(BlockBehaviour.Properties.m_308003_(Blocks.STONE_BRICKS)));

    public static final RegistryObject<Block> GU_DRUM = registerBlock("gu_drum", () -> new GuBlock(BlockBehaviour.Properties.m_308003_(Blocks.CHEST)));

    public static final RegistryObject<Block> WHITE_PINE_PLANK = registerBlock("white_pine_plank", () -> new Block(BlockBehaviour.Properties.m_308003_(Blocks.SPRUCE_PLANKS)));

    public static final RegistryObject<Block> WHITE_PINE_STAIRS = registerBlock("white_pine_stairs", () -> new StairBlock(ModBlocks.WHITE_PINE_PLANK.get().defaultBlockState(),
        BlockBehaviour.Properties.m_308003_(Blocks.SPRUCE_PLANKS)));
    public static final RegistryObject<Block> WHITE_PINE_SLAB = registerBlock("white_pine_slab", () -> new SlabBlock(BlockBehaviour.Properties.m_308003_(Blocks.SPRUCE_PLANKS)));

    public static final RegistryObject<Block> WHITE_PINE_BUTTON = registerBlock("white_pine_button", () -> new ButtonBlock(BlockSetType.SPRUCE, 10,
        BlockBehaviour.Properties.m_308003_(Blocks.SPRUCE_BUTTON) ));
    public static final RegistryObject<Block> WHITE_PINE_PRESSURE_PLATE = registerBlock("white_pine_pressure_plate",
         () -> new PressurePlateBlock(BlockSetType.SPRUCE,BlockBehaviour.Properties.m_308003_(Blocks.SPRUCE_PLANKS)));
  
    public static final RegistryObject<Block> WHITE_PINE_FENCE = registerBlock("white_pine_fence", () -> new FenceBlock(BlockBehaviour.Properties.m_308003_(Blocks.SPRUCE_PLANKS)));
    public static final RegistryObject<Block> WHITE_PINE_FENCE_GATE = registerBlock("white_pine_fence_gate", () -> new FenceGateBlock(BlockBehaviour.Properties.m_308003_(Blocks.SPRUCE_PLANKS),SoundEvents.CHERRY_WOOD_FENCE_GATE_OPEN,SoundEvents.CHERRY_WOOD_FENCE_GATE_CLOSE, WoodType.SPRUCE));
    public static final RegistryObject<Block> WHITE_PINE_WALL = registerBlock("white_pine_wall", () -> new WallBlock(BlockBehaviour.Properties.m_308003_(Blocks.SPRUCE_PLANKS)));

    public static final RegistryObject<Block> WHITE_PINE_DOOR = registerBlock("white_pine_door", () -> new DoorBlock(BlockSetType.SPRUCE,BlockBehaviour.Properties.m_308003_(Blocks.SPRUCE_PLANKS).noOcclusion()));
    public static final RegistryObject<Block> WHITE_PINE_TRAP_DOOR = registerBlock("white_pine_trap_door", () -> new TrapDoorBlock(BlockSetType.SPRUCE,BlockBehaviour.Properties.m_308003_(Blocks.SPRUCE_PLANKS).noOcclusion()));

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block){
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block){
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }
    
    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}
