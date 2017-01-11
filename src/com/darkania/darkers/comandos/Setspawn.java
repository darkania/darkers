package com.darkania.darkers.comandos;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.darkania.darkers.extras.Permisos;

public class Setspawn implements CommandExecutor{
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		if (cmd.getName().equalsIgnoreCase("setspawn") && sender instanceof Player){
			if (Permisos.tiene(sender, "Darkers.admin")){
				Player p = (Player) sender;
				
				int X = p.getLocation().getBlockX();
				int Y = p.getLocation().getBlockY();
				int Z = p.getLocation().getBlockZ();
				p.getWorld().setSpawnLocation(X, Y, Z);
				p.sendMessage(ChatColor.GOLD+"Has cambiado el spawn a las coordenadas "+X+" "+Y+" "+Z);
				return true;
			}
			if (!Permisos.tiene(sender, "Darkers.admin")){
				sender.sendMessage(ChatColor.translateAlternateColorCodes('&', Bukkit.getPluginManager().getPlugin("Darkers").getConfig().getString("General.SinPermisos")));
				return true;
			}
		}
		if (!(sender instanceof Player)){
			sender.sendMessage(ChatColor.GREEN+"[Darkers] "+ChatColor.RED+"No utilizable desde la consola.");
			return true;
		}
		return false;
	}
}
