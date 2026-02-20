package net.inertia4104.bubblegumMod.item;

import net.inertia4104.bubblegumMod.BubblegumMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.CreativeModeTab;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB
            = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, BubblegumMod.MODID);

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
