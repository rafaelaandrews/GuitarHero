import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class NotaVerde here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class NotaVerde extends Actor
{
    /**
     * Act - do whatever the NotaVerde wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        setLocation(getX(),getY()+1);
          if(this.getY() == 385){
              MyWorld world = (MyWorld)getWorld();
              world.noteWrong();
              getWorld().removeObject(this);
          }
    }    
}
