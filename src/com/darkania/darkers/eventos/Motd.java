package com.darkania.darkers.eventos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;

import com.darkania.darkers.Darkers;

public class Motd implements Listener{
	@EventHandler
	public void onServerListPing(ServerListPingEvent event){
		try{
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/darkania?verifyServerCertificate=false&useSSL=true","root","EA6D8A9078");
            PreparedStatement tomar = conn.prepareStatement("SELECT player,ip,estado FROM `users` WHERE ip=?;");
          tomar.setString(1, event.getAddress().getHostName());
          ResultSet obtenido = tomar.executeQuery();
          obtenido.next();
          String laip = obtenido.getString("ip");
          String jugador = obtenido.getString("player");
          String estado = obtenido.getString("estado");
          Bukkit.getPluginManager().getPlugin("Darkers").getConfig().set("IP", event.getAddress().getHostName());
          Bukkit.getPluginManager().getPlugin("Darkers").saveConfig();
          Bukkit.getPluginManager().getPlugin("Darkers").reloadConfig();
          if(event.getAddress().getHostName().equals(laip)){
          
			if(Darkers.mantenimiento){
				event.setMotd("§4§k||§a§l--§2§l>>§4§l[§a§l-§4§lDarkania§a§l-§4§l]§2§l<<§a§l--§4§k||\n§2§l||§a§l-§2§l>>§4§lMantenimiento§2§l<<§a§l-§2§l||");
			}
			
			String DefaultMotd = ("§4§k||§a§l--§2§l>>§4§l[§a§l-§4§lDarkania§a§l-§4§l]§2§l<<§a§l--§4§k||\n");
			if (!estado.equals("baneado") && !Darkers.mantenimiento){
				if(jugador.length() <= 4 ){
      			  event.setMotd(DefaultMotd+"§2§l||§a§l-§4§l>>§aBienvenido "+jugador+"§4§l<<§a§l-§2§l||");  
      		  }
      		  if(jugador.length() == 5 ){
          		  event.setMotd(DefaultMotd+"§2§l||§a§l--§4§l>>§6¡§aHola "+jugador+"§6!§4§l<<§a§l--§2§l||");  
          	  }
      		  if(jugador.length() == 6 ){
          		  event.setMotd(DefaultMotd+"§2§l||§a§l--§4§l>>§aHola "+jugador+"§6!§4§l<<§a§l--§2§l||");  
          	  }

      		  if(jugador.length() == 7 ){
          		  event.setMotd(DefaultMotd+"§2§l||§a§l--§4§l>>§aHola "+jugador+"§4§l<<§a§l--§2§l||");  
          	  }
      		  
      		  if(jugador.length() == 8 ){
      			  event.setMotd(DefaultMotd+"§2§l||§a§l-§4§l>>§aHola "+jugador+"§6!§4§l<<§a§l-§2§l||");
      		  }
      		  if(jugador.length() == 9 ){
      			  event.setMotd(DefaultMotd+"§2§l||§a§l-§4§l>>§aHola "+jugador+"§4§l<<§a§l-§2§l||");
      		  }
      		  if(jugador.length() == 10 ){
      			  event.setMotd(DefaultMotd+"§2§l||§a§l-§4§l>§aHola "+jugador+"§6!§4§l<§a§l-§2§l||");
      		  }
      		  if(jugador.length() == 11 ){
      			  event.setMotd(DefaultMotd+"§2§l||§a§l-§4§l>§aHola "+jugador+"§4§l<§a§l-§2§l||");
      		  }
      		  if(jugador.length() == 12 ){
      			  event.setMotd(DefaultMotd+"§2§l||§a§l-§4§l>§aHola "+jugador+"§4§l<§a§l-§2§l||");
      		  }
      		  if(jugador.length() == 13 ){
      			  event.setMotd(DefaultMotd+"§2§l|§a§l-§4§l>§aHola "+jugador+"§4§l<§a§l-§2§l|");
      		  }
      		  if(jugador.length() == 14 ){
      			  event.setMotd(DefaultMotd+"§2§l|§4§l~§aHola "+jugador+"§6!§4§l~§2§l|");
      		  }
      		  if(jugador.length() >= 15 ){
      			  event.setMotd(DefaultMotd+"§2§l|§4§l~§aHola "+jugador+"§4§l~§2§l|");
      		  }
			}
			if (estado.equals("baneado")){
				String setmotd = "&2&l||&a&l-&2&l>>&4&lEstas Baneado&2&l<<&a&l-&2&l||";
      		  event.setMotd("§4§k||§a§l--§2§l>>§4§l[§a§l-§4§lDarkania§a§l-§4§l]§2§l<<§a§l--§4§k||\n"+setmotd);
			}
			if(estado.equals("encarcelado")){
      		  String setmotd = "&2&l||&a&l-&2&l>>&4&lEstas Encarcelado&2&l<<&a&l-&2&l||";
      		  event.setMotd("§4§k||§a§l--§2§l>>§4§l[§a§l-§4§lDarkania§a§l-§4§l]§2§l<<§a§l--§4§k||\n"+setmotd);
      	  }
			obtenido.close();
            tomar.close();
            conn.close(); 
			}
		}
		catch (Exception e){
			Darkers.logConsola(e.getMessage());
			if (Darkers.mantenimiento){
				event.setMotd("§4§k||§a§l--§2§l>>§4§l[§a§l-§4§lDarkania§a§l-§4§l]§2§l<<§a§l--§4§k||\n§2§l||§a§l-§2§l>>§4§lMantenimiento§2§l<<§a§l-§2§l||");
			}
			if (!Darkers.mantenimiento) {
				String motd = ("§4§k||§a§l--§2§l>>§4§l[§a§l-§4§lDarkania§a§l-§4§l]§2§l<<§a§l--§4§k||\n");
				event.setMotd(motd+"§2§l||§a§l--§4§l>>§aDarkania.com§4§l<<§a§l--§2§l||");
			}
		}
		
	}
}
