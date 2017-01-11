package com.darkania.darkers.comandos;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import com.darkania.darkers.extras.Permisos;

public class Limpiar implements CommandExecutor{
	public boolean onCommand(CommandSender sender, Command cmd, String labbel, String[] args){
		if(cmd.getName().equalsIgnoreCase("limpiar")){
			if (args.length == 0){
				sender.sendMessage("");
				sender.sendMessage("");
				sender.sendMessage("");
				sender.sendMessage("");
				sender.sendMessage("");
				sender.sendMessage("");
				sender.sendMessage("");
				sender.sendMessage("");
				sender.sendMessage("");
				sender.sendMessage("");
				sender.sendMessage("");
				sender.sendMessage("");
				sender.sendMessage("");
				sender.sendMessage("");
				sender.sendMessage("");
				sender.sendMessage("");
				sender.sendMessage("");
				sender.sendMessage("");
				sender.sendMessage("");
				sender.sendMessage("");
				sender.sendMessage("");
				sender.sendMessage("");
				sender.sendMessage("");
				sender.sendMessage("");
				sender.sendMessage("");
				sender.sendMessage("");
				sender.sendMessage("");
				sender.sendMessage("");
				sender.sendMessage("");
				sender.sendMessage("");
				sender.sendMessage("");
				sender.sendMessage("");
				sender.sendMessage("");
				sender.sendMessage("");
				sender.sendMessage(ChatColor.GOLD+"Chat Limpiado.");
				return true;
			}
			if ("todos".equalsIgnoreCase(args[0])){
				if (Permisos.tiene(sender, "Darkers.staff")){
					Bukkit.broadcastMessage("");
					Bukkit.broadcastMessage("");
					Bukkit.broadcastMessage("");
					Bukkit.broadcastMessage("");
					Bukkit.broadcastMessage("");
					Bukkit.broadcastMessage("");
					Bukkit.broadcastMessage("");
					Bukkit.broadcastMessage("");
					Bukkit.broadcastMessage("");
					Bukkit.broadcastMessage("");
					Bukkit.broadcastMessage("");
					Bukkit.broadcastMessage("");
					Bukkit.broadcastMessage("");
					Bukkit.broadcastMessage("");
					Bukkit.broadcastMessage("");
					Bukkit.broadcastMessage("");
					Bukkit.broadcastMessage("");
					Bukkit.broadcastMessage("");
					Bukkit.broadcastMessage("");
					Bukkit.broadcastMessage("");
					Bukkit.broadcastMessage("");
					Bukkit.broadcastMessage("");
					Bukkit.broadcastMessage("");
					Bukkit.broadcastMessage("");
					Bukkit.broadcastMessage("");
					Bukkit.broadcastMessage("");
					Bukkit.broadcastMessage("");
					Bukkit.broadcastMessage("");
					Bukkit.broadcastMessage("");
					Bukkit.broadcastMessage("");
					Bukkit.broadcastMessage("");
					Bukkit.broadcastMessage("");
					Bukkit.broadcastMessage("");
					Bukkit.broadcastMessage("");
					Bukkit.broadcastMessage(ChatColor.GOLD+"Chat Limpiado.");
					sender.sendMessage(ChatColor.BLUE+"Has limpiado el chat global.");
					return true;
				}
			}
		}
		return false;
	}
}
