package me.skyblock.items.armor;

import me.skyblock.items.SItem;
import org.bukkit.Material;

public class DiamondLeggings extends SItem {
    @Override
    public long getHealth() {
        return 999;
    }

    @Override
    public String getName() {
        return "Diamond Leggings";
    }

    @Override
    public String getUID() {
        return "DIAMOND_LEGGINGS";
    }

    @Override
    public Material getItem() {
        return Material.DIAMOND_LEGGINGS;
    }
    @Override
    public int getRarity() {
        return 5;
    }
}
