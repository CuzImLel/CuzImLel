package de.cuzimlel.pvpplugin;

import de.cuzimlel.pvpplugin.tablist.TablistManager;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import sun.tools.jconsole.Tab;

public final class Main extends JavaPlugin {
    private static Main instance;


    public Main() {
        instance = this;
    }
    public static Main getInstance() {
        return instance;
    }
    @Override
    public void onEnable() {
        // Plugin startup logic
        PluginManager manager = Bukkit.getPluginManager();
        manager.registerEvents(new JoinListener(), this);

            new BukkitRunnable() {
                @Override
                public void run() {
                    for (Player all : Bukkit.getOnlinePlayers()) {
                        TablistManager.UpdatePlayerTeams(all);
                    }
                }
            }.runTaskTimer(Main.getInstance(), 0, 20);
        }





    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }




}
