package me.skyblock.items.armor;

import me.skyblock.items.SItem;
import me.skyblock.items.Type;
import org.bukkit.Material;

public class NecronLeggings extends SItem {
    @Override
    public Type getType() {
        return Type.LEGGINGS;
    }

    @Override
    public String getName() {
        return "Necron's Leggings";
    }

    @Override
    public String getUID() {
        return "NECRON_LEGGINGS";
    }

    @Override
    public int getRarity() {
        return 5;
    }

    @Override
    public Material getItem() {
        return Material.LEATHER_LEGGINGS;
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
        return 230;
    }

    @Override
    public long getDefense() {
        return 125;
    }

    @Override
    public long getIntelligence() {
        return 10;
    }
}
