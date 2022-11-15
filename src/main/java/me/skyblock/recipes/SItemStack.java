package me.skyblock.recipes;

import me.skyblock.items.SItem;

public class SItemStack {
    private SItem item;
    private int amount;
    public SItemStack(SItem item, int amount) {
        this.item = item;
        this.amount = amount;
    }
    public SItemStack(SItem item) {
        this.item = item;
        this.amount = 1;
    }
    public SItem setMaterial(SItem item) {
        this.item = item;
        return this.item;
    }
    public SItem setAmount(int amount) {
        this.amount = amount;
        return this.item;
    }
    public SItem getItem() {
        return this.item;
    }
    public int getAmount() {
        return this.amount;
    }
}
