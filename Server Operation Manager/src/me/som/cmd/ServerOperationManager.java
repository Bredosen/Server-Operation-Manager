package me.som.cmd;

import java.awt.Color;
import java.util.logging.Logger;

import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import me.som.cmd.som.handlers.ColorHandler;
import me.som.cmd.som.managers.CommandManager;
import me.som.cmd.som.managers.EventManager;
import me.som.cmd.som.managers.GameData;
import me.som.cmd.somDefault.commands.TestCmd;

public class ServerOperationManager extends JavaPlugin {
    // Declare Local Variables
    private static Logger                 logger;
    private static ServerOperationManager som;
    private static boolean                kickPlayerUploadShutDown;

    // Declare Global Variables
    private static CommandManager commandManager;
    private static EventManager   eventManager;
    private static GameData       gameData;

    @Override
    public void onLoad() {
        // Setting Local Variables
        setLog(getLogger());
        setSOM(this);
    }

    @Override
    public void onEnable() {
        // Setting Local Variables
        setKickPlayerUploadShutDown(false);

        // Setting Global Variables
        commandManager = new CommandManager();
        eventManager = new EventManager();
        gameData = new GameData();

        // Setting up Plugin
        try {
            getCommand("Test").setExecutor(new TestCmd());
            getLog().info("Successfully enabled plugin [" + getDescription().getName() + " | V" + getDescription().getVersion() + "]");
        } catch (Exception error) {
            getLog().warning("Failed at enabling plugin [" + getDescription().getName() + " | V" + getDescription().getVersion() + "]");
            error.printStackTrace();
        }
    }

    @Override
    public void onDisable() {
        if (isKickPlayerUploadShutDown()) kickPlayers();
    }

    public void kickPlayers() {
        String message = "";
        Color start = new Color(50, 50, 50);
        Color end = new Color(225, 225, 225);
        message += ColorHandler.fade2Colors(new Color(0, 120, 255), new Color(0, 220, 255), "ThalassicMC") + "\n";
        message += ColorHandler.fade2Colors(start, end, "=====================");
        message += ColorHandler.fade2Colors(end, start, "=====================");
        message += "\n" + ColorHandler.rgbToHex(new Color(200, 40, 90)) + "Server is reloading!\n";
        message += "\n" + ColorHandler.rgbToHex(Color.green) + "Please reconnect in about 10 seconds\n";
        message += ColorHandler.fade2Colors(start, end, "=====================");
        message += ColorHandler.fade2Colors(end, start, "=====================");

        for (Player player : getServer().getOnlinePlayers())
            player.kickPlayer(ColorHandler.format(message).replace("{player}", player.getName()));
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
