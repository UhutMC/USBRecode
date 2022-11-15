package me.skyblock.commands;

import me.skyblock.items.Items;
import me.skyblock.items.SItem;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Test implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) return true;

        if (!Items.doesExist(args[0].toUpperCase())) {
            sender.sendMessage("§cItem does not exist");
            return true;
        }

        Player p = (Player) sender;
        p.getInventory().addItem(Items.generateItem(args[0].toUpperCase()));
        p.sendMessage("§cGave you §a" + args[0].toUpperCase());

        return false;
    }
}
