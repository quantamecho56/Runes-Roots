package net.quantamecho.runesandroots.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.quantamecho.runesandroots.RunesAndRoots;
import net.quantamecho.runesandroots.block.ModBlocks;

public class ModCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREAVTIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, RunesAndRoots.MOD_ID);

    public static final RegistryObject<CreativeModeTab> RUNES_AND_ROOTS_TAB = CREAVTIVE_MODE_TABS.register("runes_and_roots_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.EMPTYRUNE.get()))
                    .title(Component.translatable("creativetab.runes_and_roots"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.EMPTYRUNE.get());
                        pOutput.accept(ModItems.RUNEOFCONTAMINATION.get());
                        pOutput.accept(ModItems.RUNEOFBEASTHEART.get());
                        pOutput.accept(ModItems.RUNEOFDECAY.get());
                        pOutput.accept(ModItems.RUNEOFDREAMSTEP.get());
                        pOutput.accept(ModItems.RUNEOFENDURENCE.get());
                        pOutput.accept(ModItems.RUNEOFMETAMORPHISIS.get());
                        pOutput.accept(ModItems.RUNEOFRENEWAL.get());
                        pOutput.accept(ModBlocks.RUNE_CARVER.get());
                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREAVTIVE_MODE_TABS.register(eventBus);
    }
}