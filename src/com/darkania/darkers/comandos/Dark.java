package com.darkania.darkers.comandos;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import com.darkania.darkers.extras.Permisos;

public class Dark implements CommandExecutor{
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		if (cmd.getName().equalsIgnoreCase("darkers")){
			if (Permisos.tiene(sender, "Darkers.staff")){
				if (args.length == 0){
					sender.sendMessage(ChatColor.GREEN+"-----Comandos de Darkers v1.0.0 [Pagina 1-4]-----");
					sender.sendMessage(ChatColor.GREEN+"/colores "+ChatColor.AQUA+"- Ver los formatos de colores que hay.");
					sender.sendMessage(ChatColor.GREEN+"/craftear"+ChatColor.AQUA+" - Abre una mesa de crafteo.");
					sender.sendMessage(ChatColor.GREEN+"/curar [usuario]"+ChatColor.AQUA+" - Cura tus corazones o los de un usuario");
					sender.sendMessage(ChatColor.GREEN+"/darkers"+ChatColor.AQUA+" - Ve los comandos del plugin darkers");
					sender.sendMessage(ChatColor.GREEN+"/difundir"+ChatColor.AQUA+" - Envia un mensaje con sonido");
					sender.sendMessage(ChatColor.GREEN+"/hat"+ChatColor.AQUA+" - Ponte un item de sombrero");
					sender.sendMessage(ChatColor.GREEN+"Usa /darkers 2 para obtener obtener mas comandos");
					return true;
				}
				if ("2".equalsIgnoreCase(args[0])){
					sender.sendMessage(ChatColor.GREEN+"-----Comandos de Darkers v1.0.0 [Pagina 2-4]-----");
					sender.sendMessage(ChatColor.GREEN+"/helpop [Mensaje]"+ChatColor.AQUA+" - Pide ayuda a un staff");
					sender.sendMessage(ChatColor.GREEN+"/jobs"+ChatColor.AQUA+" - Trabajar de forma survival");
					sender.sendMessage(ChatColor.GREEN+"/limpiar [todos] "+ChatColor.AQUA+"- Limpia tu chat o el de todos.");
					sender.sendMessage(ChatColor.GREEN+"/msg "+ChatColor.AQUA+"- Envia un mensaje privado a un jugador.");
					sender.sendMessage(ChatColor.GREEN+"/mail [send, read, clear]"+ChatColor.AQUA+"- Envia un mail a un jugador");
					sender.sendMessage(ChatColor.GREEN+"/m"+ChatColor.AQUA+" - Envia un mensaje privado a un jugador.");
					sender.sendMessage(ChatColor.GREEN+"Usa /darkers 3 para obtener obtener mas comandos");
					return true;
				}
				if ("3".equalsIgnoreCase(args[0])){
					sender.sendMessage(ChatColor.GREEN+"-----Comandos de Darkers v1.0.0 [Pagina 3-4]-----");
					sender.sendMessage(ChatColor.GREEN+"/ofertas "+ChatColor.AQUA+"- Entra al modo de chat ofertas");
					sender.sendMessage(ChatColor.GREEN+"/plugins "+ChatColor.AQUA+"- ve los plugins de darkania");
					sender.sendMessage(ChatColor.GREEN+"/privado "+ChatColor.AQUA+"- Entra al modo de chat privado");
					sender.sendMessage(ChatColor.GREEN+"/publico "+ChatColor.AQUA+"- Entra al modo de chat publico");
					sender.sendMessage(ChatColor.GREEN+"/r "+ChatColor.AQUA+"- Responde el mensaje enviado con /msg.");
					sender.sendMessage(ChatColor.GREEN+"/say "+ChatColor.AQUA+"- Envia un mensaje a todos los jugadores, con sonido");
					sender.sendMessage(ChatColor.GREEN+"Usa /darkers 4 para obtener obtener mas comandos");
					return true;
				}
				if ("4".equalsIgnoreCase(args[0])){
					sender.sendMessage(ChatColor.GREEN+"-----Comandos de Darkers v1.0.0 [Pagina 4-4]-----");
					sender.sendMessage(ChatColor.GREEN+"/socialspy [on, off] "+ChatColor.AQUA+"- Espia los mensajes de los usuarios");
					sender.sendMessage(ChatColor.GREEN+"/suicide "+ChatColor.AQUA+"- Suicidate");
					sender.sendMessage(ChatColor.GREEN+"/tppos "+ChatColor.AQUA+"- Teletransportate a unas coordenadas");
					sender.sendMessage(ChatColor.GREEN+"/sethealth "+ChatColor.AQUA+"- Cambia tu nivel de corazones");
					return true;
				}
				sender.sendMessage(ChatColor.RED+"Pagina no encontrada.");
			}	
			if (!Permisos.tiene(sender, "Darkers.staff")){
				sender.sendMessage(ChatColor.DARK_GREEN+"Comando invalido. Usa /help para ver la lista de comandos.");
				return true;
			}
		}
		return false;
	}
}
