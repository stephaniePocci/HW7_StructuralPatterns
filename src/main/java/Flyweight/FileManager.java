package Flyweight;

import java.io.*;
import java.util.List;

public class FileManager {
    public static void saveDocument(Document document, String fileName) {
        try (FileOutputStream fileOut = new FileOutputStream(fileName);
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(document.getCharacters());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void saveDocumentToTxt(Document document, String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            List<Character> characters = document.getCharacters();
            for (Character character : characters) {
                writer.write(character.getValue());
                CharacterProperties properties = character.getProperties();
                writer.write(STR." (Font: \{properties.getFont()}, Color: \{properties.getColor()}, Size: \{properties.getSize()})");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static Document loadDocument(String fileName) {
        try (FileInputStream fileIn = new FileInputStream(fileName);
             ObjectInputStream in = new ObjectInputStream(fileIn)) {
            List<Character> characters = (List<Character>) in.readObject();
            Document document = new Document();
            for (Character character : characters) {
                document.addCharacter(character.getValue(), character.getProperties());
            }
            return document;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}