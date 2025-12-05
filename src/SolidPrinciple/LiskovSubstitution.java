package SolidPrinciple;

class Document{
    private String data;
    public Document(String data){
        this.data = data;
    }

    public void openDocument(){
        System.out.println(this.data);
    }

    public void saveDocument(String data){
        this.data = data;
        System.out.println("Data saved successfully.");
    }

    public String getData(){
        return this.data;
    }
}

class ReadOnlyDocument extends Document{

    public ReadOnlyDocument(String data) {
        super(data);
    }

    @Override
    public void saveDocument(String data){
        throw new UnsupportedOperationException("Read only document.");
    }

}

class DocumentProcessor{

    public void saveNProcess(Document document, String additionalInfo){
        document.openDocument();
        String currentData = document.getData() + "\nProcessed " + additionalInfo;
        document.saveDocument(currentData);
        System.out.println("Document saved successfully.");
    }

}

public class LiskovSubstitution {
    public static void main(String[] args) {
        Document publicDocument = new Document("The power of learning...");
        DocumentProcessor documentProcessor = new DocumentProcessor();

        System.out.println("--- Processing Regular Document ---");

        documentProcessor.saveNProcess(publicDocument, "How to learn fast");

        System.out.println("\n--- Processing ReadOnly Document ---");

        ReadOnlyDocument readOnly = new ReadOnlyDocument("Personal loan contract");
        try {
            documentProcessor.saveNProcess(readOnly, "Loan interest is zero.");
        }catch (UnsupportedOperationException unsupportedOperationException){
            System.out.println(unsupportedOperationException);
        }



        // LSP
        System.out.println("--------- SLP --------");
        Documents readOnlyDocument = new ReadOnlyDocuments("Loan Document term & condition");
        Documents readWriteDocument = new EditableDocument("Open suggestion for health care");

        DocumentProcessors documentProcessors = new DocumentProcessors();
        documentProcessors.process(readOnlyDocument);
        documentProcessors.processAndSave(readWriteDocument, "Meditation, mastery, Movement");
    }
}

class DocumentProcessors{
    public void process(Documents documents){
        documents.open();
    }

    public void processAndSave(Documents documents,  String additionalData) {
        if(!(documents instanceof EditableDocument editableDocument)){
            throw new IllegalArgumentException("Do not have access to read");
        }

        editableDocument.open();
        String currentData = editableDocument.getData();
        String newData = currentData + "Processed | " + additionalData;
        editableDocument.save(newData);
        System.out.println("Document edited successfully.");
    }
}

class DocumentProcessor1 {
    public void process(Document doc) {
        doc.openDocument();
        System.out.println("Document processed.");
    }

    public void processAndSave(Document doc, String additionalInfo) {
        if (!(doc instanceof Editable editableDoc)) {
            throw new IllegalArgumentException("Document is not editable.");
        }

        doc.openDocument();
        String currentData = doc.getData();
        String newData = currentData + " | Processed: " + additionalInfo;
        editableDoc.save(newData);
        System.out.println("Editable document processed and saved.");
    }
}

interface Documents{
    void open();
    String getData();
}

interface Editable{
    void save(String data);
}

class EditableDocument implements Documents, Editable{
    private String data;

    EditableDocument(String data){
        this.data = data;
    }

    @Override
    public void open() {
        System.out.println(preview());
    }

    @Override
    public String getData() {
        return data;
    }

    @Override
    public void save( String data) {
        this.data = data;
    }


    private String preview(){
        return "Preview document " + data.substring(0, 5) + "...";
    }
}

class ReadOnlyDocuments implements Documents{
    private String data;

    ReadOnlyDocuments(String data){
        this.data = data;
    }

    @Override
    public void open() {
        System.out.println(preview());
    }

    @Override
    public String getData() {
        return data;
    }

    private String preview(){
        return "Preview document " + data.substring(0, 5) + "...";
    }
}

/** LRS: subclass should be substitute of parent class without altering/modifying the behaviour.
If S is the subclass of type T then any object of T should be used S without modifing/altering the program.
 */