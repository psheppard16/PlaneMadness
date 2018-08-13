
/**
 * Write a description of class SpawnChain here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.ArrayList;
public class SpawnGroup
{
    int xPos;
    String enemyType;
    int initialDelay;
    int timeInterval;
    int spawnCheck;
    int xShift;
    int amount;
    public SpawnGroup(int xPos, String enemyType, int amount, int initialDelay, int timeInterval, int xShift)
    {
        this.amount = amount;
        this.xPos = xPos - xShift;
        this.enemyType = enemyType;
        this.xShift = xShift;
        this.initialDelay = initialDelay;
        this.timeInterval = timeInterval;
        this.spawnCheck = timeInterval;
    }

    public void spawnProcedure()
    {
        if (enemyType.equals("asteroid"))
        {
            spawnCheck = timeInterval;
            xPos = Utility.random(0, 1000);
            amount -= 1;
        }
        else
        {
            spawnCheck = timeInterval;
            xPos += xShift;
            amount -= 1;
        }
    }
}
