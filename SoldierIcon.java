import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SoldierIcon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SoldierIcon extends Actor{
    private GreenfootImage image = new GreenfootImage("soldier.png");
    
    public SoldierIcon(){
        image.scale(40, 40);
        image.mirrorHorizontally();
        setImage(image);
    }
}