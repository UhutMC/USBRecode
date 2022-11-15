package me.skyblock.items.misc;

import me.skyblock.gui.SkyblockMenu;
import me.skyblock.items.*;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class SkyblockMenuItem extends SItem implements Listener {
    @Override
    public String getName() {
        return "Skyblock Menu";
    }


    @Override
    public Material getItem() {
        return Material.NETHER_STAR;
    }

    @Override
    public List getLore() {
        List lore = new ArrayList();
        lore.add("§7View all of your SkyBlock");
        lore.add("§7progress, including your Skills,");
        lore.add("§7Collections, Recipes, and more!");
        lore.add("");
        lore.add("§eClick to open!");
        return lore;
    }

    @Override
    public int getRarity() {
        return 2;
    }

    @Override
    public String getUID() {
        return "SKYBLOCK_MENU";
    }

    @Override
    public boolean isRarityHidden() {
        return true;
    }

    @EventHandler
    public void onClick(PlayerInteractEvent e) {
        if (e.getPlayer().getInventory().getItemInMainHand().getItemMeta() == null) return;
        if (e.getPlayer().getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains("Skyblock Menu")) {
            SkyblockMenu.openMenu(e.getPlayer());
        }
    }
}
