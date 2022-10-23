package de.cuzimlel.pvpplugin.tablist;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

public class TablistManager {
    public static void setPlayerList(Player player) {
        player.setPlayerListHeaderFooter(ChatColor.GOLD + ">> " + ChatColor.BLUE + "SpeedCoding" + ChatColor.GOLD + " <<" + ChatColor.GREEN + "\n Welcome back " + player.getName(), ChatColor.YELLOW + "Have Fun!");
    }
    public static void setPlayerTeams(Player player) {
        Scoreboard scoreboard = player.getScoreboard();
        Team User = scoreboard.getTeam("010users");
        if (User == null) {
            User = scoreboard.registerNewTeam("010users");

        }
        Team Staff = scoreboard.getTeam("001Admin");
        if (Staff == null) {
            Staff = scoreboard.registerNewTeam("001Admin");

        }
        Staff.setPrefix(ChatColor.RED + "Admin " + ChatColor.DARK_GRAY + "| ");
        Staff.setColor(ChatColor.RED);
        User.setPrefix(ChatColor.GREEN + "User " + ChatColor.DARK_GRAY + "| ");
        User.setColor(ChatColor.GREEN);
        for (Player all : Bukkit.getOnlinePlayers()) {
            if (all.isOp()) {
                Staff.addEntry(all.getName());
                continue;
            }
                User.addEntry(all.getName());

        }
    }
    public static void UpdatePlayerTeams(Player player) {
        Scoreboard scoreboard = player.getScoreboard();
        Team User = scoreboard.getTeam("010users");
        Team Staff = scoreboard.getTeam("001Admin");
        if (User == null || Staff == null) {
            setPlayerTeams(player);
            return;
        }
        for (Player all : Bukkit.getOnlinePlayers()) {
            if (all.isOp()) {
                Staff.addEntry(all.getName());
                continue;
            }
                User.addEntry(all.getName());

        }
    }

}
