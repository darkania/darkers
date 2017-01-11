package com.darkania.darkers.utilidades;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.ShapelessRecipe;

public class CrafteosMesa {
	
public static void iniciar() {
		
	    ShapelessRecipe grass = new ShapelessRecipe(new ItemStack(Material.GRASS, 1));
	    grass.addIngredient(1, Material.DIRT);
	    grass.addIngredient(1, Material.SEEDS);
	    Bukkit.getServer().addRecipe(grass);
		
	    ShapelessRecipe web = new ShapelessRecipe(new ItemStack(Material.WEB, 1));
	    web.addIngredient(3, Material.STRING);
	    Bukkit.getServer().addRecipe(web);
	    
	    ShapelessRecipe carne = new ShapelessRecipe(new ItemStack(Material.RAW_BEEF));
	    carne.addIngredient(1, Material.ROTTEN_FLESH);
	    carne.addIngredient(Material.SUGAR);
	    carne.addIngredient(Material.POTION);
	    Bukkit.getServer().addRecipe(carne);
		
	    ShapelessRecipe compacto = new ShapelessRecipe(new ItemStack(Material.PACKED_ICE, 1));
	    compacto.addIngredient(4, Material.ICE);
	    Bukkit.getServer().addRecipe(compacto);
		
	    ShapedRecipe hierro = new ShapedRecipe(new ItemStack(Material.IRON_BARDING, 1)).shape(new String[] { "  1", "121", "111" });
	    hierro.setIngredient('1', Material.IRON_INGOT);
	    hierro.setIngredient('2', Material.WOOL);
	    Bukkit.getServer().addRecipe(hierro);
		
	    ShapedRecipe oro = new ShapedRecipe(new ItemStack(Material.GOLD_BARDING, 1)).shape(new String[] { "  1", "121", "111" });
	    oro.setIngredient('1', Material.GOLD_INGOT);
	    oro.setIngredient('2', Material.WOOL);
	    Bukkit.getServer().addRecipe(oro);
		
	    ShapedRecipe diamante = new ShapedRecipe(new ItemStack(Material.DIAMOND_BARDING, 1)).shape(new String[] { "  1", "121", "111" });
	    diamante.setIngredient('1', Material.DIAMOND);
	    diamante.setIngredient('2', Material.WOOL);
	    Bukkit.getServer().addRecipe(diamante);
		
	    ShapedRecipe silla = new ShapedRecipe(new ItemStack(Material.SADDLE, 1)).shape(new String[] { "111", "121", "2 2" });
	    silla.setIngredient('1', Material.LEATHER);
	    silla.setIngredient('2', Material.IRON_INGOT);
	    Bukkit.getServer().addRecipe(silla);
	    
	    //DISCOS
	    
	    ShapedRecipe c13 = new ShapedRecipe(new ItemStack(Material.GOLD_RECORD, 1)).shape(new String[] { "111", "121", "111" });
	    c13.setIngredient('1', Material.OBSIDIAN);
	    c13.setIngredient('2', Material.GOLD_INGOT);
	    Bukkit.getServer().addRecipe(c13);
	    
	    ShapedRecipe cat = new ShapedRecipe(new ItemStack(Material.GREEN_RECORD, 1)).shape(new String[] { "111", "121", "111" });
	    cat.setIngredient('1', Material.OBSIDIAN);
	    cat.setIngredient('2', Material.CACTUS);
	    Bukkit.getServer().addRecipe(cat);
	    
	    ShapedRecipe blocks = new ShapedRecipe(new ItemStack(Material.RECORD_3, 1)).shape(new String[] { "111", "121", "111" });
	    blocks.setIngredient('1', Material.OBSIDIAN);
	    blocks.setIngredient('2', Material.PUMPKIN);
	    Bukkit.getServer().addRecipe(blocks);
	    
	    ShapedRecipe chirp = new ShapedRecipe(new ItemStack(Material.RECORD_4, 1)).shape(new String[] { "111", "121", "111" });
	    chirp.setIngredient('1', Material.OBSIDIAN);
	    chirp.setIngredient('2', Material.REDSTONE);
	    Bukkit.getServer().addRecipe(chirp);
	    
	    ShapedRecipe far = new ShapedRecipe(new ItemStack(Material.RECORD_5, 1)).shape(new String[] { "111", "121", "111" });
	    far.setIngredient('1', Material.OBSIDIAN);
	    far.setIngredient('2', Material.SLIME_BALL);
	    Bukkit.getServer().addRecipe(far);
	    
	    ShapedRecipe mall = new ShapedRecipe(new ItemStack(Material.RECORD_6, 1)).shape(new String[] { "111", "121", "111" });
	    mall.setIngredient('1', Material.OBSIDIAN);
	    mall.setIngredient('2', Material.MYCEL);
	    Bukkit.getServer().addRecipe(mall);
	    
	    ShapedRecipe mellohi = new ShapedRecipe(new ItemStack(Material.RECORD_7, 1)).shape(new String[] { "111", "111", "111" });
	    mellohi.setIngredient('1', Material.OBSIDIAN);
	    Bukkit.getServer().addRecipe(mellohi);
	    
	    ShapedRecipe stal = new ShapedRecipe(new ItemStack(Material.RECORD_8, 1)).shape(new String[] { "111", "121", "111" });
	    stal.setIngredient('1', Material.OBSIDIAN);
	    stal.setIngredient('2', Material.COAL);
	    Bukkit.getServer().addRecipe(stal);
	    
	    ShapedRecipe strad = new ShapedRecipe(new ItemStack(Material.RECORD_9, 1)).shape(new String[] { "111", "121", "111" });
	    strad.setIngredient('1', Material.OBSIDIAN);
	    strad.setIngredient('2', Material.QUARTZ);
	    Bukkit.getServer().addRecipe(strad);
	    
	    ShapedRecipe ward = new ShapedRecipe(new ItemStack(Material.RECORD_10, 1)).shape(new String[] { "111", "121", "111" });
	    ward.setIngredient('1', Material.OBSIDIAN);
	    ward.setIngredient('2', Material.WEB);
	    Bukkit.getServer().addRecipe(ward);
	    
	    ShapedRecipe c11 = new ShapedRecipe(new ItemStack(Material.RECORD_11, 1)).shape(new String[] { "111", "121", "111" });
	    c11.setIngredient('1', Material.OBSIDIAN);
	    c11.setIngredient('2', Material.NETHER_STAR);
	    Bukkit.getServer().addRecipe(c11);
	    
	    ShapedRecipe wait = new ShapedRecipe(new ItemStack(Material.RECORD_12, 1)).shape(new String[] { "111", "121", "111" });
	    wait.setIngredient('1', Material.OBSIDIAN);
	    wait.setIngredient('2', Material.DIAMOND);
	    Bukkit.getServer().addRecipe(wait);
	    
	}
}
