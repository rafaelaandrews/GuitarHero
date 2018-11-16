import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class FinalScore extends Actor
{
    public FinalScore(int finalScore)
    {
        GreenfootImage image = new GreenfootImage(String.valueOf(finalScore),          
                                                  50,
                                                  new Color(0,0,0,200),
                                                  new Color(255,255,255,200));                                          
                                                  
        setImage(image);  
    }
}

