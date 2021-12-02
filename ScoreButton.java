import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ScoreButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ScoreButton extends Button{
    GreenfootImage sbImage = new GreenfootImage("ScoreBotton.JPEG");
    
    public ScoreButton(Reviewer ... reviewers){
        setImage(sbImage);
    }

    public void act() {
    }
}
