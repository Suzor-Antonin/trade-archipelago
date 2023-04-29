package buildings;

import mechanics.*;

public class Quarry_ extends Building_
{
    public Quarry_(int id, int level)
    {
        this.type = 'S';
        this.id = id;
        this.level = level;
    }

    @Override
    public Resources_ getUpgradeCost(int level)
    {
        switch (level)
        {
            case 0:
                return new Resources_(50, 0, 0, 100);
            case 1:
                return new Resources_(55, 0, 40, 100);
            case 2:
                return new Resources_(60, 0, 50, 150);
            case 3:
                return new Resources_(80, 0, 75, 250);
            default:
                return new Resources_();
        }
    }
    public Resources_ getUpgradeCost() { return this.getUpgradeCost(this.level); }

    @Override
    public Resources_ getDowngradeRefund(int level)
    {
        switch (level)
        {
            case 1:
                return new Resources_(15, 0, 0, 0);
            case 2:
                return new Resources_(30, 0, 0, 0);
            case 3:
                return new Resources_(45, 0, 0, 0);
            case 4:
                return new Resources_(60, 0, 0, 0);
            default:
                return new Resources_();
        }
    }
    public Resources_ getDowngradeRefund() { return this.getDowngradeRefund(this.level); }

    @Override
    public Resources_ getIncome(int level)
    {
        switch (level)
        {
            case 1:
                return new Resources_(2, 0, 0, 30);
            case 2:
                return new Resources_(4, 0, 0, 40);
            case 3:
                return new Resources_(6, 0, 0, 50);
            case 4:
                return new Resources_(10, 0, 0, 75);
            default:
                return new Resources_();
        }
    }
    public Resources_ getIncome() { return this.getIncome(this.level); }

    @Override
    public int getPeopleMax(int level)
    {
        switch (level)
        {
            case 1:
                return 20;
            case 2:
                return 25;
            case 3:
                return 30;
            case 4:
                return 40;
            default:
                return 0;
        }
    }
    public int getPeopleMax() { return this.getPeopleMax(this.level); }
}
