package com.darkania.darkers.eventos;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.material.Door;

public class Refrigerador2 implements Listener {
	boolean EventFixed = false;
	@EventHandler
	public void onPlayerInteract (PlayerInteractEvent event){
		if (event.getAction().equals(Action.RIGHT_CLICK_BLOCK)){
			if(event.getHand() == EquipmentSlot.OFF_HAND)return;
			Material P = event.getClickedBlock().getType();
			Player pl = event.getPlayer();
			if (P==Material.IRON_DOOR_BLOCK){
				Door Puerta = (Door) event.getClickedBlock().getState().getData();
				Block block = event.getClickedBlock();
				if(Puerta.isTopHalf()){
					Puerta= (Door)event.getClickedBlock().getRelative(0,-1,0).getState().getData();
					block = event.getClickedBlock().getRelative(0,-1,0);
				}	
				if(!isOpen(Puerta)){
					openDoor(block,Puerta,pl);
					}
				if(isOpen(Puerta)){
					closeDoor(block,Puerta,pl);
					}
			}
		}
	}

	@SuppressWarnings("deprecation")
	public boolean isOpen(Door puerta)
	{
		if(puerta.getData()>4)return true;
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
		if(puerta.getData()>4)
		{
			block.setData((byte)(puerta.getData()-4));
			p.playSound(p.getLocation(), Sound.valueOf("BLOCK_IRON_DOOR_CLOSE"), 2.0F, 0.0F);
		}
	}

}
