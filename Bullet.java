
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
public class Bullet
{
    double xPos;
    double yPos;
    int turnRate;
    int fireDelay;
    GameLoop gameLoop;
    BufferedImage image;
    BufferedImage origionalImage;
    String moveType;
    double angle;
    double speed;
    boolean isEnemy;
    String bulletType;
    boolean exploded;
    int xSize;
    int ySize;
    double damage;
    int timer;
    ArrayList<Corner> corners;
    Player player;
    Enemy enemy;
    public Bullet(double xPos, double yPos, GameLoop gameLoop, double angle, String bulletType, Enemy enemy)
    {
        this.xPos = xPos;
        this.yPos = yPos;
        this.gameLoop = gameLoop;
        this.angle = angle;
        isEnemy = true;
        this.exploded = false;
        this.bulletType = bulletType;
        if (bulletType.equals("cannon"))
        {
            this.moveType = "linear";
            this.speed = 20;
            this.damage = 10;
            this.xSize = 8;
            this.ySize = 30;
            corners = new ArrayList<Corner>();
            corners.add(new Corner(4, 0));
            corners.add(new Corner(0, 3));
            corners.add(new Corner(0, 23));
            corners.add(new Corner(4, 29));
            corners.add(new Corner(7, 23));
            corners.add(new Corner(7, 3));
            corners.add(new Corner(4, 0));
        }
        else if (bulletType.equals("missle"))
        {
            this.moveType = "linearSpeedUp";
            this.speed = 3;
            this.damage = 20;
            this.xSize = 13;
            this.ySize = 15;
            corners = new ArrayList<Corner>();
            corners.add(new Corner(7, 0));
            corners.add(new Corner(10, 5));
            corners.add(new Corner(10, 11));
            corners.add(new Corner(11, 12));
            corners.add(new Corner(13, 15));
            corners.add(new Corner(10, 14));
            corners.add(new Corner(6, 14));
            corners.add(new Corner(2, 15));
            corners.add(new Corner(4, 12));
            corners.add(new Corner(5, 11));
            corners.add(new Corner(5, 5));
            corners.add(new Corner(7, 0));
        }
        else if (bulletType.equals("machineGun"))
        {
            this.moveType = "linear";
            this.speed = 20;
            this.damage = 5;
            this.xSize = 10;
            this.ySize = 10;
            corners = new ArrayList<Corner>();
            corners.add(new Corner(5, 0));
            corners.add(new Corner(10, 10));
            corners.add(new Corner(0, 10));
            corners.add(new Corner(5, 0));
        }
        else if (bulletType.equals("shotGunCannon"))
        {
            this.moveType = "linear";
            this.speed = 20;
            this.angle = Utility.random(70, 110);
            this.damage = 15;
            this.xSize = 8;
            this.ySize = 30;
            corners = new ArrayList<Corner>();
            corners.add(new Corner(0, 4));
            corners.add(new Corner(3, 0));
            corners.add(new Corner(23, 0));
            corners.add(new Corner(29, 4));
            corners.add(new Corner(23, 7));
            corners.add(new Corner(3, 7));
            corners.add(new Corner(0, 4));
            Utility.rotateCorners(xSize, ySize, corners, angle);
        }
        else if (bulletType.equals("flameThrower"))
        {
            this.moveType = "shortSpread";
            this.speed = 5;
            this.damage = 10;
            corners = new ArrayList<Corner>();
            corners.add(new Corner(0, 0));
            corners.add(new Corner(0, 2));
            corners.add(new Corner(0, 4));
            corners.add(new Corner(0, 6));
            corners.add(new Corner(0, 8));
            corners.add(new Corner(0, 10));
            corners.add(new Corner(0, 12));
            corners.add(new Corner(0, 14));
            this.xSize = 15;
            this.ySize = 1;
        }
        else if (bulletType.equals("iceRay"))
        {
            this.moveType = "linear";
            this.speed = 10;
            this.damage = 25;
            this.xSize = 0;
            this.ySize = 0;
        }
        else if (bulletType.equals("flakCannon"))
        {
            this.moveType = "linear";
            this.speed = 15;
            this.damage = 100;
            this.angle = 270;
            this.xSize = 40;
            this.ySize = 40;
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
        else if (bulletType.equals("flakCannonS"))
        {
            this.moveType = "linear";
            this.speed = 15;
            this.damage = 100;
            this.angle = Utility.random(260, 280);
            this.xSize = 20;
            this.ySize = 20;
            corners = new ArrayList<Corner>();
            corners.add(new Corner(5, 0));
            corners.add(new Corner(Utility.random(15, 20), Utility.random(5, 10)));
            corners.add(new Corner(Utility.random(7, 13), Utility.random(10, 13)));
            corners.add(new Corner(Utility.random(15, 20), Utility.random(15, 20)));
            corners.add(new Corner(Utility.random(5, 10), 20));
            corners.add(new Corner(Utility.random(0, 4), Utility.random(10, 13)));
            corners.add(new Corner(Utility.random(0, 4), Utility.random(0, 5)));
            corners.add(new Corner(5, 0));
        }
        else if (bulletType.equals("flakCannonSS"))
        {
            this.moveType = "linear";
            this.speed = 15;
            this.damage = 100;
            this.angle = Utility.random(250, 290);
            this.xSize = 10;
            this.ySize = 10;
            corners = new ArrayList<Corner>();
            corners.add(new Corner(5, 0));
            corners.add(new Corner(10, Utility.random(3, 5)));
            corners.add(new Corner(Utility.random(7, 10), 10));
            corners.add(new Corner(Utility.random(0, 2), Utility.random(7, 10)));
            corners.add(new Corner(Utility.random(0, 3), Utility.random(0, 3)));
            corners.add(new Corner(5, 0));
        }
        else if (bulletType.equals("laserBeam"))
        {
            this.moveType = "static";
            this.speed = 0;
            this.damage = 2;
            this.xSize = 20;
            this.ySize = 1000;
            corners = new ArrayList<Corner>();
            corners.add(new Corner(0, 0));
            corners.add(new Corner(20, 0));
            corners.add(new Corner(20, 1000));
            corners.add(new Corner(0, 1000));
            corners.add(new Corner(0, 0));
        }
        else if (bulletType.equals("lightningCannon"))
        {
            this.moveType = "linearRandomSplit";
            this.speed = 5;
            this.damage = 1;
            this.xSize = 0;
            this.ySize = 0;
            corners = new ArrayList<Corner>();
            corners.add(new Corner(0, 0));
            corners.add(new Corner(2, 0));
            corners.add(new Corner(4, 0));
            corners.add(new Corner(6, 0));
            corners.add(new Corner(8, 0));
            corners.add(new Corner(10, 0));
            corners.add(new Corner(12, 0));
            corners.add(new Corner(14, 0));
        }
        else if (bulletType.equals("plasmaThrower"))
        {
            this.moveType = "shortSpread";
            this.speed = 0;
            this.damage = 100;
            corners = new ArrayList<Corner>();
            corners.add(new Corner(0, 0));
            corners.add(new Corner(0, 2));
            corners.add(new Corner(0, 4));
            corners.add(new Corner(0, 6));
            corners.add(new Corner(0, 8));
            corners.add(new Corner(0, 10));
            corners.add(new Corner(0, 12));
            corners.add(new Corner(0, 14));
            this.xSize = 15;
            this.ySize = 1;
        }
    }

    public Bullet(double xPos, double yPos, GameLoop gameLoop, double angle, String bulletType, Player player)
    {
        this.player = player;
        this.xPos = xPos;
        this.yPos = yPos;
        this.gameLoop = gameLoop;
        this.angle = angle;
        isEnemy = false;
        this.exploded = false;
        this.bulletType = bulletType;
        if (bulletType.equals("cannon"))
        {
            this.moveType = "linear";
            this.speed = 20;
            this.damage = 10;
            this.xSize = 8;
            this.ySize = 30;
            corners = new ArrayList<Corner>();
            corners.add(new Corner(4, 0));
            corners.add(new Corner(0, 3));
            corners.add(new Corner(0, 23));
            corners.add(new Corner(4, 29));
            corners.add(new Corner(7, 23));
            corners.add(new Corner(7, 3));
            corners.add(new Corner(4, 0));
        }
        else if (bulletType.equals("missle"))
        {
            this.moveType = "linearSpeedUp";
            this.speed = 3;
            this.damage = 20;
            this.xSize = 13;
            this.ySize = 15;
            corners = new ArrayList<Corner>();
            corners.add(new Corner(7, 0));
            corners.add(new Corner(10, 5));
            corners.add(new Corner(10, 11));
            corners.add(new Corner(11, 12));
            corners.add(new Corner(13, 15));
            corners.add(new Corner(10, 14));
            corners.add(new Corner(6, 14));
            corners.add(new Corner(2, 15));
            corners.add(new Corner(4, 12));
            corners.add(new Corner(5, 11));
            corners.add(new Corner(5, 5));
            corners.add(new Corner(7, 0));
        }
        else if (bulletType.equals("machineGun"))
        {
            this.moveType = "linear";
            this.speed = 20;
            this.damage = 5;
            this.xSize = 10;
            this.ySize = 10;
            corners = new ArrayList<Corner>();
            corners.add(new Corner(5, 0));
            corners.add(new Corner(10, 10));
            corners.add(new Corner(0, 10));
            corners.add(new Corner(5, 0));
        }
        else if (bulletType.equals("shotGunCannon"))
        {
            this.moveType = "linear";
            this.speed = 20;
            this.angle = Utility.random(70, 110);
            this.damage = 15;
            this.xSize = 8;
            this.ySize = 30;
            corners = new ArrayList<Corner>();
            corners.add(new Corner(0, 4));
            corners.add(new Corner(3, 0));
            corners.add(new Corner(23, 0));
            corners.add(new Corner(29, 4));
            corners.add(new Corner(23, 7));
            corners.add(new Corner(3, 7));
            corners.add(new Corner(0, 4));
            Utility.rotateCorners(xSize, ySize, corners, angle);
        }
        else if (bulletType.equals("flameThrower"))
        {
            this.moveType = "shortSpread";
            this.speed = 5;
            this.damage = 10;
            corners = new ArrayList<Corner>();
            corners.add(new Corner(0, 0));
            corners.add(new Corner(0, 2));
            corners.add(new Corner(0, 4));
            corners.add(new Corner(0, 6));
            corners.add(new Corner(0, 8));
            corners.add(new Corner(0, 10));
            corners.add(new Corner(0, 12));
            corners.add(new Corner(0, 14));
            this.xSize = 15;
            this.ySize = 1;
        }
        else if (bulletType.equals("iceRay"))
        {
            this.moveType = "linear";
            this.speed = 10;
            this.damage = 25;
            this.xSize = 15;
            this.ySize = 40;
            corners = new ArrayList<Corner>();
            corners.add(new Corner(8, 39));
            corners.add(new Corner(10, 31));
            corners.add(new Corner(14, 35));
            corners.add(new Corner(10, 0));
            corners.add(new Corner(6, 5));
            corners.add(new Corner(0, 27));
            corners.add(new Corner(6, 39));
        }
        else if (bulletType.equals("flakCannon"))
        {
            this.moveType = "linear";
            this.speed = 15;
            this.damage = 100;
            this.angle = 90;
            this.xSize = 40;
            this.ySize = 40;
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
        else if (bulletType.equals("flakCannonS"))
        {
            this.moveType = "linear";
            this.speed = 15;
            this.damage = 100;
            this.angle = Utility.random(80, 100);
            this.xSize = 20;
            this.ySize = 20;
            corners = new ArrayList<Corner>();
            corners.add(new Corner(5, 0));
            corners.add(new Corner(Utility.random(15, 20), Utility.random(5, 10)));
            corners.add(new Corner(Utility.random(7, 13), Utility.random(10, 13)));
            corners.add(new Corner(Utility.random(15, 20), Utility.random(15, 20)));
            corners.add(new Corner(Utility.random(5, 10), 20));
            corners.add(new Corner(Utility.random(0, 4), Utility.random(10, 13)));
            corners.add(new Corner(Utility.random(0, 4), Utility.random(0, 5)));
            corners.add(new Corner(5, 0));
        }
        else if (bulletType.equals("flakCannonSS"))
        {
            this.moveType = "linear";
            this.speed = 15;
            this.damage = 100;
            this.angle = Utility.random(70, 110);
            this.xSize = 10;
            this.ySize = 10;
            corners = new ArrayList<Corner>();
            corners.add(new Corner(5, 0));
            corners.add(new Corner(10, Utility.random(3, 5)));
            corners.add(new Corner(Utility.random(7, 10), 10));
            corners.add(new Corner(Utility.random(0, 2), Utility.random(7, 10)));
            corners.add(new Corner(Utility.random(0, 3), Utility.random(0, 3)));
            corners.add(new Corner(5, 0));
        }
        else if (bulletType.equals("laserBeam"))
        {
            this.moveType = "timerFollowPlayer";
            this.speed = 0;
            this.damage = 4;
            this.xSize = 20;
            this.ySize = 1000;
            angle = 90;
            corners = new ArrayList<Corner>();
            corners.add(new Corner(0, 0));
            corners.add(new Corner(20, 0));
            corners.add(new Corner(20, -1000));
            corners.add(new Corner(0, -1000));
            corners.add(new Corner(0, 0));
        }
        else if (bulletType.equals("lightningCannon"))
        {
            this.moveType = "linearRandomSplit";
            this.speed = 5;
            this.damage = 1;
            this.xSize = 15;
            this.ySize = 0;
            corners = new ArrayList<Corner>();
            corners.add(new Corner(0, 0));
            corners.add(new Corner(2, 0));
            corners.add(new Corner(4, 0));
            corners.add(new Corner(6, 0));
            corners.add(new Corner(8, 0));
            corners.add(new Corner(10, 0));
            corners.add(new Corner(12, 0));
            corners.add(new Corner(14, 0));
        }
        else if (bulletType.equals("plasmaThrower"))
        {
            this.moveType = "shortSpread";
            this.speed = 0;
            this.damage = 100;
            corners = new ArrayList<Corner>();
            corners.add(new Corner(0, 0));
            corners.add(new Corner(0, 2));
            corners.add(new Corner(0, 4));
            corners.add(new Corner(0, 6));
            corners.add(new Corner(0, 8));
            corners.add(new Corner(0, 10));
            corners.add(new Corner(0, 12));
            corners.add(new Corner(0, 14));
            this.xSize = 15;
            this.ySize = 1;
        }
    }
    
    public Bullet(double xPos, double yPos, Bullet bullet)
    {
        this.xPos = xPos;
        this.yPos = yPos;
        this.gameLoop = bullet.gameLoop;
        this.angle = bullet.angle;
        this.enemy = bullet.enemy;
        this.isEnemy = bullet.isEnemy;
        this.player = bullet.player;
        this.exploded = false;
        this.image = bullet.image;
        this.moveType = bullet.moveType;
        this.bulletType = bullet.bulletType;
        this.speed = bullet.speed;
        this.damage = bullet.damage;
        this.xSize = bullet.xSize;
        this.ySize = bullet.ySize;
        this.corners = bullet.corners;
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
            xPos -= speed * Math.cos(Math.toRadians(angle));
            yPos -= speed * Math.sin(Math.toRadians(angle));
        }
        else if (moveType.equals("linearSpeedUp"))
        {
            xPos -= speed * Math.cos(Math.toRadians(angle));
            yPos -= speed * Math.sin(Math.toRadians(angle));
            speed += 1;
        }
        else if (moveType.equals("longScramable"))
        {
            xPos -= speed * Math.cos(Math.toRadians(angle));
            yPos -= speed * Math.sin(Math.toRadians(angle));
            for(int i = 0; i < corners.size(); i++)
            {
                if (corners.get(i).xPos > corners.get(corners.size() - 1).xPos / 2)
                {
                    corners.get(i).xPos -= Utility.random(5, 10) * Math.sin(Math.toRadians(angle));
                }
                else
                {
                    corners.get(i).xPos += Utility.random(5, 10) * Math.sin(Math.toRadians(angle));
                }
                corners.get(i).yPos -= Utility.random(0, 10) * Math.sin(Math.toRadians(angle));
            }
            xSize = (int)corners.get(corners.size() - 1).xPos;
        }
        else if (moveType.equals("shortSpread"))
        {
            double smallest = 10000;
            double largest = 0;
            for(int i = 0; i < corners.size(); i++)
            {
                if(corners.get(i).xPos < smallest)
                {
                    smallest = corners.get(i).xPos;
                }               
            }
            for(int i = 0; i < corners.size(); i++)
            {
                corners.get(i).xPos -= smallest;
            }
            xPos -= smallest;
            for(int i = 0; i < corners.size(); i++)
            {
                if(corners.get(i).xPos > largest)
                {
                    largest = corners.get(i).xPos;
                }
            }
            xSize = (int)largest;
            xPos -= speed * Math.cos(Math.toRadians(angle));
            yPos -= speed * Math.sin(Math.toRadians(angle));
            for(int i = 0; i < corners.size(); i++)
            {
                corners.get(i).xPos += Utility.random(-15, 40);
                corners.get(i).yPos -= Utility.random(0, 10) * Math.sin(Math.toRadians(angle));
            }
            timer += 33;
            if (timer >= 330)
            {
                exploded = true;
            }
        }
        else if (moveType.equals("linearRandomSplit"))
        {
            double smallest = 10000;
            double largest = 0;
            for(int i = 0; i < corners.size(); i++)
            {
                if(corners.get(i).yPos < smallest)
                {
                    smallest = corners.get(i).xPos;
                }               
            }
            for(int i = 0; i < corners.size(); i++)
            {
                if(corners.get(i).yPos > largest)
                {
                    largest = corners.get(i).xPos;
                }
            }
            ySize = (int)largest;
            for(int i = 0; i < corners.size(); i++)
            {
                corners.get(i).xPos += Utility.random(-2, 2);
                if (corners.get(i).yPos > (largest - smallest) / 2)
                {
                    corners.get(i).yPos -= Utility.random(-10, 25) * Math.sin(Math.toRadians(angle));
                }
            }
            yPos -= speed * Math.sin(Math.toRadians(angle));
            xPos -= speed * Math.cos(Math.toRadians(angle));
            timer += 33;
            if (timer >= 3300)
            {
                exploded = true;
            }
        }
        else if (moveType.equals("timerFollowPlayer"))
        {
            xPos = player.xPos + (player.xSize / 2) - (xSize / 2);
            yPos = player.yPos;
            timer += 33;
            if (timer >= 1000)
            {
                exploded = true;
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
            angle = Math.toDegrees(Math.atan2(yDistance, xDistance));
            xPos += magnetS * Math.cos(Math.toRadians(angle));
            yPos += magnetS * Math.sin(Math.toRadians(angle));
        }
    }
}
