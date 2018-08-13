
/**
 * Write a description of class EndScreen here.
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
public class EndScreen extends JPanel
{
    Window window;
    JButton MainMenu;
    JButton LevelScreen;
    JButton Shop;
    JTextField winLoss;
    JTextField moneyGained;
    JTextField totalMoney;
    PlayerData data;
    JLabel label;
    public EndScreen(Window window, PlayerData data)
    {
        this.window = window;
        setLayout(null);
        setBounds(0, 0, 1000, 1000);
        try
        {
            label = new JLabel(new ImageIcon(ImageIO.read(new File("images/EndScreen.jpg"))));
            label.setBounds(0, 0, 1000, 1000);
        }
        catch (IOException e)
        {
            System.out.println("File read error");  
        }
        add(label);
        if(data.won)
        {
            winLoss = new JTextField("VICTORY!");
            winLoss.setForeground(Color.GREEN);
        }
        else
        {
            winLoss = new JTextField("FAILURE!");
            winLoss.setForeground(Color.RED);
        }
        winLoss.setBounds(250, 0, 750, 100);
        winLoss.setFont(new Font("Arial", Font.PLAIN, 110));
        winLoss.setOpaque(false);
        winLoss.setBorder(null);
        window.add(winLoss);
        moneyGained = new JTextField("You earned: " + data.moneyWon + " coins");
        moneyGained.setBounds(250, 250, 500, 100);
        moneyGained.setFont(new Font("Arial", Font.PLAIN, 30));
        moneyGained.setOpaque(false);
        moneyGained.setBorder(null);
        moneyGained.setEditable(false);
        window.add(moneyGained);
        totalMoney = new JTextField("You now have: " + data.money + " coins");
        totalMoney.setBounds(250, 350, 500, 100);
        totalMoney.setFont(new Font("Arial", Font.PLAIN, 30));
        totalMoney.setOpaque(false);
        totalMoney.setBorder(null);
        totalMoney.setEditable(false);
        window.add(totalMoney);
        MainMenu = new JButton(new ButtonAction("Main Menu", KeyEvent.VK_A));
        MainMenu.setBounds(375, 500, 250, 100);
        window.add(MainMenu);
        LevelScreen = new JButton(new ButtonAction("Level Screen", KeyEvent.VK_A));
        LevelScreen.setBounds(375, 650, 250, 100);
        window.add(LevelScreen);
        Shop = new JButton(new ButtonAction("Shop", KeyEvent.VK_A));
        Shop.setBounds(375, 800, 250, 100);
        window.add(Shop);
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
            if (e.getActionCommand().equals("Main Menu"))
            {
                window.requestedScreen = "MainMenu";
            }
            else if (e.getActionCommand().equals("Shop"))
            {
                window.requestedScreen = "Shop";
            }
            else if (e.getActionCommand().equals("Level Screen"))
            {
                data = new PlayerData(3);
                window.requestedScreen = "LevelScreen";
            }
        }
    }
}
