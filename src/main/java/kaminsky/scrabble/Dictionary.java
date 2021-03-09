package kaminsky.scrabble;

import java.util.*;
import java.io.*;

/**
 * Class to determine if words on a Scrabble board exist in a dictionary
 */
public class Dictionary
{
    private Map<String, String> wordsToDefinitions = new HashMap<>();

    public Dictionary(String filename)
    {
        this.wordsToDefinitions = readFile(filename);
    }

    public Map<String, String> getWordsToDefinitions() {
        return wordsToDefinitions;
    }

    /**
     *
     * @param filename of a file containing a dictionary
     * @return a sorted ArrayList of all the words in the dictionary
     */
    private Map<String, String> readFile(String filename)
    {
        File file = new File(filename);
        try
        {
            Scanner readFile = new Scanner(file);
            while (readFile.hasNextLine())
            {
                wordsToDefinitions.put(
                        readFile.next(), //key
                        readFile.nextLine().trim()//value
                );
            }
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
        return wordsToDefinitions;
    }

    /**
     *
     * @param word to search the dictionary for
     * @return true if the word exists in the dictionary
     * and false if it does not
     */
    public boolean search(String word)
    {
        return wordsToDefinitions.containsKey(word.toUpperCase());
    }

    public String getDefinition(String word)
    {
        String definition = wordsToDefinitions.get(word.toUpperCase());
        return definition == null ? "" : definition;
    }

    public int size()
    {
        return wordsToDefinitions.size();
    }
}
