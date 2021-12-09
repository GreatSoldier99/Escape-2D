import java.io.*;
import java.util.*;
/**
 * RecordsManager. Esta clase permite administrar los records del juego
 * 
 * @author Victor Manuel Gómez Solis
 */
public class RecordsManager{
    private final int numMaxRecords;
    private final String nameFile;

    public RecordsManager(int maxRecords, String name){
        numMaxRecords=maxRecords;
        nameFile=name;
    }

    public void save(Record newRecord) {
        if (newRecord.getNamePlayer() == "")
            throw new RecordsException("Empty name not allowed");

        List<Record> records = getRecords();

        records.add(newRecord);

        records.sort((o1, o2) -> o2.getScorePlayer() - o1.getScorePlayer());

        try (FileWriter fileWriter = new FileWriter(nameFile);
             PrintWriter printWriter = new PrintWriter(fileWriter)) {
            int counter = 0;

            for(Record record: records){
                printWriter.append(record.getNamePlayer()).append(" ").print(record.getScorePlayer() + "\n");
                counter++;

                if(counter == numMaxRecords)
                    break;
            }
        } catch (IOException e) {
            e.printStackTrace();
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
