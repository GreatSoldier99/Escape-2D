import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * MenuScreen. Esta clase despliega el menu principal, el cual cuenta con tres opciones.
 * 
 * @author Victor Manuel Gómez Solis
 */
public class MenuScreen extends World implements Reviewer{
    private GreenfootSound music = new GreenfootSound("menu.mp3");
    private GreenfootImage bgImage = new GreenfootImage("menu_Background.png");
        
    public MenuScreen(){    
        super(700, 450, 1);
        setBackground(bgImage);
        showMenu();
    }

    /**
     * showMenu. Este método despliega 3 botones, los cuales son:
     * -PlayButton. Este botón permite iniciar el juego.
     * -HelpButton. Este botón permite acceder a la pantalla de ayuda o "como jugar".
     * -ScoreButton. Este botón permite acceder a la pantalla de records guardados del juego.
     */
    public void showMenu(){
        addObject(new PlayButton(this),350,100);
        addObject(new HelpButton(this),350,225);
        addObject(new ScoreButton(this),350,350);
    }
    
    /**
     * act. Este método se encarga de:
     * -Ajustar el volumen y reproducir la música de la pantalla inicial.
     */
    public void act(){
       if(!music.isPlaying())
        { 
            music.setVolume(50);
            music.play();
        }
    }

    public void eventOcurred()
    {
        music.pause();
    }
}
