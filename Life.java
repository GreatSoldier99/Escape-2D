import greenfoot.*;
import java.util.*;

public class Life extends Hud{
    private static int life = 50;
    private static int objective = 50;
    private static int previousTime;
    private String level;
    private String text = "Vida " + "(x" + String.valueOf(lives) + ") : ";
    
    private ArrayList<GreenfootImage> lifeIndicator = new ArrayList();
    
    public Life(){
        buildSign(text, life);
    }
    
    public void act(){
        
        if(life > objective){
            life--;
            updateImage(text, life);
        }
        
        checkLives();
    }
    
    public void checkLives(){
        
        if(life <= 0){
            lives--; 
            Score.passScoreToNewLevel();
            setLife();
        
            level = getWorld().getClass().getName();
            if(level=="LevelOneScreen"){ 
                Greenfoot.setWorld(new LevelOneScreen());
            }else if(level=="LevelTwoScreen"){
                Greenfoot.setWorld(new LevelTwoScreen(previousTime));
            }
        }
    }
    
    public static void subtract(int hurt){
        objective -= hurt;
    }
    
    public static void setHudLife(){
        life = 50;
        objective = 50;
    }
   
    public static void setLife(){
         life = 50;
         objective = 50;
    }
    
    public static void setPreviousTime(int timeStart){
        previousTime = timeStart;
    }
    
       
}