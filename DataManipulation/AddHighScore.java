package DataManipulation;

import GameMechanics.GameMechanics;
import entity.Hangman;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class AddHighScore {

    public static void setHighScore() {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Hangman.class)
                .buildSessionFactory();

        try {
            Session session = factory.getCurrentSession();
            Hangman tempScore = new Hangman(GameMechanics.getPlayerName(), GameMechanics.finalScore);

            session.beginTransaction();
            session.save(tempScore);
            session.getTransaction().commit();
            factory.close();

            factory = new Configuration().configure("hibernate.cfg.xml")
                    .addAnnotatedClass(Hangman.class)
                    .buildSessionFactory();

            session = factory.getCurrentSession();
            session.beginTransaction();
            Hangman temporary = session.get(Hangman.class, tempScore.getId());
            System.out.println(temporary);
            session.getTransaction().commit();
            DisplayScore.displayScore();
        } finally {
            factory.close();
        }
    }private static void displayStudents (List <Hangman> highscore) {
        for (Hangman tempscore : highscore) {
            System.out.println(tempscore);
        }
    }
}
