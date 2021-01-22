package me.som.cmd;

import java.util.logging.Logger;

import org.bukkit.plugin.java.JavaPlugin;

import me.som.cmd.som.handlers.ColorHandler;
import me.som.cmd.som.managers.CommandManager;
import me.som.cmd.som.managers.EventManager;
import me.som.cmd.som.managers.GameData;

public class ServerOperationManager extends JavaPlugin {
	// Declare Local Variables
	private static Logger					logger;
	private static ServerOperationManager	som;
	private static boolean					kickPlayerUploadShutDown;

	// Declare Global Variables
	private static CommandManager	commandManager;
	private static EventManager		eventManager;
	private static GameData			gameData;

	@Override
	public void onLoad() {
		// Setting Local Variables
		setLog(getLogger());
		setSOM(this);
	}

	@Override
	public void onEnable() {
		// Setting Local Variables
		setKickPlayerUploadShutDown(true);

		// Setting Global Variables
		commandManager = new CommandManager();
		eventManager = new EventManager();
		gameData = new GameData();

		// Setting up Plugin
		try {
			// gameData.setupFiles();
			// gameData.writeDefaultFile();
			// commandManager.setupCommandMap();
			// commandManager.registerCommands();
			// eventManager.registerEvents();
			getLog().info("Successfully enabled plugin [" + getDescription().getName() + " | V" + getDescription().getVersion() + "]");
		} catch (Exception error) {
			getLog().warning("Failed at enabling plugin [" + getDescription().getName() + " | V" + getDescription().getVersion() + "]");
			error.printStackTrace();
		}
	}

	@Override
	public void onDisable() {
		if (isKickPlayerUploadShutDown()) {
			getServer().getOnlinePlayers().forEach(player -> {
				String message = "";
				for (int i = 0; i < 30; i++)
					message += ColorHandler.rgbToHex(i * 5, i * 5, i * 5) + "=";
				player.sendMessage(ColorHandler.format(message));
			});
		}
	}

	// Return the logger
	public static Logger getLog() {
		return logger;
	}

	// Set the logger
	public static void setLog(Logger logger) {
		ServerOperationManager.logger = logger;
	}

	// Return the som
	public static ServerOperationManager getSOM() {
		return som;
	}

	// Set the som
	public static void setSOM(ServerOperationManager som) {
		ServerOperationManager.som = som;
	}

	// Return the kickPlayerUploadShutDown
	public static boolean isKickPlayerUploadShutDown() {
		return kickPlayerUploadShutDown;
	}

	// Set the kickPlayerUploadShutDown
	public static void setKickPlayerUploadShutDown(boolean kickPlayerUploadShutDown) {
		ServerOperationManager.kickPlayerUploadShutDown = kickPlayerUploadShutDown;
	}

	// Return the commandManager
	public static CommandManager getCommandManager() {
		return commandManager;
	}

	// Set the commandManager
	public static void setCommandManager(CommandManager commandManager) {
		ServerOperationManager.commandManager = commandManager;
	}

	// Return the eventManager
	public static EventManager getEventManager() {
		return eventManager;
	}

	// Set the eventManager
	public static void setEventManager(EventManager eventManager) {
		ServerOperationManager.eventManager = eventManager;
	}

	// Return the gameData
	public static GameData getGameData() {
		return gameData;
	}

	// Set the gameData
	public static void setGameData(GameData gameData) {
		ServerOperationManager.gameData = gameData;
	}
}
