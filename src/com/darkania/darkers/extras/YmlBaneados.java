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

public class YmlBaneados
  implements Listener
{
  static YmlBaneados instance = new YmlBaneados();
  Plugin p;
  FileConfiguration baneados;
  File lfile;
  
  public static YmlBaneados getInstance()
  {
    return instance;
  }
  
  public void setup(Plugin p)
  {
    this.lfile = new File(p.getDataFolder(), "baneados.yml");
    if (!this.lfile.exists()) {
      try
      {
        this.lfile.createNewFile();
      }
      catch (IOException e)
      {
        Darkers.logConsola(ChatColor.RED + "No se ha podido crear baneados.yml!");
        return;
      }
    }
    this.baneados = YamlConfiguration.loadConfiguration(this.lfile);
    this.baneados.options().copyDefaults(true);
    saveBaneados();
  }
  
  public FileConfiguration getBaneados()
  {
    return this.baneados;
  }
  
  
  public void saveBaneados()
  {
    try
    {
      this.baneados.save(this.lfile);
    }
    catch (IOException e)
    {
      Darkers.logConsola(ChatColor.RED+"No se ha podido guardar baneados.yml");
    }
  }
  
  public void reloadBaneados()
  {
    this.baneados = YamlConfiguration.loadConfiguration(this.lfile);
  }
  
  public FileConfiguration getConfig()
  {
    return this.baneados;
  }
  
  public PluginDescriptionFile getDesc()
  {
    return this.p.getDescription();
  }
}
