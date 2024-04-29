package Flyweight;

import java.util.ArrayList;
import java.util.List;

public class Document {
    private final List<Character> characters;

    public Document() {
        this.characters = new ArrayList<>();
    }

    public void addCharacter(char value, CharacterProperties properties) {
        characters.add(new Character(value, properties));
    }

    public List<Character> getCharacters() {
        return characters;
    }
}