package com.darkania.darkers.comandos;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import com.darkania.darkers.extras.Permisos;

import org.bukkit.ChatColor;

public class Jobs implements CommandExecutor {

	public void prMsg(CommandSender sender, String msg) {
		
	}

public boolean onCommand(CommandSender sender , Command cmd , String labbel , String [] args) {
		if (cmd.getName().equalsIgnoreCase("jobs") && sender instanceof Player) {
			
		if (Permisos.tiene(sender, "Darkers.jobs") && (Permisos.tiene(sender, "Darkers.usuario"))){
			Player pr = (Player) sender;
			pr.sendMessage(ChatColor.translateAlternateColorCodes('&', Bukkit.getPluginManager().getPlugin("Darkers").getConfig().getString("jobs.PrimeraLinea")));
			pr.sendMessage(ChatColor.translateAlternateColorCodes('&', Bukkit.getPluginManager().getPlugin("Darkers").getConfig().getString("jobs.SegundaLinea")));
			pr.sendMessage(ChatColor.translateAlternateColorCodes('&', Bukkit.getPluginManager().getPlugin("Darkers").getConfig().getString("jobs.TercerLinea")));
			pr.sendMessage(ChatColor.translateAlternateColorCodes('&', Bukkit.getPluginManager().getPlugin("Darkers").getConfig().getString("jobs.CuartaLinea")));
			return true;
			}
		if (!Permisos.tiene(sender, "Darkers.jobs") && (Permisos.tiene(sender, "Darkers.usuario"))){
			Player pr = (Player) sender;
			pr.sendMessage(ChatColor.translateAlternateColorCodes('&', Bukkit.getPluginManager().getPlugin("Darkers").getConfig().getString("General.SinPermisos")));
			return true;
			}
		}
		if (!(sender instanceof Player)){
			ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
		    console.sendMessage(ChatColor.GREEN + "[Darkers] "+ChatColor.RED+"No utilizable desde la consola.");
		}
		return false;
	}
}
