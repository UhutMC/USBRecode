package me.skyblock;

import me.skyblock.display.Scoreboard;
import me.skyblock.items.Items;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.*;

import java.util.Calendar;
import java.util.Date;
import me.skyblock.player.User;

public class Join implements Listener {
    @EventHandler
    public void playerJoinEvent(PlayerJoinEvent event) {
        event.setJoinMessage("§7[§a+§7] §7" + event.getPlayer().getName());
        Player player = event.getPlayer();
        User user = User.getUser(event.getPlayer().getUniqueId());
        Scoreboard.startScoreboard(player);
        player.getInventory().setItem(8, Items.generateItem("SKYBLOCK_MENU"));
    }
    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent e) {
        Player player = e.getPlayer();
        User user = User.getUser(player.getUniqueId());
        user.save();
        e.setQuitMessage("§7[§c-§7] " + player.getName());
    }
}
