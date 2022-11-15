package me.skyblock.items.armor;

import me.skyblock.items.SItem;
import org.bukkit.Material;

public class DiamondBoots extends SItem {
    @Override
    public long getHealth() {
        return 999;
    }

    @Override
    public Material getItem() {
        return Material.DIAMOND_BOOTS;
    }

    @Override
    public String getName() {
        return "Diamond Boots";
    }

    @Override
    public String getUID() {
        return "DIAMOND_BOOTS";
    }

    @Override
    public int getRarity() {
        return 5;
    }
}
