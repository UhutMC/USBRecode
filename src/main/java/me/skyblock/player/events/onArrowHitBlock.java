package me.skyblock.player.events;

import org.bukkit.entity.Arrow;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;

public class onArrowHitBlock implements Listener {
    @EventHandler
    public void onArrowHitBlock(ProjectileHitEvent e) {
        if (e.getEntity() instanceof Arrow) {
            if (!(e.getHitEntity() == null)) return;
            e.getEntity().remove();
        }
    }
}
