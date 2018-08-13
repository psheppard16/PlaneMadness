
/**
 * Write a description of class PlayerData here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.ArrayList;
import java.io.*;
import java.awt.*;
public class PlayerData
{
    ArrayList<String> completeFile;
    ArrayList<String> shipsOwned;
    ArrayList<String> shotsOwned;
    ArrayList<String> modsOwned;
    int currentShip;
    int currentShot;
    int currentMod;
    int levelsBeaten;
    int money;
    int fileNumber;
    final String path;
    int fileStartLine;
    ArrayList<SpawnGroup> enemyChain;
    boolean won;
    int moneyWon;
    public PlayerData(int fileNumber)
    {
        path = "playerData.txt";
        completeFile = new ArrayList<String>();
        enemyChain = new ArrayList<SpawnGroup>();
        shipsOwned = new ArrayList<String>(0);
        shotsOwned = new ArrayList<String>(0);
        modsOwned = new ArrayList<String>(0);
        this.fileNumber = fileNumber;
        fileStartLine = (fileNumber - 1) * (35);
        try
        {
            completeFile = readFile(0, 105);
            shipsOwned = readFile(fileStartLine, 10);
            shotsOwned = readFile(fileStartLine + 10, 10);
            modsOwned = readFile(fileStartLine + 20, 10);
            levelsBeaten = Integer.parseInt(readFile(fileStartLine + 30, 1).get(0));
            money = Integer.parseInt(readFile(fileStartLine + 31, 1).get(0));
            currentShip = Integer.parseInt(readFile(fileStartLine + 32, 1).get(0));
            currentShot = Integer.parseInt(readFile(fileStartLine + 33, 1).get(0));
            currentMod = Integer.parseInt(readFile(fileStartLine + 34, 1).get(0));
        }
        catch (IOException e)
        {
            System.out.println("error loading data");
        }
        money = 100000000;
    }

    public void updateFile()
    {
        try
        {
            FileWriter statistics = new FileWriter(path, false);
            PrintWriter stats = new PrintWriter(statistics);
            for(int i = 0; i < 105; i++)
            {
                stats.printf("%s" + "%n", completeFile.get(i));
            }
            stats.close();
        }
        catch(IOException e)
        {
        }
    }

    public void updateData()
    {
        for(int i = 0; i < 10; i++)
        {
            completeFile.set(fileStartLine + i, shipsOwned.get(i));
        }
        for(int i = 0; i < 10; i++)
        {
            completeFile.set(fileStartLine + i + 10, shotsOwned.get(i));
        }
        for(int i = 0; i < 10; i++)
        {
            completeFile.set(fileStartLine + i + 20, modsOwned.get(i));
        }
        completeFile.set(fileStartLine + 30, Integer.toString(levelsBeaten));
        completeFile.set(fileStartLine + 31, Integer.toString(money));
        completeFile.set(fileStartLine + 32, Integer.toString(currentShip));
        completeFile.set(fileStartLine + 33, Integer.toString(currentShot));
        completeFile.set(fileStartLine + 34, Integer.toString(currentMod));
    }

    /**
     * Reads a file from a starting point for a desired number of lines.
     * @return the content of the file in an arrayList.
     */
    public ArrayList<String> readFile(int startingLine, int linesToRead) throws IOException
    {
        FileReader statistics = new FileReader(path);
        BufferedReader statsReader = new BufferedReader(statistics);
        ArrayList<String> fileContent = new ArrayList();
        for (int i = 0; i < startingLine + linesToRead; i++)
        {            
            if (i >= startingLine)
            {
                fileContent.add(statsReader.readLine());
            }
            else 
            {
                statsReader.readLine();   
            }
        }
        statsReader.close();
        return fileContent;
    }

    /**
     * Adds one line of text onto the end of a file.
     */
    public void writeToFile(String text)
    throws IOException
    {
        FileWriter statistics = new FileWriter(path, true);
        PrintWriter stats = new PrintWriter(statistics);
        stats.printf("%s" + "%n", text);
        stats.close();
    }

    /**
     * Rewrites a file with the content of an array.
     */
    public void writeToFile(ArrayList<String> file)
    throws IOException
    {
        FileWriter statistics = new FileWriter(path, false);
        PrintWriter stats = new PrintWriter(statistics);
        for (int i = 0; i < file.size(); i++)
        {
            stats.printf("%s" + "%n", file.get(i));
        }
        stats.close();
    }
}
