package me.fotoh.exampleplugin.commands;

import me.fotoh.exampleplugin.ExamplePlugin;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TestCommand implements CommandExecutor {

    private final ExamplePlugin plugin;

    public TestCommand(ExamplePlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if(commandSender instanceof Player player){
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&bThis is the test command!"));
        }else{
            commandSender.sendMessage("Hi console!");
        }

        return true;
    }
}
