
/**
 * Item class that holds info about the item description and its weight
 *
 * @author Tim Mahoney
 * @version 2019-11-9
 */
public class Item
{
    // instance variables 
    private String itemName;
    private String itemDescription;
    private double itemWeight;
    private String magicCookie;

    /**
     * Constructor for objects of class Item
     */
    public Item(String itemName, String itemDescription, double itemWeight)
    {
        // initialise instance variables
        this.itemName = itemName;
        this.itemDescription = itemDescription;
        this.itemWeight = itemWeight;
        this.magicCookie = "Cookies";
    }

    /**
     * Constructor for objects of class Item which sets the instance variables with parameter values
     */
    public Item(String description, double weight)
    {
        // initialise instance variables
        itemDescription = description;
        itemWeight = weight;
    }

    /**
     * Returns a description of the item contained in a room
     * @return A description of the item with its weight
     */
    public String getItemDescription()
    {
        String itemString = "Item Description: ";
        itemString += this.itemDescription +"\n";
        itemString += "Item Weight: "+this.itemWeight;
        itemString = itemString + "\nThis room has cookies";
        return itemString;
    }
}
