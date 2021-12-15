import greenfoot.*;
import javax.swing.*;
import java.util.*;

/**
 * LevelTwoScreen. Esta clase crea el segundo nivel del juego.
 * 
 * @author Victor Manuel Gómez Solis
 */
public class LevelTwoScreen extends World{
    private static GreenfootSound music = new GreenfootSound("levelTwo.mp3");
    private static GreenfootImage background = new GreenfootImage("levelTwo_Background.png");
    
    private Soldier player = new Soldier();
    private int amountEnemies = 4;
    
    private SimpleTimer time = new SimpleTimer();
    private Counter timeCounter = new Counter("TIEMPO\n");
    private NextLevelDoor doorNextLevel = new NextLevelDoor();
    
    private final int MAX_RECORDS = 5;
    private final String NAME_FILE = "Records.txt";
    private RecordsManager recordsManager = new RecordsManager(MAX_RECORDS,NAME_FILE);
    
    private boolean start = true;
    private boolean play = true;
    private int timeStart;

    /**
     * LevelTwoScreen. Constructor de la clase con el mismo nombre, este realiza lo siguiente:
     * -Prepara el escenario del nivel.
     */
    public LevelTwoScreen(int startTime){
        super(700, 450, 1);
        timeStart = startTime;
        prepare();
    }
    
    public void prepare(){
        setBackground(background);
        music.setVolume(25);
        buildHud();
        buildEnemies();
        buildCover();
        buildPlatforms();
        buildLadders();
        buildTreasures();
        addObject(player, 25, 82);
        addObject(doorNextLevel, 671, 389);
    }
    
    public void act(){
        if(play){
            music.play();
        }
        positionPlayer();
        trackTime();
        verifyMusicStatus();
        compareLives();
    }

    public void verifyMusicStatus(){
        if(doorNextLevel.isTouchedBySoldier()){
            music.play();
            play = false;
        }
    }
    
    /**
     * buildHud. Este método construye los elementos visuales que el jugador necesita ver para comprender su estado (HUD).
     */
    public void buildHud(){
        addObject(new SoldierIcon(), 30, 30);
        addObject(new Label("NIVEL 2", Color.RED, Color.WHITE), 350, 30);        
        addObject(timeCounter, 635, 30);
        addObject(new Life(), 200, 17);
        addObject(new Score(), 152, 45);
        Life.setHudLife();
    }
    
    public void positionPlayer(){
        Enemy.setPositionPlayer(player.getPositionX(), player.getPositionY());
    }
    
    /**
     * buildEnemies. Este método agrega los enemigos al nivel.
     */
    public void buildEnemies(){
        addObject(new RifleMandaEnemy(), 610, 270);
        addObject(new RifleMandaEnemy(), 471, 402);
        addObject(new TiradorCruzEnemy(), 166, 88);
        addObject(new TiradorCruzEnemy(), 166, 187);
        Hud.setAmountEnemies(amountEnemies);
    }
    
    /**
     * buildCover. Este método construye las coberturas que serviran de defensa para el jugador.
     */
    public void buildCover(){
        int i;
        
        addObject(new GroundCover(), 319, 274);
        addObject(new GroundCover(), 160, 116);
        addObject(new GroundCover(), 160, 214);
        addObject(new GroundCover(), 271, 405);
        
        addObject(new Cover(), 318, 298);
        addObject(new Cover(), 271, 428);
        addObject(new Cover(), 670, 405);
        for(i=70;i<=200;i+=40){
            addObject(new Cover(), 120, i);
        }
    }
    
    /**
     * buildLadders. Este método construye las escaleras que se utilizaran para subir entre plataformas.
     */
    public void buildLadders(){
        addObject(new Ladder(30, 90), 573, 254);
        addObject(new Ladder(30, 100), 677, 165);
    }
    
    /**
     * buildPlatforms. Este método construye las plataformas que se utlizaran para diseñar el nivel.
     */
    public void buildPlatforms(){
        int i;
        
        addObject(new Ground(), 25, 125);
        addObject(new Ground(), 75, 220);
        for(i=25;i<=700;i+=50){
            addObject(new Ground(), i, 437);
            
            if(i != 175){
                addObject(new Ground(), i, 305);
            }
            
            if(i >= 475){
                addObject(new Ground(), i, 125);
                addObject(new Ground(), i, 220);
            }
        }
    }
    
    /**
     * buildTreasures. Este método construye los objetos valiosos que dan puntos al ser recogidos.
     */
    public void buildTreasures(){
        addObject(new Crown(), 477, 93);
        addObject(new Crown(), 529, 93);
        addObject(new Crown(), 576, 93);
        addObject(new Crown(), 473, 187);
        addObject(new Crown(), 517, 187);
        addObject(new Crown(), 18, 403);
    }
    
    /**
     * trackTime. Este método es el que permite medir el tiempo transcurrido en segundos.
     */
    public void trackTime(){
        if(start){
            timeCounter.setValue(timeStart + (time.millisElapsed() / 1000));
        }
    }
    
    /**
     * compareLives. Este método verifica si se han perdido las vidas. Si es asi se guarda el record y la pantalla cambia a la de records.
     */
    private void compareLives(){
        if(Hud.getLives() <= 0 ){
            Record record;
            music.play();
            start = false;
            
            String name = JOptionPane.showInputDialog("Ingresa tu nombre");            
            record = new Record(name, Hud.getTotalScore());
            recordsManager.save(record);
            Greenfoot.setWorld(new ScoreScreen());
        }
    }
}
