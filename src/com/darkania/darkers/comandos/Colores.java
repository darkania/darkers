package com.darkania.darkers.comandos;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import com.darkania.darkers.extras.Permisos;

public class Colores implements CommandExecutor {

	public void prMsg(CommandSender sender, String msg) {
		
	}

public boolean onCommand(CommandSender sender , Command cmd , String labbel , String [] args) {
		if (cmd.getName().equalsIgnoreCase("colores") && sender instanceof Player) {
			
	if (Permisos.tiene(sender, "Darkers.usuario")){
		Player pr = (Player) sender;
		pr.sendMessage(ChatColor.translateAlternateColorCodes('$', Bukkit.getPluginManager().getPlugin("Darkers").getConfig().getString("Colores.PrimeraLinea")));
		pr.sendMessage(ChatColor.translateAlternateColorCodes('$', Bukkit.getPluginManager().getPlugin("Darkers").getConfig().getString("Colores.SegundaLinea")));
		pr.sendMessage(ChatColor.translateAlternateColorCodes('$', Bukkit.getPluginManager().getPlugin("Darkers").getConfig().getString("Colores.TercerLinea")));
		pr.sendMessage(ChatColor.translateAlternateColorCodes('$', Bukkit.getPluginManager().getPlugin("Darkers").getConfig().getString("Colores.CuartaLinea")));
		pr.sendMessage(ChatColor.translateAlternateColorCodes('$', Bukkit.getPluginManager().getPlugin("Darkers").getConfig().getString("Colores.QuintaLinea")));
		pr.sendMessage(ChatColor.translateAlternateColorCodes('$', Bukkit.getPluginManager().getPlugin("Darkers").getConfig().getString("Colores.SextaLinea")));
		pr.sendMessage(ChatColor.translateAlternateColorCodes('$', Bukkit.getPluginManager().getPlugin("Darkers").getConfig().getString("Colores.SeptimaLinea")));
		pr.sendMessage(ChatColor.translateAlternateColorCodes('$', Bukkit.getPluginManager().getPlugin("Darkers").getConfig().getString("Colores.OctavaLinea")));
		pr.sendMessage(ChatColor.translateAlternateColorCodes('$', Bukkit.getPluginManager().getPlugin("Darkers").getConfig().getString("Colores.NovenaLinea")));
		pr.sendMessage(ChatColor.translateAlternateColorCodes('$', Bukkit.getPluginManager().getPlugin("Darkers").getConfig().getString("Colores.DecimaLinea")));
		pr.sendMessage(ChatColor.translateAlternateColorCodes('$', Bukkit.getPluginManager().getPlugin("Darkers").getConfig().getString("Colores.DecimaPrimeraLinea")));
		pr.sendMessage(ChatColor.translateAlternateColorCodes('$', Bukkit.getPluginManager().getPlugin("Darkers").getConfig().getString("Colores.DecimaSegundaLinea")));
		return true;
		}
	if (!Permisos.tiene(sender, "Darkers.usuario")){
		Player pr = (Player) sender;
		pr.sendMessage(ChatColor.translateAlternateColorCodes('&', Bukkit.getPluginManager().getPlugin("Darkers").getConfig().getString("General.SinPermisos")));
		return true;
	}
		}
		if (!(sender instanceof Player)){
		    ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
		    console.sendMessage(ChatColor.GREEN + "[Darkers] "+ChatColor.RED+"No utilizable desde la consola.");
		}
		return false;
	}
}
