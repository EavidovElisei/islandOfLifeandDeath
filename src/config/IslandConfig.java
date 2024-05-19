package config;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class IslandConfig {
    private int width; // ширина
    private int height; // высота
    private int days;

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getDays() {
        return days;
    }



    public IslandConfig(String pathToPropetiesFile) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(pathToPropetiesFile))) {
            Properties properties = new Properties();
            properties.load(bufferedReader);
            this.width = Integer.parseInt(properties.getProperty("island.width"));
            this.height = Integer.parseInt(properties.getProperty("island.height"));
            this.days = Integer.parseInt(properties.getProperty("island.days"));

        } catch (IOException exception) {
            System.err.println(exception.getMessage());
        }


    }




    }
