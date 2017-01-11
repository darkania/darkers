package com.darkania.darkers.utilidades;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Team;

import com.darkania.darkers.Darkers;

public class ColoresEnNombres {
	public static void ColorPlayer(Player p){
		p.setDisplayName(ChatColor.WHITE+"["+ChatColor.RED+"Admin"+ChatColor.WHITE+"] "+ChatColor.RED+p.getName());
		
		Team team = Darkers.scoreboard.registerNewTeam(p.getName());
		team.setDisplayName(p.getName());
		team.setPrefix(ChatColor.RED.toString());
		team.addEntry(p.getName());
		p.setScoreboard(Darkers.scoreboard);
		p.sendMessage(ChatColor.GOLD+"Tu nuevo nick es "+p.getDisplayName());
	}

}
