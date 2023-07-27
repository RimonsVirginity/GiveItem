package giveitem.give;

import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
    getCommand("TestGive").setExecutor(new GiveCommand(this));






    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
