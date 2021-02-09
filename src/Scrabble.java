import java.util.*;
import java.io.*;

/**
 * Class to determine if words on a Scrabble board exist in a dictionary
 */
public class Scrabble
{
    private final ArrayList<String> dictionary;
    private final ArrayList<String> words;

    public Scrabble(String filename)
    {
        this.words = new ArrayList<>();
        this.dictionary = readFile(filename);
    }

    /**
     *
     * @return words
     */
    public ArrayList<String> getWords()
    {
        return words;
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
                dictionary.add(word);
            }
        }
        catch (Exception exception)
        {
            System.out.println(exception);
        }
        Collections.sort(dictionary);
        return dictionary;
    }

    /**
     *
     * @param word that is added to the board if it exists in the dictionary
     * @return true if the word exists and is successfully added to the board,
     * and false if the word does not exist
     */
    public boolean search(String word)
    {
        Object[] dictArray = dictionary.toArray();
        int binarySearch = Arrays.binarySearch(dictArray, word.toUpperCase());
        if (binarySearch > 0)
        {
            words.add(word);
        }
        else
        {
            return false;
        }
        return true;
    }
}
