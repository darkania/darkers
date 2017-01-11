package com.darkania.darkers.comandos;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import com.darkania.darkers.Darkers;
import com.darkania.darkers.extras.Permisos;

public class Vanish implements CommandExecutor{
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		if (cmd.getName().equalsIgnoreCase("vanish") && sender instanceof Player){
			Player p = (Player) sender;
			if (Permisos.tiene(p, "Darkers.staffSP")){
				if (Darkers.vanished.contains(p.getName())){
					Darkers.vanished.remove(p.getName());
					p.sendMessage(ChatColor.RED+"Te has desactivado el vanish");
					p.removePotionEffect(PotionEffectType.INVISIBILITY);
					for (Player usuario:Bukkit.getServer().getOnlinePlayers()){
						if (!Permisos.tiene(usuario, "Darkers.staff")){
							String join = Bukkit.getPluginManager().getPlugin("Darkers").getConfig().getString("Mensajes.Join.Usuario");
							usuario.sendMessage(join.replaceAll("&", "§").replaceAll("%usuario%", p.getDisplayName()));
							return true;
						}
						if (Permisos.tiene(usuario, "Darkers.staff")){
							usuario.sendMessage(ChatColor.AQUA+""+ChatColor.BOLD+p.getName()+" Se ha desactivado el vanish");
							return true;
						}
					}
					return true;
				}
				if (!Darkers.vanished.contains(p.getName())){
					Darkers.vanished.add(p.getName());
					p.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 10000000, 255, true));
					p.sendMessage(ChatColor.GOLD+"Te has ocultado de los usuarios");
					for (Player usuario:Bukkit.getServer().getOnlinePlayers()){
						if (!Permisos.tiene(usuario, "Darkers.staff")){
							usuario.hidePlayer(p);
							String quit = Bukkit.getPluginManager().getPlugin("Darkers").getConfig().getString("Mensajes.Quit");
							usuario.sendMessage(quit.replaceAll("&", "§").replaceAll("%usuario%", p.getDisplayName()));
							return true;
						}
						if (Permisos.tiene(usuario, "Darkers.staff")){
							usuario.sendMessage(ChatColor.AQUA+""+ChatColor.BOLD+p.getName()+" Se ha ocultado de los usuarios");
							return true;
						}
					}
					return true;
				}
			}
			if (!Permisos.tiene(p, "Darkers.staffSP")){
				p.sendMessage(ChatColor.translateAlternateColorCodes('&', Bukkit.getPluginManager().getPlugin("Darkers").getConfig().getString("General.SinPermisos")));
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
