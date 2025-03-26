package de.tjorven.angelring.item;

import de.tjorven.angelring.AngelRingMod;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, AngelRingMod.MODID);

    public static final RegistryObject<Item> ANGEL_RING = ITEMS.register("angel_ring",
            () -> new AngelRing(new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> FIRE_PROTECTION_NECKLACE = ITEMS.register("fire_necklace",
            () -> new FireNecklace(new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> WATER_GEM = ITEMS.register("water_gem",
            () -> new WaterGem(new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> ANGEL_WING = ITEMS.register("angel_wing",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> ANGEL_FEATHER = ITEMS.register("angel_feather",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> BASE_RING = ITEMS.register("base_ring",
            () -> new Item(new Item.Properties()));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
