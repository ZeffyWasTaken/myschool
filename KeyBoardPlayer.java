import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class KeyBoardPlayer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class KeyBoardPlayer extends Player
{
    /**
     * Act - do whatever the KeyBoardPlayer wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
        super.act();
    }
    @Override
    public String getCommand(){
        
        if(Greenfoot.isKeyDown("left")){
            return "left";
        }else{
            if(Greenfoot.isKeyDown("right")){
                return "right";
                }else{
                
                if(Greenfoot.isKeyDown("down")){
                    return "down";
                
                }else{
                    if(Greenfoot.isKeyDown("up")){
                        return "up";
                    }
                }
            }
        }
        
        return "null";
    }
    @Override
    public void getGold(){
        if(isTouching(Gold.class)){
            removeTouching(Gold.class);
            Score = 250+Score;
        }
    }
}
