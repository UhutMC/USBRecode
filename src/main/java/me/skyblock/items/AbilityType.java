package me.skyblock.items;

public enum AbilityType {
    RIGHTCLICK("RIGHT CLICK"),
    LEFTCLICK("LEFT CLICK"),
    NONE(null);

    public String name;
    AbilityType(String name) {
        this.name = name;
    }
}
