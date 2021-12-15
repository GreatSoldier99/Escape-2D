import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Esta clase representa el arma del villano "Tirador Cruz".
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SniperRifle extends Weapon{
    private static final int HURT = 10;
    private static final int LEFT = 2;
    private static final int RIGHT = 1;
    private static final int SPEED = 8;
    private static final int UP = 4;
    
    private int direction;
    private int keyWeapon;
    private int x;
    private int y;
    
    public SniperRifle(int direction, int keyWeapon){
        setImage("bulletB.png");
        this.direction = direction;
        this.keyWeapon = keyWeapon;
    }

    public void act() { 
        x=getX();
        y=getY();
        
        if(direction == RIGHT){
            setLocation(x+SPEED, y);
        }else if(direction == LEFT){
            setLocation(x-SPEED, y);
        }else if(direction == UP){
            setLocation(x , y-SPEED);
        }
            
        collision(keyWeapon, HURT);
    }
}
