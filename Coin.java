
/**
 * Write a description of class Bullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.awt.image.BufferedImage;
import java.lang.Math;
import javax.swing.*;
import java.io.*;
import javax.imageio.ImageIO;
import java.awt.*;
import java.util.ArrayList;
import java.awt.geom.Line2D;
public class Coin
{
    double xPos;
    double yPos;
    double xSize;
    double ySize;
    GameLoop gameLoop;
    String moveType;
    double angle;
    double speed;
    String coinType;
    boolean pickedUp;
    double value;
    ArrayList<Corner> corners;
    public Coin(double xPos, double yPos, GameLoop gameLoop, String coinType)
    {
        this.xPos = xPos;
        this.yPos = yPos;
        this.gameLoop = gameLoop;
        this.pickedUp = false;
        angle = Utility.random(0, 360);
        speed = Utility.random(10, 2);
        if (coinType.equals("small"))
        {
            this.value = 10;
            this.xSize = 10;
            this.ySize = 20;
            corners = new ArrayList<Corner>();
            corners.add(new Corner(4, 0));
            corners.add(new Corner(9, 9));
            corners.add(new Corner(4, 19));
            corners.add(new Corner(0, 10));
            corners.add(new Corner(4, 0));
        }
        corners = Utility.rotateCorners(xSize(), ySize(), corners, angle);
    }

    public void Bullet(double xPos, double yPos, Coin coin)
    {
        this.xPos = xPos;
        this.yPos = yPos;
        this.gameLoop = coin.gameLoop;
        this.angle = 0;
        this.pickedUp = false;
        this.coinType = coin.coinType;
        this.value = coin.value;
        this.xSize = coin.xSize;
        this.ySize = coin.ySize;
    }

    public int xSize()
    {
        double angleR = Math.toRadians(angle);
        double cos = Math.abs(Math.cos(angle));
        double sin = Math.abs(Math.sin(angle));
        return (int)Math.floor(xSize * cos + ySize * sin);
    }

    public int ySize()
    {
        double angleR = Math.toRadians(angle);
        double cos = Math.abs(Math.cos(angle));
        double sin = Math.abs(Math.sin(angle));
        return (int)Math.floor(ySize * cos + xSize * sin);
    }

    public boolean collideCheck(double x, double y, ArrayList<Corner> corners2)
    {
        for(int i = 0; i < corners2.size() - 1; i++)
        {
            for(int j = 0; j < corners.size() - 1; j++)
            {
                if (Line2D.linesIntersect(corners.get(j).xPos + xPos, corners.get(j).yPos + yPos, corners.get(j + 1).xPos + xPos, corners.get(j + 1).yPos + yPos, 
                    corners2.get(i).xPos + x, corners2.get(i).yPos + y, corners2.get(i + 1).xPos + x, corners2.get(i + 1).yPos + y))
                {
                    return true;
                }
            }
        }
        return false;
    }

    public void move()
    {
        xPos -= speed * Math.cos(Math.toRadians(angle));
        yPos -= speed * Math.sin(Math.toRadians(angle));
        if(speed > 0)
        {
            speed -= 1;
        }
        yPos += 7;
    }

    public void moveMagnet(int playerX, int playerY, int magnetD, int magnetS)
    {
        if(Math.sqrt(Math.pow((playerX - xPos), 2.0) + 
            Math.pow((playerY - yPos), 2.0)) < magnetD)
        {
            double xDistance = playerX - xPos;
            double yDistance = playerY - yPos;
            angle = Math.toDegrees(Math.atan2(yDistance, xDistance));
            xPos += magnetS * Math.cos(Math.toRadians(angle));
            yPos += magnetS * Math.sin(Math.toRadians(angle));
        }
    }
}
