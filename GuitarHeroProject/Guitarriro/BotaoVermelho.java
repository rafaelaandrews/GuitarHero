import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class BotaoVermelho extends Actor
{
    boolean pressed = false;
    boolean active = false;
    
    private GreenfootImage activeImage = new GreenfootImage("botao_vermelho_apertado.png");  
    private GreenfootImage looseImage = new GreenfootImage("botao_vermelho.png");
    private int activeRatio = 0;
    private int activeLimit = 20;
    private int pressRatio = 0;
    
    public void act() 
    {
        // (1) Botão zerado e usuário pressiona o a
        if (!active && !pressed && Greenfoot.isKeyDown("d"))
        {
            pressed=true;
            active=true;
            this.setImage(activeImage);
            pressRatio=1;
        }
        // (2) Botão ativo e usuário continua pressionando
        else if (active && pressed && Greenfoot.isKeyDown("d"))
        {
            activeRatio++;

            if (activeRatio==activeLimit)
            {
            	active = false;
            	this.setImage(looseImage);
                activeRatio = 0;
            }
            else
            {
            	// TODO - Refatorar comportamentos como este em subrotinas
            	Actor notaVermelha = getOneIntersectingObject(NotaVermelha.class);
	            if (notaVermelha!=null){
                    MyWorld world = (MyWorld)getWorld();
                    world.noteRight();
	                getWorld().removeObject(notaVermelha);
	            }
            }    
        }
        // (3) Botão expirado e usuário continua pressionando
        else if (!active && pressed && Greenfoot.isKeyDown("d"))
        {
                     
        }
        // (4) Botão ativo e o usuário solta a tecla antes da expiração
        else if (active && pressed && !Greenfoot.isKeyDown("d"))
        {
            active = false;
            pressed = false;
            this.setImage(looseImage);         
        }
         // (5) Botão expirado e o usuário solta a tecla 
        else if (!active && pressed && !Greenfoot.isKeyDown("d"))
        {
            pressed = false;         
        }    
    } 
    
}

