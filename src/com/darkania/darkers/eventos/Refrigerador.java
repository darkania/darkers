package com.darkania.darkers.eventos;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.material.Door;

import com.darkania.darkers.Darkers;
import com.darkania.darkers.extras.YmlRefrigeradores;

public class Refrigerador implements Listener {
	@SuppressWarnings("deprecation")
@EventHandler
public void onPlayerInteract (PlayerInteractEvent event){
	if (event.getAction().equals(Action.RIGHT_CLICK_BLOCK)){
		if(event.getHand() == EquipmentSlot.OFF_HAND)return;
		Material P = event.getClickedBlock().getType();
		Player pl = event.getPlayer();
		if (P == Material.IRON_DOOR_BLOCK){
			Door Puerta = (Door) event.getClickedBlock().getState().getData();
			Block Block = event.getClickedBlock();
			byte Facing = event.getClickedBlock().getState().getData().getData();
			if (Puerta.isTopHalf()){
			Puerta = (Door)event.getClickedBlock().getRelative(0, -1, 0).getState().getData();
			Block = event.getClickedBlock().getRelative(0,-1,0);
			Darkers.getRefrigeradores().set("Refrigeradores."+pl.getName()+".Temporal.X", Block.getLocation().getBlockX());
			Darkers.getRefrigeradores().set("Refrigeradores."+pl.getName()+".Temporal.Y", Block.getLocation().getBlockY());
			Darkers.getRefrigeradores().set("Refrigeradores."+pl.getName()+".Temporal.Z", Block.getLocation().getBlockZ());
			YmlRefrigeradores.getInstance().saveRefrigeradores();
			YmlRefrigeradores.getInstance().reloadRefrigeradores();
			Facing = event.getClickedBlock().getRelative(0, -1, 0).getState().getData().getData();
			}
				Block AbajoPuerta = event.getClickedBlock().getRelative(0, -1, 0);
				Location LocEste = new Location(AbajoPuerta.getWorld(), AbajoPuerta.getLocation().getX()+1.5,
						AbajoPuerta.getLocation().getY(), AbajoPuerta.getLocation().getZ(), pl.getLocation().getYaw(), pl.getLocation().getPitch());
				Location LocSur = new Location(AbajoPuerta.getWorld(), AbajoPuerta.getLocation().getX(),
						AbajoPuerta.getLocation().getY(), AbajoPuerta.getLocation().getZ()+1.5, pl.getLocation().getYaw(), pl.getLocation().getPitch());
				Location LocOeste = new Location(AbajoPuerta.getWorld(), AbajoPuerta.getLocation().getX()-1.5,
						AbajoPuerta.getLocation().getY(), AbajoPuerta.getLocation().getZ(), pl.getLocation().getYaw(), pl.getLocation().getPitch());
				Location LocNorte = new Location(AbajoPuerta.getWorld(), AbajoPuerta.getLocation().getX(),
						AbajoPuerta.getLocation().getY(), AbajoPuerta.getLocation().getZ()-1.5, pl.getLocation().getYaw(), pl.getLocation().getPitch());
				
				if (Facing == 0){
					//Este
				if (event.getClickedBlock().getRelative(-2,0,0).getType() == Material.IRON_DOOR_BLOCK){
						pl.sendMessage(ChatColor.RED+"Hay una puerta detrás del refrigerador que causa conflicto. ¡Tienes que quitarla!");
				}
				else if (!(event.getClickedBlock().getRelative(-2,0,0).getType() == Material.IRON_DOOR_BLOCK)){					
					if ((event.getClickedBlock().getRelative(-1, 0, 0).getType() == Material.QUARTZ_BLOCK) && (
							event.getClickedBlock().getRelative(-1, -1, 0).getType() == Material.QUARTZ_BLOCK)){
						if((pl.getLocation().getBlockX() == AbajoPuerta.getLocation().getBlockX()) && (
								pl.getLocation().getBlockY() == AbajoPuerta.getLocation().getBlockY()) && (
										pl.getLocation().getBlockZ() == AbajoPuerta.getLocation().getBlockZ())){
							
							pl.teleport(LocEste);
						}
						AbrirRefrigerador(pl);
						if(!isOpen(Puerta)){
							openDoor(Block ,Puerta ,pl );
							}
						if(isOpen(Puerta)){
							closeDoor(Block ,Puerta ,pl );
							}
					}
				}
				}
				
				if (Facing == 1){
					//Sur
				if (event.getClickedBlock().getRelative(0,0,-2).getType() == Material.IRON_DOOR_BLOCK){
						pl.sendMessage(ChatColor.RED+"Hay una puerta detrás del refrigerador que causa conflicto. ¡Tienes que quitarla!");
				}
				else if (!(event.getClickedBlock().getRelative(0,0,-2).getType() == Material.IRON_DOOR_BLOCK)){							
					if ((event.getClickedBlock().getRelative(0, 0, -1).getType() == Material.QUARTZ_BLOCK) && (
							event.getClickedBlock().getRelative(0, -1, -1).getType() == Material.QUARTZ_BLOCK)){
						if((pl.getLocation().getBlockX() == AbajoPuerta.getLocation().getBlockX()) && (
								pl.getLocation().getBlockY() == AbajoPuerta.getLocation().getBlockY()) && (
										pl.getLocation().getBlockZ() == AbajoPuerta.getLocation().getBlockZ())){
							
							pl.teleport(LocSur);
						}
						AbrirRefrigerador(pl);
						if(!isOpen(Puerta)){
							openDoor(Block ,Puerta ,pl );
							}
						if(isOpen(Puerta)){
							closeDoor(Block ,Puerta ,pl );
							}
					}
					}
				}
				
				if (Facing == 2){
					//Oeste
				if (event.getClickedBlock().getRelative(+2,0,0).getType() == Material.IRON_DOOR_BLOCK){
						pl.sendMessage(ChatColor.RED+"Hay una puerta detrás del refrigerador que causa conflicto. ¡Tienes que quitarla!");
				}
				else if (!(event.getClickedBlock().getRelative(+2,0,0).getType() == Material.IRON_DOOR_BLOCK)){
					if ((event.getClickedBlock().getRelative(+1,0, 0).getType() == Material.QUARTZ_BLOCK) && (
							event.getClickedBlock().getRelative(+1, -1, 0).getType() == Material.QUARTZ_BLOCK)){					
						if((pl.getLocation().getBlockX() == AbajoPuerta.getLocation().getBlockX()) && (
								pl.getLocation().getBlockY() == AbajoPuerta.getLocation().getBlockY()) && (
										pl.getLocation().getBlockZ() == AbajoPuerta.getLocation().getBlockZ())){
							
							pl.teleport(LocOeste);
						}
						AbrirRefrigerador(pl);
						if(!isOpen(Puerta)){
							openDoor(Block ,Puerta ,pl );
							}
						if(isOpen(Puerta)){
							closeDoor(Block ,Puerta ,pl );
							}
					}	
				}
				}
				
				if (Facing == 3){
					//Norte
				if (event.getClickedBlock().getRelative(0,0,+2).getType() == Material.IRON_DOOR_BLOCK){
						pl.sendMessage(ChatColor.RED+"Hay una puerta detrás del refrigerador que causa conflicto. ¡Tienes que quitarla!");
				}
				else if (!(event.getClickedBlock().getRelative(0,0,+2).getType() == Material.IRON_DOOR_BLOCK)){
					if ((event.getClickedBlock().getRelative(0, 0, +1).getType() == Material.QUARTZ_BLOCK) && (
							event.getClickedBlock().getRelative(0, -1, +1).getType() == Material.QUARTZ_BLOCK)){					
						if((pl.getLocation().getBlockX() == AbajoPuerta.getLocation().getBlockX()) && (
								pl.getLocation().getBlockY() == AbajoPuerta.getLocation().getBlockY()) && (
										pl.getLocation().getBlockZ() == AbajoPuerta.getLocation().getBlockZ())){
							
							pl.teleport(LocNorte);
						}
						AbrirRefrigerador(pl);
						if(!isOpen(Puerta)){
							openDoor(Block ,Puerta ,pl );
							}
						if(isOpen(Puerta)){
							closeDoor(Block ,Puerta ,pl );
							}
					}
				}
				}
				
			
		}
	}
}
	@EventHandler
	public void onInventoryClose(InventoryCloseEvent event){
		Player p = (Player) event.getPlayer();
		if ((p != null) && (event.getInventory() != null) && (event.getInventory().getTitle() != null)) {
		if (event.getInventory().getTitle().equals(ChatColor.AQUA+"-------Refrigerador-------")){
			if (Darkers.getRefrigeradores().getString("Refrigeradores."+p.getName())== null)return;
			Door Puerta = (Door)Bukkit.getWorld(p.getWorld().getName()).getBlockAt(
					Darkers.getRefrigeradores().getInt("Refrigeradores."+p.getName()+".Temporal.X"), 
					Darkers.getRefrigeradores().getInt("Refrigeradores."+p.getName()+".Temporal.Y"),
					Darkers.getRefrigeradores().getInt("Refrigeradores."+p.getName()+".Temporal.Z")).getState().getData();
			
			Block Block = (org.bukkit.block.Block) Bukkit.getWorld(p.getWorld().getName()).getBlockAt(
					Darkers.getRefrigeradores().getInt("Refrigeradores."+p.getName()+".Temporal.X"), 
					Darkers.getRefrigeradores().getInt("Refrigeradores."+p.getName()+".Temporal.Y"),
					Darkers.getRefrigeradores().getInt("Refrigeradores."+p.getName()+".Temporal.Z"));
			if(!isOpen(Puerta)){
				openDoor(Block ,Puerta ,p);
				}
			if(isOpen(Puerta)){
				closeDoor(Block ,Puerta ,p);
				}
			
			for (ItemStack I : event.getInventory().getContents()){
				p.sendMessage(""+I);
				if (I==null){
					Darkers.getRefrigeradores().set("Refrigeradores."+p.getName()+".Temporal", null);
					YmlRefrigeradores.getInstance().saveRefrigeradores();
					YmlRefrigeradores.getInstance().reloadRefrigeradores();
					return;
				}
			}
			int Numeroderefrigerador = Darkers.getRefrigeradores().getInt("Refrigeradores."+p.getName()+".Refrigeradores");
			Darkers.getRefrigeradores().set("Refrigeradores."+p.getName()+".Numero"+Numeroderefrigerador+".X", Darkers.getRefrigeradores().getInt("Refrigeradores."+p.getName()+".Temporal.X"));
			Darkers.getRefrigeradores().set("Refrigeradores."+p.getName()+".Numero"+Numeroderefrigerador+".Y", Darkers.getRefrigeradores().getInt("Refrigeradores."+p.getName()+".Temporal.Y"));
			Darkers.getRefrigeradores().set("Refrigeradores."+p.getName()+".Numero"+Numeroderefrigerador+".Z", Darkers.getRefrigeradores().getInt("Refrigeradores."+p.getName()+".Temporal.Z"));
			Darkers.getRefrigeradores().set("Refrigeradores."+p.getName()+".Refrigeradores", Numeroderefrigerador+1);
			Darkers.getRefrigeradores().set("Refrigeradores."+p.getName()+".Numero"+Numeroderefrigerador+".Items", event.getInventory().getContents());
			Darkers.getRefrigeradores().set("Refrigeradores."+p.getName()+".Temporal", null);
			YmlRefrigeradores.getInstance().saveRefrigeradores();
			YmlRefrigeradores.getInstance().reloadRefrigeradores();
			p.sendMessage("Items guardados");
		}
	}
	}
	public void AbrirRefrigerador(Player p){
		p.closeInventory();
		Inventory i = Bukkit.getServer().createInventory(p, 27, ChatColor.AQUA+"-------Refrigerador-------");
		p.openInventory(i);
	}
	@SuppressWarnings("deprecation")
	public boolean isOpen(Door puerta)
	{
		if(puerta.getData()>3)return true;
		else return false;
	}

	@SuppressWarnings("deprecation")
	public void openDoor(Block block, Door puerta, Player p)
	{
		if(puerta.getData()<4)
		{
			block.setData((byte) (puerta.getData()+4));
			p.playSound(p.getLocation(), Sound.valueOf("BLOCK_IRON_DOOR_OPEN"), 2.0F, 0.0F);
		}
	
	}

	@SuppressWarnings("deprecation")
	public void closeDoor(Block block, Door puerta, Player p)
	{
		if(puerta.getData()>=4)
		{
			block.setData((byte)(puerta.getData()-4));
			p.playSound(p.getLocation(), Sound.valueOf("BLOCK_IRON_DOOR_CLOSE"), 2.0F, 0.0F);
		}
	}
}
