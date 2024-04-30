package config;

import abstracts.Entity;
import com.fasterxml.jackson.databind.ObjectMapper;
import enums.EntityType;

import java.util.HashMap;
import java.util.Map;

public  class EntityCharacteristicConfig {
    private Map<EntityType, Entity> entityMapConfig;

    public Map<EntityType, Entity> getEntityMapConfig() {
        return entityMapConfig;
    }

    public EntityCharacteristicConfig(ObjectMapper objectMapper, String pathToJson){
        HashMap<EntityType, Entity> entityMapConfig = new HashMap<>();
        entityMapConfig.put(EntityType.GRASS, new Entity(10.0, 10, 10, 10.0) {
        });
        this.entityMapConfig = entityMapConfig;
        //сверху заглушка!
        //todo код, который парсит json file в entityMapConfig


    }
}
