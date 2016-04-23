package model.database;

import interceptors.Hibernate;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.AvailableSettings;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;



class HibernateUtil {

    private static final Logger logger = Logger.getLogger(HibernateUtil.class);
    private static SessionFactory sessionFactory = null;

    //==========================================================================
    static {
        try {

        Configuration configuration = new Configuration();
        configuration.setInterceptor(new Hibernate());
        configuration.setProperty(AvailableSettings.ORDER_UPDATES, "true");                    
        configuration.configure();
        StandardServiceRegistryBuilder serviceRegistryBuilder;
        ServiceRegistry serviceRegistry;

        serviceRegistryBuilder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
        serviceRegistry = serviceRegistryBuilder.build();
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);

        } catch (Exception e) {
            try {
                logger.error("HibernateUtil", e);
                throw e;
            } catch (Exception ex) {
                logger.error("HibernateUtil", e);
            }
        }
        
    } 

    //==========================================================================
    static void closeSession(Session session) {

        if (session != null) {

            if (session.isOpen()) {
                session.close();
            }
        }

    }

    //==========================================================================
    synchronized static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    
} // end class