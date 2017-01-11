package com.darkania.darkers.comandos;

import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_11_R1.entity.CraftHorse;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import net.minecraft.server.v1_11_R1.EntityHorse;


public class Relinchar implements CommandExecutor{

	public boolean onCommand(CommandSender sender, Command cmd, String labbel, String[] args) {
		if(cmd.getName().equalsIgnoreCase("relinchar") && sender instanceof Player){
			
			Player p = (Player)sender;
			List<Entity> ent = p.getNearbyEntities(10, 10, 10);
			for(Entity ent2:ent){
			if(ent2.getType().equals(EntityType.HORSE) && ent2.getCustomName().equals("CPrueba")){
			EntityHorse CB = ((CraftHorse)ent2).getHandle();
			CB.setStanding(true);    
			p.sendMessage("Tu ip es: "+p.getAddress().getHostName());
			}
			}
			
			

		}
		return false;
	}
	

}
