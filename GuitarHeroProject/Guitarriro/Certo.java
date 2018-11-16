import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Certo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Certo extends Actor
{
    private int certoLife = 0;
    public void act() 
    {
        if(certoLife++ == 10){
            getWorld().removeObject(this);
        }
    }    
}
