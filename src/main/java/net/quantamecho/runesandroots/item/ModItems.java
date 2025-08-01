package net.quantamecho.runesandroots.item;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.quantamecho.runesandroots.RunesAndRoots;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, RunesAndRoots.MOD_ID);

    public static final RegistryObject<Item> RUNEOFDECAY = ITEMS.register("rune_of_decay",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RUNEOFBEASTHEART = ITEMS.register("rune_of_beastheart",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RUNEOFCONTAMINATION = ITEMS.register("rune_of_contamination",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RUNEOFDREAMSTEP = ITEMS.register("rune_of_dreamstep",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RUNEOFENDURENCE = ITEMS.register("rune_of_endurence",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RUNEOFMETAMORPHISIS = ITEMS.register("rune_of_metamorphisis",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RUNEOFRENEWAL = ITEMS.register("rune_of_renewal",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> EMPTYRUNE = ITEMS.register("empty_rune",
            () -> new Item(new Item.Properties()));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}