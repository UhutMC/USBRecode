package me.skyblock.items.swords;

import me.skyblock.items.SItem;
import me.skyblock.items.Type;
import org.bukkit.Material;

public class DimoonizaryDagger extends SItem {
    @Override
    public String getName() {
        return "Dimoonizary Dagger";
    }

    @Override
    public Material getItem() {
        return Material.DIAMOND_SWORD;
    }

    @Override
    public int getRarity() {
        return 4;
    }

    @Override
    public long getFerocity() {
        return 45;
    }

    @Override
    public long getDamage() {
        return 357;
    }

    @Override
    public String getUID() {
        return "DIMOONIZARY_DAGGER";
    }

    @Override
    public Type getType() {
        return Type.SWORD;
    }

    @Override
    public long getSpeed() {
        return 400;
    }
}
