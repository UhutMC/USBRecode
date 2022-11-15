package me.skyblock.player;

import me.skyblock.items.Items;
import me.skyblock.items.Stats;
import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;

public class StatHandler {
    public static void removeHelmetStats(Player p, User user) {
        for (Stats stats : Stats.values()) {
            if (stats == Stats.MANA || stats == Stats.CURRENTHEALTH) return;
            user.removeStat(stats, user.getHelmetStat(stats));
            user.setHelmetStat(stats, 0L);
        }
    }
    public static void removeChestplateStats(Player p, User user) {
        for (Stats stats : Stats.values()) {
            if (stats == Stats.MANA || stats == Stats.CURRENTHEALTH) return;
            user.removeStat(stats, user.getChestplateStat(stats));
            user.setChestplateStat(stats, 0L);
        }
    }
    public static void removeLeggingsStats(Player p, User user) {
        for (Stats stats : Stats.values()) {
            if (stats == Stats.MANA || stats == Stats.CURRENTHEALTH) return;
            user.removeStat(stats, user.getLeggingsStat(stats));
            user.setLeggingsStat(stats, 0L);
        }
    }
    public static void removeBootsStats(Player p, User user) {
        for (Stats stats : Stats.values()) {
            if (stats == Stats.MANA || stats == Stats.CURRENTHEALTH) return;
            user.removeStat(stats, user.getBootsStat(stats));
            user.setBootsStat(stats, 0L);
        }
    }
    public static void removeHeldStats(Player p, User user) {
        for (Stats stats : Stats.values()) {
            if (stats == Stats.MANA || stats == Stats.CURRENTHEALTH) return;
            user.removeStat(stats, user.getHeldStat(stats));
            user.setHeldStat(stats, 0L);
        }
    }

    public static void gatherHelmetStats(ItemMeta meta, User user) {
        for (Stats stats : Stats.values()) {
            if (stats == Stats.MANA || stats == Stats.CURRENTHEALTH) return;
            user.addStat(stats, Items.getLong(meta, stats.str));
            user.setHelmetStat(stats, Items.getLong(meta, stats.str));
        }
    }
    public static void gatherChestplateStats(ItemMeta meta, User user) {
        for (Stats stats : Stats.values()) {
            if (stats == Stats.MANA || stats == Stats.CURRENTHEALTH) return;
            user.addStat(stats, Items.getLong(meta, stats.str));
            user.setChestplateStat(stats, Items.getLong(meta, stats.str));
        }
    }
    public static void gatherLeggingsStats(ItemMeta meta, User user) {
        for (Stats stats : Stats.values()) {
            if (stats == Stats.MANA || stats == Stats.CURRENTHEALTH) return;
            user.addStat(stats, Items.getLong(meta, stats.str));
            user.setLeggingsStat(stats, Items.getLong(meta, stats.str));
        }
    }
    public static void gatherBootsStats(ItemMeta meta, User user) {
        for (Stats stats : Stats.values()) {
            if (stats == Stats.MANA || stats == Stats.CURRENTHEALTH) return;
            user.addStat(stats, Items.getLong(meta, stats.str));
            user.setBootsStat(stats, Items.getLong(meta, stats.str));
        }
    }
    public static void gatherHeldStats(ItemMeta meta, User user) {
        for (Stats stats : Stats.values()) {
            if (stats == Stats.MANA || stats == Stats.CURRENTHEALTH) return;
            user.addStat(stats, Items.getLong(meta, stats.str));
            user.setHeldStat(stats, Items.getLong(meta, stats.str));
        }
    }
}
