import java.util.ArrayList;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        //initial word to test logic
        String word = "pizza";
        Scanner scanner = new Scanner(System.in);

        //array of characters to store "_" to display for the user
        ArrayList<Character> wordState = new ArrayList<>();

        //variable to keep count of the wrong attempts
        int wrongCount = 0;


        //inserting underscores with the lenght of the used word to display for the user
        for(int i = 0; i < word.length(); i++)
        {
            wordState.add('_');
        }

        //debugging print statement
        System.out.println(wordState);



        scanner.close();

    }
}
