import greenfoot.*;
import java.util.*;

/**
 * RifleMandaEnemy. Esta clase crea y controla al personaje no-jugable antagonista "Rifle Manda".
 * 
 * @author Victor Manuel Gómez Solis
 */
public class RifleMandaEnemy extends Enemy{
    public static final int SCORE_ENEMY = 20;
    private static final int SPEED = 1;
    private static final int TYPES_OF_MOVEMENT = 3;
    
    private double direction;
    private int cadenceWeapon = 15;
    private int counterGun=0;
    private int counterLeft;
    private int counterRight;
    private int life = 20;
    private String typeWeapon = "AssaultRifle";
    
    private ArrayList<GreenfootImage> skinEnemieRight = new ArrayList();
    private ArrayList<GreenfootImage> skinEnemieLeft = new ArrayList();
    private ArrayList<GreenfootImage> skinEnemieStanding = new ArrayList();
    
    private GreenfootImage firstPose = new GreenfootImage("RM_Standing.png");

    public RifleMandaEnemy(){
        buildSkins();
        firstPose.scale(25, 50);
        setImage(firstPose);  
        direction = Math.random()*2+1;
    }   

    public void act() {
        enemyControl();
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
            if(i == RIGHT){
                skinEnemieRight.add(prepareImage("RM_MovementA.png", false));
                skinEnemieRight.add(prepareImage("RM_MovementB.png", false));
                skinEnemieRight.add(prepareImage("RM_MovementC.png", false));
                skinEnemieRight.add(prepareImage("RM_MovementD.png", false));
                skinEnemieRight.add(prepareImage("RM_MovementE.png", false));
                skinEnemieRight.add(prepareImage("RM_MovementF.png", false));
                skinEnemieRight.add(prepareImage("RM_MovementG.png", false));
                skinEnemieRight.add(prepareImage("RM_MovementH.png", false));
            }
            else if(i == LEFT){
                skinEnemieLeft.add(prepareImage("RM_MovementA.png", true));
                skinEnemieLeft.add(prepareImage("RM_MovementB.png", true));
                skinEnemieLeft.add(prepareImage("RM_MovementC.png", true));
                skinEnemieLeft.add(prepareImage("RM_MovementD.png", true));
                skinEnemieLeft.add(prepareImage("RM_MovementE.png", true));
                skinEnemieLeft.add(prepareImage("RM_MovementF.png", true));
                skinEnemieLeft.add(prepareImage("RM_MovementG.png", true));
                skinEnemieLeft.add(prepareImage("RM_MovementH.png", true));
            }
            else if(i == STAND){
                skinEnemieStanding.add(prepareImage("RM_Shooting.png", false));
                skinEnemieStanding.add(prepareImage("RM_Shooting.png", true));       
            }
        }
    }
    
    private void enemyControl(){
        int x = getX();
        int y = getY();
        
        if(isTouching(Platform.class) && direction != STAND){
            if((int)direction == RIGHT){
                moveRight(x, y);
                
                if(x > 690 || isTouching(Cover.class)){
                    direction = LEFT;
                }
                    
                if(!isTouching(Platform.class)){
                    direction = LEFT;
                    setLocation(x-20,y);
                }
            }else if((int)direction==LEFT){
                moveLeft(x, y);
                
                if(x<10 || isTouching(Cover.class) || !isTouching(Platform.class)){
                    direction = RIGHT;
                }
                    
                if(!isTouching(Platform.class)){
                    direction = RIGHT;
                    setLocation(x+20,y);
                }
            }
        
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
                    getWorld().addObject(WeaponFactory.buildWeapon(typeWeapon, RIGHT, KEY_WEAPON_ENEMIE), x + 15, y-9);
                }
            }else{
                standing(LEFT); 
                if(counterGun % cadenceWeapon ==0){
                    getWorld().addObject(WeaponFactory.buildWeapon(typeWeapon, LEFT, KEY_WEAPON_ENEMIE), x - 15, y-9);
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
    
    private void moveRight(int x, int y){
        direction = RIGHT;
        setLocation(x+SPEED, y);
        
        counterLeft = 0;
        counterRight++;
        if(counterRight < (skinEnemieRight.size())*TIME_SKIN){
            if(counterRight % TIME_SKIN == 0){
                setImage(skinEnemieRight.get(counterRight / TIME_SKIN));
            }
        }else{
            counterRight = 0;
        }
    }

    private void moveLeft(int x, int y){
        direction = LEFT;
        setLocation(x-SPEED, y);
        
        counterLeft++;
        counterRight = 0;
        if(counterLeft < (skinEnemieLeft.size())*TIME_SKIN){
            if(counterLeft % TIME_SKIN == 0){
                setImage(skinEnemieLeft.get(counterLeft / TIME_SKIN));
            }
        }else{
            counterLeft = 0;
        }
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
