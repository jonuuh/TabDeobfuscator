package net.jonuuh.tabdeobfuscator;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

@Mod(modid = "tabdeobfuscator", version = "1.1.2", acceptedMinecraftVersions = "[1.8.9]")
public class TabDeobfuscator
{
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        MinecraftForge.EVENT_BUS.register(new TabEvent());
    }
}
