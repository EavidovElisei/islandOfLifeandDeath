package models.abstracts;

import service.AnimalAction;

public abstract class Animal extends Entity implements AnimalAction {
    protected int healthPercent;
    public boolean isMovedInThisLap;
    protected boolean inNewBornAnimal;




    protected Animal(double weight, int maxCountOnField, int speed, double kgToFullEating) {

        super(weight, maxCountOnField, speed, kgToFullEating);
        this.healthPercent = 100;
        this.isMovedInThisLap = false;
        this.inNewBornAnimal = false;

    }

    public int getHealthPercent() {
        return healthPercent;
    }

    public void setHealthPercent(int healthPercent) {
        this.healthPercent = healthPercent;
    }

    public boolean isMovedInThisLap() {
        return isMovedInThisLap;
    }

    public void setMovedInThisLap(boolean movedInThisLap) {
        isMovedInThisLap = movedInThisLap;
    }

    public boolean isInNewBornAnimal() {
        return inNewBornAnimal;
    }

    public void setInNewBornAnimal(boolean inNewBornAnimal) {
        this.inNewBornAnimal = inNewBornAnimal;
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
