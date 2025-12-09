package SolidPrinciple.practice.documentEditor.goodDesing;

import java.util.List;

public class DocumentRenderer {
    private Document document;
    private String renderedDoc;
    DocumentRenderer(Document document){
        this.document = document;
        this.renderedDoc = "";
    }
    public String render(){
        List<DocElement> docElementList = this.document.getElements();
        if(renderedDoc.isEmpty()){
            StringBuilder documentData = new StringBuilder();
            for(DocElement element: docElementList){
                if(element.render().endsWith(".jpg") || element.render().endsWith(".png")){
                    documentData.append("[image: ").append(element.render()).append(" ]\n");
                }else{
                    documentData.append(element.render()).append("\n");
                }
                renderedDoc = documentData.toString();
            }
        }
        System.out.println(renderedDoc);
        return this.renderedDoc;
    }
}
