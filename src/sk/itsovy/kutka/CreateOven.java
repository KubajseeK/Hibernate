package sk.itsovy.kutka;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import sk.itsovy.kutka.entity.Cake;
import sk.itsovy.kutka.entity.Oven;

public class CreateOven {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Cake.class)
                .addAnnotatedClass(Oven.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            Oven oven1 = new Oven(100, "stone");
            Oven oven2 = new Oven(50, "iron");

            session.beginTransaction();

            session.save(oven1);
            session.save(oven2);


            session.getTransaction().commit();
        }
        finally {
            session.close();
            factory.close();
        }
    }
}
