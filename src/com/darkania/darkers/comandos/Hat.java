package com.darkania.darkers.comandos;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

import com.darkania.darkers.extras.Permisos;

public class Hat implements CommandExecutor{
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		if (cmd.getName().equalsIgnoreCase("hat") && sender instanceof Player){
			Player p = (Player) sender;
			if (Permisos.tiene(p, "Darkers.vip")){
				PlayerInventory inv = p.getInventory();
				@SuppressWarnings("deprecation")
				ItemStack hand = p.getItemInHand();
				if (inv.getHelmet() != null){
					inv.addItem(new ItemStack[] { inv.getHelmet() });
				}
				if ((hand == null || hand.getType() == Material.AIR)){
					p.sendMessage(ChatColor.RED+"No tienes ningun item para ponerte de sobrero");
					return true;
				}
				inv.setHelmet(hand);
				inv.remove(hand);
				p.sendMessage(ChatColor.GREEN+"Disfruta de tu nuevo sombrero.");
				return true;
			}
			if (!Permisos.tiene(p, "Darkers.vip")){
				p.sendMessage(ChatColor.translateAlternateColorCodes('&', Bukkit.getPluginManager().getPlugin("Darkers").getConfig().getString("General.SinPermisos")));
				return true;
			}
		}
		if (!(sender instanceof Player)){
			sender.sendMessage(ChatColor.GREEN + "[Darkers] "+ChatColor.RED+"No utilizable desde la consola.");
		}
		return false;
	}

}
