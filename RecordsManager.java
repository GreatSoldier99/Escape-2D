import java.io.*;
import java.util.*;
/**
 * Write a description of class RecordsManager here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RecordsManager{
    private final int numMaxRecords;
    private int countRecords;
    private final String nameFile;

    public RecordsManager(int maxRecords, String name){
        numMaxRecords=maxRecords;
        nameFile=name;
        countRecords=0;
    }

    public void save(Record record) {
        if (record.getNamePlayer() == "")
            throw new RecordsException("Empty name not allowed");

        countRecords++;
        if (countRecords <= numMaxRecords){
            try (FileWriter fileWriter = new FileWriter(nameFile, true);
                 PrintWriter printWriter = new PrintWriter(fileWriter)) {
                printWriter.append(record.getNamePlayer()).append(" ").print(record.getScorePlayer() + "\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if(countRecords > numMaxRecords){
            this.saveInFullCase(record);
        }
    }

    public void saveInFullCase(Record record){
        int i;
        List<Record> auxRecords = this.getRecords();

        countRecords=0;

        try (FileWriter fileWriter = new FileWriter(nameFile);
             PrintWriter printWriter = new PrintWriter(fileWriter)) {
            printWriter.write("");
        } catch (IOException e) {
            e.printStackTrace();
        }
        auxRecords.remove(0);

        this.save(record);
        for(i=0;i<numMaxRecords-1;i++){
            this.save(auxRecords.get(i));
        }
    }

    public List<Record> getRecords(){
        List<Record> records = new ArrayList<Record>();

        try(BufferedReader reader = new BufferedReader(new FileReader(nameFile))){
            String currentLine;

            while((currentLine=reader.readLine()) != null){
                String[] items = currentLine.split(" ");

                records.add(new Record(items[0], Integer.parseInt(items[1])));
            }
        }catch (IOException e) {
            e.printStackTrace();
        }

        return records;
    }
}
