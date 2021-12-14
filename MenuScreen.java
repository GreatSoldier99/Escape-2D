import greenfoot.*;  

/**
 * MenuScreen. Esta clase despliega el menu principal, el cual cuenta con tres botones que pueden seleccionarse al hacer click.
 * 
 * @author Victor Manuel Gómez Solis
 */
public class MenuScreen extends World implements Observer{
    private static GreenfootSound music = new GreenfootSound("menu.mp3");
    private static GreenfootImage background = new GreenfootImage("menu_Background.png");
    
    private PlayButton playButton = new PlayButton(this);
    private HelpButton helpButton = new HelpButton(this);
    private ScoreButton scoreButton = new ScoreButton(this);
    
    /**
     * MenuScreen. Constructor de la clase con el mismo nombre, al construirse la pantalla ocurre lo siguiente: 
     * -Se coloca la imagen de fondo de la pantalla. 
     * -Se colocan los botones que contendra el menu.
     */
    public MenuScreen(){    
        super(700, 450, 1);
        music.setVolume(50);
        setBackground(background);
        showMenu();
    }

    /**
     * showMenu. Este método despliega 3 botones, los cuales son:
     * -PlayButton. Este botón permite iniciar el juego.
     * -HelpButton. Este botón permite acceder a la pantalla de ayuda o "como jugar".
     * -ScoreButton. Este botón permite acceder a la pantalla de records guardados del juego.
     */
    public void showMenu(){
        addObject(playButton,350,100);
        addObject(helpButton,350,225);
        addObject(scoreButton,350,350);
    }
    
    /**
     * act. Este método se encarga de:
     * -Ajustar el volumen y reproducir la música del menu del juego.
     * -Verificar si se hace click con el mouse alguno de los tres botones del menu.
     */
    public void act(){
        music.play();
        
        if(Greenfoot.mouseClicked(scoreButton) || Greenfoot.mouseClicked(helpButton)){
            eventOcurred();
        }
        if(Greenfoot.mouseClicked(playButton)){
            music.stop();
        }
    }
    
    /**
     * eventOcurred. Se pausara la música del menu.
     */
    public void eventOcurred(){
        music.pause();
    }
}