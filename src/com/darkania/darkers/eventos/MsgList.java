package com.darkania.darkers.eventos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.events.ListenerOptions;
import com.comphenix.protocol.events.ListenerPriority;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketEvent;
import com.comphenix.protocol.wrappers.WrappedGameProfile;
import com.darkania.darkers.Darkers;

public class MsgList implements Listener{
	@SuppressWarnings("deprecation")
	@EventHandler
	public void Msglist(ServerListPingEvent event){
		try { 
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/darkania?verifyServerCertificate=false&useSSL=true","root","EA6D8A9078");
            PreparedStatement tomar = conn.prepareStatement("SELECT player,ip FROM `users` WHERE ip=?;");
          tomar.setString(1, event.getAddress().getHostName());
          ResultSet obtenido = tomar.executeQuery();
          obtenido.next();
          String laip = obtenido.getString("ip");
          if(event.getAddress().getHostName().equals(laip)){
        	  //MSGLIST DE MANTENIMIENTO
        	  if(Darkers.mantenimiento){	  
        		  Darkers.msgping.clear();
        		  for(String elmsg: Bukkit.getPluginManager().getPlugin("Darkers").getConfig().getStringList("MsgList.Mantenimiento")){
        				Darkers.msgping.add(new WrappedGameProfile("1", ChatColor.translateAlternateColorCodes('&', elmsg)));
        				}
        		  
        				ProtocolLibrary.getProtocolManager().addPacketListener(new PacketAdapter(Bukkit.getPluginManager().getPlugin("Darkers"),ListenerPriority.NORMAL,
        				Arrays.asList(new PacketType[] {PacketType.Status.Server.OUT_SERVER_INFO}),
        				new ListenerOptions[] { ListenerOptions.ASYNC }) {
        					public void onPacketSending(PacketEvent e){
        						e.getPacket().getServerPings().read(0).setPlayers(Darkers.msgping);		
        						e.getPacket().getServerPings().read(0).setVersionProtocol(-1);
        						e.getPacket().getServerPings().read(0).setVersionName("Mantenimiento");		
        						}
        					});
        	  		}
        	  
        	  if(!Darkers.mantenimiento){	  
        		  for(String elmsg:Bukkit.getPluginManager().getPlugin("Darkers").getConfig().getStringList("MsgList.Normal")){
        				Darkers.msgping.add(new WrappedGameProfile("1", ChatColor.translateAlternateColorCodes('&', elmsg)));
        				}
        				ProtocolLibrary.getProtocolManager().addPacketListener(new PacketAdapter(Bukkit.getPluginManager().getPlugin("Darkers"),ListenerPriority.NORMAL,
        								 Arrays.asList(new PacketType[] {PacketType.Status.Server.OUT_SERVER_INFO}),
        								 new ListenerOptions[] { ListenerOptions.ASYNC }) 
        				{
        							public void onPacketSending(PacketEvent e){
        								e.getPacket().getServerPings().read(0).setPlayers(Darkers.msgping);						
        							}
        				
        				
        				});
        	  		}
        	  
          }
            obtenido.close();
            tomar.close();
            conn.close(); 
            }
		catch (Exception e) { 
			if (Darkers.mantenimiento){
				Darkers.msgping.clear();
      		  for(String elmsg:Bukkit.getPluginManager().getPlugin("Darkers").getConfig().getStringList("MsgList.Mantenimiento")){
      				Darkers.msgping.add(new WrappedGameProfile("1", ChatColor.translateAlternateColorCodes('&', elmsg)));
      				}
      				ProtocolLibrary.getProtocolManager().addPacketListener(new PacketAdapter(Bukkit.getPluginManager().getPlugin("Darkers"),ListenerPriority.NORMAL,
      								 Arrays.asList(new PacketType[] {PacketType.Status.Server.OUT_SERVER_INFO}),
      								 new ListenerOptions[] { ListenerOptions.ASYNC }) 
      				{
      							public void onPacketSending(PacketEvent e){
      								e.getPacket().getServerPings().read(0).setPlayers(Darkers.msgping);
      								
      								e.getPacket().getServerPings().read(0).setVersionProtocol(-1);
      								e.getPacket().getServerPings().read(0).setVersionName("Mantenimiento");
      								
      							}
      				});
			}
			
			if(!Darkers.mantenimiento){	  
      		  for(String elmsg:Bukkit.getPluginManager().getPlugin("Darkers").getConfig().getStringList("MsgList.Normal")){
      				Darkers.msgping.add(new WrappedGameProfile("1", ChatColor.translateAlternateColorCodes('&', elmsg)));
      				}
      				ProtocolLibrary.getProtocolManager().addPacketListener(new PacketAdapter(Bukkit.getPluginManager().getPlugin("Darkers"),ListenerPriority.NORMAL,
      								 Arrays.asList(new PacketType[] {PacketType.Status.Server.OUT_SERVER_INFO}),
      								 new ListenerOptions[] { ListenerOptions.ASYNC }) 
      				{
      							public void onPacketSending(PacketEvent e){
      								e.getPacket().getServerPings().read(0).setPlayers(Darkers.msgping);						
      							}
      				
      				
      				});
      	  		}
			
			
		}
	}
}
