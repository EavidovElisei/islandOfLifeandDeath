package service.impl;

import config.PossibilityOfEatingConfig;
import consts.Consts;
import models.Island;
import models.abstracts.Animal;
import models.abstracts.Entity;
import models.enums.DirectionType;
import models.herbivores.Herbivore;
import models.island.Field;
import models.plants.Grass;
import models.plants.Plant;
import models.predators.Predator;
import models.predators.Wolf;


import java.util.*;

public class EatingService {
    Random random = new Random();
    private PossibilityOfEatingConfig possibilityOfEatingConfig ;

    public EatingService(Island island) {
    }
    public Island move(Island island, PossibilityOfEatingConfig possibilityOfEatingConfig) {
        Island newIsland = createNewIsland(island);



        for (Map.Entry<Field, List<Entity>> entry : island.getIsland().entrySet()) {
            Field field = entry.getKey();
            List<Entity> entities = entry.getValue();
            List<Entity> listWithPredators = new ArrayList<>();
            List<Entity> listWithHerbivores = new ArrayList<>();
            List<Entity> listWithPlants = new ArrayList<>();

            List<Entity> entitiesForFieldTo = newIsland.getIsland().get(field);
            // собираем группы животных
            for (Entity entity : entities) {

                if (!(entity instanceof Animal animal)) {
                    listWithPlants.add(entity);
                    entitiesForFieldTo.add(entity);
                    continue;
                }
                if (animal instanceof Predator) {
                    listWithPredators.add(entity);
                    continue;
                }
                if (animal instanceof Herbivore) {
                    listWithHerbivores.add(entity);
                    continue;
                }
            }
            // кормим и перемещаем в новый остров хищников
            for (int i = 0; i < listWithPredators.size(); i++) {
                Predator predator = (Predator) listWithPredators.get(i);
                boolean predatorWasEat = false;
                for (int j = 0; j < listWithHerbivores.size(); j++) {
                    Herbivore herbivore = (Herbivore) listWithHerbivores.get(j);
                    if (herbivore.died == true) {
                        continue;
                    }
                    if (possibilityOfEatingConfig.canEat(predator, herbivore)) {
                        predator.setHealthPercent(predator.getHealthPercent() + IncrementHealthPercent(predator, herbivore));
                        predatorWasEat = true;
                        herbivore.died = true;
                    }
                    break;
                }
                if (!predatorWasEat && !predator.died) {
                    predator.setHealthPercent(predator.getHealthPercent() - Consts.LIFE_PERCENT_INCREMENT );
                    if (predator.getHealthPercent() <= 0) {
                        predator.died = true;
                    }
                }
                if (!predator.died) {
                    entitiesForFieldTo.add(predator);
                }
            }
            // кормим и перемещаем в новый остров травоядных
            for (int i = 0; i < listWithHerbivores.size(); i++) {
                Herbivore herbivore = (Herbivore) listWithHerbivores.get(i);
                if (herbivore.died == true) {
                    continue;
                } else {
                    //поел или нет
                    boolean HerbivoreWasEat = false;
                    for (int j = 0; j < listWithPlants.size(); j++) {
                        Plant grass = (Plant) listWithPlants.get(j);

                        if (grass.died == true) {
                            continue;
                        } else {
                            herbivore.setHealthPercent(herbivore.getHealthPercent() + IncrementHealthPercent(herbivore, grass));
                            HerbivoreWasEat = true;
                            grass.died = true;
                        }
                        break;
                    }
                    if (!HerbivoreWasEat && !herbivore.died) {
                        herbivore.setHealthPercent(herbivore.getHealthPercent() - Consts.LIFE_PERCENT_INCREMENT );
                        if (herbivore.getKgToFullEating() <= 0) {
                            herbivore.died = true;
                        }
                    }
                    if (!herbivore.died) {
                        entitiesForFieldTo.add(herbivore);

                    }



                }

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

    public int getRandomFrom100(Random random) {
        int randomNumberFrom100 = random.nextInt(100);
        return randomNumberFrom100;
    }

    public int IncrementHealthPercent(Entity isEating, Entity hasBeenEating){
        //int incrementHealthPercent = (int) ((Consts.MAX_PERCENT /hasBeenEating.getWeight())*isEating.getKgToFullEating());
        int incrementHealthPercent = (int) ((Consts.MAX_PERCENT /isEating.getKgToFullEating())*hasBeenEating.getWeight());

        return incrementHealthPercent;
    }



}
















