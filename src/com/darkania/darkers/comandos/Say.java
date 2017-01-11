package com.darkania.darkers.comandos;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.darkania.darkers.extras.Permisos;

public class Say implements CommandExecutor{
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		if (cmd.getName().equalsIgnoreCase("say")){
			if (Permisos.tiene(sender, "Darkers.staff")){
				if (args.length == 0){
					sender.sendMessage(ChatColor.RED+"Uso correcto: /say [Mensaje]");
					return true;
				}
				String Mensaje = "";
				String[] arrayOfString;
				int j = (arrayOfString = args).length;
				for (int i = 0; i < j; i++){
					String s = arrayOfString[i];Mensaje = Mensaje + s + " ";
				}
				String consola = "Informacion";
				String usuario = (sender instanceof Player) ? ((Player)sender).getDisplayName() : consola;
				String color = Bukkit.getPluginManager().getPlugin("Darkers").getConfig().getString("Say.ColorDeMensaje");
				String prefix = Bukkit.getPluginManager().getPlugin("Darkers").getConfig().getString("Say.Prefix").replaceAll("%usuario%", usuario);
				String sonido = Bukkit.getPluginManager().getPlugin("Darkers").getConfig().getString("Say.Sonido");
				
				Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', prefix + ChatColor.RESET + " " + ChatColor.valueOf(color) + Mensaje + ChatColor.RESET));
				for(Player pr:Bukkit.getServer().getOnlinePlayers()){
					pr.playSound(pr.getLocation(), Sound.valueOf(sonido), 1.0F, 0.0F);
		    	}
				
				return true;
			}
			if (!Permisos.tiene(sender, "Darkers.say")){
				sender.sendMessage(ChatColor.translateAlternateColorCodes('&', Bukkit.getPluginManager().getPlugin("Darkers").getConfig().getString("General.SinPermisos")));
				return true;
			}
		}
		return false;
	}
}