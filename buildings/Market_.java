package buildings;

import mechanics.*;

public class Market_ extends Building_
{
    public Market_(int id, int level)
    {
        this.type = 'G';
        this.id = id;
        this.level = level;
    }

    @Override
    public Resources_ getUpgradeCost(int level)
    {
        switch (level)
        {
            case 0:
                return new Resources_(100, 0, 25, 25);
            case 1:
                return new Resources_(150, 0, 50, 50);
            case 2:
                return new Resources_(200, 0, 80, 80);
            case 3:
                return new Resources_(300, 0, 130, 130);
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
                return new Resources_(5, 0, 0, 0);
            case 2:
                return new Resources_(10, 0, 0, 0);
            case 3:
                return new Resources_(15, 0, 0, 0);
            case 4:
                return new Resources_(20, 0, 0, 0);
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
                return 10;
            case 2:
                return 20;
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
