package com.darkania.darkers.extras;

import java.io.File;
import java.io.IOException;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginDescriptionFile;

import com.darkania.darkers.Darkers;

public class YmlMensajes
  implements Listener
{
  static YmlMensajes instance = new YmlMensajes();
  Plugin p;
  FileConfiguration mensajes;
  File lfile;
  
  public static YmlMensajes getInstance()
  {
    return instance;
  }
  
  public void setup(Plugin p)
  {
    this.lfile = new File(p.getDataFolder(), "mensajes.yml");
    if (!this.lfile.exists()) {
      try
      {
        this.lfile.createNewFile();
      }
      catch (IOException e)
      {
        Darkers.logConsola(ChatColor.RED + "No se ha podido crear mensajes.yml!");
        return;
      }
    }
    this.mensajes = YamlConfiguration.loadConfiguration(this.lfile);
    this.mensajes.options().copyDefaults(true);
    saveMensajes();
  }
  
  public FileConfiguration getMensajes()
  {
    return this.mensajes;
  }
  
  
  public void saveMensajes()
  {
    try
    {
      this.mensajes.save(this.lfile);
    }
    catch (IOException e)
    {
      Darkers.logConsola(ChatColor.RED+"No se ha podido guardar mensajes.yml");
    }
  }
  
  public void reloadMensajes()
  {
    this.mensajes = YamlConfiguration.loadConfiguration(this.lfile);
  }
  
  public FileConfiguration getConfig()
  {
    return this.mensajes;
  }
  
  public PluginDescriptionFile getDesc()
  {
    return this.p.getDescription();
  }
}
