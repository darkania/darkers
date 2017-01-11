package com.darkania.darkers.utilidades;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.event.Listener;

public class AutoGuardarMundos implements Listener{
	public static boolean IniciarAutoGuardado(){
		int Intervalo = Bukkit.getServer().getPluginManager().getPlugin("Darkers").getConfig().getInt("AutoGuardado.Intervalo") * 1200;
		Bukkit.getScheduler().scheduleSyncRepeatingTask(Bukkit.getServer().getPluginManager().getPlugin("Darkers"), new Runnable(){
			@Override
			public void run (){
				Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "say Guardando mundos...");
				for (World mundo : Bukkit.getWorlds()){
					mundo.save();
				}
				Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "say Mundos guardados");
			}
		}, Intervalo, Intervalo);
		return true;
	}
}
