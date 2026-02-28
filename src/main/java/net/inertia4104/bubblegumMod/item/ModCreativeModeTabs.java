package net.inertia4104.bubblegumMod.item;

import net.inertia4104.bubblegumMod.BubblegumMod;
import net.inertia4104.bubblegumMod.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB
            = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, BubblegumMod.MODID);

    public static final Supplier<CreativeModeTab> BUBBLEGUM_MOD_ITEMS_TAB = CREATIVE_MODE_TAB.register("bubblegum_mod_items_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.BUBBLEGUMMACHINE.get())).title(Component.translatable("creativetab.inertiasbubblegummod.bubblegum"))
                    .displayItems((parameters, output) -> {
                        output.accept(ModItems.REDGUM);
                        output.accept(ModItems.BLUEGUM);
                        output.accept(ModItems.GREENGUM);
                        output.accept(ModItems.PINKGUM);
                        output.accept(ModItems.ORANGEGUM);
                        output.accept(ModItems.PURPLEGUM);
                        output.accept(ModItems.YELLOWGUM);
                        output.accept(ModBlocks.BUBBLEGUMMACHINE);

                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
