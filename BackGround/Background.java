package BackGround;

import Body.Body;
import GameMechanics.GameMechanics;
import java.util.Arrays;
import java.util.HashSet;

public class Background {

    private static String guessSoFar = "", guessToDisplay = "";
    private static char guess;
    public static HashSet<Character> missedGuesses = new HashSet<>();

    public static void setGuessSoFar() {guessSoFar = new String(new char[GameMechanics.getWordToBeGuessed().length()]).replace("\0", "_");}

    public static String getGuessSoFar() {return guessSoFar;}


    public static void setGuess() {
        try {
            System.out.print("\nEnter a letter: ");
            guess = GameMechanics.input.nextLine().toLowerCase().charAt(0);
            missedGuesses.add(guess);
            Arrays.stream(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}).forEach(Background::setDisplayedGuess);
            Body.Board(GameMechanics.count);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void setDisplayedGuess(int x) {
        String tempGuess = getGuessSoFar();
        try {
            if (guess == (GameMechanics.getWordToBeGuessed().charAt(x))) {
                guessToDisplay += guess;
            } else if (tempGuess.charAt(x) != '_') {
                guessToDisplay += GameMechanics.getWordToBeGuessed().charAt(x);
            } else if (tempGuess.charAt(x) == '_') {
                guessToDisplay += "_";
            }

            if (x == 9) {
                if (tempGuess.equals(guessToDisplay)) {
                    GameMechanics.count++;
                    GameMechanics.finalScore -= 1000;
                }
                guessSoFar = guessToDisplay;
                if (guessSoFar.equals(GameMechanics.getWordToBeGuessed())) {
                    Body.Board(GameMechanics.count);
                    GameMechanics.count = 10;
                    Body.endGame();
                } else if (GameMechanics.count >= 6) {
                    Body.Board(GameMechanics.count);
                    GameMechanics.count = 10;
                    Body.endGame();

                }
                guessToDisplay = "";
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
