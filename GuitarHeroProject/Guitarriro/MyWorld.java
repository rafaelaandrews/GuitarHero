import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends greenfoot.World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    //private Guitarra guitarra;
    private NotaVerde notaVerde;
    private NotaAmarela notaAmarela;
    private NotaVermelha notaVermelha;
    private BotaoVerde botaoVerde;
    private BotaoAmarelo botaoAmarelo;
    private BotaoVermelho botaoVermelho;
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        preparePlaying();
    }
        private void preparePlaying()
    {
        // Clear the world
        removeObjects(getObjects(Actor.class));
                
        // Create the menu
        //guitarra = new Guitarra();
        //addObject(guitarra,getWidth()/2,getHeight()/2);
        notaVerde = new NotaVerde();
        notaVermelha = new NotaVermelha();
        notaAmarela = new NotaAmarela();
        botaoVerde = new BotaoVerde();
        botaoAmarelo = new BotaoAmarelo();
        botaoVermelho = new BotaoVermelho();
        addObject(notaVerde, 250, 10);
        addObject(notaAmarela, 300, 10);
        addObject(notaVermelha, 350, 10);
        addObject(botaoVerde, 250, 380);
        addObject(botaoAmarelo, 300, 380);
        addObject(botaoVermelho, 350, 380);

        // Set the game state
    }
}
