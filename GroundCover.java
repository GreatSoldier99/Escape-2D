import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * GroundCover. Esta clase permite poner un "suelo" sobre una cobertura para poder brincarla.
 * 
 * @author Victor Manuel Gómez Solis
 */
public class GroundCover extends Platform{
   private GreenfootImage image = new GreenfootImage("platform_GroundCover.png");
   
   public GroundCover(){
        image.scale(40,10);
        setImage(image);
    }
}
