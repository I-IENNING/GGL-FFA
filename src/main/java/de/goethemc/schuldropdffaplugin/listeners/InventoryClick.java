package de.goethemc.schuldropdffaplugin.listeners;

import de.goethemc.schuldropdffaplugin.etc.Kits;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;


public class InventoryClick implements Listener {
    Kits kit = new Kits();
    @EventHandler
    public void onClick(InventoryClickEvent e){
        if(e.getWhoClicked() instanceof Player p){
            switch (e.getCurrentItem().getType()){
                case Material.GOLDEN_APPLE:
                    kit.getUHC(p);
                    break;
                case Material.DIAMOND_SWORD:
                    kit.getOnlySword(p);
                    break;
                case Material.NETHERITE_CHESTPLATE:
                    kit.getSoup(p);
                    break;
            }
        }

    }
}
