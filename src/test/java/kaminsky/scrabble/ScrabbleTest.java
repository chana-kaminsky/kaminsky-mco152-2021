package kaminsky.scrabble;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileNotFoundException;

public class ScrabbleTest {
    @Test
    public void searchTrueUpper() throws FileNotFoundException
    {
        //given
        //the dictionary file must be in the project folder for the test to pass
        String filename = "dictionary.txt";
        //if the test passes, it means that the readFile method works,
        //because it's called in the constructor when the board is created
        Scrabble dictionary = new Scrabble(filename);

        //when
        boolean isInDictionary = dictionary.search("MANGO");

        //then
        Assert.assertTrue(isInDictionary);
    }

    @Test
    public void searchTrueLower() throws FileNotFoundException
    {
        //given
        String filename = "dictionary.txt";
        Scrabble dictionary = new Scrabble(filename);

        //when
        boolean isInDictionary = dictionary.search("strawberry");

        //then
        Assert.assertTrue(isInDictionary);
    }

    @Test
    public void searchFalseUpper() throws FileNotFoundException
    {
        //given
        String filename = "dictionary.txt";
        Scrabble dictionary = new Scrabble(filename);

        //when
        boolean isInDictionary = dictionary.search("ASDFGHJKL");

        //then
        Assert.assertFalse(isInDictionary);
    }

    @Test
    public void searchFalseLower() throws FileNotFoundException
    {
        //given
        String filename = "dictionary.txt";
        Scrabble dictionary = new Scrabble(filename);

        //when
        boolean isInDictionary = dictionary.search("foo");

        //then
        Assert.assertFalse(isInDictionary);
    }

    @Test
    public void searchFalseNumeric() throws FileNotFoundException
    {
        //given
        String filename = "dictionary.txt";
        Scrabble dictionary = new Scrabble(filename);

        //when
        boolean isInDictionary = dictionary.search("1234");

        //then
        Assert.assertFalse(isInDictionary);
    }

    @Test
    public void getDefinitionOfWord()
    {
        //given
        String filename = "dictionary.txt";
        Scrabble dictionary = new Scrabble(filename);

        //when

        //then
        Assert.assertEquals("<pinecone=n> [n]", dictionary.getDefinition("pinecones"));
    }

    @Test
    public void getDefinitionNoWord()
    {
        //given
        String filename = "dictionary.txt";
        Scrabble dictionary = new Scrabble(filename);

        //when

        //then
        Assert.assertEquals("", dictionary.getDefinition("abcd"));
    }

}
