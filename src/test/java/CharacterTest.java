import Flyweight.Character;
import Flyweight.CharacterProperties;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CharacterTest {
    @Test
    public void testCharacterConstructor() {
        char value = 'A';
        String font = "Arial";
        String color = "Black";
        int size = 12;

        CharacterProperties properties = new CharacterProperties(font, color, size);
        Character character = new Character(value, properties);

        assertEquals(value, character.getValue());
        assertEquals(properties, character.getProperties());
    }

    @Test
    public void testGetValue() {
        char value = 'B';
        String font = "Times New Roman";
        String color = "Red";
        int size = 14;

        CharacterProperties properties = new CharacterProperties(font, color, size);
        Character character = new Character(value, properties);

        assertEquals(value, character.getValue());
    }

    @Test
    public void testGetProperties() {
        char value = 'C';
        String font = "Courier";
        String color = "Blue";
        int size = 10;

        CharacterProperties properties = new CharacterProperties(font, color, size);
        Character character = new Character(value, properties);

        assertEquals(properties, character.getProperties());
    }
}