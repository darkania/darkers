package com.darkania.darkers.comandos;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Suicide implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("suicide")){
			Player p = (Player) sender;
			p.setHealth(0.0D);
			Bukkit.broadcastMessage(p.getDisplayName()+ChatColor.RED+" se ha suicidado.");
			return true;
		}
		return false;
	}
	

}
