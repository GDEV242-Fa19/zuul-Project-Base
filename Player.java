import java.util.*;
/**
 *Player class that holds the players' name, current room, max weight the player can carry, & previous room info
 */
public class Player extends Room
{
    // instance variables - to hold player's name
    private String playerName;
    // to hold player's currentRoom
    private Room currentRoom;
    // to hold player's max carry weight
    private int maximumWeight;
    // to store the player's visited rooms
    private Stack<Room> roomStack;

    /**
     * Constructor for objects of class Player
     */
    public Player()
    {
        // initialise instance variables
        playerName = "";
        currentRoom = null;
        maximumWeight = 10000;
        roomStack = new Stack<Room>();
    }

     /* Picks up item in the current room and prints the message "Item Carried"
     */
    public int maxWeight = 0;
    public void pickUpItem()
    {
        // put your code here
        if((maxWeight + weight) < 2000)
        {
            this.itemCarry[i] = itemName;
            System.out.println("Item Carried : " + itemCarry[i]);
            i++;
            maxWeight += weight;
        }
        System.out.println("You can not carry this item ");
    }
    
    /**
     * Prints the items carried by a player
     */
    public void printItem()
    {
        // put your code here
        System.out.println("You contain the following item\n");
        for(int j = 0; j < i; j++)
        {
            System.out.println(" " + (j+1) + " " + itemCarry[j]);
        }
        System.out.println("\nTotal Weight : " + maxWeight);
    }


    /**
     * Drops the item which is carried and prints the message "Item Dropped"
     */
    public void dropItem()
    {
        // put your code here
        if(i <= 0)
        {
            System.out.println("No more items to drop");
        }
        else
        {
            --i;
            System.out.println("Item Dropped : " +itemCarry[i]);
            this.itemCarry[i] = null;
        }
    }

    /**
     * Constructor
     */
    public void setPlayerName(String pName)
    {
        // put your code here
        this.playerName = pName;
    }
    
    public void setCurrentRoom(room currRoom)
    {
        this.currentRoom = currRoom;
    }

    /**
     * Eat the cookie in the current room
     **/
    public void eatCookie()
    {
        // put your code here
        if((maxWeight + weight) < 2000)
        {
            System.out.println("Eats Magic Cookie");
            maxWeight += 5;
        }
        else
        {
            System.out.println("You cna not eat magic cookie ");
        }
    }

    public void setMaximumWeight(int maxWeight)
{
    this.maximumWeight = maxWeight;
}

public int getMaximumWeight()
{
    return maximumWeight;
}

// to get the player's description
public String getPlayerDescription()
{
    String result = "Player "+playerName+": \n";
    result += currentRoom.getLongDescription();
    return result;
}

// to get the exit room object
public Room getPlayersExit(String direction)
{
    return currentRoom.getExit(direction);
}

// set the players current entering room
public void setPlayersEnteringRoom(Room nextRoom)
{
    // update stack with currentRoom
    roomStack.push(currentRoom);
    currentRoom = nextRoom;
}
    
// to display the player's enterin the previous room info
public void movePlayerToPreviousRoom()
{
    if(roomStack.empty())
    {
        System.out.println("Sorry, You are outside and there are no previous rooms to go to");
    }
    else
    {
        currentRoom = roomStack.pop();
        System.out.println("Player "+playerName+": ");
        if (itemInHand != null)
        {
            System.out.println("You are carrying a/an " + itemInHand.getItemName()+ item in hand "\n\n");
        }
        System.out.println(currentRoom.getLongdescription());
    }
}
}

        

