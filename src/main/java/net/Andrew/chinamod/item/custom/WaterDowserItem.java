package net.Andrew.chinamod.item.custom;

import java.util.List;

import javax.annotation.Nullable;

import net.minecraft.client.resources.language.I18n;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

public class WaterDowserItem extends Item{
    public WaterDowserItem(Properties pProperties){
        super(pProperties);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        if(!pContext.getLevel().isClientSide()){
            BlockPos positonClicked = pContext.getClickedPos();
            Player player = pContext.getPlayer();
            boolean foundWater = false;

            for(int i = 0; i <= positonClicked.getY() + 64; i++){
                BlockState state = pContext.getLevel().getBlockState(positonClicked.below(i));

                if(isWaterBlock(state)){
                    outputWaterCoordinates(positonClicked.below(i), player, state.getBlock());
                    foundWater = true;

                    break;
                }
            }

            if(!foundWater){
                player.sendSystemMessage(Component.literal("No Water Found!"));
            }
        }

        pContext.getItemInHand().hurtAndBreak(1, pContext.getPlayer(), 
            player -> player.broadcastBreakEvent(player.getUsedItemHand()));

        return InteractionResult.SUCCESS;
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents,
            TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("tooltip.chinamod.water_dowser.tooltip"));
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }

    private void outputWaterCoordinates(BlockPos blockPos, Player player, Block block){
        player.sendSystemMessage(Component.literal("Found " + I18n.get(block.getDescriptionId()) + " at (" +
        blockPos.getX() + ", " + blockPos.getY() + ", " + blockPos.getZ() + ")"));
    }

    private boolean isWaterBlock(BlockState state) {
        return state.is(Blocks.WATER);
    }
}
