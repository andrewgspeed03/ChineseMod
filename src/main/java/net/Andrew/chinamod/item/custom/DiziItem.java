package net.Andrew.chinamod.item.custom;

import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;

public class DiziItem extends Item {
    public DiziItem(Properties pProperties){
        super(pProperties);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        if(pContext.getLevel().isClientSide()){
            Player player = pContext.getPlayer();
            boolean playNote = false;

            
        }


        return InteractionResult.SUCCESS;
    }

}
