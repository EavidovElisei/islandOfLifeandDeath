package models.predators;
import models.abstracts.Entity;
import service.AnimalAction;

public class Wolf extends Predator implements AnimalAction {
    int Index = 0;




    public Wolf(double weight,
                int maxCountOnField,
                int speed,
                double kgToFullEating) {
        super(weight, maxCountOnField, speed, kgToFullEating);
    }

    public Wolf (Entity entity){
        super(entity.getWeight(), entity.getMaxCountOnField(), entity.getSpeed(),entity.getKgToFullEating());
    }
    public int GetIndex(){
        return Index;
    }


}
