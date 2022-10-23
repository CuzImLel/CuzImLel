package de.cuzimlel.pvpplugin.scoreboard;

import de.cuzimlel.pvpplugin.Main;
import org.bukkit.ChatColor;
import org.bukkit.Statistic;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class TestScoreboard extends ScoreboardBuilder{
    private int socialId;
    public TestScoreboard(Player player) {
        super(player, "   UserStats   ");
        socialId = 0;
        run();
    }

    @Override
    public void createScoreboard() {
        setScore("", 8);
        setScore(ChatColor.GREEN + ChatColor.BOLD.toString() + "Hey ", 7);
        setScore(player.getName(), 6);
        setScore(ChatColor.GREEN.toString(), 5);
        setScore( ChatColor.RED + "Total-Kills", 4);
        setScore(String.valueOf(player.getStatistic(Statistic.PLAYER_KILLS)), 3);
        setScore(ChatColor.GREEN.toString(), 2);
        setScore(ChatColor.RED + "Total-Deaths", 1);
        setScore(String.valueOf(player.getStatistic(Statistic.DEATHS)), 0);
    }


    private void run() {
        new BukkitRunnable() {
            @Override
            public void run() {
            switch (socialId) {
                case 0:
                    setScore(player.getName(), 6);
                    break;
                case 1:
                    setScore( ">> " + player.getName() + " <<", 6);
                    setScore(String.valueOf(player.getStatistic(Statistic.DEATHS)), 0);
                    setScore(String.valueOf(player.getStatistic(Statistic.PLAYER_KILLS)), 3);
                    break;
                case 2:
                    setScore(player.getName(), 6);
                    break;

            }
            socialId++;
            if (socialId >= 3) {
                socialId = 0;
            }
            }
        }.runTaskTimer(Main.getInstance(), 20, 20);

    }
}
