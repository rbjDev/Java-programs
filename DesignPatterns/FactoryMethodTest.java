package DesignPatterns;

import java.io.File;
import java.util.List;

public class FactoryMethodTest {
    
    public static void main(String args[]){
        BatchProcessing batch = new BatchProcessing();
        batch.batchProcess("ABc.txt");
    }
}

class BatchProcessing{
    public void batchProcess(String filename){
        File file =  open(filename);
        TextParser parser =new TextParser(file);
        List<Record> list = parser.parse();
        processRecords();
        displayStatus();
        close();

    }

    private void close() {
        System.out.println("Closed file!!");
    }

    private void displayStatus() {
        System.out.println("All records persisted!!");
    }

    private void processRecords() {
        System.out.println("Processing records!!");
    }

    private File open(String filename) {
        System.out.println("Opening file :"+ filename);
        return null;
    }
}
