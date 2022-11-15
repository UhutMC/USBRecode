package me.skyblock.block.farming;

import me.skyblock.items.Items;
import me.skyblock.items.SItem;
import org.bukkit.Material;

public class Wheat extends CropBase {
    @Override
    public Material getBlock() {
        return Material.WHEAT;
    }

    @Override
    public SItem getDrop() {
        return Items.getItem("WHEAT");
    }

    @Override
    public int getAmountDrop() {
        return 1;
    }

    @Override
    public double getXP() {
        return 30;
    }
}
