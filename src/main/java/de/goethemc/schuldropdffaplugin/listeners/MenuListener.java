package de.goethemc.schuldropdffaplugin.listeners;

import de.goethemc.schuldropdffaplugin.SchulDropDffaPlugin;
import de.goethemc.schuldropdffaplugin.etc.SpawnIsland;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.event.inventory.InventoryEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MenuListener implements Listener {

    private final SpawnIsland spawnIsland;

    public MenuListener(SchulDropDffaPlugin plugin) {
        this.spawnIsland = new SpawnIsland(plugin);
    }


    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) {
        Player player = (Player) e.getWhoClicked();
        if (spawnIsland.isSpawnIsland(player.getLocation().getX(), player.getLocation().getY(), player.getLocation().getZ())) {
            Bukkit.getConsoleSender().sendMessage("InventoryClickEvent");
            if (!player.hasPermission("inventory.use")) {
                e.setCancelled(true);
            }
            if (!player.getGameMode().equals(GameMode.CREATIVE)) {
                e.setCancelled(true);
            }
            //Kit Selector
        }
    }

    @EventHandler
    public void onItemDrop(PlayerDropItemEvent e) {
        Player player = (Player) e.getPlayer();
        if (spawnIsland.isSpawnIsland(player.getLocation().getX(), player.getLocation().getY(), player.getLocation().getZ())) {
            //Bukkit.getConsoleSender().sendMessage("PlayerDropEvent");
            if (!player.hasPermission("inventory.use")) {
                e.setCancelled(true);
            }
            if (!player.getGameMode().equals(GameMode.CREATIVE)) {
                e.setCancelled(true);
            }
            //Kit Selector
        }
    }
}


