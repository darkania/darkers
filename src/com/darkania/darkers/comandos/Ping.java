package com.darkania.darkers.comandos;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_11_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class Ping implements CommandExecutor{
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		if (cmd.getName().equalsIgnoreCase("ping") && sender instanceof Player){
				if (args.length == 0){
					Player p = (Player)sender;
					int Ping = ((CraftPlayer)p).getHandle().ping;
					p.sendMessage(ChatColor.AQUA+"Ping: "+Ping+"ms");
				}
				if (args.length == 1){
					Player p = Bukkit.getServer().getPlayer(args[0]);
					if (p == null){
						sender.sendMessage(ChatColor.RED+"No se ha encontrado el usuario "+args[0]);
					}
					int Ping = ((CraftPlayer)p).getHandle().ping;
					p.sendMessage(ChatColor.GREEN+"Ping de "+p.getName()+": "+Ping+"ms");
				}
		}
		return false;
		
	}

}
