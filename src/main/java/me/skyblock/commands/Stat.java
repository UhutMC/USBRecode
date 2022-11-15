package me.skyblock.commands;

import me.skyblock.items.Stats;
import me.skyblock.player.User;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Stat implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            return true;
        }

        Player p = (Player)sender;
        User user = User.getUser(p.getUniqueId());
        if (args[0].equals(null) || args[1].equals(null)) return true;
        Stats stats = Stats.valueOf(args[0].toUpperCase());
        if (stats == null) return true;

        user.setStat(stats, Long.parseLong(args[1]));
        System.out.println("Changed stats of " + p.getName());


        return false;
    }
}
