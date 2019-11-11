/**
 * Representations for all the valid command words for the game
 * along with a string in a particular language.
 * 
 * @author  Tim Mahoney
 * @version 2019.11.9
 */
public enum CommandWord
{
    // A value for each command word along with its
    // corresponding user interface string.
    GO("go"), QUIT("quit"), HELP("help"), UNKNOWN("?"), LOOK("look"), ITEM("item"), EAT("eat"), DROP("drop"), BACK("back"), TAKE("take"), ITEMS("items"), EATCOOKIE("eatcookie"), CHARGE("charge"), FIRE("fire");
    
    // The command string.
    private String commandString;
    
    /**
     * Initialise with the corresponding command string.
     * @param commandString The command string.
     */
    CommandWord(String commandString)
    {
        this.commandString = commandString;
    }
    
    /**
     * @return The command word as a string.
     */
    public String toString()
    {
        return commandString;
    }
}
