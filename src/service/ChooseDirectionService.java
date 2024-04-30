package service;

import enums.DirectionType;

import java.util.Random;

public class ChooseDirectionService {
    private final Random random;

    public ChooseDirectionService(Random random) {
        this.random = random;
    }

    public DirectionType chooseDirection(Random random){
        random.nextInt(4);
        return DirectionType.values()[random.nextInt(DirectionType.values().length)];
    }

}
