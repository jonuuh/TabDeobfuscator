package net.jonuuh.tabdeobfuscator;

import net.minecraft.client.Minecraft;
import net.minecraft.client.network.NetworkPlayerInfo;
import net.minecraft.scoreboard.ScorePlayerTeam;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Util
{
    public static Set<String> getUnformattedPlayerNames(Minecraft mc)
    {
        Set<String> playerNames = new HashSet<>();
        if (mc.getNetHandler() != null && mc.getNetHandler().getPlayerInfoMap() != null)
        {
            playerNames = mc.getNetHandler().getPlayerInfoMap().stream()
                    .map(playerInfo -> playerInfo.getGameProfile().getName())
                    .collect(Collectors.toSet());
        }
        return playerNames;
    }

    public static boolean isAnyNameObfuscated(Minecraft mc)
    {
        for (String name : getFormattedPlayerNames(mc))
        {
            if (name.contains("\u00a7" + "k"))
            {
                return true;
            }
        }
        return false;
    }

    private static Set<String> getFormattedPlayerNames(Minecraft mc)
    {
        Set<String> playerNames = new HashSet<>();
        if (mc.getNetHandler() != null && mc.getNetHandler().getPlayerInfoMap() != null)
        {
            playerNames = mc.getNetHandler().getPlayerInfoMap().stream()
                    .map(Util::getFormattedPlayerName)
                    .collect(Collectors.toSet());
        }
        return playerNames;
    }

    private static String getFormattedPlayerName(NetworkPlayerInfo playerInfo)
    {
        return playerInfo.getDisplayName() != null
                ? playerInfo.getDisplayName().getFormattedText()
                : ScorePlayerTeam.formatPlayerName(playerInfo.getPlayerTeam(), playerInfo.getGameProfile().getName());
    }
}
