package buildings;

import mechanics.*;

public class City_ extends Building_
{
    public City_(int level)
    {
        this.type = 'P';
        this.id = 1;
        this.level = level;
    }

    @Override
    public Resources_ getUpgradeCost(int level)
    {
        switch (level)
        {
            case 0:
                return new Resources_(0, 0, 0, 10);
            case 1:
                return new Resources_(20, 0, 0, 200);
            case 2:
                return new Resources_(50, 0, 0, 300);
            case 3:
                return new Resources_(100, 0, 0, 400);
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
    public Resources_ getIncome(int level) { return new Resources_(); }
    public Resources_ getIncome() { return this.getIncome(this.level); }

    @Override
    public int getPeopleMax(int level)
    {
        switch (level)
        {
            case 1:
                return 80;
            case 2:
                return 150;
            case 3:
                return 250;
            case 4:
                return 400;
            default:
                return 0;
        }
    }
    public int getPeopleMax() { return this.getPeopleMax(this.level); }
}
