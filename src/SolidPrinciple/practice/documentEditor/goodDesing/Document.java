package SolidPrinciple.practice.documentEditor.goodDesing;

import java.util.ArrayList;
import java.util.List;

public class Document {
    private List<DocElement> docElementList;

    public Document(){
        this.docElementList = new ArrayList<>();
    }

    public void addElement(DocElement docElement){
        this.docElementList.add(docElement);
    }

    public List<DocElement> getElements(){
        return this.docElementList;
    }

}
