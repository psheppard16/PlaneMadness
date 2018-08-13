
/**
 * Write a description of class MainMenu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
public class MainMenu extends JPanel
{
    Window window;
    JButton levelSelect;
    JButton shop;
    JButton save;
    PlayerData data;
    JLabel label;
    public MainMenu(Window window, PlayerData data)
    {
        this.window = window;
        this.data = data;
        try
        {
            label = new JLabel(new ImageIcon(ImageIO.read(new File("images/MainMenu.png"))));
            label.setBounds(0, 0, 1000, 1000);
        }
        catch (IOException e)
        {
            System.out.println("File read error");  
        }
        add(label);
        setLayout(null);
        setBounds(0, 0, 1000, 1000);
        levelSelect = new JButton(new ButtonAction("select level", KeyEvent.VK_A));
        levelSelect.setBounds(375, 300, 250, 100);
        window.add(levelSelect);
        save = new JButton(new ButtonAction("save and quit", KeyEvent.VK_A));
        save.setBounds(375, 600, 250, 100);
        window.add(save);
        shop = new JButton(new ButtonAction("shop", KeyEvent.VK_A));
        shop.setBounds(375, 450, 250, 100);
        window.add(shop);
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
            if (e.getActionCommand().equals("select level"))
            {
                window.requestedScreen = "LevelScreen";
            }
            else if (e.getActionCommand().equals("shop"))
            {
                window.requestedScreen = "Shop";
            }
            else if (e.getActionCommand().equals("save and quit"))
            {
                data.updateData();
                data.updateFile();
                System.exit(0);
            }
        }
    }
}
