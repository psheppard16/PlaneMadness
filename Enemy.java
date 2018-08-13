
/**
 * Write a description of class Enemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.awt.image.BufferedImage;
import javax.swing.*;
import javax.imageio.ImageIO;
import java.io.*;
import java.awt.*;
import java.util.ArrayList;
import java.awt.geom.Line2D;
public class Enemy
{
    double xPos;
    double yPos;
    GameLoop gameLoop;
    BufferedImage image;
    BufferedImage origionalImage;
    String moveType;
    double angle;
    double speed;
    double currentSpeed;
    double damage;
    int xSize;
    int ySize;
    double health;
    Bullet bullet;
    boolean shootsBullet;
    int maxShotCD;
    int shotCD;
    int slowCD;
    int turnRate;
    int coinAmount;
    String type;
    String coinType;
    ArrayList<Corner> corners;
    public Enemy(int xPos, GameLoop gameLoop, String type)
    {
        this.xPos = xPos;
        this.type = type;
        this.yPos = 0;
        this.gameLoop = gameLoop;
        if (type.equals("dasher"))
        {
            try
            {
                origionalImage = ImageIO.read(new File("images/dasherImage.png"));
                image = ImageIO.read(new File("images/dasherImage.png"));
            }
            catch (IOException e)
            {
            }
            this.moveType = "linear";
            coinAmount = 5;
            coinType = "small";
            this.damage = 10;
            this.angle = 270;
            this.speed = 7;
            this.xSize = 90;
            this.ySize = 115;
            this.health = 100.0;
            this.shootsBullet = false;
            corners = new ArrayList<Corner>();
            corners.add(new Corner(0, 57));
            corners.add(new Corner(20, 42));
            corners.add(new Corner(34, 42));
            corners.add(new Corner(34, 15));
            corners.add(new Corner(50, 0));
            corners.add(new Corner(50, 10));
            corners.add(new Corner(60, 6));
            corners.add(new Corner(60, 43));
            corners.add(new Corner(89, 57));
            corners.add(new Corner(60, 72));
            corners.add(new Corner(60, 108));
            corners.add(new Corner(50, 104));
            corners.add(new Corner(50, 114));
            corners.add(new Corner(34, 99));
            corners.add(new Corner(34, 72));
            corners.add(new Corner(20, 72));
            corners.add(new Corner(0, 57));
        }
        else if (type.equals("asteroid"))
        {
            try
            {
                origionalImage = ImageIO.read(new File("images/dasherImage.png"));
                image = ImageIO.read(new File("images/dasherImage.png"));
            }
            catch (IOException e)
            {
            }
            this.moveType = "linear";
            coinAmount = 5;
            coinType = "small";
            this.damage = 10;
            this.angle = Utility.random(200, 340);
            this.speed = 7;
            this.xSize = 90;
            this.ySize = 115;
            this.health = 100.0;
            this.shootsBullet = false;
            corners = new ArrayList<Corner>();
            corners.add(new Corner(10, 0));
            corners.add(new Corner(40, 6));
            corners.add(new Corner(35, 10));
            corners.add(new Corner(40, 20));
            corners.add(new Corner(30, 20));
            corners.add(new Corner(40, 35));
            corners.add(new Corner(20, 40));
            corners.add(new Corner(13, 33));
            corners.add(new Corner(5, 40));
            corners.add(new Corner(0, 20));
            corners.add(new Corner(5, 10));
            corners.add(new Corner(0, 5));
            corners.add(new Corner(10, 0));
        }
        else if (type.equals("diveBomber"))
        {
            try
            {
                origionalImage = ImageIO.read(new File("images/diveBomberImage.png"));
                image = ImageIO.read(new File("images/diveBomberImage.png"));
            }
            catch (IOException e)
            {
            }
            this.moveType = "loopy";
            coinAmount = 10;
            coinType = "small";
            this.damage = 10;
            this.turnRate = 4;
            this.angle = 270;
            this.speed = 7;
            this.xSize = 50;
            this.ySize = 50;
            this.health = 100.0;
            this.shootsBullet = false;
            corners = new ArrayList<Corner>();
            corners.add(new Corner(0, 24));
            corners.add(new Corner(16, 17));
            corners.add(new Corner(39, 0));
            corners.add(new Corner(50, 6));
            corners.add(new Corner(48, 10));
            corners.add(new Corner(40, 7));
            corners.add(new Corner(36, 14));
            corners.add(new Corner(47, 19));
            corners.add(new Corner(47, 30));
            corners.add(new Corner(36, 35));
            corners.add(new Corner(40, 42));
            corners.add(new Corner(48, 39));
            corners.add(new Corner(49, 43));
            corners.add(new Corner(39, 50));
            corners.add(new Corner(16, 32));
            corners.add(new Corner(0, 24));
        }
        else if (type.equals("shooter"))
        {
            try
            {
                origionalImage = ImageIO.read(new File("images/shooterImage.png"));
                image = ImageIO.read(new File("images/shooterImage.png"));
            }
            catch (IOException e)
            {
            }
            this.moveType = "linear";
            coinAmount = 15;
            coinType = "small";
            this.health = 100.0;
            this.angle = 270;
            this.speed = 3;
            this.xSize = 90;
            this.ySize = 115;
            this.shootsBullet = true;
            this.shotCD = 0;
            this.maxShotCD = 100;
            corners = new ArrayList<Corner>();
            corners = new ArrayList<Corner>();
            corners.add(new Corner(0, 57));
            corners.add(new Corner(20, 42));
            corners.add(new Corner(34, 42));
            corners.add(new Corner(34, 15));
            corners.add(new Corner(50, 0));
            corners.add(new Corner(50, 10));
            corners.add(new Corner(60, 6));
            corners.add(new Corner(60, 43));
            corners.add(new Corner(89, 57));
            corners.add(new Corner(60, 72));
            corners.add(new Corner(60, 108));
            corners.add(new Corner(50, 104));
            corners.add(new Corner(50, 114));
            corners.add(new Corner(34, 99));
            corners.add(new Corner(34, 72));
            corners.add(new Corner(20, 72));
            corners.add(new Corner(0, 57));
            this.bullet = new Bullet(this.xPos, this.yPos, gameLoop, 270, "machineGun", this);
        }
        this.currentSpeed = speed;
        corners = Utility.rotateCorners(xSize(), ySize(), corners, angle);
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
        if (moveType.equals("linear"))
        {
            xPos -= currentSpeed * Math.cos(Math.toRadians(angle));
            yPos -= currentSpeed * Math.sin(Math.toRadians(angle));
        }
        if (moveType.equals("loopy"))
        {
            xPos -= currentSpeed * Math.cos(Math.toRadians(angle));
            if (angle > 180 && angle < 360)
            {
                yPos -= 2 * currentSpeed * Math.sin(Math.toRadians(angle));
            }
            else
            {
                yPos -= currentSpeed * Math.sin(Math.toRadians(angle));
            }
            if (angle <= 360 - turnRate)
            {
                angle += turnRate;
            }
            else
            {
                angle = 0;
            }
        }
    }
    
    public void moveMagnet(int playerX, int playerY, int magnetD, int magnetS)
    {
        if(Math.sqrt(Math.pow((playerX - xPos), 2.0) + 
            Math.pow((playerY - yPos), 2.0)) < magnetD)
        {
            double xDistance = playerX - xPos;
            double yDistance = playerY - yPos;
            double angle = Math.toDegrees(Math.atan2(yDistance, xDistance));
            xPos -= magnetS * Math.cos(Math.toRadians(angle));
            yPos -= magnetS * Math.sin(Math.toRadians(angle));
        }
    }
}
