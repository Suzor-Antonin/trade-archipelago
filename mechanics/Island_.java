package mechanics;

import buildings.*;
import static shortcuts.Shortcuts_.*;

public class Island_
{
    public String name;
    public int id;
    public boolean isOwned = false;
    public Resources_ income = new Resources_();
    public String specialty1; // 'G', 'F', 'W', 'S'
    public String specialty2; // 'G', 'F', 'W', 'S'

    public int people;
    public int peopleMax;
    public int peopleG;
    public int peopleF;
    public int peopleW;
    public int peopleS;
    public int peopleGMax;
    public int peopleFMax;
    public int peopleWMax;
    public int peopleSMax;

    public Building_ p;
    public Building_ g1;
    public Building_ g2;
    public Building_ f1;
    public Building_ f2;
    public Building_ w1;
    public Building_ w2;
    public Building_ s1;
    public Building_ s2;


    public Island_()
    {
        //
    }

    public void update()
    {
        income.setZero();
        income.add( p.getIncome());
        income.add(g1.getIncome());
        income.add(g2.getIncome());
        income.add(f1.getIncome());
        income.add(f2.getIncome());
        income.add(w1.getIncome());
        income.add(w2.getIncome());
        income.add(s1.getIncome());
        income.add(s2.getIncome());

        peopleMax  = p.getPeopleMax();
        peopleGMax = g1.getPeopleMax() + g2.getPeopleMax();
        peopleFMax = f1.getPeopleMax() + f2.getPeopleMax();
        peopleWMax = w1.getPeopleMax() + w2.getPeopleMax();
        peopleSMax = s1.getPeopleMax() + s2.getPeopleMax();

        while (peopleG + peopleF + peopleW + peopleS > people)
        {
            deleteP(false);
        }

        people = people > peopleMax ? peopleMax : people;
        peopleG = peopleG > peopleGMax ? peopleGMax : peopleG;
        peopleF = peopleF > peopleFMax ? peopleFMax : peopleF;
        peopleW = peopleW > peopleWMax ? peopleWMax : peopleW;
        peopleS = peopleS > peopleSMax ? peopleSMax : peopleS;

        income.gold += peopleG;
        income.food += peopleF * 2;
        income.wood += peopleW;
        income.stone += peopleS;

        switch (specialty1)
        {
            case "G":
                income.gold *= 11;
                income.gold /= 10;
                break;
            case "F":
                income.food *= 11;
                income.food /= 10;
                break;
            case "W":
                income.wood *= 11;
                income.wood /= 10;
                break;
            case "S":
                income.stone *= 11;
                income.stone /= 10;
                break;
        }
        switch (specialty2)
        {
            case "G":
                income.gold *= 11;
                income.gold /= 10;
                break;
            case "F":
                income.food *= 11;
                income.food /= 10;
                break;
            case "W":
                income.wood *= 11;
                income.wood /= 10;
                break;
            case "S":
                income.stone *= 11;
                income.stone /= 10;
                break;
        }

        income.food -= people;
    }

    public boolean employ(char type)
    {
        if (peopleG + peopleF + peopleW + peopleS < people)
        {
            switch (type)
            {
                case 'G':
                    if (peopleG < peopleGMax)
                    {
                        ++peopleG;
                        return true;
                    }
                    return false;
                case 'F':
                    if (peopleF < peopleFMax)
                    {
                        ++peopleF;
                        return true;
                    }
                    return false;
                case 'W':
                    if (peopleW < peopleWMax)
                    {
                        ++peopleW;
                        return true;
                    }
                    return false;
                case 'S':
                    if (peopleS < peopleSMax)
                    {
                        ++peopleS;
                        return true;
                    }
                    return false;
            }
        }
        return false;
    }
    public boolean unemploy(char type)
    {
        switch (type)
        {
            case 'G':
                if (peopleG > 0)
                {
                    --peopleG;
                    return true;
                }
                return false;
            case 'F':
                if (peopleF > 0)
                {
                    --peopleF;
                    return true;
                }
                return false;
            case 'W':
                if (peopleW > 0)
                {
                    --peopleW;
                    return true;
                }
                return false;
            case 'S':
                if (peopleS > 0)
                {
                    --peopleS;
                    return true;
                }
                return false;
        }
        return false;
    }

    public void deleteP(boolean lowFood)
    {
        if (lowFood && employ('F')) {}
        else if (peopleS >= peopleW && peopleS > 0)
        {
            --peopleS;
            if (lowFood)
            {
                if (peopleF < peopleFMax)
                {
                    ++peopleF;
                }
                else
                {
                    --people;
                }
            }
        }
        else if (peopleW > 0)
        {
            --peopleW;
            if (lowFood)
            {
                if (peopleF < peopleFMax)
                {
                    ++peopleF;
                }
                else
                {
                    --people;
                }
            }
        }
        else if (peopleG > 0)
        {
            --peopleG;
            if (lowFood)
            {
                if (peopleF < peopleFMax)
                {
                    ++peopleF;
                }
                else
                {
                    --people;
                }
            }
        }
        else if (!lowFood && peopleF > 0)
        {
            --peopleF;
        }
        else
        {
            --people;
        }
    }
}
