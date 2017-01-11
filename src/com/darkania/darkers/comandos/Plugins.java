package com.darkania.darkers.comandos;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.darkania.darkers.extras.Permisos;

public class Plugins implements CommandExecutor{
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		if (cmd.getName().equalsIgnoreCase("plugins")){
			Player p = (Player) sender; 
			if (!Permisos.tiene(p, "Darkers.staffSP")){
				sender.sendMessage(ChatColor.DARK_AQUA+""+ChatColor.BOLD+"Buen intento "+p.getDisplayName());
				return true;
			}
			if (Permisos.tiene(p, "Darkers.staffSP")){
				p.sendMessage(ChatColor.GREEN+"------[Darkania]-[Plugins]------");
				p.sendMessage("§aDarkers§f, §aLogin§f, §aPermissionsEx§f, §aSteveHouse§f, §aLibsDisguises§f, §aProtocolLib§f, §aSimpleClans§f, §aWorldEdit§f.");
				return true;
			}
		}
		return false;
	}

}
