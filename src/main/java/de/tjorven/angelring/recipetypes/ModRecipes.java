package de.tjorven.angelring.recipetypes;

import de.tjorven.angelring.AngelRingMod;
import de.tjorven.angelring.jsonhandling.BigCraftingRecipeSerializer;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModRecipes {
    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS = DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, AngelRingMod.MODID);
    public static final DeferredRegister<RecipeType<?>> TYPES = DeferredRegister.create(ForgeRegistries.RECIPE_TYPES, AngelRingMod.MODID);

    public static final RegistryObject<RecipeSerializer<TenXTenCraftingRecipe>> BIG_CRAFTING_SERIALIZER =
            SERIALIZERS.register("custom_crafting", BigCraftingRecipeSerializer::new);

    public static final RegistryObject<RecipeType<TenXTenCraftingRecipe>> BIG_CRAFTING_TYPE =
            TYPES.register("10x10_crafting", () -> new RecipeType<>() {
                public String toString() {
                    return "angelringmod:10x10_crafting";
                }
            });
}
