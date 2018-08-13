
/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.ArrayList;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
public class Player
{
    int xPos;
    int yPos;
    int xSize;
    int ySize;
    int level;
    int speed;
    int magnetD;
    int magnetS;
    double health;
    boolean up;
    boolean down;
    boolean left;
    boolean right;
    boolean spaceDown;
    int maxShotCD;
    int shotCD;
    double angle;
    int money;
    String bulletType;
    BufferedImage image;
    BufferedImage origionalImage;
    ArrayList<Corner> corners;
    SaveScreen saveScreen;
    public Player(int xPos, int yPos, SaveScreen saveScreen)
    {
        up = false;
        down = false;
        left = false;
        right = false;
        spaceDown = false;
        this.saveScreen = saveScreen;
        this.xPos = xPos;
        this.yPos = yPos;
        magnetS = 3;
        magnetD = 100;
        money = 0;
        angle = 0;
        if (saveScreen.data.currentShot ==  1)
        {
            this.maxShotCD = 200;
            this.bulletType = "cannon";
        }
        else if (saveScreen.data.currentShot ==  2)
        {
            this.maxShotCD = 200;
            this.bulletType = "missle";
        }
        else if (saveScreen.data.currentShot == 3)
        {
            this.maxShotCD = 50;
            this.bulletType = "machineGun";
        }
        else if (saveScreen.data.currentShot == 4)
        {
            this.maxShotCD = 500;
            this.bulletType = "shotGunCannon";
        }
        else if (saveScreen.data.currentShot == 5)
        {
            this.maxShotCD = 10;
            this.bulletType = "flameThrower";
        }
        else if (saveScreen.data.currentShot == 6)
        {
            this.maxShotCD = 200;
            this.bulletType = "iceRay";
        }
        else if (saveScreen.data.currentShot == 7)
        {
            this.maxShotCD = 200;
            this.bulletType = "flakCannon";
        }
        else if (saveScreen.data.currentShot == 8)
        {
            this.maxShotCD = 2000;
            this.bulletType = "laserBeam";
        }
        else if (saveScreen.data.currentShot == 9)
        {
            this.maxShotCD = 250;
            this.bulletType = "lightningCannon";
        }
        else if (saveScreen.data.currentShot == 10)
        {
            this.maxShotCD = 10;
            this.bulletType = "plasmaThrower";
        }
        shotCD = maxShotCD;
        if (saveScreen.data.currentShip == 1) //"scout"))
        {
            speed = 8;
            health = 50.0;
            xSize = 50;
            ySize = 50;
            corners = new ArrayList<Corner>();
            corners.add(new Corner(25, 0));
            corners.add(new Corner(32, 15));
            corners.add(new Corner(36, 18));
            corners.add(new Corner(38, 16));
            corners.add(new Corner(40, 16));
            corners.add(new Corner(40, 23));
            corners.add(new Corner(46, 29));
            corners.add(new Corner(49, 37));
            corners.add(new Corner(46, 38));
            corners.add(new Corner(35, 30));
            corners.add(new Corner(30, 38));
            corners.add(new Corner(30, 43));
            corners.add(new Corner(28, 41));
            corners.add(new Corner(27, 43));
            corners.add(new Corner(28, 44));
            corners.add(new Corner(25, 49));
            corners.add(new Corner(24, 49));
            corners.add(new Corner(21, 44));
            corners.add(new Corner(22, 42));
            corners.add(new Corner(21, 41));
            corners.add(new Corner(19, 43));
            corners.add(new Corner(19, 38));
            corners.add(new Corner(15, 30));
            corners.add(new Corner(3, 38));
            corners.add(new Corner(0, 36));
            corners.add(new Corner(3, 29));
            corners.add(new Corner(9, 23));
            corners.add(new Corner(9, 16));
            corners.add(new Corner(11, 16));
            corners.add(new Corner(13, 18));
            corners.add(new Corner(17, 15));
            corners.add(new Corner(24, 0));
            corners.add(new Corner(25, 0));
        }
        else if (saveScreen.data.currentShip == 2) //"nebulaGlider"))
        {
            speed = 5;
            health = 100.0;
            xSize = 100;
            ySize = 100;
            corners = new ArrayList<Corner>();
            corners.add(new Corner(50, 11));
            corners.add(new Corner(53, 11));
            corners.add(new Corner(57, 14));
            corners.add(new Corner(61, 24));
            corners.add(new Corner(64, 38));
            corners.add(new Corner(64, 47));
            corners.add(new Corner(66, 48));
            corners.add(new Corner(68, 20));
            corners.add(new Corner(72, 20));
            corners.add(new Corner(74, 33));
            corners.add(new Corner(76, 33));
            corners.add(new Corner(80, 25));
            corners.add(new Corner(83, 13));
            corners.add(new Corner(87, 5));
            corners.add(new Corner(91, 0));
            corners.add(new Corner(99, 0));
            corners.add(new Corner(99, 5));
            corners.add(new Corner(96, 27));
            corners.add(new Corner(94, 49));
            corners.add(new Corner(89, 64));
            corners.add(new Corner(81, 83));
            corners.add(new Corner(71, 93));
            corners.add(new Corner(64, 96));
            corners.add(new Corner(52, 99));
            corners.add(new Corner(47, 99));
            corners.add(new Corner(35, 96));
            corners.add(new Corner(28, 93));
            corners.add(new Corner(18, 83));
            corners.add(new Corner(10, 64));
            corners.add(new Corner(5, 49));
            corners.add(new Corner(3, 27));
            corners.add(new Corner(0, 0));
            corners.add(new Corner(8, 0));
            corners.add(new Corner(12, 5));
            corners.add(new Corner(16, 13));
            corners.add(new Corner(20, 25));
            corners.add(new Corner(23, 33));
            corners.add(new Corner(25, 33));
            corners.add(new Corner(27, 20));
            corners.add(new Corner(31, 20));
            corners.add(new Corner(33, 48));
            corners.add(new Corner(35, 47));
            corners.add(new Corner(36, 32));
            corners.add(new Corner(38, 24));
            corners.add(new Corner(42, 14));
            corners.add(new Corner(46, 11));
            corners.add(new Corner(50, 11));
        }
        else if (saveScreen.data.currentShip == 3) //"smasher"))
        {
            speed = 9;
            health = 100.0;
            xSize = 50;
            ySize = 50;
            corners = new ArrayList<Corner>();
            corners.add(new Corner(25, 4));
            corners.add(new Corner(26, 4));
            corners.add(new Corner(30, 0));
            corners.add(new Corner(31, 0));
            corners.add(new Corner(31, 4));
            corners.add(new Corner(30, 5));
            corners.add(new Corner(30, 20));
            corners.add(new Corner(33, 27));
            corners.add(new Corner(35, 29));
            corners.add(new Corner(40, 22));
            corners.add(new Corner(40, 37));
            corners.add(new Corner(49, 42));
            corners.add(new Corner(47, 44));
            corners.add(new Corner(46, 42));
            corners.add(new Corner(44, 44));
            corners.add(new Corner(46, 46));
            corners.add(new Corner(46, 48));
            corners.add(new Corner(44, 50));
            corners.add(new Corner(43, 50));
            corners.add(new Corner(41, 48));
            corners.add(new Corner(41, 46));
            corners.add(new Corner(43, 44));
            corners.add(new Corner(41, 42));
            corners.add(new Corner(39, 44));
            corners.add(new Corner(37, 42));
            corners.add(new Corner(35, 44));
            corners.add(new Corner(37, 46));
            corners.add(new Corner(37, 48));
            corners.add(new Corner(35, 50));
            corners.add(new Corner(34, 50));
            corners.add(new Corner(32, 48));
            corners.add(new Corner(32, 46));
            corners.add(new Corner(34, 44));
            corners.add(new Corner(32, 42));
            corners.add(new Corner(31, 44));
            corners.add(new Corner(27, 38));
            corners.add(new Corner(22, 38));
            corners.add(new Corner(18, 44));
            corners.add(new Corner(17, 42));
            corners.add(new Corner(15, 44));
            corners.add(new Corner(17, 46));
            corners.add(new Corner(17, 48));
            corners.add(new Corner(15, 50));
            corners.add(new Corner(14, 50));
            corners.add(new Corner(12, 48));
            corners.add(new Corner(12, 46));
            corners.add(new Corner(14, 44));
            corners.add(new Corner(12, 42));
            corners.add(new Corner(10, 44));
            corners.add(new Corner(8, 42));
            corners.add(new Corner(6, 44));
            corners.add(new Corner(8, 46));
            corners.add(new Corner(8, 48));
            corners.add(new Corner(6, 50));
            corners.add(new Corner(5, 50));
            corners.add(new Corner(3, 48));
            corners.add(new Corner(3, 46));
            corners.add(new Corner(5, 44));
            corners.add(new Corner(3, 42));
            corners.add(new Corner(2, 44));
            corners.add(new Corner(0, 42));
            corners.add(new Corner(9, 37));
            corners.add(new Corner(9, 22));
            corners.add(new Corner(14, 29));
            corners.add(new Corner(16, 27));
            corners.add(new Corner(19, 20));
            corners.add(new Corner(19, 5));
            corners.add(new Corner(18, 4));
            corners.add(new Corner(18, 0));
            corners.add(new Corner(19, 0));
            corners.add(new Corner(23, 4));
            corners.add(new Corner(25, 4));
        }
        else if (saveScreen.data.currentShip == 4) //"voidRing"))
        {
            speed = 6;
            health = 200.0;
            xSize = 100;
            ySize = 100;
            corners = new ArrayList<Corner>();
            corners.add(new Corner(50, 20));
            corners.add(new Corner(53, 18));
            corners.add(new Corner(56, 31));
            corners.add(new Corner(62, 33));
            corners.add(new Corner(67, 38));
            corners.add(new Corner(70, 45));
            corners.add(new Corner(70, 56));
            corners.add(new Corner(67, 63));
            corners.add(new Corner(62, 68));
            corners.add(new Corner(55, 70));
            corners.add(new Corner(60, 88));
            corners.add(new Corner(71, 84));
            corners.add(new Corner(82, 73));
            corners.add(new Corner(86, 65));
            corners.add(new Corner(89, 52));
            corners.add(new Corner(89, 48));
            corners.add(new Corner(86, 35));
            corners.add(new Corner(82, 27));
            corners.add(new Corner(72, 17));
            corners.add(new Corner(60, 12));
            corners.add(new Corner(60, 0));
            corners.add(new Corner(69, 4));
            corners.add(new Corner(77, 8));
            corners.add(new Corner(83, 14));
            corners.add(new Corner(83, 4));
            corners.add(new Corner(84, 5));
            corners.add(new Corner(87, 5));
            corners.add(new Corner(88, 4));
            corners.add(new Corner(91, 22));
            corners.add(new Corner(96, 31));
            corners.add(new Corner(99, 42));
            corners.add(new Corner(99, 60));
            corners.add(new Corner(96, 70));
            corners.add(new Corner(92, 78));
            corners.add(new Corner(77, 93));
            corners.add(new Corner(67, 98));
            corners.add(new Corner(59, 100));
            corners.add(new Corner(40, 100));
            corners.add(new Corner(26, 96));
            corners.add(new Corner(18, 92));
            corners.add(new Corner(7, 81));
            corners.add(new Corner(4, 75));
            corners.add(new Corner(2, 69));
            corners.add(new Corner(0, 61));
            corners.add(new Corner(0, 40));
            corners.add(new Corner(3, 31));
            corners.add(new Corner(9, 22));
            corners.add(new Corner(11, 4));
            corners.add(new Corner(12, 5));
            corners.add(new Corner(15, 5));
            corners.add(new Corner(16, 4));
            corners.add(new Corner(16, 14));
            corners.add(new Corner(30, 4));
            corners.add(new Corner(39, 0));
            corners.add(new Corner(39, 13));
            corners.add(new Corner(35, 15));
            corners.add(new Corner(29, 16));
            corners.add(new Corner(18, 27));
            corners.add(new Corner(14, 35));
            corners.add(new Corner(12, 41));
            corners.add(new Corner(11, 48));
            corners.add(new Corner(11, 52));
            corners.add(new Corner(12, 59));
            corners.add(new Corner(14, 65));
            corners.add(new Corner(18, 73));
            corners.add(new Corner(28, 83));
            corners.add(new Corner(40, 88));
            corners.add(new Corner(45, 70));
            corners.add(new Corner(42, 70));
            corners.add(new Corner(38, 68));
            corners.add(new Corner(33, 63));
            corners.add(new Corner(30, 56));
            corners.add(new Corner(30, 45));
            corners.add(new Corner(33, 38));
            corners.add(new Corner(38, 33));
            corners.add(new Corner(44, 31));
            corners.add(new Corner(46, 20));
            corners.add(new Corner(47, 18));
            corners.add(new Corner(49, 20));
            corners.add(new Corner(50, 20));
        }
        else if (saveScreen.data.currentShip == 5) //"cutter"))
        {
            speed = 10;
            health = 250.0;
            xSize = 50;
            ySize = 50;
            corners = new ArrayList<Corner>();
            corners.add(new Corner(25, 0));
            corners.add(new Corner(29, 0));
            corners.add(new Corner(34, 1));
            corners.add(new Corner(38, 4));
            corners.add(new Corner(42, 8));
            corners.add(new Corner(42, 3));
            corners.add(new Corner(43, 4));
            corners.add(new Corner(46, 0));
            corners.add(new Corner(46, 11));
            corners.add(new Corner(49, 19));
            corners.add(new Corner(49, 30));
            corners.add(new Corner(46, 39));
            corners.add(new Corner(39, 46));
            corners.add(new Corner(31, 49));
            corners.add(new Corner(18, 49));
            corners.add(new Corner(15, 48));
            corners.add(new Corner(11, 47));
            corners.add(new Corner(4, 40));
            corners.add(new Corner(2, 36));
            corners.add(new Corner(0, 32));
            corners.add(new Corner(0, 21));
            corners.add(new Corner(3, 11));
            corners.add(new Corner(3, 0));
            corners.add(new Corner(6, 4));
            corners.add(new Corner(7, 4));
            corners.add(new Corner(7, 3));
            corners.add(new Corner(7, 8));
            corners.add(new Corner(11, 4));
            corners.add(new Corner(15, 2));
            corners.add(new Corner(18, 0));
            corners.add(new Corner(25, 0));
        }
        else if (saveScreen.data.currentShip == 6) //"stinger"))
        {
            speed = 7;
            health = 500.0;
            xSize = 100;
            ySize = 100;
            corners = new ArrayList<Corner>();
            corners.add(new Corner(50, 0));
            corners.add(new Corner(52, 1));
            corners.add(new Corner(54, 4));
            corners.add(new Corner(57, 10));
            corners.add(new Corner(57, 20));
            corners.add(new Corner(63, 11));
            corners.add(new Corner(63, 43));
            corners.add(new Corner(69, 30));
            corners.add(new Corner(71, 30));
            corners.add(new Corner(71, 24));
            corners.add(new Corner(76, 24));
            corners.add(new Corner(76, 30));
            corners.add(new Corner(78, 30));
            corners.add(new Corner(78, 50));
            corners.add(new Corner(84, 53));
            corners.add(new Corner(99, 44));
            corners.add(new Corner(99, 57));
            corners.add(new Corner(94, 81));
            corners.add(new Corner(92, 82));
            corners.add(new Corner(94, 86));
            corners.add(new Corner(92, 86));
            corners.add(new Corner(94, 90));
            corners.add(new Corner(94, 94));
            corners.add(new Corner(89, 99));
            corners.add(new Corner(84, 94));
            corners.add(new Corner(84, 90));
            corners.add(new Corner(86, 86));
            corners.add(new Corner(84, 86));
            corners.add(new Corner(86, 82));
            corners.add(new Corner(84, 81));
            corners.add(new Corner(84, 68));
            corners.add(new Corner(72, 61));
            corners.add(new Corner(69, 61));
            corners.add(new Corner(60, 70));
            corners.add(new Corner(54, 70));
            corners.add(new Corner(58, 80));
            corners.add(new Corner(56, 80));
            corners.add(new Corner(53, 78));
            corners.add(new Corner(52, 79));
            corners.add(new Corner(55, 85));
            corners.add(new Corner(55, 90));
            corners.add(new Corner(52, 95));
            corners.add(new Corner(50, 99));
            corners.add(new Corner(49, 99));
            corners.add(new Corner(47, 95));
            corners.add(new Corner(44, 90));
            corners.add(new Corner(44, 85));
            corners.add(new Corner(47, 79));
            corners.add(new Corner(46, 78));
            corners.add(new Corner(43, 80));
            corners.add(new Corner(41, 80));
            corners.add(new Corner(45, 70));
            corners.add(new Corner(40, 70));
            corners.add(new Corner(30, 61));
            corners.add(new Corner(27, 61));
            corners.add(new Corner(15, 68));
            corners.add(new Corner(15, 81));
            corners.add(new Corner(13, 82));
            corners.add(new Corner(15, 86));
            corners.add(new Corner(13, 86));
            corners.add(new Corner(15, 90));
            corners.add(new Corner(15, 94));
            corners.add(new Corner(10, 99));
            corners.add(new Corner(5, 95));
            corners.add(new Corner(5, 90));
            corners.add(new Corner(7, 86));
            corners.add(new Corner(5, 86));
            corners.add(new Corner(7, 82));
            corners.add(new Corner(5, 81));
            corners.add(new Corner(0, 57));
            corners.add(new Corner(0, 44));
            corners.add(new Corner(15, 53));
            corners.add(new Corner(20, 50));
            corners.add(new Corner(20, 30));
            corners.add(new Corner(22, 30));
            corners.add(new Corner(22, 24));
            corners.add(new Corner(27, 24));
            corners.add(new Corner(27, 30));
            corners.add(new Corner(29, 30));
            corners.add(new Corner(35, 43));
            corners.add(new Corner(35, 11));
            corners.add(new Corner(42, 20));
            corners.add(new Corner(42, 10));
            corners.add(new Corner(45, 4));
            corners.add(new Corner(47, 1));
            corners.add(new Corner(49, 0));
            corners.add(new Corner(50, 0));
        }
        else if (saveScreen.data.currentShip == 7) //"warpWing"))
        {
            speed = 12;
            health = 350.0;
            xSize = 50;
            ySize = 50;
            corners = new ArrayList<Corner>();
            corners.add(new Corner(24, 1));
            corners.add(new Corner(26, 0));
            corners.add(new Corner(29, 7));
            corners.add(new Corner(31, 7));
            corners.add(new Corner(37, 0));
            corners.add(new Corner(39, 0));
            corners.add(new Corner(39, 5));
            corners.add(new Corner(42, 3));
            corners.add(new Corner(49, 0));
            corners.add(new Corner(47, 5));
            corners.add(new Corner(43, 18));
            corners.add(new Corner(41, 23));
            corners.add(new Corner(41, 28));
            corners.add(new Corner(42, 32));
            corners.add(new Corner(45, 41));
            corners.add(new Corner(49, 49));
            corners.add(new Corner(42, 48));
            corners.add(new Corner(40, 46));
            corners.add(new Corner(31, 44));
            corners.add(new Corner(18, 44));
            corners.add(new Corner(9, 46));
            corners.add(new Corner(7, 48));
            corners.add(new Corner(0, 49));
            corners.add(new Corner(3, 41));
            corners.add(new Corner(6, 32));
            corners.add(new Corner(7, 28));
            corners.add(new Corner(7, 23));
            corners.add(new Corner(6, 18));
            corners.add(new Corner(3, 5));
            corners.add(new Corner(0, 0));
            corners.add(new Corner(7, 3));
            corners.add(new Corner(10, 5));
            corners.add(new Corner(10, 0));
            corners.add(new Corner(12, 0));
            corners.add(new Corner(18, 7));
            corners.add(new Corner(20, 7));
            corners.add(new Corner(23, 0));
            corners.add(new Corner(24, 1));
            corners.add(new Corner(25, 1));
        }
        else if (saveScreen.data.currentShip == 8) //"striker"))
        {
            speed = 8;
            health = 750.0;
            xSize = 100;
            ySize = 100;
            corners = new ArrayList<Corner>();
            corners.add(new Corner(50, 0));
            corners.add(new Corner(57, 0));
            corners.add(new Corner(59, 1));
            corners.add(new Corner(61, 7));
            corners.add(new Corner(61, 23));
            corners.add(new Corner(63, 24));
            corners.add(new Corner(63, 28));
            corners.add(new Corner(76, 34));
            corners.add(new Corner(76, 20));
            corners.add(new Corner(90, 30));
            corners.add(new Corner(90, 42));
            corners.add(new Corner(99, 80));
            corners.add(new Corner(99, 90));
            corners.add(new Corner(90, 85));
            corners.add(new Corner(90, 94));
            corners.add(new Corner(87, 99));
            corners.add(new Corner(75, 99));
            corners.add(new Corner(75, 96));
            corners.add(new Corner(24, 96));
            corners.add(new Corner(24, 99));
            corners.add(new Corner(13, 99));
            corners.add(new Corner(10, 94));
            corners.add(new Corner(10, 85));
            corners.add(new Corner(0, 90));
            corners.add(new Corner(0, 79));
            corners.add(new Corner(10, 42));
            corners.add(new Corner(10, 30));
            corners.add(new Corner(24, 20));
            corners.add(new Corner(24, 39));
            corners.add(new Corner(37, 34));
            corners.add(new Corner(37, 28));
            corners.add(new Corner(24, 33));
            corners.add(new Corner(24, 20));
            corners.add(new Corner(24, 90));
            corners.add(new Corner(76, 90));
            corners.add(new Corner(76, 33));
            corners.add(new Corner(63, 28));
            corners.add(new Corner(63, 34));
            corners.add(new Corner(76, 39));
            corners.add(new Corner(63, 34));
            corners.add(new Corner(63, 80));
            corners.add(new Corner(76, 75));
            corners.add(new Corner(76, 69));
            corners.add(new Corner(63, 74));
            corners.add(new Corner(63, 85));
            corners.add(new Corner(37, 85));
            corners.add(new Corner(37, 74));
            corners.add(new Corner(24, 69));
            corners.add(new Corner(24, 75));
            corners.add(new Corner(37, 80));
            corners.add(new Corner(37, 24));
            corners.add(new Corner(37, 28));
            corners.add(new Corner(37, 24));
            corners.add(new Corner(39, 24));
            corners.add(new Corner(39, 7));
            corners.add(new Corner(41, 1));
            corners.add(new Corner(43, 0));
            corners.add(new Corner(49, 0));
            corners.add(new Corner(50, 0));
        }
        else if (saveScreen.data.currentShip == 9) //"shard"))
        {
            speed = 15;
            health = 500.0;
            xSize = 50;
            ySize = 50;
            corners = new ArrayList<Corner>();
            corners.add(new Corner(25, 8));
            corners.add(new Corner(27, 8));
            corners.add(new Corner(30, 0));
            corners.add(new Corner(30, 16));
            corners.add(new Corner(41, 0));
            corners.add(new Corner(39, 17));
            corners.add(new Corner(46, 6));
            corners.add(new Corner(49, 19));
            corners.add(new Corner(49, 25));
            corners.add(new Corner(43, 32));
            corners.add(new Corner(42, 35));
            corners.add(new Corner(46, 48));
            corners.add(new Corner(41, 44));
            corners.add(new Corner(39, 38));
            corners.add(new Corner(36, 41));
            corners.add(new Corner(36, 47));
            corners.add(new Corner(36, 44));
            corners.add(new Corner(35, 44));
            corners.add(new Corner(28, 46));
            corners.add(new Corner(26, 47));
            corners.add(new Corner(25, 49));
            corners.add(new Corner(24, 47));
            corners.add(new Corner(22, 46));
            corners.add(new Corner(14, 44));
            corners.add(new Corner(14, 47));
            corners.add(new Corner(14, 43));
            corners.add(new Corner(12, 40));
            corners.add(new Corner(6, 48));
            corners.add(new Corner(8, 30));
            corners.add(new Corner(7, 29));
            corners.add(new Corner(1, 38));
            corners.add(new Corner(5, 23));
            corners.add(new Corner(0, 13));
            corners.add(new Corner(5, 18));
            corners.add(new Corner(6, 12));
            corners.add(new Corner(3, 0));
            corners.add(new Corner(16, 17));
            corners.add(new Corner(20, 10));
            corners.add(new Corner(14, 2));
            corners.add(new Corner(25, 8));
        }
        else if (saveScreen.data.currentShip == 10) //"raven"))
        {
            speed = 10;
            health = 1000.0;
            xSize = 100;
            ySize = 100;
            corners = new ArrayList<Corner>();
            corners.add(new Corner(50, 0));
            corners.add(new Corner(55, 17));
            corners.add(new Corner(60, 31));
            corners.add(new Corner(65, 42));
            corners.add(new Corner(70, 51));
            corners.add(new Corner(75, 59));
            corners.add(new Corner(80, 66));
            corners.add(new Corner(85, 72));
            corners.add(new Corner(90, 76));
            corners.add(new Corner(95, 78));
            corners.add(new Corner(99, 80));
            corners.add(new Corner(79, 79));
            corners.add(new Corner(99, 88));
            corners.add(new Corner(75, 87));
            corners.add(new Corner(90, 95));
            corners.add(new Corner(81, 94));
            corners.add(new Corner(72, 93));
            corners.add(new Corner(62, 89));
            corners.add(new Corner(69, 95));
            corners.add(new Corner(77, 99));
            corners.add(new Corner(67, 98));
            corners.add(new Corner(59, 96));
            corners.add(new Corner(53, 92));
            corners.add(new Corner(55, 96));
            corners.add(new Corner(53, 95));
            corners.add(new Corner(50, 97));
            corners.add(new Corner(50, 99));
            corners.add(new Corner(49, 99));
            corners.add(new Corner(49, 97));
            corners.add(new Corner(46, 95));
            corners.add(new Corner(44, 96));
            corners.add(new Corner(46, 92));
            corners.add(new Corner(40, 95));
            corners.add(new Corner(35, 97));
            corners.add(new Corner(30, 98));
            corners.add(new Corner(21, 99));
            corners.add(new Corner(30, 95));
            corners.add(new Corner(37, 89));
            corners.add(new Corner(33, 90));
            corners.add(new Corner(25, 93));
            corners.add(new Corner(20, 94));
            corners.add(new Corner(9, 95));
            corners.add(new Corner(25, 87));
            corners.add(new Corner(0, 88));
            corners.add(new Corner(21, 79));
            corners.add(new Corner(0, 80));
            corners.add(new Corner(9, 75));
            corners.add(new Corner(20, 64));
            corners.add(new Corner(25, 56));
            corners.add(new Corner(30, 47));
            corners.add(new Corner(35, 37));
            corners.add(new Corner(40, 25));
            corners.add(new Corner(45, 11));
            corners.add(new Corner(49, 0));
            corners.add(new Corner(50, 0));
        }
        
        if (saveScreen.data.currentMod ==  1)
        {
            this.health *= 1.5;
        }
        else if (saveScreen.data.currentMod ==  2)
        {
            this.speed *= 1.5;
        }
        else if (saveScreen.data.currentMod == 5)
        {
            this.maxShotCD *= .75;
        }
        else if (saveScreen.data.currentMod == 6)
        {
            magnetS = 10;
            magnetD = 250;
        }
        corners = Utility.rotateCorners(xSize, ySize, corners, angle);
    }

    public int xSize()
    {
        double angleR = Math.toRadians(angle);
        double cos = Math.abs(Math.cos(angleR));
        double sin = Math.abs(Math.sin(angleR));
        return (int)Math.floor(xSize * cos + ySize * sin);
    }

    public int ySize()
    {
        double angleR = Math.toRadians(angle);
        double cos = Math.abs(Math.cos(angleR));
        double sin = Math.abs(Math.sin(angleR));
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
}
