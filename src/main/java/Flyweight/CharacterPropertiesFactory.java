package Flyweight;

import java.util.HashMap;
import java.util.Map;

public class CharacterPropertiesFactory { // flyweight factory
    private static final Map<CharacterProperties, CharacterProperties> propertiesPool = new HashMap<>();

    public static CharacterProperties getCharacterProperties(String font, String color, int size) {
        CharacterProperties properties = new CharacterProperties(font, color, size);
        CharacterProperties existingProperties = propertiesPool.get(properties);
        if (existingProperties != null) {
            return existingProperties;
        } else {
            propertiesPool.put(properties, properties);
            return properties;
        }
    }
}