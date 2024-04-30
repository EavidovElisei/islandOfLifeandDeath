package herbivores;

import abstracts.Animal;

public abstract class  Herbivore extends Animal {
    public Herbivore(Double weight, Integer maxCountOnField, Integer speed, Double kgToFullEating) {
        super(weight, maxCountOnField, speed, kgToFullEating);
    }
}
