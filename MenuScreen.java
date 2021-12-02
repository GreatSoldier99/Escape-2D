import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Menu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MenuScreen extends World implements Reviewer{
    private GreenfootSound music = new GreenfootSound("menu.mp3");
    private GreenfootImage bgImage = new GreenfootImage("cave.png");
    
    public MenuScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(700, 450, 1);
        setBackground(bgImage);
        showMenu();
    }

    private void showMenu()
    {
        addObject(new PlayButton(this),350,100);
        addObject(new HelpButton(this),350,225);
        addObject(new ScoreButton(this),350,350);
    }

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
