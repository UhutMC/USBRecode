package me.skyblock.stats;

import me.skyblock.items.Items;
import me.skyblock.items.Stats;
import me.skyblock.player.StatHandler;
import me.skyblock.player.User;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerFishEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Misc implements Listener {
    public static void applyStatsToPlayer(Player p, User user) {
        regeneration(user);
    }
    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();
        User user = User.getUser(p.getUniqueId());
        if (e.getSlot() == 36) {
            //if cursor is air remove stats if current item is air apply stats
            if (e.getCurrentItem().getType().equals(Material.AIR) && !e.getCursor().getType().equals(Material.AIR)) {
                StatHandler.gatherBootsStats(e.getCursor().getItemMeta(), user);
                p.sendMessage("Applied stats");
                return;
            } else if (!e.getCurrentItem().getType().equals(Material.AIR) && e.getCursor().getType().equals(Material.AIR)) {
                StatHandler.removeBootsStats(p, user);
                p.sendMessage("Removed stats");
                return;
            }
        }
        else if (e.getSlot() == 37) {
            if (e.getCurrentItem().getType().equals(Material.AIR) && !e.getCursor().getType().equals(Material.AIR)) {
                StatHandler.gatherLeggingsStats(e.getCursor().getItemMeta(), user);
                p.sendMessage("Applied stats");
                return;
            } else if (!e.getCurrentItem().getType().equals(Material.AIR) && e.getCursor().getType().equals(Material.AIR)) {
                StatHandler.removeLeggingsStats(p, user);
                p.sendMessage("Removed stats");
                return;
            }
        }
        else if (e.getSlot() == 38) {
            if (e.getCurrentItem().getType().equals(Material.AIR) && !e.getCursor().getType().equals(Material.AIR)) {
                StatHandler.gatherChestplateStats(e.getCursor().getItemMeta(), user);
                p.sendMessage("Applied stats");
                return;
            } else if (!e.getCurrentItem().getType().equals(Material.AIR) && e.getCursor().getType().equals(Material.AIR)) {
                StatHandler.removeChestplateStats(p, user);
                p.sendMessage("Removed stats");
                return;
            }
        }
        else if (e.getSlot() == 39) {
            if (e.getCurrentItem().getType().equals(Material.AIR) && !e.getCursor().getType().equals(Material.AIR)) {
                StatHandler.gatherHelmetStats(e.getCursor().getItemMeta(), user);
                p.sendMessage("Applied stats");
                return;
            } else if (!e.getCurrentItem().getType().equals(Material.AIR) && e.getCursor().getType().equals(Material.AIR)) {
                StatHandler.removeHelmetStats(p, user);
                p.sendMessage("Removed stats");
                return;
            }
        }
        ArmorTypes armor = isArmor(e.getCursor());
        if (armor != null) {
            if (e.getClick().equals(ClickType.SHIFT_LEFT) || e.getClick().equals(ClickType.SHIFT_RIGHT)) {
                if (armor.equals(ArmorTypes.HELMET) && p.getInventory().getHelmet() == null) {
                    StatHandler.gatherHelmetStats(e.getCursor().getItemMeta(), user);
                }
                else if (armor.equals(ArmorTypes.CHESTPLATE) && p.getInventory().getChestplate() == null) {
                    StatHandler.gatherChestplateStats(e.getCursor().getItemMeta(), user);
                }
                else if (armor.equals(ArmorTypes.LEGGINGS) && p.getInventory().getLeggings() == null) {
                    StatHandler.gatherLeggingsStats(e.getCursor().getItemMeta(), user);
                }
                else if (armor.equals(ArmorTypes.BOOTS) && p.getInventory().getBoots() == null) {
                    StatHandler.gatherBootsStats(e.getCursor().getItemMeta(), user);
                }
                p.sendMessage("Applied late stats (alternative method)");
            }
        }
    }
    private final ArmorTypes isArmor(final ItemStack itemStack) {
        if (itemStack == null)
            return null;
        final String typeNameString = itemStack.getType().name();
        if (typeNameString.endsWith("_HELMET")) return ArmorTypes.HELMET;
        else if (typeNameString.endsWith("_CHESTPLATE")) return ArmorTypes.CHESTPLATE;
        else if (typeNameString.endsWith("_LEGGINGS")) return ArmorTypes.LEGGINGS;
        else if (typeNameString.endsWith("_BOOTS")) return ArmorTypes.BOOTS;

        return null;
    }
    private enum ArmorTypes {
        HELMET,
        CHESTPLATE,
        LEGGINGS,
        BOOTS,
        NONE
    }
    @EventHandler(priority = EventPriority.LOWEST)
    public void onRightClick(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        if (e.getAction().equals(Action.RIGHT_CLICK_AIR) || e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
            e.setCancelled(true);
        }
    }
    public static void regeneration(User user) {
        if (user.getStat(Stats.HEALTH) > user.getStat(Stats.CURRENTHEALTH)) {
            long amount = user.getStat(Stats.HEALTH)/30;
            user.addStat(Stats.CURRENTHEALTH, amount);
        }
        if (user.getStat(Stats.HEALTH) < user.getStat(Stats.CURRENTHEALTH)) {
            user.setStat(Stats.CURRENTHEALTH, user.getStat(Stats.HEALTH));
        }

        if (user.getStat(Stats.INTELLIGENCE) > user.getStat(Stats.MANA)) {
            long amount = user.getStat(Stats.INTELLIGENCE)/30;
            user.addStat(Stats.MANA, amount);
        }
        if (user.getStat(Stats.INTELLIGENCE) < user.getStat(Stats.MANA)) {
            user.setStat(Stats.MANA, user.getStat(Stats.INTELLIGENCE));
        }
    }
}
