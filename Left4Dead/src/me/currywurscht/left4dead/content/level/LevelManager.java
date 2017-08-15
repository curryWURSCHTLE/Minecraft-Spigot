package me.currywurscht.left4dead.content.level;

import java.io.File;

import me.currywurscht.left4dead.main.Left4Dead;

import org.bukkit.Bukkit;
import org.bukkit.WorldCreator;

public class LevelManager {
	
	String worldName;
	String lobbyName;
	File file;
	
	public LevelManager(String worldName, String lobbyName) {
		this.worldName = worldName;
		this.lobbyName = lobbyName;
		
		this.file = new File(worldName);
		if(!this.file.exists()) {
			System.out.println("Welt konnte nicht gefunden werden.");
			return;
		}
	}
	
	public File getWorldFile() {
		return file;
	}
	
	public void loadWorld() {
		Bukkit.createWorld(new WorldCreator(worldName));
	}
	
	public void loadLobby() {
		Bukkit.createWorld(new WorldCreator(lobbyName));
	}
	
	public void unloadWorld() {
		Bukkit.unloadWorld(worldName, false);
	}
	
	public void unloadLobby() {
		Bukkit.unloadWorld(lobbyName, false);
	}
	
	public void changeMap(String newMap) {
		Bukkit.getScheduler().runTaskAsynchronously(Left4Dead.getInstance(), new Runnable() {
			@Override
			public void run() {
				unloadWorld();
				worldName = newMap;
				loadWorld();
			}
		});
	}
}
