import greenfoot.*;

/**
 * Write a description of class Crown here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Crown extends ValuableItem{
    private GreenfootImage image = new GreenfootImage("crown.png");
    
    public Crown(){
        image.scale(20, 40);
        setImage(image);
        points = 30;
    }
}
