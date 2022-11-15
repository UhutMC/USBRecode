package me.skyblock.enchants;

import me.skyblock.items.Stats;

public enum EnchantEnum {
    GROWTH("growth","Growth","test",Stats.HEALTH, 15),
    PROTECTION("protection","Protection","test",Stats.DEFENSE, 3);


    public String name;
    public String description;
    public Stats bonus;
    public int bonusam;
    public String idname;
    EnchantEnum(String idname, String name, String desc, Stats bonus, int bonusam) {
        this.name = name;
        this.description = desc;
        this.bonus = bonus;
        this.bonusam = bonusam;
        this.idname = idname;
    }
}
