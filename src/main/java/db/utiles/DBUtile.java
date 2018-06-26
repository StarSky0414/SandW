package db.utiles;

import db.po.AddressBookBean;
import db.po.POProvider;
import db.po.UserAddressOptionBean;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;


public class DBUtile {

    @SuppressWarnings("unchecked")
    public static <T> List<T> queryInfoList(String hql){
        Session session = HibernateSession.getSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery(hql);
        List list = query.list();
        transaction.commit();
        return list;
    }

    @SuppressWarnings("unchecked")
    public static <T> List<T> queryInfoList(String hql, Map<String,Object> parmMap){
        Session session = HibernateSession.getSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery(hql);
        for (Map.Entry<String, Object> parameterString : parmMap.entrySet()) {
            query.setParameter(parameterString.getKey(),parameterString.getValue());
        }
        List list = query.list();
        transaction.commit();
        return list;
    }


    public static POProvider saveInfo(POProvider poProvider){
        Session session = HibernateSession.getSession();
        Transaction transaction = session.beginTransaction();
        session.save(poProvider);
        transaction.commit();
        return poProvider;
    }

    public static void upData(String hql, Map<String,Object> parmMap){
        Session session = HibernateSession.getSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery(hql);
        for (Map.Entry<String, Object> parameterString : parmMap.entrySet()) {
            query.setParameter(parameterString.getKey(),parameterString.getValue());
        }
        query.executeUpdate();
        transaction.commit();
    }

    public static   void  upData(Map<String,Object> parmMap,POProvider poProvider) throws IntrospectionException, InvocationTargetException, IllegalAccessException, InstantiationException {
        Session session = HibernateSession.getSession();
        Transaction transaction = session.beginTransaction();
        Field[] declaredFields = poProvider.getClass().getDeclaredFields();
        for (Field field : declaredFields) {
            String name = field.getName();
            PropertyDescriptor propertyDescriptor = new PropertyDescriptor(name, poProvider.getClass());
            Method writeMethod = propertyDescriptor.getWriteMethod();
            if (parmMap.containsKey(name)) {
                System.out.println(parmMap.get(name).getClass().toString());
                writeMethod.invoke(poProvider, parmMap.get(name));
            }
        }
        session.update(poProvider);
        transaction.commit();
//        System.out.println(declaredFields.length);
//        Field f = declaredFields[0];
//        PropertyDescriptor propertyDescriptor = new PropertyDescriptor(f.getName(), poProvider.getClass());
//        Method readMethod = propertyDescriptor.getReadMethod();
//        Integer num = (Integer)readMethod.invoke(poProvider);
//        System.out.println(num);
//        f = declaredFields[2];
//        propertyDescriptor = new PropertyDescriptor(f.getName(), poProvider.getClass());
//        readMethod = propertyDescriptor.getReadMethod();
//        String str = (String) readMethod.invoke(poProvider);
//        System.out.println(str+"------------");
    }

}
