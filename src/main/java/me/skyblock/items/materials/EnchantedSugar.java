package me.skyblock.items.materials;

import me.skyblock.items.SItem;
import me.skyblock.items.Type;
import org.bukkit.Material;

public class EnchantedSugar extends SItem {
    @Override
    public String getName() {
        return "Enchanted Sugar";
    }

    @Override
    public int getRarity() {
        return 2;
    }

    @Override
    public String getUID() {
        return "ENCHANTED_SUGAR";
    }

    @Override
    public Type getType() {
        return Type.NONE;
    }

    @Override
    public Material getItem() {
        return Material.SUGAR;
    }
}
