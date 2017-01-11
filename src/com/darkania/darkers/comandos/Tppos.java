package com.darkania.darkers.comandos;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.darkania.darkers.extras.Permisos;

import net.md_5.bungee.api.ChatColor;

public class Tppos implements CommandExecutor{
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		if (cmd.getName().equalsIgnoreCase("tppos") && sender instanceof Player){
			Player p = (Player) sender;
			if (Permisos.tiene(p, "Darkers.staff")){
				if (args.length == 3){
					Location targetPos = new Location(p.getWorld(), Integer.parseInt(args[0]), Integer.parseInt(args[1]), Integer.parseInt(args[2]));
			          p.teleport(targetPos);
			          p.sendMessage(ChatColor.DARK_AQUA+"Teletransportado...");
			          return true;
				}
				if (args.length > 3){
					p.sendMessage(ChatColor.RED+"Uso: /tppos [x y z]");
					return true;
				}
				if (args.length <= 2){
					p.sendMessage(ChatColor.RED+"Uso: /tppos [x y z]");
					return true;
				}
			}
			if (!Permisos.tiene(p, "Darkers.staff")){
				ChatColor.translateAlternateColorCodes('&', Bukkit.getPluginManager().getPlugin("Darkers").getConfig().getString("General.SinPermisos"));
				return true;
			}
		}
		if (!(sender instanceof Player)){
			sender.sendMessage(ChatColor.GREEN+"[Darkers] "+ChatColor.RED+"No utilizable desde la consola");
			return true;
		}
		return false;
	}

}
