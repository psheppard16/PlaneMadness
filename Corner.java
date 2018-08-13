
/**
 * Write a description of class Corner here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Corner
{
    double xPos;
    double yPos;
    public Corner(double xPos, double yPos)
    {
        this.xPos = xPos;
        this.yPos = yPos;
    }
    
    public void moveMagnet(int playerX, int playerY, int xLoc, int yLoc, int magnetD, int magnetS)
    {
        if(Math.sqrt(Math.pow((playerX - xPos - xLoc), 2.0) + 
            Math.pow((playerY - yPos - yLoc), 2.0)) < magnetD)
        {
            double xDistance = playerX - xPos - xLoc;
            double yDistance = playerY - yPos - yLoc;
            double angle = Math.toDegrees(Math.atan2(yDistance, xDistance));
            xPos += magnetS * Math.cos(Math.toRadians(angle));
            yPos += magnetS * Math.sin(Math.toRadians(angle));
        }
    }
}
