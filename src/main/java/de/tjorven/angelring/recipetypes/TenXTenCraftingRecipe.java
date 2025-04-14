package de.tjorven.angelring.recipetypes;

import net.minecraft.core.NonNullList;
import net.minecraft.core.RegistryAccess;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.Container;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;

public class TenXTenCraftingRecipe implements Recipe<Container> {
    private final ResourceLocation id;
    private final ItemStack output;
    private final NonNullList<Ingredient> ingredients;

    public TenXTenCraftingRecipe(ResourceLocation id, ItemStack output, NonNullList<Ingredient> ingredients) {
        this.id = id;
        this.output = output;
        this.ingredients = ingredients;
    }

    @Override
    public boolean matches(Container container, Level level) {
        // Vergleiche container (100 Slots) mit den Zutaten
        // Hier musst du eigenes Grid-Matching schreiben
        return false;
    }

    @Override
    public ItemStack assemble(Container p_44001_, RegistryAccess p_267165_) {
        return output.copy();
    }

    public ItemStack getOutput() {
        return output.copy();
    }

    @Override
    public boolean canCraftInDimensions(int width, int height) {
        return width >= 10 && height >= 10;
    }

    @Override
    public ItemStack getResultItem(RegistryAccess p_267052_) {
        return output;
    }

    @Override
    public ResourceLocation getId() {
        return id;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return ModRecipes.BIG_CRAFTING_SERIALIZER.get();
    }

    @Override
    public RecipeType<?> getType() {
        return ModRecipes.BIG_CRAFTING_TYPE.get();
    }
}
