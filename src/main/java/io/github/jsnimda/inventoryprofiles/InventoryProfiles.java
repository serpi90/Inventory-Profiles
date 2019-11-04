package io.github.jsnimda.inventoryprofiles;

import fi.dy.masa.malilib.event.InitializationHandler;
import io.github.jsnimda.inventoryprofiles.forge.ForgeEventHandler;
import io.github.jsnimda.inventoryprofiles.gui.GuiConfigs;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.ExtensionPoint;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;

/**
 * InventoryProfiles
 */
@Mod(ModInfo.MOD_ID)
public class InventoryProfiles {

  public InventoryProfiles() {

    MinecraftForge.EVENT_BUS.register(new ForgeEventHandler());

    ModLoadingContext.get().registerExtensionPoint(ExtensionPoint.CONFIGGUIFACTORY, ()->{
      return (x,y)->new GuiConfigs();
    });

    InitializationHandler.getInstance().registerInitializationHandler(new InitHandler());
    
  }

}