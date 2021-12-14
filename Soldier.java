import greenfoot.*;
import java.util.*;

/**
 * Soldier. Esta clase maneja la interacción del personaje jugable.
 * 
 * @author Victor Manuel Gómez Solis
 */
public class Soldier extends Actor{
    private final int MOVE_SPEED = 2;
    private final int JUMP_SPEED = 3;
    private final int HIGH_LIMIT = 0;
    private final int FALL_SPEED = 3;
    private final int HIGH_JUMP = 50;
    
    private final int NO_MOVEMENT = 0;
    private final int RIGHT = 1;
    private final int LEFT = 2;
    private final int DOWN = 3;
    private final int UP = 4;
    private final int UP_WEAPON = 5;
    private final int SQUAT = 6;
    private final int SHOOT = 7;
    private final int TYPES_OF_MOVEMENT = 8;
    
    private final int KEY_WEAPON = 1;
    
    private boolean isJumping;
    private boolean jumping;
    
    private int counterDown;
    private int counterGun = 0;
    private int counterLeft;
    private int counterRight;
    private int counterUp;
    private int direction;
    private int highAgent;
    
    static String typeWeapon;
    
    private ArrayList<GreenfootImage> soldierRightSkin = new ArrayList();
    private ArrayList<GreenfootImage> soldierLeftSkin = new ArrayList();
    private ArrayList<GreenfootImage> soldierJumpSkin = new ArrayList();
    private ArrayList<GreenfootImage> soldierClimbSkin = new ArrayList();
    private ArrayList<GreenfootImage> soldierStandingSkin = new ArrayList();
    private ArrayList<GreenfootImage> soldierLookUpSkin = new ArrayList();
    private ArrayList<GreenfootImage> soldierOnCoverSkin = new ArrayList();
    private ArrayList<GreenfootImage> soldierShootingSkin = new ArrayList();
    
    private GreenfootImage firstPose = new GreenfootImage("soldierStanding.png");
    
    public Soldier(){
        typeWeapon="Pistol";
        buildSkins();
        firstPose.scale(25, 50);
        setImage(firstPose);   
    }    

    public void act(){
        controlMovement();
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

        for(int i=0; i<=TYPES_OF_MOVEMENT-1; i++){
            if(i == RIGHT){
                soldierRightSkin.add(prepareImage("soldierMovement_A.png", false));
                soldierRightSkin.add(prepareImage("soldierMovement_B.png", false));
                soldierRightSkin.add(prepareImage("soldierMovement_C.png", false));
                soldierRightSkin.add(prepareImage("soldierMovement_D.png", false));
            }
            else if(i == LEFT){
                soldierLeftSkin.add(prepareImage("soldierMovement_A.png", true));
                soldierLeftSkin.add(prepareImage("soldierMovement_B.png", true));
                soldierLeftSkin.add(prepareImage("soldierMovement_C.png", true));
                soldierLeftSkin.add(prepareImage("soldierMovement_D.png", true));
            }
            else if(i == UP){
                soldierJumpSkin.add(prepareImage("soldierJump.png", true));    
                soldierJumpSkin.add(prepareImage("soldierJump.png", false));
            }
            else if(i == DOWN){
                soldierClimbSkin.add(prepareImage("soldierClimb.png", true));
                soldierClimbSkin.add(prepareImage("soldierClimb.png", false));
            }
            else if(i == NO_MOVEMENT){
                soldierStandingSkin.add(prepareImage("soldierStanding.png", false));
                soldierStandingSkin.add(prepareImage("soldierStanding.png", true));
                soldierStandingSkin.add(prepareImage("soldierClimb.png", true));
                soldierStandingSkin.add(prepareImage("soldierClimb.png", false));        
            }
            else if(i == UP_WEAPON){
                soldierLookUpSkin.add(prepareImage("soldierLookUp.png", false));
                soldierLookUpSkin.add(prepareImage("soldierLookUp.png", true));
            }else if(i == SQUAT){
                GreenfootImage image = new GreenfootImage("soldierCrouching.png");
                image.mirrorHorizontally();
                soldierOnCoverSkin.add(image);
                soldierOnCoverSkin.add(new GreenfootImage("soldierCrouching.png"));
            }else if(i == SHOOT){
                soldierShootingSkin.add(prepareImage("soldierShooting.png", false));
                soldierShootingSkin.add(prepareImage("soldierShooting.png", true));
            }
        }
    }
    
    private void controlMovement(){
        int x = getX();
        int y = getY();
        
        counterGun++;
        if(!isTouching(Platform.class) && !isTouching(Ladder.class) &&!jumping){
            fall(x, y);
        }
        else if(isTouching(Platform.class) && direction != DOWN && direction != UP && !jumping){
            if(Greenfoot.isKeyDown("space")){
                jumping=true;
                isJumping = true;
                highAgent=getY();
            }else if(Greenfoot.isKeyDown("right")){
                moveRight(x, y);
            }else if(Greenfoot.isKeyDown("left")){
                moveLeft(x, y);
            }else if(Greenfoot.isKeyDown("z") && counterGun % assignsCadence(typeWeapon) == 0){
                getWorld().addObject(WeaponFactory.buildWeapon(typeWeapon, direction, KEY_WEAPON), getX(), getY()-15);
            }else if(!isTouching(Ladder.class) && Greenfoot.isKeyDown("up")){
                if(direction == RIGHT){
                    setImage(soldierLookUpSkin.get(direction-1));
                }else if(direction == LEFT){
                    setImage(soldierLookUpSkin.get(direction-1));
                }
                
                if(counterGun % assignsCadence(typeWeapon) == 0){
                    getWorld().addObject(WeaponFactory.buildWeapon(typeWeapon, UP, KEY_WEAPON), getX(), getY());
                }
            }else if(!isTouching(Ladder.class) && Greenfoot.isKeyDown("down")){
                if(direction == RIGHT){
                    setImage(soldierOnCoverSkin.get(direction-1));
                }else if(direction == LEFT){
                    setImage(soldierOnCoverSkin.get(direction-1));
                }
            }else if(Greenfoot.isKeyDown("space")){
                jumping=true;
                isJumping = true;
                highAgent=getY();
            }else if (direction != NO_MOVEMENT){
                standing(x, y);
            }
        }else if(jumping){
            jump(x, y);    
        }
        
        if(isTouching(Ladder.class)  && direction != NO_MOVEMENT && !jumping){
            if(Greenfoot.isKeyDown("down") && !isTouching(Platform.class)){                          
                moveDown(x, y);
            }else if(Greenfoot.isKeyDown("up")){
                moveUp(x, y);
            }else if(direction==3 && isTouching(Platform.class)){
                if(Greenfoot.isKeyDown("right") || Greenfoot.isKeyDown("left")){
                    direction=NO_MOVEMENT;
                }
            }
        }else if(!isTouching(Ladder.class) && direction == UP){
            if(Greenfoot.isKeyDown("right") || Greenfoot.isKeyDown("left")){
                setLocation(x, y + 6);
                direction = NO_MOVEMENT;
            }
        }
    }

    private void standing(int x, int y){
        if(Greenfoot.isKeyDown("z")){
            setImage(soldierShootingSkin.get(direction-1));
        }else{
            setImage(soldierStandingSkin.get(direction-1));
        }
    }
    
    private void moveRight(int x, int y){
        direction = RIGHT;
        setLocation(x+MOVE_SPEED, y);
        if(isTouching(Cover.class))
            setLocation(x-MOVE_SPEED, y);
            
        counterLeft=0;
        counterRight++;
        counterGun=0;
        if(counterRight < (soldierRightSkin.size())*3+3){
            if(counterRight % 3 == 0)
                setImage(soldierRightSkin.get(counterRight/3-1));
        }else{
            counterRight=0;
        }     
    }
    
    private void moveLeft(int x, int y){
        direction = LEFT;
        setLocation(x-MOVE_SPEED, y);
        if(isTouching(Cover.class))
            setLocation(x+MOVE_SPEED, y);
            
        counterLeft++;
        counterRight=0;
        counterGun=0;
        if(counterLeft < (soldierLeftSkin.size())*3+3){
            if(counterLeft % 3 == 0)
                setImage(soldierLeftSkin.get(counterLeft/3-1));
        }else{
            counterLeft=0;
        }
    }
    
    private void jump(int x, int y){ 
        int jumpDirection;

        if(direction == RIGHT){
            jumpDirection=1;
            setImage(soldierJumpSkin.get(0));
        }else{
            jumpDirection = -1;
            setImage(soldierJumpSkin.get(1));
        }

        if(y>highAgent-HIGH_JUMP && isJumping && y>HIGH_LIMIT){
            y=y-JUMP_SPEED;
        }else{
            isJumping = false;  
        }
        
        if(!isTouching(Cover.class)){
            x=x+(MOVE_SPEED*jumpDirection);
        }
        
        setLocation(x , y);
        if(!isJumping && isTouching(Platform.class) && isTouching(Cover.class)){
            y=y+JUMP_SPEED;
            setLocation(x-(MOVE_SPEED*jumpDirection),y);
        }else if(!isJumping&&!isTouching(Platform.class)){
            y=y+JUMP_SPEED;
            setLocation(x,y);
            if(isTouching(Platform.class)){
                jumping=false;
            }
        } 
    }
    
    private void fall(int x, int y){
        setLocation(x, y+FALL_SPEED);
    }

    private void moveUp(int x, int y){
        setLocation(x, y - MOVE_SPEED);
        direction = UP;
        
        counterUp++;
        counterDown=0;
        counterGun=0;
        if(counterUp < ((soldierClimbSkin.size())*3+3)){
            if(counterUp % 3 == 0){
                setImage(soldierClimbSkin.get(counterUp/3-1));
            }
        }else{
            counterUp=0;
        }
    }
    
    private void moveDown(int x, int y){  
        setLocation(x, y +MOVE_SPEED);
        direction = DOWN;
        
        counterUp=0;
        counterDown++;
        counterGun=0;
        if(counterDown < ((soldierClimbSkin.size())*3+3)){
            if(counterDown % 3 == 0){
                setImage(soldierClimbSkin.get(counterDown/3-1));
            } 
        }else{
            counterDown=0;
        }
    } 

    private int assignsCadence(String typeWeapon){
        
        switch(typeWeapon){
            case "Pistol":
                return 10;
            case "AssaultRifle":
                return 25;
            default:
                return 1;
        }
    }
    
    public int getPositionX(){
        return getX();   
    }

    public int getPositionY(){
        return getY();
    }

    public int getDirection(){
        return direction;
    }
}
