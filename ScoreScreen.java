import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * ScoreScreen. Esta clase despliega la pantalla donde se veran los records guardados del juego (si los hay).
 * 
 * @author Victor Manuel Gómez Solis
 */
public class ScoreScreen extends World{
    private GreenfootImage bgImage = new GreenfootImage("Fondo.png");
    
    private static final int maxRecords = 5;
    private static final String nameFile = "Records.txt";
    private static RecordsManager recordsManager = new RecordsManager(maxRecords,nameFile);
    
    private static final String titleText = "MEJORES PUNTAJES\n|Nombre|     |Puntaje|";
    private static final Color textColor = Color.RED;
    private static final Color outlineColor = Color.BLACK;
    private static Label titleLabel = new Label(titleText,textColor,outlineColor);
    
    private static int positionX = 325;
    private static int positionY = 200;
    
    public ScoreScreen(){    
        super(700, 450, 1);
        setBackground(bgImage);
        addObject(titleLabel,350,112);
        displayRecords();
    }
    
    public void displayRecords(){
        List<Record> records = new ArrayList<Record>();
        
        records = recordsManager.getRecords();
        for(Record record : records){
            Label labelRecord = new Label(record);
            addObject(labelRecord,positionX,positionY);
            positionY+=50;
        }
    }
}
