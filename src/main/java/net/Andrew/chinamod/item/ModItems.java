package net.Andrew.chinamod.item;


import net.Andrew.chinamod.ChinaMod;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = 
    DeferredRegister.create(ForgeRegistries.ITEMS, ChinaMod.MODID);

    public static final RegistryObject<Item> SILK = ITEMS.register("silk",
    () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> RAW_SILK = ITEMS.register("raw_silk",
    () -> new Item(new Item.Properties()));


    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
    
}
