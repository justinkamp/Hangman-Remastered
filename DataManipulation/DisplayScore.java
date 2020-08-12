package DataManipulation;

import entity.Hangman;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class DisplayScore {

    public static void displayScore() {

        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Hangman.class)
                .buildSessionFactory();

        try (factory) {
            Session session = factory.getCurrentSession();
            session.beginTransaction();
            List<Hangman> highscore = session.createQuery("from Hangman").getResultList();
            displayStudents(highscore);
            session.getTransaction().commit();
        }
    }   private static void displayStudents (List <Hangman> highscore) {
        System.out.print("Player | Score\n");
        System.out.print("-----------------\n");
                for (Hangman tempscore : highscore) {
                    System.out.println(tempscore);
                }
            }
        }
