package Flyweight;

import java.io.Serial;
import java.io.Serializable;

public class CharacterProperties implements Serializable { // flyweight object
    @Serial
    private static final long serialVersionUID = 1L; // Add this line
    private final String font;
    private final String color;
    private final int size;

    public CharacterProperties(String font, String color, int size) {
        this.font = font;
        this.color = color;
        this.size = size;
    }


    public String getFont() {
        return font;
    }

    public String getColor() {
        return color;
    }

    public int getSize() {
        return size;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        CharacterProperties other = (CharacterProperties) obj;
        return font.equals(other.font) && color.equals(other.color) && size == other.size;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + font.hashCode();
        result = 31 * result + color.hashCode();
        result = 31 * result + size;
        return result;
    }
}