package SolidPrinciple.practice.documentEditor.goodDesing;

import java.io.FileWriter;
import java.io.IOException;

public class PersistInFile implements Persistence{
    @Override
    public void save(String document) {
        try{
            FileWriter fileWriter = new FileWriter("GoodLld.txt");
            fileWriter.write(document);
            fileWriter.close();
        }catch (IOException ioException){
            System.out.println(ioException.getMessage());
        }
    }
}
