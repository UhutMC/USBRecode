package me.skyblock.commands;

import me.skyblock.Skyblock;
import org.bukkit.NamespacedKey;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;

public class NBT implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!(sender instanceof Player)) return true;

        ItemStack item = ((Player) sender).getItemInHand();
        if (args[0] == null) return true;
        sender.sendMessage("" + item.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(Skyblock.getPlugin(),args[0]), PersistentDataType.LONG));
        return false;
    }
}
