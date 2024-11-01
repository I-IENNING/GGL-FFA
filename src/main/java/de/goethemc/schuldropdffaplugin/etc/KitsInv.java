package de.goethemc.schuldropdffaplugin.etc;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class KitsInv {
    public void openKitsInv(Player player,String ausgewählt){
        Inventory kitInv = Bukkit.createInventory(player, 9, ChatColor.GOLD + "Kits");

        ItemStack classicKit = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta classicKitMeta = classicKit.getItemMeta();
        classicKitMeta.setDisplayName(ChatColor.AQUA+ "Only Sword");
        classicKitMeta.setLore(List.of("1 Schwert + 2 Gold Äpfel"));
        classicKit.setItemMeta(classicKitMeta);

        ItemStack tankKit = new ItemStack(Material.MUSHROOM_STEW);
        ItemMeta tankKitMeta = tankKit.getItemMeta();
        tankKitMeta.setDisplayName(ChatColor.DARK_GRAY+ "Soup");
        tankKitMeta.setLore(List.of("Eisenschwert + Lederrüstung + Soups"));
        tankKit.setItemMeta(tankKitMeta);

        ItemStack axtKit = new ItemStack(Material.NETHERITE_AXE);
        ItemMeta axtKitMeta = axtKit.getItemMeta();
        axtKitMeta.setDisplayName(ChatColor.RED + "Axt");
        axtKitMeta.setLore(List.of("Schwert + Axt + Bogen + Crossbow + Dia-Rüstung"));
        axtKit.setItemMeta(axtKitMeta);

        ItemStack rangeKit = new ItemStack(Material.BOW);
        ItemMeta rangeKitMeta = rangeKit.getItemMeta();
        rangeKitMeta.setDisplayName(ChatColor.YELLOW + "Fernkampf");
        rangeKitMeta.setLore(List.of("Bogen, Armbrust, etc."));
        rangeKit.setItemMeta(rangeKitMeta);

        ItemStack uhcKit = new ItemStack(Material.GOLDEN_APPLE);
        ItemMeta uhcKitMeta = uhcKit.getItemMeta();
        uhcKitMeta.setDisplayName(ChatColor.GOLD + "UHC");
        uhcKitMeta.setLore(List.of("Schwert + Lava + Wasser + Blöcke etc."));
        uhcKit.setItemMeta(uhcKitMeta);

        switch (ausgewählt){
            case "ONLYSWORD": classicKitMeta.setLore(List.of(ChatColor.GREEN+"Ausgewählt."));
                    classicKit.setItemMeta(classicKitMeta); break;
            case "SOUP": tankKitMeta.setLore(List.of(ChatColor.GREEN+"Ausgewählt."));
                    tankKit.setItemMeta(tankKitMeta); break;
            case "AXE": axtKitMeta.setLore(List.of(ChatColor.GREEN+"Ausgewählt."));
                    axtKit.setItemMeta(axtKitMeta); break;
            case "": break;
            case "UHC": uhcKitMeta.setLore(List.of(ChatColor.GREEN+"Ausgewählt."));
                    uhcKit.setItemMeta(uhcKitMeta); break;
            default: classicKitMeta.setLore(List.of(ChatColor.GREEN+"Ausgewählt."));
                    classicKit.setItemMeta(classicKitMeta); break;
        }


        kitInv.setItem(0,classicKit);
        kitInv.setItem(2,tankKit);
        kitInv.setItem(4,axtKit);
        kitInv.setItem(6,rangeKit);
        kitInv.setItem(8, uhcKit);

        player.openInventory(kitInv);
    }

}
