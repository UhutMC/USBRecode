package me.skyblock.items.swords;

import me.skyblock.items.SItem;
import me.skyblock.items.Type;
import org.bukkit.Material;

public class BonzoStaff extends SItem {
    @Override
    public long getDamage() {
        return 9999;
    }

    @Override
    public String getUID() {
        return "BONZO_STAFF";
    }

    @Override
    public Material getItem() {
        return Material.BLAZE_ROD;
    }

    @Override
    public long getCritchance() {
        return 905;
    }

    @Override
    public long getCritdamage() {
        return 1500;
    }

    @Override
    public long getIntelligence() {
        return 90140;
    }

    @Override
    public Type getType() {
        return Type.SWORD;
    }

    @Override
    public int getRarity() {
        return 3;
    }

    @Override
    public String getName() {
        return "Bonzo Staff";
    }
}
