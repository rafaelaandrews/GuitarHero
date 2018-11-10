import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BotaoAzul here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BotaoAzul extends Actor
{
    boolean pressed = false;
    boolean active = false;
    
    private GreenfootImage activeImage = new GreenfootImage("botao_azul_apertado.png");  
    private GreenfootImage looseImage = new GreenfootImage("botao_azul.png");
    private int activeRatio = 0;
    private int activeLimit = 20;
    private int pressRatio = 0;
    
    public void act() 
    {
        // (1) Botão zerado e usuário pressiona o a
        if (!active && !pressed && Greenfoot.isKeyDown("f"))
        {
            pressed=true;
            active=true;
            this.setImage(activeImage);
            pressRatio=1;
        }
        // (2) Botão ativo e usuário continua pressionando
        else if (active && pressed && Greenfoot.isKeyDown("f"))
        {
            activeRatio++;

            if (activeRatio==activeLimit)
            {
            	active = false;
            	this.setImage(looseImage);
            }
            else
            {
            	// TODO - Refatorar comportamentos como este em subrotinas
            	Actor notaAzul = getOneIntersectingObject(NotaAzul.class);
	            if (notaAzul!=null){
                    MyWorld world = (MyWorld)getWorld();
                    world.noteRight();
	                getWorld().removeObject(notaAzul);
	            }
            }    
        }
        // (3) Botão expirado e usuário continua pressionando
        else if (!active && pressed && Greenfoot.isKeyDown("f"))
        {
                     
        }
        // (4) Botão ativo e o usuário solta a tecla antes da expiração
        else if (active && pressed && !Greenfoot.isKeyDown("f"))
        {
            active = false;
            pressed = false;
            this.setImage(looseImage);         
        }
         // (5) Botão expirado e o usuário solta a tecla 
        else if (!active && pressed && !Greenfoot.isKeyDown("f"))
        {
            pressed = false;         
        }    
    }    
}
