import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.util.List;

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlayerInfo extends Actor
{
    
    String[] images = { "player_run_00.png","player_run_01.png","player_run_02.png", "player_run_03.png"};
    String[] barImages = { "player_bar_hang_00.png" , "player_bar_hang_01.png"};
    int currentBarImg = 0;  
     int ladImg = 0;
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int currentImg = 0;
    int xPos;
    int yPos;
    int leftNum = 1;
    GreenfootImage myImage = getImage();
    boolean LaddersAbove = false;
    boolean LaddersBelow = false;
    public void addedToWorld(World w){
        xPos = getX();
        yPos = getY();
    }
    public void act()
    {
          
 
        World myWorld = getWorld();
        MouseInfo currentMouseInfo = Greenfoot.getMouseInfo();     
        if(getMouseInfo() != null){
            int myMouseX = currentMouseInfo.getX();
            int myMouseY = currentMouseInfo.getY();
            
             Actor intersect = getOneIntersectingObject(Ladders.class);
                // if(isTouching(Ladders.class)){
                    // upDown();
                // }
            LaddersHeight();
            if(isOnGround() || isOnLadders()){
                // System.out.println("1"+ LaddersBelow);
                
                if(getX()-getImage().getWidth()>myMouseX && BrickLeft() == false ){
                    
                   
                    if(getX() > myImage.getWidth()/2){
                    moveMyObject(-3, false);
                    }
                       
                    
                }
               else if(getX()+getImage().getWidth() < myMouseX && BrickRight() == false ){
                  
                    if(getX() < myWorld.getWidth()- myImage.getWidth()/2){
                    moveMyObject(3, false);
                    }
                   
                }
                
                if(isOnLadders()){
                    //System.out.println("3");
                    if(myMouseY > getY()){
                       // if(isOnGround() == false){
                        upDown("down");
                   // }
                        
                    }
                    
                    else if(myMouseY < getY()){
                         //if(isOnGround() == false){
                        upDown("up");
                    //}
                        
                    }
                }
                
                
                
        
                
        
            
            }  // else 
            else {
                if(isOnBars()){
                    if(getX()-getImage().getWidth()>myMouseX && myMouseY < getY() ){
                    
                   
                    if(getX() > myImage.getWidth()/2){
                    moveMyBar(-3);
                    }
                       
                    
                }
               else if(getX()-getImage().getWidth()<myMouseX && myMouseY < getY()){
                  
                    if(getX() < myWorld.getWidth()- myImage.getWidth()/2){
                    moveMyBar(3);
                    }
                }else{
                    if(myMouseY > getX()){
                           moveMyObject(0,false);
                    
                    }
                }
                }else{
                //System.out.println("2");
                moveMyObject(0,true);
                }
            
            }
            }else if(isOnGround() == false && isOnLadders() == false){
               moveMyObject(0,true);
                
            
        }
    }
        
        public void upDown(String str){
           
            GreenfootImage ladImgg =new GreenfootImage("player_climb_ladder.png");
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
        public void moveMyBar(int n){
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
        public void moveMyObject(int n, boolean jump){
        currentImg++;
        if(currentImg >= images.length){
        currentImg=0;
    }
        
        GreenfootImage img1 = new GreenfootImage(images[currentImg]);
        if(n < 0){
            img1.mirrorHorizontally();
            setImage(img1);
            System.out.println(currentImg);
        setLocation(getX()+n,getY());
    }else{
         if(n > 0){
        setImage(img1);
       System.out.println(currentImg);
        setLocation(getX()+n,getY());
    }else{
        if( n == 0){
            setImage("player_bar_hang_00.png");
            setLocation(getX(),getY()+3);
        }
    }
        }
       



}

        public boolean isOnLadders(){
                 //   System.out.println(isTouching(Ladders.class));
            return isTouching(Ladders.class);
                    
                }
                 public boolean isOnBars(){
                   //System.out.println(isTouching(Bars.class));
                    return isTouching(Bars.class);
                    
                }
                
                public void LaddersHeight(){
                   
                        List<Actor> myList = new ArrayList();
                        myList = getWorld().getObjects(null);
                        for(int i = 0;i < myList.size();i++){
                            if(myList.get(i).getClass()==Ladders.class){
                         
                                int dy = myList.get(i).getY();
                                Actor intersect = getOneIntersectingObject(Ladders.class);
                            if(intersect!=null){
                           // System.out.println("Is touching-"+dy+"--"+getY());
                            setLaddersLocation(dy);
                            break;
                            }
                        }
                        }
                }
                        public void setLaddersLocation(int dy){
                    Actor intersect = getOneIntersectingObject(Ladders.class);
                        if(isOnLadders()){
                             if(dy < getY()){
                            LaddersAbove = true;
                        }
                        else if(dy>getY()){
                            LaddersBelow = true;
                        }

                        }           
                    
                }
                public boolean isOnGround(){
                    boolean isOnGround = false;
                    
    
                    if(getOneObjectAtOffset(getImage().getWidth()-20,getImage().getHeight()-5, Bricks.class)  != null ){
                        isOnGround = true;
                    }
                    return isOnGround;
                }
                public boolean BrickBelow(){
                    boolean BrickBelowBool = false;
                    if(getOneObjectAtOffset(0,getImage().getHeight()/2 , Bricks.class) != null){
                        BrickBelowBool = true;
                        //System.out.println("TRUEEEEEEEEEEEEEEEEEEEEEE");
                    }else{
                        //System.out.println("FALSEEEEEEEEEEEEEEEEEEEEEE");
                    }
                    return BrickBelowBool;
                }
                 public boolean BrickAbove(){
                    boolean BrickAboveBool = false;
                    if(getOneObjectAtOffset(0,-getImage().getHeight()/2 , Bricks.class) != null){
                        BrickAboveBool = true;
                        //System.out.println("trueeeeeeeeeeeeeeeee");
                    }else{
                        //System.out.println("falseeeeeeeeeeeeeeeee");
                    }
                    return BrickAboveBool;
                }
                  public boolean BrickLeft(){
                    boolean BrickLeftBool = false;
                    if(getOneObjectAtOffset(-getImage().getWidth()/2,0 , Bricks.class) != null){
                        BrickLeftBool = true;
                        //System.out.println("trueeeeeeeeeeeeeeeee");
                    }else{
                        //System.out.println("falseeeeeeeeeeeeeeeee");
                    }
                    return BrickLeftBool;
                }
                public boolean BrickRight(){
                    boolean BrickRightBool = false;
                    if(getOneObjectAtOffset(getImage().getWidth()/2,0 , Bricks.class) != null){
                        BrickRightBool = true;
                       // System.out.println("trueeeeeeeeeeeeeeeee");
                    }else{
                        //System.out.println("falseeeeeeeeeeeeeeeee");
                    }
                    return BrickRightBool;
                }
                public MouseInfo getMouseInfo(){
                    MouseInfo myMouseInfo = null;
                    MouseInfo newMouseInfo = Greenfoot.getMouseInfo();
                    if(newMouseInfo!= null){
                       myMouseInfo = newMouseInfo;
                    }
                    return myMouseInfo;
                }
}

// import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

// /**
 // * Write a description of class PlayerInfo here.
 // * 
 // * @author (your name) 
 // * @version (a version number or a date)
 // */
// public class PlayerInfo extends Actor
// {
    // /**
     // * Act - do whatever the PlayerInfo wants to do. This method is called whenever
     // * the 'Act' or 'Run' button gets pressed in the environment.
     // */
    
        // int prevMouseX = 0;
        // int prevMmouseY =0;
        // GreenfootImage myImage = getImage();
         // int currentImg = 0;
         // String[] images = { "player_run_00.png","player_run_01.png","player_run_02.png", "player_run_03.png"};
    // public void act()
    // {        MouseInfo currentMouseInfo = getMouseInfo();        
        
        // World myWorld = getWorld();
         // Actor intersect = getOneIntersectingObject(Ladders.class);
            // if(currentMouseInfo !=null){           
             // int myMouseX = currentMouseInfo.getX();
            // int myMouseY = currentMouseInfo.getY();
        
            // //System.out.println("Checking mouse coord-"+prevMouseX+"--"+myMouseX);
               // if(isOnGround()){
           
            // if(getX()-getImage().getWidth() > myMouseX){
                // if(getX()-getImage().getWidth()/2>= myMouseX){
            // moveMyObject(-3,false);
            // }
            // }
            
            // else if(getX()+getImage().getWidth() < myMouseX){
                // //if(getX() < myWorld.getWidth()- myImage.getWidth()/2){
                   // if(getX()+getImage().getWidth() <= myMouseX){
                // moveMyObject(3,false);
                // }
                   // // }
            // }
        // }else{
            // moveMyObject(0,true);
        // }
        
        // prevMouseX = myMouseX;
        // prevMmouseY  = myMouseY;        
        // }
    // }
    // public void moveMyObject(int n, boolean jump){
        // currentImg++;
        // if(currentImg >= images.length){
        // currentImg=0;
    // }
    
    // GreenfootImage img1 = new GreenfootImage(images[currentImg]);
    // if(n< 0){
         // img1.mirrorHorizontally();
            // setImage(img1);
        // move(n);
        // //setLocation(prevMouseX+n,getY());
    // }
    // else if(n > 0){
         // setImage(img1);
        // move(n);
        // //setLocation(prevMouseX+n,getY());
    // }
    // else if(n==0){
         // setImage("player_bar_hang_00.png");
            // setLocation(getX(),getY()+3);
    // }
// }
      // public boolean isOnGround(){
        // boolean isOnGround = false;
                    // if(getOneObjectAtOffset(getImage().getWidth()-8,getImage().getHeight()-8, Bricks.class)  != null ){
                        // isOnGround = true;
                    // }
                    // return isOnGround;
                // }
    // public MouseInfo getMouseInfo(){
        // MouseInfo myMouseInfo = null;
        // MouseInfo newMouseInfo = Greenfoot.getMouseInfo();
        // if(newMouseInfo!= null){
           // myMouseInfo = newMouseInfo;
        // }
        // return myMouseInfo;
    // }
// }
