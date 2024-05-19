package models.herbivores;

import models.abstracts.Entity;


public class Mouse extends Herbivore {
    int Index = 2;
    public Mouse(double weight,
                int maxCountOnField,
                int speed,
                double kgToFullEating) {
        super(weight, maxCountOnField, speed, kgToFullEating);
    }

    public Mouse (Entity entity){
        super(entity.getWeight(), entity.getMaxCountOnField(), entity.getSpeed(),entity.getKgToFullEating());
    }
}
