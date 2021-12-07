import greenfoot.*;

/**
 * PlayButton. Esta clase representa un botón que inicia el juego.
 * 
 * @author Victor Manuel Gómez Solis
 */
public class PlayButton extends Button{
    GreenfootImage button = new GreenfootImage("PlayButton.JPEG");
    
    /**
     * PlayButton. Constructor de la clase con el mismo nombre, coloca la imagen al botón.
     */
    public PlayButton(Observer ...observers){
        setImage(button);
    }

    public void act(){
       super.act();
    }
}
