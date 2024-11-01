package de.goethemc.schuldropdffaplugin.etc;

import de.goethemc.schuldropdffaplugin.SchulDropDffaPlugin;

public class SpawnIsland {
    private final SchulDropDffaPlugin plugin;
    public SpawnIsland(SchulDropDffaPlugin plugin){
        this.plugin = plugin;
    }

    public boolean isSpawnIsland(double x, double y, double z){
        double smallerX = smallerValue("X");
        double greaterX = greaterValue("X");
        double smallerY = smallerValue("Y");
        double greaterY = greaterValue("Y");
        double smallerZ = smallerValue("Z");
        double greaterZ = greaterValue("Z");


        return x >= smallerX && x <= greaterX &&
                y >= smallerY && y <= greaterY &&
                z >= smallerZ && z <= greaterZ;
    }



    public double greaterValue(String path) {
        double a = plugin.getConfig().getInt("spawn-area."+path+"1");
        double b = plugin.getConfig().getInt("spawn-area."+path+"2");

        if(a > b) return a;
        return b;
    }
    public double smallerValue(String path){
        double a = this.plugin.getConfig().getInt("spawn-area."+path+"1");
        double b = this.plugin.getConfig().getInt("spawn-area."+path+"2");

        if(a <= b) return a;
        return b;
    }
}