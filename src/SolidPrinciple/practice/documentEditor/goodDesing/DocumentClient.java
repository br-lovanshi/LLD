package SolidPrinciple.practice.documentEditor.goodDesing;

public class DocumentClient {
    public static void main(String[] args) {

        DocumentEditor documentEditor = new DocumentEditor(new Document(), new PersistInFile());
        documentEditor.addElement(new TextElement("This is heading"));
        documentEditor.addElement(new TextElement("This is another heading"));
        documentEditor.render();
        documentEditor.saveFile();

    }
}
