package com.darkania.darkers.comandos;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.darkania.darkers.extras.Permisos;

public class Curar implements CommandExecutor{
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		if (cmd.getName().equalsIgnoreCase("curar")){
			if (Permisos.tiene(sender, "Darkers.staff")){
				if (args.length == 0){
				if ((sender instanceof Player)){
					Player p = (Player) sender;
					@SuppressWarnings("deprecation")
					double max = p.getMaxHealth();
					p.setHealth(max);
					p.setFoodLevel(20);
					p.setSaturation(20);
					p.sendMessage(ChatColor.GOLD+"Te has curado.");
					return true;	
				}
				if ((!(sender instanceof Player))){
					sender.sendMessage(ChatColor.GREEN+"Uso: /curar [Usuario]");
					return true;
				}
				}
				if (args.length == 1){
					Player p2 = Bukkit.getServer().getPlayer(args[0]);
					if (p2 == null){
						sender.sendMessage(ChatColor.RED+"Jugador no encontrado");
						return true;
					}
					@SuppressWarnings("deprecation")
					double max = p2.getMaxHealth();
					p2.setHealth(max);
					p2.setFoodLevel(20);
					p2.setSaturation(20);
					p2.sendMessage(ChatColor.GOLD+"Has sido curado");
					sender.sendMessage(ChatColor.GREEN+"Has curado a "+p2.getDisplayName());
					return true;
				}
			}
			if (!Permisos.tiene(sender, "Darkers.staff")){
				sender.sendMessage(ChatColor.translateAlternateColorCodes('&', Bukkit.getPluginManager().getPlugin("Darkers").getConfig().getString("General.SinPermisos")));
				return true;
			}
		}
		return false;
	}
}
