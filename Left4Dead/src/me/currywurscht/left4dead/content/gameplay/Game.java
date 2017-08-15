package me.currywurscht.left4dead.content.gameplay;

import me.currywurscht.left4dead.main.Left4Dead;
import me.currywurscht.left4dead.utilities.StringCollection;

import org.bukkit.Bukkit;

public class Game extends GameManager {

	int lobbyPhaseCount = 60;
	int lobbyPhaseScheduler;
	int gamePhaseScheduler;
	
	public Game() {
		this.create();
	}
	
	public void startLobbyPhase() {
		setPhase(Phase.LOBBY);
		lobbyPhaseScheduler = Bukkit.getScheduler().scheduleSyncRepeatingTask(Left4Dead.getInstance(), new Runnable() {
			@Override
			public void run() {
				
				if(lobbyPhaseCount % 10 == 0) {
					Bukkit.broadcastMessage(StringCollection.prefix + "§aSpiel startet in §e" + lobbyPhaseCount + " §aSekunden.");
				}
				if(lobbyPhaseCount <= 5) {
					Bukkit.broadcastMessage(StringCollection.prefix + "§aSpiel startet in §e" + lobbyPhaseCount + " §aSekunden.");
				}
				if(lobbyPhaseCount != 0) {
					lobbyPhaseCount --;
				} else {
					if(Bukkit.getServer().getOnlinePlayers().size() >= 4) {
						startGame();
						Bukkit.getScheduler().cancelTask(lobbyPhaseScheduler);
					} else {
						lobbyPhaseCount = 20;
						Bukkit.broadcastMessage(StringCollection.prefix + "§aEs sind zu wenige Spieler online, um das Spiel zu starten.");
					}
				}
				
				if(Bukkit.getServer().getOnlinePlayers().size() >= 4) {
					startGame();
					Bukkit.getScheduler().cancelTask(lobbyPhaseScheduler);
				}
			}
		}, 0, 1);
	}
	
	public void startGame() {
		setPhase(Phase.INGAME);
		gamePhaseScheduler = Bukkit.getScheduler().scheduleSyncRepeatingTask(Left4Dead.getInstance(), new Runnable() {
			@Override
			public void run() {
				
			}
		}, 0, 10);
	}
	
	public void startSaferoomLoadingDelayPhase() {
		
	}
}
