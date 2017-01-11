package com.darkania.darkers.utilidades;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.event.Listener;

public class AutoReinicio implements Listener{
	public static boolean PrimerMsg(){
		int Intervalo = Bukkit.getServer().getPluginManager().getPlugin("Darkers").getConfig().getInt("AutoReinicio.T-MSG-1")*20;
		String comando = Bukkit.getServer().getPluginManager().getPlugin("Darkers").getConfig().getString("AutoReinicio.C-MSG-1");
		Bukkit.getScheduler().scheduleSyncDelayedTask(Bukkit.getServer().getPluginManager().getPlugin("Darkers"), new Runnable(){
			@Override 
			public void run (){
				Bukkit.dispatchCommand(Bukkit.getConsoleSender(), comando.replaceAll("&", "§"));
			}
		}, Intervalo);
		return true;
		
	}
	public static boolean SegundoMsg(){
		int Intervalo = Bukkit.getServer().getPluginManager().getPlugin("Darkers").getConfig().getInt("AutoReinicio.T-MSG-2")*20;
		String comando = Bukkit.getServer().getPluginManager().getPlugin("Darkers").getConfig().getString("AutoReinicio.C-MSG-2");
		Bukkit.getScheduler().scheduleSyncDelayedTask(Bukkit.getServer().getPluginManager().getPlugin("Darkers"), new Runnable(){
			@Override 
			public void run (){
				Bukkit.dispatchCommand(Bukkit.getConsoleSender(), comando.replaceAll("&", "§"));
			}
		}, Intervalo);
		return true;
		
	}
	public static boolean TercerMsg(){
		int Intervalo = Bukkit.getServer().getPluginManager().getPlugin("Darkers").getConfig().getInt("AutoReinicio.T-MSG-3")*20;
		String comando = Bukkit.getServer().getPluginManager().getPlugin("Darkers").getConfig().getString("AutoReinicio.C-MSG-3");
		Bukkit.getScheduler().scheduleSyncDelayedTask(Bukkit.getServer().getPluginManager().getPlugin("Darkers"), new Runnable(){
			@Override 
			public void run (){
				Bukkit.dispatchCommand(Bukkit.getConsoleSender(), comando.replaceAll("&", "§"));
			}
		}, Intervalo);
		return true;
		
	}
	public static boolean CuartoMsg(){
		int Intervalo = Bukkit.getServer().getPluginManager().getPlugin("Darkers").getConfig().getInt("AutoReinicio.T-MSG-4")*20;
		String comando = Bukkit.getServer().getPluginManager().getPlugin("Darkers").getConfig().getString("AutoReinicio.C-MSG-4");
		Bukkit.getScheduler().scheduleSyncDelayedTask(Bukkit.getServer().getPluginManager().getPlugin("Darkers"), new Runnable(){
			@Override 
			public void run (){
				Bukkit.dispatchCommand(Bukkit.getConsoleSender(), comando.replaceAll("&", "§"));
			}
		}, Intervalo);
		return true;
		
	}
	public static boolean Reinicio(){
		int Intervalo = Bukkit.getServer().getPluginManager().getPlugin("Darkers").getConfig().getInt("AutoReinicio.Intervalo")*20;
		Bukkit.getScheduler().scheduleSyncDelayedTask(Bukkit.getServer().getPluginManager().getPlugin("Darkers"), new Runnable(){
			@Override 
			public void run (){
				Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "say Guardando mundos...");
				for (World mundo : Bukkit.getWorlds()){
					mundo.save();
					Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "say Se guardo el mundo "+mundo.getName()+".");
					
				}
				Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "restart");
			}
		}, Intervalo);
		return true;
		
	}
}
