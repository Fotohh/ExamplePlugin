package me.fotoh.exampleplugin;

import me.fotoh.exampleplugin.commands.ReloadCommand;
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

        if(!getDataFolder().exists()) getDataFolder().mkdirs();

        config = new CustomConfig(this);

        if(config.getConfig().get("numbers.integer_number") == null) {
            config.getConfig().set("numbers.integer_number", 10);
            config.save();
        }

        getLogger().info("The plugin has started!");

        getCommand("test").setExecutor(new TestCommand(this));
        getCommand("reload-config").setExecutor(new ReloadCommand(this));
        new OnJoin(this);
    }

    @Override
    public void onDisable() {
        getLogger().info("The plugin has been disabled!");
    }
}
