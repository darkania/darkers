package com.darkania.darkers.comandos;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Spawn implements CommandExecutor{
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		if (cmd.getName().equalsIgnoreCase("spawn") && sender instanceof Player){
			Player p = (Player)sender;
			p.teleport(p.getWorld().getSpawnLocation());
			p.sendMessage(ChatColor.GOLD+"Bienvenido al spawn");
			return true;
		}
		return false;
	}

}
