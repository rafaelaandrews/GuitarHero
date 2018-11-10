import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BotaoAmarelo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BotaoAmarelo extends Actor
{
    boolean pressed = false;
    boolean active = false;
    
    private GreenfootImage activeImage = new GreenfootImage("botao_amarelo_apertado.png");  
    private GreenfootImage looseImage = new GreenfootImage("botao_amarelo.png");
    private int activeRatio = 0;
    private int activeLimit = 20;
    private int pressRatio = 0;
    Score score = new Score();
    
    public void act() 
    {
        // (1) Botão zerado e usuário pressiona o a
        if (!active && !pressed && Greenfoot.isKeyDown("s"))
        {
            pressed=true;
            active=true;
            this.setImage(activeImage);
            pressRatio=1;
        }
        // (2) Botão ativo e usuário continua pressionando
        else if (active && pressed && Greenfoot.isKeyDown("s"))
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
            	Actor notaAmarela = getOneIntersectingObject(NotaAmarela.class);
	            if (notaAmarela!=null){
	                MyWorld world = (MyWorld)getWorld();
	                world.noteRight();
	                getWorld().removeObject(notaAmarela);
	            }
            }    
        }
        // (3) Botão expirado e usuário continua pressionando
        else if (!active && pressed && Greenfoot.isKeyDown("s"))
        {
                     
        }
        // (4) Botão ativo e o usuário solta a tecla antes da expiração
        else if (active && pressed && !Greenfoot.isKeyDown("s"))
        {
            active = false;
            pressed = false;
            this.setImage(looseImage);         
        }
         // (5) Botão expirado e o usuário solta a tecla 
        else if (!active && pressed && !Greenfoot.isKeyDown("s"))
        {
            pressed = false;         
        }    
    } 
    
}
