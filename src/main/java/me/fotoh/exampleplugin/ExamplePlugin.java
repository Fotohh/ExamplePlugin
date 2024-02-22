package me.fotoh.exampleplugin;

import me.fotoh.exampleplugin.commands.TestCommand;
import me.fotoh.exampleplugin.file.CustomConfig;
import me.fotoh.exampleplugin.listeners.OnJoin;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public final class ExamplePlugin extends JavaPlugin {

    private CustomConfig config;

    public CustomConfig getCustomConfig() {
        return config;
    }

    @Override
    public void onEnable() {

        if(!getDataFolder().exists()){
            getDataFolder().mkdirs();
        }

        config = new CustomConfig(this);

        saveDefaultConfig();
        getLogger().info("The plugin has started!");

        getCommand("test").setExecutor(new TestCommand(this));
        new OnJoin(this);
    }

    @Override
    public void onDisable() {
        getLogger().info("The plugin has been disabled!");
    }
}
