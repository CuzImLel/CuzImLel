package de.cuzimlel.pvpplugin;

import de.cuzimlel.pvpplugin.scoreboard.TestScoreboard;
import de.cuzimlel.pvpplugin.tablist.TablistManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import sun.tools.jconsole.Tab;

public class JoinListener implements Listener {
    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        event.setJoinMessage(ChatColor.GREEN + ChatColor.ITALIC.toString() + "Welcome back " + player.getName());
        new TestScoreboard(player);
        TablistManager.setPlayerList(player);
        TablistManager.setPlayerTeams(player);


    }

}
