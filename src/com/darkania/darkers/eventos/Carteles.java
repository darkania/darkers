package com.darkania.darkers.eventos;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.SignChangeEvent;

import com.darkania.darkers.extras.Permisos;

public class Carteles implements Listener{
	
	@EventHandler
	public void onSignChange(SignChangeEvent event){
		Player p = event.getPlayer();
		if (!Permisos.tiene(p, "Darkers.vip")){
			return;
		}
		if (Permisos.tiene(p, "Darkers.vip")){
			for (int i = 0; i <= 3; i++){
				String linea = event.getLine(i);
				linea = ChatColor.translateAlternateColorCodes('&', linea);
				event.setLine(i, linea);
			}
		}
	}

}
