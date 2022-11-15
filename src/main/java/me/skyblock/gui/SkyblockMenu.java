package me.skyblock.gui;

import me.skyblock.items.Stats;
import me.skyblock.player.User;
import me.skyblock.util.Util;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SkyblockMenu implements Listener {
    final static ItemStack blackglass = new ItemStack(Material.BLACK_STAINED_GLASS_PANE,1);
    public static void openMenu(Player p) {
        User user = User.getUser(p.getUniqueId());

        Inventory menu = Bukkit.createInventory(null, 54, "Skyblock Menu");
        ItemMeta itemmeta = blackglass.getItemMeta();
        itemmeta.setDisplayName("§7");
        blackglass.setItemMeta(itemmeta);
        for (int i=0;i<54;i++) {
            menu.setItem(i, blackglass);
        }
        ItemStack playerhead = new ItemStack(Material.PLAYER_HEAD, 1, (byte) 3);
        SkullMeta meta = (SkullMeta) playerhead.getItemMeta();
        //lore now cuz bad
        List lore = new ArrayList<String>();
        lore.add(ChatColor.RED + " ❤ Health " + ChatColor.WHITE + user.getStat(Stats.HEALTH) + " HP");
        lore.add(ChatColor.GREEN + " ❈ Defense " + ChatColor.WHITE + user.getStat(Stats.DEFENSE));
        lore.add(ChatColor.RED + " ❁ Strength " + ChatColor.WHITE + user.getStat(Stats.STRENGTH));
        lore.add(ChatColor.WHITE + " ✦ Speed " + user.getStat(Stats.SPEED));
        lore.add(ChatColor.BLUE + " ☣ Crit Chance " + ChatColor.WHITE + user.getStat(Stats.CRITCHANCE) + "%");
        lore.add(ChatColor.BLUE + " ☠ Crit Damage " + ChatColor.WHITE + user.getStat(Stats.CRITDAMAGE) + "%");
        lore.add(ChatColor.AQUA + " ✎ Intelligence " + ChatColor.WHITE + user.getStat(Stats.INTELLIGENCE));
        lore.add(ChatColor.YELLOW + " ⚔ Bonus Attack Speed " + ChatColor.WHITE + user.getStat(Stats.ATTACKSPEED) + "%");
        lore.add(ChatColor.DARK_AQUA + " α Sea Creature Chance " + ChatColor.WHITE + user.getStat(Stats.SEACREATURECHANCE) + "%");
        lore.add(ChatColor.AQUA + " ✯ Magic Find " + ChatColor.WHITE + user.getStat(Stats.MAGICFIND));
        lore.add(ChatColor.WHITE + " ❂ True Defense " +  user.getStat(Stats.TRUEDEFENSE));
        lore.add(ChatColor.RED + " ⫽ Ferocity " + ChatColor.WHITE + user.getStat(Stats.FEROCITY));
        lore.add(ChatColor.GOLD + " ☘ Farming Fortune " + ChatColor.WHITE + user.getStat(Stats.FARMINGFORTUNE));
        lore.add("");
        lore.add(ChatColor.YELLOW + "Click to view!");
        meta.setOwner(p.getName());
        meta.setDisplayName(ChatColor.YELLOW + "Your Skyblock profile");
        meta.setLore(lore);
        playerhead.setItemMeta(meta);





        menu.setItem(20, Util.makeColorfulItem(Material.BLAZE_POWDER, "&aItem Catalogue", 1, 0, "&7View a list of every Skyblock item and &emore!\n\n&eClick to open!", false));
        menu.setItem(22, Util.makeColorfulItem(Material.EMERALD, "&aUtilities panel", 1, 0, "&8Personal Troubleshooting\n&7Troubleshoot various minor bugs/glitches\n&7that may occur to you.\n\n&eClick to open!",false));
        menu.setItem(23, Util.makeColorfulItem(Material.WRITABLE_BOOK, "&aQuest Log", 1, 0, "&7View your active quests\n&7progress, and rewards.\n\n&eClick to view!",false));
        menu.setItem(24, Util.makeColorfulItem(Material.GOLD_INGOT, "&aStore", 1, 0, "&7Support the server and\n&7purchase ranks, cosmetics\n&7and more!",false));
        menu.setItem(25, Util.makeColorfulItem(Material.CHEST, "&aStorage", 1, 0, "&7Access your items anytime\n&7from anywhere.\n\n&eClick to open!",false));
        menu.setItem(19, Util.makeColorfulItem(Material.DIAMOND_SWORD, "&aYour Skills", 1, 0, "&7View your Skill progression and\n&7rewards.",false));
        menu.setItem(30, Util.makeColorfulItem(Material.BONE, "&aPets", 1, 0, "\n&eClick to open the pets menu!",false));
        menu.setItem(31, Util.makeColorfulItem(Material.CRAFTING_TABLE, "&aCrafting Table", 1, 0, "\n&7Click to open the crafting grid!",false));
        menu.setItem(32, Util.makeColorfulItem(Material.LEATHER_CHESTPLATE,"&aWardrobe",1,0, "\n&7Store and access your armor sets!",false));
        menu.setItem(49, Util.makeColorfulItem(Material.BARRIER, "&cClose", 1, 0, "", false));
        menu.setItem(50, Util.makeColorfulItem(Material.REDSTONE_TORCH, "&aSettings", 1, 0, "&7Configure your SkyBlock\n&7settings.\n\n&eClick to configure!",false));




        //13
        menu.setItem(13, playerhead);
        p.openInventory(menu);
    }
    @EventHandler
    public void itemDropped(PlayerDropItemEvent e) {
        if (e.getItemDrop().getItemStack().getItemMeta().getDisplayName().equalsIgnoreCase("Skyblock")) e.setCancelled(true);
    }
    @EventHandler
    public void onInvClick(InventoryClickEvent e) {
        if (!e.getView().getTitle().equalsIgnoreCase("Skyblock Menu")) {
            if (e.getSlot() == 8) e.setCancelled(true);
            return;
        }
        Player player = (Player) e.getWhoClicked();
        e.setCancelled(true);
    }
}
