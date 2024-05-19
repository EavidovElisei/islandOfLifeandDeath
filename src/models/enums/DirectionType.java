package models.enums;

public enum DirectionType {
    LEFT("left",  -1),
    RIGHT("right", 1),
    UP("up", 1),
    DOWN("down", -1);

    private String type;
    private int step;


    DirectionType(String type, int step) {
        this.type = type;
        this.step = step;
    }

    public String getType() {
        return type;
    }

    public int getStep() {
        return step;
    }
}
