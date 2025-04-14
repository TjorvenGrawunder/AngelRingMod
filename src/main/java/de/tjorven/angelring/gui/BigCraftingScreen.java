package de.tjorven.angelring.gui;

import de.tjorven.angelring.menu.BigCraftingMenu;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.screens.inventory.CraftingScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;

public class BigCraftingScreen extends AbstractContainerScreen<BigCraftingMenu> {
    public BigCraftingScreen(BigCraftingMenu menu, Inventory playerInventory, Component title) {
        super(menu, playerInventory, title);
    }

    @Override
    protected void renderBg(GuiGraphics p_283065_, float p_97788_, int p_97789_, int p_97790_) {
        // TODO: Render the background of the crafting table
    }
}
