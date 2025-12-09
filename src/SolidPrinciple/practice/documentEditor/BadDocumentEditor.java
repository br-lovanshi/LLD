package SolidPrinciple.practice;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class DocumentEditor{
    private List<String> elements;
    private String renderedDoc;

    DocumentEditor(){
        this.elements = new ArrayList<>();
        this.renderedDoc = "";
    }

    public void addLine(){
        elements.add("\n");
    }

    public void addSpace(){
        elements.add(" ");
    }

    public void addText(String text){
        elements.add(text);
    }

    public void addImage(String image){
        elements.add(image);
    }

    public void saveToFile(){
        // logic to save into file
        try{
        FileWriter fileWriter = new FileWriter("LldDocument.txt");
        fileWriter.write(renderDoc());
        fileWriter.close();
            System.out.println("Document saved successfully.");
        }catch (IOException ioException){
            System.out.println(ioException.getMessage());
        }
    }

    public String renderDoc(){
        // logic to render doc
        StringBuilder result = new StringBuilder();
        if(renderedDoc.isEmpty()){
            for(String element : elements){
                if(element.length() > 4 && (element.endsWith(".jpg")) || element.endsWith(".png")){
                    result.append("[image: ").append(element).append(" ]").append("\n");
                }else{
                    result.append(element).append("\n");
                }
                renderedDoc = result.toString();
            }
        }

        return renderedDoc;
    }
}

public class BadDocumentEditor {

    public static void main(String[] args) {

        DocumentEditor documentEditor = new DocumentEditor();
        documentEditor.addText("Core java important concept");
        documentEditor.addLine();
        documentEditor.addImage("coreJava.png");
        documentEditor.addText("1. Oops");
        documentEditor.addSpace();
        documentEditor.addText("2. Multithreading");
        documentEditor.addSpace();

        String renderedDoc = documentEditor.renderDoc();
        System.out.println(renderedDoc);
        documentEditor.saveToFile();
    }
}
