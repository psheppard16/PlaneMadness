
/**
 * Write a description of class shopItem here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.io.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.util.ArrayList;
public class ShopItem
{
    JButton button;
    ImageIcon shopIcon;
    JLabel enlargedIcon;
    String name;
    int cost;
    int xPos;
    int yPos;
    ArrayList<ShopItem> itemList;
    JTextField nameField;
    JTextField costField;
    JTextField descriptionField;
    public ShopItem(String name, int x, int y, ImageIcon shopIcon, BufferedImage enlargedIcon, int cost, ArrayList<ShopItem> itemList, String description)
    {
        this.itemList = itemList;
        this.xPos = xPos;
        this.yPos = yPos;
        this.name = name;
        this.shopIcon = shopIcon;
        this.enlargedIcon = new JLabel(new ImageIcon(enlargedIcon));
        this.enlargedIcon.setBounds(765, 765, 200, 200);
        this.cost = cost;
        button = new JButton(shopIcon);
        button.setBounds(x, y, 100, 100);
        itemList.add(this);
        nameField = new JTextField(name);
        nameField.setBounds(40, 750, 500, 50);
        nameField.setFont(new Font("Arial", Font.PLAIN, 50));
        nameField.setForeground(Color.BLACK);
        nameField.setOpaque(false);
        nameField.setBorder(null);
        nameField.setEditable(false);
        descriptionField = new JTextField(description);
        descriptionField.setBounds(40, 820, 700, 100);
        descriptionField.setFont(new Font("Arial", Font.PLAIN, 30));
        descriptionField.setForeground(Color.BLACK);
        descriptionField.setOpaque(false);
        descriptionField.setBorder(null);
        descriptionField.setEditable(false);
        costField = new JTextField("costs: " + cost);
        costField.setBounds(40, 800, 500, 50);
        costField.setFont(new Font("Arial", Font.PLAIN, 30));
        costField.setForeground(Color.BLACK);
        costField.setOpaque(false);
        costField.setBorder(null);
        costField.setEditable(false);
    }
}
