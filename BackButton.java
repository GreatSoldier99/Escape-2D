import greenfoot.*;

/**
 * BackButton. Esta clase representa un botón que regresa a la pantalla anterior.
 * 
 * @author Victor Manuel Gómez Solis
 */
public class BackButton extends Button{
    private static GreenfootImage button = new GreenfootImage("BackButton.png");
    
    /**
     * BackButton. Constructor de la clase con el mismo nombre, coloca la imagen al botón.
     */
    public BackButton(){
        setImage(button);
    }
    
    /**
     * act. En este método ocurren las siguientes acciones:
     * -Cuando se le hace click al botón, se regresa al menu principal.
     */
    public void act(){
        super.act();
        
        if(Greenfoot.mouseClicked(this)){
            Greenfoot.setWorld(new MenuScreen());
        }
    }
}
