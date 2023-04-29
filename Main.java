import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

import mechanics.*;

public class Main
{
    public static String SAVEFILESPATH = "saves/";

    public static void main(String[] args)
    {
        new MainWindow_();
    }

    public static boolean loadDifficulty(String name, int difficulty)
    {
        Game_ game = new Game_();
        game.loadGame(SAVEFILESPATH + name);
        if (!game.valid)
        {
            return false;
        }

        switch (difficulty)
        {
            case 1:
                game.difficulty = 1;
                game.resources.gold = 1600;
                game.resources.food = 500;
                game.resources.wood = 80;
                game.resources.stone = 80;
                game.taxBase = 500;
                game.taxExtra = 150;
                game.buyBase = 400;
                game.buyExtra = 100;
                game.secondChance = true;
                break;
            case 2:
                game.difficulty = 2;
                game.resources.gold = 800;
                game.resources.food = 200;
                game.resources.wood = 20;
                game.resources.stone = 20;
                game.taxBase = 600;
                game.taxExtra = 200;
                game.buyBase = 500;
                game.buyExtra = 150;
                game.secondChance = true;
                break;
            case 3:
                game.difficulty = 3;
                game.resources.gold = 400;
                game.resources.food = 100;
                game.resources.wood = 0;
                game.resources.stone = 0;
                game.taxBase = 700;
                game.taxExtra = 250;
                game.buyBase = 600;
                game.buyExtra = 200;
                game.secondChance = false;
                break;
        }

        Window_ window = new Window_();
        game.window = window;
        window.game = game;

        game.update();
        return true;

    }
    
    public static boolean loadSave(String name)
    {
        Game_ game = new Game_();
        game.loadGame(SAVEFILESPATH + name);
        if (!game.valid)
        {
            return false;
        }

        Window_ window = new Window_();
        game.window = window;
        window.game = game;

        game.update();
        return true;
    }
}

class MainWindow_ extends JFrame implements KeyListener, MouseListener
{
    public int mode = 1; // 1 is new game, 2 is load game
    public int difficulty = 2;
    public JLayeredPane mainBox;
    public JPanel mainBoxBackground;
    public JLabel mainMessage;

    //region choices
    public JLabel mainNew;
    public JLabel mainLoad;
    public JLabel mainQuit;
    public JLabel mainEasy;
    public JLabel mainMedium;
    public JLabel mainHard;
    public JLabel mainSave1;
    public JLabel mainSave2;
    public JLabel mainSave3;
    //endregion

    public MainWindow_()
    {
        super();
        this.setVisible(true);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400 + getInsets().left + getInsets().right, 320 + getInsets().top + getInsets().bottom);
        this.setResizable(false);
        this.setTitle("Trade Archipelago - Main Menu");
        this.setLayout(null);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.addKeyListener(this);

        mainBox = new JLayeredPane();
        mainBox.setBounds(0, 0, 400, 320);
        this.add(mainBox);
        mainBoxBackground = new JPanel();
        mainBoxBackground.setBounds(0, 0, 400, 320);
        mainBoxBackground.setBackground(Color.black);
        mainBox.add(mainBoxBackground);
        mainBox.setLayer(mainBoxBackground, -1, 0);
        
        mainMessage = new JLabel();
        mainMessage.setBounds(0, 0, 400, 20);
        mainMessage.setText("Trade Archipelago - Main Menu");
        mainMessage.setHorizontalAlignment(SwingConstants.CENTER);
        mainMessage.setForeground(Color.white);
        mainBox.add(mainMessage);

        //region menu
        mainNew = new JLabel();
        mainNew.setBounds(50, 30, 300, 80);
        mainNew.setText("NEW GAME");
        mainNew.setFont(mainNew.getFont().deriveFont(32f));
        mainNew.setHorizontalAlignment(SwingConstants.CENTER);
        mainNew.setOpaque(true);
        mainNew.setBackground(Color.gray);
        mainNew.setForeground(Color.black);
        mainBox.add(mainNew);
        mainNew.addMouseListener(this);

        mainLoad = new JLabel();
        mainLoad.setBounds(50, 130, 300, 80);
        mainLoad.setText("LOAD GAME");
        mainLoad.setFont(mainLoad.getFont().deriveFont(32f));
        mainLoad.setHorizontalAlignment(SwingConstants.CENTER);
        mainLoad.setOpaque(true);
        mainLoad.setBackground(Color.gray);
        mainLoad.setForeground(Color.black);
        mainBox.add(mainLoad);
        mainLoad.addMouseListener(this);

        mainQuit = new JLabel();
        mainQuit.setBounds(50, 230, 300, 80);
        mainQuit.setText("QUIT");
        mainQuit.setFont(mainQuit.getFont().deriveFont(32f));
        mainQuit.setHorizontalAlignment(SwingConstants.CENTER);
        mainQuit.setOpaque(true);
        mainQuit.setBackground(Color.gray);
        mainQuit.setForeground(Color.black);
        mainBox.add(mainQuit);
        mainQuit.addMouseListener(this);
        //endregion


        //region difficulty
        mainEasy = new JLabel();
        mainEasy.setBounds(50, 30, 300, 80);
        mainEasy.setText("EASY");
        mainEasy.setFont(mainEasy.getFont().deriveFont(32f));
        mainEasy.setHorizontalAlignment(SwingConstants.CENTER);
        mainEasy.setOpaque(true);
        mainEasy.setBackground(Color.gray);
        mainEasy.setForeground(Color.black);
        mainBox.add(mainEasy);
        mainEasy.addMouseListener(this);
        mainEasy.setVisible(false);

        mainMedium = new JLabel();
        mainMedium.setBounds(50, 130, 300, 80);
        mainMedium.setText("MEDIUM");
        mainMedium.setFont(mainMedium.getFont().deriveFont(32f));
        mainMedium.setHorizontalAlignment(SwingConstants.CENTER);
        mainMedium.setOpaque(true);
        mainMedium.setBackground(Color.gray);
        mainMedium.setForeground(Color.black);
        mainBox.add(mainMedium);
        mainMedium.addMouseListener(this);
        mainMedium.setVisible(false);

        mainHard = new JLabel();
        mainHard.setBounds(50, 230, 300, 80);
        mainHard.setText("HARD");
        mainHard.setFont(mainHard.getFont().deriveFont(32f));
        mainHard.setHorizontalAlignment(SwingConstants.CENTER);
        mainHard.setOpaque(true);
        mainHard.setBackground(Color.gray);
        mainHard.setForeground(Color.black);
        mainBox.add(mainHard);
        mainHard.addMouseListener(this);
        mainHard.setVisible(false);
        //endregion


        //region save
        mainSave1 = new JLabel();
        mainSave1.setBounds(50, 30, 300, 80);
        mainSave1.setText("SAVE 1");
        mainSave1.setFont(mainSave1.getFont().deriveFont(32f));
        mainSave1.setHorizontalAlignment(SwingConstants.CENTER);
        mainSave1.setOpaque(true);
        mainSave1.setBackground(Color.gray);
        mainSave1.setForeground(Color.black);
        mainBox.add(mainSave1);
        mainSave1.addMouseListener(this);
        mainSave1.setVisible(false);

        mainSave2 = new JLabel();
        mainSave2.setBounds(50, 130, 300, 80);
        mainSave2.setText("SAVE 2");
        mainSave2.setFont(mainSave2.getFont().deriveFont(32f));
        mainSave2.setHorizontalAlignment(SwingConstants.CENTER);
        mainSave2.setOpaque(true);
        mainSave2.setBackground(Color.gray);
        mainSave2.setForeground(Color.black);
        mainBox.add(mainSave2);
        mainSave2.addMouseListener(this);
        mainSave2.setVisible(false);

        mainSave3 = new JLabel();
        mainSave3.setBounds(50, 230, 300, 80);
        mainSave3.setText("SAVE 3");
        mainSave3.setFont(mainSave3.getFont().deriveFont(32f));
        mainSave3.setHorizontalAlignment(SwingConstants.CENTER);
        mainSave3.setOpaque(true);
        mainSave3.setBackground(Color.gray);
        mainSave3.setForeground(Color.black);
        mainBox.add(mainSave3);
        mainSave3.addMouseListener(this);
        mainSave3.setVisible(false);
        //endregion
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e)
    {
        if (e.getKeyCode() == 27)
        {
            loadMenu();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {}

    @Override
    public void mouseClicked(MouseEvent e)
    {
        Component componentClicked = e.getComponent();
        if (componentClicked == mainNew)
        {
            mode = 1;
            loadDifficulty();
        }
        else if (componentClicked == mainLoad)
        {
            mode = 2;
            loadSave();
        }
        else if (componentClicked == mainQuit)
        {
            this.dispose();
        }

        //region difficulty
        else if (componentClicked == mainEasy)
        {
            difficulty = 1;
            loadSave();
        }
        else if (componentClicked == mainMedium)
        {
            difficulty = 2;
            loadSave();
        }
        else if (componentClicked == mainHard)
        {
            difficulty = 3;
            loadSave();
        }
        //endregion
        
        //region save
        else if (componentClicked == mainSave1)
        {
            if (mode == 1)
            {
                if (Main.loadDifficulty("save1.txt", difficulty))
                {
                    this.dispose();
                }
                else
                {
                    mainMessage.setText("There was an error opening the save. Did you modify it ?");
                }
            }
            else
            {
                if (Main.loadSave("save1.txt"))
                {
                    this.dispose();
                }
                else
                {
                    mainMessage.setText("There was an error opening the save. Did you modify it ?");
                }
            }
        }
        else if (componentClicked == mainSave2)
        {
            if (mode == 1)
            {
                if (Main.loadDifficulty("save2.txt", difficulty))
                {
                    this.dispose();
                }
                else
                {
                    mainMessage.setText("There was an error opening the save. Did you modify it ?");
                }
            }
            else
            {
                if (Main.loadSave("save2.txt"))
                {
                    this.dispose();
                }
                else
                {
                    mainMessage.setText("There was an error opening the save. Did you modify it ?");
                }
            }
        }
        else if (componentClicked == mainSave3)
        {
            if (mode == 1)
            {
                if (Main.loadDifficulty("save3.txt", difficulty))
                {
                    this.dispose();
                }
                else
                {
                    mainMessage.setText("There was an error opening the save. Did you modify it ?");
                }
            }
            else
            {
                if (Main.loadSave("save3.txt"))
                {
                    this.dispose();
                }
                else
                {
                    mainMessage.setText("There was an error opening the save. Did you modify it ?");
                }
            }
        }
        //endregion
    }

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}

    public void loadMenu()
    {
        mainNew.setVisible(true);
        mainLoad.setVisible(true);
        mainQuit.setVisible(true);
        mainEasy.setVisible(false);
        mainMedium.setVisible(false);
        mainHard.setVisible(false);
        mainSave1.setVisible(false);
        mainSave2.setVisible(false);
        mainSave3.setVisible(false);

        mainMessage.setText("Trade Archipelago - Main Menu");
    }

    public void loadDifficulty()
    {
        mainNew.setVisible(false);
        mainLoad.setVisible(false);
        mainQuit.setVisible(false);
        mainEasy.setVisible(true);
        mainMedium.setVisible(true);
        mainHard.setVisible(true);
        mainSave1.setVisible(false);
        mainSave2.setVisible(false);
        mainSave3.setVisible(false);

        mainMessage.setText("Please select a difficulty.");
    }

    public void loadSave()
    {
        mainNew.setVisible(false);
        mainLoad.setVisible(false);
        mainQuit.setVisible(false);
        mainEasy.setVisible(false);
        mainMedium.setVisible(false);
        mainHard.setVisible(false);
        mainSave1.setVisible(true);
        mainSave2.setVisible(true);
        mainSave3.setVisible(true);

        mainMessage.setText("Please select a save slot.");
    }
}
