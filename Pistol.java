import greenfoot.*;

/**
 * Pistol. Esta clase representa el arma de nuestro personaje jugable.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Pistol extends Weapon{
    private static final int HURT = 5;
    private static final int LEFT = 2;
    private static final int RIGHT = 1;
    private static final int SPEED = 4;
    private static final int UP = 4;
    
    private int direction;
    private int keyWeapon;
    private int x;
    private int y;
    
    public Pistol(int direction, int keyWeapon){
        setImage("bulletA.png");
        
        this.direction = direction;
        this.keyWeapon = keyWeapon;
    }
    
    public void act(){ 
        x=getX();
        y=getY();
        
        if(direction == RIGHT){
            setLocation(x+SPEED, y);
        }else if(direction == LEFT){
            setLocation(x-SPEED, y);
        }else if(direction == UP){
            setLocation(x , y-SPEED);
        }
            
        collision(keyWeapon,HURT);
    }
}
