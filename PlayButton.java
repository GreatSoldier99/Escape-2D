import greenfoot.*;

/**
 * PlayButton. Esta clase representa un botón que inicia el juego.
 * 
 * @author Victor Manuel Gómez Solis
 */
public class PlayButton extends Button{
    GreenfootImage button = new GreenfootImage("PlayButton.JPEG");
    
    /**
     * PlayButton. Constructor de la clase con el mismo nombre, coloca la imagen al botón y reinicia el HUD.
     */
    public PlayButton(Observer ...observers){
        setImage(button);
        initializeHud();
    }

    /**
     * act. En este método ocurren las siguientes acciones:
     * -Cuando se le hace click al botón, se despliega el primer nivel del juego.
     */
    public void act(){
        super.act();
        if(Greenfoot.mouseClicked(this)){
            Greenfoot.setWorld(new LevelOneScreen());
        }
    }
    
    public void initializeHud(){
        Hud.initializeHud();
        Score.setHudScore();
    }
}