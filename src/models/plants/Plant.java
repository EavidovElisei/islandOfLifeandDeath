package models.plants;


import models.abstracts.Entity;

public abstract class Plant extends Entity {
    public boolean wasEaten;
    public Plant(Double weight, Integer maxCountOnField, Integer speed, Double kgToFullEating) {
        super(weight, maxCountOnField, speed, kgToFullEating);
        this.wasEaten = false;
    }
}
