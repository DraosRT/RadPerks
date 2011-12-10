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
		if(event.isCancelled() || event.isBlockInHand()){ // randomer679 - Check if the event is cancelled OR if it was a block place event. If so return.
			return;
		}
		Player player = event.getPlayer();
		Material material = event.getItem().getType();
		if ((material == Material.RAW_BEEF) || (material == Material.RAW_FISH)
				|| (material == Material.RAW_CHICKEN || (material == Material.PORK))) {
            onPlayerEat(player, event.getItem().getType());
		}
	} // end of onPlayerInteract
	
	private void onPlayerEat(Player player, Material food) {
		int radAddition;
		if(food == Material.ROTTEN_FLESH){ // randomer679 - Example of varying food rad values.
			radAddition = 3;
		}else if(food == Material.RAW_BEEF){
			radAddition = 2;
		}else{
			radAddition = 1;
		}
		int radValue = RadPerks.playerRadValues.get(player); // get that players rad value
		radValue += radAddition; // randomer679 - Add radAddition to current value.
		RadPerks.playerRadValues.put(player, radValue);
		player.sendMessage("You just gained "+radAddition+" rads. You now have "+radValue+" rads.");
		if(radValue >= 50){
			int radLevel = RadPerks.playerRadLevels.get(player);
			radLevel++;
			RadPerks.playerRadLevels.put(player, radLevel);
			player.sendMessage("Also you just gained a RadLevel! Your current RadLevel is "+radLevel+"!");
		}
		RadPerksUtils.save(); // save to file. randomer679 - I recommend moving this to onDisable but I'll leave that up to you :)
	} // randomer679 - Closing brace was missing.
	
	@Override
	public void onPlayerJoin(PlayerJoinEvent event) { // randomer679 - Loads a playerList rad value when they join.
	    Player player = event.getPlayer();
	    if(!RadPerks.playerList.contains(player)){ // player not in the list? randomer679 - Closing bracket was missing. If player is not in this list the player won't be in the hashmap either.
			if(!RadPerksUtils.load(player)){ // randomer679 - Check if the player is new. Attempts to load player into hashmap.
				RadPerks.playerRadValues.put(player,0); // add player
				RadPerks.playerRadLevels.put(player, 0);
				RadPerks.playerList.add(player);	// add player
			}
    	}
	}  
}
