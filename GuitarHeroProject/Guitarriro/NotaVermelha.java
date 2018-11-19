import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class NotaVermelha here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class NotaVermelha extends Actor
{
    /**
     * Act - do whatever the NotaVermelha wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
          setLocation(getX(),getY()+2);
          if(this.getY() == 386){
              MyWorld world = (MyWorld)getWorld();
              world.noteWrong();
              getWorld().removeObject(this);
          }
    }    
}
