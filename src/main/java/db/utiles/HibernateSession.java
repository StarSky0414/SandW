package db.utiles;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HibernateSession {
    private static SessionFactory sessionFactory;
    private static Logger logger= LoggerFactory.getLogger(HibernateSession.class);

    static {
        createSessionFactory();
    }

    private static void createSessionFactory(){
        try{
            Configuration configure = new Configuration().configure();
            sessionFactory=configure.buildSessionFactory();
        } catch (Throwable throwable){
            logger.error("[****]SessionFaction:{}",throwable.getMessage());
        }
    }

    public static Session getSession(){
        if (sessionFactory==null){
            createSessionFactory();
        }
        Session session = sessionFactory.getCurrentSession();
        return  session;
    }

    public static void closeSession(Session session){
        if (session!=null){
            session.close();
        }
    }

    public static void shutdown (){
        if (sessionFactory!=null){
            sessionFactory.close();
        }
    }
}
