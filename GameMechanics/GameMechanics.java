package GameMechanics;

import BackGround.Background;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class GameMechanics {

    public static Scanner input = new Scanner(System.in);
    public static int finalScore = 6000, count = 0;
    private static String playerName = "", guessedWord;
    private static ArrayList<String> wordToBeGuessed = new ArrayList<>();

    //Setting the player's name
    public static void setPlayerName() throws IOException {
        try {
            System.out.print("Enter player name: ");
            playerName = input.nextLine();
            setWordToBeGuessed();
            Background.setGuessSoFar();
            do {
                Background.setGuess();
                //Body.Board(count);
            } while (count < 6);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public static String getPlayerName() {return playerName;}

    //Setting the word to guess
    public static void setWordToBeGuessed() {
        try {
            int randomGuess = (int)(Math.random() * 10);
            wordToBeGuessed.add("corruption");
            wordToBeGuessed.add("possession");
            wordToBeGuessed.add("nomination");
            wordToBeGuessed.add("accessible");
            wordToBeGuessed.add("conclusion");
            wordToBeGuessed.add("discipline");
            wordToBeGuessed.add("commission");
            wordToBeGuessed.add("relaxation");
            wordToBeGuessed.add("brilliance");
            wordToBeGuessed.add("instrument");
            guessedWord = wordToBeGuessed.get(randomGuess);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public static String getWordToBeGuessed() {return guessedWord;}
}
