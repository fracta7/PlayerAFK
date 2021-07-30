package com.fracta7.playerafk;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class AFKListener implements Listener {
    CommandAfk pafk = new CommandAfk();

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        //listens when players move
        //players who are afk will no longer be afk when they move
        //if (event.getTo().getBlockX() != event.getFrom().getBlockX() || event.getTo().getBlockY() != event.getFrom().getBlockY() || event.getTo().getBlockZ() != event.getFrom().getBlockZ()) {

        System.out.println(pafk.isAFK("fracta7"));
        if (pafk.isAFK(event.getPlayer().getName())) {
            //broadcasting to everyone
            String pName = event.getPlayer().getName();
            event.getPlayer().sendMessage("moved");
            for (Player p : Bukkit.getOnlinePlayers()) {
                p.sendMessage(ChatColor.YELLOW + pName + ChatColor.GOLD + " is no longer AFK");
            }
            //removing from list
            pafk.removeAFK(pName);
        }
    }

}
