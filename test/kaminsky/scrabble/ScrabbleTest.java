package kaminsky.scrabble;
import org.junit.Assert;
import org.junit.Test;

public class ScrabbleTest
{
    @Test
    public void search()
    {
        //given
        //the dictionary file must be in the project folder for the test to pass
        String filename = "dictionary.txt";
        //if the test passes, it means that the readFile method works,
        //because it's called in the constructor when the board is created
        Scrabble board = new Scrabble(filename);

        //when
        String[] realWords = {"strawberry", "mango", "blueberry", "apple"};
        for (String word : realWords)
        {
            //then
            Assert.assertTrue(board.search(word));
        }

        //when
        String[] fakeWords = {"foo", "adfghjkl", "555", "lmnop"};
        for (String word : fakeWords)
        {
            //then
            Assert.assertFalse(board.search(word));
        }
    }
}
