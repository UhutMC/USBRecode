package me.skyblock.commands;

import me.skyblock.gui.SkyblockMenu;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SkyblockMenuCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("stfu hoe");
            return true;
        }
        Player player = (Player) sender;

        SkyblockMenu.openMenu(player);
        return false;
    }
}
