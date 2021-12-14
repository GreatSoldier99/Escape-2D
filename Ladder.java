import greenfoot.*;

/**
 * Ladder. Esta clase representa un objeto escalera, por el cual el personaje jugable puede subir.
 * 
 * @author Victor Manuel Gómez Solis
 */
public class Ladder extends Actor{
    private GreenfootImage ladder = new GreenfootImage("ladder_A.png");
    
    public Ladder(int width, int length){
        ladder.scale(width, length);
        setImage(ladder);
    }
}