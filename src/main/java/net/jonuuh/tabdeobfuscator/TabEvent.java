package net.jonuuh.tabdeobfuscator;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.network.NetworkPlayerInfo;
import net.minecraft.scoreboard.ScorePlayerTeam;
import net.minecraft.scoreboard.Scoreboard;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class TabEvent
{
    private final Minecraft mc;
    private final GuiPlayerTabOverride tabGui;

    public TabEvent()
    {
        this.mc = Minecraft.getMinecraft();
        this.tabGui = new GuiPlayerTabOverride(mc, mc.ingameGUI);
    }

    @SubscribeEvent
    public void onPreRenderTabGui(RenderGameOverlayEvent.Pre event)
    {
        if (event.type == RenderGameOverlayEvent.ElementType.PLAYER_LIST && isAnyNameObfuscated(mc))
        {
            event.setCanceled(true);
            Scoreboard sb = mc.theWorld.getScoreboard();
            tabGui.renderPlayerlist(new ScaledResolution(mc).getScaledWidth(), sb, sb.getObjectiveInDisplaySlot(0));
        }
    }

    private boolean isAnyNameObfuscated(Minecraft mc)
    {
        if (mc.getNetHandler() == null || mc.getNetHandler().getPlayerInfoMap() == null)
        {
            return false;
        }
        return mc.getNetHandler().getPlayerInfoMap().stream().map(this::getFormattedName).anyMatch(name -> name.contains("\u00a7k"));
    }

    private String getFormattedName(NetworkPlayerInfo playerInfo)
    {
        return playerInfo.getDisplayName() != null ? playerInfo.getDisplayName().getFormattedText()
                : ScorePlayerTeam.formatPlayerName(playerInfo.getPlayerTeam(), playerInfo.getGameProfile().getName());
    }
}
