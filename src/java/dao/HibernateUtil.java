/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.SessionFactory;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author TAWSBC
 */
public class HibernateUtil {

    private static final SessionFactory sessionFactory;
    
    static {
        try {
            // Create the SessionFactory from standard (hibernate.cfg.xml) 
            // config file.
            
            sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            // Log the exception. 
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}

//import org.hibernate.Session;
//import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
//import org.hibernate.cfg.Configuration;
//import org.hibernate.service.ServiceRegistry;
// 
//public class HibernateUtil {
//    
////    private static final ThreadLocal<Session> threadLocal = new ThreadLocal<Session>();
//    
//    private static org.hibernate.SessionFactory sessionFactory;
//    
//    static {
//        try{
//            
//            Configuration configuration=  new Configuration().configure("hibernate.cfg.xml");
//            StandardServiceRegistryBuilder serviceRegistryBuilder = new StandardServiceRegistryBuilder();
//            serviceRegistryBuilder.applySettings(configuration.getProperties());
//            ServiceRegistry serviceRegistry = serviceRegistryBuilder.build();
//            sessionFactory = configuration.buildSessionFactory(serviceRegistry);        
//            
//        }catch(Exception e){
//            e.printStackTrace();
//        }
//    }
//    
//    private HibernateUtil(){}
//    
////    public static Session getThreadLocalSession() {
////        Session session = (Session) threadLocal.get();
////        
////        if (session == null) {
////         session = sessionFactory.openSession();
////            threadLocal.set(session);
////         }
////        
////        return session;
////     }
//    
//    
////    public static void closeThreadLocalSession() {
////        
////        Session session = (Session) threadLocal.get();
////        threadLocal.set(null);
////        if (session != null) {
////        session.close();        
////        }
////    }
//    
//    public static Session getsession() {
//            return sessionFactory.openSession();
//    }
//    
//    public static void closeSession(Session session) {
//        if (session != null) {
//            session.close();
//        }
//    }
//}
