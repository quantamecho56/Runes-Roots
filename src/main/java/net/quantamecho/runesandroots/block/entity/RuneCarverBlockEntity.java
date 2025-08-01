package net.quantamecho.runesandroots.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.Container;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.quantamecho.runesandroots.screen.RuneCarverMenu;
import net.quantamecho.runesandroots.block.entity.ModBlockEntities;

import java.util.List;
import java.util.stream.IntStream;

import static net.minecraft.world.level.block.Block.popResource;

public class RuneCarverBlockEntity extends BlockEntity implements MenuProvider, Container {
    private final ItemStack[] items = new ItemStack[10]; // 9 input + 1 output

    public RuneCarverBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.RUNE_CARVER_BE.get(), pos, state);
        clearContent();
    }

    // === MenuProvider methods ===

    @Override
    public Component getDisplayName() {
        return Component.translatable("block.runes_and_roots.rune_carver");
    }

    @Override
    public AbstractContainerMenu createMenu(int id, Inventory playerInventory, Player player) {
        return new RuneCarverMenu(id, playerInventory, this);
    }

    // === Container methods ===

    @Override
    public int getContainerSize() {
        return items.length;
    }

    @Override
    public boolean isEmpty() {
        for (ItemStack stack : items) {
            if (!stack.isEmpty()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public ItemStack getItem(int index) {
        return items[index];
    }

    @Override
    public ItemStack removeItem(int index, int count) {
        return ContainerHelper.removeItem(items, index, count);
    }

    @Override
    public ItemStack removeItemNoUpdate(int index) {
        ItemStack stack = items[index];
        items[index] = ItemStack.EMPTY;
        return stack;
    }

    @Override
    public void setItem(int index, ItemStack stack) {
        items[index] = stack;
        if (stack.getCount() > getMaxStackSize()) {
            stack.setCount(getMaxStackSize());
        }
    }

    @Override
    public boolean stillValid(Player player) {
        return true;
    }

    @Override
    public void clearContent() {
        for (int i = 0; i < items.length; i++) {
            items[i] = ItemStack.EMPTY;
        }
    }

    public void drops() {
        SimpleContainer inv = new SimpleContainer(getContainerSize());
        for (int i = 0; i < getContainerSize(); i++) {
            inv.setItem(i, getItem(i));
        }

        if (this.level != null && !this.level.isClientSide) {
            for (int i = 0; i < inv.getContainerSize(); i++) {
                popResource(this.level, this.worldPosition, inv.getItem(i));
            }
        }
    }

    // Add ticking logic here if needed
    public void tick(Level level, BlockPos pos, BlockState state) {
        // Crafting logic goes here, if any
    }
}