import greenfoot.*;

/**
 * LevelTwoScreen. Esta clase crea el segundo nivel del juego.
 * 
 * @author Victor Manuel Gómez Solis
 */
public class LevelTwoScreen extends World{
    private static GreenfootImage background = new GreenfootImage("levelTwo_Background.png");

    /**
     * LevelTwoScreen. Constructor de la clase con el mismo nombre, este realiza lo siguiente:
     * -Prepara el escenario del nivel.
     */
    public LevelTwoScreen(){    
        super(700, 450, 1);
        prepare();
    }
    
    public void prepare(){
        setBackground(background);
    }
}
