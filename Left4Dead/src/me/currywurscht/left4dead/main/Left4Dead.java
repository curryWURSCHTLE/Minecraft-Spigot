package me.currywurscht.left4dead.main;

import me.currywurscht.left4dead.commands.CommandHandler;
import me.currywurscht.left4dead.content.level.LevelManager;
import me.currywurscht.left4dead.utilities.GameMetadatas;
import me.currywurscht.left4dead.utilities.WorldConfigInput;
import me.currywurscht.left4dead.utilities.config.Config;

import org.bukkit.plugin.java.JavaPlugin;

public class Left4Dead extends JavaPlugin {

	private static Left4Dead instance;
	private GameMetadatas meta;
	private WorldConfigInput worldconfig;
	private LevelManager lvlManager;
	private Config config;
	
	@Override
	public void onEnable() {
		registerListener();
		registerCommands();
		init();
	}
	
	@Override
	public void onDisable() {
		
	}
	
	private void registerListener() {
		
	}
	
	private void registerCommands() {
		CommandHandler.registerCommands();
	}
	
	//TODO STAGE VERÄNDERN MIT DYNAMISCHER FUNKTION
	
	@SuppressWarnings("static-access")
	private void init() {
		this.instance = this;
		this.meta = new GameMetadatas();
		this.config = new Config("plugins/Left4Dead/DONTTOUCHTHIS/gameconfig.yml");
		this.worldconfig = new WorldConfigInput(config.getMapFilePath(config.getCampaignName(), 1) + "/left4dead.yml");
		this.lvlManager = new LevelManager(config.getMapFilePath(config.getCampaignName(), 1), config.getLobbyWorldName());
	}
	
	public static Left4Dead getInstance() {
		return instance;
	}
	
	public GameMetadatas getGameMetas() {
		return this.meta;
	}

	public WorldConfigInput getWorldConfig() {
		return this.worldconfig;
	}
	
	public LevelManager getLevelManager() {
		return this.lvlManager;
	}
	
	public Config getGameConfig() {
		return config;
	}
}
