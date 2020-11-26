package sk.itsovy.kutka;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import sk.itsovy.kutka.entity.Cake;
import sk.itsovy.kutka.entity.Oven;

public class CreateCake {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Cake.class)
                .addAnnotatedClass(Oven.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {

            session.beginTransaction();

            int id = 1;
            Oven oven = session.get(Oven.class, id);

            Cake cake1 = new Cake("Fruity");
            Cake cake2 = new Cake("Banana");
            Cake cake3 = new Cake("Choco Dream");

            oven.add(cake1);
            oven.add(cake2);
            oven.add(cake3);

            session.save(cake1);
            session.save(cake2);
            session.save(cake3);


            session.getTransaction().commit();
        } finally {
            session.close();
            factory.close();
        }
    }
}
