package entity;

import javax.persistence.*;

@Entity
@Table(name = "hangman")
public class Hangman {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "player_name")
    private String playerName;

    @Column(name = "highscore")
    private int highScore;

    public Hangman() {}

    public Hangman(String playerName, int highScore) {
        this.playerName = playerName;
        this.highScore = highScore;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getHighScore() {
        return highScore;
    }

    public void setHighScore(int highScore) {
        this.highScore = highScore;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    @Override
    public String toString() {
        return playerName + " | " + highScore;
    }
}
