package plants;

import abstracts.Entity;

public class Grass extends Plant {

    public Grass(Double weight,
                 Integer maxCountOnField,
                 Integer speed,
                 Double kgToFullEating) {
        super(weight, maxCountOnField, speed, kgToFullEating);
    }

    public Grass (Entity entity){
        super(entity.getWeight(), entity.getMaxCountOnField(), entity.getSpeed(),entity.getKgToFullEating());
    }
}
