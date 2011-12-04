package me.draosrt.radperks;

import org.bukkit.plugin.java.JavaPlugin;

public class RadPerks extends JavaPlugin {

	protected RadPerksLogHandler log;
	
	@Override
	public void onEnable() {
		this.log = new RadPerksLogHandler (this);
		
		this.log.info("Enabled");
		
	}

	@Override
	public void onDisable() {
		this.log.info("Disabled");
		
		
	}

	
	
}
