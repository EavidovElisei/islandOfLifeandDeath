package config;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import models.abstracts.Entity;
import models.enums.EntityType;
import models.herbivores.Horse;
import models.herbivores.Mouse;
import models.plants.Grass;
import models.predators.Bear;
import models.predators.Wolf;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


public  class EntityCharacteristicConfig {
    private Map<EntityType, Entity> characteristicMapConfig;


    public EntityCharacteristicConfig(ObjectMapper objectMapper, String pathToJson) {
        this.characteristicMapConfig = new HashMap<>();
        File file = new File(pathToJson);
        fillEntityTypeEntityValueToMap(objectMapper, file);
    }

    public Map<EntityType, Entity> getCharacteristicMapConfig() {
        return characteristicMapConfig;
    }


    private    Map<EntityType, Entity> fillEntityTypeEntityValueToMap(ObjectMapper objectMapper, File file) {
        Entity entity;
        for (EntityType value : EntityType.values()) {
            try {
                JsonNode jsonNode = objectMapper.readTree(file);
                JsonNode specificObject = jsonNode.get(value.getType());


                double weight = specificObject.get("weight").asDouble();

                int maxCountOnField = specificObject.get("maxCountOnField").asInt();
                int speed = specificObject.get("speed").asInt();
                double kgToFullEating = specificObject.get("kgToFullEating").asDouble();
                switch (value){
                    case WOLF:
                        entity = new Wolf(weight, maxCountOnField, speed, kgToFullEating);
                        break;
                    case BEAR:
                        entity = new Bear(weight, maxCountOnField, speed, kgToFullEating);
                        break;
                    case HORSE:
                        entity = new Horse(weight, maxCountOnField, speed, kgToFullEating);
                        break;
                    case MOUSE:
                        entity = new Mouse(weight, maxCountOnField, speed, kgToFullEating);
                        break;
                    case GRASS:
                        entity = new Grass(weight, maxCountOnField, speed, kgToFullEating);
                        break;
                    default:
                        entity = new Entity(weight, maxCountOnField, speed, kgToFullEating);
                }

            } catch (IOException  exception) {
                throw new RuntimeException(exception);
            }
            this.characteristicMapConfig.put(value,  entity);

        }
        return characteristicMapConfig;
    }


}


        //        HashMap<EntityType, Entity> entityMapConfig = new HashMap<>();
//        entityMapConfig.put(EntityType.GRASS, new Entity(10.0, 20, 10, 10.0) {
//        });
//        entityMapConfig.put(EntityType.WOLF, new Entity(100.0, 10, 30, 20.0) {
//        });
//        entityMapConfig.put(EntityType.BEAR, new Entity(1000.0, 5, 30, 20.0) {
//        });
//        entityMapConfig.put(EntityType.MOUSE, new Entity(100.0, 10, 30, 20.0) {
//        });
//        entityMapConfig.put(EntityType.HORSE, new Entity(100.0, 10, 30, 20.0) {
//        });
//
//
//        this.entityMapConfig = entityMapConfig;
//        //сверху заглушка!
//        //todo код, который парсит json file в entityMapConfig
//
//
//    }



