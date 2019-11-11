import java.util.Set;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Class Room - a room in an adventure game.
 *
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 *
 * A "Room" represents one location in the scenery of the game.  It is 
 * connected to other rooms via exits.  For each existing exit, the room 
 * stores a reference to the neighboring room.
 * 
 * @author  Tim Mahoney
 * @version 2019.11.9
 */

public class Room extends Item 
{
    // stores name of the room
    private String description;
    // stores exits of this room
    private HashMap<String, Room> exits; 
    // holds collection of item objects present in the room
    private ArrayList<Item> roomItems;
    private Item roomItem;

    /**
     * Create a room described "description". Initially, it has
     * no exits. "description" is something like "a kitchen" or
     * "an open court yard".
     * @param description The room's description.
     */
    public Room(String description) 
    {
        this.description = description;
        exits = new HashMap<String, Room>();
        roomItems = new ArrayList<Item>();
    }

    /**
     * Get the ArrayList of the items added to the current room
     */
    public ArrayList<Item> getRoomItems()
    {
        // put your code here
        return roomItems;
    }

    /**
     * Define an exit from this room.
     * @param direction The direction of the exit.
     * @param neighbor  The room to which the exit leads.
     */
    public void setExit(String direction, Room neighbor) 
    {
        exits.put(direction, neighbor);
    }

    /**
     * @return The short description of the room
     * (the one that was defined in the constructor).
     */
    public String getShortDescription()
    {
        return description;
    }

    /**
     * Return a description of the room in the form:
     *     You are in the kitchen.
     *     Exits: north west
     * @return A long description of this room
     */
    public String getLongDescription()
    {
        return "You are " + description + ".\n" + getExitString();
    }

    /**
     * Return a string describing the room's exits, for example
     * "Exits: north west".
     * @return Details of the room's exits.
     */
    private String getExitString()
    {
        String returnString = "Exits:";
        Set<String> keys = exits.keySet();
        for(String exit : keys) {
            returnString += " " + exit;
        }
        return returnString;
    }

    /**
     * Return a string for items present in the room
     **/
    public String getItemsInRoom()
    {
        // put your code here
        String returnItems = "Items in the room are: \n";
        {
            returnItems += item.getItemDescription()+"\n";
        }
        return returnItems;
    }

    /**
     * Add name of items and description of item and its weight to its corresponding room
     * @param item_name Specifies the name of the item
     * @param description specifies description of item
     * @param weight holds the weight of the item
     */
    public void addItem(Item item)
    {
        // put your code here
        roomItems.add(item);
    }

    /**
     * Get the item object if the itemName is found in the list of items present in the room
     */
    public Item getItem(String itemName)
    {
        // loop the list of the items in the room
        for (int i = 0; i < roomItems.size(); i++)
        {
        // condition to check the itemName matched with any of the items from the list that are present in the room
        if (roomItems.get(i).getItemName().equalsIgnoreCase(itemName))
        {
            // if matched return the Item object present at index i
            return roomItems.get(i);
        }
    }
    // otherwise return null
    return null;
    }
   
    // To remove an item from the list of which the user has picked up
    public void removeItem(Item item)
    {
        // loop the list of the items in the room
        for (int i = 0; i < roomItems.size(); i++)
        {
            // item matches with any of the item in the room then remove the item from list and break loop
            if (roomItems.get(i) == item)
            {
                roomItems.remove(item);
                break;
            }
        }
    }

    /**
     * Return the room that is reached if we go from this room in direction
     * "direction". If there is no room in that direction, return null.
     * @param direction The exit's direction.
     * @return The room in the given direction.
     */
    public Room getExit(String direction) 
    {
        return exits.get(direction);
    }
}

