package net.Andrew.chinamod.item;


import net.Andrew.chinamod.ChinaMod;
import net.Andrew.chinamod.item.custom.FuelItem;
import net.Andrew.chinamod.item.custom.WaterDowserItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = 
        DeferredRegister.create(ForgeRegistries.ITEMS, ChinaMod.MODID);

    public static final RegistryObject<Item> JADE = ITEMS.register("jade", () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> SILK = ITEMS.register("silk",
    () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAW_SILK = ITEMS.register("raw_silk",
    () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> WATER_DOWSER = ITEMS.register("water_dowser",
    () -> new WaterDowserItem(new Item.Properties().durability(100)));

    public static final RegistryObject<Item> COOKED_RICE = ITEMS.register("cooked_rice",
    () -> new Item(new Item.Properties().food(ModFoods.COOKED_RICE)));

    public static final RegistryObject<Item> PINE_CONE = ITEMS.register("pine_cone",
    () -> new FuelItem(new Item.Properties(), 100));

    //public static final RegistryObject<Item> JIAN_SWORD = ITEMS.register("jian_sword",
    //() -> new SwordItem(new Item.Properties(), 100));

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
    
}
