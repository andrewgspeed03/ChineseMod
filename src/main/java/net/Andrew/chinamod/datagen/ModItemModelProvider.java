package net.Andrew.chinamod.datagen;

import net.Andrew.chinamod.ChinaMod;
import net.Andrew.chinamod.block.ModBlocks;
import net.Andrew.chinamod.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider{

    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, ChinaMod.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.COOKED_RICE);

        simpleItem(ModItems.PINE_CONE);

        simpleItem(ModItems.JADE);

        simpleItem(ModItems.RAW_SILK);
        simpleItem(ModItems.SILK);
       
        simpleItem(ModItems.WATER_DOWSER);

        simpleBlockItem(ModBlocks.WHITE_PINE_DOOR);

        fenceItem(ModBlocks.WHITE_PINE_FENCE, ModBlocks.WHITE_PINE_PLANK);
        buttonItem(ModBlocks.WHITE_PINE_BUTTON, ModBlocks.WHITE_PINE_PLANK);
        wallItem(ModBlocks.WHITE_PINE_WALL, ModBlocks.WHITE_PINE_PLANK);

        evenSimplerBlockItem(ModBlocks.WHITE_PINE_STAIRS);
        evenSimplerBlockItem(ModBlocks.WHITE_PINE_SLAB);
        evenSimplerBlockItem(ModBlocks.WHITE_PINE_PRESSURE_PLATE);
        evenSimplerBlockItem(ModBlocks.WHITE_PINE_FENCE_GATE);

        trapdoorItem(ModBlocks.WHITE_PINE_TRAP_DOOR);
    }
    
    private ItemModelBuilder simpleItem(RegistryObject<Item> item){
        return withExistingParent(item.getId().getPath(),
            new ResourceLocation("item/generated")).texture("layer0",
            new ResourceLocation(ChinaMod.MODID, "item/" + item.getId().getPath()));
    }
    public void evenSimplerBlockItem(RegistryObject<Block> block) {
        this.withExistingParent(ChinaMod.MODID + ":" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
                modLoc("block/" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath()));
    }

    public void trapdoorItem(RegistryObject<Block> block) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
                modLoc("block/" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath() + "_bottom"));
    }
    public void fenceItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock){
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/fence_inventory"))
            .texture("texture", new ResourceLocation(ChinaMod.MODID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }
    public void buttonItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock){
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/button_inventory"))
            .texture("texture", new ResourceLocation(ChinaMod.MODID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }
    public void wallItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock){
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/wall_inventory"))
            .texture("wall", new ResourceLocation(ChinaMod.MODID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    private ItemModelBuilder simpleBlockItem(RegistryObject<Block> item){
        return withExistingParent(item.getId().getPath(),
            new ResourceLocation("item/generated")).texture("layer0",
            new ResourceLocation(ChinaMod.MODID, "block/" + item.getId().getPath()));
    }
}
