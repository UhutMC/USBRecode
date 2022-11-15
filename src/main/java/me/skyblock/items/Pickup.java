package me.skyblock.items;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Pickup implements Listener {
    @EventHandler
    public void onPickup(PlayerPickupItemEvent e) {
        ItemStack stack = e.getItem().getItemStack();
        int amount = stack.getAmount();
        e.getItem().setItemStack(Items.generateItem(stack.getType().name()));
        e.getItem().getItemStack().setAmount(amount);
        for (AutoCompact auto : AutoCompact.values()) {
            int am = 0;
            for (ItemStack item : e.getPlayer().getInventory().getContents()) {
                if (item != null && auto.orig.getUID().equals(Items.getString(item.getItemMeta(), "UID"))) {
                    am += item.getAmount();
                }
            }
            for (int z = 0;z < am;z+=160) {
                e.getPlayer().getInventory().addItem(Items.generateItem(auto.item.getUID()));
                ItemStack a = Items.generateItem(auto.orig.getUID());
                a.setAmount(64);
                e.getPlayer().getInventory().remove(a);
                e.getPlayer().getInventory().remove(a);
                a.setAmount(32);
                e.getPlayer().getInventory().remove(a);
            }
        }
    }
}
