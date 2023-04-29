package mechanics;

public class Resources_
{
    // Used to store information about resources.
    public int people = 0;
    public int gold = 0;
    public int food = 0;
    public int wood = 0;
    public int stone = 0;

    public Resources_() {}

    public Resources_(int gold, int food, int wood, int stone)
    {
        this.gold = gold;
        this.food = food;
        this.wood = wood;
        this.stone = stone;
    }

    public Resources_(int people, int gold, int food, int wood, int stone)
    {
        this.people = people;
        this.gold = gold;
        this.food = food;
        this.wood = wood;
        this.stone = stone;
    }

    public void add(Resources_ resources)
    {
        this.gold += resources.gold;
        this.food += resources.food;
        this.wood += resources.wood;
        this.stone += resources.stone;
    }
    public Resources_ addn(Resources_ resources)
    {
        return new Resources_(this.gold + resources.gold,
                this.food + resources.food,
                this.wood + resources.wood,
                this.stone + resources.stone);
    }
    public void addp(Resources_ resources)
    {
        this.people += resources.people;
        this.gold += resources.gold;
        this.food += resources.food;
        this.wood += resources.wood;
        this.stone += resources.stone;
    }
    public Resources_ addnp(Resources_ resources)
    {
        return new Resources_(this.people + resources.people,
                this.gold + resources.gold,
                this.food + resources.food,
                this.wood + resources.wood,
                this.stone + resources.stone);
    }

    public void sub(Resources_ resources)
    {
        this.gold -= resources.gold;
        this.food -= resources.food;
        this.wood -= resources.wood;
        this.stone -= resources.stone;
    }
    public Resources_ subn(Resources_ resources)
    {
        return new Resources_(this.gold - resources.gold,
                this.food - resources.food,
                this.wood - resources.wood,
                this.stone - resources.stone);
    }
    public void subp(Resources_ resources)
    {
        this.people -= resources.people;
        this.gold -= resources.gold;
        this.food -= resources.food;
        this.wood -= resources.wood;
        this.stone -= resources.stone;
    }
    public Resources_ subnp(Resources_ resources)
    {
        return new Resources_(this.people - resources.people,
                this.gold - resources.gold,
                this.food - resources.food,
                this.wood - resources.wood,
                this.stone - resources.stone);
    }

    public void minus()
    {
        this.people = -this.people;
        this.gold = -this.gold;
        this.food = -this.food;
        this.wood = -this.wood;
        this.stone = -this.stone;
    }
    public Resources_ minusn()
    {
        return new Resources_(-this.people,
                -this.gold,
                -this.food,
                -this.wood,
                -this.stone);
    }

    public boolean isSuperiorTo(Resources_ resources)
    {
        return this.gold > resources.gold &&
                this.food > resources.food &&
                this.wood > resources.wood &&
                this.stone > resources.stone;
    }
    public boolean isEqualTo(Resources_ resources)
    {
        return this.gold == resources.gold &&
                this.food == resources.food &&
                this.wood == resources.wood &&
                this.stone == resources.stone;
    }
    public boolean isSuperiorOrEqualTo(Resources_ resources)
    {
        return this.gold >= resources.gold &&
                this.food >= resources.food &&
                this.wood >= resources.wood &&
                this.stone >= resources.stone;
    }
    public boolean isSuperiorToP(Resources_ resources)
    {
        return this.people > resources.people &&
                this.gold > resources.gold &&
                this.food > resources.food &&
                this.wood > resources.wood &&
                this.stone > resources.stone;
    }
    public boolean isEqualToP(Resources_ resources)
    {
        return this.people == resources.people &&
                this.gold == resources.gold &&
                this.food == resources.food &&
                this.wood == resources.wood &&
                this.stone == resources.stone;
    }
    public boolean isSuperiorOrEqualToP(Resources_ resources)
    {
        return this.people >= resources.people &&
                this.gold >= resources.gold &&
                this.food >= resources.food &&
                this.wood >= resources.wood &&
                this.stone >= resources.stone;
    }

    public void setZero()
    {
        this.people = 0;
        this.gold = 0;
        this.food = 0;
        this.wood = 0;
        this.stone = 0;
    }
}
