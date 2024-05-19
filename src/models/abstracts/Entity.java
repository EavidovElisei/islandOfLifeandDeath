package models.abstracts;

import consts.Consts;

public  class  Entity {

    protected double weight;
    protected int maxCountOnField;
    protected int speed;
    protected double kgToFullEating;
    public boolean died;

    public Entity(double weight, int maxCountOnField, int speed, double kgToFullEating) {
        this.weight = weight;
        this.maxCountOnField = maxCountOnField;
        this.speed = speed;
        this.kgToFullEating = kgToFullEating;
        this.died = false;
    }

    public double getWeight() {
        return weight;
    }



    public int getMaxCountOnField() {
        return maxCountOnField;
    }



    public int getSpeed() {
        return speed;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setMaxCountOnField(int maxCountOnField) {
        this.maxCountOnField = maxCountOnField;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setKgToFullEating(double kgToFullEating) {
        this.kgToFullEating = kgToFullEating;
    }

    public int IncrementHealthPercent(Entity isEating, Entity hasBeenEating){
        int IncrementHealthPercent = (int) ((Consts.MAX_PERCENT /hasBeenEating.getWeight())*isEating.getKgToFullEating());
        return IncrementHealthPercent;
    }


    public double getKgToFullEating() {
        return kgToFullEating;
    }


}
