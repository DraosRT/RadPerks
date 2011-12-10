package me.draosrt.radperks;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.bukkit.event.Event;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class RadPerks extends JavaPlugin {

	protected RadPerksLogHandler log;
	public final RadPerksPlayerListener playerListener = new RadPerksPlayerListener(this);
	public RadPerksUtils radPerksUtils = new RadPerksUtils();
	public static HashMap<String, Integer> playerRadValues = new HashMap<String, Integer>();  // randomer679 - This shouldn't have been generic. Added correct types.
	public static List<String> playerList = new ArrayList<String>(); // randomer679 - Same as above. Moved both these here for easier access for all classes.
	public static File dataFolder;

	
	@Override
	public void onEnable() {		
		this.log = new RadPerksLogHandler(this);
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
