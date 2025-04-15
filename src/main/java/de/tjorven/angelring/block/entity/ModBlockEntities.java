package de.tjorven.angelring.block.entity;

import de.tjorven.angelring.AngelRingMod;
import de.tjorven.angelring.block.ModBlocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, AngelRingMod.MODID);

    public static final RegistryObject<BlockEntityType<BigCraftingTableBlockEntity>> BIG_CRAFTING_TABLE_BE =
            BLOCK_ENTITIES.register("big_crafting_table_be", () ->
                    BlockEntityType.Builder.of(BigCraftingTableBlockEntity::new,
                            ModBlocks.BIG_CRAFTING_TABLE.get()).build(null));


    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
