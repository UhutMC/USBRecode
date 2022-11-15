package me.skyblock.damage;

import me.skyblock.display.Indicator;
import me.skyblock.items.Stats;
import me.skyblock.player.User;
import org.bukkit.Location;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerItemDamageEvent;

public class Damage implements Listener {
    public static int getDamage() {
        return 0;
    }

    @EventHandler
    public void onDamage(EntityDamageByEntityEvent e) {
        if (!(e.getDamager() instanceof Player)) {
            e.setCancelled(true);
            return;
        }
        if (e.getEntity() instanceof Player) {
            e.setCancelled(true);
            return;
        }
        if ((e.getEntity() instanceof ArmorStand)) {
            e.setCancelled(true);
            return;
        }
        User user = User.getUser(e.getDamager().getUniqueId());
        boolean isCrit = rollCrit(user);
        Indicator.spawnIndicator(e.getEntity().getLocation(), calculateDamage(user, (Player) e.getDamager(),isCrit),isCrit);

    }
    public static int calculateDamage(User user, Player player, boolean isCrit) {
        double baseDamage = user.getStat(Stats.DAMAGE);
        double critDamage = user.getStat(Stats.CRITDAMAGE);
        double baseStrength = user.getStat(Stats.STRENGTH);

        double first = baseDamage*(1+baseStrength/100);
        double second = 101;
        double finish = first*second*(1);
        if (isCrit) finish = finish*(1+critDamage/100);
        return (int) finish;
    }
    public static boolean rollCrit(User user) {
        if (user.getStat(Stats.CRITCHANCE) > Math.random()*100) return true;
        return false;
    }
}
