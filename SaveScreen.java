
/**
 * Write a description of class SaveFile here.
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
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
public class SaveScreen extends JPanel
{
    Window window;
    JButton saveFile1;
    JButton saveFile2;
    JButton saveFile3;
    PlayerData data;
    JLabel label;
    public SaveScreen(Window window)
    {
        this.window = window;
        setLayout(null);
        setBounds(0, 0, 1000, 1000);
        try
        {
            label = new JLabel(new ImageIcon(ImageIO.read(new File("images/SaveScreen.jpg"))));
            label.setBounds(0, 0, 1000, 1000);
        }
        catch (IOException e)
        {
            System.out.println("File read error");  
        }
        add(label);
        saveFile1 = new JButton(new ButtonAction("Save File One", KeyEvent.VK_A));
        saveFile2 = new JButton(new ButtonAction("Save File Two", KeyEvent.VK_A));
        saveFile3 = new JButton(new ButtonAction("Save File Three", KeyEvent.VK_A));
        saveFile1.setBounds(375, 300, 250, 100);
        saveFile2.setBounds(375, 450, 250, 100);
        saveFile3.setBounds(375, 600, 250, 100);
        window.add(saveFile1);
        window.add(saveFile2);
        window.add(saveFile3);
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
            if (e.getActionCommand().equals("Save File One"))
            {
                data = new PlayerData(1);
                window.requestedScreen = "MainMenu";
            }
            else if (e.getActionCommand().equals("Save File Two"))
            {
                data = new PlayerData(3);
                window.requestedScreen = "MainMenu";
            }
            else if (e.getActionCommand().equals("Save File Three"))
            {
                data = new PlayerData(3);
                window.requestedScreen = "MainMenu";
            }
        }
    }
}

