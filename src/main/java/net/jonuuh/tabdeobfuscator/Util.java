package net.jonuuh.tabdeobfuscator;

import net.minecraft.client.Minecraft;
import net.minecraft.client.network.NetworkPlayerInfo;
import net.minecraft.scoreboard.ScorePlayerTeam;

public class Util
{
    public static boolean isAnyNameObfuscated(Minecraft mc)
    {
        if (mc.getNetHandler() == null || mc.getNetHandler().getPlayerInfoMap() == null)
        {
            return false;
        }

        return mc.getNetHandler().getPlayerInfoMap().stream().map(Util::getFormattedName).anyMatch(name -> name.contains("\u00a7k"));
    }

    private static String getFormattedName(NetworkPlayerInfo playerInfo)
    {
        return playerInfo.getDisplayName() != null ? playerInfo.getDisplayName().getFormattedText()
                : ScorePlayerTeam.formatPlayerName(playerInfo.getPlayerTeam(), playerInfo.getGameProfile().getName());
    }
}
