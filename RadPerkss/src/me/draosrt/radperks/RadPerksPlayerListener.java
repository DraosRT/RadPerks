package me.draosrt.radperks;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerListener;

public class RadPerksPlayerListener extends PlayerListener {
	
	public RadPerks plugin; // randomer679 - Static was not needed.
	
	public RadPerksPlayerListener(RadPerks instance) {
		plugin = instance;
	}

	@Override
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
		int i = RadPerks.playerRadValues.get(player.getName()); // get that playerList rad level
		i++; // plus by one
		//playerRadValues.remove(player.getName(); // randomer679 - This is not needed. Put automatically replaces the current value.
		RadPerks.playerRadValues.put(player.getName(), i); // randomer679 - After the check that you do above this should not fail and does not need try/catch.
		RadPerksUtils.save(); // save to file. randomer679 - I recommend moving this to onDisable but I'll leave that up to you :)
	} // randomer679 - Closing brace was missing.
	
	@Override
	public void onPlayerJoin(PlayerJoinEvent event) { // randomer679 - Loads a playerList rad value when they join.
	    String playerName = event.getPlayer().getName();
	    if(!RadPerks.playerList.contains(playerName)){ // player not in the list? randomer679 - Closing bracket was missing. If player is not in this list the player won't be in the hashmap either.
			if(!RadPerksUtils.load(playerName)){ // randomer679 - If this returns true then the player will have been loaded from the rad list. Otherwise the player is new.
				RadPerks.playerRadValues.put(playerName,0); // add player
				RadPerks.playerList.add(playerName);	// add player
			}
    	}
	}  
}
