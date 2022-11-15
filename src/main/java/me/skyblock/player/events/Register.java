package me.skyblock.player.events;

import me.skyblock.Skyblock;

public class Register {
    public Register(Skyblock me) {
        me.getServer().getPluginManager().registerEvents(new OnReceiveDamage(), me);
        me.getServer().getPluginManager().registerEvents(new onArrowHitBlock(), me);
        me.getServer().getPluginManager().registerEvents(new onPlayerDeath(), me);
    }
}
