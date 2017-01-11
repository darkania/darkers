package com.darkania.darkers.extras;

import org.bukkit.command.BlockCommandSender;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class Permisos
{
  public static boolean tiene(CommandSender sender, String permiso)
  {
    if ((sender instanceof ConsoleCommandSender)) {
      return true;
    }
    if ((sender instanceof BlockCommandSender)){
    	return true;
    }
    if ((sender instanceof Player))
    {
      Player user = (Player)sender;
      if (user.isOp()) {
        return true;
      }
      if (user.hasPermission(permiso)) {
        return true;
      }
      return false;
    }
    return false;
  }
  
  public static boolean has(Player player, String permiso)
  {
    if (player == null) {
      return false;
    }
    if (player.isOp()) {
      return true;
    }
    if (player.hasPermission(permiso)) {
      return true;
    }
    return false;
  }
}