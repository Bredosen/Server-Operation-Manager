package me.som.cmd.somDefault.commands;

import java.awt.Color;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.som.cmd.som.handlers.ColorHandler;

public class TestCmd implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] arg3) {
        if (!(sender instanceof Player)) return false;
        Player player = (Player) sender;
        player.sendMessage(ColorHandler.format(ColorHandler.fade2Colors(Color.red, Color.yellow, "This is just a test to see how it's looking")));
        return false;
    }

}
