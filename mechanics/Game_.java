package mechanics;

import buildings.*;
import events.*;

import java.io.*;
import java.util.*;

import static shortcuts.Shortcuts_.*;

public class Game_
{
    public String saveName;
    public Window_ window;
    public Random rng = new Random();
    public EventLists_ eventLists = new EventLists_(this);

    public boolean valid = false;
    public boolean taxPaid = true;
    public boolean hasWon = false;

    public int turn;
    public int difficulty = 2; // 1 easy, 2 medium, 3 hard
    public boolean secondChance;
    public int seed;
    public Event_ turnEvent = null;

    public int taxBase = 600;
    public int taxExtra = 200;
    public int buyBase = 200;
    public int buyExtra = 150;

    public Island_[] islands;
    public Event_[] ships;
    public int nbIslandsOwned;

    public Resources_ resources = new Resources_();
    public Resources_ income = new Resources_();

    public Game_()
    {
        //
    }

    public void loadGame(String filePath)
    {
        try // Pour le moment, on vérifie juste les booléens.
        {
            File file = new File(filePath);
            BufferedReader reader = new BufferedReader(new FileReader(file));
            saveName = reader.readLine(); // line 1
            int b = Integer.parseInt(reader.readLine()); // line 2
            valid = (b == 1);
            seed = Integer.parseInt(reader.readLine()); // line 3
            difficulty = Integer.parseInt(reader.readLine()); // line 4
            resources.gold = Integer.parseInt(reader.readLine()); // line5
            resources.food = Integer.parseInt(reader.readLine()); // line
            resources.wood = Integer.parseInt(reader.readLine()); // line
            resources.stone = Integer.parseInt(reader.readLine()); // line 8
            turn = Integer.parseInt(reader.readLine()); // line 9
            b = Integer.parseInt(reader.readLine()); // line 10
            if (b != 0 && b != 1) { valid = false; }
            secondChance = (b == 1);

            int nbIslands = Integer.parseInt(reader.readLine()); // line 11
            islands = new Island_[nbIslands];
            ships = new Event_[nbIslands];

            for (int n = 0; n < nbIslands; ++n) {
                Island_ i = new Island_();
                i.id = n;
                i.name = reader.readLine(); // line 12
                i.specialty1 = reader.readLine(); // line 13
                i.specialty2 = reader.readLine(); // line 14
                b = Integer.parseInt(reader.readLine()); // line 15
                if (b != 0 && b != 1) { valid = false; }
                i.isOwned = (b == 1);
                if (b == 1) { ++nbIslandsOwned; }

                i.people = Integer.parseInt(reader.readLine()); // line 16
                i.peopleG = Integer.parseInt(reader.readLine()); // line
                i.peopleF = Integer.parseInt(reader.readLine()); // line
                i.peopleW = Integer.parseInt(reader.readLine()); // line
                i.peopleS = Integer.parseInt(reader.readLine()); // line 20

                i.p = new City_(Integer.parseInt(reader.readLine())); // line 21
                i.g1 = new Market_(1, Integer.parseInt(reader.readLine())); // line
                i.g2 = new Market_(2, Integer.parseInt(reader.readLine())); // line
                i.f1 = new Pier_(1, Integer.parseInt(reader.readLine())); // line
                i.f2 = new Pier_(2, Integer.parseInt(reader.readLine())); // line
                i.w1 = new Yard_(1, Integer.parseInt(reader.readLine())); // line
                i.w2 = new Yard_(2, Integer.parseInt(reader.readLine())); // line
                i.s1 = new Quarry_(1, Integer.parseInt(reader.readLine())); // line
                i.s2 = new Quarry_(2, Integer.parseInt(reader.readLine())); // line 29

                islands[n] = i;
            }

            b = Integer.parseInt(reader.readLine()); // last line
            if (b != 0 && b != 1) { valid = false; }
            hasWon = (b == 1);

            generateEvents();
        }
        catch (Exception e)
        {
            valid = false;
            e.printStackTrace();
        }
    }

    public void saveGame()
    {
        try
        {
            File file = new File("saves/" + saveName + ".txt");
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));

            writer.write(saveName); writer.newLine();
            writer.write(valid ? "1" : "0"); writer.newLine();
            writer.write("" + seed); writer.newLine();
            writer.write("" + difficulty); writer.newLine();

            writer.write("" + resources.gold); writer.newLine();
            writer.write("" + resources.food); writer.newLine();
            writer.write("" + resources.wood); writer.newLine();
            writer.write("" + resources.stone); writer.newLine();

            writer.write("" + turn); writer.newLine();
            writer.write(valid ? "1" : "0"); writer.newLine();

            writer.write("" + islands.length); writer.newLine();
            for (Island_ i : islands)
            {
                writer.write(i.name); writer.newLine();
                writer.write(i.specialty1); writer.newLine();
                writer.write(i.specialty2); writer.newLine();
                writer.write(i.isOwned ? "1" : "0"); writer.newLine();

                writer.write("" + i.people); writer.newLine();
                writer.write("" + i.peopleG); writer.newLine();
                writer.write("" + i.peopleF); writer.newLine();
                writer.write("" + i.peopleW); writer.newLine();
                writer.write("" + i.peopleS); writer.newLine();


                writer.write("" + i.p.level); writer.newLine();
                writer.write("" + i.g1.level); writer.newLine();
                writer.write("" + i.g2.level); writer.newLine();
                writer.write("" + i.f1.level); writer.newLine();
                writer.write("" + i.f2.level); writer.newLine();
                writer.write("" + i.w1.level); writer.newLine();
                writer.write("" + i.w2.level); writer.newLine();
                writer.write("" + i.s1.level); writer.newLine();
                writer.write("" + i.s2.level); writer.newLine();
            }

            writer.write(hasWon ? "1" : "0"); writer.newLine();

            writer.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void update()
    {
        if (!valid) { window.newPopup("GAME STATE IS NOT VALID."); }

        income.setZero();
        for (Island_ i : islands)
        {
            i.update();
            if (i.isOwned)
            {
                income.add(i.income);
            }
        }
        updateDisplay();
    }

    public void updateDisplay()
    {
        window.turn.setText("" + turn + " (" + (12 - turn % 12) + ")");
        window.gold.setText(resources.gold + " G");
        window.goldIncome.setText(income.gold + " +");
        window.food.setText(resources.food + " F");
        window.foodIncome.setText(income.food + " +");
        window.wood.setText(resources.wood + " W");
        window.woodIncome.setText(income.wood + " +");
        window.stone.setText(resources.stone + " S");
        window.stoneIncome.setText(income.stone + " +");

        if (window.islandBox.isVisible())
        {
            window.loadIsland();
        }
    }

    public void skipTurn()
    {
        if (!valid) { window.newPopup("GAME STATE IS NOT VALID."); }

        if (resources.gold >= 16000 && !hasWon)
        {
            win();
            return;
        }
        else if (turn % 12 == 0 && turnEvent == null && !taxPaid && !hasWon)
        {
            turnTax();
        }
        if (turnEvent != null)
        {
            window.loadEvent(turnEvent);
            return;
        }

        while (income.food < 0)
        {
            for (Island_ i : islands)
            {
                if (i.isOwned)
                {
                    i.deleteP(true);
                }
            }
            update();
        }

        ++turn;
        seed = rng.nextInt(10000);
        generateEvents();

        resources.add(income);
        update();
    }

    public void generateEvents()
    {
        for (int i = 0; i < islands.length; ++i)
        {
            ships[i] = eventLists.Ship(seed + i);
            ships[i].island = islands[i];
        }
        if (turn % 12 == 0 && !hasWon)
        {
            taxPaid = false;
            turnEvent = null;
        }
        else if (seed < 600)
        {
            turnEvent = eventLists.Global(seed);
        }
        else if (seed < 800)
        {
            turnEvent = eventLists.Local(seed);
            turnEvent.island = islands[0];
        }
        else if (seed < 1000)
        {
            turnEvent = eventLists.Local(seed);
            turnEvent.island = islands[1];
        }
        else if (seed < 1200)
        {
            turnEvent = eventLists.Local(seed);
            turnEvent.island = islands[2];
        }
        else if (seed < 1400)
        {
            turnEvent = eventLists.Local(seed);
            turnEvent.island = islands[3];
        }
    }

    public void turnTax()
    {
        if (resources.gold >= 800) { turnEvent = eventLists.taxOk(); }
        else if (secondChance) { turnEvent = eventLists.taxSC(); }
        else { turnEvent = eventLists.taxNope(); taxPaid = false; }
    }

    public void win()
    {
        turnEvent = eventLists.independence();
        window.loadEvent(turnEvent);
    }
}
