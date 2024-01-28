package net.jonuuh.examplemod;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

@Mod(
        modid = "examplemod",
        version = "1.2.0",
        acceptedMinecraftVersions = "[1.8.9]"
)
public class ExampleMod
{
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
    }
}
