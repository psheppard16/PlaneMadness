
/**
 * Write a description of class PlayField here.
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
import java.util.Timer;
import java.util.TimerTask;
import java.util.ArrayList;
public class GameLoop extends JPanel
{
    Player player;
    Insets insets;
    BufferedImage playerImage;
    BufferedImage bulletImage;
    BufferedImage juggernautImage;
    ArrayList<Bullet> bulletList;
    ArrayList<Enemy> enemyList;
    ArrayList<Coin> coinList;
    Button fullButton;
    boolean fullScreen;
    BufferedImage spaceImage;
    Background space1;
    Background space2;
    String menu;
    Window window;
    Timer gameLoop;
    boolean levelBeaten;
    int winTimer;
    double damageMultiplyer;
    double valueMultiplyer;
    SaveScreen saveScreen;
    public GameLoop(Window window, SaveScreen saveScreen)
    {
        this.saveScreen = saveScreen;
        winTimer = 3000;
        levelBeaten = false;
        this.window = window;
        setBounds(0, 0, 1000, 1000);
        fullScreen = false;
        try
        {
            playerImage = ImageIO.read(new File("images/playerImage.gif"));
            bulletImage = ImageIO.read(new File("images/rocketImage.png"));
            juggernautImage = ImageIO.read(new File("images/juggernautImage.png"));
            spaceImage = ImageIO.read(new File("images/spaceImage.png"));
        }
        catch (IOException e)
        {
            System.out.println("File read error");  
        }
        space1 = new Background(0, 2178, 4960, spaceImage);
        space2 = new Background(-4960, 2178, 4960, spaceImage);
        bulletList = new ArrayList<Bullet>(0);
        enemyList = new ArrayList<Enemy>(0);
        coinList = new ArrayList<Coin>(0);
        player = new Player(500, 500, saveScreen);

        KeyListener keyAction = new KeyListener() 
            {
                @Override
                public void keyPressed(KeyEvent e)
                {
                    keyP(e);
                }

                @Override
                public void keyReleased(KeyEvent e) 
                {
                    keyR(e);
                }

                @Override
                public void keyTyped(KeyEvent e) 
                {
                }
            };  

        addKeyListener(keyAction);
        TimerTask newFrame = new TimerTask()
            {
                public void run() 
                {
                    requestFocus();
                    spawnEnemies();
                    misc();
                    rotateCorners();
                    moveObjects();
                    collideCheck();
                    refreshScreen();
                }
            };
        gameLoop = new Timer();
        damageMultiplyer = 1.0;
        valueMultiplyer = 1.0;
        if (saveScreen.data.currentMod == 7)
        {
        damageMultiplyer = 1.50;
        }
        else if (saveScreen.data.currentMod == 4)
        {
        valueMultiplyer = 1.25;
        }
        gameLoop.scheduleAtFixedRate(newFrame, 0, 33);
    }

    public void spawnEnemies()
    {
        for(int i = 0; i < saveScreen.data.enemyChain.size(); i++)
        {
            if (saveScreen.data.enemyChain.get(i).amount > 0)
            {
                if (saveScreen.data.enemyChain.get(i).initialDelay < 0)
                {
                    if(saveScreen.data.enemyChain.get(i).spawnCheck < 0)
                    {
                        saveScreen.data.enemyChain.get(i).spawnProcedure();
                        enemyList.add(new Enemy(saveScreen.data.enemyChain.get(i).xPos, this, saveScreen.data.enemyChain.get(i).enemyType));
                    }
                    else
                    {
                        saveScreen.data.enemyChain.get(i).spawnCheck -= 33;
                    }
                }
                else
                {
                    saveScreen.data.enemyChain.get(i).initialDelay -= 33;
                }
            }
            else
            {
                saveScreen.data.enemyChain.remove(i);
                i -= 1;
            }
        }
    }

    public void moveObjects()
    {
        space1.yPos += 2;
        space2.yPos += 2;
        if (space1.yPos >= space1.ySize)
        {
            space1.yPos = -space1.ySize;
        }
        if (space2.yPos >= space2.ySize)
        {
            space2.yPos = -space2.ySize;
        }
        if (player.up && player.yPos > 0)
        {
            player.yPos -= player.speed;
        }
        else if(player.yPos < 0)
        {
            player.yPos = 0;
        }
        if (player.right && player.xPos + player.xSize() / 2 < 1000)
        {
            player.xPos += player.speed;
        }
        else if(player.xPos + player.xSize() / 2 > 1000)
        {
            player.xPos = 1000 - player.xSize() / 2;
        }
        if (player.down && player.yPos + player.ySize() / 2 < 1000)
        {
            player.yPos += player.speed;
        }
        else if(player.yPos + player.ySize() / 2 > 1000)
        {
            player.yPos = 1000 - player.ySize() / 2;
        }
        if (player.left && player.xPos > 0 - player.xSize() / 2)
        {
            player.xPos -= player.speed;
        }
        else if(player.xPos < 0 - player.xSize() / 2)
        {
            player.xPos = 0 - player.xSize() / 2;
        }
        for (int i = 0; i < bulletList.size(); i++)
        {
            bulletList.get(i).move();
        }
        for (int i = 0; i < enemyList.size(); i++)
        {
            enemyList.get(i).move();
            if (enemyList.get(i).type.equals("asteroid") && saveScreen.data.currentMod == 3)
            {
                enemyList.get(i).moveMagnet(player.xPos + player.xSize() / 2, player.yPos + player.ySize() / 2, 250, 5);
            }
        }
        for (int i = 0; i < coinList.size(); i++)
        {
            coinList.get(i).move();
            coinList.get(i).moveMagnet(player.xPos + player.xSize() / 2, player.yPos + player.ySize() / 2, player.magnetD, player.magnetS);
        }
    }

    public void misc()
    {
        if (player.shotCD > 0)
        {
            player.shotCD -= 33;
        }
        else
        {
            player.shotCD = 0;
        }
        if (player.shotCD <= 0 && player.spaceDown)
        {
            player.shotCD = player.maxShotCD;
            if (player.bulletType.equals("shotGunCannon"))
            {
                Bullet bullet1 = new Bullet(0, 0, this, 90, player.bulletType, player);
                bullet1.xPos = player.xPos + (player.xSize() / 2) - (bullet1.xSize() / 2);
                bullet1.yPos = player.yPos - bullet1.ySize();
                bullet1.damage *= damageMultiplyer;
                bulletList.add(bullet1);
                Bullet bullet2 = new Bullet(0, 0, this, 90, player.bulletType, player);
                bullet2.xPos = player.xPos + (player.xSize() / 2) - (bullet2.xSize() / 2);
                bullet2.yPos = player.yPos - bullet2.ySize();
                bullet2.damage *= damageMultiplyer;
                bulletList.add(bullet2);
                Bullet bullet3 = new Bullet(0, 0, this, 90, player.bulletType, player);
                bullet3.xPos = player.xPos + (player.xSize() / 2) - (bullet3.xSize() / 2);
                bullet3.yPos = player.yPos - bullet3.ySize();
                bullet3.damage *= damageMultiplyer;
                bulletList.add(bullet3);
            }
            else 
            {
                Bullet bullet = new Bullet(0, 0, this, 90, player.bulletType, player);
                bullet.xPos = player.xPos + (player.xSize() / 2) - (bullet.xSize() / 2);
                bullet.yPos = player.yPos - bullet.ySize();
                bullet.damage *= damageMultiplyer;
                bulletList.add(bullet);
            }
        }
        for (int i = 0; i < enemyList.size(); i++)
        {    
            if (enemyList.get(i).slowCD <= 0)
            {
                enemyList.get(i).currentSpeed = enemyList.get(i).speed;
            }
            else
            {
                enemyList.get(i).slowCD -= 33;
            }
            if (enemyList.get(i).shootsBullet)
            {
                if (enemyList.get(i).shotCD > 0)
                {
                    enemyList.get(i).shotCD -= 33;
                }
                else
                {
                    enemyList.get(i).shotCD = enemyList.get(i).maxShotCD;                    
                    bulletList.add(new Bullet(enemyList.get(i).xPos + enemyList.get(i).xSize() / 2, enemyList.get(i).yPos + enemyList.get(i).ySize, enemyList.get(i).bullet));
                }
            }
            if (enemyList.get(i).health <= 0.0 || enemyList.get(i).yPos >= 1200)
            {
                for (int k = 0; k < enemyList.get(i).coinAmount; k++)
                {
                    Coin coin = new Coin(enemyList.get(i).xPos + enemyList.get(i).xSize() / 2, enemyList.get(i).yPos + enemyList.get(i).ySize() / 2, this, enemyList.get(i).coinType);
                    coin.value *= valueMultiplyer;
                    coinList.add(coin);
                }
                enemyList.remove(i);
            }
        }
        for (int i = 0; i < bulletList.size(); i++)
        {
            if (bulletList.get(i).bulletType.equals("flakCannon") && bulletList.get(i).isEnemy == false)
            {
                if (Utility.random(0, 100) < 3)
                {
                    bulletList.get(i).exploded = true;
                    Bullet bullet1 = new Bullet(bulletList.get(i).xPos, bulletList.get(i).yPos, this, 90, "flakCannonS", player);
                    bullet1.damage *= damageMultiplyer;
                    bulletList.add(bullet1);
                    Bullet bullet2 = new Bullet(bulletList.get(i).xPos, bulletList.get(i).yPos, this, 90, "flakCannonS", player);
                    bullet2.damage *= damageMultiplyer;
                    bulletList.add(bullet2);
                }
            }
            else if (bulletList.get(i).bulletType.equals("flakCannonS") && bulletList.get(i).isEnemy == false)
            {
                if (Utility.random(0, 100) < 3)
                {
                    bulletList.get(i).exploded = true;
                    Bullet bullet1 = new Bullet(bulletList.get(i).xPos, bulletList.get(i).yPos, this, 90, "flakCannonSS", player);
                    bullet1.damage *= damageMultiplyer;
                    bulletList.add(bullet1);
                    Bullet bullet2 = new Bullet(bulletList.get(i).xPos, bulletList.get(i).yPos, this, 90, "flakCannonSS", player);
                    bullet2.damage *= damageMultiplyer;
                    bulletList.add(bullet2);
                    Bullet bullet3 = new Bullet(bulletList.get(i).xPos, bulletList.get(i).yPos, this, 90, "flakCannonSS", player);
                    bullet1.damage *= damageMultiplyer;
                    bulletList.add(bullet3);
                    Bullet bullet4 = new Bullet(bulletList.get(i).xPos, bulletList.get(i).yPos, this, 90, "flakCannonSS", player);
                    bullet2.damage *= damageMultiplyer;
                    bulletList.add(bullet4);
                }
            }
            if (bulletList.get(i).bulletType.equals("flakCannon") && bulletList.get(i).isEnemy == true)
            {
                if (Utility.random(0, 100) < 3)
                {
                    bulletList.get(i).exploded = true;
                    Bullet bullet1 = new Bullet(bulletList.get(i).xPos, bulletList.get(i).yPos, this, 90, "flakCannonS", enemyList.get(0));
                    bullet1.damage *= damageMultiplyer;
                    bulletList.add(bullet1);
                    Bullet bullet2 = new Bullet(bulletList.get(i).xPos, bulletList.get(i).yPos, this, 90, "flakCannonS", enemyList.get(0));
                    bullet2.damage *= damageMultiplyer;
                    bulletList.add(bullet2);
                }
            }
            else if (bulletList.get(i).bulletType.equals("flakCannonS") && bulletList.get(i).isEnemy == true)
            {
                if (Utility.random(0, 100) < 3)
                {
                    bulletList.get(i).exploded = true;
                    Bullet bullet1 = new Bullet(bulletList.get(i).xPos, bulletList.get(i).yPos, this, 90, "flakCannonSS", enemyList.get(0));
                    bullet1.damage *= damageMultiplyer;
                    bulletList.add(bullet1);
                    Bullet bullet2 = new Bullet(bulletList.get(i).xPos, bulletList.get(i).yPos, this, 90, "flakCannonSS", enemyList.get(0));
                    bullet2.damage *= damageMultiplyer;
                    bulletList.add(bullet2);
                    Bullet bullet3 = new Bullet(bulletList.get(i).xPos, bulletList.get(i).yPos, this, 90, "flakCannonSS", enemyList.get(0));
                    bullet1.damage *= damageMultiplyer;
                    bulletList.add(bullet3);
                    Bullet bullet4 = new Bullet(bulletList.get(i).xPos, bulletList.get(i).yPos, this, 90, "flakCannonSS", enemyList.get(0));
                    bullet2.damage *= damageMultiplyer;
                    bulletList.add(bullet4);
                }
            }
            if (bulletList.get(i).exploded || bulletList.get(i).yPos < - 100)
            {
                bulletList.remove(i);
            }
        }
        for (int i = 0; i < coinList.size(); i++)
        {
            if (coinList.get(i).pickedUp || coinList.get(i).yPos > 1300)
            {
                coinList.remove(i);
            }
        }
        if (enemyList.size() == 0 && saveScreen.data.enemyChain.size() == 0)
        {
            levelBeaten = true;
        }
        if (player.health <= 0.0)
        {
            gameLoop.cancel();
            saveScreen.data.money += player.money / 4;
            saveScreen.data.moneyWon = player.money / 4;
            saveScreen.data.won = false;
            window.requestedScreen = "EndScreen";
        }
        else if (levelBeaten && winTimer <= 0)
        {
            gameLoop.cancel();
            saveScreen.data.money += player.money;
            saveScreen.data.moneyWon = player.money;
            saveScreen.data.won = true;
            window.requestedScreen = "EndScreen";
        }
        else if (levelBeaten)
        {
            winTimer -= 33;
        }
    }

    public void rotateImages()
    {
        player.image = Utility.rotateImage(player.origionalImage, player.angle);
        for (int i = 0; i < bulletList.size(); i++)
        {
            bulletList.get(i).image = Utility.rotateImage(bulletList.get(i).origionalImage, bulletList.get(i).angle);
        }
        for (int i = 0; i < enemyList.size(); i++)
        {
            enemyList.get(i).image = Utility.rotateImage(enemyList.get(i).origionalImage, enemyList.get(i).angle);
        }
    }

    public void rotateCorners()
    {  
        for (int i = 0; i < bulletList.size(); i++)
        {
            if (!bulletList.get(i).moveType.equals("linear"))
            {
                bulletList.get(i).corners = Utility.rotateCorners(bulletList.get(i).xSize(), bulletList.get(i).ySize(), bulletList.get(i).corners, bulletList.get(i).turnRate);
            }
        }
        for (int i = 0; i < enemyList.size(); i++)
        {
            if (!enemyList.get(i).moveType.equals("linear"))
            {
                enemyList.get(i).corners = Utility.rotateCorners(enemyList.get(i).xSize, enemyList.get(i).ySize, enemyList.get(i).corners, enemyList.get(i).turnRate);
            }
        }
    }

    public void collideCheck()
    {
        for (int i = 0; i < bulletList.size(); i++)
        {
            if (bulletList.get(i).isEnemy)
            {
                if (bulletList.get(i).collideCheck(player.xPos, player.yPos, player.corners))
                {
                    player.health -= bulletList.get(i).damage;
                    bulletList.get(i).exploded = true;
                }
            }
            else
            {
                for (int j = 0; j < enemyList.size(); j++)
                {
                    if (bulletList.get(i).bulletType.equals("lightningCannon"))
                    {
                        for( int k = 0; k < bulletList.get(i).corners.size(); k++)
                        {
                            bulletList.get(i).corners.get(k).moveMagnet((int)enemyList.get(j).xPos + enemyList.get(j).xSize() / 2, (int)enemyList.get(j).yPos + enemyList.get(j).ySize() / 2, (int)bulletList.get(i).xPos, (int)bulletList.get(i).yPos, 100, 50);
                        }      
                    }
                    if (bulletList.get(i).collideCheck(enemyList.get(j).xPos, enemyList.get(j).yPos, enemyList.get(j).corners))
                    {
                        if (bulletList.get(i).bulletType.equals("lightningCannon"))
                        {
                            enemyList.get(j).health -= bulletList.get(i).damage;
                        }
                        else if (bulletList.get(i).bulletType.equals("laserBeam"))
                        {
                            enemyList.get(j).health -= bulletList.get(i).damage;
                        }
                        else if (bulletList.get(i).bulletType.equals("iceRay"))
                        {
                            enemyList.get(j).currentSpeed = enemyList.get(j).speed - enemyList.get(j).speed / 5;
                            enemyList.get(j).slowCD = 3000;
                            enemyList.get(j).health -= bulletList.get(i).damage;
                            bulletList.get(i).exploded = true;
                        }
                        else
                        {
                            enemyList.get(j).health -= bulletList.get(i).damage;
                            bulletList.get(i).exploded = true;
                        }
                    }
                }
            }
        }
        for (int i = 0; i < enemyList.size(); i++)
        {
            if (enemyList.get(i).collideCheck(player.xPos, player.yPos, player.corners))
            {
                player.health -= enemyList.get(i).damage;
                enemyList.get(i).health = 0;
            }
        }
        for (int i = 0; i < coinList.size(); i++)
        {
            if (coinList.get(i).collideCheck(player.xPos, player.yPos, player.corners))
            {
                player.money += coinList.get(i).value;
                coinList.get(i).pickedUp = true;
            }
        }
    }

    public void refreshScreen()
    {
        repaint();
        revalidate();
    }

    public void keyP(KeyEvent e) 
    {
        try
        {
            if (e.getKeyChar() == 'w')
            {
                player.up = true;
            }
            else if (e.getKeyChar() == 'd')
            {
                player.right = true;
            }
            else if (e.getKeyChar() == 's')
            {
                player.down = true;
            }
            else if (e.getKeyChar() == 'a')
            {
                player.left = true;
            }
            else if (e.getKeyChar() == 'a' && saveScreen.data.currentMod == 8)
            {
                for (int i = 0; i < enemyList.size(); i++)
                {                  
                    enemyList.get(i).health = 0.0;
                }
            }
            else if (e.getKeyCode() == 32)
            {
                player.spaceDown = true;
            }
        }
        catch (NullPointerException h)
        {
            System.out.println("KeyPress error");  
        }
    }

    public void keyR(KeyEvent e) 
    {
        try
        {
            if (e.getKeyChar() == 'w')
            {
                player.up = false;
            }
            else if (e.getKeyChar() == 'd')
            {
                player.right = false;
            }
            else if (e.getKeyChar() == 's')
            {
                player.down = false;
            }
            else if (e.getKeyChar() == 'a')
            {
                player.left = false;
            }
            else if (e.getKeyChar() == 'j')
            {
                enemyList.add(new Enemy(300, this, "shooter"));
            }
            else if (e.getKeyCode() == 32)
            {
                player.spaceDown = false;
            }
        }
        catch (NullPointerException h)
        {
            System.out.println("KeyPress error");  
        }
    }

    public void paintComponent(Graphics g)
    {
        //g.setColor(Color.GREEN);
        g.setColor(Color.RED);
        //g.drawImage(player.image, (int)player.xPos, (int)player.yPos, null);
        g.drawImage(space1.image, space1.xPos, space1.yPos, null);
        g.drawImage(space2.image, space2.xPos, space2.yPos, null);
        for(int j = 0; j < player.corners.size() - 1; j++)
        {
            g.drawLine((int)(player.corners.get(j).xPos + player.xPos), (int)(player.corners.get(j).yPos + player.yPos),
                (int)(player.corners.get(j + 1).xPos + player.xPos), (int)(player.corners.get(j + 1).yPos + player.yPos));
        } 
        //g.setColor(Color.BLUE);
        for (int i = 0; i < bulletList.size(); i++)
        {
            //g.drawImage(bulletList.get(i).image, (int)bulletList.get(i).xPos, (int)bulletList.get(i).yPos, null);
            for(int j = 0; j < bulletList.get(i).corners.size() - 1; j++)
            {
                g.drawLine((int)(bulletList.get(i).corners.get(j).xPos + bulletList.get(i).xPos), (int)(bulletList.get(i).corners.get(j).yPos + bulletList.get(i).yPos),
                    (int)(bulletList.get(i).corners.get(j + 1).xPos + bulletList.get(i).xPos), (int)(bulletList.get(i).corners.get(j + 1).yPos + bulletList.get(i).yPos));
            }
        }
        //g.setColor(Color.RED);
        for (int i = 0; i < enemyList.size(); i++)
        {
            //g.drawImage(enemyList.get(i).image, (int)enemyList.get(i).xPos, (int)enemyList.get(i).yPos, null);
            for(int j = 0; j < enemyList.get(i).corners.size() - 1; j++)
            {
                g.drawLine((int)(enemyList.get(i).corners.get(j).xPos + enemyList.get(i).xPos), (int)(enemyList.get(i).corners.get(j).yPos + enemyList.get(i).yPos),
                    (int)(enemyList.get(i).corners.get(j + 1).xPos + enemyList.get(i).xPos), (int)(enemyList.get(i).corners.get(j + 1).yPos + enemyList.get(i).yPos));
            }
        }
        //g.setColor(Color.YELLOW);
        for (int i = 0; i < coinList.size(); i++)
        {
            //g.drawImage(coinList.get(i).image, (int)coinList.get(i).xPos, (int)coinList.get(i).yPos, null);
            for(int j = 0; j < coinList.get(i).corners.size() - 1; j++)
            {
                g.drawLine((int)(coinList.get(i).corners.get(j).xPos + coinList.get(i).xPos), (int)(coinList.get(i).corners.get(j).yPos + coinList.get(i).yPos),
                    (int)(coinList.get(i).corners.get(j + 1).xPos + coinList.get(i).xPos), (int)(coinList.get(i).corners.get(j + 1).yPos + coinList.get(i).yPos));
            }
        }
    }
}