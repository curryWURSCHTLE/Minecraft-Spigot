package me.currywurscht.left4dead.commands;

import org.bukkit.entity.Player;

public interface CommandInterface {
	
	public String prefix = "§6L4D SetUp §8>> ";

	public abstract boolean onCommand(Player p, String[] args);
	
	public abstract void help(Player p);
	
	public abstract String getPermission();
	
}
