import greenfoot.*;
import java.util.*;

/**
 * ScoreScreen. Esta clase despliega la pantalla donde se veran los records guardados del juego (si los hay).
 * 
 * @author Victor Manuel Gómez Solis
 */
public class ScoreScreen extends World implements Observer{
    private static GreenfootSound music = new GreenfootSound("intro.mp3");
    private static GreenfootImage background = new GreenfootImage("fondo.png");
    
    private static final int MAX_RECORDS = 5;
    private static final String NAME_FILE = "Records.txt";
    private static RecordsManager recordsManager = new RecordsManager(MAX_RECORDS,NAME_FILE);
    
    private static final String TEXT_TITLE = "MEJORES PUNTAJES\n|Nombre|     |Puntaje|";
    private static final Color TEXT_COLOR = Color.RED;
    private static final Color OUTLINE_COLOR = Color.BLACK;
    private static Label titleLabel = new Label(TEXT_TITLE,TEXT_COLOR,OUTLINE_COLOR);
    
    private int positionX = 325;
    private int positionY = 200;
    
    private BackButton backButton = new BackButton();
    
    /**
     * ScoreScreen. Constructor de la clase con el mismo nombre, al construirse la pantalla ocurre lo siguiente:
     * -Se coloca la imagen de fondo de la pantalla.
     * -Se agrega el titulo de la pantalla y etiquetas para los records.
     * -Se despliegan los records almacenados.
     * -Se agrega el botón de regresa.
     */
    public ScoreScreen(){    
        super(700, 450, 1);
        music.setVolume(50);
        setBackground(background);
        addObject(titleLabel,350,112);
        displayRecords();
        addObject(backButton,30,225);
    }
    
    /**
     * act. Este método se encarga de:
     * -Ajustar el volumen y reproducir la música de la pantalla de records.
     * -Verificar si se hace click con el mouse en el backButton.
     */
    public void act(){
        music.play();
        
        if(Greenfoot.mouseClicked(backButton)){
            eventOcurred();
        }
    }
    
    /**
     * displayRecords. Este método se encarga de desplegar los records guardados.
     */
    public void displayRecords(){
        List<Record> records = new ArrayList<Record>();
        
        records = recordsManager.getRecords();
        for(Record record : records){
            Label labelRecord = new Label(record);
            addObject(labelRecord,positionX,positionY);
            positionY+=50;
        }
    }
    
    /**
     * eventOcurred. Se pausara la música del menu.
     */
    public void eventOcurred(){
        music.pause();
    }
}
