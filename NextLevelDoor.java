import greenfoot.*;
import javax.swing.*;

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
    private int previousTime;
    
    private final int MAX_RECORDS = 5;
    private final String NAME_FILE = "Records.txt";
    private RecordsManager recordsManager = new RecordsManager(MAX_RECORDS,NAME_FILE);
   
    public NextLevelDoor(){
        image.scale(110, 130);
        setImage(image);
    }
    
    public void act(){
        Coallition();
    }    

    public void Coallition(){
        Record record;
        
        if(isTouching(Soldier.class)){
            level = getWorld().getClass().getName();
            
            if(level == "LevelOneScreen"){
                Score.passScoreToNewLevel();
                Greenfoot.setWorld(new LevelTwoScreen(previousTime));
            }else{
                Score.passScoreToNewLevel();
                String name = JOptionPane.showInputDialog("Ingresa tu nombre");            
                record = new Record(name, Hud.getTotalScore());
                recordsManager.save(record);
                Greenfoot.setWorld(new ScoreScreen());
            }
        }
    }
    
    public boolean isTouchedBySoldier(){
        return this.isTouching(Soldier.class);
    }
    
    public void setPreviousTime(int timeStart){
        previousTime = timeStart;
    }
}
