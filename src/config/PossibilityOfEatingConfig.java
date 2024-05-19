package config;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import models.abstracts.Entity;
import models.enums.EntityType;
import models.predators.Wolf;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;


public final class PossibilityOfEatingConfig {

    private int[][] possibilityOfEating;
    private Map<String, Integer> entityIndexMap;
    private int wolfIndex = 0;
    private int bearIndex = 1;
    private int mouseIndex= 2;
    private int horseIndex= 3;
    private int grassIndex= 4;

    public PossibilityOfEatingConfig(ObjectMapper objectMapper, String pathToJson) throws IOException {

        this.possibilityOfEating = new int[5][5];
        File file = new File(pathToJson);
        fillPossibilityOfEatingWithIndexes(objectMapper, file);

    }

    private void initializeEntityIndexMap() {
        entityIndexMap.put("wolf", EntityType.WOLF.getIndex());
        entityIndexMap.put("bear", EntityType.BEAR.getIndex());
        entityIndexMap.put("mouse", EntityType.MOUSE.getIndex());
        entityIndexMap.put("horse", EntityType.HORSE.getIndex());
        entityIndexMap.put("grass", EntityType.GRASS.getIndex());
    }

    public int[][] getPossibilityOfEating() {
        return possibilityOfEating;
    }

    private void fillPossibilityOfEating(ObjectMapper objectMapper, File file) throws IOException {
        JsonNode jsonNode = objectMapper.readTree(file);

        for (JsonNode entry : jsonNode) {
            String from = entry.get("from").asText();
            String to = entry.get("to").asText();
            int percent = entry.get("percent").asInt();

            int fromIndex = entityIndexMap.get(from);
            int toIndex = entityIndexMap.get(to);

            possibilityOfEating[fromIndex][toIndex] = percent;
        }
    }

    private void fillPossibilityOfEatingWithIndexes(ObjectMapper objectMapper, File file) throws IOException {
        JsonNode jsonNode = objectMapper.readTree(file);

        for (JsonNode entry : jsonNode) {
            String from = entry.get("from").asText();
            String to = entry.get("to").asText();
            int percent = entry.get("percent").asInt();
            int fromIndex = this.getIndexByName(from);
            int toIndex = this.getIndexByName(to);
            if (fromIndex == -1 || toIndex == -1) {
                continue;
            }
            possibilityOfEating[fromIndex][toIndex] = percent;
        }
    }

    private int getIndexByName(String name) {
        switch (name) {
            case "wolf": return wolfIndex;
            case "bear": return bearIndex;
            case "mouse": return mouseIndex;
            case "horse": return horseIndex;
            case "grass": return grassIndex;
            default:return -1;
        }
    }

    private int getIndexByClass(Entity entity) {
        switch (entity.getClass().getSimpleName()) {
            case "Wolf": return wolfIndex;
            case "Bear": return bearIndex;
            case "Mouse": return mouseIndex;
            case "Horse": return horseIndex;
            case "Grass": return grassIndex;
            default:return -1;
        }
    }
    public boolean canEat( Entity predator, Entity herbivore){
        int possibility = this.possibilityOfEating[getIndexByClass(predator)][getIndexByClass(herbivore)];
        Random random = new Random();
        int randomNumberFrom100 = random.nextInt(100);
        if(randomNumberFrom100 <= possibility){
            return true;
        }else{
            return false;
        }
    }
}





