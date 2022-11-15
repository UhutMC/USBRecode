package me.skyblock.display;

import me.skyblock.Skyblock;
import me.skyblock.items.Stats;
import me.skyblock.player.User;
import me.skyblock.stats.Misc;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.ScoreboardManager;

import java.text.NumberFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Scoreboard {
    public static void startScoreboard(Player p) {
        User user = User.getUser(p.getUniqueId());
        new BukkitRunnable() {
            public void run() {
                if (!p.isOnline()) {cancel();}
                ScoreboardManager manager = Bukkit.getScoreboardManager();
                org.bukkit.scoreboard.Scoreboard scoreboard = manager.getNewScoreboard();
                java.util.Date date= new Date();
                Calendar cal = Calendar.getInstance();
                cal.setTime(date);
                int month = cal.get(Calendar.MONTH)+1;
                int day = cal.get(Calendar.DAY_OF_MONTH);
                int year = cal.get(Calendar.YEAR)-2000;
                Objective objective = scoreboard.registerNewObjective("t1", "dummy1", ChatColor.YELLOW + "" + ChatColor.BOLD + "    SKYBLOCK    ");
                objective.setDisplaySlot(DisplaySlot.SIDEBAR);

                Score score9 = objective.getScore(ChatColor.GRAY + "" + month + "/" + day + "/" + year + " " + ChatColor.DARK_GRAY + "m104");
                score9.setScore(14);
                Score score8 = objective.getScore(ChatColor.BLACK + "");
                score8.setScore(13);
                Score score7 = objective.getScore(" " + ChatColor.WHITE + "Late Dev 0th");
                score7.setScore(12);
                Score score6 = objective.getScore(ChatColor.GRAY + " 0:00am");
                score6.setScore(11);
                Score score5 = objective.getScore(ChatColor.GRAY + " ⏣ " + ChatColor.GRAY + "None");
                score5.setScore(10);
                Score score4 = objective.getScore(ChatColor.AQUA + "");
                score4.setScore(9);
                Score score3 = objective.getScore(ChatColor.WHITE + "Purse: " + ChatColor.GOLD + NumberFormat.getInstance(Locale.US).format(user.getCoins()));
                score3.setScore(8);
                Score score2 = objective.getScore(ChatColor.WHITE + "Bits: " + ChatColor.AQUA + NumberFormat.getInstance(Locale.US).format(user.getBits()));
                score2.setScore(7);
                Score score1 = objective.getScore(ChatColor.DARK_PURPLE + "");
                score1.setScore(6);
                Score footer = objective.getScore(ChatColor.YELLOW + "mc.dungsim.net");
                footer.setScore(5);


                p.setScoreboard(scoreboard);

                Misc.applyStatsToPlayer(p, user);
                p.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent("§c"+user.getStat(Stats.CURRENTHEALTH)+"/"+user.getStat(Stats.HEALTH) + "❤      §a" + user.getStat(Stats.DEFENSE)+"❈ Defense      §b"+user.getStat(Stats.MANA)+"/"+user.getStat(Stats.INTELLIGENCE)+"✎ Mana"));
            }
        }.runTaskTimer(Skyblock.getPlugin(), 0L, 4);
    }
}
