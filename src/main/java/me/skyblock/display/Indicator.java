package me.skyblock.display;

import me.skyblock.Skyblock;
import org.bukkit.Location;
import org.bukkit.entity.Ageable;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;

public class Indicator {
    public static ArrayList<ArmorStand> indicators = new ArrayList<>();
    public static void spawnIndicator(Location loc, int damage, boolean isCrit) {
        //§ DONT FORGOR
        String display = Integer.toString(damage);
        if (isCrit) {
            char[] CharArray = {'f','e','6','c','c'};
            String compile = "§f✦";
            int i = 0;
            for (int x = 0;x < display.length();x++) {
                compile = compile + "§" + CharArray[i] + display.charAt(x);

                i++;
                if (i == 4) i = 0;
            }
            display = compile + "§f✦";
        } else {
            display = "§7" + display;
        }

        double randomX = Math.random();
        double randomY = Math.random();
        double randomZ = Math.random();
        randomX -= 0.5;
        randomY += 0.25;
        randomZ -= 0.5;
        final ArmorStand as = (ArmorStand)loc.getWorld().spawnEntity(loc.add(randomX, randomY+0.5, randomZ), EntityType.ARMOR_STAND);
        as.setVisible(false);
        as.setCustomName(display);
        as.setCustomNameVisible(true);
        as.setGravity(false);
        as.setInvulnerable(true);
        indicators.add(as);
        int i = 0;
        new BukkitRunnable() {
            @Override
            public void run() {

                indicators.remove(as);
                if (!as.isDead()) as.remove();
            }
        }.runTaskLater(Skyblock.getPlugin(), 30L);
    }
}
