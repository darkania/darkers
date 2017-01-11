package com.darkania.darkers;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.configuration.file.FileConfiguration;
//import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.Scoreboard;

import com.comphenix.protocol.wrappers.WrappedGameProfile;
import com.darkania.darkers.comandos.Ban;
import com.darkania.darkers.comandos.Colores;
import com.darkania.darkers.comandos.Craftear;
import com.darkania.darkers.comandos.Curar;
import com.darkania.darkers.comandos.Dark;
import com.darkania.darkers.comandos.DesactivarLluvia;
import com.darkania.darkers.comandos.Difundir;
import com.darkania.darkers.comandos.Enderchest;
import com.darkania.darkers.comandos.Hat;
import com.darkania.darkers.comandos.HelpOp;
import com.darkania.darkers.comandos.Limpiar;
import com.darkania.darkers.comandos.M;
import com.darkania.darkers.comandos.Mantenimiento;
import com.darkania.darkers.comandos.Msg;
import com.darkania.darkers.comandos.Ofertas;
import com.darkania.darkers.comandos.Ping;
import com.darkania.darkers.comandos.Plugins;
import com.darkania.darkers.comandos.Privado;
import com.darkania.darkers.comandos.Publico;
import com.darkania.darkers.comandos.R;
//import com.darkania.darkers.comandos.Relinchar;
import com.darkania.darkers.comandos.Renombrar;
import com.darkania.darkers.comandos.Say;
import com.darkania.darkers.comandos.SetHealth;
import com.darkania.darkers.comandos.Setspawn;
import com.darkania.darkers.comandos.SocialSpy;
import com.darkania.darkers.comandos.Spawn;
import com.darkania.darkers.comandos.Suicide;
import com.darkania.darkers.comandos.Tppos;
import com.darkania.darkers.comandos.Unban;
import com.darkania.darkers.comandos.Vanish;
import com.darkania.darkers.eventos.Alertas;
import com.darkania.darkers.eventos.Boton;
import com.darkania.darkers.eventos.CabezasDeMobs;
//import com.darkania.darkers.eventos.CabezasDeMobs;
import com.darkania.darkers.eventos.Carteles;
import com.darkania.darkers.eventos.Chat;
import com.darkania.darkers.eventos.Mensajes;
import com.darkania.darkers.eventos.Motd;
import com.darkania.darkers.eventos.MsgList;
import com.darkania.darkers.eventos.MsgMuertes;
import com.darkania.darkers.eventos.Refrigerador;
import com.darkania.darkers.extras.YmlBaneados;
import com.darkania.darkers.extras.YmlMensajes;
import com.darkania.darkers.extras.YmlMuteados;
import com.darkania.darkers.extras.YmlRefrigeradores;
import com.darkania.darkers.utilidades.AutoGuardarMundos;
import com.darkania.darkers.utilidades.AutoReinicio;
//import com.darkania.darkers.utilidades.ColoresEnNombres;
import com.darkania.darkers.utilidades.CrafteosHorno;
import com.darkania.darkers.utilidades.CrafteosMesa;

public class Darkers extends JavaPlugin {
	public static boolean mantenimiento = false;
	public static List<WrappedGameProfile> msgping = new ArrayList<WrappedGameProfile>();
	public static ArrayList<String> privado = new ArrayList<>();
	public static ArrayList<String> publico = new ArrayList<>();
	public static ArrayList<String> ofertas = new ArrayList<>();
	public static ArrayList<String> muteado = new ArrayList<>();
	public static ArrayList<String> vanished = new ArrayList<>();
	public static ArrayList<String> socialspy = new ArrayList<>();
	public static Scoreboard scoreboard;
	@Override
	public void onEnable() {
	getServer();	
		YmlBaneados.getInstance().setup(this);
		YmlMensajes.getInstance().setup(this);
		YmlMuteados.getInstance().setup(this);
		YmlRefrigeradores.getInstance().setup(this);
	    getServer().getPluginManager().registerEvents(new YmlBaneados(), this);
	    getServer().getPluginManager().registerEvents(new YmlMensajes(), this);
	    getServer().getPluginManager().registerEvents(new CabezasDeMobs(), this);
		getServer().getPluginManager().registerEvents(new Mensajes(), this);
		getServer().getPluginManager().registerEvents(new Alertas(), this);
		getServer().getPluginManager().registerEvents(new Chat(), this);
		getServer().getPluginManager().registerEvents(new Boton(), this);
		getServer().getPluginManager().registerEvents(new Carteles(), this);
		getServer().getPluginManager().registerEvents(new MsgMuertes(), this);
		getServer().getPluginManager().registerEvents(new MsgList(), this);
		getServer().getPluginManager().registerEvents(new Motd(), this);
		getServer().getPluginManager().registerEvents(new Refrigerador(), this);
		getCommand("colores").setExecutor(new Colores());
		getCommand("say").setExecutor(new Say());
		getCommand("helpop").setExecutor(new HelpOp());
		getCommand("limpiar").setExecutor(new Limpiar());
		getCommand("msg").setExecutor(new Msg());
		getCommand("r").setExecutor(new R());
		getCommand("darkers").setExecutor(new Dark());
		getCommand("m").setExecutor(new M());
		getCommand("difundir").setExecutor(new Difundir());
		getCommand("curar").setExecutor(new Curar());
		getCommand("craftear").setExecutor(new Craftear());
		getCommand("socialspy").setExecutor(new SocialSpy());
		getCommand("publico").setExecutor(new Publico());
		getCommand("privado").setExecutor(new Privado());
		getCommand("ofertas").setExecutor(new Ofertas());
		getCommand("tppos").setExecutor(new Tppos());
		getCommand("hat").setExecutor(new Hat());
		getCommand("suicide").setExecutor(new Suicide());
		getCommand("plugins").setExecutor(new Plugins());
		getCommand("enderchest").setExecutor(new Enderchest());
		getCommand("sethealth").setExecutor(new SetHealth());
		getCommand("vanish").setExecutor(new Vanish());
		getCommand("ban").setExecutor(new Ban());
		getCommand("unban").setExecutor(new Unban());
		getCommand("renombrar").setExecutor(new Renombrar());
		getCommand("setspawn").setExecutor(new Setspawn());
		getCommand("spawn").setExecutor(new Spawn());
		getCommand("ping").setExecutor(new Ping());
		getCommand("desactivar").setExecutor(new DesactivarLluvia());
		getCommand("mantenimiento").setExecutor(new Mantenimiento());
		//getCommand("relinchar").setExecutor(new Relinchar());
		saveDefaultConfig();	
	    CrafteosMesa.iniciar();
	    CrafteosHorno.iniciar();
	    //for (Player p: Bukkit.getServer().getOnlinePlayers()){
	    	//ColoresEnNombres.ColorPlayer(p);
	    //}
	   logConsola("Habilitado");
	    AutoReinicio();
	    AutoGuardarMundos.IniciarAutoGuardado();{
	    	logConsola(ChatColor.GREEN+"AutoGuardado iniciado");
	    }
		if (Bukkit.getPluginManager().getPlugin("Darkers").getConfig().getBoolean("Mantenimiento")){
			mantenimiento = true;
			logConsola(ChatColor.RED+"El mantenimiento esta activado");
		}
	}
	
	@Override
	public void onDisable() {
		logConsola("Deshabilitado correctamente");
	}
	
	public static FileConfiguration getBaneados(){
	    return YmlBaneados.getInstance().getBaneados();
	  }
	public static FileConfiguration getMensajes(){
		return YmlMensajes.getInstance().getMensajes();
	}
	public static FileConfiguration getMuteados(){
		return YmlMuteados.getInstance().getMuteados();
	}
	public static FileConfiguration getRefrigeradores(){
		return YmlRefrigeradores.getInstance().getRefrigeradores();
	}
	public void AutoReinicio(){
		AutoReinicio.PrimerMsg();
	    AutoReinicio.SegundoMsg();
	    AutoReinicio.TercerMsg();
	    AutoReinicio.CuartoMsg();
	    AutoReinicio.Reinicio();
	    logConsola(ChatColor.GREEN+"Se inicio el AutoReinicio");
	}
	public static void logConsola(String msg) {
	    ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
	    console.sendMessage(ChatColor.AQUA + "[Darkers] " + ChatColor.BLUE + msg);
	  }
}







