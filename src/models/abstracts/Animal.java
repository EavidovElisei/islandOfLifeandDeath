package abstracts;

import service.AnimalAction;

public abstract class Animal extends Entity implements AnimalAction {
    public Animal(Double weight, Integer maxCountOnField, Integer speed, Double kgToFullEating) {
        super(weight, maxCountOnField, speed, kgToFullEating);
    }

    @Override
    public void move() {

    }

    @Override
    public void multiply() {

    }

    @Override
    public void chooseDirection() {

    }
// содержит поведение, общее для всех животных
}
