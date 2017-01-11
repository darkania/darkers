package com.darkania.darkers.comandos;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.darkania.darkers.extras.Permisos;

public class SetHealth implements CommandExecutor{
	@SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		if (cmd.getName().equalsIgnoreCase("sethealth") && sender instanceof Player){
			if (Permisos.tiene(sender, "Darkers.staffSP")){
				if (args.length == 0){
					Player p = (Player) sender;
					p.sendMessage(ChatColor.RED+"Uso: /sethealth [Cantidad-Doble]");
					return true;
				}
				if (args.length == 1){
					Player p = (Player) sender;
					double i = Double.valueOf(args[0]);
					p.setMaxHealth(i);
					p.sendMessage(ChatColor.GOLD+"Ahora tienes §e"+i+"§6 de vida.");
					return true;
				}
			}
			if (!Permisos.tiene(sender, "Darkers.staffSP")){
				sender.sendMessage(ChatColor.translateAlternateColorCodes('&', Bukkit.getPluginManager().getPlugin("Darkers").getConfig().getString("General.SinPermisos")));
				return true;
			}
		}
		if (!(sender instanceof Player)){
			sender.sendMessage(ChatColor.GREEN+"[Darkers] "+ChatColor.RED+"No utilizable desde la consola");
		}
		return false;
	}

}
