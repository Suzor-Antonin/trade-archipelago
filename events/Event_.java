package events;

import mechanics.*;
import static shortcuts.Shortcuts_.*;
public class Event_
{
    //public Game_ game;
    public Island_ island;
    public String name;
    public String[] description;
    public char type; // 'G', 'L', 'S'
    public Resources_[] resOutcomes;
    public String[] strOutcomes;

    public Event_(String name, String[] description,  char type, Resources_[] resOutcomes, String[] strOutcomes)
    {
        if (resOutcomes.length != strOutcomes.length)
        {
            prl("Event_ '" + name + "': 'resOutcomes' and 'strOutcomes' are of different lengths!");
        }
        this.name = name;
        this.description = description;
        this.type = type;
        this.resOutcomes = resOutcomes;
        this.strOutcomes = strOutcomes;
    }
}
