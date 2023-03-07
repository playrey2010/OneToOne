package com.example.hibernate.demo;

import com.example.hibernate.demo.entity.Instructor;
import com.example.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteDemo {
    public static void main(String[] args) {

        // create session factory

        SessionFactory factory = new Configuration()
                .configure("/hibernate.cfg.xml").
                addAnnotatedClass(Instructor.class).
                addAnnotatedClass(InstructorDetail.class).
                buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try {


            // start a transaction
            session.beginTransaction();

            // get instructor with primary key
            int primaryKey = 2;
            Instructor instructor = session.get(Instructor.class, primaryKey);

            System.out.println("Found instructor: " + instructor);

            // delete the instructor
            if (instructor != null) {
                System.out.println("Deleting: " + instructor);
                session.delete(instructor);
            }


            // commit transaction
            session.getTransaction().commit();
        } finally {
            factory.close();
        }

    }
}
