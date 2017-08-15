package me.currywurscht.left4dead.utilities;

import java.util.HashMap;

import me.currywurscht.left4dead.content.mobs.ZombieMob.ZombieMobType;

import org.bukkit.Location;

public class GameMetadatas {
	
	private HashMap<Location, ZombieMobType> spots;
	
	public GameMetadatas() {
		spots = new HashMap<>();
		
	}

	public HashMap<Location, ZombieMobType> getSpots() {
		return spots;
	}
	
	public void addSpot(Location loc, ZombieMobType type) {
		spots.put(loc, type);
	}
}
