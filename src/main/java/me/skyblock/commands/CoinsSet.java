package me.skyblock.commands;

import me.skyblock.player.User;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CoinsSet implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {
            Player p = (Player) sender;

            if (!p.isOp()) return false;
            final long duh = Long.parseLong(args[2]);
            User me = User.getUser(p.getUniqueId());
            if (args[0].equals("coins")) {
                if (args[1].equals("set")) {
                    me.setCoins(duh);
                } else if (args[1].equals("add")) {
                    me.addCoins(duh);
                } else if (args[1].equals("remove")) {
                    me.removeCoins(duh);
                }
            } else if (args[0].equals("bits")) {
                if (args[1].equals("set")) {
                    me.setBits(duh);
                } else if (args[1].equals("add")) {
                    me.addBits(duh);
                } else if (args[1].equals("remove")) {
                    me.removeBits(duh);
                }
            } else if (args[0].equals("bank")) {
                if (args[1].equals("set")) {
                    me.setBankCoins(duh);
                } else if (args[1].equals("add")) {
                    me.addBankCoins(duh);
                } else if (args[1].equals("remove")) {
                    me.removeBankCoins(duh);
                }
            }

        }
        return true;
    }
}
