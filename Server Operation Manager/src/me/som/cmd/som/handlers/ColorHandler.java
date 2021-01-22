package me.som.cmd.som.handlers;

import java.awt.Color;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.md_5.bungee.api.ChatColor;

public class ColorHandler {

	// Declare and set the Pattern
	private static final Pattern pattern = Pattern.compile("(?<!\\\\)(#[a-fA-F0-9]{6})");

	// Translate a RGB color value to a Hex value
	public static String rgbToHex(int red, int green, int blue) {
		return String.format("#%02X%02X%02X", red, green, blue);
	}

	// Translate a Hex color value to a RGB value
	public static Color hexToRGB(String hex) {
		return Color.decode(hex);
	}

	// Format a message with hex colors in it, to a colored message
	public static String format(String message) {
		Matcher matcher = pattern.matcher(message);
		while (matcher.find()) {
			String color = message.substring(matcher.start(), matcher.end());
			message = message.replace(color, "" + ChatColor.of(color));
			matcher = pattern.matcher(message);
		}
		return message;
	}

	// Fade two colors using Hex
	public static Color[] fade2ColorsHex(String startFadeHex, String endFadeHex, int steps) {

		// Declare & Set Variables
		Color[] colors = new Color[steps];
		Color start = hexToRGB(startFadeHex);
		Color end = hexToRGB(endFadeHex);

		steps--;

		// Set the color multiplier per step
		double rStep = (double) (end.getRed() - start.getRed()) / (double) steps;
		double gStep = (double) (end.getGreen() - start.getGreen()) / (double) steps;
		double bStep = (double) (end.getBlue() - start.getBlue()) / (double) steps;

		// Calculate color and adding color to colors
		for (int step = 0; step <= steps; step++) {
			int red = (int) (start.getRed() + rStep * step);
			int green = (int) (start.getGreen() + gStep * step);
			int blue = (int) (start.getBlue() + bStep * step);

			// Add color
			colors[step] = new Color(red, green, blue);
		}
		// Return array colors
		return colors;
	}

	// Fade two colors using RGB
	public static Color[] fade2ColorsRGB(Color start, Color end, int steps) {

		// Declare & Set Variables
		Color[] colors = new Color[steps];

		steps--;

		// Set the color multiplier per step
		double rStep = (double) (end.getRed() - start.getRed()) / (double) steps;
		double gStep = (double) (end.getGreen() - start.getGreen()) / (double) steps;
		double bStep = (double) (end.getBlue() - start.getBlue()) / (double) steps;

		// Calculate color and adding color to colors
		for (int step = 0; step <= steps; step++) {
			int red = (int) (start.getRed() + rStep * step);
			int green = (int) (start.getGreen() + gStep * step);
			int blue = (int) (start.getBlue() + bStep * step);

			// Add color
			colors[step] = new Color(red, green, blue);
		}
		// Return array colors
		return colors;
	}
}
