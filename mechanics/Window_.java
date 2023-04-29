package mechanics;

import buildings.*;
import events.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import static shortcuts.Shortcuts_.prl;

public class Window_ extends JFrame implements KeyListener, MouseListener
{
    public Game_ game;
    public Island_ islandSelected;
    public Island_ islandToBuy;
    public Building_ buildingSelected;
    public Event_ eventSelected;
    public int gradeMode; // 1 for upgrade, -1 for downgrade
    public boolean isPaused;

    public JLayeredPane layers;
    public JPanel layersBackground;


    //region pause
    public JLayeredPane pauseBox;
    public JPanel pauseBoxBackground;
    public JLabel pauseResume;
    public JLabel pauseSave;
    public JLabel pauseQuit;
    //endregion


    //region popup
    public JLayeredPane popupBox;
    public JPanel popupBoxBackground;
    public JLabel popupText;
    public JLabel popupClose;
    //endregion


    //region turn
    public JLayeredPane turnBox;
    public JPanel turnBoxBackground;
    public JLabel turn;
    public JLabel turnSkip;
    //endregion


    //region resources
    public JLayeredPane resourcesBox;
    public JPanel resourcesBoxBackground;
    public JLabel gold;
    public JLabel food;
    public JLabel wood;
    public JLabel stone;
    public JLabel goldIncome;
    public JLabel foodIncome;
    public JLabel woodIncome;
    public JLabel stoneIncome;
    //endregion


    //region select
    public JLayeredPane selectBox;
    public JPanel selectBoxBackground;
    public JLabel select1;
    public JLabel select1Ship;
    public JLabel select2;
    public JLabel select2Ship;
    public JLabel select3;
    public JLabel select3Ship;
    public JLabel select4;
    public JLabel select4Ship;
    //endregion


    //region grade
    public JLayeredPane gradeBox;
    public JPanel gradeBoxBackground;
    public JLabel gradePrompt;
    public JLabel gradeCurrentText;
    public JLabel gradeAfterText;
    public JLabel gradeClose;
    public JLabel gradeValidate;
    //endregion


    //region island
    public JLayeredPane islandBox;
    public JPanel islandBoxBackground;
    public JLabel islandName;
    public JLabel islandPeople;
    public JLabel islandP;
    public JLabel islandPUpgrade;
    public JLabel islandPDowngrade;
    public JLabel islandG1;
    public JLabel islandG1Upgrade;
    public JLabel islandG1Downgrade;
    public JLabel islandG2;
    public JLabel islandG2Upgrade;
    public JLabel islandG2Downgrade;
    public JLabel islandPeopleG;
    public JLabel islandPeopleGUp;
    public JLabel islandPeopleGDown;
    public JLabel islandF1;
    public JLabel islandF1Upgrade;
    public JLabel islandF1Downgrade;
    public JLabel islandF2;
    public JLabel islandF2Upgrade;
    public JLabel islandF2Downgrade;
    public JLabel islandPeopleF;
    public JLabel islandPeopleFUp;
    public JLabel islandPeopleFDown;
    public JLabel islandW1;
    public JLabel islandW1Upgrade;
    public JLabel islandW1Downgrade;
    public JLabel islandW2;
    public JLabel islandW2Upgrade;
    public JLabel islandW2Downgrade;
    public JLabel islandPeopleW;
    public JLabel islandPeopleWUp;
    public JLabel islandPeopleWDown;
    public JLabel islandS1;
    public JLabel islandS1Upgrade;
    public JLabel islandS1Downgrade;
    public JLabel islandS2;
    public JLabel islandS2Upgrade;
    public JLabel islandS2Downgrade;
    public JLabel islandPeopleS;
    public JLabel islandPeopleSUp;
    public JLabel islandPeopleSDown;
    public JLabel islandDrawer;
    //endregion


    //region event
    public JLayeredPane eventBox;
    public JPanel eventBoxBackground;
    public JLabel eventTitle;
    public JLabel eventText1;
    public JLabel eventText2;
    public JLabel eventText3;
    public JLabel eventText4;
    public JLabel eventClose;
    public JLabel eventChoice1Text;
    public JLabel eventChoice1Resources;
    public JLabel eventChoice2Text;
    public JLabel eventChoice2Resources;
    public JLabel eventChoice3Text;
    public JLabel eventChoice3Resources;
    public JLabel eventChoice4Text;
    public JLabel eventChoice4Resources;
    //endregion


    //region buy
    public JLayeredPane buyBox;
    public JPanel buyBoxBackground;
    public JLabel buyText1;
    public JLabel buyText2;
    public JLabel buyClose;
    public JLabel buyValidate;
    //endregion

    public Window_()
    {
        super();
        this.setVisible(true);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1000 + getInsets().left + getInsets().right, 500 + getInsets().top + getInsets().bottom);
        this.setResizable(false);
        this.setTitle("Trade Archipelago - Game");
        this.setLayout(null);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.addKeyListener(this);

        layers = new JLayeredPane();
        layers.setBounds(0, 0, 1000, 500);
        this.add(layers);
        layersBackground = new JPanel();
        layersBackground.setBounds(0, 0, 1000, 500);
        layersBackground.setBackground(Color.gray);
        layers.add(layersBackground);
        layers.setLayer(layersBackground, -1, 0);


        //region pause
        pauseBox = new JLayeredPane();
        pauseBox.setBounds(425, 200, 150, 120);
        layers.add(pauseBox);
        pauseBoxBackground = new JPanel();
        pauseBoxBackground.setBounds(0, 0, 150, 120);
        pauseBoxBackground.setBackground(Color.black);
        pauseBox.add(pauseBoxBackground);
        pauseBox.setLayer(pauseBoxBackground, -1, 0);

        pauseResume = new JLabel();
        pauseResume.setBounds(3, 3, 144, 34);
        pauseResume.setText("Resume");
        pauseResume.setHorizontalAlignment(SwingConstants.CENTER);
        pauseResume.setOpaque(true);
        pauseResume.setBackground(Color.gray);
        pauseResume.setForeground(Color.black);
        pauseBox.add(pauseResume);
        pauseResume.addMouseListener(this);

        pauseSave = new JLabel();
        pauseSave.setBounds(3, 43, 144, 34);
        pauseSave.setText("Save");
        pauseSave.setHorizontalAlignment(SwingConstants.CENTER);
        pauseSave.setOpaque(true);
        pauseSave.setBackground(Color.gray);
        pauseSave.setForeground(Color.black);
        pauseBox.add(pauseSave);
        pauseSave.addMouseListener(this);

        pauseQuit = new JLabel();
        pauseQuit.setBounds(3, 83, 144, 34);
        pauseQuit.setText("Quit");
        pauseQuit.setHorizontalAlignment(SwingConstants.CENTER);
        pauseQuit.setOpaque(true);
        pauseQuit.setBackground(Color.gray);
        pauseQuit.setForeground(Color.black);
        pauseBox.add(pauseQuit);
        pauseQuit.addMouseListener(this);

        pauseBox.setVisible(false);
        //endregion


        //region popup
        popupBox = new JLayeredPane();
        popupBox.setBounds(425, 175, 150, 50);
        layers.add(popupBox);
        layers.setLayer(popupBox, 5, 0);
        popupBoxBackground = new JPanel();
        popupBoxBackground.setBounds(0, 0, 150, 50);
        popupBoxBackground.setBackground(Color.black);
        popupBox.add(popupBoxBackground);
        popupBox.setLayer(popupBoxBackground, -1, 0);

        popupText = new JLabel();
        popupText.setBounds(3, 20, 144, 27);
        popupText.setText("Popup Window");
        popupText.setHorizontalAlignment(SwingConstants.CENTER);
        popupText.setOpaque(true);
        popupText.setBackground(Color.gray);
        popupText.setForeground(Color.black);
        popupBox.add(popupText);

        popupClose = new JLabel();
        popupClose.setBounds(130, 0, 20, 20);
        popupClose.setText("X");
        popupClose.setHorizontalAlignment(SwingConstants.CENTER);
        popupClose.setForeground(Color.red);
        popupBox.add(popupClose);
        popupClose.addMouseListener(this);

        popupBox.setVisible(false);
        //endregion


        //region turns
        turnBox = new JLayeredPane();
        turnBox.setBounds(877, 0, 123, 30);
        layers.add(turnBox);
        turnBoxBackground = new JPanel();
        turnBoxBackground.setBounds(0, 0, 123, 30);
        turnBoxBackground.setBackground(Color.black);
        turnBox.add(turnBoxBackground);
        turnBox.setLayer(turnBoxBackground, -1, 0);

        turn = new JLabel();
        turn.setBounds(3, 0, 70, 30);
        turn.setText("0");
        turn.setHorizontalAlignment(SwingConstants.LEFT);
        turn.setForeground(Color.white);
        turnBox.add(turn);

        turnSkip = new JLabel();
        turnSkip.setBounds(73, 0, 50, 30);
        turnSkip.setText("SKIP");
        turnSkip.setHorizontalAlignment(SwingConstants.LEFT);
        turnSkip.setForeground(Color.white);
        turnBox.add(turnSkip);
        turnSkip.addMouseListener(this);
        //endregion


        //region resources
        resourcesBox = new JLayeredPane();
        resourcesBox.setBounds(0, 0, 300, 50);
        layers.add(resourcesBox);
        resourcesBoxBackground = new JPanel();
        resourcesBoxBackground.setBounds(0, 0, 300, 50);
        resourcesBoxBackground.setBackground(Color.black);
        resourcesBox.add(resourcesBoxBackground);
        resourcesBox.setLayer(resourcesBoxBackground, -1, 0);

        gold = new JLabel();
        gold.setBounds(0, 0, 75, 25);
        gold.setText("0 G");
        gold.setHorizontalAlignment(SwingConstants.RIGHT);
        gold.setForeground(Color.white);
        resourcesBox.add(gold);

        goldIncome = new JLabel();
        goldIncome.setBounds(0, 25, 75, 25);
        goldIncome.setText("0 +");
        goldIncome.setHorizontalAlignment(SwingConstants.RIGHT);
        goldIncome.setForeground(Color.white);
        resourcesBox.add(goldIncome);

        food = new JLabel();
        food.setBounds(75, 0, 75, 25);
        food.setText("0 F");
        food.setHorizontalAlignment(SwingConstants.RIGHT);
        food.setForeground(Color.white);
        resourcesBox.add(food);

        foodIncome = new JLabel();
        foodIncome.setBounds(75, 25, 75, 25);
        foodIncome.setText("0 +");
        foodIncome.setHorizontalAlignment(SwingConstants.RIGHT);
        foodIncome.setForeground(Color.white);
        resourcesBox.add(foodIncome);

        wood = new JLabel();
        wood.setBounds(150, 0, 75, 25);
        wood.setText("0 W");
        wood.setHorizontalAlignment(SwingConstants.RIGHT);
        wood.setForeground(Color.white);
        resourcesBox.add(wood);

        woodIncome = new JLabel();
        woodIncome.setBounds(150, 25, 75, 25);
        woodIncome.setText("0 +");
        woodIncome.setHorizontalAlignment(SwingConstants.RIGHT);
        woodIncome.setForeground(Color.white);
        resourcesBox.add(woodIncome);

        stone = new JLabel();
        stone.setBounds(225, 0, 75, 25);
        stone.setText("0 S");
        stone.setHorizontalAlignment(SwingConstants.RIGHT);
        stone.setForeground(Color.white);
        resourcesBox.add(stone);

        stoneIncome = new JLabel();
        stoneIncome.setBounds(225, 25, 75, 25);
        stoneIncome.setText("0 +");
        stoneIncome.setHorizontalAlignment(SwingConstants.RIGHT);
        stoneIncome.setForeground(Color.white);
        resourcesBox.add(stoneIncome);
        //endregion


        //region select
        selectBox = new JLayeredPane();
        selectBox.setBounds(763, 188, 225, 300);
        layers.add(selectBox);
        selectBoxBackground = new JPanel();
        selectBoxBackground.setBounds(0, 0, 225, 300);
        selectBoxBackground.setBackground(Color.black);
        selectBox.add(selectBoxBackground);
        selectBox.setLayer(selectBoxBackground, -1, 0);

        select1 = new JLabel();
        select1.setBounds(3, 3, 144, 69);
        select1.setText("Gold Island");
        select1.setHorizontalAlignment(SwingConstants.CENTER);
        select1.setOpaque(true);
        select1.setBackground(Color.gray);
        select1.setForeground(Color.black);
        selectBox.add(select1);
        select1.addMouseListener(this);

        select1Ship = new JLabel();
        select1Ship.setBounds(153, 3, 69, 69);
        select1Ship.setText("Ship");
        select1Ship.setHorizontalAlignment(SwingConstants.CENTER);
        select1Ship.setOpaque(true);
        select1Ship.setBackground(Color.gray);
        select1Ship.setForeground(Color.black);
        selectBox.add(select1Ship);
        select1Ship.addMouseListener(this);

        select2 = new JLabel();
        select2.setBounds(3, 78, 144, 69);
        select2.setText("Food Island");
        select2.setHorizontalAlignment(SwingConstants.CENTER);
        select2.setOpaque(true);
        select2.setBackground(Color.gray);
        select2.setForeground(Color.black);
        selectBox.add(select2);
        select2.addMouseListener(this);

        select2Ship = new JLabel();
        select2Ship.setBounds(153, 78, 69, 69);
        select2Ship.setText("Ship");
        select2Ship.setHorizontalAlignment(SwingConstants.CENTER);
        select2Ship.setOpaque(true);
        select2Ship.setBackground(Color.gray);
        select2Ship.setForeground(Color.black);
        selectBox.add(select2Ship);
        select2Ship.addMouseListener(this);

        select3 = new JLabel();
        select3.setBounds(3, 153, 144, 69);
        select3.setText("Wood Island");
        select3.setHorizontalAlignment(SwingConstants.CENTER);
        select3.setOpaque(true);
        select3.setBackground(Color.gray);
        select3.setForeground(Color.black);
        selectBox.add(select3);
        select3.addMouseListener(this);

        select3Ship = new JLabel();
        select3Ship.setBounds(153, 153, 69, 69);
        select3Ship.setText("Ship");
        select3Ship.setHorizontalAlignment(SwingConstants.CENTER);
        select3Ship.setOpaque(true);
        select3Ship.setBackground(Color.gray);
        select3Ship.setForeground(Color.black);
        selectBox.add(select3Ship);
        select3Ship.addMouseListener(this);

        select4 = new JLabel();
        select4.setBounds(3, 228, 144, 69);
        select4.setText("Stone Island");
        select4.setHorizontalAlignment(SwingConstants.CENTER);
        select4.setOpaque(true);
        select4.setBackground(Color.gray);
        select4.setForeground(Color.black);
        selectBox.add(select4);
        select4.addMouseListener(this);

        select4Ship = new JLabel();
        select4Ship.setBounds(153, 228, 69, 69);
        select4Ship.setText("Ship");
        select4Ship.setHorizontalAlignment(SwingConstants.CENTER);
        select4Ship.setOpaque(true);
        select4Ship.setBackground(Color.gray);
        select4Ship.setForeground(Color.black);
        selectBox.add(select4Ship);
        select4Ship.addMouseListener(this);
        //endregion


        //region grade (upgrade/downgrade)
        gradeBox = new JLayeredPane();
        gradeBox.setBounds(300, 100, 400, 150);
        layers.add(gradeBox);
        layers.setLayer(gradeBox, 1, 0);
        gradeBoxBackground = new JPanel();
        gradeBoxBackground.setBounds(0, 0, 400, 150);
        gradeBoxBackground.setBackground(Color.black);
        gradeBox.add(gradeBoxBackground);
        gradeBox.setLayer(gradeBoxBackground, -1, 0);

        gradePrompt = new JLabel();
        gradePrompt.setBounds(5, 30, 390, 20);
        gradePrompt.setText("GP");
        gradePrompt.setHorizontalAlignment(SwingConstants.LEFT);
        gradePrompt.setForeground(Color.white);
        gradeBox.add(gradePrompt);

        gradeCurrentText = new JLabel();
        gradeCurrentText.setBounds(5, 50, 390, 20);
        gradeCurrentText.setText("GCT");
        gradeCurrentText.setHorizontalAlignment(SwingConstants.LEFT);
        gradeCurrentText.setForeground(Color.white);
        gradeBox.add(gradeCurrentText);

        gradeAfterText = new JLabel();
        gradeAfterText.setBounds(5, 70, 390, 20);
        gradeAfterText.setText("GAT");
        gradeAfterText.setHorizontalAlignment(SwingConstants.LEFT);
        gradeAfterText.setForeground(Color.white);
        gradeBox.add(gradeAfterText);

        gradeValidate = new JLabel();
        gradeValidate.setBounds(203, 128, 194, 19);
        gradeValidate.setText("Validate");
        gradeValidate.setHorizontalAlignment(SwingConstants.LEFT);
        gradeValidate.setOpaque(true);
        gradeValidate.setBackground(Color.gray);
        gradeValidate.setForeground(Color.black);
        gradeBox.add(gradeValidate);
        gradeValidate.addMouseListener(this);

        gradeClose = new JLabel();
        gradeClose.setBounds(380, 0, 20, 20);
        gradeClose.setText("X");
        gradeClose.setHorizontalAlignment(SwingConstants.LEFT);
        gradeClose.setForeground(Color.red);
        gradeBox.add(gradeClose);
        gradeClose.addMouseListener(this);

        gradeBox.setVisible(false);
        //endregion


        //region island
        islandBox = new JLayeredPane();
        islandBox.setBounds(0, 300, 500, 200);
        layers.add(islandBox);
        islandBoxBackground = new JPanel();
        islandBoxBackground.setBounds(0, 0, 500, 200);
        islandBoxBackground.setBackground(Color.black);
        islandBox.add(islandBoxBackground);
        islandBox.setLayer(islandBoxBackground, -1, 0);

        islandName = new JLabel();
        islandName.setBounds(3, 3, 94, 54);
        islandName.setText("Island Name");
        islandName.setHorizontalAlignment(SwingConstants.CENTER);
        islandName.setOpaque(true);
        islandName.setBackground(Color.gray);
        islandName.setForeground(Color.black);
        islandBox.add(islandName);

        islandPeople = new JLabel();
        islandPeople.setBounds(3, 63, 94, 54);
        islandPeople.setText("0 / 0");
        islandPeople.setHorizontalAlignment(SwingConstants.CENTER);
        islandPeople.setOpaque(true);
        islandPeople.setBackground(Color.gray);
        islandPeople.setForeground(Color.black);
        islandBox.add(islandPeople);

        islandP = new JLabel();
        islandP.setBounds(3, 123, 74, 74);
        islandP.setText("C");
        islandP.setHorizontalAlignment(SwingConstants.CENTER);
        islandP.setOpaque(true);
        islandP.setBackground(Color.gray);
        islandP.setForeground(Color.black);
        islandBox.add(islandP);
        islandP.addMouseListener(this);

        islandPUpgrade = new JLabel();
        islandPUpgrade.setBounds(83, 123, 14, 34);
        islandPUpgrade.setText("/\\");
        islandPUpgrade.setHorizontalAlignment(SwingConstants.CENTER);
        islandPUpgrade.setOpaque(true);
        islandPUpgrade.setBackground(Color.gray);
        islandPUpgrade.setForeground(Color.black);
        islandBox.add(islandPUpgrade);
        islandPUpgrade.addMouseListener(this);

        islandPDowngrade = new JLabel();
        islandPDowngrade.setBounds(83, 163, 14, 34);
        islandPDowngrade.setText("\\/");
        islandPDowngrade.setHorizontalAlignment(SwingConstants.CENTER);
        islandPDowngrade.setOpaque(true);
        islandPDowngrade.setBackground(Color.gray);
        islandPDowngrade.setForeground(Color.black);
        islandBox.add(islandPDowngrade);
        islandPDowngrade.addMouseListener(this);

        islandPeopleG = new JLabel();
        islandPeopleG.setBounds(103, 3, 54, 34);
        islandPeopleG.setText("0 / 0");
        islandPeopleG.setHorizontalAlignment(SwingConstants.CENTER);
        islandPeopleG.setOpaque(true);
        islandPeopleG.setBackground(Color.gray);
        islandPeopleG.setForeground(Color.black);
        islandBox.add(islandPeopleG);
        islandPeopleG.addMouseListener(this);

        islandPeopleGUp = new JLabel();
        islandPeopleGUp.setBounds(163, 3, 14, 34);
        islandPeopleGUp.setText("/\\");
        islandPeopleGUp.setHorizontalAlignment(SwingConstants.CENTER);
        islandPeopleGUp.setOpaque(true);
        islandPeopleGUp.setBackground(Color.gray);
        islandPeopleGUp.setForeground(Color.black);
        islandBox.add(islandPeopleGUp);
        islandPeopleGUp.addMouseListener(this);

        islandPeopleGDown = new JLabel();
        islandPeopleGDown.setBounds(183, 3, 14, 34);
        islandPeopleGDown.setText("\\/");
        islandPeopleGDown.setHorizontalAlignment(SwingConstants.CENTER);
        islandPeopleGDown.setOpaque(true);
        islandPeopleGDown.setBackground(Color.gray);
        islandPeopleGDown.setForeground(Color.black);
        islandBox.add(islandPeopleGDown);
        islandPeopleGDown.addMouseListener(this);

        islandG1 = new JLabel();
        islandG1.setBounds(103, 123, 74, 74);
        islandG1.setText("G1");
        islandG1.setHorizontalAlignment(SwingConstants.CENTER);
        islandG1.setOpaque(true);
        islandG1.setBackground(Color.gray);
        islandG1.setForeground(Color.black);
        islandBox.add(islandG1);
        islandG1.addMouseListener(this);

        islandG1Upgrade = new JLabel();
        islandG1Upgrade.setBounds(183, 123, 14, 34);
        islandG1Upgrade.setText("/\\");
        islandG1Upgrade.setHorizontalAlignment(SwingConstants.CENTER);
        islandG1Upgrade.setOpaque(true);
        islandG1Upgrade.setBackground(Color.gray);
        islandG1Upgrade.setForeground(Color.black);
        islandBox.add(islandG1Upgrade);
        islandG1Upgrade.addMouseListener(this);

        islandG1Downgrade = new JLabel();
        islandG1Downgrade.setBounds(183, 163, 14, 34);
        islandG1Downgrade.setText("\\/");
        islandG1Downgrade.setHorizontalAlignment(SwingConstants.CENTER);
        islandG1Downgrade.setOpaque(true);
        islandG1Downgrade.setBackground(Color.gray);
        islandG1Downgrade.setForeground(Color.black);
        islandBox.add(islandG1Downgrade);
        islandG1Downgrade.addMouseListener(this);

        islandG2 = new JLabel();
        islandG2.setBounds(103, 43, 74, 74);
        islandG2.setText("G2");
        islandG2.setHorizontalAlignment(SwingConstants.CENTER);
        islandG2.setOpaque(true);
        islandG2.setBackground(Color.gray);
        islandG2.setForeground(Color.black);
        islandBox.add(islandG2);
        islandG2.addMouseListener(this);

        islandG2Upgrade = new JLabel();
        islandG2Upgrade.setBounds(183, 43, 14, 34);
        islandG2Upgrade.setText("/\\");
        islandG2Upgrade.setHorizontalAlignment(SwingConstants.CENTER);
        islandG2Upgrade.setOpaque(true);
        islandG2Upgrade.setBackground(Color.gray);
        islandG2Upgrade.setForeground(Color.black);
        islandBox.add(islandG2Upgrade);
        islandG2Upgrade.addMouseListener(this);

        islandG2Downgrade = new JLabel();
        islandG2Downgrade.setBounds(183, 83, 14, 34);
        islandG2Downgrade.setText("\\/");
        islandG2Downgrade.setHorizontalAlignment(SwingConstants.CENTER);
        islandG2Downgrade.setOpaque(true);
        islandG2Downgrade.setBackground(Color.gray);
        islandG2Downgrade.setForeground(Color.black);
        islandBox.add(islandG2Downgrade);
        islandG2Downgrade.addMouseListener(this);

        islandPeopleF = new JLabel();
        islandPeopleF.setBounds(203, 3, 54, 34);
        islandPeopleF.setText("0 / 0");
        islandPeopleF.setHorizontalAlignment(SwingConstants.CENTER);
        islandPeopleF.setOpaque(true);
        islandPeopleF.setBackground(Color.gray);
        islandPeopleF.setForeground(Color.black);
        islandBox.add(islandPeopleF);
        islandPeopleF.addMouseListener(this);

        islandPeopleFUp = new JLabel();
        islandPeopleFUp.setBounds(263, 3, 14, 34);
        islandPeopleFUp.setText("/\\");
        islandPeopleFUp.setHorizontalAlignment(SwingConstants.CENTER);
        islandPeopleFUp.setOpaque(true);
        islandPeopleFUp.setBackground(Color.gray);
        islandPeopleFUp.setForeground(Color.black);
        islandBox.add(islandPeopleFUp);
        islandPeopleFUp.addMouseListener(this);

        islandPeopleFDown = new JLabel();
        islandPeopleFDown.setBounds(283, 3, 14, 34);
        islandPeopleFDown.setText("\\/");
        islandPeopleFDown.setHorizontalAlignment(SwingConstants.CENTER);
        islandPeopleFDown.setOpaque(true);
        islandPeopleFDown.setBackground(Color.gray);
        islandPeopleFDown.setForeground(Color.black);
        islandBox.add(islandPeopleFDown);
        islandPeopleFDown.addMouseListener(this);

        islandF1 = new JLabel();
        islandF1.setBounds(203, 123, 74, 74);
        islandF1.setText("F1");
        islandF1.setHorizontalAlignment(SwingConstants.CENTER);
        islandF1.setOpaque(true);
        islandF1.setBackground(Color.gray);
        islandF1.setForeground(Color.black);
        islandBox.add(islandF1);
        islandF1.addMouseListener(this);

        islandF1Upgrade = new JLabel();
        islandF1Upgrade.setBounds(283, 123, 14, 34);
        islandF1Upgrade.setText("/\\");
        islandF1Upgrade.setHorizontalAlignment(SwingConstants.CENTER);
        islandF1Upgrade.setOpaque(true);
        islandF1Upgrade.setBackground(Color.gray);
        islandF1Upgrade.setForeground(Color.black);
        islandBox.add(islandF1Upgrade);
        islandF1Upgrade.addMouseListener(this);

        islandF1Downgrade = new JLabel();
        islandF1Downgrade.setBounds(283, 163, 14, 34);
        islandF1Downgrade.setText("\\/");
        islandF1Downgrade.setHorizontalAlignment(SwingConstants.CENTER);
        islandF1Downgrade.setOpaque(true);
        islandF1Downgrade.setBackground(Color.gray);
        islandF1Downgrade.setForeground(Color.black);
        islandBox.add(islandF1Downgrade);
        islandF1Downgrade.addMouseListener(this);

        islandF2 = new JLabel();
        islandF2.setBounds(203, 43, 74, 74);
        islandF2.setText("F2");
        islandF2.setHorizontalAlignment(SwingConstants.CENTER);
        islandF2.setOpaque(true);
        islandF2.setBackground(Color.gray);
        islandF2.setForeground(Color.black);
        islandBox.add(islandF2);
        islandF2.addMouseListener(this);

        islandF2Upgrade = new JLabel();
        islandF2Upgrade.setBounds(283, 43, 14, 34);
        islandF2Upgrade.setText("/\\");
        islandF2Upgrade.setHorizontalAlignment(SwingConstants.CENTER);
        islandF2Upgrade.setOpaque(true);
        islandF2Upgrade.setBackground(Color.gray);
        islandF2Upgrade.setForeground(Color.black);
        islandBox.add(islandF2Upgrade);
        islandF2Upgrade.addMouseListener(this);

        islandF2Downgrade = new JLabel();
        islandF2Downgrade.setBounds(283, 83, 14, 34);
        islandF2Downgrade.setText("\\/");
        islandF2Downgrade.setHorizontalAlignment(SwingConstants.CENTER);
        islandF2Downgrade.setOpaque(true);
        islandF2Downgrade.setBackground(Color.gray);
        islandF2Downgrade.setForeground(Color.black);
        islandBox.add(islandF2Downgrade);
        islandF2Downgrade.addMouseListener(this);

        islandPeopleW = new JLabel();
        islandPeopleW.setBounds(303, 3, 54, 34);
        islandPeopleW.setText("0 / 0");
        islandPeopleW.setHorizontalAlignment(SwingConstants.CENTER);
        islandPeopleW.setOpaque(true);
        islandPeopleW.setBackground(Color.gray);
        islandPeopleW.setForeground(Color.black);
        islandBox.add(islandPeopleW);
        islandPeopleW.addMouseListener(this);

        islandPeopleWUp = new JLabel();
        islandPeopleWUp.setBounds(363, 3, 14, 34);
        islandPeopleWUp.setText("/\\");
        islandPeopleWUp.setHorizontalAlignment(SwingConstants.CENTER);
        islandPeopleWUp.setOpaque(true);
        islandPeopleWUp.setBackground(Color.gray);
        islandPeopleWUp.setForeground(Color.black);
        islandBox.add(islandPeopleWUp);
        islandPeopleWUp.addMouseListener(this);

        islandPeopleWDown = new JLabel();
        islandPeopleWDown.setBounds(383, 3, 14, 34);
        islandPeopleWDown.setText("\\/");
        islandPeopleWDown.setHorizontalAlignment(SwingConstants.CENTER);
        islandPeopleWDown.setOpaque(true);
        islandPeopleWDown.setBackground(Color.gray);
        islandPeopleWDown.setForeground(Color.black);
        islandBox.add(islandPeopleWDown);
        islandPeopleWDown.addMouseListener(this);

        islandW1 = new JLabel();
        islandW1.setBounds(303, 123, 74, 74);
        islandW1.setText("W1");
        islandW1.setHorizontalAlignment(SwingConstants.CENTER);
        islandW1.setOpaque(true);
        islandW1.setBackground(Color.gray);
        islandW1.setForeground(Color.black);
        islandBox.add(islandW1);
        islandW1.addMouseListener(this);

        islandW1Upgrade = new JLabel();
        islandW1Upgrade.setBounds(383, 123, 14, 34);
        islandW1Upgrade.setText("/\\");
        islandW1Upgrade.setHorizontalAlignment(SwingConstants.CENTER);
        islandW1Upgrade.setOpaque(true);
        islandW1Upgrade.setBackground(Color.gray);
        islandW1Upgrade.setForeground(Color.black);
        islandBox.add(islandW1Upgrade);
        islandW1Upgrade.addMouseListener(this);

        islandW1Downgrade = new JLabel();
        islandW1Downgrade.setBounds(383, 163, 14, 34);
        islandW1Downgrade.setText("\\/");
        islandW1Downgrade.setHorizontalAlignment(SwingConstants.CENTER);
        islandW1Downgrade.setOpaque(true);
        islandW1Downgrade.setBackground(Color.gray);
        islandW1Downgrade.setForeground(Color.black);
        islandBox.add(islandW1Downgrade);
        islandW1Downgrade.addMouseListener(this);

        islandW2 = new JLabel();
        islandW2.setBounds(303, 43, 74, 74);
        islandW2.setText("W2");
        islandW2.setHorizontalAlignment(SwingConstants.CENTER);
        islandW2.setOpaque(true);
        islandW2.setBackground(Color.gray);
        islandW2.setForeground(Color.black);
        islandBox.add(islandW2);
        islandW2.addMouseListener(this);

        islandW2Upgrade = new JLabel();
        islandW2Upgrade.setBounds(383, 43, 14, 34);
        islandW2Upgrade.setText("/\\");
        islandW2Upgrade.setHorizontalAlignment(SwingConstants.CENTER);
        islandW2Upgrade.setOpaque(true);
        islandW2Upgrade.setBackground(Color.gray);
        islandW2Upgrade.setForeground(Color.black);
        islandBox.add(islandW2Upgrade);
        islandW2Upgrade.addMouseListener(this);

        islandW2Downgrade = new JLabel();
        islandW2Downgrade.setBounds(383, 83, 14, 34);
        islandW2Downgrade.setText("\\/");
        islandW2Downgrade.setHorizontalAlignment(SwingConstants.CENTER);
        islandW2Downgrade.setOpaque(true);
        islandW2Downgrade.setBackground(Color.gray);
        islandW2Downgrade.setForeground(Color.black);
        islandBox.add(islandW2Downgrade);
        islandW2Downgrade.addMouseListener(this);

        islandPeopleS = new JLabel();
        islandPeopleS.setBounds(403, 3, 54, 34);
        islandPeopleS.setText("0 / 0");
        islandPeopleS.setHorizontalAlignment(SwingConstants.CENTER);
        islandPeopleS.setOpaque(true);
        islandPeopleS.setBackground(Color.gray);
        islandPeopleS.setForeground(Color.black);
        islandBox.add(islandPeopleS);
        islandPeopleS.addMouseListener(this);

        islandPeopleSUp = new JLabel();
        islandPeopleSUp.setBounds(463, 3, 14, 34);
        islandPeopleSUp.setText("/\\");
        islandPeopleSUp.setHorizontalAlignment(SwingConstants.CENTER);
        islandPeopleSUp.setOpaque(true);
        islandPeopleSUp.setBackground(Color.gray);
        islandPeopleSUp.setForeground(Color.black);
        islandBox.add(islandPeopleSUp);
        islandPeopleSUp.addMouseListener(this);

        islandPeopleSDown = new JLabel();
        islandPeopleSDown.setBounds(483, 3, 14, 34);
        islandPeopleSDown.setText("\\/");
        islandPeopleSDown.setHorizontalAlignment(SwingConstants.CENTER);
        islandPeopleSDown.setOpaque(true);
        islandPeopleSDown.setBackground(Color.gray);
        islandPeopleSDown.setForeground(Color.black);
        islandBox.add(islandPeopleSDown);
        islandPeopleSDown.addMouseListener(this);

        islandS1 = new JLabel();
        islandS1.setBounds(403, 123, 74, 74);
        islandS1.setText("S1");
        islandS1.setHorizontalAlignment(SwingConstants.CENTER);
        islandS1.setOpaque(true);
        islandS1.setBackground(Color.gray);
        islandS1.setForeground(Color.black);
        islandBox.add(islandS1);
        islandS1.addMouseListener(this);

        islandS1Upgrade = new JLabel();
        islandS1Upgrade.setBounds(483, 123, 14, 34);
        islandS1Upgrade.setText("/\\");
        islandS1Upgrade.setHorizontalAlignment(SwingConstants.CENTER);
        islandS1Upgrade.setOpaque(true);
        islandS1Upgrade.setBackground(Color.gray);
        islandS1Upgrade.setForeground(Color.black);
        islandBox.add(islandS1Upgrade);
        islandS1Upgrade.addMouseListener(this);

        islandS1Downgrade = new JLabel();
        islandS1Downgrade.setBounds(483, 163, 14, 34);
        islandS1Downgrade.setText("\\/");
        islandS1Downgrade.setHorizontalAlignment(SwingConstants.CENTER);
        islandS1Downgrade.setOpaque(true);
        islandS1Downgrade.setBackground(Color.gray);
        islandS1Downgrade.setForeground(Color.black);
        islandBox.add(islandS1Downgrade);
        islandS1Downgrade.addMouseListener(this);

        islandS2 = new JLabel();
        islandS2.setBounds(403, 43, 74, 74);
        islandS2.setText("S2");
        islandS2.setHorizontalAlignment(SwingConstants.CENTER);
        islandS2.setOpaque(true);
        islandS2.setBackground(Color.gray);
        islandS2.setForeground(Color.black);
        islandBox.add(islandS2);
        islandS2.addMouseListener(this);

        islandS2Upgrade = new JLabel();
        islandS2Upgrade.setBounds(483, 43, 14, 34);
        islandS2Upgrade.setText("/\\");
        islandS2Upgrade.setHorizontalAlignment(SwingConstants.CENTER);
        islandS2Upgrade.setOpaque(true);
        islandS2Upgrade.setBackground(Color.gray);
        islandS2Upgrade.setForeground(Color.black);
        islandBox.add(islandS2Upgrade);
        islandS2Upgrade.addMouseListener(this);

        islandS2Downgrade = new JLabel();
        islandS2Downgrade.setBounds(483, 83, 14, 34);
        islandS2Downgrade.setText("\\/");
        islandS2Downgrade.setHorizontalAlignment(SwingConstants.CENTER);
        islandS2Downgrade.setOpaque(true);
        islandS2Downgrade.setBackground(Color.gray);
        islandS2Downgrade.setForeground(Color.black);
        islandBox.add(islandS2Downgrade);
        islandS2Downgrade.addMouseListener(this);

        islandBox.setVisible(false);

        islandDrawer = new JLabel();
        islandDrawer.setBounds(500, 300, 20, 200);
        islandDrawer.setText("<>");
        islandDrawer.setHorizontalAlignment(SwingConstants.CENTER);
        islandDrawer.setOpaque(true);
        islandDrawer.setBackground(Color.black);
        islandDrawer.setForeground(Color.white);
        layers.add(islandDrawer);
        islandDrawer.addMouseListener(this);
        islandDrawer.setVisible(false);
        //endregion


        //region event
        eventBox = new JLayeredPane();
        eventBox.setBounds(80, 80, 600, 200);
        layers.add(eventBox);
        layers.setLayer(eventBox, 1, 0);
        eventBoxBackground = new JPanel();
        eventBoxBackground.setBounds(0, 0, 600, 200);
        eventBoxBackground.setBackground(Color.black);
        eventBox.add(eventBoxBackground);
        eventBox.setLayer(eventBoxBackground, -1, 0);

        eventTitle = new JLabel();
        eventTitle.setBounds(10, 0, 500, 20);
        eventTitle.setText("Event Title");
        eventTitle.setHorizontalAlignment(SwingConstants.LEFT);
        eventTitle.setForeground(Color.white);
        eventBox.add(eventTitle);

        eventText1 = new JLabel();
        eventText1.setBounds(3, 23, 590, 20);
        eventText1.setText("Event Text 1");
        eventText1.setHorizontalAlignment(SwingConstants.LEFT);
        eventText1.setForeground(Color.white);
        eventBox.add(eventText1);

        eventText2 = new JLabel();
        eventText2.setBounds(3, 43, 590, 20);
        eventText2.setText("Event Text 2");
        eventText2.setHorizontalAlignment(SwingConstants.LEFT);
        eventText2.setForeground(Color.white);
        eventBox.add(eventText2);

        eventText3 = new JLabel();
        eventText3.setBounds(3, 63, 590, 20);
        eventText3.setText("Event Text 3");
        eventText3.setHorizontalAlignment(SwingConstants.LEFT);
        eventText3.setForeground(Color.white);
        eventBox.add(eventText3);

        eventText4 = new JLabel();
        eventText4.setBounds(3, 83, 590, 20);
        eventText4.setText("Event Text 4");
        eventText4.setHorizontalAlignment(SwingConstants.LEFT);
        eventText4.setForeground(Color.white);
        eventBox.add(eventText4);

        eventClose = new JLabel();
        eventClose.setBounds(580, 0, 20, 20);
        eventClose.setText("X");
        eventClose.setHorizontalAlignment(SwingConstants.LEFT);
        eventClose.setForeground(Color.red);
        eventBox.add(eventClose);
        eventClose.addMouseListener(this);

        eventChoice1Text = new JLabel();
        eventChoice1Text.setBounds(3, 153, 144, 22);
        eventChoice1Text.setText("Event Choice 1 Text");
        eventChoice1Text.setHorizontalAlignment(SwingConstants.CENTER);
        eventChoice1Text.setOpaque(true);
        eventChoice1Text.setBackground(Color.gray);
        eventChoice1Text.setForeground(Color.black);
        eventBox.add(eventChoice1Text);
        eventChoice1Text.addMouseListener(this);

        eventChoice1Resources = new JLabel();
        eventChoice1Resources.setBounds(3, 175, 144, 22);
        eventChoice1Resources.setText("Event Choice 1 Resources");
        eventChoice1Resources.setHorizontalAlignment(SwingConstants.CENTER);
        eventChoice1Resources.setOpaque(true);
        eventChoice1Resources.setBackground(Color.gray);
        eventChoice1Resources.setForeground(Color.black);
        eventBox.add(eventChoice1Resources);
        eventChoice1Resources.addMouseListener(this);

        eventChoice2Text = new JLabel();
        eventChoice2Text.setBounds(153, 153, 144, 22);
        eventChoice2Text.setText("Event Choice 2 Text");
        eventChoice2Text.setHorizontalAlignment(SwingConstants.CENTER);
        eventChoice2Text.setOpaque(true);
        eventChoice2Text.setBackground(Color.gray);
        eventChoice2Text.setForeground(Color.black);
        eventBox.add(eventChoice2Text);
        eventChoice2Text.addMouseListener(this);

        eventChoice2Resources = new JLabel();
        eventChoice2Resources.setBounds(153, 175, 144, 22);
        eventChoice2Resources.setText("Event Choice 2 Resources");
        eventChoice2Resources.setHorizontalAlignment(SwingConstants.CENTER);
        eventChoice2Resources.setOpaque(true);
        eventChoice2Resources.setBackground(Color.gray);
        eventChoice2Resources.setForeground(Color.black);
        eventBox.add(eventChoice2Resources);
        eventChoice2Resources.addMouseListener(this);

        eventChoice3Text = new JLabel();
        eventChoice3Text.setBounds(303, 153, 144, 22);
        eventChoice3Text.setText("Event Choice 3 Text");
        eventChoice3Text.setHorizontalAlignment(SwingConstants.CENTER);
        eventChoice3Text.setOpaque(true);
        eventChoice3Text.setBackground(Color.gray);
        eventChoice3Text.setForeground(Color.black);
        eventBox.add(eventChoice3Text);
        eventChoice3Text.addMouseListener(this);

        eventChoice3Resources = new JLabel();
        eventChoice3Resources.setBounds(303, 175, 144, 22);
        eventChoice3Resources.setText("Event Choice 3 Resources");
        eventChoice3Resources.setHorizontalAlignment(SwingConstants.CENTER);
        eventChoice3Resources.setOpaque(true);
        eventChoice3Resources.setBackground(Color.gray);
        eventChoice3Resources.setForeground(Color.black);
        eventBox.add(eventChoice3Resources);
        eventChoice3Resources.addMouseListener(this);

        eventChoice4Text = new JLabel();
        eventChoice4Text.setBounds(453, 153, 144, 22);
        eventChoice4Text.setText("Event Choice 4 Text");
        eventChoice4Text.setHorizontalAlignment(SwingConstants.CENTER);
        eventChoice4Text.setOpaque(true);
        eventChoice4Text.setBackground(Color.gray);
        eventChoice4Text.setForeground(Color.black);
        eventBox.add(eventChoice4Text);
        eventChoice4Text.addMouseListener(this);

        eventChoice4Resources = new JLabel();
        eventChoice4Resources.setBounds(453, 175, 144, 22);
        eventChoice4Resources.setText("Event Choice 4 Resources");
        eventChoice4Resources.setHorizontalAlignment(SwingConstants.CENTER);
        eventChoice4Resources.setOpaque(true);
        eventChoice4Resources.setBackground(Color.gray);
        eventChoice4Resources.setForeground(Color.black);
        eventBox.add(eventChoice4Resources);
        eventChoice4Resources.addMouseListener(this);

        eventBox.setVisible(false);
        //endregion


        //region buy
        buyBox = new JLayeredPane();
        buyBox.setBounds(684, 50, 310, 130);
        layers.add(buyBox);
        layers.setLayer(buyBox, 1, 0);
        buyBoxBackground = new JPanel();
        buyBoxBackground.setBounds(0, 0, 310, 130);
        buyBoxBackground.setBackground(Color.black);
        buyBox.add(buyBoxBackground);
        buyBox.setLayer(buyBoxBackground, -1, 0);

        buyText1 = new JLabel();
        buyText1.setBounds(3, 23, 306, 20);
        buyText1.setText("buy Text 1");
        buyText1.setHorizontalAlignment(SwingConstants.LEFT);
        buyText1.setForeground(Color.white);
        buyBox.add(buyText1);

        buyText2 = new JLabel();
        buyText2.setBounds(3, 43, 306, 20);
        buyText2.setText("buy Text 2");
        buyText2.setHorizontalAlignment(SwingConstants.LEFT);
        buyText2.setForeground(Color.white);
        buyBox.add(buyText2);

        buyClose = new JLabel();
        buyClose.setBounds(290, 0, 20, 20);
        buyClose.setText("X");
        buyClose.setHorizontalAlignment(SwingConstants.LEFT);
        buyClose.setForeground(Color.red);
        buyBox.add(buyClose);
        buyClose.addMouseListener(this);

        buyValidate = new JLabel();
        buyValidate.setBounds(163, 83, 144, 44);
        buyValidate.setText("Buy for --- G");
        buyValidate.setHorizontalAlignment(SwingConstants.CENTER);
        buyValidate.setOpaque(true);
        buyValidate.setBackground(Color.gray);
        buyValidate.setForeground(Color.black);
        buyBox.add(buyValidate);
        buyValidate.addMouseListener(this);

        buyBox.setVisible(false);
        //endregion
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e)
    {
        if (e.getKeyCode() == 27)
        {
            setPause();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {}


    @Override
    public void mouseClicked(MouseEvent e)
    {
        Component componentClicked = e.getComponent();
        if (componentClicked == pauseResume)
        {
            setPause();
        }
        else if (componentClicked == pauseSave)
        {
            game.saveGame();
        }
        else if (componentClicked == pauseQuit)
        {
            this.dispose();
        }
        else if (componentClicked == turnSkip)
        {
            game.skipTurn();
        }
        else if (componentClicked == popupClose)
        {
            popupBox.setVisible(false);
        }
        else if (componentClicked == islandDrawer)
        {
            if (islandBox.isVisible())
            {
                islandBox.setVisible(false);
                islandDrawer.setBounds(0, 300, 20, 200);
            }
            else
            {
                loadIsland();
            }
        }
        else if (componentClicked == gradeValidate)
        {
            if (gradeMode == -1)
            {
                buildingSelected.downgrade();
                game.resources.add(buildingSelected.getDowngradeRefund());
                gradeBox.setVisible(false);
                game.update();
                loadIsland();
            }
            else if (game.resources.isSuperiorOrEqualTo(buildingSelected.getUpgradeCost()))
            {
                buildingSelected.upgrade();
                game.resources.sub(buildingSelected.getUpgradeCost());
                gradeBox.setVisible(false);
                game.update();
                loadIsland();
            }
            else
            {
                newPopup("Not enough resources !");
            }
        }
        else if (componentClicked == gradeClose)
        {
            gradeBox.setVisible(false);
        }
        else if (componentClicked == buyValidate)
        {
            if (game.resources.gold >= game.buyBase + game.nbIslandsOwned * game.buyExtra)
            {
                game.resources.gold -= game.buyBase + game.nbIslandsOwned * game.buyExtra;
                islandToBuy.isOwned = true;
                ++game.nbIslandsOwned;
                buyBox.setVisible(false);
                game.update();
                islandSelected = islandToBuy;
                loadIsland();
            }
            else
            {
                newPopup("Not enough resources !");
            }
        }
        else if (componentClicked == buyClose)
        {
            buyBox.setVisible(false);
        }

        //region select
        else if (componentClicked == select1)
        {
            if (game.islands[0].isOwned)
            {
                islandSelected = game.islands[0];
                loadIsland();
            }
            else
            {
                islandToBuy = game.islands[0];
                buyIsland();
            }
        }
        else if (componentClicked == select1Ship)
        {
            if (!game.islands[0].isOwned)
            {
                newPopup("You do not own this island.");
            }
            else if (game.ships[0] == null)
            {
                newPopup("You have already done business with this island's ship this month.");
            }
            else
            {
                loadEvent(game.ships[0]);
            }
        }
        else if (componentClicked == select2)
        {
            if (game.islands[1].isOwned)
            {
                islandSelected = game.islands[1];
                loadIsland();
            }
            else
            {
                islandToBuy = game.islands[1];
                buyIsland();
            }
        }
        else if (componentClicked == select2Ship)
        {
            if (!game.islands[1].isOwned)
            {
                newPopup("You do not own this island.");
            }
            else if (game.ships[1] == null)
            {
                newPopup("You have already done business with this island's ship this month.");
            }
            else
            {
                loadEvent(game.ships[1]);
            }
        }
        else if (componentClicked == select3)
        {
            if (game.islands[2].isOwned)
            {
                islandSelected = game.islands[2];
                loadIsland();
            }
            else
            {
                islandToBuy = game.islands[2];
                buyIsland();
            }
        }
        else if (componentClicked == select3Ship)
        {
            if (!game.islands[2].isOwned)
            {
                newPopup("You do not own this island.");
            }
            else if (game.ships[2] == null)
            {
                newPopup("You have already done business with this island's ship this month.");
            }
            else
            {
                loadEvent(game.ships[2]);
            }
        }
        else if (componentClicked == select4)
        {
            if (game.islands[3].isOwned)
            {
                islandSelected = game.islands[3];
                loadIsland();
            }
            else
            {
                islandToBuy = game.islands[3];
                buyIsland();
            }
        }
        else if (componentClicked == select4Ship)
        {
            if (!game.islands[3].isOwned)
            {
                newPopup("You do not own this island.");
            }
            else if (game.ships[3] == null)
            {
                newPopup("You have already done business with this island's ship this month.");
            }
            else
            {
                loadEvent(game.ships[3]);
            }
        }
        //endregion

        //region grade
        else if (componentClicked == islandPUpgrade)
        {
            buildingSelected = islandSelected.p;
            if (buildingSelected.level == 4)
            {
                newPopup("City is already at maximum level (4) !");
            }
            else { loadUpgrade(); }
        }
        else if (componentClicked == islandPDowngrade)
        {
            buildingSelected = islandSelected.p;
            if (buildingSelected.level == 1)
            {
                newPopup("City is already at lowest level (1) !");
            }
            else { loadDowngrade(); }
        }
        else if (componentClicked == islandG1Upgrade)
        {
            buildingSelected = islandSelected.g1;
            if (buildingSelected.level == 4)
            {
                newPopup("Market 1 is already at maximum level (4) !");
            }
            else { loadUpgrade(); }
        }
        else if (componentClicked == islandG1Downgrade)
        {
            buildingSelected = islandSelected.g1;
            if (buildingSelected.level == 0)
            {
                newPopup("Market 1 is already at lowest level (0) !");
            }
            else { loadDowngrade(); }
        }
        else if (componentClicked == islandG2Upgrade)
        {
            buildingSelected = islandSelected.g2;
            if (buildingSelected.level == 4)
            {
                newPopup("Market 2 is already at maximum level (4) !");
            }
            else { loadUpgrade(); }
        }
        else if (componentClicked == islandG2Downgrade)
        {
            buildingSelected = islandSelected.g2;
            if (buildingSelected.level == 0)
            {
                newPopup("Market 2 is already at lowest level (0) !");
            }
            else { loadDowngrade(); }
        }
        else if (componentClicked == islandF1Upgrade)
        {
            buildingSelected = islandSelected.f1;
            if (buildingSelected.level == 4)
            {
                newPopup("Fishing pier 1 is already at maximum level (4) !");
            }
            else { loadUpgrade(); }
        }
        else if (componentClicked == islandF1Downgrade)
        {
            buildingSelected = islandSelected.f1;
            if (buildingSelected.level == 0)
            {
                newPopup("Fishing pier 1 is already at lowest level (0) !");
            }
            else { loadDowngrade(); }
        }
        else if (componentClicked == islandF2Upgrade)
        {
            buildingSelected = islandSelected.f2;
            if (buildingSelected.level == 4)
            {
                newPopup("Fishing pier 2 is already at maximum level (4) !");
            }
            else { loadUpgrade(); }
        }
        else if (componentClicked == islandF2Downgrade)
        {
            buildingSelected = islandSelected.f2;
            if (buildingSelected.level == 0)
            {
                newPopup("Fishing pier 2 is already at lowest level (0) !");
            }
            else { loadDowngrade(); }
        }
        else if (componentClicked == islandW1Upgrade)
        {
            buildingSelected = islandSelected.w1;
            if (buildingSelected.level == 4)
            {
                newPopup("Lumber yard 1 is already at maximum level (4) !");
            }
            else { loadUpgrade(); }
        }
        else if (componentClicked == islandW1Downgrade)
        {
            buildingSelected = islandSelected.w1;
            if (buildingSelected.level == 0)
            {
                newPopup("Lumber yard 1 is already at lowest level (0) !");
            }
            else { loadDowngrade(); }
        }
        else if (componentClicked == islandW2Upgrade)
        {
            buildingSelected = islandSelected.w2;
            if (buildingSelected.level == 4)
            {
                newPopup("Lumber yard 2 is already at maximum level (4) !");
            }
            else { loadUpgrade(); }
        }
        else if (componentClicked == islandW2Downgrade)
        {
            buildingSelected = islandSelected.w2;
            if (buildingSelected.level == 0)
            {
                newPopup("Lumber yard 2 is already at lowest level (0) !");
            }
            else { loadDowngrade(); }
        }
        else if (componentClicked == islandS1Upgrade)
        {
            buildingSelected = islandSelected.s1;
            if (buildingSelected.level == 4)
            {
                newPopup("Stone quarry 1 is already at maximum level (4) !");
            }
            else { loadUpgrade(); }
        }
        else if (componentClicked == islandS1Downgrade)
        {
            buildingSelected = islandSelected.s1;
            if (buildingSelected.level == 0)
            {
                newPopup("Stone quarry 1 is already at lowest level (0) !");
            }
            else { loadDowngrade(); }
        }
        else if (componentClicked == islandS2Upgrade)
        {
            buildingSelected = islandSelected.s2;
            if (buildingSelected.level == 4)
            {
                newPopup("Stone quarry 2 is already at maximum level (4) !");
            }
            else { loadUpgrade(); }
        }
        else if (componentClicked == islandS2Downgrade)
        {
            buildingSelected = islandSelected.s2;
            if (buildingSelected.level == 0)
            {
                newPopup("Stone quarry 2 is already at lowest level (0) !");
            }
            else { loadDowngrade(); }
        }
        //endregion

        //region event
        else if (componentClicked == eventChoice4Text || componentClicked == eventChoice4Resources)
        {
            switch (eventSelected.type)
            {
                case 'S':
                    eventSelected.island.people += eventSelected.resOutcomes[0].people;
                    game.resources.add(eventSelected.resOutcomes[0]);
                    eventBox.setVisible(false);
                    game.ships[eventSelected.island.id] = null;
                    game.update();
                    break;
                case 'L':
                    eventSelected.island.people += eventSelected.resOutcomes[0].people;
                    game.resources.add(eventSelected.resOutcomes[0]);
                    eventBox.setVisible(false);
                    game.turnEvent = null;
                    game.skipTurn();
                    break;
                case 'G':
                    game.resources.add(eventSelected.resOutcomes[0]);
                    eventBox.setVisible(false);
                    if (eventSelected.name.equals("Buying the independence"))
                    {
                        game.hasWon = true;
                        game.turnEvent = null;
                    }
                    else if (!game.taxPaid)
                    {
                        if (!eventSelected.strOutcomes[0].equals("No hope is left"))
                        {
                            game.taxPaid = true;
                            game.turnEvent = null;
                        }
                    }
                    else
                    {
                        game.turnEvent = null;
                    }
                    game.skipTurn();
                    break;
            }
        }
        else if (componentClicked == eventChoice3Text || componentClicked == eventChoice3Resources)
        {
            switch (eventSelected.type)
            {
                case 'S':
                    eventSelected.island.people += eventSelected.resOutcomes[1].people;
                    game.ships[eventSelected.island.id] = null;
                    game.resources.add(eventSelected.resOutcomes[1]);
                    eventBox.setVisible(false);
                    game.update();
                    break;
                case 'L':
                    eventSelected.island.people += eventSelected.resOutcomes[1].people;
                    game.resources.add(eventSelected.resOutcomes[1]);
                    eventBox.setVisible(false);
                    game.turnEvent = null;
                    game.skipTurn();
                    break;
                case 'G':
                    game.resources.add(eventSelected.resOutcomes[1]);
                    eventBox.setVisible(false);
                    game.turnEvent = null;
                    game.skipTurn();
                    break;
            }
        }
        else if (componentClicked == eventChoice2Text || componentClicked == eventChoice2Resources)
        {
            switch (eventSelected.type)
            {
                case 'S':
                    eventSelected.island.people += eventSelected.resOutcomes[2].people;
                    game.ships[eventSelected.island.id] = null;
                    game.resources.add(eventSelected.resOutcomes[2]);
                    eventBox.setVisible(false);
                    game.update();
                    break;
                case 'L':
                    eventSelected.island.people += eventSelected.resOutcomes[2].people;
                    game.resources.add(eventSelected.resOutcomes[2]);
                    eventBox.setVisible(false);
                    game.turnEvent = null;
                    game.skipTurn();
                    break;
                case 'G':
                    game.resources.add(eventSelected.resOutcomes[2]);
                    eventBox.setVisible(false);
                    game.turnEvent = null;
                    game.skipTurn();
                    break;
            }
        }
        else if (componentClicked == eventChoice1Text || componentClicked == eventChoice1Resources)
        {
            switch (eventSelected.type)
            {
                case 'S':
                    eventSelected.island.people += eventSelected.resOutcomes[3].people;
                    game.ships[eventSelected.island.id] = null;
                    game.resources.add(eventSelected.resOutcomes[3]);
                    eventBox.setVisible(false);
                    game.update();
                    break;
                case 'L':
                    eventSelected.island.people += eventSelected.resOutcomes[3].people;
                    game.resources.add(eventSelected.resOutcomes[3]);
                    eventBox.setVisible(false);
                    game.turnEvent = null;
                    game.skipTurn();
                    break;
                case 'G':
                    game.resources.add(eventSelected.resOutcomes[3]);
                    eventBox.setVisible(false);
                    game.turnEvent = null;
                    game.skipTurn();
                    break;
            }
        }
        else if (componentClicked == eventClose)
        {
            eventBox.setVisible(false);
        }
        //endregion

        //region people
        else if (componentClicked == islandPeopleGUp)
        {
            if (islandSelected.employ('G'))
            {
                game.update();
            }
        }
        else if (componentClicked == islandPeopleGDown)
        {
            if (islandSelected.unemploy('G'))
            {
                game.update();
            }
        }
        else if (componentClicked == islandPeopleFUp)
        {
            if (islandSelected.employ('F'))
            {
                game.update();
            }
        }
        else if (componentClicked == islandPeopleFDown)
        {
            if (islandSelected.unemploy('F'))
            {
                game.update();
            }
        }
        else if (componentClicked == islandPeopleWUp)
        {
            if (islandSelected.employ('W'))
            {
                game.update();
            }
        }
        else if (componentClicked == islandPeopleWDown)
        {
            if (islandSelected.unemploy('W'))
            {
                game.update();
            }
        }
        else if (componentClicked == islandPeopleSUp)
        {
            if (islandSelected.employ('S'))
            {
                game.update();
            }
        }
        else if (componentClicked == islandPeopleSDown)
        {
            if (islandSelected.unemploy('S'))
            {
                game.update();
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

    public void loadUpgrade()
    {
        // prepares the pane with all information for upgrading a building and displays it
        gradeMode = 1;
        int level = buildingSelected.level;
        Resources_ rs;

        switch (buildingSelected.type)
        {
            case 'P':
                gradePrompt.setText("Do you want to upgrade this City from level " +
                        level + " to level " + (level + 1) + " ?");
                break;
            case 'G':
                gradePrompt.setText("Do you want to upgrade this Market from level " +
                        level + " to level " + (level + 1) + " ?");
                break;
            case 'F':
                gradePrompt.setText("Do you want to upgrade this Pier from level " +
                        level + " to level " + (level + 1) + " ?");
                break;
            case 'W':
                gradePrompt.setText("Do you want to upgrade this Forest from level " +
                        level + " to level " + (level + 1) + " ?");
                break;
            case 'S':
                gradePrompt.setText("Do you want to upgrade this Quarry from level " +
                        level + " to level " + (level + 1) + " ?");
                break;
        }

        if (buildingSelected.type == 'P')
        {
            gradeCurrentText.setText("Current population space: " + buildingSelected.getPeopleMax() + " P");
        }
        else
        {
            rs = buildingSelected.getIncome();
            gradeCurrentText.setText("Current income: " +
                    rs.gold + " G, " + rs.food + " F, " + rs.wood + " W, " + rs.stone + " S");
        }

        if (buildingSelected.type == 'P')
        {
            gradeAfterText.setText("Future population space: " + buildingSelected.getPeopleMax(level + 1) + " P");
        }
        else
        {
            rs = buildingSelected.getIncome(level + 1);
            gradeAfterText.setText("Future income: " +
                    rs.gold + " G, " + rs.food + " F, " + rs.wood + " W, " + rs.stone + " S");
        }

        rs = buildingSelected.getUpgradeCost();
        gradeValidate.setText(rs.gold + " G, " + rs.food + " F, " + rs.wood + " W, " + rs.stone + " S");

        gradeBox.setVisible(true);
    }
    public void loadDowngrade()
    {
        // prepares the pane with all information for downgrading a building and displays it
        gradeMode = -1;
        int level = buildingSelected.level;
        Resources_ rs;

        switch (buildingSelected.type)
        {
            case 'P':
                gradePrompt.setText("Do you want to downgrade this City from level " +
                        level + " to level " + (level - 1) + " ?");
                break;
            case 'G':
                gradePrompt.setText("Do you want to downgrade this Market from level " +
                        level + " to level " + (level - 1) + " ?");
                break;
            case 'F':
                gradePrompt.setText("Do you want to downgrade this Pier from level " +
                        level + " to level " + (level - 1) + " ?");
                break;
            case 'W':
                gradePrompt.setText("Do you want to downgrade this Forest from level " +
                        level + " to level " + (level - 1) + " ?");
                break;
            case 'S':
                gradePrompt.setText("Do you want to downgrade this Quarry from level " +
                        level + " to level " + (level - 1) + " ?");
                break;
        }

        if (buildingSelected.type == 'P')
        {
            gradeCurrentText.setText("Current population space: " + buildingSelected.getPeopleMax() + " P");
        }
        else
        {
            rs = buildingSelected.getIncome();
            gradeCurrentText.setText("Current income: " +
                    rs.gold + " G, " + rs.food + " F, " + rs.wood + " W, " + rs.stone + " S");
        }

        if (buildingSelected.type == 'P')
        {
            gradeAfterText.setText("Future population space: " + buildingSelected.getPeopleMax(level - 1) + " P");
        }
        else
        {
            rs = buildingSelected.getIncome(level - 1);
            gradeAfterText.setText("Future income: " +
                    rs.gold + " G, " + rs.food + " F, " + rs.wood + " W, " + rs.stone + " S");
        }

        rs = buildingSelected.getDowngradeRefund();
        gradeValidate.setText(rs.gold + " G, " + rs.food + " F, " + rs.wood + " W, " + rs.stone + " S");

        gradeBox.setVisible(true);
    }

    public void loadIsland()
    {
        // prepares the pane with all information for one island and displays it
        islandName.setText(islandSelected.name);
        islandPeople.setText(islandSelected.people + " / " + islandSelected.peopleMax);
        islandP.setText("City LVL " + islandSelected.p.level);

        islandPeopleG.setText(islandSelected.peopleG + " / " + islandSelected.peopleGMax);
        islandG1.setText("Market LVL " + islandSelected.g1.level);
        islandG2.setText("Market LVL " + islandSelected.g2.level);

        islandPeopleF.setText(islandSelected.peopleF + " / " + islandSelected.peopleFMax);
        islandF1.setText("Pier LVL " + islandSelected.f1.level);
        islandF2.setText("Pier LVL " + islandSelected.f2.level);

        islandPeopleW.setText(islandSelected.peopleW + " / " + islandSelected.peopleWMax);
        islandW1.setText("Forest LVL " + islandSelected.w1.level);
        islandW2.setText("Forest LVL " + islandSelected.w2.level);

        islandPeopleS.setText(islandSelected.peopleS + " / " + islandSelected.peopleSMax);
        islandS1.setText("Quarry LVL " + islandSelected.s1.level);
        islandS2.setText("Quarry LVL " + islandSelected.s2.level);

        islandBox.setVisible(true);

        islandDrawer.setBounds(500, 300, 20, 200);
        islandDrawer.setVisible(true);
    }

    public void loadEvent(Event_ event)
    {
        eventSelected = event;
        Resources_ rs;

        if (event.type == 'G') { eventTitle.setText(event.name); }
        else { eventTitle.setText(event.name + " (" + event.island.name + ")"); }

        eventText1.setText(event.description[0]);
        switch (event.description.length)
        {
            case 1:
                eventText2.setVisible(false);
                eventText3.setVisible(false);
                eventText4.setVisible(false);
                break;
            case 2:
                eventText2.setText(event.description[1]);
                eventText2.setVisible(true);
                eventText3.setVisible(false);
                eventText4.setVisible(false);
                break;
            case 3:
                eventText2.setText(event.description[1]);
                eventText2.setVisible(true);
                eventText3.setText(event.description[2]);
                eventText3.setVisible(true);
                eventText4.setVisible(false);
                break;
            case 4:
                eventText2.setText(event.description[1]);
                eventText2.setVisible(true);
                eventText3.setText(event.description[2]);
                eventText3.setVisible(true);
                eventText4.setText(event.description[3]);
                eventText4.setVisible(true);
                break;
        }

        switch (event.resOutcomes.length)
        {
            case 1:
                eventChoice4Text.setText(event.strOutcomes[0]);
                rs = event.resOutcomes[0];
                eventChoice4Resources.setText(rs.people + "P, " + rs.gold + " G, " +
                        rs.food + " F, " + rs.wood + " W, " + rs.stone + " S");
                eventChoice3Text.setVisible(false);
                eventChoice3Resources.setVisible(false);
                eventChoice2Text.setVisible(false);
                eventChoice2Resources.setVisible(false);
                eventChoice1Text.setVisible(false);
                eventChoice1Resources.setVisible(false);
                break;
            case 2:
                eventChoice4Text.setText(event.strOutcomes[0]);
                rs = event.resOutcomes[0];
                eventChoice4Resources.setText(rs.people + "P, " + rs.gold + " G, " +
                        rs.food + " F, " + rs.wood + " W, " + rs.stone + " S");
                eventChoice3Text.setText(event.strOutcomes[1]);
                eventChoice3Text.setVisible(true);
                rs = event.resOutcomes[1];
                eventChoice3Resources.setText(rs.people + "P, " + rs.gold + " G, " +
                        rs.food + " F, " + rs.wood + " W, " + rs.stone + " S");
                eventChoice3Resources.setVisible(true);
                eventChoice2Text.setVisible(false);
                eventChoice2Resources.setVisible(false);
                eventChoice1Text.setVisible(false);
                eventChoice1Resources.setVisible(false);
                break;
            case 3:
                eventChoice4Text.setText(event.strOutcomes[0]);
                rs = event.resOutcomes[0];
                eventChoice4Resources.setText(rs.people + "P, " + rs.gold + " G, " +
                        rs.food + " F, " + rs.wood + " W, " + rs.stone + " S");
                eventChoice3Text.setText(event.strOutcomes[1]);
                eventChoice3Text.setVisible(true);
                rs = event.resOutcomes[1];
                eventChoice3Resources.setText(rs.people + "P, " + rs.gold + " G, " +
                        rs.food + " F, " + rs.wood + " W, " + rs.stone + " S");
                eventChoice3Resources.setVisible(true);
                eventChoice2Text.setText(event.strOutcomes[2]);
                eventChoice2Text.setVisible(true);
                rs = event.resOutcomes[2];
                eventChoice2Resources.setText(rs.people + "P, " + rs.gold + " G, " +
                        rs.food + " F, " + rs.wood + " W, " + rs.stone + " S");
                eventChoice2Resources.setVisible(true);
                eventChoice1Text.setVisible(false);
                eventChoice1Resources.setVisible(false);
                break;
            case 4:
                eventChoice4Text.setText(event.strOutcomes[0]);
                rs = event.resOutcomes[0];
                eventChoice4Resources.setText(rs.people + "P, " + rs.gold + " G, " +
                        rs.food + " F, " + rs.wood + " W, " + rs.stone + " S");
                eventChoice3Text.setText(event.strOutcomes[1]);
                eventChoice3Text.setVisible(true);
                rs = event.resOutcomes[1];
                eventChoice3Resources.setText(rs.people + "P, " + rs.gold + " G, " +
                        rs.food + " F, " + rs.wood + " W, " + rs.stone + " S");
                eventChoice2Text.setText(event.strOutcomes[2]);
                eventChoice2Text.setVisible(true);
                rs = event.resOutcomes[2];
                eventChoice2Resources.setText(rs.people + "P, " + rs.gold + " G, " +
                        rs.food + " F, " + rs.wood + " W, " + rs.stone + " S");
                eventChoice2Resources.setVisible(true);
                eventChoice1Text.setText(event.strOutcomes[3]);
                eventChoice1Text.setVisible(true);
                rs = event.resOutcomes[3];
                eventChoice1Resources.setText(rs.people + "P, " + rs.gold + " G, " +
                        rs.food + " F, " + rs.wood + " W, " + rs.stone + " S");
                eventChoice1Resources.setVisible(true);
                break;
        }

        eventClose.setVisible(event.type == 'S');
        eventBox.setVisible(true);
    }

    public void newPopup(String text)
    {
        int size = text.length() * 7;

        popupBox.setBounds(500 - size / 2, 175, size, 50);
        popupBoxBackground.setBounds(0, 0, size, 50);
        popupClose.setBounds(size - 20, 0, 20, 20);
        popupText.setBounds(3, 20, size - 6, 27);

        popupText.setText(text);
        popupBox.setVisible(true);
    }

    public void setPause()
    {
        isPaused = !isPaused;

        pauseBox.setVisible(isPaused);
        popupBox.setVisible(false);
        turnBox.setVisible(!isPaused);
        resourcesBox.setVisible(!isPaused);
        selectBox.setVisible(!isPaused);
        gradeBox.setVisible(false);
        islandBox.setVisible(false);
        islandDrawer.setBounds(0, 300, 20, 200);
        islandDrawer.setVisible(!isPaused);
        eventBox.setVisible(false);
    }

    public void buyIsland()
    {
        islandToBuy.update();
        buyText1.setText("Do you want to buy the " + islandToBuy.name + " ?");
        buyText2.setText("Its current outcome is of " + islandToBuy.income.gold + " G, " +
                islandToBuy.income.food + " F, " + islandToBuy.income.wood + " W, " + islandToBuy.income.stone + "S.");
        buyValidate.setText("Buy for " + (game.buyBase + game.buyExtra * game.nbIslandsOwned) + " G");
        buyBox.setVisible(true);
    }
}
