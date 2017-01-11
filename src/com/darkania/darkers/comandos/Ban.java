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

public class Ban implements CommandExecutor{
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		if (cmd.getName().equalsIgnoreCase("ban") && sender instanceof Player){
			if (Permisos.tiene(sender, "Darkers.staffSP")){
				if (args.length <= 1){
					sender.sendMessage(ChatColor.RED+"Uso: /ban [Jugador] [Razón]");
				}
				if (args.length >= 2){
					Player p = (Player)sender;
					Player baneado = org.bukkit.Bukkit.getPlayer(args[0]);
					int veces = Darkers.getBaneados().getInt("Baneados."+baneado.getName()+".VecesBaneado");
					if (Permisos.tiene(baneado, "Darkers.Admin")){
						p.sendMessage(ChatColor.RED+"No puedes kickear a "+baneado.getName());
					}
					if (!Permisos.tiene(baneado, "Darkers.Admin")){
						String Razon = "";
					     for (int i = 1; i <= args.length - 1; i++) {
					       Razon = Razon + args[i] + " ";
					     }
					    veces = veces+1;
					    Darkers.getBaneados().set(baneado.getName()+".Razon", Razon);
					    Darkers.getBaneados().set(baneado.getName()+".Responsable", p.getName());
					    Darkers.getBaneados().set(baneado.getName()+".Baneado", "Si");
					    Darkers.getBaneados().set(baneado.getName()+".VecesBaneado", veces);
						YmlBaneados.getInstance().saveBaneados();
						YmlBaneados.getInstance().reloadBaneados();
					    String cRazon = Bukkit.getPluginManager().getPlugin("Darkers").getConfig().getString("Baneos.Prefix");
					    cRazon = cRazon.replace("%motivo%", Razon).replace("%n%", "\n").replace("%responsable%", p.getName());
					    cRazon = ChatColor.translateAlternateColorCodes('&', cRazon);
					    baneado.kickPlayer(cRazon);
				    	p.sendMessage(ChatColor.RED+"Has baneado a "+baneado.getName());
					}
				}
			}
			if (!Permisos.tiene(sender, "Darkers.staffSP")){
				sender.sendMessage(ChatColor.translateAlternateColorCodes('&', Bukkit.getPluginManager().getPlugin("Darkers").getConfig().getString("General.SinPermisos")));
			}
		}
		if (!(sender instanceof Player)){
			if (args.length <= 1){
				sender.sendMessage(ChatColor.RED+"Uso: /ban [Jugador] [Razón]");
			}
			if (args.length >= 2){
				String p = "Consola";
				Player baneado = org.bukkit.Bukkit.getPlayer(args[0]);
				int veces = Darkers.getBaneados().getInt("Baneados."+baneado.getName()+".VecesBaneado");
				String Razon = "";
			     for (int i = 1; i <= args.length - 1; i++) {
			       Razon = Razon + args[i] + " ";
			     }
			    Darkers.getBaneados().set(baneado.getName()+".Razon", Razon);
			    Darkers.getBaneados().set(baneado.getName()+".Responsable", p);
			    Darkers.getBaneados().set(baneado.getName()+".Baneado", "Si");
			    veces = veces + 1;
			    Darkers.getBaneados().set(baneado.getName()+".VecesBaneado", veces);
				YmlBaneados.getInstance().saveBaneados();
				YmlBaneados.getInstance().reloadBaneados();
			    String cRazon = Bukkit.getPluginManager().getPlugin("Darkers").getConfig().getString("Baneos.Prefix");
			    cRazon = cRazon.replace("%motivo%", Razon).replace("%n%", "\n").replace("%responsable%", p);
			    cRazon = ChatColor.translateAlternateColorCodes('&', cRazon);
			    baneado.kickPlayer(cRazon);
			   	sender.sendMessage(ChatColor.RED+"Has baneado a "+baneado.getName());
				
			}
		}
		return false;
	}

}
