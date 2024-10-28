package de.goethemc.schuldropdffaplugin.listeners;

import de.goethemc.schuldropdffaplugin.SchulDropDffaPlugin;
import de.goethemc.schuldropdffaplugin.etc.PvpTag;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class JoinListener implements Listener {
    PvpTag taggerino = new PvpTag();
    String tag = taggerino.getTag();

    private final SchulDropDffaPlugin plugin;
    public JoinListener(SchulDropDffaPlugin plugin){this.plugin = plugin;}

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event){

        int xCord = plugin.getConfig().getInt("SpawnX");
        int yCord = plugin.getConfig().getInt("SpawnY");
        int zCord = plugin.getConfig().getInt("SpawnZ");

        Player player = event.getPlayer();
        player.teleport(new Location(player.getWorld(),xCord,yCord,zCord));
        event.setJoinMessage(tag + ChatColor.GREEN + " >>> " +  ChatColor.GOLD + player.getName()  + ChatColor.GREEN + " hat den Server betreten! Hi! " );
        player.sendMessage(tag + ChatColor.YELLOW + " Willkommen auf dem PVP-Server vom GGL!");
        player.sendTitle(ChatColor.YELLOW + "PVP", tag);
        player.playSound(player.getLocation(), Sound.BLOCK_BELL_USE, 1,1);

        Inventory inventory = player.getInventory();
        inventory.clear();

        ItemStack selector = new ItemStack(Material.DIAMOND);
        ItemMeta selectorMeta = selector.getItemMeta();
        selectorMeta.setDisplayName(ChatColor.GOLD + "KIT SELECTOR");
        selectorMeta.setLore(List.of("Wähle ein Kit für den Kampf"));
        selector.setItemMeta(selectorMeta);

        ItemStack arenatp = new ItemStack(Material.IRON_SWORD);
        ItemMeta arenatpMeta = arenatp.getItemMeta();
        arenatpMeta.setDisplayName(ChatColor.GOLD + "ARENA");
        arenatpMeta.setLore(List.of("Tritt der Arena zum Kampf bei"));
        arenatp.setItemMeta(arenatpMeta);

        ItemStack lobbytp = new ItemStack(Material.COMPASS);
        ItemMeta lobbytpMeta = lobbytp.getItemMeta();
        lobbytpMeta.setDisplayName(ChatColor.GOLD + "LOBBY");
        lobbytpMeta.setLore(List.of("Kehre zur Lobby zurück"));
        lobbytp.setItemMeta(lobbytpMeta);


        inventory.setItem(1, arenatp);
        inventory.setItem(5, selector);
        inventory.setItem(9, lobbytp);



    }

}
