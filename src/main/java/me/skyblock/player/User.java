package me.skyblock.player;


import me.skyblock.Skyblock;
import me.skyblock.items.Items;
import me.skyblock.items.Stats;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class User {
    private static final Skyblock plugin = Skyblock.getPlugin();
    private static final Map<UUID, User> USER_CACHE = new HashMap<>();
    private static File USER_FOLDER = new File(plugin.getDataFolder(), "./users");
    private Map<Stats, Long> STAT_CACHE = new HashMap<>();
    private Map<Stats, Long> HELMET_CACHE = new HashMap<>();
    private Map<Stats, Long> CHESTPLATE_CACHE = new HashMap<>();
    private Map<Stats, Long> LEGGINGS_CACHE = new HashMap<>();
    private Map<Stats, Long> BOOTS_CACHE = new HashMap<>();
    private Map<Stats, Long> HELD_CACHE = new HashMap<>();
    private UUID uuid;
    private final Config config;
    private long coins;
    private long bankCoins;
    private long bits;
    private Double islandX;
    private Double islandZ;
    private double farmingXP;
    private double miningXP;
    private double combatXP;
    private double foragingXP;
    private int[] slayers;
    private int[] slayerLevels;
    private String helm_name;
    private String chest_name;
    private String legs_name;
    private String boots_name;
    private String held_name;


    private User(UUID uuid)
    {
        this.uuid = uuid;
        this.coins = 50;
        this.bankCoins = 0;
        this.islandX = null;
        this.islandZ = null;
        this.farmingXP = 0;
        this.miningXP = 0;
        this.combatXP = 0;
        this.foragingXP = 0;
        this.slayers = new int[3];
        this.slayerLevels = new int[3];
        this.bits = 0;
        for (Stats stats : Stats.values()) {
            this.HELD_CACHE.put(stats, 0L);
            this.HELMET_CACHE.put(stats, 0L);
            this.CHESTPLATE_CACHE.put(stats, 0L);
            this.LEGGINGS_CACHE.put(stats, 0L);
            this.BOOTS_CACHE.put(stats, 0L);
        }
        this.STAT_CACHE.put(Stats.DAMAGE, 5L);
        this.STAT_CACHE.put(Stats.HEALTH, 100L);
        this.STAT_CACHE.put(Stats.DEFENSE, 30L);
        this.STAT_CACHE.put(Stats.TRUEDEFENSE, 0L);
        this.STAT_CACHE.put(Stats.STRENGTH, 30L);
        this.STAT_CACHE.put(Stats.SPEED, 100L);
        this.STAT_CACHE.put(Stats.CRITCHANCE, 30L);
        this.STAT_CACHE.put(Stats.CRITDAMAGE, 50L);
        this.STAT_CACHE.put(Stats.INTELLIGENCE, 100L);
        this.STAT_CACHE.put(Stats.SEACREATURECHANCE, 25L);
        this.STAT_CACHE.put(Stats.MAGICFIND, 50L);
        this.STAT_CACHE.put(Stats.ATTACKSPEED, 0L);
        this.STAT_CACHE.put(Stats.FEROCITY, 5L);
        this.STAT_CACHE.put(Stats.FARMINGFORTUNE, 75L);
        this.STAT_CACHE.put(Stats.MANA, 100L);
        this.STAT_CACHE.put(Stats.CURRENTHEALTH, 100L);
        if (!USER_FOLDER.exists()) USER_FOLDER.mkdirs();
        File configFile = new File(USER_FOLDER, uuid.toString() + ".yml");
        boolean save = false;
        try {
            if (!configFile.exists()) {
                save = true;
                configFile.createNewFile();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        this.config = new Config(USER_FOLDER, uuid.toString() + ".yml");
        USER_CACHE.put(uuid, this);
        if (save) save();
        load();
    }

    public void load() {
        this.coins = config.getLong("coins");
        this.bits = config.getLong("bits");
        this.bankCoins = config.getLong("bankCoins");
        this.islandX = config.contains("island.x") ? config.getDouble("island.x") : null;
        this.islandZ = config.contains("island.z") ? config.getDouble("island.z") : null;
        this.farmingXP = config.getDouble("xp.farming");
        this.miningXP = config.getDouble("xp.mining");
        this.combatXP = config.getDouble("xp.combat");
        this.foragingXP = config.getDouble("xp.foraging");
        this.slayerLevels[0] = config.getInt("slayer.rev.highest");
        this.slayerLevels[1] = config.getInt("slayer.tara.highest");
        this.slayerLevels[2] = config.getInt("slayer.sven.highest");
        this.slayers[0] = config.getInt("slayer.rev.xp");
        this.slayers[1] = config.getInt("slayer.tara.xp");
        this.slayers[2] = config.getInt("slayer.sven.xp");
        this.STAT_CACHE.put(Stats.DAMAGE, config.getLong("stat.damage"));
        this.STAT_CACHE.put(Stats.HEALTH, config.getLong("stat.health"));
        this.STAT_CACHE.put(Stats.DEFENSE, config.getLong("stat.defense"));
        this.STAT_CACHE.put(Stats.TRUEDEFENSE, config.getLong("stat.truedefense"));
        this.STAT_CACHE.put(Stats.STRENGTH, config.getLong("stat.strength"));
        this.STAT_CACHE.put(Stats.SPEED, config.getLong("stat.speed"));
        this.STAT_CACHE.put(Stats.CRITCHANCE, config.getLong("stat.critchance"));
        this.STAT_CACHE.put(Stats.CRITDAMAGE, config.getLong("stat.critdamage"));
        this.STAT_CACHE.put(Stats.INTELLIGENCE, config.getLong("stat.intelligence"));
        this.STAT_CACHE.put(Stats.SEACREATURECHANCE, config.getLong("stat.scc"));
        this.STAT_CACHE.put(Stats.MAGICFIND, config.getLong("stat.magicfind"));
        this.STAT_CACHE.put(Stats.ATTACKSPEED, config.getLong("stat.attackspeed"));
        this.STAT_CACHE.put(Stats.FEROCITY, config.getLong("stat.ferocity"));
        this.STAT_CACHE.put(Stats.FARMINGFORTUNE, config.getLong("stat.farmingfortune"));
        this.STAT_CACHE.put(Stats.CURRENTHEALTH, this.STAT_CACHE.get(Stats.HEALTH));
        this.STAT_CACHE.put(Stats.MANA, this.STAT_CACHE.get(Stats.INTELLIGENCE));
    }

    public void save() {
        StatHandler.removeBootsStats(this.getPlayer(), this);
        StatHandler.removeLeggingsStats(this.getPlayer(), this);
        StatHandler.removeChestplateStats(this.getPlayer(), this);
        StatHandler.removeHelmetStats(this.getPlayer(), this);
        StatHandler.removeHeldStats(this.getPlayer(), this);

        config.set("collections", null);
        config.set("coins", this.coins);
        config.set("bankCoins", this.bankCoins);
        config.set("bits", this.bits);
        config.set("island.x", this.islandX);
        config.set("island.z", this.islandZ);
        config.set("xp.farming", this.farmingXP);
        config.set("xp.mining", this.miningXP);
        config.set("xp.combat", this.combatXP);
        config.set("xp.foraging", this.foragingXP);
        config.set("slayer.rev.highest", this.slayerLevels[0]);
        config.set("slayer.tara.highest", this.slayerLevels[1]);
        config.set("slayer.sven.highest", this.slayerLevels[2]);
        config.set("slayer.rev.xp", this.slayers[0]);
        config.set("slayer.tara.xp", this.slayers[1]);
        config.set("slayer.sven.xp", this.slayers[2]);
        config.set("stat.damage", this.STAT_CACHE.get(Stats.DAMAGE));
        config.set("stat.health", this.STAT_CACHE.get(Stats.HEALTH));
        config.set("stat.defense", this.STAT_CACHE.get(Stats.DEFENSE));
        config.set("stat.truedefense", this.STAT_CACHE.get(Stats.TRUEDEFENSE));
        config.set("stat.strength", this.STAT_CACHE.get(Stats.STRENGTH));
        config.set("stat.speed", this.STAT_CACHE.get(Stats.SPEED));
        config.set("stat.critchance", this.STAT_CACHE.get(Stats.CRITCHANCE));
        config.set("stat.critdamage", this.STAT_CACHE.get(Stats.CRITDAMAGE));
        config.set("stat.intelligence", this.STAT_CACHE.get(Stats.INTELLIGENCE));
        config.set("stat.scc", this.STAT_CACHE.get(Stats.SEACREATURECHANCE));
        config.set("stat.magicfind", this.STAT_CACHE.get(Stats.MAGICFIND));
        config.set("stat.attackspeed", this.STAT_CACHE.get(Stats.ATTACKSPEED));
        config.set("stat.ferocity", this.STAT_CACHE.get(Stats.FEROCITY));
        config.set("stat.farmingfortune", this.STAT_CACHE.get(Stats.FARMINGFORTUNE));
        config.save();
        System.out.println("Saved user data of " + Bukkit.getPlayer(this.uuid).getName());
    }
    public long getStat(Stats stat) {return this.STAT_CACHE.get(stat);}
    public void addStat(Stats stat, long val) {this.STAT_CACHE.put(stat, this.STAT_CACHE.get(stat)+val);}
    public void removeStat(Stats stat, long val) {this.STAT_CACHE.put(stat, this.STAT_CACHE.get(stat)-val);}
    public void setStat(Stats stat, long val) {this.STAT_CACHE.put(stat, val);}

    public long getHelmetStat(Stats stat) {return this.HELMET_CACHE.get(stat);}
    public void addHelmetStat(Stats stat, long val) {this.HELMET_CACHE.put(stat, this.HELMET_CACHE.get(stat)+val);}
    public void removeHelmetStat(Stats stat, long val) {this.HELMET_CACHE.put(stat, this.HELMET_CACHE.get(stat)-val);}
    public void setHelmetStat(Stats stat, long val) {this.HELMET_CACHE.put(stat, val);}

    public long getChestplateStat(Stats stat) {return this.CHESTPLATE_CACHE.get(stat);}
    public void addChestplateStat(Stats stat, long val) {this.CHESTPLATE_CACHE.put(stat, this.CHESTPLATE_CACHE.get(stat)+val);}
    public void removeChestplateStat(Stats stat, long val) {this.CHESTPLATE_CACHE.put(stat, this.CHESTPLATE_CACHE.get(stat)-val);}
    public void setChestplateStat(Stats stat, long val) {this.CHESTPLATE_CACHE.put(stat, val);}

    public long getLeggingsStat(Stats stat) {return this.LEGGINGS_CACHE.get(stat);}
    public void addLeggingsStat(Stats stat, long val) {this.LEGGINGS_CACHE.put(stat, this.LEGGINGS_CACHE.get(stat)+val);}
    public void removeLeggingsStat(Stats stat, long val) {this.LEGGINGS_CACHE.put(stat, this.LEGGINGS_CACHE.get(stat)-val);}
    public void setLeggingsStat(Stats stat, long val) {this.LEGGINGS_CACHE.put(stat, val);}

    public long getBootsStat(Stats stat) {return this.BOOTS_CACHE.get(stat);}
    public void addBootsStat(Stats stat, long val) {this.BOOTS_CACHE.put(stat, this.BOOTS_CACHE.get(stat)+val);}
    public void removeBootsStat(Stats stat, long val) {this.BOOTS_CACHE.put(stat, this.BOOTS_CACHE.get(stat)-val);}
    public void setBootsStat(Stats stat, long val) {this.BOOTS_CACHE.put(stat, val);}

    public long getHeldStat(Stats stat) {return this.HELD_CACHE.get(stat);}
    public void addHeldStat(Stats stat, long val) {this.HELD_CACHE.put(stat, this.HELD_CACHE.get(stat)+val);}
    public void removeHeldStat(Stats stat, long val) {this.HELD_CACHE.put(stat, this.HELD_CACHE.get(stat)-val);}
    public void setHeldStat(Stats stat, long val) {this.HELD_CACHE.put(stat, val);}

    public void setIslandLocation(double x, double z) {this.islandX = x;this.islandZ = z;}

    public Player getPlayer() {return Bukkit.getPlayer(this.uuid);}

    public void addCoins(long coins) {this.coins += coins;}
    public void removeCoins(long coins) {this.coins -= coins;}
    public void setCoins(long coins) {this.coins = coins;};
    public long getCoins() {return this.coins;}

    public long getBankCoins() {return this.bankCoins;}
    public void addBankCoins(long coins) {this.bankCoins += coins;}
    public void removeBankCoins(long coins) {this.bankCoins -= coins;}
    public void setBankCoins(long coins) {this.bankCoins -= coins;}

    public long getBits() {return this.bits;}
    public void addBits(long bits) {this.bits += bits;}
    public void removeBits(long bits) {this.bits -= bits;}
    public void setBits(long bits) {this.bits = bits;}

    public void sendMessage(String mes) {
        Player player = Bukkit.getPlayer(this.uuid);
        if (player == null) return;
        player.sendMessage(mes);
    }

    public Config getConfig() {
        return this.config;
    }

    public static User getUser(UUID uuid) {
        if (uuid == null) return null;
        if (USER_CACHE.containsKey(uuid)) return USER_CACHE.get(uuid);
        return new User(uuid);
    }

    public static Collection<User> getCachedUsers() {
        return USER_CACHE.values();
    }
}
