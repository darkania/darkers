package com.darkania.darkers.eventos;

import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Slime;
import org.bukkit.entity.Wolf;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import net.md_5.bungee.api.ChatColor;

public class CabezasDeMobs implements Listener{
	@EventHandler
	public void onEntityDeath(EntityDeathEvent event){
		Entity ent = (Entity)event.getEntity();
		if (ent instanceof Slime){
			ItemStack item = new ItemStack(Material.SKULL_ITEM, 1, (short)3);
			SkullMeta sm = (SkullMeta)item.getItemMeta();
			sm.setDisplayName(ChatColor.RESET+"Cabeza de Slime");
			sm.setOwner("MHF_Slime");
			item.setItemMeta(sm);
			event.getDrops().add(item);
		}
		if (ent instanceof Wolf){
			ItemStack item = new ItemStack(Material.SKULL_ITEM, 1, (short)3);
			SkullMeta sm = (SkullMeta)item.getItemMeta();
			sm.setDisplayName(ChatColor.RESET+"Cabeza de Lobo");
			sm.setOwner("MHF_Wolf");
			item.setItemMeta(sm);
			event.getDrops().add(item);
		}
	}
}
