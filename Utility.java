
/**
 * Write a description of class Utility here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
public class Utility
{
    public static BufferedImage rotateImage(BufferedImage image, double angleD)
    {
        double angle = Math.toRadians(angleD);
        double sin = Math.abs(Math.sin(angle)), cos = Math.abs(Math.cos(angle));
        int w = image.getWidth(), h = image.getHeight();
        int neww = (int)Math.floor(w*cos+h*sin), newh = (int)Math.floor(h*cos+w*sin);
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice gd = ge.getDefaultScreenDevice();
        GraphicsConfiguration gc = gd.getDefaultConfiguration();
        BufferedImage result = gc.createCompatibleImage(neww, newh, Transparency.TRANSLUCENT);
        Graphics2D g = result.createGraphics();
        g.translate((neww-w)/2, (newh-h)/2);
        g.rotate(angle, w/2, h/2);
        g.drawRenderedImage(image, null);
        g.dispose();
        return result;
    }

    public static ArrayList<Corner> rotateCorners(double xSize, double ySize, ArrayList<Corner> corners, double angleD)
    {
        double angle = Math.toRadians(angleD);
        double centerX = xSize / 2;
        double centerY = ySize / 2;
        for (int i = 0; i < corners.size(); i++)
        {
            double x = corners.get(i).xPos;
            double y = corners.get(i).yPos;
            corners.get(i).xPos = centerX + (x-centerX)*Math.cos(angle) - (y-centerY)*Math.sin(angle);
            corners.get(i).yPos = centerY + (x-centerX)*Math.sin(angle) + (y-centerY)*Math.cos(angle);
        }
        return corners;
    }
    
    /**
     * Generates a random number with a given upper and lower bound
     * @return the random number
     */
    public static int random(int lowerBound, int upperBound)
    {
        int difference = upperBound - lowerBound;
        int randomNumber = ((int)((difference + 1)*Math.random() + lowerBound));  
        return randomNumber;
    }
}
