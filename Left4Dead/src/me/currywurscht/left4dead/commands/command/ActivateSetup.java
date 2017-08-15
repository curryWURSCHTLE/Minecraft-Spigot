package me.currywurscht.left4dead.commands.command;

import org.bukkit.entity.Player;

import me.currywurscht.left4dead.commands.CommandHandler;
import me.currywurscht.left4dead.commands.CommandInterface;

public class ActivateSetup implements CommandInterface {
	
	@Override
	public boolean onCommand(Player p, String[] args) {
		CommandHandler.setupMode = !CommandHandler.setupMode;
		p.sendMessage(prefix + "§aDer Konfigurationsmodus wurde " + (CommandHandler.setupMode == true ? "aktiviert." : "deaktiviert."));
		return true;
	}

	@Override
	public void help(Player p) {
		p.sendMessage(prefix + "§c/activatesetup - Aktiviere den Konfigurations Modus");
	}

	@Override
	public String getPermission() {
		return "left4dead.admin.setup.activate";
	}
}
