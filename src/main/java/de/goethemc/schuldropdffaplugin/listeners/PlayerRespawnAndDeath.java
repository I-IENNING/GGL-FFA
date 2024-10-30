package de.goethemc.schuldropdffaplugin.listeners;

import de.goethemc.schuldropdffaplugin.SchulDropDffaPlugin;
import de.goethemc.schuldropdffaplugin.etc.SpawnInv;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

import static org.bukkit.Effect.Type.SOUND;

public class PlayerRespawnAndDeath implements Listener {
    SpawnInv inv = new SpawnInv();
    private final SchulDropDffaPlugin plugin;
    public PlayerRespawnAndDeath(SchulDropDffaPlugin plugin){this.plugin = plugin;}

    @EventHandler
    public void onPlayerRespawn(PlayerRespawnEvent e){
        int xCord = plugin.getConfig().getInt("SpawnX");
        int yCord = plugin.getConfig().getInt("SpawnY");
        int zCord = plugin.getConfig().getInt("SpawnZ");
        Player p = e.getPlayer();
        Location loc = new Location(p.getWorld(), xCord,yCord,zCord);
        e.setRespawnLocation(loc);

        p.teleport(new Location(p.getWorld(),xCord,yCord,zCord));

        p.getInventory().clear();
        inv.setPlayerInv(p.getInventory());
        p.playSound(p.getLocation(), Sound.ENTITY_ELDER_GUARDIAN_DEATH,1,1);
    }
    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent e){
        e.getDrops().clear();
        Player p = e.getPlayer();

        //geile alle sounds: https://minecraftsounds.com/
        p.getKiller().playSound(p.getLocation(), Sound.BLOCK_AMETHYST_BLOCK_BREAK,1,1);
    }

}
