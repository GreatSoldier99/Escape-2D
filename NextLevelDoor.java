import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class NextLevelDoor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class NextLevelDoor extends Platform{
    private GreenfootImage image = new GreenfootImage("doorNextLevel.png");
    
    private String level;
    private int previousScore;
   
    public NextLevelDoor(){
        image.scale(110, 130);
        setImage(image);
    }
    
    public void act(){
        Coallition();
    }    

    public void Coallition(){

        if(isTouching(Soldier.class)){
            level = getWorld().getClass().getName();
            
            if(level == "LevelOneScreen"){
                Score.passScoreToNewLevel();
                Greenfoot.setWorld(new LevelTwoScreen());
            }
        }
    }
    
    public boolean isTouchedBySoldier(){
        return this.isTouching(Soldier.class);
    }
}
