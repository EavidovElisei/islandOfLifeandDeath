package models.plants;


import models.abstracts.Entity;

public class Grass extends Plant {
    int Index = 4;

    public Grass(Double weight,
                 Integer maxCountOnField,
                 Integer speed,
                 Double kgToFullEating) {
        super(weight, maxCountOnField, speed, kgToFullEating);
    }

    public Grass (Entity entity){
        super(entity.getWeight(), entity.getMaxCountOnField(), entity.getSpeed(),entity.getKgToFullEating());
    }
}
