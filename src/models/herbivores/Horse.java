package models.herbivores;

import models.abstracts.Entity;


public class Horse extends Herbivore {
int Index = 3;
    public Horse(double weight,
                 int maxCountOnField,
                 int speed,
                 double kgToFullEating) {
        super(weight, maxCountOnField, speed, kgToFullEating);
    }

    public Horse (Entity entity){
        super(entity.getWeight(), entity.getMaxCountOnField(), entity.getSpeed(),entity.getKgToFullEating());
    }
}
