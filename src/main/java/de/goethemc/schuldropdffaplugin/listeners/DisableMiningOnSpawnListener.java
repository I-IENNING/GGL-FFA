package de.goethemc.schuldropdffaplugin.listeners;

import com.sun.tools.javac.Main;
import de.goethemc.schuldropdffaplugin.SchulDropDffaPlugin;
import de.goethemc.schuldropdffaplugin.etc.PvpTag;
import de.goethemc.schuldropdffaplugin.etc.SpawnIsland;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import static org.bukkit.Material.YELLOW_GLAZED_TERRACOTTA;


public class DisableMiningOnSpawnListener implements Listener {

    PvpTag taggerino = new PvpTag();
    String tag = taggerino.getTag();
    private final SpawnIsland spawnIsland;

    public DisableMiningOnSpawnListener(SchulDropDffaPlugin plugin) {
        this.spawnIsland = new SpawnIsland(plugin);
    }

    @EventHandler
    public void onSpawnMine(BlockBreakEvent e) {
        Player player = e.getPlayer();
        //Bukkit.getConsoleSender().sendMessage("t");
        if (spawnIsland.isSpawnIsland(player.getLocation().getX(), player.getLocation().getY(), player.getLocation().getZ())) {
            //Bukkit.getConsoleSender().sendMessage("BreakEvent1");
            e.setCancelled(true);
            player.sendMessage(tag + ChatColor.RED + " Du darfst hier keine Blöcke abbauen!");
        }
    }

    @EventHandler
    public void onMine(BlockBreakEvent e) {
        Player player = e.getPlayer();
        //Bukkit.getConsoleSender().sendMessage("t2");
        if (!(e.getBlock().getType() == YELLOW_GLAZED_TERRACOTTA)) {
            if (!(player.getGameMode() == GameMode.CREATIVE)) {
                //Bukkit.getConsoleSender().sendMessage("BreakEvent2");
                e.setCancelled(true);
                player.sendMessage(tag + ChatColor.RED + " Du darfst hier keine Blöcke abbauen!");
            }
        }

    }
}
