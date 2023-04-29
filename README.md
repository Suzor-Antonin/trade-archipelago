# Trade Archipelago
A Java game about managing islands.

### Why make this game
We were asked to create a project in Java, using Object-Oriented Programming.
I thought this would be a good way to demonstrate my skills:
* Handling multiple objects, nested and/or listed (islands and buildings)
* Creating a User Interface that would be readable despite all the information
* Handle user input, both with the mouse and the keyboard (the `Escape` key should be used)
* Reading and writing data in and out of files, then processing it in the program
* Organising a project by modules, which all call to each other

### What are the rules of the game
The game is a turn-based management game, focusing on 4 resources:
* Gold, used for almost everything
* Food, used to feed your people
* Wood, used to build your islands
* Stone, used to build your islands

Each resource can be gained each turn from the islands you manage.
At first, you will start with one island.
Each island possesses buildings, which produce resources.
Each island also possesses people, which you can ask to work on various resources, if you have built enough buildings.

You can spend resources to upgrade your buildings and buy new islands, which all have their favorite resource.
Each turn, on each of your islands, a trade ship will come, with offers, that you can accept or decline.
Beware, in between your turns may happen random events, at a global or local scale.

#### The goal of the game
The goal of the game is to garner 16,000 Gold to buy your independence, as an administrator, from a kingdom you belong to.
However, every year (every 12 turns), you have to pay a tax to your kingdom. Be careful, it goes up the more islands you have !

#### The difficulty system
The game can be played in 3 difficulties: Easy, Medium, and Hard.
These change the price of the tax and of the islands, the starting resources, and the "second chance" when you can't pay your taxes for the first time.

#### Small details, still a challenge
* The ships and events are determined the turn before they occur, and their random seed is written in the save file.
* When your food income is negative and you choose to end your turn, the people in your islands will first progressively switch jobs to fishermen before dying.
* When you do buy your independence, you do not have to pay the yearly tax ever again.

### The save file system
The save files are simple `.txt` file, which does make them "vulnerable".
The user may tweak them as they please, however, they may become unvalid by doing so, and thus not openable.
If the menu tells you that an error has occurred even though you did not touch them, try modifying the `SAVEFILESPATH` variable in `Main.java`, line 13.
Indeed, the program uses a relative path, so depending on how you run the game, it might be wrong.
