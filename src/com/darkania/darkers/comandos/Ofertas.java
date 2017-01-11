package com.darkania.darkers.comandos;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.darkania.darkers.Darkers;

public class Ofertas implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		if (cmd.getName().equalsIgnoreCase("ofertas") && sender instanceof Player){
			Player p = (Player) sender;
			if (Darkers.ofertas.contains(p.getName())){
				p.sendMessage(ChatColor.RED+"Actualmente estas en ofertas.");
				return true;
			}
			if (!Darkers.ofertas.contains(p.getName())){
				Darkers.ofertas.add(p.getName());
				Darkers.publico.remove(p.getName());
				Darkers.privado.remove(p.getName());
				p.sendMessage(ChatColor.DARK_GREEN+"Has entrado al modo de chat §2Ofertas");
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
