package me.fotoh.exampleplugin.listeners;

import me.fotoh.exampleplugin.ExamplePlugin;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class OnJoin implements Listener {

    private final ExamplePlugin plugin;

    public OnJoin(ExamplePlugin plugin){
        this.plugin = plugin;
        Bukkit.getServer().getPluginManager().registerEvents(new OnJoin(plugin), plugin);
    }

    @EventHandler
    public void playerJoin(PlayerJoinEvent event){
        Player player = event.getPlayer();
        player.sendMessage("Hello there "  + player.getDisplayName() + "!");

        String CAN_FLY = "example_section.section1.section2.can_fly";
        if(plugin.getCustomConfig().getConfig().get(CAN_FLY) == null){
            plugin.getCustomConfig().getConfig().set(CAN_FLY, true);
            plugin.getCustomConfig().save();
        }

        player.setFlying(plugin.getCustomConfig().getConfig().getBoolean(CAN_FLY));
    }

    @EventHandler
    public void playerDeath(PlayerDeathEvent event){
        Player player = event.getEntity();
        player.sendMessage("You died!");
    }

}
