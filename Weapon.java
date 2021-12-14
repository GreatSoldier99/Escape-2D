import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Weapon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Weapon extends Actor{
    public static final int KEY_WEAPON_PLAYER = 1;
    public static final int KEY_WEAPON_ENEMIE = 2;
    
    protected void collision(int keyWeapon, int HURT){
        if(getX() > 690 || getX() < 10 || getY() > 445 || getY() < 10 || isTouching(Platform.class)|| isTouching(Cover.class)){
            getWorld().removeObject(this);
        }

        else if(keyWeapon == KEY_WEAPON_PLAYER){
            Actor collided = getOneIntersectingObject(Enemy.class);
            if(collided != null){
                Enemy.subtractLife(keyWeapon, HURT);
            } 

        }
        else if(keyWeapon == KEY_WEAPON_ENEMIE){
            if(isTouching(Soldier.class)){
                getWorld().removeObject(this);
                Life.subtract(HURT);
            }
        }

    }

    public int getPositionX(){
        return getX(); 
    }

    public int getPositionY(){
        return getY();
    }
}
