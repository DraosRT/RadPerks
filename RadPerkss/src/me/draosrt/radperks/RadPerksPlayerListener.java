package me.draosrt.radperks;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerListener;

public class RadPerksPlayerListener extends PlayerListener {
	public static RadPerks plugin;
	public RadPerksPlayerListener(RadPerks instance) {
		plugin = instance;
	}
	
	public void onPlayerInteract(PlayerInteractEvent event) {
		Player player = event.getPlayer();
		Material material = event.getItem().getType();
		if ((material == Material.RAW_BEEF) || (material == Material.RAW_FISH)
				|| (material == Material.RAW_CHICKEN || (material == Material.PORK))) {
            onPlayerEat(player, event);
            
		}
	} // end of onPlayerInteract
	
	private void onPlayerEat(Player player, PlayerInteractEvent event) {
		int id = event.getItem().getTypeId();
		// TODO: Maybe a event.getPlayer, then store in HashMap
		// then do a rad++ to increase radiation...
	}
	
	
	
	
	
	
}
