package net.Andrew.chinamod.datagen;

import net.Andrew.chinamod.ChinaMod;
import net.Andrew.chinamod.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider{

    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, ChinaMod.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
       simpleItem(ModItems.COOKED_RICE);

       simpleItem(ModItems.PINE_CONE);

       simpleItem(ModItems.RAW_SILK);
       simpleItem(ModItems.SILK);
       
       simpleItem(ModItems.WATER_DOWSER);
    }
    
    private ItemModelBuilder simpleItem(RegistryObject<Item> item){
        return withExistingParent(item.getId().getPath(),
            new ResourceLocation("item/generated")).texture("layer0",
            new ResourceLocation(ChinaMod.MODID, "item/" + item.getId().getPath()));
    }
}
