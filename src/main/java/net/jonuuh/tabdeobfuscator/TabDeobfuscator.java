package net.jonuuh.tabdeobfuscator;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.scoreboard.Scoreboard;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod(
        modid = "tabdeobfuscator",
        version = "1.0.0",
        acceptedMinecraftVersions = "[1.8.9]"
)
public class TabDeobfuscator
{
    private static Minecraft mc;
    private static GuiPlayerTabOverride tabGui;

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        mc = Minecraft.getMinecraft();
        tabGui = new GuiPlayerTabOverride(mc, mc.ingameGUI);
        MinecraftForge.EVENT_BUS.register(new TabEvent());
    }

    private static class TabEvent
    {
        @SubscribeEvent
        public void onPreRenderTabGui(RenderGameOverlayEvent.Pre event)
        {
            if (event.type == RenderGameOverlayEvent.ElementType.PLAYER_LIST)
            {
                event.setCanceled(true);

                Scoreboard sb = mc.theWorld.getScoreboard();
                tabGui.renderPlayerlist(new ScaledResolution(mc).getScaledWidth(), sb, sb.getObjectiveInDisplaySlot(0));
            }
        }
    }

}
