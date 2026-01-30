import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        //file path for wordbank
        String filePath = "src/words.txt";
        ArrayList<String> words  = new ArrayList<>();

        try(BufferedReader reader = new BufferedReader(new FileReader(filePath)))
        {
            String line;
            while((line = reader.readLine()) != null)
            {
                words.add(line.trim());
            }

        }
        catch(FileNotFoundException e)
        {
            System.out.println(filePath + " File not found");
        }
        catch(IOException e)
        {
            System.out.println("Something went wrong");
        }

        Random random = new Random();
        String word = words.get(random.nextInt(words.size()));

        //initial word to test logic
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

        //Setting up memnu
        System.out.println("************************");
        System.out.println("Welcome to Java Hangman");
        System.out.print("************************");

        //main game loop
        while(wrongCount < 6)
        {
            //displaying hangman 'art'
            System.out.print(getHangmanArt(wrongCount));


            System.out.print("Word: ");
            for(char c : wordState )
            {
                System.out.print(c + " ");
            }
            System.out.println();

            //getting user info
            System.out.print("Guess a letter: ");
            char guess = scanner.next().toLowerCase().charAt(0);


            //verifying if guess is part of the word
            if(word.indexOf(guess) >= 0)
            {
                System.out.println("Correct guess");

                for(int i = 0; i < word.length(); i++)
                {
                    if(word.charAt(i) == guess)
                    {
                        wordState.set(i, guess);
                    }
                }

                if(!wordState.contains('_'))
                {
                    System.out.print(getHangmanArt(wrongCount));
                    System.out.println("YOU WIN!!!");
                    System.out.println("The word was: " + word);
                    break;
                }
            }
            else
            {
                wrongCount++;
                System.out.println("Wrong guess");
            }
        }

        if(wrongCount >= 6)
        {
            System.out.println(getHangmanArt(6));
            System.out.println("GAME OVER");
            System.out.println("The word was: " + word);
        }

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

