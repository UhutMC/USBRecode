package me.skyblock.items.armor;

import me.skyblock.items.SItem;
import me.skyblock.items.Type;
import org.bukkit.Material;

public class NecronChestplate extends SItem {
    @Override
    public Type getType() {
        return Type.CHESTPLATE;
    }

    @Override
    public String getName() {
        return "Necron's Chestplate";
    }

    @Override
    public String getUID() {
        return "NECRON_CHESTPLATE";
    }

    @Override
    public int getRarity() {
        return 5;
    }

    @Override
    public Material getItem() {
        return Material.LEATHER_CHESTPLATE;
    }

    @Override
    public long getStrength() {
        return 40;
    }

    @Override
    public long getCritdamage() {
        return 30;
    }

    @Override
    public long getHealth() {
        return 260;
    }

    @Override
    public long getDefense() {
        return 140;
    }

    @Override
    public long getIntelligence() {
        return 10;
    }
}
