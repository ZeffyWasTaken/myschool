import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
import java.util.ArrayList;

/**
 * Write a description of class Enemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy extends Player
{
    //List<Player> cls = new ArrayList<Player>(getWorld().getObjects(KeyBoardPlayer.class));
        
       //List<Actor> actors = getWorld().getObjects(Player.class);
       //List <Actor> PLAYERS = getWorld().getObjects(Player.class);
       //incompatible types: inference variable A has incompatible equality

    public void act()
    {
        // Add your action code here.
        super.act();
        //List<Player> cls = new ArrayList<Player>(getWorld().getObjects(KeyBoardPlayer.class));
        //System.out.println("Len-"+cls.get(0).getX()+"--"+cls.get(0).getY());
    }
    public int getPlayerX(){
         List<Player> cls = new ArrayList<Player>(getWorld().getObjects(KeyBoardPlayer.class));
         return cls.get(0).getX();
    
    }
       public int getPlayerY(){
         List<Player> cls = new ArrayList<Player>(getWorld().getObjects(KeyBoardPlayer.class));
         return cls.get(0).getY();
    
    }
    @Override
    public void moveMyObject(int n, boolean jump){
         String[] images = { "enemy_run_00.png","enemy_run_01.png","enemy_run_02.png", "enemy_run_03.png"};
          
          currentImg++;
         // System.out.println("From Enemy:"+n+"-"+currentBarImg);
                if(currentImg >= images.length){
                    currentImg = 0;
                }
                GreenfootImage img1 = new GreenfootImage(images[currentImg]);
                if(n < 0){
                     img1.mirrorHorizontally();
                    setImage(img1);
        
                    setLocation(getX()+n,getY());
                    }else{
             if(n > 0){
            setImage(img1);
           
            setLocation(getX()+n,getY());
        }else{
            if( n == 0){
                setImage("enemy_bar_hang_00.png");
                setLocation(getX(),getY()+3);
            }
        }
        }
    
    }
    @Override 
    public String getCommand(){
        System.out.println("PlayerX--"+getPlayerX() + "----" + getX());
        String dir = "";
            //System.out.println("detected");
            if (getX()>getPlayerX()) {
                return "left";
                 //System.out.println("...");
                // dir = "left";
            } else if (getX() < getPlayerX()) {
                return "right";
                 //System.out.println("....");
                 //dir = "right";
            } 
             if (getY() < getPlayerY()) {
                System.out.println("DOWN");
                return "down";
               // dir = "down";
            } else if (getY() > getPlayerY()) {                        
                System.out.println("UP");
                return "up";
               //dir = "up";
            }
        
        //System.out.println("null");
        return "null";
    }
    //GreenfootImage ladImgg =new GreenfootImage("enemy_climb_ladder.png");
    @Override
      public void upDown(String str){
           
            GreenfootImage ladImgg =new GreenfootImage("enemy_climb_ladder.png");
            //GreenfootImage mirladImgg = new GreenfootImage(ladImg.mirrorHorizontally());
            ladImg++;
            if(ladImg > 2){
                ladImg = 1;
                setImage(ladImgg);
            }else if(ladImg == 2){
                //GreenfootImage mirladImgg = ladImgg.mirrorHorizontally();
                ladImgg.mirrorHorizontally();
                setImage(ladImgg);
                
                //System.out.println("2");
            }else if(ladImg == 1){
                setImage(ladImgg);
                //System.out.println("1");
            }
            //setImage("player_climb_ladder.png");
           if(str == "up"&&  BrickAbove() == false){
                  setLocation(getX(), getY() -3);
            }
            else if(str == "down" && BrickBelow() == false ){
                setLocation(getX(), getY() +3);
            }
        }
    @Override
      public void moveMyBar(int n){
           String[] barImages = { "enemy_bar_hang_00.png" , "enemy_bar_hang_01.png"};
                currentBarImg++;
                if(currentBarImg >= barImages.length){
                    currentBarImg = 0;
                }
                GreenfootImage img1 = new GreenfootImage(barImages[currentBarImg]);
                if(n < 0){
                     img1.mirrorHorizontally();
                    setImage(img1);
        
                    setLocation(getX()+n,getY());
                    }else{
             if(n > 0){
            setImage(img1);
           
            setLocation(getX()+n,getY());
        }else{
            if( n == 0){
                setImage("player_bar_hang_00.png");
                setLocation(getX(),getY()+3);
            }
        }
        }
    }
}
