package com.darkania.darkers.comandos;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.darkania.darkers.Darkers;
import com.darkania.darkers.extras.Permisos;

public class SocialSpy implements CommandExecutor{
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		if (cmd.getName().equalsIgnoreCase("socialspy")){
			if (Permisos.tiene(sender, "Darkers.staffSP")){
				Player p = (Player) sender;
				if (args.length == 0){
					sender.sendMessage(ChatColor.RED+"Uso: /socialspy <on>,<off>");
					return true;
				}
				if (args.length >= 1){
					if ("on".equals(args[0])){
						Darkers.socialspy.add(p.getName());
						sender.sendMessage(ChatColor.DARK_AQUA+""+ChatColor.BOLD+"Te has activado el SocialSpy");
						return true;
					}
					if ("off".equals(args[0])){
						Darkers.socialspy.remove(p.getName());
						sender.sendMessage(ChatColor.RED+"Te has desactivado el SocialSpy");
						return true;
					}
				}
			}
			if (!Permisos.tiene(sender, "Darkers.staffSP")){
				sender.sendMessage(ChatColor.translateAlternateColorCodes('&', Bukkit.getPluginManager().getPlugin("Darkers").getConfig().getString("General.SinPermisos")));
				return true;
			}
		}
		return false;
	}
}
