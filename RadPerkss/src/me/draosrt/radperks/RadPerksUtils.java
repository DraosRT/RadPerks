package me.draosrt.radperks;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.YamlConfiguration;


public class RadPerksUtils {

	private static File radListFile;
	
	public static boolean load(String playerName){ // randomer679 - Loads a playerList rad value from the rad list into the hashmap and list.
		YamlConfiguration radList = loadList();
		if(radList.contains(playerName)){
			int radValue = radList.getInt(playerName);
			RadPerks.playerRadValues.put(playerName, radValue);
			RadPerks.playerList.add(playerName);
			return true;
		}
		return false;
	}

	public static void save(){
		YamlConfiguration radList = loadList();
		int i;
		for(i = 0; i < RadPerks.playerList.size(); i++) { // while i is smaller than the list of playerList, plus it and run the code
			String playerName = RadPerks.playerList.get(i); // randomer679 - This method of saving is much cleaner and simpler. Also easier to load.										
			Integer radValue = RadPerks.playerRadValues.get(playerName);
			radList.set(playerName, radValue);
		}
		try {
	        radList.save(radListFile); // randomer679 - Needs try/catch as it is a file system operation.
        } catch(IOException e) {
	        e.printStackTrace();
        }
	}
	
	public static YamlConfiguration loadList(){ // randomer679 - Loads rad list and returns it to the calling method.
		YamlConfiguration radList = YamlConfiguration.loadConfiguration(radListFile); // randomer679 - Does not need a try/catch as it creates a blank config object if the config is not found.
		return radList;
	}
	
	
	
}
