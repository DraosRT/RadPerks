package me.rohan.RadPerks;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerListener;

public class RadPerksPlayerListener extends PlayerListener {

  
	public RadPerksPlayerListener(RadPerks instance) {
		
	}
	
	public void onPlayerInteract(PlayerInteractEvent event) {
		Player player = event.getPlayer();
		if (event.getItem().getType()== Material.RAW_BEEF) {
            if (event.getAction()==Action.RIGHT_CLICK_AIR) {
            	player.sendMessage(ChatColor.GREEN + "It Works!");

                
		
		}
	}
		if (event.getItem().getType()== Material.RAW_FISH) {
            if (event.getAction()==Action.RIGHT_CLICK_AIR) {
            	player.sendMessage(ChatColor.GREEN + "It Works!");
}


}
		if (event.getItem().getType()== Material.RAW_CHICKEN) {
            if (event.getAction()==Action.RIGHT_CLICK_AIR) {
            	player.sendMessage(ChatColor.GREEN + "It Works!");
	
	}
}
	}
}


