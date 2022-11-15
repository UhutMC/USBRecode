package me.skyblock.items.armor;

import me.skyblock.items.SItem;
import org.bukkit.Material;

public class DiamondHelmet extends SItem {
    @Override
    public long getHealth() {
        return 999;
    }

    @Override
    public String getUID() {
        return "DIAMOND_HELMET";
    }

    @Override
    public String getName() {
        return "Diamond Helmet";
    }

    @Override
    public Material getItem() {
        return Material.DIAMOND_HELMET;
    }
    @Override
    public int getRarity() {
        return 5;
    }
}
