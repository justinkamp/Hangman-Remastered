package Body;

import BackGround.Background;
import DataManipulation.AddHighScore;
import GameMechanics.GameMechanics;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Body {

    private static String firstLine = "", secondLine = "", thirdLine = "", forthLine = "", fifthLine = "", sixthLine = "";


    public static void setLine(int line) throws IOException {
        firstLine = Files.readAllLines(Paths.get("C:\\Users\\justi\\Projects\\Hangman Remastered\\src\\Body\\body.txt")).get(line);
        secondLine = Files.readAllLines(Paths.get("C:\\Users\\justi\\Projects\\Hangman Remastered\\src\\Body\\body.txt")).get(line + 1);
        thirdLine = Files.readAllLines(Paths.get("C:\\Users\\justi\\Projects\\Hangman Remastered\\src\\Body\\body.txt")).get(line + 2);
        forthLine = Files.readAllLines(Paths.get("C:\\Users\\justi\\Projects\\Hangman Remastered\\src\\Body\\body.txt")).get(line + 3);
        fifthLine = Files.readAllLines(Paths.get("C:\\Users\\justi\\Projects\\Hangman Remastered\\src\\Body\\body.txt")).get(line + 4);
        sixthLine = Files.readAllLines(Paths.get("C:\\Users\\justi\\Projects\\Hangman Remastered\\src\\Body\\body.txt")).get(line + 5);

    }

    public static void Board(int count) {
        try {
            if (count <= 6) {
                setLine(count * 6);
                System.out.println(firstLine + "\n" + secondLine + "\n" + thirdLine + "\n" + forthLine + "\n" + fifthLine + "\n" + sixthLine);
                System.out.println("Guessed Letters: " + Background.missedGuesses + "\n" + Background.getGuessSoFar());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void endGame() throws IOException {
        try {
            if (Background.getGuessSoFar().equals(GameMechanics.getWordToBeGuessed())) {
                GameMechanics.count += 6;
                String HighScore = GameMechanics.getPlayerName() + ": " + GameMechanics.finalScore;
                Files.write(Paths.get("C:\\Users\\justi\\Projects\\Hangman Remastered\\src\\Body\\TopScore.txt"), "\n".getBytes(), StandardOpenOption.APPEND);
                Files.write(Paths.get("C:\\Users\\justi\\Projects\\Hangman Remastered\\src\\Body\\TopScore.txt"), HighScore.getBytes(), StandardOpenOption.APPEND);
                System.out.println(Files.readAllLines(Paths.get("C:\\Users\\justi\\Projects\\Hangman Remastered\\src\\Body\\TopScore.txt")));
            } else if (!Background.getGuessSoFar().equals(GameMechanics.getWordToBeGuessed()) && GameMechanics.count >= 6) {
                System.out.println("Guessed Letters: " + Background.missedGuesses + "\n" + "Game Over: Sorry but the word was " + GameMechanics.getWordToBeGuessed());
            }
            AddHighScore.setHighScore();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
