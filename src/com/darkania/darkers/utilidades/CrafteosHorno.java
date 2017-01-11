package com.darkania.darkers.utilidades;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.FurnaceRecipe;
import org.bukkit.inventory.ItemStack;

public class CrafteosHorno {
	
public static void iniciar() {
		
	    FurnaceRecipe beef = new FurnaceRecipe(new ItemStack(Material.COOKED_BEEF), Material.ROTTEN_FLESH);
	    Bukkit.getServer().addRecipe(beef);
	}
}
