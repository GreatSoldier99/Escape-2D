import greenfoot.*;

/**
 * Ground. Esta clase representa la plataforma tipo suelo que "pisaran" los objetos.
 * 
 * @author Victor Manuel Gómez Solis
 */
public class Ground extends Platform{
    private GreenfootImage ground = new GreenfootImage("platform_Ground.png");
    
    public Ground(){
        ground.scale(50,25);
        setImage(ground);
    }
}
