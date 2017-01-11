package com.darkania.darkers.eventos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;


public class LoginEvent implements Listener{
	@EventHandler
	public void onPlayerLogin(PlayerLoginEvent event){
		try{
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/darkania?verifyServerCertificate=false&useSSL=true","root","EA6D8A9078");
			PreparedStatement tomar = conn.prepareStatement("UPDATE player,ip FROM `users` WHERE ip=?;");
			tomar.executeQuery();
		}
		catch(SQLException e){
			
		}
	}

}
