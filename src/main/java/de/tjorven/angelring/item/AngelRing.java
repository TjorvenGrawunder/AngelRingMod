package de.tjorven.angelring.item;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class AngelRing extends Item {
    public AngelRing(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
        if (!world.isClientSide) {
            boolean canFly = !player.getAbilities().mayfly;
            player.getAbilities().mayfly = canFly;
            player.getAbilities().flying = canFly;
            player.onUpdateAbilities();
        }
        return InteractionResultHolder.success(player.getItemInHand(hand));
    }
}
