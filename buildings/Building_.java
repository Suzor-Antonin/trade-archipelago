package buildings;

import mechanics.*;

public abstract class Building_
{

    public char type; // 'P', 'G', 'F', 'W', 'S'
    public int id; // 1, 2
    public int level; // 1, 2, 3, 4

    public void upgrade() { ++level; }

    public void downgrade()
    {
        --level;
    }

    public abstract Resources_ getUpgradeCost(int level);
    public abstract Resources_ getUpgradeCost();

    public abstract Resources_ getDowngradeRefund(int level);
    public abstract Resources_ getDowngradeRefund();

    public abstract Resources_ getIncome(int level);
    public abstract Resources_ getIncome();

    public abstract int getPeopleMax(int level);
    public abstract int getPeopleMax();
}
