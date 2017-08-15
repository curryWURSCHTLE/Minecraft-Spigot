package me.currywurscht.left4dead.utilities;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import me.currywurscht.left4dead.content.mobs.ZombieMob.ZombieMobType;
import me.currywurscht.left4dead.main.Left4Dead;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class WorldConfigInput {
	
	GameMetadatas meta = Left4Dead.getInstance().getGameMetas();
	File file;
	FileConfiguration cfg;
	
	
	public WorldConfigInput(String worldFilePath) {
		file = new File(worldFilePath);
		if(!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		cfg = YamlConfiguration.loadConfiguration(file);
	}
	
	public void read() {
		for(ZombieMobType type : ZombieMobType.values()) {
			if(cfg.getString("l4d.worldconfig.spots." + type.toString().toLowerCase()) != null ) {
				for(Location loc : serializeStringToLocations(cfg.getString("l4d.worldconfig.spots." + type.toString().toLowerCase() + ".locations"))) {
					meta.addSpot(loc, type);
				}
			}
		}
	}
	
	private List<Location> serializeStringToLocations(String s) {
		String[] args = s.split("::");
		List<Location> locs = new ArrayList<>();
		
		for(String s2 : args) {
			String[] args2 = s2.split(";");
			Location loc = new Location(
					Bukkit.getWorld(args2[0]), 
					Integer.valueOf(args2[1]), 
					Integer.valueOf(args2[2]), 
					Integer.valueOf(args2[3]));
			
			locs.add(loc);
		}
		
		return locs;
	}
}
