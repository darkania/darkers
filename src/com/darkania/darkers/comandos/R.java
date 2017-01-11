package com.darkania.darkers.comandos;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.darkania.darkers.Darkers;
import com.darkania.darkers.extras.Permisos;

public class R implements CommandExecutor{
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		if (cmd.getName().equalsIgnoreCase("r") && sender instanceof Player) {
			if (args.length == 0){
				sender.sendMessage(ChatColor.RED+"Uso correcto: /r [mensaje]");
				return true;
			}
			Player PSender = (Player)sender;
			Player PRecividor = (Player) Bukkit.getServer().getPlayer(Darkers.getMensajes().getString("Mensajes."+PSender.getName()+".Responde"));
		      String Mensaje = "";
		      String[] arrayOfString;
		      int j = (arrayOfString = args).length;
		      for (int i = 0; i < j; i++)
		      {
		        String s = arrayOfString[i];Mensaje = Mensaje + s + " ";
		      }
            	
		    
			if ((PRecividor == null) || (!PSender.canSee(PRecividor))) {
				sender.sendMessage(ChatColor.RED+"Error, el jugador no fue encontrado.");
				return true;
			}
			if (Permisos.tiene(sender, "Darkers.color")){
				String MensajeColor = ChatColor.translateAlternateColorCodes('&', Mensaje);
				if (Permisos.tiene(PRecividor, "Darkers.staff")){
					PSender.sendMessage("§b§l[§byo -> "+PRecividor.getDisplayName()+"§b§l] §r"+MensajeColor);
					PRecividor.sendMessage("§b§l[§b"+PSender.getDisplayName()+" §b-> yo§b§l] §r"+MensajeColor);
					PSender.playSound(PSender.getLocation(), Sound.valueOf("UI_BUTTON_CLICK"), 1.0F, 2.0F);
					for(Player pr:Bukkit.getServer().getOnlinePlayers()){
						if (Permisos.tiene(pr, "Darkers.staffSP")) {
							if (Darkers.socialspy.contains(pr.getName())){
								pr.sendMessage("§2§l[§a§lD§2§l]--->> [§a"+PSender.getDisplayName()+" §2§l-> §a"+PRecividor.getDisplayName()+"§2§l] §r"+MensajeColor);
								return true;
							}
						}
					}
					return true;
				}
				if (!Permisos.tiene(PRecividor, "Darkers.staff")){
					PSender.sendMessage("§6[yo -> "+PRecividor.getDisplayName()+"§6] §r"+MensajeColor);
					PRecividor.sendMessage("§6["+PSender.getDisplayName()+" §6-> yo] §r"+MensajeColor);
					for(Player pr:Bukkit.getServer().getOnlinePlayers()){
						if (Permisos.tiene(pr, "Darkers.staffSP")) {
							if (Darkers.socialspy.contains(pr.getName())){
								pr.sendMessage("§2§l[§a§lD§2§l]--->> [§a"+PSender.getDisplayName()+" §2§l-> §a"+PRecividor.getDisplayName()+"§2§l] §r"+MensajeColor);
								return true;
							}
						}
					}
					return true;
				}
			}
			if (!Permisos.tiene(sender, "Darkers.color")){
				Mensaje = Mensaje.replaceAll("&1", "");
				Mensaje = Mensaje.replaceAll("&2", "");
				Mensaje = Mensaje.replaceAll("&3", "");
				Mensaje = Mensaje.replaceAll("&4", "");
				Mensaje = Mensaje.replaceAll("&5", "");
				Mensaje = Mensaje.replaceAll("&6", "");
				Mensaje = Mensaje.replaceAll("&7", "");
				Mensaje = Mensaje.replaceAll("&8", "");
				Mensaje = Mensaje.replaceAll("&9", "");
				Mensaje = Mensaje.replaceAll("&a", "");
				Mensaje = Mensaje.replaceAll("&b", "");
				Mensaje = Mensaje.replaceAll("&c", "");
				Mensaje = Mensaje.replaceAll("&d", "");
				Mensaje = Mensaje.replaceAll("&e", "");
				Mensaje = Mensaje.replaceAll("&f", "");
				Mensaje = Mensaje.replaceAll("&k", "");
				Mensaje = Mensaje.replaceAll("&l", "");
				Mensaje = Mensaje.replaceAll("&m", "");
				Mensaje = Mensaje.replaceAll("&n", "");
				Mensaje = Mensaje.replaceAll("&o", "");
				Mensaje = Mensaje.replaceAll("&r", "");
				
				if (Permisos.tiene(PRecividor, "Darkers.staff")){
					PSender.sendMessage("§b§l[§byo -> "+PRecividor.getDisplayName()+"§b§l] §r"+Mensaje);
					PRecividor.sendMessage("§b§l[§b"+PSender.getDisplayName()+" §b-> yo§b§l] §r"+Mensaje);
					PSender.playSound(PSender.getLocation(), Sound.valueOf("UI_BUTTON_CLICK"), 1.0F, 2.0F);
					for(Player pr:Bukkit.getServer().getOnlinePlayers()){
						if (Permisos.tiene(pr, "Darkers.staffSP")) {
							if (Darkers.socialspy.contains(pr.getName())){
								pr.sendMessage("§2§l[§a§lD§2§l]--->> [§a"+PSender.getDisplayName()+" §2§l-> §a"+PRecividor.getDisplayName()+"§2§l] §r"+Mensaje);
								return true;
							}
						}
					}
					return true;
				}
				if (!Permisos.tiene(PRecividor, "Darkers.staff")){
					PSender.sendMessage("§6[yo -> "+PRecividor.getDisplayName()+"§6] §r"+Mensaje);
					PRecividor.sendMessage("§6["+PSender.getDisplayName()+" §6-> yo] §r"+Mensaje);
					for(Player pr:Bukkit.getServer().getOnlinePlayers()){
						if (Permisos.tiene(pr, "Darkers.staffSP")) {
							if (Darkers.socialspy.contains(pr.getName())){
								pr.sendMessage("§2§l[§a§lD§2§l]--->> [§a"+PSender.getDisplayName()+" §2§l-> §a"+PRecividor.getDisplayName()+"§2§l] §r"+Mensaje);
								return true;
							}
						}
					}
					return true;
				}
			}
		
		}
		if (!(sender instanceof Player)){
			sender.sendMessage(ChatColor.GREEN+"[Darkers] "+ChatColor.RED+"No utilizable desde la consola.");
		}
		return false;
	}
	
}