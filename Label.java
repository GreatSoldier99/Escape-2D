import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Label here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Label extends Actor{
    private GreenfootImage imgText;
    private String textLabel;
    //No me funciona usar \t, lo corregire en cuanto pueda solucionarlo.
    private String splitter = "                        ";
    
    public Label(Record record){
        textLabel=record.getNamePlayer()+splitter+Integer.toString(record.getScorePlayer());
        imgText = new GreenfootImage(textLabel,35,Color.WHITE,null,Color.BLACK);
        setImage(imgText);
    }
    
    public Label(String text, Color foreGround, Color outLine){
        imgText = new GreenfootImage(text,50,foreGround,null,outLine);
        setImage(imgText);
    }
    
    public void act(){
        // Add your action code here.
    }
}
