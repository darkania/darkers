package com.darkania.darkers.comandos;

import com.darkania.darkers.Darkers;
import com.darkania.darkers.extras.Permisos;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class HelpOp implements org.bukkit.command.CommandExecutor {
	public boolean onCommand(CommandSender sender, Command cmd, String labbel, String[] args){
		if((cmd.getName().equalsIgnoreCase("helpop") && sender instanceof Player)){
			if (args.length == 0){
				sender.sendMessage(ChatColor.RED+"Uso: /helpop [Mensaje de Ayuda/Duda/Problema]");
				return true;
			}
			if ("msg".equalsIgnoreCase(args[0])){
				sender.sendMessage(ChatColor.RED+"No ponga como duda o problema 'msg'.");
				sender.sendMessage(ChatColor.RED+"Uso: /helpop [Mensaje de Ayuda/Duda/Problema]");
				return true;
			}
			if ("ayuda".equalsIgnoreCase(args[0])){
				sender.sendMessage(ChatColor.RED+"No ponga como duda o problema 'ayuda'.");
				sender.sendMessage(ChatColor.RED+"Uso: /helpop [Mensaje de Ayuda/Duda/Problema]");
				return true;
			}
			if ("problema".equalsIgnoreCase(args[0])){
				sender.sendMessage(ChatColor.RED+"No ponga como duda o problema 'problema'.");
				sender.sendMessage(ChatColor.RED+"Uso: /helpop [Mensaje de Ayuda/Duda/Problema");
				return true;
			}
			if ("duda".equalsIgnoreCase(args[0])){
				sender.sendMessage(ChatColor.RED+"No ponga como duda o problema 'duda'.");
				sender.sendMessage(ChatColor.RED+"Uso: /helpop [Mensaje de Ayuda/Duda/Problema");
				return true;
			}
			if("hola".equalsIgnoreCase(args[0])){
				sender.sendMessage(ChatColor.RED+"No ponga como duda o problema 'hola'.");
				sender.sendMessage(ChatColor.RED+"Uso: /helpop [Mensaje de Ayuda/Duda/Problema");
				return true;
			}
			StringBuilder chatMessage = new StringBuilder();
			for (int i = 0; i < args.length; i++) chatMessage.append(args[i]).append(" ");
			String usuario = (sender instanceof Player) ? ((Player)sender).getDisplayName() : "Consola";
			if ((sender instanceof ConsoleCommandSender)) {
				sender.sendMessage("§4[HelpOp] §6" + usuario + "§6: §d" + chatMessage.toString());
				
				for(Player pr:Bukkit.getServer().getOnlinePlayers()){
					if (Permisos.tiene(pr, "Darkers.staff")) {
						pr.sendMessage("§4[HelpOp] §6" + usuario + "§6: §d" + chatMessage.toString());
					}
				}
				return true;
			}
			ConsoleCommandSender c = Bukkit.getServer().getConsoleSender();
			c.sendMessage("§4[HelpOp] §6" + usuario + "§6: §d" + chatMessage.toString());
			int hay = 0;
			
			for(Player pr:Bukkit.getServer().getOnlinePlayers()){
				if (Permisos.tiene(pr, "Darkers.staff")) {
					if (!Darkers.vanished.contains(pr.getName())){
						hay++;
						pr.sendMessage("§4[HelpOp] §6" + usuario + "§6: §d" + chatMessage.toString());
						pr.playSound(pr.getLocation(), org.bukkit.Sound.ENTITY_ENDERDRAGON_SHOOT, 1.0F, 0.0F);
					}
					if (Darkers.vanished.contains(pr.getName())){
						pr.sendMessage("§4[HelpOp] §6" + usuario + "§6: §d" + chatMessage.toString());	
					}
				}
			}
			sender.sendMessage("§aMensaje enviado: §f" + chatMessage.toString());
			if (hay == 0) sender.sendMessage("§cNo hay staff online, su mensaje esta enviandose al foro...");
			return true;
		}
		if (!(sender instanceof Player)){
			ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
		    console.sendMessage(ChatColor.GREEN + "[Darkers] "+ChatColor.RED+"No utilizable desde la consola.");
		}
		return true;
	}
}
