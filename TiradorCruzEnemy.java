import greenfoot.*;
import java.util.*;

/**
 * TiradorCruzEnemy. Esta clase crea y controla al personaje no-jugable antagonista "Tirador Cruz".
 * 
 * @author Victor Manuel Gómez Solis
 */
public class TiradorCruzEnemy extends Enemy{
    public static final int SCORE_ENEMY = 50;
    private static final int SPEED = 1;
    private static final int TYPES_OF_MOVEMENT = 1;
    
    private double direction;
    private int cadenceWeapon = 70;
    private int counterGun=0;
    private int counterLeft;
    private int counterRight;
    private int life = 100;
    private String typeWeapon = "SniperRifle";
    
    private ArrayList<GreenfootImage> skinEnemieStanding = new ArrayList();
    
    private GreenfootImage firstPose = new GreenfootImage("TC_Standing.png");
    
    public TiradorCruzEnemy(){
        buildSkins();
        firstPose.scale(25, 50);
        setImage(firstPose);  
        direction = Math.random()*2+1;
    }   

    public void act(){
        enemyMovement();
    }
    
    private GreenfootImage prepareImage(String nameImage, Boolean reverse){
        GreenfootImage image = new GreenfootImage(nameImage);
        
        if(reverse == true){
            image.mirrorHorizontally();
        }
        image.scale(25, 50);
        
        return image;
    }

    private void buildSkins(){
        
        for(int i=0; i<TYPES_OF_MOVEMENT; i++){
            if(i == STAND){
                skinEnemieStanding.add(prepareImage("TC_Standing.png", false));
                skinEnemieStanding.add(prepareImage("TC_Standing.png", true));       
            }
        }
    }
    
    private void enemyMovement(){
        int x = getX();
        int y = getY();
        
        if(isTouching(Platform.class) && direction != STAND){
            if(getPositionYPlayer() > y){
                if(getPositionYPlayer() - y < 10){
                    direction = STAND;
                }
            }else if(getPositionYPlayer() < y){
                if(y - getPositionYPlayer() < 10){
                    direction = STAND;
                }
            }
        }
        else if(direction == STAND){
            counterGun++;
            
            if(getPositionXPlayer() > getX()){
                standing(RIGHT);  
                if(counterGun % cadenceWeapon ==0){
                    getWorld().addObject(WeaponFactory.buildWeapon(typeWeapon, RIGHT, KEY_WEAPON_ENEMIE), x + 15, y-12);
                }
            }else{
                standing(LEFT); 
                if(counterGun % cadenceWeapon ==0){
                    getWorld().addObject(WeaponFactory.buildWeapon(typeWeapon, LEFT, KEY_WEAPON_ENEMIE), x - 15, y-12);
                }
            }

            if(getPositionYPlayer() > y){
                if(getPositionYPlayer() - y > 10){
                    direction = Math.random()*2+1;
                    counterGun = 0;
                }
            }else if(getPositionYPlayer() < y){
                if(y - getPositionYPlayer() > 10){
                    direction = Math.random()*2+1;
                    counterGun = 0;
                }
            }
        }
        
        checkLife();
    }

    private void standing(int position){
        setImage(skinEnemieStanding.get(position-1));
    }
    
    public void checkLife(){
        Actor collided = getOneIntersectingObject(Weapon.class);
        
        if(collided != null){
            if(keyWeaponPlayer == 1){
                life -= hurtPlayer;
                getWorld().removeObject(collided);
            }
        }
        
        if(life <= 0){
            getWorld().removeObject(this);
            Score.addScore(Enemy.getPoints());
            Hud.subtractAmountEnemies();
        }
    }
}
