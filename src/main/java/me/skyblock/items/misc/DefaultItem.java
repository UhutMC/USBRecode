package me.skyblock.items.misc;

import me.skyblock.items.SItem;
import org.bukkit.Material;

public class DefaultItem extends SItem {
    private String name;
    private Material item;
    private String UID;
    public DefaultItem(Material item, String name, String UID) {
        this.item = item;
        this.name = name;
        this.UID = UID;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Material getItem() {
        return this.item;
    }

    @Override
    public int getRarity() {
        return 1;
    }

    @Override
    public String getUID() {
        return this.UID;
    }
}
