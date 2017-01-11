package com.darkania.darkers.comandos;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import com.darkania.darkers.extras.Permisos;


public class Renombrar implements CommandExecutor{
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		if (cmd.getName().equalsIgnoreCase("renombrar") && sender instanceof Player){
			Player p = (Player) sender;
			if (Permisos.tiene(p, "Darkers.staff")){
				if (args.length == 0){
					p.sendMessage(ChatColor.RED+"Uso: /renombrar [Nombre]");
					return true;
				}
				@SuppressWarnings("deprecation")
				ItemStack item = p.getItemInHand();
				if ((item.getType() == Material.AIR) || (item == null)){
					p.sendMessage(ChatColor.RED+"Necesitas tener seleccionado un item");
					return true;
				}
				ItemMeta Item = item.getItemMeta();
				
				 String Nombre = "";
			      for (int i = 0; i <= args.length - 1; i++)
			      {
			        Nombre = Nombre + args[i] + "";
			      }
			      Nombre = ChatColor.translateAlternateColorCodes('&', Nombre);
				Item.setDisplayName(Nombre);
				item.setItemMeta(Item);
				List<String> lore = new ArrayList<String>();
				lore.add(ChatColor.GREEN+"Propiedad de "+p.getName());
				Item.setLore(lore);
				item.setItemMeta(Item);
				sender.sendMessage(ChatColor.GOLD+"¡Item renombrado con exito!");
			}
			if (!Permisos.tiene(p, "Darkers.staff")){
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
