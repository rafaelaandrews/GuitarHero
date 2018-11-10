import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Score here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Score extends Actor
{
    private int points = 0;
    private int count = 0;
    
    public Score(){
        act();
    }
    public void act() 
    {
        if(count == 0){
            GreenfootImage image = new GreenfootImage("Score: "+points, 25, new Color(0,0,0,200), new Color(255, 255, 255, 0));
            setImage(image);
        }
        if(count == 10){
            count = 0;
        }
        else{
            count++;
        }
    }
    
    public void addScore(int newPoints){
        points += newPoints;
    }
    
    public void removePoints(int pointsRemove){
        points -= pointsRemove;
    }
    
    public int getScore(){
        return points;
    }
}
