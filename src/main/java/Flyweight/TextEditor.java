package Flyweight;

import java.util.Scanner;

public class TextEditor {
    private final Document document;
    private final Scanner scanner;

    public TextEditor() {
        this.document = new Document();
        this.scanner = new Scanner(System.in);
    }

    public void createDocument() {
        System.out.print("Enter the text: ");
        String text = scanner.nextLine();

        for (char c : text.toCharArray()) {
            System.out.println(STR."Enter font for '\{c}':");
            String font = scanner.nextLine();
            System.out.println(STR."Enter color for '\{c}':");
            String color = scanner.nextLine();
            System.out.println(STR."Enter size for '\{c}':");
            int size = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            CharacterProperties properties = CharacterPropertiesFactory.getCharacterProperties(font, color, size);
            document.addCharacter(c, properties);
        }
    }

    public void displayDocument() {
        for (Character character : document.getCharacters()) {
            System.out.print(character.getValue());
            CharacterProperties properties = character.getProperties();
            System.out.println(STR." (Font: \{properties.getFont()}, Color: \{properties.getColor()}, Size: \{properties.getSize()})");
        }
    }

    public static void main(String[] args) {
        TextEditor textEditor = new TextEditor();
        textEditor.createDocument();
        textEditor.displayDocument();

        String txtFileName = "document.txt";
        FileManager.saveDocumentToTxt(textEditor.document, txtFileName);
        System.out.println(STR."\nDocument saved to \{txtFileName}");

        String datFileName = "document.dat";
        FileManager.saveDocument(textEditor.document, datFileName);
        System.out.println(STR."Document also saved to \{datFileName}");

        Document loadedDocument = FileManager.loadDocument(datFileName);
        System.out.println("\nLoaded document:");
        assert loadedDocument != null;
        for (Character character : loadedDocument.getCharacters()) {
            System.out.print(character.getValue());
            CharacterProperties properties = character.getProperties();
            System.out.println(STR." (Font: \{properties.getFont()}, Color: \{properties.getColor()}, Size: \{properties.getSize()})");
        }
    }
}