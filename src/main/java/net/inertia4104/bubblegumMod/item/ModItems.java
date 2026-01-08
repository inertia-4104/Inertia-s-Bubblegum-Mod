package net.inertia4104.bubblegumMod.item;

import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.inertia4104.bubblegumMod.BubblegumMod;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(BubblegumMod.MODID);

    public static final DeferredItem<Item> REDGUM = ITEMS.register("redgum",
            () -> new Item(new Item.Properties().food(FoodItemProperties.REDGUM)));
    public static final DeferredItem<Item> BLUEGUM = ITEMS.register("bluegum",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> GREENGUM = ITEMS.register("greengum",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> PINKGUM = ITEMS.register("pinkgum",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> PURPLEGUM = ITEMS.register("purplegum",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> ORANGEGUM = ITEMS.register("orangegum",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> YELLOWGUM = ITEMS.register("yellowgum",
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
