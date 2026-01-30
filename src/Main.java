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

        System.out.println("************************");
        System.out.println("Welcome to Java Hangman");
        System.out.println("************************");

        //testing method
        System.out.println(getHangmanArt((6)));


        scanner.close();

    }


    //getHangmanArt method gets and int as parameter and return a string
    //is usde to display the Hangman depending in the # of attemps left
    static String getHangmanArt(int wrongCount)
    {
        return switch(wrongCount)
        {
            case 0 -> """
                      
                      """;
            case 1 -> """
                      0
                      
                      
                      """;

            case 2 -> """
                      0
                      |
                      
                      
                      """;

            case 3 -> """
                       0
                      /|
                      
                      """;

            case 4 -> """
                        0
                       /|\\
                      
                      """;

            case 5 -> """
                       0
                      /|\\
                      /
                      """;

            case 6 -> """
                       0
                      /|\\
                      /\\
                      """;

            default -> "";
        };

    }
}

