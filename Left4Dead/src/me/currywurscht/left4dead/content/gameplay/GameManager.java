package me.currywurscht.left4dead.content.gameplay;

import me.currywurscht.left4dead.content.mobs.ZombieMob.ZombieMobType;
import me.currywurscht.left4dead.main.Left4Dead;
import me.currywurscht.left4dead.utilities.GameMetadatas;

import org.bukkit.Location;

public class GameManager {
	
	int stage;
	Phase phase;
	GameMetadatas meta = Left4Dead.getInstance().getGameMetas();
	
	public void create() {
		
	}
	
	public void resetGame(boolean nextLevel) {
		
	}
	
	public Phase getPhase() {
		return phase;
	}
	
	public void setPhase(Phase phase) {
		this.phase = phase;
	}
	
	public int getStage() {
		return stage;
	}
	
	public void setStage(int stage) {
		this.stage = stage;
	}
	
	public enum Phase {
		LOBBY,
		INGAME,
		SAFEROOM;
	}
	
	public void spawnMobs() {
		for(Location loc : meta.getSpots().keySet()) {
			if(meta.getSpots().get(loc) == ZombieMobType.ZOMBIE) {
//				ZombieMob mob = ZombieMob
			} else {
				
			}
		}
	}
}
