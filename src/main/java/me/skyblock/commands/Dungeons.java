package me.skyblock.commands;

import me.skyblock.dungeons.Dungeon;
import me.skyblock.dungeons.FloorEnum;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Dungeons implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) return true;

        new Dungeon(4, 4, Math.random(), FloorEnum.FLOOR_1);

        return false;
    }
}
