package com.Hdestroyer.plugin.command;

import com.Hdestroyer.plugin.HdestroyerMain;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;


public class Enclosure implements Listener {
    public double X1;
    public double Y1;
    public double Z1;
    public double X2;
    public double Y2;
    public double Z2;
    @EventHandler
    public void onPlayerSlectBlock(PlayerInteractEvent e) {
        ItemStack Itemhand = e.getItem();
        if (Itemhand == null) {
            return;
        }
        Player p = e.getPlayer();
        double x1;
        double y1;
        double z1;
        double x2;
        double y2;
        double z2;
        if (HdestroyerMain.Plugin.wood.isSimilar(e.getItem())) {
            if (e.getAction() == Action.LEFT_CLICK_BLOCK) {
                e.setCancelled(true);
                x1 = e.getClickedBlock().getLocation().getX();
                y1 = e.getClickedBlock().getLocation().getY();
                z1 = e.getClickedBlock().getLocation().getZ();
                X1 = x1;
                Y1 = y1;
                Z1 = z1;
            }
            if (e.getAction() == Action.RIGHT_CLICK_BLOCK) {
                x2 = e.getClickedBlock().getLocation().getX();
                y2 = e.getClickedBlock().getLocation().getY();
                z2 = e.getClickedBlock().getLocation().getZ();
                e.setCancelled(true);
                X2 = x2;
                Y2 = y2;
                Z2 = z2;
            }
            double X = x2 - X1;
            double Y = y2 - Y1;
            double Z = z2 - Z1;
            if (X < 0){
                X = X -1;
            }else{
                X = X +1;
            }
            if (Y < 0){
                Y = Y -1;
            }else {
                Y = Y +1;
            }
            if (Z < 0){
                Z = Z -1;
            }else {
                Z = Z +1;
            }
            Math.abs(X);
            Math.abs(Y);
            Math.abs(Z);
            p.sendMessage("总大小为:" + Math.abs(X * Y * Z));
        }
    }
}
