package com.darkania.darkers.comandos;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import com.darkania.darkers.extras.Permisos;

public class Craftear implements CommandExecutor{
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		if (cmd.getName().equalsIgnoreCase("craftear") && sender instanceof Player){
			if (Permisos.tiene(sender, "Darkers.vip")){
				Player p = (Player) sender;
				p.openWorkbench(null, true);
				return true;
			}
			if (!Permisos.tiene(sender, "Darkers.vip")){
				sender.sendMessage(ChatColor.translateAlternateColorCodes('&', Bukkit.getPluginManager().getPlugin("Darkers").getConfig().getString("General.SinPermisos")));
			}
		}
		if (!(sender instanceof Player)){
			ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
		    console.sendMessage(ChatColor.GREEN + "[Darkers] "+ChatColor.RED+"No utilizable desde la consola.");
		}
		return false;
	}

}
