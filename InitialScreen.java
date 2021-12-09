import greenfoot.*;

/**
 * InitialScreen. Esta clase despliega una pantalla inicial para que no sea vea el menu de forma inmediata al ejecutar el juego.
 * 
 * @author Victor Manuel Gómez Solis
 */
public class InitialScreen extends World{
    private GreenfootSound music = new GreenfootSound("intro.mp3");
    private static GreenfootImage background = new GreenfootImage("initialScreen_Background.png");
    
    /**
     * InitialScreen. Constructor de la clase con el mismo nombre, al construirse la pantalla se coloca la imagen de fondo de la pantalla.
     */
    public InitialScreen(){    
        super(700, 450, 1);
        setBackground(background);
    }
    
    /**
     * act. Este método se encarga de:
     * -Ajustar el volumen y reproducir la música de la pantalla inicial.
     * -Cambiar a la pantalla del menu principal al presionar la tecla "a" del teclado.
     */
    public void act(){
        if(!music.isPlaying()){ 
            music.setVolume(50);
            music.play();
        }
        
        if(Greenfoot.isKeyDown("a")){
            music.stop();
            Greenfoot.setWorld(new MenuScreen());  
        }
    }
}
