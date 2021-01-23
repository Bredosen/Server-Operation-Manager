package me.bredo.test;

import java.awt.Color;

import me.som.cmd.som.handlers.ColorHandler;

public class Test {

    public static void main(String[] args) {

        String start = ColorHandler.rgbToHex(0, 0, 0);
        String end = ColorHandler.rgbToHex(100, 100, 100);

        System.out.println("Start Hex Value: " + start);
        System.out.println("End Hex Value: " + end);

        System.out.println("message: " + ColorHandler.format(ColorHandler.fade2Colors(ColorHandler.hexToRGB(start), ColorHandler.hexToRGB(end), "SUP")));

        for (Color color : ColorHandler.fade2ColorsRGB(ColorHandler.hexToRGB(start), ColorHandler.hexToRGB(end), 5))
            System.out.println("RGB: [" + color.getRed() + ", " + color.getGreen() + ", " + color.getBlue() + "] | Hex: ["
                    + ColorHandler.rgbToHex(color.getRed(), color.getGreen(), color.getBlue()) + "]");
    }

}
