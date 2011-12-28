package me.draosrt.radperks;

import java.io.IOException;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;


public class RadPerksUtils {
	
	public static boolean load(Player player){ // randomer679 - Loads a playerList rad value from the rad list into the hashmap and list.
		YamlConfiguration radList = loadList();
		String playerName = player.getName();
		if(radList.contains(playerName+".radLevel") && radList.contains(playerName+".currentRads")){
			int radLevel = radList.getInt(playerName+".radLevel");
			int radValue = radList.getInt(playerName+".currentRads");
			RadPerks.playerRadLevels.put(player, radLevel);
			RadPerks.playerRadValues.put(player, radValue);
			RadPerks.playerList.add(player);
			return true;
		}else{
		return false;
		}
	}

	public static void save(){
		YamlConfiguration radList = loadList();
		int i;
		for(i = 0; i < RadPerks.playerList.size(); i++) { // while i is smaller than the list of playerList, plus it and run the code
			Player player = RadPerks.playerList.get(i); // randomer679 - This method of saving is much cleaner and simpler. Also easier to load.										
			String playerName = player.getName();
			Integer radValue = RadPerks.playerRadValues.get(player);
			Integer radLevel = RadPerks.playerRadLevels.get(player);
			radList.set(playerName+".currentRads", radValue);
			radList.set(playerName+".radLevel", radLevel);
		}
		try {
	        radList.save(RadPerks.radListFile); // randomer679 - Needs try/catch as it is a file system operation.
        } catch(IOException e) {
	        e.printStackTrace();
        }
	}
	
	public static YamlConfiguration loadList(){ // randomer679 - Loads rad list and returns it to the calling method.
		YamlConfiguration radList = YamlConfiguration.loadConfiguration(RadPerks.radListFile); // randomer679 - Does not need a try/catch as it creates a blank config object if the config is not found.
		return radList;
	}
	
	
	
}
