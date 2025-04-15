package de.tjorven.angelring.gui;

import com.mojang.blaze3d.systems.RenderSystem;
import de.tjorven.angelring.AngelRingMod;
import de.tjorven.angelring.gui.menu.BigCraftingMenu;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class BigCraftingScreen extends AbstractContainerScreen<BigCraftingMenu> {

    private static ResourceLocation TEXTURE = new ResourceLocation(AngelRingMod.MODID, "textures/gui/10x10_crafting_table.png");

    public BigCraftingScreen(BigCraftingMenu menu, Inventory playerInventory, Component title) {
        super(menu, playerInventory, title);
    }

    @Override
    protected void renderBg(GuiGraphics p_283065_, float p_97788_, int p_97789_, int p_97790_) {
        // TODO: Render the background of the crafting table
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, TEXTURE);
        int i = (width - imageWidth) / 2;
        int j = (height - imageHeight) / 2;

        p_283065_.blit(TEXTURE, i, j, 0, 0, imageWidth, imageHeight);
    }

    @Override
    public void render(GuiGraphics p_283479_, int p_283661_, int p_281248_, float p_281886_) {
        renderBackground(p_283479_);
        super.render(p_283479_, p_283661_, p_281248_, p_281886_);
        renderTooltip(p_283479_, p_283661_, p_281248_);
    }
}
