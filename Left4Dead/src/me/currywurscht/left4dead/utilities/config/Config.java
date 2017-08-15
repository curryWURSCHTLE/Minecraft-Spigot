package me.currywurscht.left4dead.utilities.config;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class Config {

	File file;
	FileConfiguration cfg;
	
	public Config(String path) {
		this.file = new File(path);
		if(!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		this.cfg = YamlConfiguration.loadConfiguration(file);
	}
	
//	public void setLocation(Location loc, String path, boolean keepValues) {
//		if(keepValues) {
//			cfg.getString(path);
//		} else {
//			
//		}
//	}
	
	public void setMapFile(String campaignName, Integer stage, String mapFile) {
		cfg.set("L4D.Map.Path." + campaignName + "." + String.valueOf(stage), mapFile);
		try {
			cfg.save(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public String getMapFilePath(String campaignName, Integer stage) {
		//String map = "L4D_" + campaignName + "_" + String.valueOf(stage);
		return cfg.getString("L4D.Map.Path." + campaignName + "." + String.valueOf(stage));
	}
	
	public String getCampaignName() {
		return cfg.getString("L4D.Map.CampaignName");
	}
	
	public void setCampaignName(String campaignGame) {
		cfg.set("L4D.Map.CampaignName", campaignGame);
		try {
			cfg.save(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public String getLobbyWorldName() {
		return cfg.getString("L4D.Map.Lobby.Name");
	}
	
	public void setLobbyWorldName(String name) {
		cfg.set("L4D.Map.Lobby.Name", name);
		try {
			cfg.save(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
