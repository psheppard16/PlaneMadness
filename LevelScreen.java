
/**
 * Write a description of class WorldScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.ArrayList;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
public class LevelScreen extends JPanel
{
    JButton level1;
    JButton level2;
    JButton level3;
    JButton level4;
    JButton level5;
    JButton level6;
    JButton level7;
    JButton level8;
    JButton level9;
    JButton level10;
    JButton level11;
    JButton level12;
    JButton level13;
    JButton level14;
    JButton level15;
    JButton level16;
    JButton level17;
    JButton level18;
    JButton level19;
    JButton level20;
    JButton level21;
    JButton level22;
    JButton level23;
    JButton level24;
    Window window;
    JLabel label;
    JButton MainMenu;
    JButton Shop;
    SaveScreen saveScreen;
    public LevelScreen(Window window, SaveScreen saveScreen)
    {
        this.saveScreen = saveScreen;
        this.window = window;
        setBounds(0, 0, 1000, 1000);
        try
        {
            label = new JLabel(new ImageIcon(ImageIO.read(new File("images/LevelScreen.jpg"))));
            label.setBounds(0, 0, 1000, 1000);
        }
        catch (IOException e)
        {
            System.out.println("File read error");  
        }
        add(label);
        level1 = new JButton(new ButtonAction("Level 1", KeyEvent.VK_A));
        level1.setBounds(100, 100, 100, 50);
        window.add(level1);
        level2 = new JButton(new ButtonAction("Level 2", KeyEvent.VK_A));
        level2.setBounds(200, 100, 100, 50);
        window.add(level2);
        level3 = new JButton(new ButtonAction("Level 3", KeyEvent.VK_A));
        level3.setBounds(300, 100, 100, 50);
        window.add(level3);
        level4 = new JButton(new ButtonAction("Level 4", KeyEvent.VK_A));
        level4.setBounds(400, 100, 100, 50);
        window.add(level4);
        level5 = new JButton(new ButtonAction("Level 5", KeyEvent.VK_A));
        level5.setBounds(500, 100, 100, 50);
        window.add(level5);
        level6 = new JButton(new ButtonAction("Level 6", KeyEvent.VK_A));
        level6.setBounds(600, 100, 100, 50);
        window.add(level6);
        level7 = new JButton(new ButtonAction("Level 7", KeyEvent.VK_A));
        level7.setBounds(700, 100, 100, 50);
        window.add(level7);
        level8 = new JButton(new ButtonAction("Level 8", KeyEvent.VK_A));
        level8.setBounds(800, 100, 100, 50);
        window.add(level8);
        level9 = new JButton(new ButtonAction("Level 9", KeyEvent.VK_A));
        level9.setBounds(100, 200, 100, 50);
        window.add(level9);
        level10 = new JButton(new ButtonAction("Level 10", KeyEvent.VK_A));
        level10.setBounds(200, 200, 100, 50);
        window.add(level10);
        level11 = new JButton(new ButtonAction("Level 11", KeyEvent.VK_A));
        level11.setBounds(300, 200, 100, 50);
        window.add(level11);
        level12 = new JButton(new ButtonAction("Level 12", KeyEvent.VK_A));
        level12.setBounds(400, 200, 100, 50);
        window.add(level12);
        level13 = new JButton(new ButtonAction("Level 13", KeyEvent.VK_A));
        level13.setBounds(500, 200, 100, 50);
        window.add(level13);
        level14 = new JButton(new ButtonAction("Level 14", KeyEvent.VK_A));
        level14.setBounds(600, 200, 100, 50);
        window.add(level14);
        level15 = new JButton(new ButtonAction("Level 15", KeyEvent.VK_A));
        level15.setBounds(700, 200, 100, 50);
        window.add(level15);
        level16 = new JButton(new ButtonAction("Level 16", KeyEvent.VK_A));
        level16.setBounds(800, 200, 100, 50);
        window.add(level16);
        level17 = new JButton(new ButtonAction("Level 17", KeyEvent.VK_A));
        level17.setBounds(100, 300, 100, 50);
        window.add(level17);
        level18 = new JButton(new ButtonAction("Level 18", KeyEvent.VK_A));
        level18.setBounds(200, 300, 100, 50);
        window.add(level18);
        level19 = new JButton(new ButtonAction("Level 19", KeyEvent.VK_A));
        level19.setBounds(300, 300, 100, 50);
        window.add(level19);
        level20 = new JButton(new ButtonAction("Level 20", KeyEvent.VK_A));
        level20.setBounds(400, 300, 100, 50);
        window.add(level20);
        level21 = new JButton(new ButtonAction("Level 21", KeyEvent.VK_A));
        level21.setBounds(500, 300, 100, 50);
        window.add(level21);
        level22 = new JButton(new ButtonAction("Level 22", KeyEvent.VK_A));
        level22.setBounds(600, 300, 100, 50);
        window.add(level22);
        level23 = new JButton(new ButtonAction("Level 23", KeyEvent.VK_A));
        level23.setBounds(700, 300, 100, 50);
        window.add(level23);
        level24 = new JButton(new ButtonAction("Level 24", KeyEvent.VK_A));
        level24.setBounds(800, 300, 100, 50);
        window.add(level24);
        MainMenu = new JButton(new ButtonAction("Main Menu", KeyEvent.VK_A));
        MainMenu.setBounds(375, 650, 250, 100);
        window.add(MainMenu);
        Shop = new JButton(new ButtonAction("Shop", KeyEvent.VK_A));
        Shop.setBounds(375, 800, 250, 100);
        window.add(Shop);
        setVisible(true);
    }
    
    private class ButtonAction extends AbstractAction 
    {
        public ButtonAction(String name, Integer mnemonic) 
        {
            super(name);
            putValue(MNEMONIC_KEY, mnemonic);
        }

        @Override
        public void actionPerformed(ActionEvent e) 
        {
            if (e.getActionCommand().equals("Level 1"))
            {
                saveScreen.data.enemyChain.add(new SpawnGroup(50, "shooter", 9, 3000, 1000, 100));     
                window.requestedScreen = "GameLoop";
            }
            else if (e.getActionCommand().equals("Level 2"))
            {
                saveScreen.data.enemyChain.add(new SpawnGroup(50, "shooter", 9, 3000, 1000, 100));
                saveScreen.data.enemyChain.add(new SpawnGroup(0, "asteroid", 100, 0, 100, 0));
                window.requestedScreen = "GameLoop";
            }
            else if (e.getActionCommand().equals("Level 3"))
            {
                saveScreen.data.enemyChain.add(new SpawnGroup(50, "shooter", 9, 3000, 1000, 100));     
                window.requestedScreen = "GameLoop";
            }
            else if (e.getActionCommand().equals("Level 4"))
            {
                saveScreen.data.enemyChain.add(new SpawnGroup(50, "shooter", 9, 3000, 1000, 100));     
                window.requestedScreen = "GameLoop";
            }
            else if (e.getActionCommand().equals("Level 5"))
            {
                saveScreen.data.enemyChain.add(new SpawnGroup(50, "shooter", 9, 3000, 1000, 100));     
                window.requestedScreen = "GameLoop";
            }
            else if (e.getActionCommand().equals("Level 6"))
            {
                saveScreen.data.enemyChain.add(new SpawnGroup(50, "shooter", 9, 3000, 1000, 100));     
                window.requestedScreen = "GameLoop";
            }
            else if (e.getActionCommand().equals("Level 7"))
            {
               saveScreen.data.enemyChain.add(new SpawnGroup(50, "shooter", 9, 3000, 1000, 100));     
                window.requestedScreen = "GameLoop";
            }
            else if (e.getActionCommand().equals("Level 8"))
            {
               saveScreen.data.enemyChain.add(new SpawnGroup(50, "shooter", 9, 3000, 1000, 100));     
                window.requestedScreen = "GameLoop";
            }
            else if (e.getActionCommand().equals("Level 9"))
            {
               saveScreen.data.enemyChain.add(new SpawnGroup(50, "shooter", 9, 3000, 1000, 100));     
                window.requestedScreen = "GameLoop";
            }
            else if (e.getActionCommand().equals("Level 10"))
            {
               saveScreen.data.enemyChain.add(new SpawnGroup(50, "shooter", 9, 3000, 1000, 100));     
                window.requestedScreen = "GameLoop";
            }
            else if (e.getActionCommand().equals("Level 11"))
            {
               saveScreen.data.enemyChain.add(new SpawnGroup(50, "shooter", 9, 3000, 1000, 100));     
                window.requestedScreen = "GameLoop";
            }
            else if (e.getActionCommand().equals("Level 12"))
            {
               saveScreen.data.enemyChain.add(new SpawnGroup(50, "shooter", 9, 3000, 1000, 100));     
                window.requestedScreen = "GameLoop";
            }
            else if (e.getActionCommand().equals("Level 13"))
            {
               saveScreen.data.enemyChain.add(new SpawnGroup(50, "shooter", 9, 3000, 1000, 100));     
                window.requestedScreen = "GameLoop";
            }
            else if (e.getActionCommand().equals("Level 14"))
            {
               saveScreen.data.enemyChain.add(new SpawnGroup(50, "shooter", 9, 3000, 1000, 100));     
                window.requestedScreen = "GameLoop";
            }
            else if (e.getActionCommand().equals("Level 15"))
            {
               saveScreen.data.enemyChain.add(new SpawnGroup(50, "shooter", 9, 3000, 1000, 100));     
                window.requestedScreen = "GameLoop";
            }
            else if (e.getActionCommand().equals("Level 16"))
            {
               saveScreen.data.enemyChain.add(new SpawnGroup(50, "shooter", 9, 3000, 1000, 100));     
                window.requestedScreen = "GameLoop";
            }
            else if (e.getActionCommand().equals("Level 17"))
            {
               saveScreen.data.enemyChain.add(new SpawnGroup(50, "shooter", 9, 3000, 1000, 100));     
                window.requestedScreen = "GameLoop";
            }
            else if (e.getActionCommand().equals("Level 18"))
            {
               saveScreen.data.enemyChain.add(new SpawnGroup(50, "shooter", 9, 3000, 1000, 100));     
                window.requestedScreen = "GameLoop";
            }
            else if (e.getActionCommand().equals("Level 19"))
            {
               saveScreen.data.enemyChain.add(new SpawnGroup(50, "shooter", 9, 3000, 1000, 100));     
                window.requestedScreen = "GameLoop";
            }
            else if (e.getActionCommand().equals("Level 20"))
            {
               saveScreen.data.enemyChain.add(new SpawnGroup(50, "shooter", 9, 3000, 1000, 100));     
                window.requestedScreen = "GameLoop";
            }
            else if (e.getActionCommand().equals("Level 21"))
            {
               saveScreen.data.enemyChain.add(new SpawnGroup(50, "shooter", 9, 3000, 1000, 100));     
                window.requestedScreen = "GameLoop";
            }
            else if (e.getActionCommand().equals("Level 22"))
            {
               saveScreen.data.enemyChain.add(new SpawnGroup(50, "shooter", 9, 3000, 1000, 100));     
                window.requestedScreen = "GameLoop";
            }
            else if (e.getActionCommand().equals("Level 23"))
            {
               saveScreen.data.enemyChain.add(new SpawnGroup(50, "shooter", 9, 3000, 1000, 100));     
                window.requestedScreen = "GameLoop";
            }
            else if (e.getActionCommand().equals("Level 24"))
            {
               saveScreen.data.enemyChain.add(new SpawnGroup(50, "shooter", 9, 3000, 1000, 100));     
                window.requestedScreen = "GameLoop";
            }
            else if (e.getActionCommand().equals("Main Menu"))
            {
                window.requestedScreen = "MainMenu";
            }
            else if (e.getActionCommand().equals("Shop"))
            {
                window.requestedScreen = "Shop";
            }
        }
    }
}
