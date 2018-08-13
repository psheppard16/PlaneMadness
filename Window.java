
/**
 * Write a description of class Menus here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
public class Window extends JFrame
{
    String requestedScreen;
    String currentScreen;
    int winXSize;
    int winYSize;
    double scaleX;
    double scaleY;
    JButton saveFile3;
    SaveScreen saveScreen;
    public Window()
    {
        currentScreen = "";
        requestedScreen = "SaveScreen";
        setLayout(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationByPlatform(true);
        setResizable(false);
        setUndecorated(false);
        setSize(1000, 1000);
        setVisible(true);

        TimerTask newFrame = new TimerTask()
            {
                public void run() 
                {
                    if(!currentScreen.equals(requestedScreen))
                    {
                        currentScreen = requestedScreen;
                        getContentPane().removeAll();
                        populateScreen();
                    }
                    /*
                    try
                    {
                    System.out.println(saveScreen.data.currentMod);
                    }
                    catch (NullPointerException e)
                    {
                    System.out.println("current mod not found");
                    }
                     */
                    repaint();
                    revalidate();
                }
            };
        Timer gameLoop = new Timer();
        gameLoop.scheduleAtFixedRate(newFrame, 0, 33);
    }

    public void populateScreen()
    {
        if (requestedScreen.equals("SaveScreen"))
        {
            saveScreen = new SaveScreen(this);
            add(saveScreen);
        }
        else if (requestedScreen.equals("MainMenu"))
        {
            add(new MainMenu(this, saveScreen.data));
        }
        else if (requestedScreen.equals("Shop"))
        {
            add(new Shop(this, saveScreen));
        }
        else if (requestedScreen.equals("LevelScreen"))
        {
            add(new LevelScreen(this, saveScreen));
        }
        else if (requestedScreen.equals("GameLoop"))
        {
            add(new GameLoop(this, saveScreen));
        }
        else if (requestedScreen.equals("EndScreen"))
        {
            add(new EndScreen(this, saveScreen.data));
        }
    }
}
