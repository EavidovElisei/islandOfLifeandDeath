package models;



import models.abstracts.Entity;
import models.island.Field;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

public class Island {
    private Map<Field, List<Entity>> island;
    private int width;
    private int height;

    public Map<Field, List<Entity>> getIsland() {
        return island;
    }

    public Island(Map<Field, List<Entity>> island, int width, int height) {
        this.island = island;
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Field getField(int x, int y) {
        for (Field field : island.keySet()) {
            if (field.getX() == x && field.getY() == y) {
                return field;
            }
        }
        throw new NoSuchElementException("Field not found at coordinates (" + x + ", " + y + ")");
    }

}