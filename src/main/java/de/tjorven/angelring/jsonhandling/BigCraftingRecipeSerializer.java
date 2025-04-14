package de.tjorven.angelring.jsonhandling;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import de.tjorven.angelring.recipetypes.TenXTenCraftingRecipe;
import net.minecraft.core.NonNullList;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.ShapedRecipe;

import java.util.HashMap;
import java.util.Map;

public class BigCraftingRecipeSerializer implements RecipeSerializer<TenXTenCraftingRecipe> {
    @Override
    public TenXTenCraftingRecipe fromJson(ResourceLocation recipeId, JsonObject json) {
        JsonArray patternArray = GsonHelper.getAsJsonArray(json, "pattern");
        int height = patternArray.size();
        int width = patternArray.get(0).getAsString().length();

        Map<String, Ingredient> key = new HashMap<>();
        JsonObject keyObj = GsonHelper.getAsJsonObject(json, "key");
        for (Map.Entry<String, JsonElement> entry : keyObj.entrySet()) {
            key.put(entry.getKey(), Ingredient.fromJson(entry.getValue()));
        }

        NonNullList<Ingredient> ingredients = NonNullList.withSize(100, Ingredient.EMPTY);
        for (int y = 0; y < height; y++) {
            String line = patternArray.get(y).getAsString();
            for (int x = 0; x < width; x++) {
                String symbol = line.substring(x, x + 1);
                Ingredient ingredient = key.getOrDefault(symbol, Ingredient.EMPTY);
                ingredients.set(x + y * 10, ingredient); // 10x10 Grid, Padding wenn nötig
            }
        }

        JsonObject resultObj = GsonHelper.getAsJsonObject(json, "result");
        ItemStack result = ShapedRecipe.itemStackFromJson(resultObj);

        return new TenXTenCraftingRecipe(recipeId, result, ingredients);
    }

    @Override
    public TenXTenCraftingRecipe fromNetwork(ResourceLocation id, FriendlyByteBuf buffer) {
        ItemStack output = buffer.readItem();
        int size = buffer.readInt();
        NonNullList<Ingredient> ingredients = NonNullList.withSize(size, Ingredient.EMPTY);
        for (int i = 0; i < size; i++) {
            ingredients.set(i, Ingredient.fromNetwork(buffer));
        }
        return new TenXTenCraftingRecipe(id, output, ingredients);
    }

    @Override
    public void toNetwork(FriendlyByteBuf buffer, TenXTenCraftingRecipe recipe) {
        buffer.writeItemStack(recipe.getOutput(), false);
        buffer.writeInt(recipe.getIngredients().size());
        for (Ingredient ingredient : recipe.getIngredients()) {
            ingredient.toNetwork(buffer);
        }
    }
}
