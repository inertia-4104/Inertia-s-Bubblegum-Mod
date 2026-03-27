package net.inertia4104.bubblegumMod.block;

import net.inertia4104.bubblegumMod.BubblegumMod;
import net.inertia4104.bubblegumMod.block.custom.GashaponBlock;
import net.inertia4104.bubblegumMod.block.custom.MachineBlock;
import net.inertia4104.bubblegumMod.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(BubblegumMod.MODID);
    // Creates a deffered register for the blocks, see documentation.

    // Both methods below just add it to the newly created registy
    public static final DeferredBlock<Block> BUBBLEGUMMACHINE = registerBlock("bubblegummachine",
            () -> new MachineBlock(BlockBehaviour.Properties.of().noOcclusion().strength(3f)));

    public static final DeferredBlock<Block> GASHAPON = registerBlock("gashapon", () -> new GashaponBlock(BlockBehaviour
            .Properties.of().noOcclusion().strength(3f)));

    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block){
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    // Blocks need held items called blockitems in order to be used, this registers them.
    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    // Finally, this basically tells minecraft to run all this whenever the registering for blocks is happening by calling upon the almighty eventbus
    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
