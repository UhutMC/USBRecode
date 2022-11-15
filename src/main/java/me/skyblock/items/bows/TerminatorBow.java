package me.skyblock.items.bows;

import me.skyblock.Skyblock;
import me.skyblock.items.AbilityType;
import me.skyblock.items.SItem;
import me.skyblock.player.User;
import me.skyblock.util.Util;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import java.util.ArrayList;
import java.util.List;

public class TerminatorBow extends SItem {
    @Override
    public long getDamage() {
        return 310;
    }

    @Override
    public long getStrength() {
        return 50;
    }

    @Override
    public long getCritdamage() {
        return 250;
    }

    @Override
    public long getAttackspeed() {
        return 40;
    }

    @Override
    public List getLore() {
        List list = new ArrayList();
        list.add("§6Shortbow: Instantly Shoots!");
        list.add("§7Shoots §b3 §7arrows at once.");
        list.add("§7Can damage Endermen.");
        return list;
    }

    @Override
    public int getRarity() {
        return 5;
    }

    @Override
    public String getName() {
        return "Terminator";
    }

    @Override
    public String getUID() {
        return "TERMINATOR";
    }

    @Override
    public Material getItem() {
        return Material.BOW;
    }

    @Override
    public int getAbilityManaCost() {
        return 0;
    }

    @Override
    public AbilityType getAbilityType() {
        return AbilityType.RIGHTCLICK;
    }

    @Override
    public List getAbilityLore() {
        List list = new ArrayList<>();
        list.add("§7Can be casted after landing §63 §7hits.");
        list.add("§7Shoot a beam, penatrating up");
        list.add("§7to §e5 §7foes and dealing §c2x");
        list.add("§7the damage an arrow would.");
        list.add("§7The beam always crits.");
        return list;
    }

    @Override
    public int getAbilityCooldown() {
        return 2;
    }

    @Override
    public String getAbilityName() {
        return "Salvation";
    }

    @Override
    public void onAbilityRightClick(Player p, User user, PlayerInteractEvent e) {
        e.setCancelled(true);
        //user.sendMessage("You used an ability!");
        Arrow a1;
        Arrow a2;
        Arrow a3;
        a1 = p.launchProjectile(Arrow.class);
        a1.setVelocity(a1.getVelocity());
        a2 = p.launchProjectile(Arrow.class);
        a2.setCustomName("Terminator");
        a2.setVelocity(Util.rotateVector(a1.getVelocity(), 50.38));

        a3 = p.launchProjectile(Arrow.class);
        a3.setCustomName("Terminator");
        p.playSound(p.getLocation(), Sound.ENTITY_ARROW_SHOOT, 1, 1);
        a3.setVelocity(Util.rotateVector(a1.getVelocity(), -50.38));
        new BukkitRunnable() {
            @Override
            public void run() {
                if (a1.isValid()) a1.remove();
                if (a2.isValid()) a2.remove();
                if (a3.isValid()) a3.remove();
            }
        }.runTaskLater(Skyblock.getPlugin(), 300);
    }
}
