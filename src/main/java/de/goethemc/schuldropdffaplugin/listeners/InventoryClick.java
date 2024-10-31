package de.goethemc.schuldropdffaplugin.listeners;

import de.goethemc.schuldropdffaplugin.SchulDropDffaPlugin;
import de.goethemc.schuldropdffaplugin.etc.Kits;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.HashMap;
import java.util.UUID;


public class InventoryClick implements Listener {
    Kits kit = new Kits();
    private final SchulDropDffaPlugin plugin;

    public InventoryClick(SchulDropDffaPlugin plugin){
        this.plugin = plugin;
    }

    HashMap<Player,String> playerKitMap = new HashMap<>();
    private final String uhc = "UHC";
    private final String onlySword = "ONLYSWORD";
    private final String soup = "SOUP";
    private final String axe = "AXE";

    @EventHandler
    public void onClick(InventoryClickEvent e) {
        if (e.getWhoClicked() instanceof Player p) {
            switch (e.getCurrentItem().getType()) {
                case Material.GOLDEN_APPLE:
                    playerKitMap.put(p, this.uhc);
                    p.sendMessage("Du hast das UHC kit erfolgreich ausgewählt.");
                    break;
                case Material.DIAMOND_SWORD:
                    playerKitMap.put(p, this.onlySword);
                    p.sendMessage("Du hast das UHC kit erfolgreich ausgewählt.");
                    break;
                case Material.NETHERITE_CHESTPLATE:
                    playerKitMap.put(p, this.soup);
                    p.sendMessage("Du hast das UHC kit erfolgreich ausgewählt.");
                    break;
                case Material.NETHERITE_AXE:
                    playerKitMap.put(p, this.axe);
                    p.sendMessage("Du hast das UHC kit erfolgreich ausgewählt.");
                    break;
            }
        }
    }


        @EventHandler
        public void onFallDamage(EntityDamageEvent event){
            int minFallDistance = plugin.getConfig().getInt("minFallDistance");
            if (event.getEntity() instanceof Player player){
                if (event.getCause() == EntityDamageEvent.DamageCause.FALL && player.getFallDistance() >= minFallDistance){
                    checkForKit(player);
                }
            }
        }

        @EventHandler
        public void onPlayerDeath(PlayerDeathEvent e){
            Player died = e.getPlayer();

            if(died.getKiller() == null) return;
            Player killer = died.getKiller();
            killer.setHealthScale(20);

            checkForKit(killer);

        }

        public void checkForKit(Player player){
        if(playerKitMap.containsKey(player)){
            switch (playerKitMap.get(player)){
                case "UHC": kit.getUHC(player); break;
                case "SOUP": kit.getSoup(player); break;
                case "AXE": kit.getAxe(player); break;
                default: kit.getOnlySword(player); break;
            }
        }else{
            kit.getOnlySword(player);
        }

        }
}
