import greenfoot.*;

/**
 * Enemy. Esta clase representa a los personajes enemigos no-jugables.
 * 
 *
 */
public class Enemy extends Actor{
    public static final int KEY_WEAPON_ENEMIE = 2;
    public static final int LEFT = 2;
    public static final int POINTS = 5;
    public static final int RIGHT = 1;
    public static final int STAND = 0;
    public static final int TIME_SKIN = 3;
    
    public static int hurtPlayer;
    public static int keyWeaponPlayer;
    public static int positionYPlayer;
    public static int positionXPlayer;
    
    public static void setPositionPlayer(int x, int y){
        positionYPlayer = y;
        positionXPlayer = x;
    }
    
    public int getPositionYPlayer(){
        return positionYPlayer;   
    }
    
    public int getPositionXPlayer(){
        return positionXPlayer;
    }
    
    public static int getPoints(){
        return POINTS;
    }
    
    public static void subtractLife(int keyWeapon, int hurt){
        keyWeaponPlayer = keyWeapon;
        hurtPlayer = hurt;        
    }
}