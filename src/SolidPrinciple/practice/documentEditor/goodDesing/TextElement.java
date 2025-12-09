package SolidPrinciple.practice.documentEditor.goodDesing;

public class TextElement implements DocElement{
    private String element;
    TextElement(String data){
        this.element = data;
    }
    @Override
    public String render() {
        return this.element;
    }
}
