package me.skyblock.entity;

import me.skyblock.Skyblock;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class SEntity {
    private static final Skyblock plugin = Skyblock.getPlugin();
    private static final Map<UUID, SEntity> MOB_CACHE = new HashMap<>();

    private int health;
    private int maxhealth;
    private String name;
    private int level;
    private boolean boss;
    private EntityType entity;
    private Entity entityreal;

    public SEntity(EntityType entity, int health, int maxhealth, String name, int level, boolean boss, Location loc) {
        this.entity = entity;
        this.health = health;
        this.maxhealth = maxhealth;
        this.name = name;
        this.level = level;
        this.boss = boss;
        MOB_CACHE.put(entityreal.getUniqueId(), this);
        spawnEntity(loc);
    }
    private void spawnEntity(Location loc) {

        Entity ent = loc.getWorld().spawnEntity(loc, entity);
        this.entityreal = ent;
        ent.setCustomName(this.name);
        ent.setCustomNameVisible(true);
    }
    public static SEntity getInstance(UUID uuid) {
        if (uuid == null) return null;
        if (MOB_CACHE.containsKey(uuid)) return MOB_CACHE.get(uuid);
        return null;
    }
    public static Collection<SEntity> getAll() {return MOB_CACHE.values();}
    private int getHealth() {return this.health;}
    private int getMaxhealth() {return this.maxhealth;}
    private void setHealth(int b) {this.health = b;}
    private void setMaxhealth(int b) {this.maxhealth = b;}
    private void addHealth(int b) {this.health += b;}
    private void addMaxhealth(int b) {this.maxhealth += b;}
    private void removeHealth(int b) {this.health -= b;}
    private void removeMaxhealth(int b) {this.maxhealth -= b;}
    private String getName() {return this.name;}
    private void setName(String b) {this.name=b;}
    private boolean isBoss() {return this.boss;}
    private void setIsBoss(boolean b) {this.boss = b;}
    private int getLevel() {return this.level;}
    private void setLevel(int b) {this.level=b;}
    private Entity getEntity() {return this.entityreal;}

}
