package com.darkania.darkers.comandos;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.darkania.darkers.Darkers;

public class Publico implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		if (cmd.getName().equalsIgnoreCase("publico") && sender instanceof Player){
			Player p = (Player) sender;
			if (Darkers.publico.contains(p.getName())){
				p.sendMessage(ChatColor.RED+"Actualmente estas en privado.");
				return true;
			}
			if (!Darkers.publico.contains(p.getName())){
				Darkers.publico.add(p.getName());
				Darkers.privado.remove(p.getName());
				Darkers.ofertas.remove(p.getName());
				p.sendMessage(ChatColor.DARK_GREEN+"Has entrado al modo de chat §aPublico");
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
