package com.darkania.darkers.comandos;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.darkania.darkers.Darkers;
import com.darkania.darkers.extras.Permisos;
import com.darkania.darkers.extras.YmlBaneados;

public class Unban implements CommandExecutor{
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		if (cmd.getName().equalsIgnoreCase("unban") && sender instanceof Player){
			if (Permisos.tiene(sender, "Darkers.staffSP")){
				if (args.length == 0){
					sender.sendMessage(ChatColor.RED+"Uso: /unban [Jugador]");
				}
				if (args.length >= 1){
					Player p = (Player)sender;
					Player desbaneado = org.bukkit.Bukkit.getPlayer(args[0]);
					if (!"Si".contains(Darkers.getBaneados().getString(desbaneado.getName()+".Baneado"))){
						p.sendMessage(ChatColor.RED+"El usuario "+desbaneado.getName()+" no esta baneado");
						return true;
					}
					if ("Si".contains(Darkers.getBaneados().getString(desbaneado.getName()+".Baneado"))){
						Darkers.getBaneados().set(desbaneado.getName(), "");
					    Darkers.getBaneados().set(desbaneado.getName()+".UltimaRazon", Darkers.getBaneados().getString(desbaneado.getName()+".Razon"));
					    Darkers.getBaneados().set(desbaneado.getName()+".Desbaneador", p.getName());
					    Darkers.getBaneados().set(desbaneado.getName()+".Baneado", "No");
						YmlBaneados.getInstance().saveBaneados();
						YmlBaneados.getInstance().reloadBaneados();
				    	p.sendMessage(ChatColor.RED+"Has desbaneado a "+desbaneado.getName());
				    	return true;
					}
					
				}
			}
			if (!Permisos.tiene(sender, "Darkers.staffSP")){
				sender.sendMessage(ChatColor.translateAlternateColorCodes('&', Bukkit.getPluginManager().getPlugin("Darkers").getConfig().getString("General.SinPermisos")));
			}
		}
		if (!(sender instanceof Player)){
			if (args.length == 0){
				sender.sendMessage(ChatColor.RED+"Uso: /unban [Jugador]");
			}
				String p = "Consola";
				String desbaneado = args[0];
				if (!"Si".contains(Darkers.getBaneados().getString(desbaneado+".Baneado"))){
					sender.sendMessage(ChatColor.RED+"El usuario "+desbaneado+" No esta baneado");
					return true;
				}
				if ("Si".contains(Darkers.getBaneados().getString(desbaneado+".Baneado"))){
				    Darkers.getBaneados().set(desbaneado+".UltimaRazon", Darkers.getBaneados().getString(desbaneado+".Razon"));
				    Darkers.getBaneados().set(desbaneado+".Desbaneador", p);
				    Darkers.getBaneados().set(desbaneado+".Baneado", "No");
					YmlBaneados.getInstance().saveBaneados();
					YmlBaneados.getInstance().reloadBaneados();
			    	sender.sendMessage(ChatColor.RED+"Has desbaneado a "+desbaneado);
			    	return true;
				}
		}
		return false;
	}

}
