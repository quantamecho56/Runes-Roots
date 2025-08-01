package net.quantamecho.runesandroots.block.entity;

import net.quantamecho.runesandroots.RunesAndRoots;
import net.quantamecho.runesandroots.block.ModBlocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, RunesAndRoots.MOD_ID);

    public static final RegistryObject<BlockEntityType<RuneCarverBlockEntity>> RUNE_CARVER_BE =
            BLOCK_ENTITIES.register("rune_carver_be", () ->
                    BlockEntityType.Builder.of(RuneCarverBlockEntity::new,
                            ModBlocks.RUNE_CARVER.get()).build(null));


    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}