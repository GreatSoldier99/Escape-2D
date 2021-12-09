import greenfoot.*;
import java.util.*;

/**
 * Button. Esta clase es la base para crear los demas botones del juego.
 * 
 * @author Victor Manuel Gómez Solis
 */
public class Button extends Actor{
    private static final int LOW_TRANSPARENCY = 100;
    private static final int HIGH_TRANSPARENCY = 255;
    
    public Button(){
    }
    
    /**
     * act. Este método realiza algunos aspectos visuales a los botones, todos los botones heredarán esos aspectos y estos son:
     * -Hacer transparente al boton cuando el mouse este moviendose sobre el.
     */
    public void act(){
        if(Greenfoot.mouseMoved(this)){
            getImage().setTransparency(LOW_TRANSPARENCY);
        }else{
            getImage().setTransparency(HIGH_TRANSPARENCY);
        }
    }
}
