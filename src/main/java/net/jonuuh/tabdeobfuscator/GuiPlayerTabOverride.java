package net.jonuuh.tabdeobfuscator;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiIngame;
import net.minecraft.client.gui.GuiPlayerTabOverlay;
import net.minecraft.client.network.NetworkPlayerInfo;

public class GuiPlayerTabOverride extends GuiPlayerTabOverlay
{
    public GuiPlayerTabOverride(Minecraft mc, GuiIngame guiIngame)
    {
        super(mc, guiIngame);
    }

    @Override
    public String getPlayerName(NetworkPlayerInfo playerInfo)
    {
        return super.getPlayerName(playerInfo).replace("\u00a7" + "k", "");
    }
}
