package com.darkania.darkers.extras;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginDescriptionFile;

public class YmlRefrigeradores
  implements Listener
{
  static YmlRefrigeradores instance = new YmlRefrigeradores();
  Plugin p;
  FileConfiguration refrigeradores;
  File lfile;
  
  public static YmlRefrigeradores getInstance()
  {
    return instance;
  }
  
  public void setup(Plugin p)
  {
    this.lfile = new File(p.getDataFolder(), "Refrigeradores.yml");
    if (!this.lfile.exists()) {
      try
      {
        this.lfile.createNewFile();
      }
      catch (IOException e)
      {
        Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "No se ha podido crear Refrigeradores.yml!");
        return;
      }
    }
    this.refrigeradores = YamlConfiguration.loadConfiguration(this.lfile);
    this.refrigeradores.options().copyDefaults(true);
    saveRefrigeradores();
  }
  
  public FileConfiguration getRefrigeradores()
  {
    return this.refrigeradores;
  }
  
  
  public void saveRefrigeradores()
  {
    try
    {
      this.refrigeradores.save(this.lfile);
    }
    catch (IOException e)
    {
      Bukkit.getConsoleSender().sendMessage(ChatColor.RED+"No se ha podido guardar Refrigeradores.yml");
    }
  }
  
  public void reloadRefrigeradores()
  {
    this.refrigeradores = YamlConfiguration.loadConfiguration(this.lfile);
  }
  
  public FileConfiguration getConfig()
  {
    return this.refrigeradores;
  }
  
  public PluginDescriptionFile getDesc()
  {
    return this.p.getDescription();
  }
}
