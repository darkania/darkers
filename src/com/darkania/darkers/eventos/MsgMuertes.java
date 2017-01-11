package com.darkania.darkers.eventos;

import org.bukkit.Bukkit;
import org.bukkit.entity.Blaze;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.EnderDragon;
import org.bukkit.entity.Enderman;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Ghast;
import org.bukkit.entity.IronGolem;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.MagmaCube;
import org.bukkit.entity.PigZombie;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.entity.Silverfish;
import org.bukkit.entity.Skeleton;
import org.bukkit.entity.Slime;
import org.bukkit.entity.Spider;
import org.bukkit.entity.Witch;
import org.bukkit.entity.Wolf;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.PlayerDeathEvent;

import net.md_5.bungee.api.ChatColor;

public class MsgMuertes implements Listener{
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onPlayerDeath(EntityDeathEvent event){
		if (((event.getEntity() instanceof Player)) && (event.getEntity().getKiller() == null)){
			Player p = (Player)event.getEntity();
			EntityDamageEvent lastDamage = p.getLastDamageCause();
			
			if (!(lastDamage instanceof EntityDamageByEntityEvent)){
				return;
			}
			EntityDamageByEntityEvent damageEvent = (EntityDamageByEntityEvent)lastDamage;
			Entity killer = damageEvent.getDamager();
			EntityDamageEvent.DamageCause causa = lastDamage.getCause();
			String msg = "";
			if (lastDamage.getCause().equals(EntityDamageEvent.DamageCause.PROJECTILE)){
				Projectile pe = (Projectile)killer;
				if ((pe.getShooter() instanceof LivingEntity)){
					LivingEntity le = (LivingEntity)pe.getShooter();
					if (le instanceof Blaze){
						msg = Bukkit.getPluginManager().getPlugin("Darkers").getConfig().getString("MensajesAlMorir.DisparoDeBlaze").replaceAll("%usuario%", p.getDisplayName());
					}
					if (le instanceof Skeleton){
						msg = Bukkit.getPluginManager().getPlugin("Darkers").getConfig().getString("MensajesAlMorir.DisparoDeEsqueleto").replaceAll("%usuario%", p.getDisplayName());
					}
					if (le instanceof Ghast){
						msg = Bukkit.getPluginManager().getPlugin("Darkers").getConfig().getString("MensajesAlMorir.DisparoDeGhast").replaceAll("%usuario%", p.getDisplayName());
					}
				}
			}
			if (causa == EntityDamageEvent.DamageCause.BLOCK_EXPLOSION){
				//PONER LA CAUSA XD
			}
		    if (causa == EntityDamageEvent.DamageCause.DROWNING) {
		          
		    }
		    if (causa == EntityDamageEvent.DamageCause.FALL) {
		          
		    }
		    if (causa == EntityDamageEvent.DamageCause.CUSTOM) {
		          
		    }
		    if (causa == EntityDamageEvent.DamageCause.FALLING_BLOCK) {
		          
		    }
		    if (causa == EntityDamageEvent.DamageCause.FIRE) {
		          
	        }
		    if (causa == EntityDamageEvent.DamageCause.FIRE_TICK) {
		          
		    }
		    if (causa == EntityDamageEvent.DamageCause.LAVA) {
		          
		    }
		    if (causa == EntityDamageEvent.DamageCause.LIGHTNING) {
		          
		    }
		    if (causa == EntityDamageEvent.DamageCause.MAGIC) {
		          
		    }
		    if (causa == EntityDamageEvent.DamageCause.MELTING) {
		          
		    }
		    if (causa == EntityDamageEvent.DamageCause.POISON) {
		          
		    }
		    if (causa == EntityDamageEvent.DamageCause.STARVATION) {
		          
		    }
		    if (causa == EntityDamageEvent.DamageCause.SUFFOCATION) {
		          
		    }
		    if (causa == EntityDamageEvent.DamageCause.SUICIDE) {
		          
		    }
		    if (causa == EntityDamageEvent.DamageCause.THORNS) {
		          
		    }
		    if (causa == EntityDamageEvent.DamageCause.VOID) {
		          
		    }
			if (killer instanceof Zombie){
				msg = Bukkit.getPluginManager().getPlugin("Darkers").getConfig().getString("MensajesAlMorir.Zombie").replaceAll("%usuario%", p.getDisplayName());
			}
			if (killer instanceof PigZombie){
				msg = Bukkit.getPluginManager().getPlugin("Darkers").getConfig().getString("MensajesAlMorir.Pigman").replaceAll("%usuario%", p.getDisplayName());
			}
			if (killer instanceof Creeper){
				msg = Bukkit.getPluginManager().getPlugin("Darkers").getConfig().getString("MensajesAlMorir.Creeper").replaceAll("%usuario%", p.getDisplayName());
			}
			if (killer instanceof Skeleton){
				Skeleton e = (Skeleton)killer;
				if (e.getSkeletonType().equals(Skeleton.SkeletonType.NORMAL)){
					msg = Bukkit.getPluginManager().getPlugin("Darkers").getConfig().getString("MensajesAlMorir.Esqueleto").replaceAll("%usuario%", p.getDisplayName());
				}
				if (e.getSkeletonType().equals(Skeleton.SkeletonType.WITHER)){
					msg = Bukkit.getPluginManager().getPlugin("Darkers").getConfig().getString("MensajesAlMorir.EsqueletoWither").replaceAll("%usuario%", p.getDisplayName());
				}
			}
			if (killer instanceof Silverfish){
				msg = Bukkit.getPluginManager().getPlugin("Darkers").getConfig().getString("MensajesAlMorir.PezDePlata").replaceAll("%usuario%", p.getDisplayName());
			}
			if (killer instanceof Enderman){
				msg = Bukkit.getPluginManager().getPlugin("Darkers").getConfig().getString("MensajesAlMorir.Enderman").replaceAll("%usuario%", p.getDisplayName());
			}
			if (killer instanceof Blaze){
				msg = Bukkit.getPluginManager().getPlugin("Darkers").getConfig().getString("MensajesAlMorir.Blaze").replaceAll("%usuario%", p.getDisplayName());
			}
			if (killer instanceof Spider){
				msg = Bukkit.getPluginManager().getPlugin("Darkers").getConfig().getString("MensajesAlMorir.Araña").replaceAll("%usuario%", p.getDisplayName());
			}
			if (killer instanceof EnderDragon){
				msg = Bukkit.getPluginManager().getPlugin("Darkers").getConfig().getString("MensajesAlMorir.DragonEnder").replaceAll("%usuario%", p.getDisplayName());
			}
			if (killer instanceof Ghast){
				msg = Bukkit.getPluginManager().getPlugin("Darkers").getConfig().getString("MensajesAlMorir.Ghast").replaceAll("%usuario%", p.getDisplayName());
			}
			if (killer instanceof IronGolem){
				msg = Bukkit.getPluginManager().getPlugin("Darkers").getConfig().getString("MensajesAlMorir.GolemDeHierro").replaceAll("%usuario%", p.getDisplayName());
			}
			if (killer instanceof MagmaCube){
				msg = Bukkit.getPluginManager().getPlugin("Darkers").getConfig().getString("MensajesAlMorir.CuboDeMagma").replaceAll("%usuario%", p.getDisplayName());
			}
			if (killer instanceof Slime){
				msg = Bukkit.getPluginManager().getPlugin("Darkers").getConfig().getString("MensajesAlMorir.Slime").replaceAll("%usuario%", p.getDisplayName());
			}
			if (killer instanceof Witch){
				msg = Bukkit.getPluginManager().getPlugin("Darkers").getConfig().getString("MensajesAlMorir.Bruja").replaceAll("%usuario%", p.getDisplayName());
			}
			if (killer instanceof Wolf){
				msg = Bukkit.getPluginManager().getPlugin("Darkers").getConfig().getString("MensajesAlMorir.Lobo").replaceAll("%usuario%", p.getDisplayName());
			}
			
			String msgFinal = ChatColor.translateAlternateColorCodes('&', msg);
			((PlayerDeathEvent)event).setDeathMessage(msgFinal);
		}
	}

}
