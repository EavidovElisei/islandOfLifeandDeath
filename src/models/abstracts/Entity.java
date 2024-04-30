package abstracts;

public  class  Entity {
    private Double weight;
    private Integer maxCountOnField;
    private Integer speed;
    private Double kgToFullEating;

    public Entity(Double weight, Integer maxCountOnField, Integer speed, Double kgToFullEating) {
        this.weight = weight;
        this.maxCountOnField = maxCountOnField;
        this.speed = speed;
        this.kgToFullEating = kgToFullEating;
    }

    public Double getWeight() {
        return weight;
    }



    public Integer getMaxCountOnField() {
        return maxCountOnField;
    }



    public Integer getSpeed() {
        return speed;
    }



    public Double getKgToFullEating() {
        return kgToFullEating;
    }


}
