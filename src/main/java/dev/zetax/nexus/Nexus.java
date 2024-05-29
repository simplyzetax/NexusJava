package dev.zetax.nexus;

import dev.zetax.nexus.EventListeners.GUIClose;
import dev.zetax.nexus.EventListeners.GUIOpen;
import org.bukkit.plugin.java.JavaPlugin;

public final class Nexus extends JavaPlugin {

    public static Nexus INSTANCE;

    @Override
    public void onEnable() {

        getLogger().info("Nexus has been enabled!");

        if (getServer().getPluginManager().getPlugin("UltraCustomizer") == null) {
            getLogger().severe("UltraCustomizer is not installed! Disabling Nexus...");
            getServer().getPluginManager().disablePlugin(this);
            return;
        }

        INSTANCE = this;

        getServer().getPluginManager().registerEvents(new GUIOpen(), this);
        getServer().getPluginManager().registerEvents(new GUIClose(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("Nexus has been disabled!");
    }
}
