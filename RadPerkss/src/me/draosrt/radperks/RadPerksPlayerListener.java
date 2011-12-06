package me.draosrt.radperks;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerListener;

public class RadPerksPlayerListener extends PlayerListener {
	public static RadPerks plugin;
	private static HashMap myHashMap = new HashMap();  // New hashmap
	private static List players = new ArrayList(); // new arraylist for players
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
		if(!myHashMap.containsKey(player.getName()){ // player not logged?  
			myHashMap.put(player.getName(),0); // add player
			if(!players.contains(player.getName()){ // player not in the list?
				players.add(player.getName());	// add player
			}
		}
		try {
			int i = myHashMap.get(player.getName()); // get that players rad level
			i++; // plus by one
			myHashMap.remove(player.getName(); // remove player
			myHashMap.put(player.getName(), i);  // add the player in again with the new rad level
			this.save(); // save to file
		}catch(Exception e) {
			System.out.print("failed to get int");
		}
		private void save(){
			int i;
				PrintWriter write = new PrintWriter(new FileWriter(new File("myfile.txt"))); // not sure where this will save to :/
			for(i = 0; i < players.size(); i++) { /*
			while i is smaller than the list of players, plus it and run the code*/
				Player p = (Player) players.get(i); // get a player out of the list.

				write.print(p.getName() + ":" + myHashMap.get(p.getName())); // write to file

			}
			if(i >= players.size()) {
				write.close(); // save what we have written.
			}
		}


	}






}