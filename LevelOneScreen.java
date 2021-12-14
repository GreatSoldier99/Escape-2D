import greenfoot.*;
import javax.swing.*;
import java.util.*;

/**
 * LevelOne. Esta clase crea el primer nivel del juego
 * 
 * @author Victor Manuel Gómez Solis
 */
public class LevelOneScreen extends World{
    private static GreenfootSound music = new GreenfootSound("levelOne.mp3");
    private static GreenfootImage background = new GreenfootImage("levelOne_Background.png");
    
    private Soldier player = new Soldier();
    private int amountEnemies=2;
    
    private SimpleTimer time = new SimpleTimer();
    private Counter timeCounter = new Counter("TIEMPO\n");
    
    private final int MAX_RECORDS = 5;
    private final String NAME_FILE = "Records.txt";
    private RecordsManager recordsManager = new RecordsManager(MAX_RECORDS,NAME_FILE);
    
    private boolean start = true;
    
    /**
     * LevelOneScreen. Constructor de la clase con el mismo nombre, este realiza lo siguiente:
     * -Prepara el escenario del nivel.
     */
    public LevelOneScreen(){    
        super(700, 450, 1);
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
        addObject(player, 25, 370);
        addObject(new NextLevelDoor(), 671, 101);
    }
    
    /**
     * act. Este método se encarga de:
     * -Ajustar el volumen y reproducir la música del menu del juego.
     */
    public void act(){
        music.play();
        positionPlayer();
        trackTime();
        compareLives();
    }
   
    public void positionPlayer(){
        Enemy.setPositionPlayer(player.getPositionX(), player.getPositionY());
    }
    
    /**
     * buildHud. Este método construye los elementos visuales que el jugador necesita ver para comprender su estado (HUD).
     */
    public void buildHud(){
        addObject(new SoldierIcon(), 30, 30);
        addObject(new Label("NIVEL 1", Color.CYAN, Color.DARK_GRAY), 350, 30);        
        addObject(timeCounter, 635, 30);
        addObject(new Life(), 200, 17);
        addObject(new Score(), 152, 45);
        Life.setHudLife();
    }
    
    /**
     * buildPlatforms. Este método construye las plataformas que se utlizaran para diseñar el nivel.
     */
    public void buildPlatforms(){
        int i;
        
        addObject(new Ground(), 25, 412);
        for(i=25;i<=700;i+=50){
            if(i != 175)
                addObject(new Ground(), i, 150);
            addObject(new Ground(), i, 285);
            addObject(new Ground(), i, 437);
        }
    }
    
    /**
     * buildCover. Este método construye las coberturas que serviran de defensa para el jugador.
     */
    public void buildCover(){
        addObject(new GroundCover(), 278, 401);
        addObject(new GroundCover(), 532, 248);
        
        addObject(new Cover(), 219, 103);
        addObject(new Cover(), 219, 143);
        addObject(new Cover(), 278, 423);
        addObject(new Cover(), 532, 270);
    }
    
    /**
     * buildLadders. Este método construye las escaleras que se utilizaran para subir entre plataformas.
     */
    public void buildLadders(){
        addObject(new Ladder(25, 150), 17, 214);
        addObject(new Ladder(25, 150), 306, 214);
        addObject(new Ladder(25, 150), 675, 350);//347
    }
    
    /**
     * buildTreasures. Este método construye los objetos valiosos que dan puntos al ser recogidos.
     */
    public void buildTreasures(){
        addObject(new Crown(), 122, 118);
        addObject(new Crown(), 175, 90);
        addObject(new Crown(), 686, 405);
    }
    
    /**
     * buildEnemies. Este método agrega los enemigos al nivel.
     */
    public void buildEnemies(){
        addObject(new RifleMandaEnemy(), 622, 402);
        addObject(new RifleMandaEnemy(), 446, 249);
        Hud.setAmountEnemies(amountEnemies);
    }
    
    /**
     * trackTime. Este método es el que permite medir el tiempo transcurrido en segundos.
     */
    public void trackTime(){
        if(start){
            timeCounter.setValue(time.millisElapsed() / 1000);
        }
    }
    
    /**
     * compareLives. Este método verifica si se han perdido las vidas. Si es asi se guarda el record y la pantalla cambia a la de records.
     */
    private void compareLives(){
        if(Hud.getLives() <= 0 ){
            music.stop();
            start = false;
            Record record;
            
            String name = JOptionPane.showInputDialog("Ingresa tu nombre");            
            record = new Record(name, Hud.getTotalScore());
            recordsManager.save(record);
            Greenfoot.setWorld(new ScoreScreen());
        }
    }
    
}