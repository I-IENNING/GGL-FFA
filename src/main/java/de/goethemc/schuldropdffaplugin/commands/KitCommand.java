package de.goethemc.schuldropdffaplugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class KitCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (commandSender instanceof Player player){

            Inventory partikel = Bukkit.createInventory(player, 9, ChatColor.GOLD + "Kits");

            ItemStack classicKit = new ItemStack(Material.DIAMOND_SWORD);
            ItemMeta classicKitMeta = classicKit.getItemMeta();
            classicKitMeta.setDisplayName(ChatColor.AQUA+ "Classic");
            classicKitMeta.setLore(List.of("Standart Ausrüstung"));
            classicKit.setItemMeta(classicKitMeta);

            ItemStack tankKit = new ItemStack(Material.NETHERITE_CHESTPLATE);
            ItemMeta tankKitMeta = tankKit.getItemMeta();
            tankKitMeta.setDisplayName(ChatColor.DARK_GRAY+ "Tank");
            tankKitMeta.setLore(List.of("Starke Rüstung"));
            tankKit.setItemMeta(tankKitMeta);

            ItemStack axtKit = new ItemStack(Material.NETHERITE_AXE);
            ItemMeta axtKitMeta = axtKit.getItemMeta();
            axtKitMeta.setDisplayName(ChatColor.RED + "Axt");
            axtKitMeta.setLore(List.of("Axt."));
            axtKit.setItemMeta(axtKitMeta);

            ItemStack rangeKit = new ItemStack(Material.BOW);
            ItemMeta rangeKitMeta = rangeKit.getItemMeta();
            rangeKitMeta.setDisplayName(ChatColor.YELLOW + "Fernkampf");
            rangeKitMeta.setLore(List.of("Bogen, Armbrust, etc."));
            rangeKit.setItemMeta(rangeKitMeta);

            ItemStack uhcKit = new ItemStack(Material.GOLDEN_APPLE);
            ItemMeta uhcKitMeta = uhcKit.getItemMeta();
            uhcKitMeta.setDisplayName(ChatColor.DARK_PURPLE + "UHC");
            uhcKitMeta.setLore(List.of("Tränke"));
            uhcKit.setItemMeta(uhcKitMeta);


            partikel.setItem(0,classicKit);
            partikel.setItem(2,tankKit);
            partikel.setItem(4,axtKit);
            partikel.setItem(6,rangeKit);
            partikel.setItem(8, uhcKit);

            player.openInventory(partikel);

        }
        else{
            commandSender.sendMessage("Du musst ein Spieler sein.");
        }
        return false;
    }
}
