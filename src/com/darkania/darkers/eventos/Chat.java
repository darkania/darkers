package com.darkania.darkers.eventos;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import com.darkania.darkers.Darkers;
import com.darkania.darkers.extras.Permisos;

public class Chat implements Listener{
	@EventHandler
	public void onPlayerChat(AsyncPlayerChatEvent event){
		Player p = event.getPlayer();
		if (Darkers.muteado.contains(p.getName())){
			p.sendMessage(ChatColor.RED+"Has sido muteado.");
			return;
		}
		if (Darkers.publico.contains(p.getName())){
			if (!Permisos.tiene(p, "Darkers.vip")){
				String Formato = Bukkit.getPluginManager().getPlugin("Darkers").getConfig().getString("Chat.FormatoPublico").replace('&', '§');
				Formato = Formato.replaceAll("%usuario%", p.getDisplayName());
				Formato = Formato.replaceAll("%mensaje%", event.getMessage());
				Bukkit.broadcastMessage(Formato);	
			}
			if (Permisos.tiene(p, "Darkers.vip")){
				String Formato = Bukkit.getPluginManager().getPlugin("Darkers").getConfig().getString("Chat.FormatoPublico").replace('&', '§');
				Formato = Formato.replaceAll("%usuario%", p.getDisplayName());
				Formato = Formato.replaceAll("%mensaje%", event.getMessage().replace('&', '§'));
				Bukkit.broadcastMessage(Formato);
			}
		}
		if (Darkers.ofertas.contains(p.getName())){
			if (!Permisos.tiene(p, "Darkers.vip")){
				String Formato = Bukkit.getPluginManager().getPlugin("Darkers").getConfig().getString("Chat.FormatoOfertas").replace('&', '§');
				Formato = Formato.replaceAll("%usuario%", p.getDisplayName());
				Formato = Formato.replaceAll("%mensaje%", event.getMessage());
				Bukkit.broadcastMessage(Formato);	
			}
			if (Permisos.tiene(p, "Darkers.vip")){
				String Formato = Bukkit.getPluginManager().getPlugin("Darkers").getConfig().getString("Chat.FormatoOfertas").replace('&', '§');
				Formato = Formato.replaceAll("%usuario%", p.getDisplayName());
				Formato = Formato.replaceAll("%mensaje%", event.getMessage().replace('&', '§'));
				Bukkit.broadcastMessage(Formato);	
			}
		}
		if (Darkers.privado.contains(p.getName())){
		      if (!Permisos.tiene(p, "Darkers.vip")){
			        String Formato = Bukkit.getPluginManager().getPlugin("Darkers").getConfig().getString("Chat.FormatoPrivado").replace('&', '§');
			        Formato = Formato.replaceAll("%usuario%", p.getDisplayName());
			        Formato = Formato.replaceAll("%mensaje%", event.getMessage());
			        for (Entity cp : p.getNearbyEntities(50.0D, 50.0D, 50.0D)) {
			          if ((cp instanceof Player)) {
			            cp.sendMessage(Formato);
			            p.sendMessage(Formato);
			          }
			        }
			      }
			      if (Permisos.tiene(p, "Darkers.vip")){
			        String Formato = Bukkit.getPluginManager().getPlugin("Darkers").getConfig().getString("Chat.FormatoPrivado").replace('&', '§');
			        Formato = Formato.replaceAll("%usuario%", p.getDisplayName());
			        Formato = Formato.replaceAll("%mensaje%", event.getMessage().replace('&', '§'));
			        for (Entity cp : p.getNearbyEntities(50.0D, 50.0D, 50.0D)){
			          if ((cp instanceof Player)){
			            cp.sendMessage(Formato);
			            p.sendMessage(Formato);
			          }
			        }
			      }
	}
		if (!Darkers.privado.contains(p.getName()) && !Darkers.publico.contains(p.getName()) && !Darkers.ofertas.contains(p.getName())){
			p.sendMessage(ChatColor.RED+"Ha ocurrido un error, intenta otra vez...");
			Darkers.privado.add(p.getName());
			Darkers.publico.remove(p.getName());
			Darkers.ofertas.remove(p.getName());
			return;
		}
		event.setCancelled(true);
	}

}
