package models.predators;
import models.abstracts.Entity;

public class Bear extends Predator {
    int Index = 1;





    public Bear(double weight,
                int maxCountOnField,
                int speed,
                double kgToFullEating) {
        super(weight, maxCountOnField, speed, kgToFullEating);
    }

    public Bear (Entity entity){
        super(entity.getWeight(), entity.getMaxCountOnField(), entity.getSpeed(),entity.getKgToFullEating());
    }


}
