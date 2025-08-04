package net.quantamecho.runesandroots;

import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.quantamecho.runesandroots.screen.ModMenuTypes;
import net.quantamecho.runesandroots.screen.RuneCarverScreen;

@Mod.EventBusSubscriber(modid = RunesAndRoots.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class Client {
    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event)
    {
        MenuScreens.register(ModMenuTypes.RUNE_CARVER_MENU.get(), RuneCarverScreen::new);
    }
}
