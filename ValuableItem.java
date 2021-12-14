import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class ValuableItem extends Actor{
    protected int points;
    
    public void act(){
        Coallition();
    } 

    protected void Coallition(){
        
        if(isTouching(Soldier.class)){
            getWorld().removeObject(this);
            Score.addScore(points);
        }       
    }
}
