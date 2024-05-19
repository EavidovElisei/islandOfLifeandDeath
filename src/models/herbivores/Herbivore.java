package models.herbivores;


import models.abstracts.Animal;

public abstract class  Herbivore extends Animal {
    public boolean wasEaten;
    public Herbivore(double weight, int maxCountOnField, int speed, double kgToFullEating) {
        super(weight, maxCountOnField, speed, kgToFullEating);
        this.wasEaten = false;
    }
}
