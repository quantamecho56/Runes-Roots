package net.quantamecho.runesandroots;

import com.mojang.logging.LogUtils;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.quantamecho.runesandroots.block.ModBlocks;
import net.quantamecho.runesandroots.block.entity.ModBlockEntities;
import net.quantamecho.runesandroots.item.ModCreativeModTabs;
import net.quantamecho.runesandroots.item.ModItems;
import net.quantamecho.runesandroots.screen.ModMenuTypes;
import net.quantamecho.runesandroots.screen.RuneCarverScreen;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(RunesAndRoots.MOD_ID)
public class RunesAndRoots {
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "runes_and_roots";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    public RunesAndRoots(FMLJavaModLoadingContext context) {
        IEventBus modEventBus = context.getModEventBus();

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModBlockEntities.register(modEventBus);
        ModCreativeModTabs.register(modEventBus);
        ModMenuTypes.register(modEventBus);

        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {

    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event)
    {
        if(event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
            event.accept(ModItems.RUNEOFDECAY);
            event.accept(ModItems.RUNEOFBEASTHEART);
            event.accept(ModItems.RUNEOFCONTAMINATION);
            event.accept(ModItems.RUNEOFDREAMSTEP);
            event.accept(ModItems.RUNEOFENDURENCE);
            event.accept(ModItems.RUNEOFMETAMORPHISIS);
            event.accept(ModItems.RUNEOFRENEWAL);
        }
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {

    }
}
