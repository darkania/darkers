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

public class YmlMuteados
  implements Listener
{
  static YmlMuteados instance = new YmlMuteados();
  Plugin p;
  FileConfiguration muteados;
  File lfile;
  
  public static YmlMuteados getInstance()
  {
    return instance;
  }
  
  public void setup(Plugin p)
  {
    this.lfile = new File(p.getDataFolder(), "muteados.yml");
    if (!this.lfile.exists()) {
      try
      {
        this.lfile.createNewFile();
      }
      catch (IOException e)
      {
        Darkers.logConsola(ChatColor.RED + "No se ha podido crear muteados.yml!");
        return;
      }
    }
    this.muteados = YamlConfiguration.loadConfiguration(this.lfile);
    this.muteados.options().copyDefaults(true);
    saveMuteados();
  }
  
  public FileConfiguration getMuteados()
  {
    return this.muteados;
  }
  
  
  public void saveMuteados()
  {
    try
    {
      this.muteados.save(this.lfile);
    }
    catch (IOException e)
    {
      Darkers.logConsola(ChatColor.RED+"No se ha podido guardar muteados.yml");
    }
  }
  
  public void reloadMuteados()
  {
    this.muteados = YamlConfiguration.loadConfiguration(this.lfile);
  }
  
  public FileConfiguration getConfig()
  {
    return this.muteados;
  }
  
  public PluginDescriptionFile getDesc()
  {
    return this.p.getDescription();
  }
}
