package me.skyblock.dungeons;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Dungeon {
    private int xsize;
    private int ysize;
    private double seed;
    private FloorEnum floor;
    public Dungeon(int xsize, int ysize, double seed, FloorEnum floor) {
        this.xsize = xsize;
        this.ysize = ysize;
        this.seed = seed;
        this.floor = floor;
        initializeGeneration();
    }
    /*
    Limitations: 1 fairy room, at least 1 puzzle maximum 4, spawn room must have path to blood room, and the path must be connected to fairy.
    rooms must have possible doors extend doorclass
     */
    private void initializeGeneration() {
        Thread thread = new Thread() {
            public void run() {
                spawnSpawn();
                spawnBlood();
                spawnFairy();
            }
        };
        thread.start();

    }
    private void spawnSpawn() {
        dungeonDebugger("Spawning start room");
    }
    private void spawnBlood() {
        dungeonDebugger("Spawning blood room");
    }
    private void spawnFairy() {
        dungeonDebugger("Spawning fairy room");
    }

    private void dungeonDebugger(String text) {
        for (Player p : Bukkit.getOnlinePlayers()) {
            p.sendMessage(ChatColor.RED + text);
        }
    }
}
