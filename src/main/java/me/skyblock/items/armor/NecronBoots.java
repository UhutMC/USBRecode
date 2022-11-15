package me.skyblock.items.armor;

import me.skyblock.items.SItem;
import me.skyblock.items.Type;
import org.bukkit.Material;

public class NecronBoots extends SItem {
    @Override
    public Type getType() {
        return Type.BOOTS;
    }

    @Override
    public String getName() {
        return "Necron's Boots";
    }

    @Override
    public String getUID() {
        return "NECRON_BOOTS";
    }

    @Override
    public int getRarity() {
        return 5;
    }

    @Override
    public Material getItem() {
        return Material.LEATHER_BOOTS;
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
        return 145;
    }

    @Override
    public long getDefense() {
        return 85;
    }

    @Override
    public long getIntelligence() {
        return 10;
    }
}
