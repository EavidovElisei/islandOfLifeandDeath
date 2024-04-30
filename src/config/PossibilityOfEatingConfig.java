package config;

import abstracts.Entity;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Map;


public class PossibilityOfEatingConfig {

    //реализация % вероятности поедания животных
    private Map <Map<Entity, Entity>,Long> possibilityOfEating;
    //(wolf to mouse = 80)

    public PossibilityOfEatingConfig(ObjectMapper objectMapper, String pathToJson) {
        this.possibilityOfEating = possibilityOfEating;
        // заполняем наш possibilityOfEating из нашего Json
    }
}
