package Main;

import GameMechanics.GameMechanics;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        try {
            GameMechanics.setPlayerName();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
