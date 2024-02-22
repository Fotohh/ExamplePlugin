package me.fotoh.exampleplugin.file;

import me.fotoh.exampleplugin.ExamplePlugin;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class CustomConfig extends File {

    private final ExamplePlugin plugin;

    private final YamlConfiguration yml = new YamlConfiguration();

    public CustomConfig(ExamplePlugin plugin) {
        super(plugin.getDataFolder(), "custom_config.yml");
        this.plugin = plugin;

        if(!exists()){
            try {
                createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        try {
            yml.load(this);
        } catch (IOException | InvalidConfigurationException e) {
            throw new RuntimeException(e);
        }
    }

    public YamlConfiguration getConfig(){
        return yml;
    }

    public void save(){
        try {
            yml.save(this);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
