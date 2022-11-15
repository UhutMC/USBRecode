package me.skyblock.block.farming;

import me.skyblock.items.Items;
import me.skyblock.items.SItem;
import org.bukkit.Material;

public class CropBase {
    public double getXP() {return 4.4;}
    public Material getBlock() {return Material.SUGAR_CANE;}
    public SItem getDrop() {return Items.getItem("SUGAR_CANE");}
    public int getAmountDrop() {return 4;}

}
