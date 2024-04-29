package Flyweight;

import java.io.Serial;
import java.io.Serializable;

public class Character implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L; // Required for serialization
    private final char value;
    private final CharacterProperties properties;

    public Character(char value, CharacterProperties properties) {
        this.value = value;
        this.properties = properties;
    }

    public char getValue() {
        return value;
    }

    public CharacterProperties getProperties() {
        return properties;
    }
}