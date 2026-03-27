package net.inertia4104.bubblegumMod;

import net.inertia4104.bubblegumMod.block.ModBlocks;
import net.inertia4104.bubblegumMod.item.ModCreativeModeTabs;
import net.inertia4104.bubblegumMod.item.ModItems;
import org.slf4j.Logger;
import com.mojang.logging.LogUtils;
import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;

 /*/
 This program is edited from the environment's "Setup" file. Lines marked with "I" at the end of a comment are snippets built-in to the file.
 This program is only for the initialization and related snippets. Hence a large reliance on built-in Minecraft/Neoforge code
  */




@Mod(BubblegumMod.MODID) // "I"
public class BubblegumMod {
    // Define mod id for everything to reference
    public static final String MODID = "inertiasbubblegummod";

    public static final Logger LOGGER = LogUtils.getLogger(); // "I"
    // FML will recognize some parameter types like IEventBus or ModContainer and pass them in automatically.

    // The following BubblegumMod class is written by me with help from the Neoforge Documentation and it's guidelines on setup.
    public BubblegumMod(IEventBus modEventBus, ModContainer modContainer) {
        modEventBus.addListener(this::commonSetup);
        ModCreativeModeTabs.register(modEventBus);
        NeoForge.EVENT_BUS.register(this);
        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        modEventBus.addListener(this::addCreative);
        // Register our mod's ModConfigSpec so that FML can create and load the config file for us
        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(FMLCommonSetupEvent event) {} // "I"

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event) {
    if(event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
        event.accept(ModItems.REDGUM);
        event.accept(ModItems.BLUEGUM);
        event.accept(ModItems.GREENGUM);
        event.accept(ModItems.PINKGUM);
        event.accept(ModItems.ORANGEGUM);
        event.accept(ModItems.PURPLEGUM);
        event.accept(ModItems.YELLOWGUM);
    }
    if (event.getTabKey() == CreativeModeTabs.FUNCTIONAL_BLOCKS){
        event.accept(ModBlocks.BUBBLEGUMMACHINE);
        event.accept(ModBlocks.GASHAPON);
    }
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {} // "I"
}
