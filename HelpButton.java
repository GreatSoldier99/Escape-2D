import greenfoot.*;  

/**
 * HelpButton. Esta clase representa un boton que cambia a la pantalla de ayuda.
 * 
 * @author Victor Manuel Gómez Solis
 */
public class HelpButton extends Button{
    GreenfootImage button = new GreenfootImage("HelpButton.JPEG");
    
    /**
     * HelpButton. Constructor de la clase con el mismo nombre, coloca la imagen al botón.
     */
    public HelpButton(Observer ...observers){
        setImage(button);
    }
}
