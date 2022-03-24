import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
   
public class MyWorld extends World
{
    Bricks myBrick = new Bricks();
    KeyBoardPlayer players = new KeyBoardPlayer();
    Ladders myLadder =  new Ladders();
    Bars myBar = new Bars();
    Enemy enemy = new Enemy();
    PlayerInfo mousePlayer = new PlayerInfo();
    Text Score = new Text("Score: 0");
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // 30.5 bricks wide and 30.5 bricks tall
        super(720, 630, 1); 
        
         //GreenfootImage(getWidth(),getHeight());
         GreenfootImage img = getBackground();
        img.setColor(Color.BLACK);
        img.fillRect(0,0,getWidth(),getHeight());
        setBackground(img);
        GreenfootImage brickImg = myBrick.getImage();
        GreenfootImage ladderImg = myLadder.getImage();
        GreenfootImage playerImg = players.getImage();
        createWalls(30 , brickImg.getHeight()/2,brickImg.getWidth()/2);
        //createWalls(30 , brickImg.getHeight()* 1/2,brickImg.getWidth()/2);
        createWalls(30 , getHeight()-brickImg.getHeight()*13/2,brickImg.getWidth()*1/2);
        System.out.println(ladderImg.getWidth());
         System.out.println(ladderImg.getHeight());
        createWalls(13,(getHeight() - brickImg.getHeight()*(10+1/2)),0);
        createWalls(10,(getHeight() - brickImg.getHeight()*22),brickImg.getWidth()*(4+1/2));
        createWalls(4,(getHeight() - brickImg.getHeight()*14),brickImg.getWidth()*(12 + 1/2));
        //createLadders(16,brickImg.getWidth()*(12) ,(getHeight() - brickImg.getHeight()*(4+1/2)),false);
        createWalls(4,(getHeight() - brickImg.getHeight()*14),brickImg.getWidth()*(3+1/2));
        addObject(players, playerImg.getWidth(),getWidth() - brickImg.getWidth()*16 - playerImg.getWidth()/2);
        createWalls(5,(getHeight()-brickImg.getHeight()*10),brickImg.getWidth()*(20+1/2));
        createLadders(16,(brickImg.getWidth())*(12+1/2) ,(getHeight() - brickImg.getHeight()*(10+1/2)),false);
        createLadders(8,brickImg.getWidth()*(9+1/2),(getHeight()-brickImg.getHeight()*19),true);
        createBars(13,(brickImg.getWidth())*(3+1/2),(getHeight()-brickImg.getHeight()*20));
        //createLadders(12,myBrick.getImage().getWidth()*12,0,true);
        //addObject(mousePlayer, getWidth()/3,getHeight()/3);
        addObject(enemy, brickImg.getWidth()*20,getWidth() - brickImg.getWidth()*16 - playerImg.getWidth()/2);
        addObject(Score,Score.getImage().getWidth()/2,getHeight()-Score.getImage().getHeight()/2);
        //addObject(Score,Score.getImage().getWidth()/2,getHeight()-Score.getImage().getHeight()/2);
    }
    public void act(){
    int score = players.getScore();
    if(score > 0 ){
    
        removeObject(Score);
        Score = new Text("Score: "+score);
        addObject(Score,Score.getImage().getWidth()/2,getHeight()-Score.getImage().getHeight()/2);
    }
    }
    public void createLadders(int n , int x, int y, boolean vertical){
        GreenfootImage ladderImg = myLadder.getImage();
        for(int i = 0 ; i < n;i++){
            Ladders myFirstLadder = new Ladders();
            if(vertical == false){
                
                addObject(myFirstLadder,x+ (ladderImg.getWidth()* (i)), y);
            }else{
                addObject( myFirstLadder,x,y+(ladderImg.getHeight()*i));
            }
        }
    }
    public void createWalls(int n, int y,int x){
        GreenfootImage brickImg = myBrick.getImage();
        for(int i = 0 ; i < n; i ++){
            Bricks bricks = new Bricks();
            this.addObject(bricks, x+(brickImg.getWidth()) * i, y);
        
        }
    }
    public void createBars(int n, int x, int y){
        GreenfootImage barImg = myBar.getImage();
        for(int i = 0 ; i < n; i ++){
            Bars bars = new Bars();
            this.addObject(bars, x+(barImg.getWidth()) * i, y);
        
        }
    }
}
