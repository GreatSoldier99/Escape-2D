import greenfoot.*;

/**
 * ScoreButton. Esta clase representa un boton que cambia a la pantalla de records del juego.
 * 
 * @author Victor Manuel Gómez Solis
 */
public class ScoreButton extends Button{
    GreenfootImage button = new GreenfootImage("ScoreButton.JPEG");
    
    /**
     * ScoreButton. Constructor de la clase con el mismo nombre, coloca la imagen al botón.
     */
    public ScoreButton(Observer ...observers){
        setImage(button);
    }
    
    /**
     * act. En este método ocurren las siguientes acciones:
     * -Cuando se le hace click al botón, se despliega la pantalla de records.
     */
    public void act(){
        super.act();
        if(Greenfoot.mouseClicked(this)){
            Greenfoot.setWorld(new ScoreScreen());
        }
    }
}
