package com.darkania.darkers.comandos;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.darkania.darkers.extras.Permisos;

public class Enderchest implements CommandExecutor{

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("enderchest") && sender instanceof Player){
			Player p = (Player) sender;
			if (Permisos.tiene(p, "Darkers.beta")){
				p.openInventory(p.getEnderChest());
				return true;
			}
			if (!Permisos.tiene(p, "Darkers.beta")){
				p.sendMessage(ChatColor.translateAlternateColorCodes('&', Bukkit.getPluginManager().getPlugin("Darkers").getConfig().getString("General.SinPermisos")));
				return true;
			}
			
		}
		if (!(sender instanceof Player)){
			sender.sendMessage(ChatColor.GREEN+"[Darkers]"+ChatColor.RED+" No utilizable desde la consola");
			return true;
		}
		return false;
	}
}
