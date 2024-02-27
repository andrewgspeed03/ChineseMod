package net.Andrew.chinamod.item;


import net.Andrew.chinamod.ChinaMod;
import net.Andrew.chinamod.item.custom.FuelItem;
import net.Andrew.chinamod.item.custom.ModToolTiers;
import net.Andrew.chinamod.item.custom.WaterDowserItem;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.SwordItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = 
        DeferredRegister.create(ForgeRegistries.ITEMS, ChinaMod.MOD_ID);

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

    public static final RegistryObject<Item> JADE_JIAN = ITEMS.register("jade_jian",
        () -> new SwordItem(ModToolTiers.JADE, 4, 2, new Item.Properties()));
    public static final RegistryObject<Item> JADE_PICKAXE = ITEMS.register("jade_pickaxe",
        () -> new PickaxeItem(ModToolTiers.JADE, 1, 1, new Item.Properties()));
    public static final RegistryObject<Item> JADE_AXE = ITEMS.register("jade_axe",
        () -> new AxeItem(ModToolTiers.JADE, 7, 1, new Item.Properties()));
    public static final RegistryObject<Item> JADE_SHOVEL = ITEMS.register("jade_shovel",
        () -> new ShovelItem(ModToolTiers.JADE, 0, 0, new Item.Properties()));
    public static final RegistryObject<Item> JADE_HOE = ITEMS.register("jade_hoe",
        () -> new HoeItem(ModToolTiers.JADE, 0, 0, new Item.Properties()));

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
    
}
