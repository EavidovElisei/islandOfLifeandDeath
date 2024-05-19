
import com.fasterxml.jackson.databind.ObjectMapper;
import config.EntityCharacteristicConfig;
import config.IslandConfig;
import config.PossibilityOfEatingConfig;

import models.Island;
import models.abstracts.Animal;
import models.abstracts.Entity;

import models.enums.EntityType;
import models.herbivores.Horse;
import models.herbivores.Mouse;
import models.island.Field;
import models.plants.Grass;
import models.predators.Bear;
import models.predators.Wolf;
import service.MoveService;
import service.impl.ChooseDirectionServiceImpl;
import service.impl.EatingService;
import service.impl.MoveServiceImpl;
import service.impl.MultiplyService;

import java.io.IOException;
import java.util.*;

import static consts.Consts.*;

public class Main {



    public static void main(String[] args) throws IOException {
        Random random = new Random();
        ObjectMapper objectMapper = new ObjectMapper();
        EntityCharacteristicConfig entityCharacteristicConfig = new EntityCharacteristicConfig(objectMapper, ENTITY_CHARACTERISTIC_JSON_PATH);
        PossibilityOfEatingConfig possibilityOfEatingConfig = new PossibilityOfEatingConfig(objectMapper, POSIBILLITY_OF_EATING_JSON_PATH);
        IslandConfig islandConfig = new IslandConfig(SETTINGS_PROPERTIES_PATH);
        ChooseDirectionServiceImpl chooseDirectionServiceImpl = new ChooseDirectionServiceImpl(random);
        Island island = createIsland(islandConfig);
        Island newIsland = createIsland(islandConfig);


        //вытягиваем макс колличество животных в поле
        int maxWolfsOnField = getMaxCountOnField(entityCharacteristicConfig, EntityType.WOLF);
        int maxPlantsOnField = getMaxCountOnField(entityCharacteristicConfig, EntityType.GRASS);
        int maxBearsOnField = getMaxCountOnField(entityCharacteristicConfig, EntityType.BEAR);
        int maxMousesOnField = getMaxCountOnField(entityCharacteristicConfig, EntityType.MOUSE);
        int maxHorsesOnField = getMaxCountOnField(entityCharacteristicConfig, EntityType.HORSE);


        //создаем рандомное колличесво травы, которое помещается на поле острова и пихаем в него
        //fill plants
        for (List<Entity> value : island.getIsland().values()) {

            var countOfPlants = random.nextInt(maxPlantsOnField);
            for (int i = 0; i < countOfPlants; i++) {
                Grass grass = createGrass(entityCharacteristicConfig);
                value.add(grass);
            }

        }
        //fill wolfs
        for (List<Entity> value : island.getIsland().values()) {

            var countOfWolfs = random.nextInt(maxWolfsOnField);
            for (int i = 0; i < countOfWolfs; i++) {
                Wolf wolf = createWolf(entityCharacteristicConfig);
                value.add(wolf);
            }
        }

        //fill bears
        for (List<Entity> value : island.getIsland().values()) {

            var countOfBears = random.nextInt(maxBearsOnField);
            for (int i = 0; i < countOfBears; i++) {
                Bear bear = createBear(entityCharacteristicConfig);
                value.add(bear);
            }
        }
        //fill mouses
        for (List<Entity> value : island.getIsland().values()) {

            var countOfMouses = random.nextInt(maxMousesOnField);
            for (int i = 0; i < countOfMouses; i++) {
                Mouse mouse = createMouse(entityCharacteristicConfig);
                value.add(mouse);
            }
        }

        //fill horses
        for (List<Entity> value : island.getIsland().values()) {

            var countOfHorses = random.nextInt(maxHorsesOnField);
            for (int i = 0; i < countOfHorses; i++) {
                Horse horse = createHorse(entityCharacteristicConfig);
                value.add(horse);
            }

        }

        MoveService moveService = new MoveServiceImpl(island);
        moveService.move(island);
        EatingService eatingService = new EatingService (island);
        eatingService.move(island, possibilityOfEatingConfig);
        MultiplyService multiplyService = new MultiplyService(island);
        multiplyService.MultiplyService(island);
    }

    private static Grass createGrass(EntityCharacteristicConfig entityCharacteristicConfig) {
        return new Grass(
                entityCharacteristicConfig.getCharacteristicMapConfig().get(EntityType.GRASS));
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









    private static Integer getMaxCountOnField(EntityCharacteristicConfig entityCharacteristicConfig, EntityType entityType) {
        return entityCharacteristicConfig
                .getCharacteristicMapConfig()
                .get(entityType)
                .getMaxCountOnField();
    }
    //вытягиваем максимальное колличество шагов у волка
    private static Integer getMaxSpeedOfWolf(EntityCharacteristicConfig entityCharacteristicConfig, EntityType entityType) {
        return entityCharacteristicConfig
                .getCharacteristicMapConfig()
                .get(entityType)
                .getSpeed();
    }

    private static Island createIsland(IslandConfig islandConfig) {
        Map<Field, List<Entity>> island = new HashMap<>();
        for (int i = 0; i < islandConfig.getHeight(); i++) {
            for (int j = 0; j < islandConfig.getWidth(); j++) {
                Field field = new Field(i,j);
                island.put(field, new ArrayList<>());
            }
        }
        return new Island(island, islandConfig.getWidth(), islandConfig.getHeight());
    }


}
