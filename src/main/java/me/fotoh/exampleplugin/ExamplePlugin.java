package me.fotoh.exampleplugin;

import me.fotoh.exampleplugin.commands.TestCommand;
import org.bukkit.plugin.java.JavaPlugin;

public class ExamplePlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("The plugin has started!");

        getCommand("test").setExecutor(new TestCommand(this));
    }

    @Override
    public void onDisable() {
        getLogger().info("The plugin has been disabled!");
    }
}
