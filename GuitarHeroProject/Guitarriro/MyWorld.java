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
    //5% de chance
    private int noteSpawnRatio = 10;
    
    private int timer = 12960;
    
    //limite e quantidade
    private int noteSpawnCount = 0;
    private int noteSpawnLimit = 5;
    
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
    private BotaoMenu botaoMenu;
    private FinalScore finalScore;
    private GameOver gameOver;
    
    private Good good;
    private VeryGood veryGood;
    private Great great;
    
    GreenfootSound musica = new GreenfootSound("bytheway.mp3");
    
    //Game State
    private enum GameState{MENU,PLAYING,GAMEOVER};    
    private GameState state;

    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        prepareMenu();
        //if(state == GameState.PLAYING){
            
        //}
    }
    
    public void act(){
        switch(state)
        {
            case MENU:
            {
                actMenu();
                break;
            }            
            case PLAYING:
            {    
                musica.play();
                actPlaying();

                //musica.stop();
                break;
            }            
            case GAMEOVER:
            {
                actGameOver();
                break;
            }
        }
    }
    
    private void prepareMenu()
    {
        // Clear the world
        removeObjects(getObjects(Actor.class));
                
        // Create the menu
        botaoMenu = new BotaoMenu();   
        
        addObject(new MenuFundo(), getWidth()/2, (getHeight()/2)-5);
        addObject(botaoMenu, getWidth()/2, (getHeight()/2)+50);
      
        // Set the game state
        state = GameState.MENU;
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
    
    private void prepareGameOver()
    {
        // Clear the world
        removeObjects(getObjects(Actor.class)); 
      
        // Add gameover screen
        gameOver = new GameOver();
        addObject(gameOver,getWidth()/2,getHeight()/2);
        
        //Add the final score
        int fscore = score.getScore();
        finalScore = new FinalScore(fscore);
        addObject(finalScore,getWidth()-75,60);
        good = new Good();
        veryGood = new VeryGood();
        great = new Great();
        
        if(fscore <= 5000){
            addObject(good, getWidth()/2 ,getHeight()/2);
        }else if(fscore > 5000 || fscore < 7000){
            addObject(veryGood, getWidth()/2 ,getHeight()/2);
        }else if(fscore >= 7000){
            addObject(great, getWidth()/2 ,getHeight()/2);        
        }
        
        // Set the game state
        state = GameState.GAMEOVER;           
    }
    
    public void actPlaying(){
        int aleatorio = Greenfoot.getRandomNumber(4);
        int aleatorio2 = Greenfoot.getRandomNumber(100);
        notaVerde = new NotaVerde();
        notaVermelha = new NotaVermelha();
        notaAmarela = new NotaAmarela();
        notaAzul = new NotaAzul();
        if(timer > 0){
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
            timer--;
            if(timer == 0){
                prepareGameOver();
            }
        }

    }

    public void actMenu()
    {
        if(Greenfoot.mouseClicked(botaoMenu))
        {
            preparePlaying();
        }
    }
    
    public void actGameOver()
    {
        if(Greenfoot.mouseClicked(gameOver) ||
           Greenfoot.mouseClicked(finalScore))
        {
            prepareMenu();
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
