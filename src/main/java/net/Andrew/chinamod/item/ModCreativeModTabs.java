package net.Andrew.chinamod.item;

import net.Andrew.chinamod.ChinaMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab>  CREATIVE_MODE_TABS=
        DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ChinaMod.MODID);


    public static final RegistryObject<CreativeModeTab> CHINA_TAB = CREATIVE_MODE_TABS.register("china_tab",
     () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.SILK.get()))
        .title(Component.translatable("creativetab.china_tab"))
        .displayItems((pParameters, pOutput) ->{
            pOutput.accept(ModItems.RAW_SILK.get());
            pOutput.accept(ModItems.SILK.get());
        })
        .build());


    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
