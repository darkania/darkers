package com.darkania.darkers.eventos;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

import com.darkania.darkers.extras.Permisos;

public class Alertas implements Listener{
	@EventHandler
	public void onBlockPlace(BlockPlaceEvent event){
		Player p = event.getPlayer();
		if (event.getBlockPlaced().getType() == Material.COMMAND){
			String coordenadas = Math.round(p.getLocation().getX() * 100.0D) / 100L + " " + Math.round(p.getLocation().getY() * 100.0D) / 100L + " " + Math.round(p.getLocation().getZ() * 100.0D) / 100L;
			for (Player staff:Bukkit.getServer().getOnlinePlayers()){
				if (Permisos.tiene(staff, "Darkers.staffSP")){
					String comando = "tellraw "+staff.getName()+" {'text':'§2[D]-->> §c"+p.getDisplayName()+" §2ha colocado §9BLOQUE DE COMANDOS §2en §6"+p.getWorld().getName()+"§3, §6','extra':[{'text':'" + coordenadas + "','color':'gold','clickEvent':{'action':'run_command','value':'/tppos " + coordenadas + "'},'hoverEvent':{'action':'show_text','value':'§6Pulsa para teletransportarte.'}}]}";
					Bukkit.dispatchCommand(Bukkit.getConsoleSender(), comando);
				}
			}
		}
		if (event.getBlockPlaced().getType() == Material.MOB_SPAWNER){
			String coordenadas = Math.round(p.getLocation().getX() * 100.0D) / 100L + " "+Math.round(p.getLocation().getY() * 100.0D) / 100L+" "+Math.round(p.getLocation().getZ() * 100.0D) / 100L;
			for (Player staff:Bukkit.getServer().getOnlinePlayers()){
				if (Permisos.tiene(staff, "Darkers.staffSP")){
					String comando = "tellraw "+staff.getName()+" {'text':'§2[D]-->> §c"+p.getDisplayName()+" §2ha colocado §9MOB SPAWNER §2en §6"+p.getWorld().getName()+"§3, §6','extra':[{'text':'" + coordenadas + "','color':'gold','clickEvent':{'action':'run_command','value':'/tppos " + coordenadas + "'},'hoverEvent':{'action':'show_text','value':'§6Pulsa para teletransportarte.'}}]}";
					Bukkit.dispatchCommand(Bukkit.getConsoleSender(), comando);
				}
			}
		}
		
	}
}

