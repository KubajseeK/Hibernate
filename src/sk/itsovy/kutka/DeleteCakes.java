package sk.itsovy.kutka;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import sk.itsovy.kutka.entity.Cake;
import sk.itsovy.kutka.entity.Oven;

public class DeleteCakes {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Cake.class)
                .addAnnotatedClass(Oven.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {

            session.beginTransaction();

            int id = 2;
            Cake cake = session.get(Cake.class, id);

            System.out.println("Deleting: " + cake);
            session.delete(cake);


            session.getTransaction().commit();
        } finally {
            session.close();
            factory.close();
        }
    }
}
