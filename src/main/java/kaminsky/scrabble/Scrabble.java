package kaminsky.scrabble;

import java.util.*;
import java.io.*;

/**
 * Class to determine if words on a Scrabble board exist in a dictionary
 */
public class Scrabble
{
    private final ArrayList<String> dictionary;

    public Scrabble(String filename)
    {
        this.dictionary = readFile(filename);
    }

    /**
     *
     * @return dictionary
     */
    public ArrayList<String> getDictionary()
    {
        return dictionary;
    }

    /**
     *
     * @param filename of a file containing a dictionary
     * @return a sorted ArrayList of all the words in the dictionary
     */
    private ArrayList<String> readFile(String filename)
    {
        ArrayList<String> dictionary = new ArrayList<>();
        File file = new File(filename);
        try
        {
            Scanner readFile = new Scanner(file);
            while (readFile.hasNextLine())
            {
                String word = readFile.next();
                readFile.nextLine();
                dictionary.add(word.toUpperCase());
            }
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
        Collections.sort(dictionary);
        return dictionary;
    }

    /**
     *
     * @param word to search the dictionary for
     * @return true if the word exists in the dictionary
     * and false if it does not
     */
    public boolean search(String word)
    {
        String[] dictArray = dictionary.toArray(new String[0]);
        return Arrays.binarySearch(dictArray, word.toUpperCase()) > 0;
    }
}
