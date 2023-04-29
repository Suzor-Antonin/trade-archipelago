package buildings;

import mechanics.*;

public class Pier_ extends Building_
{
    public Pier_(int id, int level)
    {
        this.type = 'F';
        this.id = id;
        this.level = level;
    }

    @Override
    public Resources_ getUpgradeCost(int level)
    {
        switch (level)
        {
            case 0:
                return new Resources_(25, 0, 50, 0);
            case 1:
                return new Resources_(50, 0, 50, 0);
            case 2:
                return new Resources_(65, 0, 70, 0);
            case 3:
                return new Resources_(80, 0, 100, 0);
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
                return new Resources_(1, 20, 0, 0);
            case 2:
                return new Resources_(2, 25, 0, 0);
            case 3:
                return new Resources_(3, 35, 0, 0);
            case 4:
                return new Resources_(5, 50, 0, 0);
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
                return 30;
            case 2:
                return 35;
            case 3:
                return 40;
            case 4:
                return 60;
            default:
                return 0;
        }
    }
    public int getPeopleMax() { return this.getPeopleMax(this.level); }
}
