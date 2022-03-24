import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.util.List;
/**
 * Write a description of class BetterPlayer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BetterPlayer extends Player
{
 
    //MouseInfo currentMouseInfo = Greenfoot.getMouseInfo(); 
    public void act()
    {
        super.act();
        
        // getCommand();        
        // Add your action code here.
    }
    @Override 
    public String getCommand(){
        MouseInfo currentMouseInfo = Greenfoot.getMouseInfo();
        if(currentMouseInfo != null){
            int myMouseX = currentMouseInfo.getX();
            int myMouseY = currentMouseInfo.getY();
            //System.out.println("detected");
            if (getX()-getImage().getWidth()>myMouseX) {
                return "left";
            } else if (getX()+getImage().getWidth() < myMouseX) {
                return "right";
            } else if (myMouseY > getY()) {
                return "down";
            } else if (myMouseY < getY()) {                        
                return "up";
            }
        }
       // System.out.println("null");
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
