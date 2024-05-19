package models.predators;


import models.abstracts.Animal;
import service.AnimalAction;

public abstract class Predator extends Animal implements AnimalAction {
    public Predator(Double weight, Integer maxCountOnField, Integer speed, Double kgToFullEating) {
        super(weight, maxCountOnField, speed, kgToFullEating);
    }
}
