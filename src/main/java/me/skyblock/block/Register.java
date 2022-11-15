package me.skyblock.block;

import me.skyblock.Skyblock;
import me.skyblock.block.farming.CropBase;
import me.skyblock.block.farming.SugarCane;
import me.skyblock.block.farming.Wheat;
import me.skyblock.items.Stats;
import me.skyblock.player.User;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Register implements Listener {
    private static final Map<Material, CropBase> REGISTER_CACHE = new HashMap<>();
    public Register() {

        register(new SugarCane());
        register(new Wheat());

    }

    public void register(CropBase clasz) {
        REGISTER_CACHE.put(clasz.getBlock(), clasz);
    }

    @EventHandler
    public void onBreakBlock(BlockBreakEvent e) {
        if (!(e.getPlayer() instanceof Player)) return;
        Player p = (Player) e.getPlayer();
        p.sendMessage("Test");
        if (!(REGISTER_CACHE.containsKey(e.getBlock().getType()))) return;
        CropBase crop = REGISTER_CACHE.get(e.getBlock().getType());
        User user = User.getUser(p.getUniqueId());

        long as = user.getStat(Stats.FARMINGFORTUNE)/100;

        int amount = (int) ((int) crop.getAmountDrop()*((user.getStat(Stats.FARMINGFORTUNE)/100)+3));
        int y = e.getBlock().getY();
        int am = 1;
        if (e.getBlock().getType() == Material.SUGAR_CANE) {
            while (true) {
                if (p.getWorld().getBlockAt(e.getBlock().getX(), y, e.getBlock().getZ()).getType() != Material.SUGAR_CANE) {
                    break;
                }
                p.getWorld().getBlockAt(e.getBlock().getX(), y, e.getBlock().getZ()).setType(Material.AIR);
                am++;
                y++;
            }
        }
        if (am > 64) {
            int total = am*amount;
            for (int b = total;b>0;b-=64)p.getWorld().dropItemNaturally(e.getBlock().getLocation(),new ItemStack(crop.getBlock(), b));
        } else {
            p.getWorld().dropItemNaturally(e.getBlock().getLocation(), new ItemStack(crop.getBlock(), amount*am));
        }
        e.setDropItems(false);
    }
}
