package service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import config.EntityCharacteristicConfig;
import config.IslandConfig;
import config.PossibilityOfEatingConfig;
import consts.Consts;
import models.Island;
import models.abstracts.Animal;
import models.abstracts.Entity;
import models.enums.EntityType;
import models.herbivores.Horse;
import models.herbivores.Mouse;
import models.island.Field;
import models.plants.Grass;
import models.plants.Plant;
import models.predators.Bear;
import models.predators.Wolf;



import java.util.*;

import static consts.Consts.ENTITY_CHARACTERISTIC_JSON_PATH;
import static consts.Consts.POSSIBILITY_OF_REPRODUCTION_PERCENT;

public class MultiplyService {
    public MultiplyService() {
    }

    public MultiplyService(Island island) {

    }

    public Island MultiplyService(Island island) {
        ObjectMapper objectMapper = new ObjectMapper();
        EntityCharacteristicConfig entityCharacteristicConfig = new EntityCharacteristicConfig(objectMapper, ENTITY_CHARACTERISTIC_JSON_PATH);





        Island newIsland = createNewIsland(island);



        for (Map.Entry<Field, List<Entity>> entry : island.getIsland().entrySet()) {
            Field field = entry.getKey();
            List<Entity> entities = entry.getValue();

            int counterOfWolfs = 0;
            int counterOfBears = 0;
            int counterOfMouses = 0;
            int counterOfHorses = 0;


            List<Entity> entitiesForFieldTo = newIsland.getIsland().get(field);
            // собираем группы животных
            for (Entity entity : entities) {
                if(entity instanceof Plant){
                    entitiesForFieldTo.add(entity);


                }
                if(entity instanceof Wolf){
                    entitiesForFieldTo.add(entity);
                    if(((Wolf) entity).getHealthPercent()>POSSIBILITY_OF_REPRODUCTION_PERCENT){
                        counterOfWolfs++;
                    }

                }
                if(entity instanceof Bear){
                    entitiesForFieldTo.add(entity);
                    if(((Bear) entity).getHealthPercent()>POSSIBILITY_OF_REPRODUCTION_PERCENT){
                        counterOfBears++;
                    }
                }
                if(entity instanceof Mouse){
                    entitiesForFieldTo.add(entity);
                    if(((Mouse) entity).getHealthPercent()>POSSIBILITY_OF_REPRODUCTION_PERCENT){
                        counterOfMouses++;
                    }
                }
                if(entity instanceof Horse){
                    entitiesForFieldTo.add(entity);
                    if(((Horse) entity).getHealthPercent()>POSSIBILITY_OF_REPRODUCTION_PERCENT){
                        counterOfHorses++;
                    }
                }

            }
            for (int i = 0; i < counterOfWolfs-1; i = i + 2) {
                entitiesForFieldTo.add(createWolf(entityCharacteristicConfig));
            }
            for (int i = 0; i < counterOfBears-1; i = i + 2) {
                entitiesForFieldTo.add(createBear(entityCharacteristicConfig));
            }
            for (int i = 0; i < counterOfMouses-1; i = i + 2) {
                entitiesForFieldTo.add(createMouse(entityCharacteristicConfig));
            }
            for (int i = 0; i < counterOfHorses-1; i = i + 2) {
                entitiesForFieldTo.add(createHorse(entityCharacteristicConfig));

            }


            newIsland.getIsland().put(field, entitiesForFieldTo);

        }
        return newIsland;
    }




    public Island createNewIsland(Island island) {
        Map<Field, List<Entity>> newIsland = new HashMap<>();
        for (Map.Entry<Field, List<Entity>> entry : island.getIsland().entrySet()) {
            List<Entity> emptyList = new ArrayList<>();
            newIsland.put(entry.getKey(), emptyList);
        }
        return new Island(newIsland, island.getWidth(), island.getHeight());

    }


    private static Wolf createWolf(EntityCharacteristicConfig entityCharacteristicConfig) {
        return new Wolf(
                entityCharacteristicConfig.getCharacteristicMapConfig().get(EntityType.WOLF));
    }
    private static Bear createBear(EntityCharacteristicConfig entityCharacteristicConfig) {
        return new Bear(
                entityCharacteristicConfig.getCharacteristicMapConfig().get(EntityType.BEAR));
    }
    private static Mouse createMouse(EntityCharacteristicConfig entityCharacteristicConfig) {
        return new Mouse(
                entityCharacteristicConfig.getCharacteristicMapConfig().get(EntityType.MOUSE));
    }
    private static Horse createHorse(EntityCharacteristicConfig entityCharacteristicConfig) {
        return new Horse(
                entityCharacteristicConfig.getCharacteristicMapConfig().get(EntityType.HORSE));
    }

    



}
















