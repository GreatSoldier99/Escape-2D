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
    
    /**
     * act. En este método ocurren las siguientes acciones:
     * -Cuando se le hace click al botón, se despliega la pantalla de ayuda.
     */
    public void act(){
        super.act();
        if(Greenfoot.mouseClicked(this)){
            Greenfoot.setWorld(new HelpScreen());
        }
    }
}
