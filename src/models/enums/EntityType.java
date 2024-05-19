package models.enums;


import models.herbivores.Horse;
import models.herbivores.Mouse;
import models.plants.Grass;
import models.predators.Bear;
import models.predators.Wolf;

public enum EntityType {

    WOLF("wolf", Wolf.class, 0),
    BEAR("bear", Bear.class,1),
    // добавляем животных тут и в классы herbivore or predators or mb plants и экстендим
    MOUSE("mouse", Mouse.class,2),
    HORSE("horse", Horse.class,3),
    GRASS("grass", Grass.class ,4);




    private String type;
    private Class clazz;
    private int index;

    EntityType(String type, Class clazz, int index) {
        this.type = type;
        this.clazz = clazz;
        this.index = index;
    }

    public String getType() {
        return type;
    }

    public Class getClazz() {
        return clazz;
    }

    public int getIndex() {
        return index;
    }
}
