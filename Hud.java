import greenfoot.*; 

public class Hud extends Actor{
    private final Color TEXT_COLOR = Color.WHITE;
    
    private static int amountEnemies;
    public static int lives = 1;
    private int stringLength;
    private static int scoreEnemies;
    public static int totalScore;
    
    public void buildSign(String sign, int points){
        stringLength = (sign.length() + 2) * 20;
        setImage(new GreenfootImage(stringLength, 30));
        GreenfootImage image = getImage();
        Font font = image.getFont();
        
        image.setFont(font.deriveFont(15.0F));
        image.setColor(TEXT_COLOR); 
        updateImage(sign, points);
    }

    public void updateImage(String sign, int score){
        GreenfootImage image = getImage();
        image.clear();
        image.drawString(sign + score, 1, 18);
    }
    
    public static void initializeHud(){
        lives = 1;
        totalScore = 0;
    }
    
    public static void subtractAmountEnemies(){
        amountEnemies--;
    }
    
    public static void updateScore(){
        totalScore += (scoreEnemies * Enemy.getPoints()) * (lives - 1);
    }
    
    public static void setAmountEnemies(int amount){
        amountEnemies = amount;
        scoreEnemies = amount;
    }
    
    public static int getAmountEnemies(){
        return amountEnemies;
    }
    
    public static int getLives(){
        return lives;
    }
    
    public static int getTotalScore(){
        return totalScore;
    }
}
