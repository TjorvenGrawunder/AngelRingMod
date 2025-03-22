package de.tjorven.angelring.curiosbehaviour;

import net.minecraft.client.renderer.EffectInstance;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.level.NoteBlockEvent;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.type.capability.ICurioItem;

import java.util.Objects;

public class FireProtectionBehaviour implements ICurioItem {
    @Override
    public void curioTick(SlotContext slotContext, ItemStack stack) {
        if (slotContext.entity() instanceof Player player) {
            player.addEffect(new MobEffectInstance(Objects.requireNonNull(MobEffect.byId(12)), 20, 0));
        }
    }
}
