package me.skyblock.block.farming;

import me.skyblock.items.Items;
import me.skyblock.items.SItem;
import org.bukkit.Material;

public class SugarCane extends CropBase {
    @Override
    public double getXP() {
        return 5.5;
    }

    @Override
    public int getAmountDrop() {
        return 3;
    }

    @Override
    public Material getBlock() {
        return Material.SUGAR_CANE;
    }

    @Override
    public SItem getDrop() {
        return Items.getItem("SUGAR_CANE");
    }
}
