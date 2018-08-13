
/**
 * Write a description of class Shop here.
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
public class Shop extends JPanel implements ActionListener
{
    ArrayList<ShopItem> itemList;
    JButton level1;
    Window window;
    BufferedImage shopImage;
    ShopItem selected;
    JTextField weapons;
    ShopItem cannon;
    ShopItem missle;
    ShopItem machineGun;
    ShopItem shotGunCannon;
    ShopItem flameThrower;
    ShopItem iceRay;
    ShopItem flakCannon;
    ShopItem laserBeam;
    ShopItem lightningCannon;
    ShopItem plasmaThrower;
    JTextField ships;
    ShopItem scout;
    ShopItem nebulaGlider;
    ShopItem smasher;
    ShopItem voidRing;
    ShopItem cutter;
    ShopItem stinger;
    ShopItem warpWing;
    ShopItem striker;
    ShopItem shard;
    ShopItem raven;
    JTextField modifiers;
    ShopItem extraHealth;
    ShopItem fasterShip;
    ShopItem asteroidDefence;
    ShopItem higherCoinValue;
    ShopItem firerate;
    ShopItem coinMagnet;
    ShopItem higherDamage;
    ShopItem nuke;
    ShopItem rechargingShield;
    ShopItem autoTurret;
    JButton mainMenu;
    JButton levelSelect;
    JButton buy;
    JTextField moneyField;
    JButton select;
    SaveScreen saveScreen;
    public Shop(Window window, SaveScreen saveScreen)
    {
        itemList = new ArrayList<ShopItem>(0);
        this.window = window;
        this.saveScreen = saveScreen;
        setLayout(null);
        setBounds(0, 0, 1000, 1000);
        try
        {
            shopImage = ImageIO.read(new File("images/shop.png"));
        }
        catch (IOException e)
        {
            System.out.println("File read error");  
        }
        window.add(new JLabel(new ImageIcon(shopImage)));

        moneyField = new JTextField("You have: " + saveScreen.data.money + " coins");
        moneyField.setBounds(250, 800, 500, 50);
        moneyField.setFont(new Font("Arial", Font.PLAIN, 30));
        moneyField.setForeground(Color.BLACK);
        moneyField.setOpaque(false);
        moneyField.setBorder(null);
        moneyField.setEditable(false);
        add(moneyField); 

        weapons = new JTextField("weapons");
        weapons.setBounds(87, 62, 250, 100);
        weapons.setFont(new Font("Arial", Font.PLAIN, 40));
        weapons.setForeground(Color.BLACK);
        weapons.setOpaque(false);
        weapons.setBorder(null);
        weapons.setEditable(false);
        add(weapons);

        try
        {
            cannon = new ShopItem("Cannon", 79, 150, new ImageIcon(ImageIO.read(new File("shop/shopIcon/weapons/cannon.png"))), 
                ImageIO.read(new File("shop/enlargedIcon/weapons/cannon.png")), 0, itemList,
                "fires a bullet at an average firerate");
            add(cannon.button);
            cannon.button.addActionListener(this);
            cannon.button.setActionCommand("cannon");

            missle = new ShopItem("Missle", 196, 150, new ImageIcon(ImageIO.read(new File("shop/shopIcon/weapons/missle.png"))), 
                ImageIO.read(new File("shop/enlargedIcon/weapons/missle.png")), 1000, itemList,
                "fires a missle that speed up over time"
            );
            add(missle.button);
            missle.button.addActionListener(this);
            missle.button.setActionCommand("missle");

            machineGun = new ShopItem("Machine Gun", 79, 250, new ImageIcon(ImageIO.read(new File("shop/shopIcon/weapons/machineGun.png"))), 
                ImageIO.read(new File("shop/enlargedIcon/weapons/machineGun.png")), 2000, itemList,
                "fires bullets rapidly that do average damage"
            );
            add(machineGun.button);
            machineGun.button.addActionListener(this);
            machineGun.button.setActionCommand("machineGun");

            shotGunCannon = new ShopItem("Shot Gun Cannon", 196, 250, new ImageIcon(ImageIO.read(new File("shop/shopIcon/weapons/shotGunCannon.png"))), 
                ImageIO.read(new File("shop/enlargedIcon/weapons/shotGunCannon.png")), 4000, itemList,
                "fires three bullets in a random spread"
            );
            add(shotGunCannon.button);
            shotGunCannon.button.addActionListener(this);
            shotGunCannon.button.setActionCommand("shotGunCannon");

            flameThrower = new ShopItem("Flamethrower", 79, 350, new ImageIcon(ImageIO.read(new File("shop/shopIcon/weapons/flameThrower.png"))), 
                ImageIO.read(new File("shop/enlargedIcon/weapons/flameThrower.png")), 8000, itemList,
                "fires a close range bout of fire"
            );
            add(flameThrower.button);
            flameThrower.button.addActionListener(this);
            flameThrower.button.setActionCommand("flameThrower");

            iceRay = new ShopItem("Ice Ray", 196, 350, new ImageIcon(ImageIO.read(new File("shop/shopIcon/weapons/iceRay.png"))), 
                ImageIO.read(new File("shop/enlargedIcon/weapons/iceRay.png")), 16000, itemList,
                "fires bullets which slow the speed of enemies"
            );
            add(iceRay.button);
            iceRay.button.addActionListener(this);
            iceRay.button.setActionCommand("iceRay");

            flakCannon = new ShopItem("Flak Cannon", 79, 450, new ImageIcon(ImageIO.read(new File("shop/shopIcon/weapons/flakCannon.png"))), 
                ImageIO.read(new File("shop/enlargedIcon/weapons/flakCannon.png")), 32000, itemList,
                "fires an asteroid that breaks up at random points"
            );
            add(flakCannon.button);
            flakCannon.button.addActionListener(this);
            flakCannon.button.setActionCommand("flakCannon");

            laserBeam = new ShopItem("Laser Beam", 196, 450, new ImageIcon(ImageIO.read(new File("shop/shopIcon/weapons/laserBeam.png"))), 
                ImageIO.read(new File("shop/enlargedIcon/weapons/laserBeam.png")), 64000, itemList,
                "fires a laser beam that pierces all enemies"
            );
            add(laserBeam.button);
            laserBeam.button.addActionListener(this);
            laserBeam.button.setActionCommand("laserBeam");

            lightningCannon = new ShopItem("Lightning Cannon", 79, 550, new ImageIcon(ImageIO.read(new File("shop/shopIcon/weapons/lightningCannon.png"))), 
                ImageIO.read(new File("shop/enlargedIcon/weapons/lightningCannon.png")), 128000, itemList,
                "fires a ball of lightning which jumps to enemies"
            );
            add(lightningCannon.button);
            lightningCannon.button.addActionListener(this);
            lightningCannon.button.setActionCommand("lightningCannon");

            plasmaThrower = new ShopItem("Plasma Thrower", 196, 550, new ImageIcon(ImageIO.read(new File("shop/shopIcon/weapons/plasmaThrower.png"))), 
                ImageIO.read(new File("shop/enlargedIcon/weapons/plasmaThrower.png")), 256000, itemList,
                "fires a close range bout of plasma"
            );
            add(plasmaThrower.button);
            plasmaThrower.button.addActionListener(this);
            plasmaThrower.button.setActionCommand("plasmaThrower");
        }
        catch(IOException e)
        {
            System.out.println("weapon image find error");  
        }

        ships = new JTextField("ships");
        ships.setBounds(400, 62, 250, 100);
        ships.setFont(new Font("Arial", Font.PLAIN, 40));
        ships.setForeground(Color.BLACK);
        ships.setOpaque(false);
        ships.setBorder(null);
        ships.setEditable(false);
        add(ships);

        try
        {
            scout = new ShopItem("Scout", 392, 150, new ImageIcon(ImageIO.read(new File("shop/shopIcon/ships/scout.png"))), 
                ImageIO.read(new File("shop/enlargedIcon/ships/scout.png")), 0, itemList,
                "The most basic small ship"
            );
            add(scout.button);
            scout.button.addActionListener(this);
            scout.button.setActionCommand("scout");

            nebulaGlider = new ShopItem("Nebula Glider", 508, 150, new ImageIcon(ImageIO.read(new File("shop/shopIcon/ships/nebulaGlider.png"))), 
                ImageIO.read(new File("shop/enlargedIcon/ships/nebulaGlider.png")), 1000, itemList,
                "The most basic large ship"
            );
            add(nebulaGlider.button);
            nebulaGlider.button.addActionListener(this);
            nebulaGlider.button.setActionCommand("nebulaGlider");

            smasher = new ShopItem("Smasher", 392, 250, new ImageIcon(ImageIO.read(new File("shop/shopIcon/ships/smasher.png"))), 
                ImageIO.read(new File("shop/enlargedIcon/ships/smasher.png")), 10000, itemList,
                "Tier 2 small ship"
            );
            add(smasher.button);
            smasher.button.addActionListener(this);
            smasher.button.setActionCommand("smasher");

            voidRing = new ShopItem("Void Ring", 508, 250, new ImageIcon(ImageIO.read(new File("shop/shopIcon/ships/voidRing.png"))), 
                ImageIO.read(new File("shop/enlargedIcon/ships/voidRing.png")), 10000, itemList,
                "Tier 2 large ship"
            );
            add(voidRing.button);
            voidRing.button.addActionListener(this);
            voidRing.button.setActionCommand("voidRing");

            cutter = new ShopItem("Cutter", 392, 350, new ImageIcon(ImageIO.read(new File("shop/shopIcon/ships/cutter.png"))), 
                ImageIO.read(new File("shop/enlargedIcon/ships/cutter.png")), 50000, itemList,
                "Tier 3 small ship"
            );
            add(cutter.button);
            cutter.button.addActionListener(this);
            cutter.button.setActionCommand("cutter");

            stinger = new ShopItem("Stinger", 508, 350, new ImageIcon(ImageIO.read(new File("shop/shopIcon/ships/stinger.png"))), 
                ImageIO.read(new File("shop/enlargedIcon/ships/stinger.png")), 50000, itemList,
                "Tier 3 large ship"
            );
            add(stinger.button);
            stinger.button.addActionListener(this);
            stinger.button.setActionCommand("stinger");

            warpWing = new ShopItem("Warp Wing", 392, 450, new ImageIcon(ImageIO.read(new File("shop/shopIcon/ships/warpWing.png"))), 
                ImageIO.read(new File("shop/enlargedIcon/ships/warpWing.png")), 100000, itemList,
                "Tier 4 small ship"
            );
            add(warpWing.button);
            warpWing.button.addActionListener(this);
            warpWing.button.setActionCommand("warpWing");

            striker = new ShopItem("Striker", 508, 450, new ImageIcon(ImageIO.read(new File("shop/shopIcon/ships/striker.png"))), 
                ImageIO.read(new File("shop/enlargedIcon/ships/striker.png")), 100000, itemList,
                "Tier 4 large ship"
            );
            add(striker.button);
            striker.button.addActionListener(this);
            striker.button.setActionCommand("striker");

            shard = new ShopItem("Shard", 392, 550, new ImageIcon(ImageIO.read(new File("shop/shopIcon/ships/shard.png"))), 
                ImageIO.read(new File("shop/enlargedIcon/ships/shard.png")), 200000, itemList,
                "Tier 5 small ship"
            );
            add(shard.button);
            shard.button.addActionListener(this);
            shard.button.setActionCommand("shard");

            raven = new ShopItem("Raven",508, 550, new ImageIcon(ImageIO.read(new File("shop/shopIcon/ships/raven.png"))), 
                ImageIO.read(new File("shop/enlargedIcon/ships/raven.png")), 200000, itemList,
                "Tier 5 large ship"
            );
            add(raven.button);
            raven.button.addActionListener(this);
            raven.button.setActionCommand("raven");
        }
        catch(IOException e)
        {
            System.out.println("ship image find error");  
        }
        modifiers = new JTextField("modifiers");
        modifiers.setBounds(712, 62, 250, 100);
        modifiers.setFont(new Font("Arial", Font.PLAIN, 40));
        modifiers.setForeground(Color.BLACK);
        modifiers.setOpaque(false);
        modifiers.setBorder(null);
        modifiers.setEditable(false);
        add(modifiers);

        try
        {
            extraHealth = new ShopItem("Extra Health", 704, 150, new ImageIcon(ImageIO.read(new File("shop/shopIcon/modifier/extraHealth.png"))), 
                ImageIO.read(new File("shop/enlargedIcon/modifier/extraHealth.png")), 0, itemList,
                "Gives 50% more health"
            );
            add(extraHealth.button);
            extraHealth.button.addActionListener(this);
            extraHealth.button.setActionCommand("extraHealth");

            fasterShip = new ShopItem("Faster Ship", 821, 150, new ImageIcon(ImageIO.read(new File("shop/shopIcon/modifier/fasterShip.png"))), 
                ImageIO.read(new File("shop/enlargedIcon/modifier/fasterShip.png")), 1000, itemList,
                "Increases speed by 50%"
            );
            add(fasterShip.button);
            fasterShip.button.addActionListener(this);
            fasterShip.button.setActionCommand("fasterShip");

            asteroidDefence = new ShopItem("Asteroid Defence", 704, 250, new ImageIcon(ImageIO.read(new File("shop/shopIcon/modifier/asteroidDefence.png"))), 
                ImageIO.read(new File("shop/enlargedIcon/modifier/asteroidDefence.png")), 2000, itemList,
                "Repels asteroids"
            );
            add(asteroidDefence.button);
            asteroidDefence.button.addActionListener(this);
            asteroidDefence.button.setActionCommand("asteroidDefence");

            higherCoinValue = new ShopItem("Higher Coin Value", 821, 250, new ImageIcon(ImageIO.read(new File("shop/shopIcon/modifier/higherCoinValue.png"))), 
                ImageIO.read(new File("shop/enlargedIcon/modifier/higherCoinValue.png")), 4000, itemList,
                "Coins are worth 25% more"
            );
            add(higherCoinValue.button);
            higherCoinValue.button.addActionListener(this);
            higherCoinValue.button.setActionCommand("higherCoinValue");

            firerate = new ShopItem("Firerate", 704, 350, new ImageIcon(ImageIO.read(new File("shop/shopIcon/modifier/firerate.png"))), 
                ImageIO.read(new File("shop/enlargedIcon/modifier/firerate.png")), 8000, itemList,
                "Firerate reduced by 25%"
            );
            add(firerate.button);
            firerate.button.addActionListener(this);
            firerate.button.setActionCommand("firerate");

            coinMagnet = new ShopItem("Coin Magnet", 821, 350, new ImageIcon(ImageIO.read(new File("shop/shopIcon/modifier/coinMagnet.png"))), 
                ImageIO.read(new File("shop/enlargedIcon/modifier/coinMagnet.png")), 16000, itemList,
                "A very strong coin magnet");
            add(coinMagnet.button);
            coinMagnet.button.addActionListener(this);
            coinMagnet.button.setActionCommand("coinMagnet");

            higherDamage = new ShopItem("Higher Damage", 704, 450, new ImageIcon(ImageIO.read(new File("shop/shopIcon/modifier/higherDamage.png"))), 
                ImageIO.read(new File("shop/enlargedIcon/modifier/higherDamage.png")), 32000, itemList,
                "Increases damage by 50%");
            add(higherDamage.button);
            higherDamage.button.addActionListener(this);
            higherDamage.button.setActionCommand("higherDamage");

            nuke = new ShopItem("Nuke", 821, 450, new ImageIcon(ImageIO.read(new File("shop/shopIcon/modifier/nuke.png"))), 
                ImageIO.read(new File("shop/enlargedIcon/modifier/nuke.png")), 64000, itemList,
                "Kills every enemy on the screen");
            add(nuke.button);
            nuke.button.addActionListener(this);
            nuke.button.setActionCommand("nuke");

            rechargingShield = new ShopItem("Recharging Shield", 704, 550, new ImageIcon(ImageIO.read(new File("shop/shopIcon/modifier/rechargingShield.png"))), 
                ImageIO.read(new File("shop/enlargedIcon/modifier/rechargingShield.png")), 128000, itemList,
                "Gives a shield that recharges over time");
            add(rechargingShield.button);
            rechargingShield.button.addActionListener(this);
            rechargingShield.button.setActionCommand("rechargingShield");

            autoTurret = new ShopItem("AutoTurret", 821, 550, new ImageIcon(ImageIO.read(new File("shop/shopIcon/modifier/autoTurret.png"))), 
                ImageIO.read(new File("shop/enlargedIcon/modifier/autoTurret.png")), 256000, itemList,
                "Places a turret which automatically fires");
            add(autoTurret.button);
            autoTurret.button.addActionListener(this);
            autoTurret.button.setActionCommand("autoTurret");
        }
        catch(IOException e)
        {
            System.out.println("modifier image find error");  
        }

        mainMenu = new JButton("Main Menu");
        mainMenu.addActionListener(this);
        mainMenu.setBounds(20, 900, 175, 75);
        mainMenu.setFont(new Font("Arial", Font.PLAIN, 30));
        mainMenu.setForeground(Color.BLACK);
        add(mainMenu);

        levelSelect = new JButton("Level Select");
        levelSelect.addActionListener(this);
        levelSelect.setBounds(195, 900, 175, 75);
        levelSelect.setFont(new Font("Arial", Font.PLAIN, 30));
        levelSelect.setForeground(Color.BLACK);
        add(levelSelect);

        buy = new JButton("Buy Item");
        buy.addActionListener(this);
        buy.setBounds(370, 900, 175, 75);
        buy.setFont(new Font("Arial", Font.PLAIN, 30));
        buy.setForeground(Color.BLACK);
        add(buy);

        select = new JButton("Equip");
        select.addActionListener(this);
        select.setBounds(545, 900, 175, 75);
        select.setFont(new Font("Arial", Font.PLAIN, 30));
        select.setForeground(Color.BLACK);
        add(select);
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if (e.getActionCommand().equals("Main Menu"))
        {
            window.requestedScreen = "MainMenu";
        }
        else if (e.getActionCommand().equals("Level Select"))
        {
            window.requestedScreen = "LevelScreen";
        }
        else if (e.getActionCommand().equals("Buy Item"))
        {
            buyItem();
        }
        else if (e.getActionCommand().equals("Equip"))
        {
            equipItem();
        }
        else if (e.getActionCommand().equals("scout"))
        {
            selected = scout;
        }
        else if (e.getActionCommand().equals("nebulaGlider"))
        {
            selected = nebulaGlider;
        }
        else if (e.getActionCommand().equals("smasher"))
        {
            selected = smasher;
        }else if (e.getActionCommand().equals("voidRing"))
        {
            selected = voidRing;
        }
        else if (e.getActionCommand().equals("cutter"))
        {
            selected = cutter;
        }
        else if (e.getActionCommand().equals("stinger"))
        {
            selected = stinger;
        }
        else if (e.getActionCommand().equals("warpWing"))
        {
            selected = warpWing;
        }
        else if (e.getActionCommand().equals("striker"))
        {
            selected = striker;
        }
        else if (e.getActionCommand().equals("shard"))
        {
            selected = shard;
        }
        else if (e.getActionCommand().equals("raven"))
        {
            selected = raven;
        }
        else if (e.getActionCommand().equals("cannon"))
        {
            selected = cannon;
        }
        else if (e.getActionCommand().equals("missle"))
        {
            selected = missle;
        }
        else if (e.getActionCommand().equals("machineGun"))
        {
            selected = machineGun;
        }
        else if (e.getActionCommand().equals("shotGunCannon"))
        {
            selected = shotGunCannon;
        }
        else if (e.getActionCommand().equals("flameThrower"))
        {
            selected = flameThrower;
        }
        else if (e.getActionCommand().equals("iceRay"))
        {
            selected = iceRay;
        }
        else if (e.getActionCommand().equals("flakCannon"))
        {
            selected = flakCannon;
        }
        else if (e.getActionCommand().equals("laserBeam"))
        {
            selected = laserBeam;
        }
        else if (e.getActionCommand().equals("lightningCannon"))
        {
            selected = lightningCannon;
        }
        else if (e.getActionCommand().equals("plasmaThrower"))
        {
            selected = plasmaThrower;
        }
        else if (e.getActionCommand().equals("extraHealth"))
        {
            selected = extraHealth;
        }
        else if (e.getActionCommand().equals("fasterShip"))
        {
            selected = fasterShip;
        }
        else if (e.getActionCommand().equals("asteroidDefence"))
        {
            selected = asteroidDefence;
        }
        else if (e.getActionCommand().equals("higherCoinValue"))
        {
            selected = higherCoinValue;
        }
        else if (e.getActionCommand().equals("firerate"))
        {
            selected = firerate;
        }
        else if (e.getActionCommand().equals("coinMagnet"))
        {
            selected = coinMagnet;
        }
        else if (e.getActionCommand().equals("higherDamage"))
        {
            selected = higherDamage;
        }
        else if (e.getActionCommand().equals("nuke"))
        {
            selected = nuke;
        }
        else if (e.getActionCommand().equals("rechargingShield"))
        {
            selected = rechargingShield;
        }
        else if (e.getActionCommand().equals("autoTurret"))
        {
            selected = autoTurret;
        }
        repaint();
        for(int i = 0; i < itemList.size(); i++)
        {
            remove(itemList.get(i).enlargedIcon);
            remove(itemList.get(i).nameField);
            remove(itemList.get(i).descriptionField);
            remove(itemList.get(i).costField);
        }
        add(selected.enlargedIcon);
        add(selected.nameField);
        add(selected.descriptionField);
        add(selected.costField);
        remove(moneyField);
        add(moneyField);
    }

    public void paintComponent(Graphics g)
    {
        g.drawImage(shopImage, 0, 0, 1000, 1000, null);
        int shipX = 0;
        int shipY = 0;
        int shotX = 0;
        int shotY = 0;
        int modX = 0;
        int modY = 0;
        if(saveScreen.data.currentShip % 2 == 0)
        {
            shipX = 508;
        }
        else
        {
            shipX = 392;
        }
        if(saveScreen.data.currentShot % 2 == 0)
        {
            shotX = 196;
        }
        else
        {
            shotX = 79;
        }
        if(saveScreen.data.currentMod % 2 == 0)
        {
            modX = 821;
        }
        else
        {
            modX = 704;
        }
        shipY = 150 + ((int)((saveScreen.data.currentShip - .03) / 2)) * 100;
        shotY = 150 + ((int)((saveScreen.data.currentShot - .03) / 2)) * 100;
        modY = 150 + ((int)((saveScreen.data.currentMod - .03) / 2)) * 100;
        g.setColor(Color.YELLOW);
        g.drawRect(shipX - 5, shipY - 5, 110, 110);
        g.drawRect(shotX - 5, shotY - 5, 110, 110);
        g.drawRect(modX - 5, modY - 5, 110, 110);
    }

    public void equipItem()
    {
        if (selected.button.getActionCommand().equals("scout"))
        {
            if (saveScreen.data.shipsOwned.get(0).equals("true"))
            {
                saveScreen.data.currentShip = 1;
            }
        }
        else if (selected.button.getActionCommand().equals("nebulaGlider"))
        {
            if (saveScreen.data.shipsOwned.get(1).equals("true"))
            {
                saveScreen.data.currentShip = 2;
            }
        }
        else if (selected.button.getActionCommand().equals("smasher"))
        {
            if (saveScreen.data.shipsOwned.get(2).equals("true"))
            {
                saveScreen.data.currentShip = 3;
            }
        }else if (selected.button.getActionCommand().equals("voidRing"))
        {
            if (saveScreen.data.shipsOwned.get(3).equals("true"))
            {
                saveScreen.data.currentShip = 4;
            }
        }
        else if (selected.button.getActionCommand().equals("cutter"))
        {
            if (saveScreen.data.shipsOwned.get(4).equals("true"))
            {
                saveScreen.data.currentShip = 5;
            }
        }
        else if (selected.button.getActionCommand().equals("stinger"))
        {
            if (saveScreen.data.shipsOwned.get(5).equals("true"))
            {
                saveScreen.data.currentShip = 6;
            }
        }
        else if (selected.button.getActionCommand().equals("warpWing"))
        {
            if (saveScreen.data.shipsOwned.get(6).equals("true"))
            {
                saveScreen.data.currentShip = 7;
            }
        }
        else if (selected.button.getActionCommand().equals("striker"))
        {
           if (saveScreen.data.shipsOwned.get(7).equals("true"))
            {
                saveScreen.data.currentShip = 8;
            }
        }
        else if (selected.button.getActionCommand().equals("shard"))
        {
            if (saveScreen.data.shipsOwned.get(8).equals("true"))
            {
                saveScreen.data.currentShip = 9;
            }
        }
        else if (selected.button.getActionCommand().equals("raven"))
        {
            if (saveScreen.data.shipsOwned.get(9).equals("true"))
            {
                saveScreen.data.currentShip = 10;
            }
        }
        else if (selected.button.getActionCommand().equals("cannon"))
        {
            if (saveScreen.data.shotsOwned.get(0).equals("true"))
            {
                saveScreen.data.currentShot = 1;
            }
        }
        else if (selected.button.getActionCommand().equals("missle"))
        {
            if (saveScreen.data.shotsOwned.get(1).equals("true"))
            {
                saveScreen.data.currentShot = 2;
            }
        }
        else if (selected.button.getActionCommand().equals("machineGun"))
        {
            if (saveScreen.data.shotsOwned.get(2).equals("true"))
            {
                saveScreen.data.currentShot = 3;
            }
        }
        else if (selected.button.getActionCommand().equals("shotGunCannon"))
        {
            if (saveScreen.data.shotsOwned.get(3).equals("true"))
            {
                saveScreen.data.currentShot = 4;
            }
        }
        else if (selected.button.getActionCommand().equals("flameThrower"))
        {
            if (saveScreen.data.shotsOwned.get(4).equals("true"))
            {
                saveScreen.data.currentShot = 5;
            }
        }
        else if (selected.button.getActionCommand().equals("iceRay"))
        {
            if (saveScreen.data.shotsOwned.get(5).equals("true"))
            {
                saveScreen.data.currentShot = 6;
            }
        }
        else if (selected.button.getActionCommand().equals("flakCannon"))
        {
            if (saveScreen.data.shotsOwned.get(6).equals("true"))
            {
                saveScreen.data.currentShot = 7;
            }
        }
        else if (selected.button.getActionCommand().equals("laserBeam"))
        {
            if (saveScreen.data.shotsOwned.get(7).equals("true"))
            {
                saveScreen.data.currentShot = 8;
            }
        }
        else if (selected.button.getActionCommand().equals("lightningCannon"))
        {
            if (saveScreen.data.shotsOwned.get(8).equals("true"))
            {
                saveScreen.data.currentShot = 9;
            }
        }
        else if (selected.button.getActionCommand().equals("plasmaThrower"))
        {
            if (saveScreen.data.shotsOwned.get(9).equals("true"))
            {
                saveScreen.data.currentShot = 10;
            }
        }
        else if (selected.button.getActionCommand().equals("extraHealth"))
        {
            if (saveScreen.data.modsOwned.get(0).equals("true"))
            {
                saveScreen.data.currentMod = 1;
            }
        }
        else if (selected.button.getActionCommand().equals("fasterShip"))
        {
            if (saveScreen.data.modsOwned.get(1).equals("true"))
            {
                saveScreen.data.currentMod = 2;
            }
        }
        else if (selected.button.getActionCommand().equals("asteroidDefence"))
        {
            if (saveScreen.data.modsOwned.get(2).equals("true"))
            {
                saveScreen.data.currentMod = 3;
            }
        }
        else if (selected.button.getActionCommand().equals("higherCoinValue"))
        {
            if (saveScreen.data.modsOwned.get(3).equals("true"))
            {
                saveScreen.data.currentMod = 4;
            }
        }
        else if (selected.button.getActionCommand().equals("firerate"))
        {
            if (saveScreen.data.modsOwned.get(4).equals("true"))
            {
                saveScreen.data.currentMod = 5;
            }
        }
        else if (selected.button.getActionCommand().equals("coinMagnet"))
        {
            if (saveScreen.data.modsOwned.get(5).equals("true"))
            {
                saveScreen.data.currentMod = 6;
            }
        }
        else if (selected.button.getActionCommand().equals("higherDamage"))
        {
            if (saveScreen.data.modsOwned.get(6).equals("true"))
            {
                saveScreen.data.currentMod = 7;
            }
        }
        else if (selected.button.getActionCommand().equals("nuke"))
        {
            if (saveScreen.data.modsOwned.get(7).equals("true"))
            {
                saveScreen.data.currentMod = 8;
            }
        }
        else if (selected.button.getActionCommand().equals("rechargingShield"))
        {
            if (saveScreen.data.modsOwned.get(8).equals("true"))
            {
                saveScreen.data.currentMod = 9;
            }
        }
        else if (selected.button.getActionCommand().equals("autoTurret"))
        {
            if (saveScreen.data.modsOwned.get(9).equals("true"))
            {
                saveScreen.data.currentMod = 10;
            }
        }
    }

    public void buyItem()
    {
        if (saveScreen.data.money >= selected.cost)
        {
            saveScreen.data.money -= selected.cost;
            if (selected.button.getActionCommand().equals("scout") && saveScreen.data.shipsOwned.get(0).equals("false"))
            {
                saveScreen.data.currentShip = 1;
                saveScreen.data.shipsOwned.set(0, "true");
            }
            else if (selected.button.getActionCommand().equals("nebulaGlider") && saveScreen.data.shipsOwned.get(1).equals("false"))
            {
                saveScreen.data.currentShip = 2;
                saveScreen.data.shipsOwned.set(1, "true");
                System.out.println(saveScreen.data.shipsOwned.get(1));
            }
            else if (selected.button.getActionCommand().equals("smasher") && saveScreen.data.shipsOwned.get(2).equals("false"))
            {
                saveScreen.data.currentShip = 3;
                saveScreen.data.shipsOwned.set(2, "true");
            }else if (selected.button.getActionCommand().equals("voidRing") && saveScreen.data.shipsOwned.get(3).equals("false"))
            {
                saveScreen.data.currentShip = 4;
                saveScreen.data.shipsOwned.set(3, "true");
            }
            else if (selected.button.getActionCommand().equals("cutter") && saveScreen.data.shipsOwned.get(4).equals("false"))
            {
                saveScreen.data.currentShip = 5;
                saveScreen.data.shipsOwned.set(4, "true");
            }
            else if (selected.button.getActionCommand().equals("stinger") && saveScreen.data.shipsOwned.get(5).equals("false"))
            {
                saveScreen.data.currentShip = 6;
                saveScreen.data.shipsOwned.set(5, "true");
            }
            else if (selected.button.getActionCommand().equals("warpWing") && saveScreen.data.shipsOwned.get(6).equals("false"))
            {
                saveScreen.data.currentShip = 7;
                saveScreen.data.shipsOwned.set(6, "true");
            }
            else if (selected.button.getActionCommand().equals("striker") && saveScreen.data.shipsOwned.get(7).equals("false"))
            {
                saveScreen.data.currentShip = 8;
                saveScreen.data.shipsOwned.set(7, "true");
            }
            else if (selected.button.getActionCommand().equals("shard") && saveScreen.data.shipsOwned.get(8).equals("false"))
            {
                saveScreen.data.currentShip = 9;
                saveScreen.data.shipsOwned.set(8, "true");
            }
            else if (selected.button.getActionCommand().equals("raven") && saveScreen.data.shipsOwned.get(9).equals("false"))
            {
                saveScreen.data.currentShip = 10;
                saveScreen.data.shipsOwned.set(9, "true");
            }
            else if (selected.button.getActionCommand().equals("cannon") && saveScreen.data.shotsOwned.get(0).equals("false"))
            {
                saveScreen.data.currentShot = 1;
                saveScreen.data.shotsOwned.set(0, "true");
            }
            else if (selected.button.getActionCommand().equals("missle") && saveScreen.data.shotsOwned.get(1).equals("false"))
            {
                saveScreen.data.currentShot = 2;                
                saveScreen.data.shotsOwned.set(1, "true");
            }
            else if (selected.button.getActionCommand().equals("machineGun") && saveScreen.data.shotsOwned.get(2).equals("false"))
            {
                saveScreen.data.currentShot = 3;
                saveScreen.data.shotsOwned.set(2, "true");
            }
            else if (selected.button.getActionCommand().equals("shotGunCannon") && saveScreen.data.shotsOwned.get(3).equals("false"))
            {
                saveScreen.data.currentShot = 4;
                saveScreen.data.shotsOwned.set(3, "true");
            }
            else if (selected.button.getActionCommand().equals("flameThrower") && saveScreen.data.shotsOwned.get(4).equals("false"))
            {
                saveScreen.data.currentShot = 5;
                saveScreen.data.shotsOwned.set(4, "true");
            }
            else if (selected.button.getActionCommand().equals("iceRay") && saveScreen.data.shotsOwned.get(5).equals("false"))
            {
                saveScreen.data.currentShot = 6;
                saveScreen.data.shotsOwned.set(5, "true");
            }
            else if (selected.button.getActionCommand().equals("flakCannon") && saveScreen.data.shotsOwned.get(6).equals("false"))
            {
                saveScreen.data.currentShot = 7;
                saveScreen.data.shotsOwned.set(6, "true");
            }
            else if (selected.button.getActionCommand().equals("laserBeam") && saveScreen.data.shotsOwned.get(7).equals("false"))
            {
                saveScreen.data.currentShot = 8;
                saveScreen.data.shotsOwned.set(7, "true");
            }
            else if (selected.button.getActionCommand().equals("lightningCannon") && saveScreen.data.shotsOwned.get(8).equals("false"))
            {
                saveScreen.data.currentShot = 9;
                saveScreen.data.shotsOwned.set(8, "true");
            }
            else if (selected.button.getActionCommand().equals("plasmaThrower") && saveScreen.data.shotsOwned.get(9).equals("false"))
            {
                saveScreen.data.currentShot = 10;
                saveScreen.data.shotsOwned.set(9, "true");
            }
            else if (selected.button.getActionCommand().equals("extraHealth") && saveScreen.data.modsOwned.get(0).equals("false"))
            {
                saveScreen.data.currentMod = 1;
                saveScreen.data.modsOwned.set(0, "true");
            }
            else if (selected.button.getActionCommand().equals("fasterShip") && saveScreen.data.modsOwned.get(1).equals("false"))
            {
                saveScreen.data.currentMod = 2;
                saveScreen.data.modsOwned.set(1, "true");
            }
            else if (selected.button.getActionCommand().equals("asteroidDefence") && saveScreen.data.modsOwned.get(2).equals("false"))
            {
                saveScreen.data.currentMod = 3;
                saveScreen.data.modsOwned.set(2, "true");
            }
            else if (selected.button.getActionCommand().equals("higherCoinValue") && saveScreen.data.modsOwned.get(3).equals("false"))
            {
                saveScreen.data.currentMod = 4;
                saveScreen.data.modsOwned.set(3, "true");
            }
            else if (selected.button.getActionCommand().equals("firerate") && saveScreen.data.modsOwned.get(4).equals("false"))
            {
                saveScreen.data.currentMod = 5;
                saveScreen.data.modsOwned.set(4, "true");
            }
            else if (selected.button.getActionCommand().equals("coinMagnet") && saveScreen.data.modsOwned.get(5).equals("false"))
            {
                saveScreen.data.currentMod = 6;
                saveScreen.data.modsOwned.set(5, "true");
            }
            else if (selected.button.getActionCommand().equals("higherDamage") && saveScreen.data.modsOwned.get(6).equals("false"))
            {
                saveScreen.data.currentMod = 7;
                saveScreen.data.modsOwned.set(6, "true");
            }
            else if (selected.button.getActionCommand().equals("nuke") && saveScreen.data.modsOwned.get(7).equals("false"))
            {
                saveScreen.data.currentMod = 8;
                saveScreen.data.modsOwned.set(7, "true");
            }
            else if (selected.button.getActionCommand().equals("rechargingShield") && saveScreen.data.modsOwned.get(8).equals("false"))
            {
                saveScreen.data.currentMod = 9;
                saveScreen.data.modsOwned.set(8, "true");
            }
            else if (selected.button.getActionCommand().equals("autoTurret") && saveScreen.data.modsOwned.get(9).equals("false"))
            {
                saveScreen.data.currentMod = 10;
                saveScreen.data.modsOwned.set(9, "true");
            }
        }
        remove(moneyField);
        moneyField.setText("You have: " + saveScreen.data.money + " coins");
        add(moneyField);
    }
}
