import db.po.UserInfoBean;
import db.utiles.HibernateSession;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class HibernateSessionTest {

    private static Session session;

    @Before
    public void getSession(){
        session = HibernateSession.getSession();
    }

    @Test
    public void dbConnectTest(){
        String hql="from UserInfoBean";
        Query query = session.createQuery(hql);
        List list = query.list();
        UserInfoBean s = (UserInfoBean) list.get(0);
        s.getId();
        HibernateSession.closeSession(session);
    }
}
