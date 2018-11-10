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
    //10% de chance
    private int noteSpawnRatio = 5;
    
    //limite e quantidade
    private int noteSpawnCount = 0;
    private int noteSpawnLimit = 4;
    
    private Score score;
    //private Guitarra guitarra;
    private NotaVerde notaVerde;
    private NotaAmarela notaAmarela;
    private NotaVermelha notaVermelha;
    private NotaAzul notaAzul;
    private BotaoVerde botaoVerde;
    private BotaoAmarelo botaoAmarelo;
    private BotaoVermelho botaoVermelho;
    private BotaoAzul botaoAzul;
    
    //Game State
    private enum GameState{MENU,PLAYING,GAMEOVER};    
    private GameState state;
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        preparePlaying();
    }
    
    public void act(){
        actPlaying();
    }
    
        private void preparePlaying()
    {
        // Clear the world
        removeObjects(getObjects(Actor.class));
        
        // Create the menu
        //guitarra = new Guitarra();
        //addObject(guitarra,getWidth()/2,getHeight()/2);
        score = new Score();
        botaoVerde = new BotaoVerde();
        botaoAmarelo = new BotaoAmarelo();
        botaoVermelho = new BotaoVermelho();
        botaoAzul = new BotaoAzul();
        addObject(score, 57, 15);
        addObject(botaoVerde, 200, 380);
        addObject(botaoAmarelo, 250, 380);
        addObject(botaoVermelho, 300, 380);
        addObject(botaoAzul, 350, 380);
        // Set the game state
        state = GameState.PLAYING;
    }
    public void actPlaying(){
        int aleatorio = Greenfoot.getRandomNumber(4);
        int aleatorio2 = Greenfoot.getRandomNumber(100);
        notaVerde = new NotaVerde();
        notaVermelha = new NotaVermelha();
        notaAmarela = new NotaAmarela();
        notaAzul = new NotaAzul();
        if(state != GameState.GAMEOVER){
            if (noteSpawnCount == 0){
                if(aleatorio2 < noteSpawnRatio){
                    if(aleatorio == 0){
                        addObject(notaVerde, 200, 10);
                    }
                    else if(aleatorio == 1){
                        addObject(notaAmarela, 250, 10);
                    }
                    else if(aleatorio == 2){
                        addObject(notaVermelha, 300, 10);
                    }
                    else if(aleatorio == 3){
                        addObject(notaAzul, 350, 10);
                    }
                }
            }
            if (noteSpawnCount++ == noteSpawnLimit)
            {
                noteSpawnCount=0;
            }  
        }

    }
    public void noteRight(){
        score.addScore(100);
    }
    public void noteWrong(){
        if(score.getScore() >= 10){
            score.removePoints(10);
        }
    }
}
