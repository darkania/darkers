package com.darkania.darkers.comandos;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Mantenimiento implements CommandExecutor{
	public boolean onCommand(CommandSender sender, Command cmd, String labbel, String[] args){
		if (cmd.getName().equalsIgnoreCase("mantenimiento")){
			
			if (args.length == 0){
				sender.sendMessage(ChatColor.RED+"Uso: /mantenimiento on/off");
			}
			if (args.length == 1){
				if("on".contains(args[0])){
					if(Bukkit.getPluginManager().getPlugin("Darkers").getConfig().getBoolean("Mantenimiento")){
						sender.sendMessage(ChatColor.RED+"El mantenimiento ya esta activado");
						return false;
					}
					else{
						Bukkit.getPluginManager().getPlugin("Darkers").getConfig().set("Mantenimiento", true);	
						Bukkit.getPluginManager().getPlugin("Darkers").saveConfig();
						Bukkit.getPluginManager().getPlugin("Darkers").reloadConfig();
						sender.sendMessage(ChatColor.RED+"Se ha activado el mantenimiento");
						return false;
					}
					
				}
				
				if("off".contains(args[0])){
					if(!Bukkit.getPluginManager().getPlugin("Darkers").getConfig().getBoolean("Mantenimiento")){
						sender.sendMessage(ChatColor.RED+"El mantenimiento ya esta desactivado");
						return false;
					}
					else{
						Bukkit.getPluginManager().getPlugin("Darkers").getConfig().set("Mantenimiento", false);
						Bukkit.getPluginManager().getPlugin("Darkers").saveConfig();
						Bukkit.getPluginManager().getPlugin("Darkers").reloadConfig();
						sender.sendMessage(ChatColor.RED+"Se ha desactivado el mantenimiento");
						return false;
					}
					
				}
			}
			if (args.length >= 2){
				sender.sendMessage(ChatColor.RED+"Uso: /mantenimiento on/off");
			}
			
		}
		
		return false;
	}
	

}
