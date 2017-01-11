package com.darkania.darkers.comandos;

import org.bukkit.ChatColor;
import org.bukkit.WeatherType;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class DesactivarLluvia implements CommandExecutor{
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		if (cmd.getName().equalsIgnoreCase("desactivar") && sender instanceof Player){
			Player p = (Player)sender;
			if (args.length == 0){
				p.sendMessage(ChatColor.RED+"Uso: /desactivar lluvia");
				return true;
			}
			if (args.length == 1){
				if ("lluvia".contains(args[0])){
					p.setPlayerWeather(WeatherType.CLEAR);
					p.sendMessage(ChatColor.GREEN+"Te has desactivado la lluvia.");
					return true;
				}
				if (!"lluvia".contains(args[0])){
					p.sendMessage(ChatColor.RED+"Uso: /desactivar lluvia");
					return true;
				}
			}
			if (args.length >= 2){
				p.sendMessage(ChatColor.RED+"Uso: /desactivar lluvia");
				return true;
			}
		}
		return false;
	}
}
