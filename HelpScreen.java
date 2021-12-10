import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * HelpScreen. Esta clase despliega la pantalla de ayuda del juego.
 * 
 * @author Victor Manuel Gómez Solis
 */
public class HelpScreen extends World{
    private static GreenfootSound music = new GreenfootSound("intro.mp3");
    private static GreenfootImage background = new GreenfootImage("helpScreen_Background.png");
    
    private BackButton backButton = new BackButton();

    /**
     * ScoreScreen. Constructor de la clase con el mismo nombre, al construirse la pantalla ocurre lo siguiente:
     * -Se coloca la imagen de fondo de la pantalla.
     * -Se agrega el botón para regresar al menu.
     */
    public HelpScreen(){    
        super(700, 450, 1);
        setBackground(background);
        addObject(backButton,620,417);
    }
    
    /**
     * act. Este método se encarga de:
     * -Ajustar el volumen y reproducir la música de la pantalla de ayuda.
     * -Verificar si se hace click con el mouse en el backButton.
     */
    public void act(){
        music.setVolume(50);
        music.play();
        if(Greenfoot.mouseClicked(backButton)){
            eventOcurred();
        }
    }
    
    /**
     * eventOcurred. Se pausara la música del menu.
     */
    public void eventOcurred(){
        music.pause();
    }
}
