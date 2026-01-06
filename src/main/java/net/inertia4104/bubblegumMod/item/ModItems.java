package net.inertia4104.bubblegumMod.item;

import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.inertia4104.bubblegumMod.BubblegumMod;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(BubblegumMod.MODID);

    public static final DeferredItem<Item> REDGUM = ITEMS.register("redgum",
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
