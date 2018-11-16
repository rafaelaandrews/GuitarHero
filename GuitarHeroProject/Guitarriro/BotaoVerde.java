import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class BotaoVerde extends Actor
{
    boolean pressed = false;
    boolean active = false;
    
    private GreenfootImage activeImage = new GreenfootImage("botao_verde_apertado.png");  
    private GreenfootImage looseImage = new GreenfootImage("botao_verde.png");
    private int activeRatio = 0;
    private int activeLimit = 20;
    private int pressRatio = 0;
    
    public void act() 
    {
        // (1) Botão zerado e usuário pressiona o a
        if (!active && !pressed && Greenfoot.isKeyDown("a"))
        {
            pressed=true;
            active=true;
            this.setImage(activeImage);
            pressRatio=1;
        }
        // (2) Botão ativo e usuário continua pressionando
        else if (active && pressed && Greenfoot.isKeyDown("a"))
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
            	Actor notaVerde = getOneIntersectingObject(NotaVerde.class);
	            if (notaVerde!=null){
                    MyWorld world = (MyWorld)getWorld();
                    world.noteRight();
                    world.addObject(new Certo(),notaVerde.getX(),370);
	                getWorld().removeObject(notaVerde);
	            }
            }    
        }
        // (3) Botão expirado e usuário continua pressionando
        else if (!active && pressed && Greenfoot.isKeyDown("a"))
        { 
        }
        // (4) Botão ativo e o usuário solta a tecla antes da expiração
        else if (active && pressed && !Greenfoot.isKeyDown("a"))
        {
            active = false;
            pressed = false;
            this.setImage(looseImage);         
        }
         // (5) Botão expirado e o usuário solta a tecla 
        else if (!active && pressed && !Greenfoot.isKeyDown("a"))
        {
            pressed = false;
            this.setImage(looseImage);         
        }    
    } 
    
}
