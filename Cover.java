import greenfoot.*; 

/**
 * Cover. Esta clase representa la cobertura que el personaje jugable puede utilizar para agacharse y cubrirse.
 * 
 * @author Victor Manuel Gómez Solis
 */
public class Cover extends Actor{
    private GreenfootImage cover = new GreenfootImage("cover.png");
    
    private static int coverWidth = 40;
    private static int coverHigh = 40;
    
    public Cover(){
        setImage(cover);
    }
    
    public static int getcoverWidth(){
        return coverWidth;
    }

    public static int getcoverHigh(){
        return coverHigh;
    }
}
