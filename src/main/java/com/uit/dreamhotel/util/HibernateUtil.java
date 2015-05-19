package com.uit.dreamhotel.util;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.uit.dreamhotel.model.room;


public class HibernateUtil {
 
    //XML based configuration
    private static SessionFactory sessionFactory;
     
    //Annotation based configuration
    private static SessionFactory sessionAnnotationFactory;
     
    //Property based configuration
    private static SessionFactory sessionJavaConfigFactory;
 
    private static SessionFactory buildSessionFactory() {
        try {
            // Create the SessionFactory from hibernate.cfg.xml
            Configuration configuration = new Configuration();
            configuration.configure("Hibernate/Spring-Hibernate.cfg.xml");
            System.out.println("Hibernate Configuration loaded");
             
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
            System.out.println("Hibernate serviceRegistry created");
             
            SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
             
            return sessionFactory;
        }
        catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
 
    private static SessionFactory buildSessionAnnotationFactory() {
        try {
            // Create the SessionFactory from hibernate.cfg.xml
            Configuration configuration = new Configuration();
            configuration.configure("Hibernate/Spring-Hibernate-Annotation.cfg.xml");
            System.out.println("Hibernate Annotation Configuration loaded");
            configuration.addAnnotatedClass(room.class);
            //configuration.addAnnotatedClass(Lesson.class);
            //configuration.addAnnotatedClass(Level.class);
            //configuration.addAnnotatedClass(Question.class);
            //configuration.addAnnotatedClass(HomeWork.class);
            //configuration.addAnnotatedClass(Alphabets.class);
            //configuration.addAnnotatedClass(Exam.class);
            //configuration.addAnnotatedClass(Grammar.class);
            //configuration.addAnnotatedClass(Kaiwa.class);
            //configuration.addAnnotatedClass(Kanji.class);
            //configuration.addAnnotatedClass(Student.class);
            //configuration.addAnnotatedClass(Test.class);
            //configuration.addAnnotatedClass(Vocabulary.class);
            //configuration.addAnnotatedClass(Homeworkmark.class);
            //configuration.addAnnotatedClass(Example.class);
            //configuration.addAnnotatedClass(HomeSlide.class);
            //configuration.addAnnotatedClass(Game.class);
            //configuration.addAnnotatedClass(ItVocabulary.class);
            //configuration.addAnnotatedClass(ItExample.class);
            //configuration.addAnnotatedClass(Examdetail.class);
            //configuration.addAnnotatedClass(JapaneseComunication.class);
            //configuration.addAnnotatedClass(JapaneseTheme.class);
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
            System.out.println("Hibernate Annotation serviceRegistry created");
             
            SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
             
            return sessionFactory;
        }
        catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
 
    private static SessionFactory buildSessionJavaConfigFactory() {
        try {
        Configuration configuration = new Configuration();
         
        //Create Properties, can be read from property files too
        Properties props = new Properties();
        props.put("hibernate.connection.characterEncoding", "UTF-8");
        props.put("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
        props.put("hibernate.connection.url", "jdbc:mysql://localhost:3306/dreamhotel");
        props.put("hibernate.connection.username", "root");
        props.put("hibernate.connection.password", "");
        props.put("hibernate.current_session_context_class", "thread");
         
        configuration.setProperties(props);
         
        //we can set mapping file or class with annotation
        //addClass(Employee1.class) will look for resource
        // com/journaldev/hibernate/model/Employee1.hbm.xml (not good)
        //configuration.addAnnotatedClass(Employee1.class);
         
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        System.out.println("Hibernate Java Config serviceRegistry created");
         
        SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
         
        return sessionFactory;
        }
        catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
     
    public static SessionFactory getSessionFactory() {
        if(sessionFactory == null) sessionFactory = buildSessionFactory();
        return sessionFactory;
    }
     
    public static SessionFactory getSessionAnnotationFactory() {
        if(sessionAnnotationFactory == null) sessionAnnotationFactory = buildSessionAnnotationFactory();
        return sessionAnnotationFactory;
    }
     
    public static SessionFactory getSessionJavaConfigFactory() {
        if(sessionJavaConfigFactory == null) sessionJavaConfigFactory = buildSessionJavaConfigFactory();
        return sessionJavaConfigFactory;
    }
     
}
