package SolidPrinciple.practice.documentEditor.goodDesing;

import java.util.List;

public class DocumentEditor {
    private Persistence persistence;
    private Document document;
    private String renderedDocument;

    DocumentEditor(Document document, Persistence persistence){
        this.document = document;
        this.persistence = persistence;
        this.renderedDocument = "";
    }
    public void addElement(DocElement docElement){
        this.document.addElement(docElement);
    }

    public List<DocElement> getElements(){
        return this.document.getElements();
    }

    public void render(){
        List<DocElement> docElementList = this.document.getElements();
        if(renderedDocument.isEmpty()){
            StringBuilder documentData = new StringBuilder();
            for(DocElement element: docElementList){
                if(element.render().endsWith(".jpg") || element.render().endsWith(".png")){
                    documentData.append("[image: ").append(element.render()).append(" ]\n");
                }else{
                    documentData.append(element.render()).append("\n");
                }
                renderedDocument = documentData.toString();
            }
        }
        System.out.println(this.renderedDocument);
    }

    public void saveFile(){
        this.persistence.save(this.renderedDocument);
    }

}
