


/**
 *  This class is the main class of the "World of Zuul" application. 
 *  "World of Zuul" is a very simple, text based adventure game.  Users 
 *  can walk around some scenery. That's all. It should really be extended 
 *  to make it more interesting!
 * 
 *  To play this game, create an instance of this class and call the "play"
 *  method.
 * 
 *  This main class creates and initialises all the others: it creates all
 *  rooms, creates the parser and starts the game.  It also evaluates and
 *  executes the commands that the parser returns.
 * 
 * @author  Tim Mahoney
 * @version 2019.11.9
 */

public class Game extends Player 
{
    private Parser parser;
    private Room currentRoom;
    private Room roomStack[];
    private int top;
    private Player player;
    private Scanner reader;
    private int counter = 0;
    private Room chargeRoom;
        
    /**
     * Create the game and initialise its internal map.
     */
    public Game() 
    {
        createRooms();
        parser = new Parser();
        player = new Player();
        reader = new Scanner(System.in);
        roomStack = new Room[500];
        top=-1;
    }

    /**
     * createPlayer method to get the info about the player
     */
    private void createPlayer()
    {
        // put your code here
        System.out.println("Enter player Name: ");
        String name = reader.nextLine();
        player.setPlayerName(name);
        createRooms();
        System.out.println("Enter maximum weight player can carry");
        int weight = reader.nextInt();
        player.setMaximumWeight(weight);
    }

    /**
     * Create all the rooms and link their exits together.
     */
    private void createRooms()
    {
        // Room outside, theater, pub, lab, office, math, bathroom, cafe, study, library, gym, recroom, choir, gallery, quiet;
      
        // create the item objects
        
        Item outsideItems[] = { new Item("Nothing", 0),
            new Item("Bushes", 200),
            new Item("Benches", 1500) };
            
            Item theaterItem[] = { new Item("Stage", 250),
                new Item("Chair", 250),
                new Item("Concessions", 10) };
                
                Item pubItem[] = { new Item("Bar", 200),
                    new Item("Pretzels", 20),
                    new Item("Darts", 100) };
                    
                    Item labItem[] = { new Item("Microscope", 100),
                        new Item("Frog", 50),
                        new Item("Beeker", 50) };
                        
                        Item officeItem[] = { new Item("Pen", 10),
                            new Item("Pencil", 10),
                            new Item("Paper", 10) };
                            
                            Item mathItem[] = { new Item("Scantron", 50),
                                new Item("Calculator", 20),
                                new Item("Notebook", 20) };
                                
                                Item bathroom[] = { new Item("Sink", 20),
                                    new Item("Soap", 10),
                                    new Item("Dryer", 10) };
                                    
                                    Item cafe[] = { new Item("Table", 50),
                                        new Item("Pizza", 30),
                                        new Item("Napkin", 10) };
                                        
                                        Item study[] = { new Item("Couch", 20),
                                            new Item("Magazine", 20),
                                            new Item("Glasses", 10) };
                                            
                                            Item library[] = { new Item("Dictionary", 20),
                                            new Item("Thesaurus", 20),
                                            new Item("Computer", 20) };
                                            
                                            Item gym[] = { new Item("Jumprope", 30),
                                                new Item("Barbells", 30),
                                                new Item("Bench", 20) };
                                                
                                                Item recroom[] = { new Item("Pool Table", 20),
                                                    new Item("Arcade", 20),
                                                    new Item("Pingpong", 20) };
                                                    
                                                    Item choir[] = { new Item("Clarinet", 10),
                                                        new Item("Saxophone", 20),
                                                        new Item("Tuba", 20) };
                                                        
                                                        Item gallery[] = { new Item("Sculpture", 20),
                                                            new Item("Models", 10),
                                                            new Item("Glass", 20) };
                                                            
                                                            Item quiet[] = { new Item("Loveseat", 20),
                                                                new Item("Table", 20),
                                                                new Item("Novel", 30) };
                                                      
        
        /* outside = addItemsToRoom(outside, outsideItems);
        theater = addItemsToRoom(theater, theaterItems);
        pub = addItemsToRoom(pub, pubItems);
        lab = addItemsToRoom(lab, labItems);
        office = addItemsToRoom(office, officeItems);
        math = addItemsToRoom(math, mathItems);
        bathroom = addItemsToRoom(bathroom, bathroomItems);
        cafe = addItemsToRoom(cafe, cafeItems);
        study = addItemsToRoom(study, studyItems);
        library = addItemsToRoom(library, libraryItems);
        gym = addItemsToRoom(gym, gymItems);
        recroom = addItemsToRoom(recroom, recroomItems);
        choir = addItemsToRoom(choir, choirItems);
        gallery = addItemsToRoom(gallery, galleryItems);
        quiet = addItemsToRoom(quiet, quietItems); */
        
        
        // declare the Item reference variables
        
        /* outside_Item = new Item("Bench: To sit, to relax", 0);
        theater_Item = new Item("Stage: To enjoy a play", 250);
        pub_Item = new Item("Beer: To drink of course!", 200);
        lab_Item = new Item("Microscope: To do sciencey things", 150);
        office_Item = new Item("Desk: To get work done", 100);
        math_Item = new Item("Test: algebra sucks!", 50);
        bathroom_Item = new Item("Toilet: to do business", 75);
        cafe_Item = new Item("Coffee: coffee coffee coffee", 100);
        study_Item = new Item("Chair: to study of course, duh", 150);
        library_Item = new Item("Books: to get my learn on", 100);
        gym_Item = new Item("Weights: to get swole", 100);
        recroom_Item = new Item("Foosball: for fun", 150);
        choir_Item = new Item("Music: for singing", 75);
        gallery_Item = new Item("Paintings: to admire", 100);
        quiet_Item = new Item("Homework: to quietly finish", 150); */
        
         outside = new Room("outside the main entrance of the university");
        theater = new Room("in a lecture theater");
        pub = new Room("in the campus pub");
        lab = new Room("in a computing lab");
        office = new Room("in the computing admin office");
        math = new Room("algebra sucks");
        bathroom = new Room("making big business");
        cafe = new Room("eating stuff");
        study = new Room("studying obviously, duh");
        library = new Room("gettin my learn on");
        gym = new Room("gettin swole brah");
        recroom = new Room("playing games");
        choir = new Room("singing");
        gallery = new Room("art and stuff");
        quiet = new Room("a place for quiet time"); 
        
        // initialise room exits
        outside.setExit("east", theater);
        outside.setExit("south", lab);
        outside.setExit("west", pub);

        theater.setExit("west", outside);

        pub.setExit("east", outside);

        lab.setExit("north", outside);
        lab.setExit("east", office);

        office.setExit("west", lab);
        
        math.setExit("north", office);
        bathroom.setExit("north", pub);
        cafe.setExit("south", pub);
        study.setExit("north", math);
        library.setExit("west", study);
        gym.setExit("south", outside);
        recroom.setExit("east", study);
        choir.setExit("south", theater);
        gallery.setExit("north", library);
        quiet.setExit("north", study);

        // currentRoom = outside;  // start game outside
        // start game outside
        player.setCurrentRoom(outside);
        
        prevRoom = null;
    }

    /**
     *  Main play routine.  Loops until end of play.
     */
    public void play() 
    {            
          // call the createPlayer() method in
         createPlayer();
        
        printWelcome();

        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the game is over.
                
        boolean finished = false;
        while (! finished) {
            if(counter > 10)
            {
                System.out.println("Sorry, your time is over");
                finished = true;
            }
            else
            {
            
            Command command = parser.getCommand();
            finished = processCommand(command);
            counter++;
        }
        System.out.println("Thank you for playing.  Good bye.");
    }

    /**
     * Print out the opening message for the player.
     */
    private void printWelcome()
    {
        System.out.println();
        System.out.println("Welcome to the World of Zuul!");
        System.out.println("World of Zuul is a new, incredibly boring adventure game.");
        System.out.println("Type '" + CommandWord.HELP + "' if you need help.");
        System.out.println();
        createPlayer();
        System.out.println("Hello player " + player.getPlayerName() + "!\n");
        System.out.println(player.getPlayerDescription());
        System.out.println(currentRoom.getLongDescription());
    }

    /**
     * Given a command, process (that is: execute) the command.
     * @param command The command to be processed.
     * @return true If the command ends the game, false otherwise.
     */
    private boolean processCommand(Command command) 
    {
        boolean wantToQuit = false;

        if (command.isUnknown())
        {
            System.out.println("I don't know what you mean...");
            return false;
        }
        String commandWord = command.getCommandWord();
        if (commandWord.equals("help"))
        printHelp();
        else if (commandWord.equals("go"))
        goRoom(command);
        else if (commandWord.equals("quit"))
        wantToQuit = quit(command);
        else if (commandWord.equals("look"))
        look();
        else if (commandWord.equals("eat"))
        System.out.println("You have eaten and are no longer hungry");
        else if (commandWord.equals("back"))
        // if command is true, call the backroom() method
        backRoom();
        else if (commandWord.equals("take"))
        // if condition is true, call the pickUpItemFromRoom() method
        pickUpItemFromRoom(command);
        else if (commandWord.equals("drop"))
       // ability to drop item using dropItemInHand() method
         dropItemInHand(command);
        else if (commandWord.equals("items"))
        player.printItem();
        // if commandWord is eatcokie then it call the eatCookie() method 
        else if (commandWord.equals("eatcookie"))
        player.eatcookie();
        else if (commandWord.equals("charge"))
        chargeBeamer();
        else if (commandWord.equals("fire"))
        fireBeamer();
        // else command not recognized
        return wantToQuit;
    }

    /**
     * charges the beamer
     */
    private void fireBeamer()
    {
        // put your code here
        System.out.println("Beamer is fired");
        currentRoom = chargeRoom;
        if(currentRoom != null)
        {
            String itemArr[] = new String[2];
            itemArr = currentRoomgetItem[2];
            player.setItem(itemArr);
            itemArr = currentRoom.getItem();
        }
    }

    /**
     * Method that accepts a command to let the player pick up an item from the current room
     */
    private void pickUpItemFromRoom(command command)
    {
        // check whether a second word exists in the command
        if (!command.hasSecondWork())
        {
            // if there is no second word we don't know what name is specified
            System.out.println("There is no item specified...");
            return;
        }
        // get second word
        String itemName = command.getSecondWord();
        
        // call the pickUpItem() method by passing the itemName by player object
        player.pickUpItem(itemName);
    }

    /** Method that accepts a command to let the player drop an item
     *  in the current room
     */
    private void dropItemInHand(Command command)
    {
        // check if there is a second word in the command
        if (!command.hasSecondWord())
        {
            // if there is no second word, we don't know what to drop
            System.out.println("There is no item specified...");
            return;
        }
        // get the second word
        String itemName = command.getSecondWord();
        // call the dropItem() method by passin the itemName by player object
        player.dropItem(itemName);
    }
    


    /**
     * Prints the current room description with any possible exits.
     */
    private void look()
    {
        // put your code here
        System.out.println(currentRoom.getLongDescription());
    }

    // implementations of user commands:

    /**
     * Print out some help information.
     * Here we print some stupid, cryptic message and a list of the 
     * command words.
     */
    private void printHelp() 
    {
        System.out.println("You are lost. You are alone. You wander");
        System.out.println("around at the university.");
        System.out.println();
        System.out.println("Your command words are:");
        parser.showCommands();
    }

    /**
     * Add the array of items to the room and return the room object
     */
    private Room addItemsToRoom(Room room, Item items[])
    {
        // put your code here
        for (int i = 0; i < items.length; i++)
        {
            room.addItem(items[i]);
        }
        return room;
    }

    /** 
     * Try to go in one direction. If there is an exit, enter the new
     * room, otherwise print an error message.
     */
    private void goRoom(Command command) 
    {
        if(!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            System.out.println("Go where?");
            return;
        }

        String direction = command.getSecondWord();

        // Try to leave current room.
        Room nextRoom = player.getPlayersExit(direction);

        if (nextRoom == null) {
            System.out.println("There is no door!");
        }
        else {
            // by using player object set the next entering room of player by calling setPlayersEnteringRoom()
            player.setPlayersEnteringRoom(nextroom);
            System.out.println(currentRoom.getPlayerDescription());
        }
    }

    /**
     * Adds current room to the stack
     */
    private void push(Room room)
    {
        // put your code here
        if(top == roomStack.length-1)
        System.out.println("Room stack is full");
        else
        roomStack[++top] = room;
    }

    /**
     * Deletes the room at the top of the stack
     * @return Room if exists, otherwise return null
     */
    private Room pop()
    {
        // put your code here
        if(top < 0)
        {
            System.out.println("Sorry, You are outside and there is no previous room to go to.");
            return null;
        }
        else
        return roomStack[top--];
    }

    
    private void backRoom()
    {
        // call the movePlayerToPreviousRoom() method by using player object
        player.movePlayerToPreviousRoom();
       
    }

    /** 
     * "Quit" was entered. Check the rest of the command to see
     * whether we really quit the game.
     * @return true, if this command quits the game, false otherwise.
     */
    private boolean quit(Command command) 
    {
        if(command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        }
        else {
            return true;  // signal that we want to quit
        }
    }
}
