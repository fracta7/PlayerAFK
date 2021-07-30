package com.fracta7.playerafk;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import java.util.HashSet;

public class CommandAfk implements CommandExecutor {

    public HashSet<String> PlayersAFK = new HashSet<>();

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(sender instanceof Player){
            Player player = (Player) sender;
            String name = player.getPlayer().getName();
            //checking if player was afk
            if(!PlayersAFK.contains(name)){
                //if player was not afk
                //sending message to everyone
                for(Player p: Bukkit.getOnlinePlayers()){
                    p.sendMessage(ChatColor.YELLOW +name+ChatColor.GOLD+" is AFK now");
                }
                //adding to list of afk players
                PlayersAFK.add(name);
            }else{
                //if player was afk
                for(Player p: Bukkit.getOnlinePlayers()){
                    p.sendMessage(ChatColor.YELLOW+name+ChatColor.GOLD+" is no longer AFK");
                }
                PlayersAFK.remove(name);
            }
        }
        return true;
    }

    //getter
    public boolean isAFK(String name){
        return PlayersAFK.contains(name);
    }

    //setter
    public void removeAFK(String playerName){
        PlayersAFK.remove(playerName);
    }

    //adding entry
    public void addAFK(String playerName){
        PlayersAFK.add(playerName);
    }


}
