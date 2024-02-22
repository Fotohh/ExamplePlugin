package me.fotoh.exampleplugin.commands;

import me.fotoh.exampleplugin.ExamplePlugin;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ReloadCommand implements CommandExecutor {

    private final ExamplePlugin plugin;

    public ReloadCommand(ExamplePlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if(commandSender instanceof Player){
            Player player = (Player) commandSender;
            if(!player.isOp()){
                player.sendMessage("You dont have the correct permissions!");
                return true;
            }
        }

        plugin.getCustomConfig().reload();

        commandSender.sendMessage("Reloaded configuration file!");


        return true;
    }
}
