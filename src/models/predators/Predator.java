package predators;

import abstracts.Animal;

public abstract class Predator extends Animal {
    public Predator(Double weight, Integer maxCountOnField, Integer speed, Double kgToFullEating) {
        super(weight, maxCountOnField, speed, kgToFullEating);
    }
}
