package me.skyblock.items;

public enum Stats {
    DAMAGE("damage"),
    HEALTH("health"),
    DEFENSE("defense"),
    TRUEDEFENSE("truedefense"),
    STRENGTH("strength"),
    SPEED("speed"),
    CRITCHANCE("critchance"),
    CRITDAMAGE("critdamage"),
    INTELLIGENCE("intelligence"),
    SEACREATURECHANCE("seacreaturechance"),
    MAGICFIND("magicfind"),
    ATTACKSPEED("attackspeed"),
    FEROCITY("ferocity"),
    FARMINGFORTUNE("farmingfortune"),
    MANA("mana"),
    CURRENTHEALTH("currenthealth");
    public String str;
    Stats(String str) {
        this.str = str;
    }
}
