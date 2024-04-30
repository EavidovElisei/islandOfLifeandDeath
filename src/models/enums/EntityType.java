package enums;

import herbivores.Horse;
import herbivores.Mouse;
import plants.Grass;
import plants.Plant;
import predators.Wolf;

public enum EntityType {
    GRASS("grass", Grass.class),
    WOLF("wolf", Wolf.class),
    // добавляем животных тут и в классы herbivore or predators or mb plants и экстендим
    MOUSE("mouse", Mouse.class),
    HORSE("horse", Horse.class);



    private String type;
    private Class clazz;

    EntityType(String type, Class clazz) {
        this.type = type;
        this.clazz = clazz;
    }
}
