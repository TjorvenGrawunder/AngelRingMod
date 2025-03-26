package de.tjorven.angelring;

import com.mojang.logging.LogUtils;
import de.tjorven.angelring.curiosbehaviour.AngelRingBehaviour;
import de.tjorven.angelring.curiosbehaviour.FireProtectionBehaviour;
import de.tjorven.angelring.curiosbehaviour.WaterBreathingBehaviour;
import de.tjorven.angelring.item.ModItems;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;
import top.theillusivec4.curios.api.CuriosApi;


// The value here should match an entry in the META-INF/mods.toml file
@Mod(AngelRingMod.MODID)
public class AngelRingMod {

    public static final String MODID = "angelringmod";
    public static final Logger LOGGER = LogUtils.getLogger();

    public AngelRingMod() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(modEventBus);

        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        curiosRegistry();
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if(event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
            event.accept(ModItems.ANGEL_RING);
            event.accept(ModItems.ANGEL_WING);
            event.accept(ModItems.ANGEL_FEATHER);
            event.accept(ModItems.BASE_RING);
            event.accept(ModItems.FIRE_PROTECTION_NECKLACE);
            event.accept(ModItems.WATER_GEM);
        }
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {

        }
    }

    private void curiosRegistry() {
        CuriosApi.registerCurio(ModItems.ANGEL_RING.get(), new AngelRingBehaviour());
        CuriosApi.registerCurio(ModItems.WATER_GEM.get(), new WaterBreathingBehaviour());
        CuriosApi.registerCurio(ModItems.FIRE_PROTECTION_NECKLACE.get(), new FireProtectionBehaviour());
    }
}
