package me.draosrt.radperks;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class RadPerks extends JavaPlugin {

	protected RadPerksLogHandler log;
	public final RadPerksPlayerListener playerListener = new RadPerksPlayerListener(this);
	public RadPerksUtils radPerksUtils = new RadPerksUtils();
	public static HashMap<Player, Integer> playerRadValues = new HashMap<Player, Integer>();  // randomer679 - This shouldn't have been generic. Added correct types.
	public static HashMap<Player, Integer> playerRadLevels = new HashMap<Player, Integer>();  // randomer679 - Store rad levels.
	public static List<Player> playerList = new ArrayList<Player>(); // randomer679 - Same as above. Moved both these here for easier access for all classes.
	public static File radListFile;
	
	@Override
	public void onEnable() {		
		this.log = new RadPerksLogHandler(this);
		File dataFolder = this.getDataFolder();
		radListFile = new File(dataFolder,"radlist.yml");
		if(!dataFolder.exists()){
			dataFolder.mkdirs();
		}
		PluginManager pm = this.getServer().getPluginManager();
		pm.registerEvent(Event.Type.PLAYER_INTERACT, this.playerListener, Event.Priority.Monitor, this); // randomer679 - Changed to monitor as it does not need to cancel the event.
		pm.registerEvent(Event.Type.PLAYER_JOIN, playerListener, Event.Priority.Monitor, this); // randomer679 - Only monitors as it does not need to cancel the event. Needed to load a playerList rad value.
		this.log.info("Enabled");
	}

	@Override
	public void onDisable() {
		this.log.info("Disabled");
		
		
	}

}
