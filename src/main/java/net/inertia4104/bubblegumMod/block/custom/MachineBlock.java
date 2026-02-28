package net.inertia4104.bubblegumMod.block.custom;


import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.tick.ServerTickEvent;
import java.util.Random;
import com.mojang.serialization.MapCodec;
import net.inertia4104.bubblegumMod.block.ModBlocks;
import net.inertia4104.bubblegumMod.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;


public class MachineBlock extends HorizontalDirectionalBlock {
    public static final MapCodec<MachineBlock> CODEC = simpleCodec(MachineBlock::new);
    private static final VoxelShape SHAPE = Block.box(3.0, 0.0, 3.0, 13.0, 16.0, 13.0);

    public MachineBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        Random random = new Random();
        int stackrandom = random.nextInt(7 - 1 + 1) + 1;
        if (stack.is(Items.IRON_NUGGET))
        {
            player.getInventory().removeItem(player.getInventory().selected, 1);
            if (stackrandom == 1) {
                player.addItem(new ItemStack(ModItems.REDGUM.get()));
            } else if (stackrandom == 2) {
                player.addItem(new ItemStack(ModItems.GREENGUM.get()));
            } else if (stackrandom == 3) {
                player.addItem(new ItemStack(ModItems.YELLOWGUM.get()));
            } else if (stackrandom == 4) {
                player.addItem(new ItemStack(ModItems.PURPLEGUM.get()));
            } else if (stackrandom == 5) {
                player.addItem(new ItemStack(ModItems.PINKGUM.get()));
            } else if (stackrandom == 6) {
                player.addItem(new ItemStack(ModItems.BLUEGUM.get()));
            } else if (stackrandom == 7) {
                player.addItem(new ItemStack(ModItems.ORANGEGUM.get()));
            }
            ((ServerLevel) level).sendParticles(new BlockParticleOption(ParticleTypes.BLOCK, state.getBlock().defaultBlockState()),
                    pos.getX() + 0.2, pos.getY() + 0.2, pos.getZ(), 90, 0,0,0, 1);
            return ItemInteractionResult.SUCCESS;
        }
        return ItemInteractionResult.FAIL;
    }

    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }

    @Override
    protected MapCodec<? extends HorizontalDirectionalBlock> codec() {
        return CODEC;
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }
}