import abstracts.Entity;
import com.fasterxml.jackson.databind.ObjectMapper;
import config.EntityCharacteristicConfig;
import config.FieldSizeConfig;
import config.PossibilityOfEatingConfig;
import enums.EntityType;
import island.Field;
import plants.Grass;
import service.ChooseDirectionService;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        //Map<Field, List<Entity>> island = new HashMap<>();
        Random random = new Random();


        ObjectMapper objectMapper = new ObjectMapper();

        EntityCharacteristicConfig entityCharacteristicConfig = new EntityCharacteristicConfig(objectMapper, "resources/posibillity_of_eating.json");

        PossibilityOfEatingConfig possibilityOfEatingConfig = new PossibilityOfEatingConfig(objectMapper, "resources/posibillity_of_eating.json" );

        FieldSizeConfig fieldSizeConfig = new FieldSizeConfig(20, 5);
        ChooseDirectionService chooseDirectionService = new ChooseDirectionService(random);

        Island island = createIsland(fieldSizeConfig);

        System.out.println(fieldSizeConfig);
        int maxPlantsOnField = getMaxCountOnField(entityCharacteristicConfig,EntityType.GRASS);
        //int maxWolfsOnField = getMaxCountOnField(entityCharacteristicConfig, EntityType.WOLF);

        //создаем рандомное колличесво травы, которое помещается на поле острова и пихаем в него
        for (List<Entity> value : island.getIsland().values()) {

            var countOfPlants = random.nextInt(maxPlantsOnField);
            for (int i = 0; i < countOfPlants; i++) {
                Grass grass = createGrass(entityCharacteristicConfig);
                value.add(grass);
            }
            System.out.println(island);
        }


        //вытягиваем из json макс колличество травы на поле


    }

    private static Grass createGrass(EntityCharacteristicConfig entityCharacteristicConfig) {
        return new Grass(
                entityCharacteristicConfig.getEntityMapConfig().get(EntityType.GRASS));
    }




    private static Integer getMaxCountOnField(EntityCharacteristicConfig entityCharacteristicConfig, EntityType entityType) {
        return entityCharacteristicConfig
                .getEntityMapConfig()
                .get(entityType)
                .getMaxCountOnField();
    }

    private static Island createIsland(FieldSizeConfig fieldSizeConfig ) {
        Map<Field, List<Entity>> island = new HashMap<>();
        for (int i = 0; i < fieldSizeConfig.getHeight(); i++) {
            for (int j = 0; j < fieldSizeConfig.getWidth(); j++) {
                Field field = new Field(i,j);
                island.put(field, new ArrayList<>());
            }
        }
        return new Island(island);
    }
}
