
/**
 * Write a description of class Background here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
public class Background
{
    BufferedImage image;
    int xSize;
    int ySize;
    int yPos;
    int xPos;
    public Background(int xSize, int ySize, BufferedImage image)
    {
        this.image = image;
        this.xSize = xSize;
        this.ySize = ySize;
        this.xPos = 0;
        this.yPos = 0;
    }
    
    public Background(int yPos, int xSize, int ySize, BufferedImage image)
    {
        this.image = image;
        this.xSize = xSize;
        this.ySize = ySize;
        this.xPos = 0;
        this.yPos = yPos;
    }
}
