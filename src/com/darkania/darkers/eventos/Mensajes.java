package com.darkania.darkers.eventos;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerLoginEvent.Result;
import org.bukkit.event.player.PlayerQuitEvent;
import com.darkania.darkers.Darkers;

public class Mensajes implements Listener{
	@EventHandler
	public void onPlayerLogin(PlayerLoginEvent event){
		Player p = event.getPlayer();
		if ("Si".equals(Darkers.getBaneados().getString(p.getName()+".Baneado"))){
			String Razon = Darkers.getBaneados().getString(p.getName()+".Razon");
			String cRazon = Bukkit.getPluginManager().getPlugin("Darkers").getConfig().getString("Baneos.Prefix");
			String Responsable = Darkers.getBaneados().getString(p.getName()+".Responsable");
		    cRazon = cRazon.replace("%motivo%", Razon).replace("%n%", "\n").replace("%responsable%", Responsable);
		    cRazon = ChatColor.translateAlternateColorCodes('&', cRazon);
		    event.disallow(Result.KICK_BANNED, cRazon);
		    
		}
	}
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event){
		Player p = (Player)event.getPlayer();
		Darkers.privado.add(p.getName());
		Darkers.publico.remove(p.getName());
		Darkers.ofertas.remove(p.getName());
		event.setJoinMessage("");
	}
	@EventHandler
	public void onPlayerQuit(PlayerQuitEvent event){
		Player p = event.getPlayer();
		Darkers.privado.remove(p.getName());
		Darkers.publico.remove(p.getName());
		Darkers.ofertas.remove(p.getName());
		String quit = Bukkit.getPluginManager().getPlugin("Darkers").getConfig().getString("Mensajes.Quit");
		event.setQuitMessage(quit.replaceAll("&", "§").replaceAll("%usuario%", p.getDisplayName()));
		
	}
}
