package com.fracta7.playerafk;

import org.bukkit.plugin.java.JavaPlugin;

public final class PlayerAFK extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        System.out.println("Starting [PlayerAFK]...");
        CommandAfk coafk = new CommandAfk();
        coafk.isAFK("fracta7");
        getServer().getPluginManager().registerEvents(new AFKListener(), this);
        this.getCommand("afk").setExecutor(new CommandAfk());
    }

}
