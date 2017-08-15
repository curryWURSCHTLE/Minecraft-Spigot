package me.currywurscht.left4dead.commands;

import java.util.HashMap;

import org.bukkit.entity.Player;

public class CommandHandler {

	public static boolean setupMode = false;
	
	private static HashMap<String, CommandInterface> commands = new HashMap<>();
	
	public static void registerCommands() {
		
	}
	
	public static void executeCommand(Player p, String[] args) {
		
	}

	public static HashMap<String, CommandInterface> getCommands() {
		return commands;
	}
}
