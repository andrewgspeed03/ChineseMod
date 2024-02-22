package net.Andrew.chinamod.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public class GuBlock extends Block{
    public GuBlock(Properties pProperties){
        super(pProperties);
    }

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand,
            BlockHitResult pHit) {
                double random = 0.5 + Math.random() * (1 - 0.5);
                pLevel.playSound(pPlayer, pPos,SoundEvents.NOTE_BLOCK_BASEDRUM.get(), SoundSource.BLOCKS,50f,(float)random);  
                
        return InteractionResult.SUCCESS;
    }
}
