package service.impl;

import config.IslandConfig;
import models.Island;
import models.abstracts.Animal;
import models.abstracts.Entity;
import models.enums.DirectionType;
import models.island.Field;
import service.MoveService;

import java.util.*;



public class MoveServiceImpl implements MoveService {
    Random random = new Random();

    private ChooseDirectionServiceImpl chooseDirectionServiceImpl;


    public MoveServiceImpl(Island island) {

        this.chooseDirectionServiceImpl = new ChooseDirectionServiceImpl(random);
    }


    public Island move(Island island) {
        Island newIsland = createNewIsland(island);


        for (Map.Entry<Field, List<Entity>> entry : island.getIsland().entrySet()) {
            Field field = entry.getKey();
            List<Entity> entities = entry.getValue();
            for (Entity entity : entities) {
                if (!(entity instanceof Animal animal)) {
                    List<Entity> entitiesForFieldTo = newIsland.getIsland().get(field);
                    //добавили к этому списку текущее животное
                    entitiesForFieldTo.add(entity);
                    //положили список в новое поле
                    newIsland.getIsland().put(field, entitiesForFieldTo);
                    continue;
                }
                if (animal.isMovedInThisLap) {
                    //entitiesLast.add(entity);
                    continue;
                }
                //расчитываем новые координаты для животного в методе calculateNewField
                animal.isMovedInThisLap = true;
                Field fieldTo = calculateNewField(field, animal, island);
                //получили список с животными в новом поле для перемещения
                List<Entity> entitiesForFieldTo = newIsland.getIsland().get(fieldTo);
                //добавили к этому списку текущее животное
                entitiesForFieldTo.add(animal);
                //положили список в новое поле
                newIsland.getIsland().put(fieldTo, entitiesForFieldTo);
            }
            //island.getIsland().put(field, entitiesLast);
        }
        return newIsland;
    }


    public Field calculateNewField(Field from, Animal animal, Island island) {
        int x = from.getX();
        int y = from.getY();

        for (int i = 0; i < animal.getSpeed(); i++) {
            DirectionType direction = chooseDirectionServiceImpl.chooseDirection(random);
            while (!canAnimalMove(x, y, direction, island)) {
                direction = chooseDirectionServiceImpl.chooseDirection(random);
            }

            if (direction == DirectionType.UP) {
                x--;
            } else if (direction == DirectionType.DOWN) {
                x++;
            } else if (direction == DirectionType.LEFT) {
                y--;
            } else if (direction == DirectionType.RIGHT) {
                y++;
            }
        }
        return island.getField(x, y);
    }

    public boolean canAnimalMove(int x, int y, DirectionType direction, Island island) {
        if (direction == DirectionType.UP && x > 0) {
            return true;
        }
        if (direction == DirectionType.DOWN && x < island.getHeight() - 1) {
            return true;
        }
        if (direction == DirectionType.LEFT && y > 0) {
            return true;
        }
        if (direction == DirectionType.RIGHT && y < island.getWidth() - 1) {
            return true;
        }
        return false;

    }

    public Island createNewIsland(Island island) {
        Map<Field, List<Entity>> newIsland = new HashMap<>();
        for (Map.Entry<Field, List<Entity>> entry : island.getIsland().entrySet()) {
            List<Entity> emptyList = new ArrayList<>();
            newIsland.put(entry.getKey(), emptyList);
        }
        return new Island(newIsland, island.getWidth(), island.getHeight());

    }
}
















