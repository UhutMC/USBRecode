package me.skyblock;

import me.skyblock.commands.*;
import me.skyblock.damage.Damage;
import me.skyblock.display.Indicator;
import me.skyblock.gui.SkyblockMenu;
import me.skyblock.items.Items;
import me.skyblock.items.Pickup;
import me.skyblock.items.misc.SkyblockMenuItem;
import me.skyblock.player.User;
import me.skyblock.player.events.Register;
import me.skyblock.stats.Misc;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Item;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Iterator;

public final class Skyblock extends JavaPlugin {
    final String PREFIX = "§8[§cUSB§8]";
    final String VERSION = "0.0.1";
    private static Skyblock plugin;
    public static Skyblock getPlugin() {
        return plugin;
    }
    //§ DONT FORGOR
    @Override
    public void onEnable() {
        // Plugin startup logic
        System.out.println(PREFIX + " Initializing Server");
        plugin = this;

        //registering events

        //registering commands
        new Items();
        registerCommands();
        registerEvents(this);

        System.out.println("Adding recipes");
    }

    @Override
    public void onDisable() {
        System.out.println(PREFIX + " Closing server.");
        for (User user : User.getCachedUsers())
            user.save();
        for (ArmorStand as : Indicator.indicators) {
            as.remove();
        }

    }
    public static void registerEvents(Skyblock it) {
        it.getServer().getPluginManager().registerEvents(new SkyblockMenuItem(), it);
        it.getServer().getPluginManager().registerEvents(new Join(), it);
        it.getServer().getPluginManager().registerEvents(new Pickup(), it);
        it.getServer().getPluginManager().registerEvents(new Damage(), it);
        it.getServer().getPluginManager().registerEvents(new SkyblockMenu(), it);
        it.getServer().getPluginManager().registerEvents(new Items(), it);
        it.getServer().getPluginManager().registerEvents(new me.skyblock.block.Register(), it);
        it.getServer().getPluginManager().registerEvents(new Misc(), it);
        new Register(it);
    }
    public void registerCommands() {
        getCommand("eco").setExecutor(new CoinsSet());
        getCommand("menu").setExecutor(new SkyblockMenuCommand());
        getCommand("test").setExecutor(new Test());
        getCommand("nbt").setExecutor(new NBT());
        getCommand("dunggen").setExecutor(new Dungeons());
        getCommand("stats").setExecutor(new Stat());
    }
}
