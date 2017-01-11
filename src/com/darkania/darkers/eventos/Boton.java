package com.darkania.darkers.eventos;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;

import net.md_5.bungee.api.ChatColor;

public class Boton implements Listener{
	@EventHandler
	public void click(PlayerInteractEvent event){
		Player p = event.getPlayer();
		if ((event.getAction().equals(Action.RIGHT_CLICK_BLOCK))){
			Material b = event.getClickedBlock().getType();
			if ((b == Material.STONE_BUTTON)){
				if (event.getClickedBlock().getLocation().getX()==51 && event.getClickedBlock().getLocation().getY()==51 && event.getClickedBlock().getLocation().getZ()==51){
					Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "say §6Pero que curioso eres "+p.getName()+" §6!!");
				}
			}
			if (b == Material.SIGN){
				if (event.getClickedBlock().getLocation().getX()==50 && event.getClickedBlock().getLocation().getY()==50 && event.getClickedBlock().getLocation().getZ()==50){
					ItemStack it = new ItemStack(Material.WRITTEN_BOOK);
					BookMeta book = (BookMeta)it.getItemMeta();
					book.setAuthor(ChatColor.DARK_GRAY+"Darkania");
					book.setTitle(ChatColor.DARK_GRAY+"Arco del Wither");
					for (String libro: Bukkit.getPluginManager().getPlugin("Darkers").getConfig().getStringList("Extras.Libro1")){
						libro.replaceAll("%usuario%", p.getDisplayName()).replaceAll("%n%", "\n");
						libro = ChatColor.translateAlternateColorCodes('&', libro);
						book.addPage(libro);
						it.setItemMeta(book);
					}
					p.getInventory().addItem(it);
					p.sendMessage("Libro entregado...");
				}
			}
		}
	}
}
