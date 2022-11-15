package me.skyblock.items;

import org.bukkit.Material;

public enum AutoCompact {
    ENCHANTED_SUGAR(Items.getItem("SUGAR_CANE"), Items.getItem("ENCHANTED_SUGAR"));

    public SItem orig;
    public SItem item;
    AutoCompact(SItem orig, SItem item) {
        this.item = item;
        this.orig = orig;
    }
}
