package com.salahbkd.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.salahbkd.hibernate.entity.Student;

public class HibernateDemo {
    public static void main(String[] args) {
        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try {
            // use the session object to save / retrieve objects / start&commit transactions
            // Hibernate stuff

        } finally {
            factory.close();
        }
    }
}
