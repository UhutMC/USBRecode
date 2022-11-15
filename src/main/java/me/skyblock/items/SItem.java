package me.skyblock.items;

import me.skyblock.player.User;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class SItem {

    public Material getItem() {return null;};
    public String getName() {return null;};
    public long getDamage() {return 0;};
    public long getHealth() {return 0;};
    public long getDefense() {return 0;};
    public long getTruedefense() {return 0;};
    public long getStrength() {return 0;};
    public long getSpeed() {return 0;};
    public long getCritchance() {return 0;};
    public long getCritdamage() {return 0;};
    public long getIntelligence() {return 0;};
    public long getSeacreaturechance() {return 0;};
    public long getMagicfind() {return 0;};
    public long getAttackspeed() {return 0;};
    public long getFerocity() {return 0;};
    public long getFarmingFortune() {return 0;};
    public List getLore() {return null;};
    public int getRarity() {return 0;}
    public Type getType() {return Type.NONE;}
    public String getURL() {return null;}
    public String getUID() {return null;}
    public boolean isStackable() {return true;}
    public boolean isRarityHidden() {return false;}
    public List getAbilityLore() {return null;}
    public String getAbilityName() {return null;}
    public int getAbilityManaCost() {return 0;}
    public int getAbilityCooldown() {return 0;}
    public AbilityType getAbilityType() {return AbilityType.NONE;}
    public void onAbilityRightClick(Player p, User user, PlayerInteractEvent e) {}
}
