import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class InitialScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class InitialScreen extends World{
    GreenfootSound music = new GreenfootSound("intro.mp3");
    GreenfootImage bgImage = new GreenfootImage("Fondo2.png");
    
    public InitialScreen()
    {    
        super(700, 450, 1);
        setBackground(bgImage);
    }

    public void act(){
 
        if(!music.isPlaying())
        { 
            music.setVolume(50);
            music.play();
        }
        if(Greenfoot.isKeyDown("a"))
        {
            music.stop();
            Greenfoot.setWorld(new MenuScreen());  
            
        }
    }
}
