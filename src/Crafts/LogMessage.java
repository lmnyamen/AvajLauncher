package Crafts;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.io.File;
import java.util.List;


public class LogMessage {

    public static List<String> strings = new ArrayList<>();

    public static String formatStringTowerBaloon(Baloon flyable, String message) {
        return ("Tower says: " + flyable.getClass().getTypeName().substring(7) + "#" + flyable.name + "(" + flyable.id + ") " + message);
    }

    public static String formatStringTowerJetPlane(JetPlane flyable, String message) {
        return ("Tower says: " + flyable.getClass().getTypeName().substring(7) + "#" + flyable.name + "(" + flyable.id + ") " + message);
    }

    public static String formatStringTowerHelicopter(Helicopter flyable, String message) {
        return ("Tower says: " + flyable.getClass().getTypeName().substring(7) + "#" + flyable.name + "(" + flyable.id + ") " + message);
    }

    public static String formatStringBaloon(Baloon flyable, String message) {
        return (flyable.getClass().getTypeName().substring(7) + "#" + flyable.name + "(" + flyable.id + "): " + message);
    }

    public static String formatStringJetPlane(JetPlane flyable, String message) {
        return (flyable.getClass().getTypeName().substring(7) + "#" + flyable.name + "(" + flyable.id + "): " + message);
    }

    public static String formatStringHelicopter(Helicopter flyable, String message) {
        return (flyable.getClass().getTypeName().substring(7) + "#" + flyable.name + "(" + flyable.id + "): " + message);
    }

    public static void addString(String newString) {
        strings.add(newString);
    }

    public static void printInTxt() {
        try {
            PrintWriter writer = new PrintWriter(new File ("simulation.txt"));
            for (int i = 0; i < strings.size(); i++)
            {
                writer.flush();
                writer.println(strings.get(i));
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Error: ");
            e.printStackTrace();
        }
    }
}
