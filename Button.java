import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Write a description of class Button here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Button extends Actor{
    private List<Reviewer> reviewers = new LinkedList<>();
    
    protected Button (){
        
    }
    
    public void act() 
    {
        if (Greenfoot.mouseClicked(this))
        {
            for(Reviewer reviewer: reviewers)
            {
                reviewer.eventOcurred();
            }
        }
    }
}
