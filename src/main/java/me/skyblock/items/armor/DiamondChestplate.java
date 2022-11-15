package me.skyblock.items.armor;

import me.skyblock.items.SItem;
import org.bukkit.Material;

public class DiamondChestplate extends SItem {
    @Override
    public long getHealth() {
        return 999;
    }

    @Override
    public Material getItem() {
        return Material.DIAMOND_CHESTPLATE;
    }

    @Override
    public String getName() {
        return "Diamond Chestplate";
    }

    @Override
    public String getUID() {
        return "DIAMOND_CHESTPLATE";
    }
    @Override
    public int getRarity() {
        return 5;
    }
}
