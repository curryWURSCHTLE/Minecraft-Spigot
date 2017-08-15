package me.currywurscht.left4dead.commands.command.setup;

import org.bukkit.entity.Player;

import me.currywurscht.left4dead.commands.CommandInterface;

public class SetCommand implements CommandInterface {

	@Override
	public boolean onCommand(Player p, String[] args) {
	
		return false;
	}

	@Override
	public void help(Player p) {
		p.sendMessage("");
		p.sendMessage("");
		p.sendMessage("");
		p.sendMessage("");
		p.sendMessage("");
		p.sendMessage("");
		p.sendMessage("");
		p.sendMessage("");
		p.sendMessage("");
		p.sendMessage("");
		p.sendMessage("");
		p.sendMessage("");
		p.sendMessage("");
		p.sendMessage("");
		p.sendMessage("");
	}

	@Override
	public String getPermission() {
		return "left4dead.admin.setup.configurate.*";
	}
}
